package TP4;

import Dev.Lexico.AnalizadorLexico;
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
    private static final String outputFilePath = "salidaASM.asm";

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
        //Si e es un RegistroTS es un operando, a menos que sea el nombre de una funcion, en cuyo caso
        //se usa para conocer saltos y no es un operando
        if (e instanceof RegistroTS){
            if (((RegistroTS)e).getUso()!=null){
                if (((RegistroTS)e).getUso().equals("nombre_funcion")){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public static boolean es_marca(Object e){
        return e.equals("-----------FinDeclaraciones-----------")
                || e.equals("FuncStartLabel") || e.equals("FillReturnReg") || e.equals("Quit")
                || e.equals("END_PROGRAM") || e.equals("CALL") || e.equals("RETURN");
    }

    // El metoddo generar asm se encarga de evaluar y trabajar sobre cada elemento de la lista de la polaca
    // En La forma de reconocer que tipo de elemento se esta hablando es seguin el naming del mismo
    public static void generarASM() {

        List<RegistroTS> agregados = new ArrayList<>();
        for(RegistroTS r : TablaSimbolos.getTabla().values()){
            if(r.getUso() == null) continue;
            if (r.getUso().equals("nombre_funcion")){
                //creamos la variable que tendra el retorno de la funcion
                RegistroTS nuevo = new RegistroTS("@auxL" + (r.getComienzoCodigoEjecutable()+1));
                nuevo.setUso("variable");
                nuevo.setTipo(r.getTipo());
                agregados.add(nuevo);
            }
        }
        for(RegistroTS r : agregados)
            TablaSimbolos.getTabla().put(r.getLexema(), r);

        List<Object> repIntermedia = Polaca.getRepresentacionIntermedia();
        asm = "";
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

                if(repIntermedia.get(i-1).equals("FuncStartLabel")){
                    asm += "MOV _funcionActual, " + currentFuncLabel.substring(1) + '\n'; //sin la 'L'
                }
                continue;
            }


            // En caso de ser una sentencia de control y avanzamos al siguiente elemento
            if (es_marca(elem)){
                switch (elem.toString()){
                    case "-----------FinDeclaraciones-----------":
                       asm += "START: " + '\n';
                       continue;

                    case "FuncStartLabel":
                        currentFuncLabel = repIntermedia.get(i+1).toString();
                        continue;

                    case "FillReturnReg" :
                        //en el tope de la pila esta la variable auxiliar que contiene el resultado de la expresion del
                        //retorno

                        //En la pila de variables tenemos el resultado de la ultima expresion de la funcion (el retorno)
                        //entonces hay que generar una asignacion a nuestra variable de retorno. Para eso metemos la variable
                        //de retorno en la pila y generamos la asig.


                        pila_variables.push(TablaSimbolos.punteroTS("@aux" + currentFuncLabel));
                        asm += GeneradorAsignacion.getASM();
                        /*
                        asm += "MOV " + "@aux" + currentFuncLabel + ", " + prefijo + ((RegistroTS)pila_variables.pop()).getLexema() + '\n';
                        TablaSimbolos.altaTS("@aux" + currentFuncLabel);
                        TablaSimbolos.punteroTS("@aux" + currentFuncLabel).setUso("variable");
                        TablaSimbolos.punteroTS("@aux" + currentFuncLabel).setTipo(String.valueOf(Parser.UINT));

                         */
                        continue;

                    case "Quit" :
                        // Generamos instruccion que mate el programa
                        asm += "invoke ExitProcess, 0" + '\n';
                        continue;

                    case "END_PROGRAM" :
                        // Agregamos tag de END
                        asm += "END" + " START" + '\n';
                        continue;

                    case "CALL":
                       // Saltamos a la direccion de la etiqueta siquiente
                       //Control recursion mutua
                       //en funcionAInvocar tenemos a donde saltamos. En funcionAnterior de donde venimos
                       //si son iguales, hay recursion mutua. Si no lo son, actualizamos la anterior con la actual
                       asm +=  "MOV _funcionAInvocar, " + String.valueOf(((RegistroTS)repIntermedia.get(i-1)).getComienzoCodigoEjecutable()+1)+ '\n' +
                               "MOV AX, " + "_funcionAnterior" + '\n' +
                               "CMP AX, " + "_funcionAInvocar" + '\n' +
                               "JZ ErrInvocacionMutua" + '\n' +
                               "MOV AX, _funcionActual" + '\n' +
                               "MOV _funcionAnterior, AX" + '\n';

                       asm += "CALL" + " L" + (((RegistroTS)repIntermedia.get(i-1)).getComienzoCodigoEjecutable()+1) + '\n';
                       pila_variables.push(TablaSimbolos.punteroTS("@auxL" + (((RegistroTS)repIntermedia.get(i-1)).getComienzoCodigoEjecutable()+1)));
                       if (TablaSimbolos.punteroTS("@auxL" + (((RegistroTS)repIntermedia.get(i-1)).getComienzoCodigoEjecutable()+1)) == null){
                           System.out.println((((RegistroTS)repIntermedia.get(i-1)).getComienzoCodigoEjecutable()+1));

                           System.out.println("Se agrego null en CALL" );
                       }
                       continue;

                    case "RETURN":
                        asm += "MOV _funcionActual, 0 \n" + "RET" + '\n' ; //ya no estamos en ninguna funcion.
                        continue;
                }
                continue;
            }

            if (es_control(elem)){
                if (elem.equals("BI")){
                    asm += "JMP " + "L" + repIntermedia.get(i-1) + '\n';
                }

                if (elem.equals("BF")){
                    //Si leemos un BF, significa que la ultima variable en la pila debe contener el resultado de una expresion booleana.
                    //Por como esta armado el compilador, ese resultado es 1 si la condicion es verdadera, y 0 si no lo es.
                    asm += "CMP " + ((RegistroTS) pila_variables.pop()).getLexema() + ", 0" + '\n'+
                        "JZ " + "L"+ repIntermedia.get(i-1) + '\n'; //Si el resultado es falso (ZeroFlag = 1) entonces saltamos a la etiqueta de la rama por falso.
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
                asm += "invoke MessageBox, NULL, addr _" + ((RegistroTS)repIntermedia.get(i+1)).getLexema().replaceAll("\\s+","")
                        + ",addr _" + ((RegistroTS)repIntermedia.get(i+1)).getLexema().replaceAll("\\s+","") + ", MB_OK" + '\n';
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
                case ((int) Parser.AND) :
                    asm = asm + '\n' + GeneradorAnd.getASM();
                    continue;
                case ((int) Parser.OR) :
                    asm = asm + '\n' + GeneradorOr.getASM();
                    continue;
                case ((int) Parser.ASIG) :
                    asm = asm + '\n' + GeneradorAsignacion.getASM();
                    continue;
                case ((int) '>') :
                    asm += '\n' + GeneradorComparacion.getASM("May");
                    continue;
                case ((int) Parser.COMP_DISTINTO) :
                    asm += '\n' + GeneradorComparacion.getASM("Dist");
                    continue;
                case ((int) '<') :
                    asm += '\n' + GeneradorComparacion.getASM("Men");
                    continue;
                case ((int) Parser.COMP_MAYOR_IGUAL) :
                    asm += '\n' + GeneradorComparacion.getASM("MayI");
                    continue;
                case ((int) Parser.COMP_MENOR_IGUAL) :
                    asm += '\n' + GeneradorComparacion.getASM("MenI");
                    continue;
                case ((int) Parser.COMP_IGUAL) :
                    asm += '\n' + GeneradorComparacion.getASM("Ig");
                    continue;
            }

        }

        String asm_copy = asm;
        asm =   ".386 \n" + ".model flat, stdcall \n" + '\n' + ".stack 200h" + '\n' +
                "option casemap :none \n" +
                "include \\masm32\\include\\windows.inc\n" +
                "include \\masm32\\include\\kernel32.inc\n" +
                "include \\masm32\\include\\user32.inc\n" +
                "includelib \\masm32\\lib\\kernel32.lib\n" +
                "includelib \\masm32\\lib\\user32.lib\n"+
                ".DATA" + '\n' + "_funcionActual DW ? \n _funcionAInvocar DW ? \n _funcionAnterior DW ? \n";

        for (RegistroTS r: TablaSimbolos.getTabla().values()) {
            if (r.getTipo() == null) continue;
            if(r.getTipo().equals("cadena_caracteres")){
                //quitamos los espacios en el nombre de la variable.
                asm += "_" +r.getLexema().replaceAll("\\s+", "") +" DB " + "\""+r.getLexema()+"\"" +", 0" + '\n';
                continue;
            }
            if(!(r.getUso().equals("variable") || r.getUso().equals("cte") || r.getUso().equals("parametro") || r.getUso().equals("asm_control"))) continue;
            try{
                String prefijo = "";
                if (!r.getLexema().startsWith("@")){
                    prefijo = "_";
                }
                if (r.getTipo().equals("asm_bool")){ //siempre es unav variable auxiliar, empieza con @
                    asm += r.getLexema() + " DW " + "?" + '\n';
                    continue;
                }
                int tipo = Integer.parseInt(r.getTipo());
                switch (tipo){
                    case Parser.UINT :
                        asm += prefijo + r.getLexema()  + " DW " + "?" + '\n';
                        continue;
                    case Parser.DOUBLE:
                        asm += prefijo + r.getLexema() + " DQ " + "?" + '\n';
                        continue;
                    case Parser.CTE_UINT:
                        if (r.getUso().equals("variable")){
                            asm += prefijo + r.getLexema()  + " DW " + "?" + '\n';
                            continue;
                        }
                        asm += "var" + r.getLexema()+ " DW " + r.getLexema() + '\n';
                        continue;
                    case Parser.CTE_DOUBLE:
                        if (r.getUso().equals("variable")){
                            asm += prefijo + r.getLexema() + " DQ " + "?" + '\n';
                            continue;
                        }
                        asm += "var" + r.getLexema().replaceAll("[-+\\.]", "")+ " DQ " + r.getLexema() + '\n';
                }
            } catch (NumberFormatException e){
                e.printStackTrace();
                continue;
            }
        }
        asm += "_ErrDivZero DB " + " \"Division por 0\", 0" + '\n' +
            "_ErrOFSuma DB " + "\"Overflow en suma de enteros\", 0 \n"+
            "_ErrIncompTipos DB " + "\"No se puede realizar la conversion de tipos\", 0 \n" +
            "_ErrRecursionMutua DB " + " \"Recursion Mutua detectada\", 0 \n";

        asm = asm + '\n' + ".CODE" + '\n';

        asm += '\n' + "DivZero: " + '\n' + "invoke MessageBox, NULL, addr _ErrDivZero, addr _ErrDivZero, MB_OK \n" + "invoke ExitProcess, 0 \n"
                + "OFSuma: \n" + "invoke MessageBox, NULL, addr _ErrOFSuma, addr _ErrOFSuma, MB_OK \n" + "invoke ExitProcess, 0 \n"
                + "IncompTipos: \n" + "invoke MessageBox, NULL, addr _ErrIncompTipos, addr _ErrIncompTipos, MB_OK \n" + "invoke ExitProcess, 0 \n"
                + "ErrInvocacionMutua: \n" + "invoke MessageBox, NULL, addr _ErrRecursionMutua, addr _ErrRecursionMutua, MB_OK \n" + "invoke ExitProcess, 0 \n";

        asm += asm_copy;
    }

    // Este metodo nos permite mostrar de manera legible el codigo ASM generado
    public static String get_asm(){
        return asm;
    }

}
