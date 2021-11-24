package TP3;

import Dev.RegistroTS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ambito {
    private static final Stack<String> ambito_stack = new Stack<>();
    private static final List<RegistroTS> lista_referencias = new ArrayList<RegistroTS>();

   public Ambito() {
       ambito_stack.add(":main");
   }

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

    public static void setAmbito(String ambito){

        agregarAmbito(ambito); //D:C:B:A

        for (RegistroTS registro: lista_referencias) {
            registro.setAmbito(retornarNaming() + ambito);
        }


    }
}
