package TP4;

import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP3.Polaca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
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

            add((int) '<');
            add((int) Parser.COMP_MAYOR_IGUAL);
            add((int) Parser.COMP_MENOR_IGUAL);
        }
    };

    // recorrer la polaca en una pasada y generar instrucciones para luego traducirlo a ASM
    static Stack<Object> pila_variables = new Stack<>();

    static List<InstruccionASM> asm = new ArrayList<>();

    static HashMap<Integer, String> instrucciones = new HashMap<>();

    static int numeroVar = 0;

    // Generamos un metodo para cargar los valores iniciales del hashmap de instrucciones
    // Este metodo se encarga de buscar la equivalentecias entre operadores e instrucciones
    public static void cargarInstrucciones(){
        instrucciones.put((int) '+' ,"ADD");
        instrucciones.put((int) '-' ,"SUB");
        instrucciones.put((int) '*' ,"MUL");
        instrucciones.put((int) '/' ,"DIV");
        instrucciones.put((int) Parser.ASIG ,"MOV");
        instrucciones.put((int) '>' ,"CMP");

        instrucciones.put((int) '<' ,"CMP");
        instrucciones.put((int) Parser.COMP_MENOR_IGUAL ,"CMP");
        instrucciones.put((int) Parser.COMP_MAYOR_IGUAL ,"CMP");

    }

    // Constantes que nos permiten guardar los nombres de los tipos de instrucciones
    public static String EAX = "EAX";
    public static String EBX = "EBX";
    public static String ECX = "ECX";
    public static String EDX = "EDX";

    // Mapa con los registros disponibles, almacenamos un booleano en el value para conocer el estado actual del registro
    public static Map<String, Boolean> registros = new HashMap<String, Boolean>();

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

    // Cargamos los registros por defecto del mapa de registros
    public static void cargarMapa(){
        registros.put(EAX ,false);
        registros.put(EBX ,false);
        registros.put(ECX ,false);
        registros.put(EDX ,false);
    }

    // Este metodo se encarga de liberar uno de los cuatro registros reservador
    public static void liberarRegristro(String nombreRegistro){
        registros.put(nombreRegistro, false);
    }

    // Este metodo se encarga de ocupar determinado registro
    public static void ocuparRegistro(String nombreRegistro){
        registros.put(nombreRegistro, true);
    }

    // Este metodo se encarga de obtener el primer registro libre de los cuatro utilizabales
    public static String getRegistroLibre(){
        for(Map.Entry<String, Boolean> entry : registros.entrySet()) {
            String key = entry.getKey();
            Boolean value = entry.getValue();
            if(value.equals(false)) return key;
        }

        // En caso que no se encuentre un registro libre debemos generar una variable auxiliar
        String nombre = "@aux" + Integer.toString(numeroVar);
        numeroVar++; // Actualizamos la variable numeroVar para ir generando un identificador incremental de la variable auxiliar
        TablaSimbolos.altaTS(nombre);
        return nombre;
    }

    // Este metodo se encarga de retornar si un operador es conmutativo o no
    public static boolean es_conmutativo(Object operador){
        return !operador.equals("/") && !operador.equals("-");
    }

    // Este metodo se encarga de reportar si un nombre corresponde a una variable o no
    // Un nombre podria corresponder a una variable si no tiene nombre de registro
    public static boolean es_variable(String nombre){
        return !registros.containsKey(nombre);
    }

    // Este metodo se encarga de obtener el tipo de instruccion segun el operador. Exploara el mapa de <Operador,Instruccion>
    public static String getTipoInstruccion(Object operador){
        return instrucciones.get(operador);
    }

    // Este metodo se encarga de generar el codigo de operador binario. Evalua los distintos tipos de operaciones que se pueden realizar
    // En funcion de los operadores que se usan ya sean registros o variables.
    public static void generarCodigoOperadorBinario(Object operador, Object primerOperando, Object segundoOperando) {

        // Planteo de casos posibles

        // sit 1 : var, var --> 1 reg
        // sit 2 :reg, var --> OP R1, var
        // sit 3 : reg1, reg2 --> OP reg1, reg2
        // sit 4:
        // si es conmutativo --> var, reg1 --> reg1, var
        // si no es conm.    --> ocupo nuevo reg
        if (es_variable(primerOperando.toString()) && es_variable(segundoOperando.toString())) {
            // Situacion 1
            String nombreRegistro = getRegistroLibre();
            ocuparRegistro(nombreRegistro);
            InstruccionASM instruccionASM = new InstruccionASM("MOV", nombreRegistro, "@" + primerOperando);
            InstruccionASM instruccionASM_2 = new InstruccionASM(getTipoInstruccion(operador), nombreRegistro, "@" + segundoOperando);
            asm.add(instruccionASM);    // Agrego las instrucciones asm a la lista
            asm.add(instruccionASM_2); // Agrego las instrucciones asm a la lista
            pila_variables.add(nombreRegistro); // Agrego el registro para seguir operando con el
        } else {
            if (!es_variable(primerOperando.toString()) && es_variable(segundoOperando.toString())) {
                // Situacion 2
                InstruccionASM instruccionASM = new InstruccionASM(getTipoInstruccion(operador), (String) primerOperando, "@" + segundoOperando);
                asm.add(instruccionASM);
                pila_variables.push(primerOperando);
            } else {
                if (!es_variable(primerOperando.toString()) && !es_variable(segundoOperando.toString())) {
                    // Situacion 3
                    InstruccionASM instruccionASM = new InstruccionASM(getTipoInstruccion(operador), (String) primerOperando, (String) segundoOperando);
                    liberarRegristro((String) segundoOperando);
                    asm.add(instruccionASM);
                    pila_variables.push(primerOperando);
                } else {
                    // Situacion 4
                    if (es_conmutativo(operador)) {
                        // Se invierten los operandos
                        InstruccionASM instruccionASM = new InstruccionASM(getTipoInstruccion(operador), (String) segundoOperando,"@" + (String) primerOperando);

                        asm.add(instruccionASM);
                        pila_variables.push(segundoOperando);

                    } else {
                        // Ocupo nuevo registro con el resultado de la operacion
                        String nombreRegistro = getRegistroLibre();
                        InstruccionASM instruccionASM = new InstruccionASM("MOV", nombreRegistro, "@" + primerOperando);
                        InstruccionASM instruccionASM_2 = new InstruccionASM(getTipoInstruccion(operador), (String) nombreRegistro, (String) segundoOperando);
                        asm.add(instruccionASM);
                        asm.add(instruccionASM_2);
                        liberarRegristro((String) segundoOperando);
                        pila_variables.push(nombreRegistro);
                    }
                }
            }
        }
    }

    // Una sentencia de control son los valores de la lista de la polaca que denotan saltos tanto condicionales como incondicionales
    public static boolean es_sentenciaControl(Object nombre){
        return nombre.equals("BF") || nombre.equals("BI");
    }

    // Por convencion, un valor es etiqueta si comienza con L. Por ejemplo L17 , L25
    public static boolean es_etiqueta(Object nombre){
        if(nombre instanceof java.lang.String){
            return nombre.toString().startsWith("L");
        }
        return false;
    }

    // El metoddo generar asm se encarga de evaluar y trabajar sobre cada elemento de la lista de la polaca
    // En La forma de reconocer que tipo de elemento se esta hablando es seguin el naming del mismo
    public static void generarASM() {

        // se recorre la polaca en una pasada y se genera el ASM
        for (Object valor : Polaca.getRepresentacionIntermedia()) {

            // Si no es un operador

            if (!operadoresBinarios.contains(valor) && !es_sentenciaControl(valor) && !es_etiqueta(valor)){
                pila_variables.push(valor);
            } else {
                if (operadoresBinarios.contains(valor)) {
                    // Si es un operador binario
                    // desapilo dos elementos y genero el asm correspondiente
                    //Aca siempre van a ser Registros!
                    Object segundoOperando = pila_variables.pop();
                    Object primerOperando = pila_variables.pop();
                    //Si llegamos aca y son string, significa que son placeholders, como "Retorno" y "Print"
                    if(segundoOperando instanceof java.lang.String){
                       continue;
                    }
                    if(primerOperando instanceof java.lang.String){
                        continue;
                    }

                    generarCodigoOperadorBinario(valor, ((RegistroTS)primerOperando).getLexema(), ((RegistroTS)segundoOperando).getLexema()); // Actualizando la lista de instrucciones
                } else {

                    // Valores de la polaca utilizados para control
                    if(valor.equals("BF")){
                        // Reconozco un salto por falso, agrego al ASM el chequeo de condicion
                        //Pila_Variables.pop() siempre va a ser un entero porque antes de un BF o BI siempre hay un entero.
                        InstruccionASM instruccionASM = new InstruccionASM("JLE" ,"L" + pila_variables.pop().toString(), "");
                        asm.add(instruccionASM);
                    }else
                        // Reconozco un salto incondicional, agrego al ASM salto
                        if (valor.equals("BI")){
                            InstruccionASM instruccionASM = new InstruccionASM("JMP" ,"L" + pila_variables.pop().toString(), "");
                            asm.add(instruccionASM);
                        }
                        else{
                            if(es_etiqueta(valor)){
                                InstruccionASM instruccionASM = new InstruccionASM((String) valor, "", "");
                                asm.add(instruccionASM);
                            }
                        }
                }
            }
        }
    }

    // Este metodo nos permite mostrar de manera legible el codigo ASM generado
    public static String get_asm(){

        StringBuilder res = new StringBuilder();
        int i = 0;
        for(InstruccionASM instruccionASM : asm){
            res.append(i).append("  ").append(instruccionASM.toString()).append("\n");
            i++;
        }
        return res.toString();
    }

}
