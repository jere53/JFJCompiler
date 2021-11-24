package TP4;

public class RepresentacionIntermedia {

    // recorrer la polaca en una pasada y generar instrucciones para luego traducirlo a ASM
    static Stack<Object> pila_variables = new Stack<>();

    static List<InstruccionASM> asm = new ArrayList<>();

    static HashMap<String, String> instrucciones = new HashMap<>();

    static void cargarInstrucciones(){
        instrucciones.put("+" ,"ADD");
        instrucciones.put("-" ,"SUB");
        instrucciones.put("*" ,"MUL");
        instrucciones.put("/" ,"DIV");
        instrucciones.put(":=" ,"MOV");
        instrucciones.put(">" ,"CMP");
        /*
        instrucciones.put("<" ,"MOV");
        instrucciones.put("<=" ,"MOV");
        instrucciones.put(">=" ,"MOV");
        */
    }

    // Constantes que nos permiten guardar los nombres de los tipos de instrucciones
    public static String EAX = "EAX";
    public static String EBX = "EBX";
    public static String ECX = "ECX";
    public static String EDX = "EDX";

    // Registros
    public static Map<String, Boolean> registros = new HashMap<String, Boolean>();


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
        // todo controlar el nulo
        for(Map.Entry<String, Boolean> entry : registros.entrySet()) {
            String key = entry.getKey();
            Boolean value = entry.getValue();
            if(value.equals(false)) return key;
        }
        return null;
    }

    public static boolean es_conmutativo(Object operador){
        return !operador.equals("/") && !operador.equals("-"); // todo es conmuitativo?
    }

    public static boolean es_variable(String nombre){
        return !registros.containsKey(nombre);
    }

    public static String getTipoInstruccion(Object operador){
        //  todo agregar tipos de operandos a los parametros

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
            // apilar la nueva instruccion
            pila_variables.add(nombreRegistro); // Agrego el registro para seguir operando
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
                        InstruccionASM instruccionASM = new InstruccionASM(getTipoInstruccion(operador), (String) segundoOperando, (String) primerOperando);

                        asm.add(instruccionASM);
                        pila_variables.push(segundoOperando);

                    } else {
                        // Ocupo nuevo registro
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

    public static void generarASM(List<String> polaca) {

        // se recorre la polaca en una pasada y se genera el ASM

        for (Object valor : polaca) {
        //for (Object valor : Polaca.getRepresentacionIntermedia()) {
            // Si no es un operador


            if (!operadoresBinarios.contains(valor)){
                pila_variables.push(valor);
            } else {
                if (operadoresBinarios.contains(valor)) {
                    System.out.println("op binario: " + valor);
                    // Si es un operador binario
                    // desapilo dos elementos y genero el asm correspondiente
                    Object segundoOperando = pila_variables.pop();
                    Object primerOperando = pila_variables.pop();
                    System.out.println("primerOperando: " + primerOperando);
                    System.out.println("segundoOperando: " + segundoOperando);
                    generarCodigoOperadorBinario(valor, primerOperando, segundoOperando); // Actualizando la lista de instrucciones
                } else {

                    // Valores de la polaca utilizados para control
                    if(valor.equals("BF")){
                        // Reconozco un salto por falso, agrego al ASM el chequeo de condicion y el salto en funcion del flag del procesador?????????????????????????
                        InstruccionASM instruccionASM = new InstruccionASM("JLE" ,"L" + (String)pila_variables.pop(), "");
                        asm.add(instruccionASM);
                    }else
                        // Reconozco un salto incondicional, agrego al ASM salto + POS
                        if (valor.equals("BI")){
                            InstruccionASM instruccionASM = new InstruccionASM("JMP" ,"L" + (String)pila_variables.pop(), "");
                            asm.add(instruccionASM);
                        }
                }
            }
        }
    }

    public static void main(String[] args) {

        //a b - c 1 + > 17 BF a b c + := 23 BI L17 a b c - := L23
        List<String> polaca1 = new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("-");
                add("c");
                add("1");
                add("+");
                add(">");
                add("17");
                add("BF");
                add("a");
                add("b");
                add("c");
                add("+");
                add(":=");
                add("23");
                add("BI");
                add("L17");
                add("a");
                add("b");
                add("c");
                add("-");
                add(":=");
                add("L23");
            }
        };




        List<String> polaca = new ArrayList<String>(){
            {
                add("z");
                add("a");
                add("b");
                add("c");
                add("*");
                add("+");
                add("d");
                add("e");
                add("f");
                add("+");
                add("/");
                add("-");
                add("20");
                add("+");
                add(":=");
            }
        };

        GeneradorASM.cargarInstrucciones();
        GeneradorASM.cargarMapa();
        GeneradorASM.generarASM(polaca1);



        for(InstruccionASM inst : GeneradorASM.asm){
            System.out.println(inst);
        }
    }
}
