package TP3;

import java.util.ArrayList;
import Dev.RegistroTS;
import java.util.List;
import java.util.Stack;

public class Polaca {

    /*
     * La lista contiene los punteros a TS y el indice esta dado por la propia ArrayList
     */
    private static final List<Object> representacionIntermedia = new ArrayList<>();
    private static final Stack<Object> pila = new Stack<>(); //TODO , cambiar nombre a criterio de jere

    public Polaca(){

    }

    public static void insert(Object o){
        representacionIntermedia.add(o);
    } // TODO, por que object y no Integer

    public static void insert_sentencia_control_cond(){
        pila.add(representacionIntermedia.size()); // Agrego el index

        representacionIntermedia.add(new Object());
        representacionIntermedia.add(new String("BF"));
    }

    public static void insert_sentencia_control_then(){
        int index = (int) pila.pop();
        representacionIntermedia.add(index,  representacionIntermedia.size() + 1);

        pila.add(representacionIntermedia.size()); // Agrego el index
        representacionIntermedia.add(new Object());
        representacionIntermedia.add(new String("BI"));
    }

    public static void insert_sentencia_control_else(){
        if(!pila.empty()){
            int index = (int) pila.pop();
            representacionIntermedia.add(index,  representacionIntermedia.size() + 1);
        }
        pila.add(representacionIntermedia.size());
        representacionIntermedia.add(new Object());
        representacionIntermedia.add(new String("BF"));
    }

    public static void removerUltimo(){
        int index = representacionIntermedia.size() - 1;
        representacionIntermedia.remove(index);
    }

    public static String imprimirPolaca() {
        return "Polaca{" + representacionIntermedia.toString() + "}";
    }
}
