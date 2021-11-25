package TP4;

import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import TP3.Polaca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.util.*;
import java.util.HashMap; // import the HashMap class


public class GeneradorASM {

    static List<String> operadoresBinarios = new ArrayList<String>(){
        {
            add("/");
            add("-");
            add("*");
            add("+");
            add("AND");
            add("OR");
            add(":=");
            add(">");

            add("<");
            add(">=");
            add("<=");
        }
    };

    // recorrer la polaca en una pasada y generar instrucciones para luego traducirlo a ASM
    static Stack<Object> pila_variables = new Stack<>();

    static List<InstruccionASM> asm = new ArrayList<>();

    static HashMap<String, String> instrucciones = new HashMap<>();

    static int numeroVar = 0;

    public static void cargarInstrucciones(){
        instrucciones.put("+" ,"ADD");
        instrucciones.put("-" ,"SUB");
        instrucciones.put("*" ,"MUL");
        instrucciones.put("/" ,"DIV");
        instrucciones.put(":=" ,"MOV");
        instrucciones.put(">" ,"CMP");

        instrucciones.put("<" ,"CMP");
        instrucciones.put("<=" ,"CMP");
        instrucciones.put(">=" ,"CMP");

    }

    // Constantes que nos permiten guardar los nombres de los tipos de instrucciones
    public static String EAX = "EAX";
    public static String EBX = "EBX";
    public static String ECX = "ECX";
    public static String EDX = "EDX";


    public static Map<String, Boolean> registros = new HashMap<String, Boolean>();

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

    public static void cargarMapa(){
        registros.put(EAX ,false);
        registros.put(EBX ,false);
        registros.put(ECX ,false);
        registros.put(EDX ,false);
    }

    public static void liberarRegristro(String nombreRegistro){
        registros.put(nombreRegistro, false);
    }

    public static void ocuparRegistro(String nombreRegistro){
        registros.put(nombreRegistro, true);
    }

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

    public static boolean es_conmutativo(Object operador){
        return !operador.equals("/") && !operador.equals("-");
    }

    public static boolean es_variable(String nombre){
        return !registros.containsKey(nombre);
    }

    public static String getTipoInstruccion(Object operador){
        return instrucciones.get((String) operador);
    }

    public static void generarCodigoOperadorBinario(Object operador, Object primerOperando, Object segundoOperando) {
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

    public static boolean es_sentenciaControl(String nombre){
        return nombre.equals("BF") || nombre.equals("BI");
    }

    public static boolean es_etiqueta(String nombre){
        return nombre.startsWith("L");
    }

    public static void generarASM() {

        // se recorre la polaca en una pasada y se genera el ASM
        for (Object valor : Polaca.getRepresentacionIntermedia()) {

            // Si no es un operador

            if (!operadoresBinarios.contains(valor) && !es_sentenciaControl((String) valor) && !es_etiqueta((String) valor)){
                pila_variables.push(valor);
            } else {
                if (operadoresBinarios.contains(valor)) {
                    // Si es un operador binario
                    // desapilo dos elementos y genero el asm correspondiente
                    Object segundoOperando = pila_variables.pop();
                    Object primerOperando = pila_variables.pop();

                    generarCodigoOperadorBinario(valor, primerOperando, segundoOperando); // Actualizando la lista de instrucciones
                } else {

                    // Valores de la polaca utilizados para control
                    if(valor.equals("BF")){
                        // Reconozco un salto por falso, agrego al ASM el chequeo de condicion
                        InstruccionASM instruccionASM = new InstruccionASM("JLE" ,"L" + (String) pila_variables.pop(), "");
                        asm.add(instruccionASM);
                    }else
                        // Reconozco un salto incondicional, agrego al ASM salto
                        if (valor.equals("BI")){
                            InstruccionASM instruccionASM = new InstruccionASM("JMP" ,"L" + (String) pila_variables.pop(), "");
                            asm.add(instruccionASM);
                        }
                        else{
                            if(es_etiqueta((String) valor)){
                                InstruccionASM instruccionASM = new InstruccionASM((String) valor, "", "");
                                asm.add(instruccionASM);
                            }
                        }
                }
            }
        }
    }

    public static List<InstruccionASM> get_asm(){
        return asm;
    }

}
