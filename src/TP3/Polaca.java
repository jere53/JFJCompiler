package TP3;

import java.util.ArrayList;
import Dev.RegistroTS;
import java.util.List;

public class Polaca {

    /**
     * La lista contiene los punteros a TS y el indice esta dado por la propia ArrayList
     */
    private static final List<RegistroTS> representacionIntermedia = new ArrayList<>();

    public Polaca(){

    }

    public static void insert(RegistroTS punteroATS){
        representacionIntermedia.add(punteroATS);
    }

    public static void removerUltimo(){
        int index = representacionIntermedia.size() - 1;
        representacionIntermedia.remove(index);
    }

}
