package TP3;

import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ambito {
    private static Stack<String> ambito_stack = new Stack<String>() {};
    private static final List<RegistroTS> lista_referencias = new ArrayList<RegistroTS>();

    public static void agregarAmbito(String ambito){
        ambito_stack.add(ambito);
    }

    public static void borrarAmbito(){
        ambito_stack.pop();
    }

    public static String retornarNaming(){
        StringBuilder res = new StringBuilder();

        for ( String ambito: ambito_stack) {
            res.append(":").append(ambito);
        }
        return res.toString();
    }

    public static void agregarVariable(RegistroTS variable){
       lista_referencias.add(variable);
    }

    public static String bindAmbito(String lexema){
        Stack<String> copia = (Stack<String>) ambito_stack.clone();

        while(!ambito_stack.empty()){
            String res = lexema + retornarNaming();
            if (TablaSimbolos.perteneceTS(res)) {
                TablaSimbolos.removePuntero(lexema);
                ambito_stack = copia;
                return res;
            }
            ambito_stack.pop();
        }
        ambito_stack = copia;
        AnalizadorLexico.errores.add("variable " + lexema + " no declarada, linea: " + AnalizadorLexico.nroLinea);
        return null;
    }
}
