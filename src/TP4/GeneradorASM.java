package TP4;

import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP3.Polaca;
import TP4.Generadores.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;


public class GeneradorASM {

    // Guardamos el codigo ASCII de los operadores binarios
    static List<Integer> operadoresBinarios = new ArrayList<Integer>(){
        {
            add((int) '/');
            add((int) '-');
            add((int) '*');
            add((int) '+');
            add((int) Parser.AND);
            add((int) Parser.OR);
            add((int) Parser.ASIG);
            add((int) '>');
            add((int) Parser.COMP_DISTINTO);
            add((int) '<');
            add((int) Parser.COMP_MAYOR_IGUAL);
            add((int) Parser.COMP_MENOR_IGUAL);
            add((int) Parser.COMP_IGUAL);
        }
    };

    // recorrer la polaca en una pasada y generar instrucciones para luego traducirlo a ASM
    public static Stack<Object> pila_variables = new Stack<>();

    static String asm = "";

    // Contador de referencia para variables auxiliares
    public static int numeroVar = 0;

    // Constantes que nos permiten guardar los nombres de los tipos de instrucciones
    public static String EAX = "EAX";
    public static String EBX = "EBX";
    public static String ECX = "ECX";
    public static String EDX = "EDX";

    // Determinamos el nombre del archivo de salida de ASM
    private static final String outputFilePath = "salidaASM.txt";

    public static FileWriter outputWriter;

    public static void inic(){
        try {
            File file = new File(outputFilePath);
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
            outputWriter = new FileWriter(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Por convencion, un valor es etiqueta si comienza con L. Por ejemplo L17 , L25
    public static boolean es_etiqueta(Object nombre){
        if(nombre instanceof java.lang.String){
            return nombre.toString().startsWith("L");
        }
        return false;
    }

    public static boolean es_control(Object e){
        return e.equals("BI") || e.equals("BF");
    }

    // Sabemos que es un operando porque pertenece a la tabla de simbolos
    public static boolean es_operando(Object e){
        return e instanceof RegistroTS;
    }

    public static boolean es_marca(Object e){
        return e.equals("-----------FinDeclaraciones-----------")
                || e.equals("FuncStartLabel") || e.equals("FillReturnReg") || e.equals("Quit")
                || e.equals("END_PROGRAM") || e.equals("CALL") || e.equals("RETURN");
    }

    static String  ultimoComp="";

    // El metoddo generar asm se encarga de evaluar y trabajar sobre cada elemento de la lista de la polaca
    // En La forma de reconocer que tipo de elemento se esta hablando es seguin el naming del mismo
    public static void generarASM() {

        List<Object> repIntermedia = Polaca.getRepresentacionIntermedia();
        asm = "START: " + '\n';
        String currentFuncLabel = "";
        for (int i = 0; i < repIntermedia.size(); i++) {

            //System.out.println("Indice : " + i + " ---- " + "cant: " + pila_variables.size());
            // Capturo el elemento actual
            Object elem = repIntermedia.get(i);

            // En caso de que sea un operando, apilamos y avanzamos al siguiente elemento
            if (es_operando(elem)){
                //si es una cadena de caracteres, no se mete en la pila
                if (((RegistroTS) elem).getTipo().equals("cadena_caracteres")) continue;
                pila_variables.push(elem);
                continue;
            }

            // En caso de ser una etiqueta, generamos directamente el asm corrspondiente y avanzamos al siguiente elemento
            if (es_etiqueta(elem)){
                asm += elem.toString() + ":"+ '\n';
                continue;
            }


            // En caso de ser una sentencia de control y avanzamos al siguiente elemento
            if (es_marca(elem)){
                switch (elem.toString()){
                    case "FuncStartLabel":
                        currentFuncLabel = repIntermedia.get(i+1).toString();
                        continue;

                    case "FillReturnReg" :
                        //en el tope de la pila esta la variable auxiliar que contiene el resultado de la expresion del
                        //retorno
                        // Generamos variable auxiliar usada para retorno de funcion, se debe apilar en la pila de variable
                        asm += "MOV " + "@aux" + currentFuncLabel + ", _" + ((RegistroTS)pila_variables.pop()).getLexema() + '\n';
                        TablaSimbolos.altaTS("@aux" + currentFuncLabel);
                        TablaSimbolos.punteroTS("@aux" + currentFuncLabel).setUso("variable");
                        TablaSimbolos.punteroTS("@aux" + currentFuncLabel).setTipo("UINT"); //TODO Cambiar
                        continue;

                    case "Quit" :
                        // Generamos instruccion que mate el programa
                        asm += "END" + '\n'; // todo : generar la instruccion ASM para cerrar el programa
                        continue;

                    case "END_PROGRAM" :
                        // Agregamos tag de END
                        asm += "END" + " START" + '\n';
                        continue;

                    case "CALL":
                        // Saltamos a la direccion de la etiqueta siquiente
                        asm += "CALL" + " L" + repIntermedia.get(i-1) + '\n';
                        pila_variables.push(TablaSimbolos.punteroTS("@auxL" + repIntermedia.get(i-1)));
                        if (TablaSimbolos.punteroTS("@auxL" + repIntermedia.get(i-1)) == null){
                            //System.out.println("Se agrego null en CALL" );
                        }
                        continue;

                    case "RETURN":
                        asm += "RET" + '\n';
                        continue;
                }
                continue;
            }

            if (es_control(elem)){
                if (elem.equals("BI")){
                    asm += "JMP " + "L" + repIntermedia.get(i-1) + '\n';
                }

                if (elem.equals("BF")){

                    asm += GeneradorComparacion.getASM(ultimoComp, i) + '\n';
                }

                continue;
            }

            //si el siguiente elemento es un BI o un BF, es un indice y debe ser ignorado. Se utilizara este indice en la siguiente iteracion
            if (i < repIntermedia.size() - 1 && (es_control(repIntermedia.get(i+1)) || repIntermedia.get(i+1).equals("CALL"))){
                continue;
            }

            // Si llegamos aca, es un operador (que siempre es un int). En funcion el tipo de operador el comporamiento es distinto
            String asm_generado = "";

            // En caso que se invoque al operador unario PRINT
            if(elem.equals("PRINT")){
                //print el proximo registro TS
                asm += "Print " + '\n' + ((RegistroTS)repIntermedia.get(i+1)).getLexema() + '\n';
                continue;
            }

            switch((int) elem){
                case ((int) '/') :
                    asm = asm + '\n' + GeneradorDivision.getASM();
                    continue;
                case ((int) '-') :
                    asm = asm + '\n' + GeneradorResta.getASM();
                    continue;
                case ((int) '*') :
                    asm = asm + '\n' + GeneradorMultiplicacion.getASM();
                    continue;
                case ((int) '+') :
                    asm = asm + '\n' + GeneradorSuma.getASM();
                    continue;
                    /*
                case ((int) Parser.AND) :
                    asm = asm + '\n' + GeneradorComparacion.getASM();
                    continue;
                case ((int) Parser.OR) :
                    asm = asm + '\n' + GeneradorComparacion.getASM();
                    continue;
                    */
                case ((int) Parser.ASIG) :
                    asm = asm + '\n' + GeneradorAsignacion.getASM();
                    continue;
                case ((int) '>') :
                    ultimoComp = "May";
                    continue;
                case ((int) Parser.COMP_DISTINTO) :
                    ultimoComp = "Dist";
                    continue;
                case ((int) '<') :
                    ultimoComp = "Men";
                    continue;
                case ((int) Parser.COMP_MAYOR_IGUAL) :
                    ultimoComp = "MayI";
                    continue;
                case ((int) Parser.COMP_MENOR_IGUAL) :
                    ultimoComp = "MenI";
                    continue;
                case ((int) Parser.COMP_IGUAL) :
                    ultimoComp = "Ig";
                    continue;
            }

        }

        asm += '\n' + "TratarDivisionPorZero: " + '\n' + "Print Error" + '\n' + "END";

        String asm_copy = asm;
        asm = ".MODEL SMALL" + '\n' + ".STACK 200h" + '\n' + ".DATA" + '\n';
        for (RegistroTS r: TablaSimbolos.getTabla().values()) {
            if (r.getTipo() == null) continue;
            if(!(r.getUso().equals("variable") || r.getUso().equals("cte") || r.getUso().equals("parametro"))) continue;
            try{
                int tipo = Integer.parseInt(r.getTipo());
                switch (tipo){
                    case Parser.UINT :
                        asm += "DW " + "_" + r.getLexema() + '\n';
                        continue;
                    case Parser.DOUBLE:
                        asm += "DD " + "_" + r.getLexema() + '\n';
                        continue;
                }
            } catch (NumberFormatException e){
                continue;
            }
        }
        asm = asm + '\n' + ".CODE" + '\n' +  asm_copy;
    }

    // Este metodo nos permite mostrar de manera legible el codigo ASM generado
    public static String get_asm(){
        return asm;
    }

}
