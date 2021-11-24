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
    private static final Stack<Integer> pila_seleccion = new Stack<>(); //TODO , cambiar nombre a criterio de jere
    private static final Stack<Integer> pila_iteracion = new Stack<>(); //TODO , cambiar nombre a criterio de juan y felix

    public Polaca(){

    }

    public static void insert(Object o){
        representacionIntermedia.add(o);
    } // TODO, por que object y no Integer

    public static void insert_sentencia_control_cond(){
        pila_seleccion.add(representacionIntermedia.size()); // Agrego el index

        representacionIntermedia.add(new Object());
        representacionIntermedia.add("BF");
    }

    public static void insert_sentencia_control_then() {
        int index = (int) pila_seleccion.pop();
        //add hace un corrimiento, hay que cambiar el valor del objeto que se dejo vacio, por eso se usa set.
        //representacionIntermedia.add(index,  representacionIntermedia.size() + 1);
        //+2, 1 para el objeto vacio y otro para el BI. en size() va el objeto vacio, y en size()+1 el BI, si la condicion es
        //falsa se empieza a leer desde size()+2
        representacionIntermedia.add(new Object());
        pila_seleccion.add(representacionIntermedia.size()); // Agrego el index

        representacionIntermedia.add("BI");
        representacionIntermedia.add("L" + representacionIntermedia.size() + 1);

        representacionIntermedia.set(index, representacionIntermedia.size());

    }

    public static void insert_sentencia_control_else(){
        //La del ELSE es la que tiene que completar el destino de la BI, no agrega otra BF.
        //Cond pregunta "hasta donde tengo que saltar si no se cumple la cond." Then le dice "tenes que saltar hasta aca si no se cumple"
        //Then pregunta "a donde tengo que saltar si se cumple la cond, para ignorar el else?", Else le dice "si se cumplio, tenes que saltar
        // hasta aca (desde donde Then dijo que salte)"
        int index = (int) pila_seleccion.pop();

        representacionIntermedia.add("L" + representacionIntermedia.size());

        representacionIntermedia.set(index,  representacionIntermedia.size()); //ya se leyo el codigo del ELSE, aca si es +1
        //este valor hasta donde llega el else. Si se cumple la cond, lo que este entre el final del THEN y este valor se ignora.
        //Si no hay rama ELSE, el codigo es el mismo, porque si la condicion se cumple se empieza a leer desde el final del then.
        //no se necesita una regla para la rama sin else.

    }
    /*

  REPEAT
    { a := b + c;
    c := d – 3; }
   UNTIL
    ( a + b <= c - d )

       a b + c d - <=  ?  b c + a := d 3 - c := ?

     BF = es porque la condicion no se cumple
     BI  = si es verdadera, saltas al inicio

     */
    public static void insert_iteracion_start(){
        //representacionIntermedia.add("L" + representacionIntermedia.size());
        representacionIntermedia.add("L" + representacionIntermedia.size());
        pila_iteracion.push(representacionIntermedia.size()); //va a tener la primer sentencia del REPEAT
    }

    public static void insert_iteracion_end(){
        Polaca.insert(pila_iteracion.pop()); //a donde tenemos que saltar si se cumple la cond
        Polaca.insert("BF");
    }

    public static void removerUltimo(){
        int index = representacionIntermedia.size() - 1;
        representacionIntermedia.remove(index);
    }

    public static String imprimirPolaca() {
        return "Polaca{" + representacionIntermedia.toString() + "}";
    }

    public static List<Object> getRepresentacionIntermedia(){
        return representacionIntermedia;
    }
}
