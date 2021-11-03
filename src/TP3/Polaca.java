package TP3;

import java.util.ArrayList;
import Dev.RegistroTS;
import java.util.List;

public class Polaca {

    /*
     * La lista contiene los punteros a TS y el indice esta dado por la propia ArrayList
     */
    private static final List<Object> representacionIntermedia = new ArrayList<>();

    public Polaca(){

    }

    public static void insert(Object o){
        representacionIntermedia.add(o);
    }

    public static void removerUltimo(){
        int index = representacionIntermedia.size() - 1;
        representacionIntermedia.remove(index);
    }

    public static String imprimirPolaca() {
        return "Polaca{" + representacionIntermedia.toString() + "}";
    }
}
