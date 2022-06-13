package TP4.Generadores;

import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP4.GeneradorASM;

public class GeneradorOr {
    public static String getASM() {

        //Op1 y Op2 son variables auxiliares que tienen un 1 si una condicion es true, y 0 si es false
        //Porque OR siempre esta entre 2 comparaciones.
        String asm = "";
        RegistroTS op1 = (RegistroTS) GeneradorASM.pila_variables.pop();
        RegistroTS op2 = (RegistroTS) GeneradorASM.pila_variables.pop();

        String nombre_auxiliar = "@aux" + GeneradorASM.numeroVar++; // Nombre de la variable aux que almacenara el resultado

        //Hacemos el OR y guardamos el resultado como un 1 o un 0 en una nueva variable auxiliar
        //sabemos que op1 y op2 son variables auxiliares. y que pueden valer 1 o 0, por lo tanto, el resultado del
        //OR es el !ZF (ZF = 0 --> OR = 1)
        asm = "OR " + op1.getLexema() + ", " + op2.getLexema() + '\n' +
                "JNZ " + "L"+nombre_auxiliar+'\n' +
                "MOV " + nombre_auxiliar +", 0" + //AND = 0 (false)
                "L"+nombre_auxiliar+":" + '\n'+
                "MOV " + nombre_auxiliar + ", 1" + '\n'; //AND = 1
        TablaSimbolos.altaTS(nombre_auxiliar);
        TablaSimbolos.punteroTS(nombre_auxiliar).setTipo("asm_bool");
        TablaSimbolos.punteroTS(nombre_auxiliar).setUso("asm_control");

        return asm;
    }
}
