package TP4.Generadores;

import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP4.GeneradorASM;

import static TP4.GeneradorASM.pila_variables;

public class GeneradorAnd {
    public static String getASM() {

        //Op1 y Op2 son variables auxiliares que tienen un 1 si una condicion es true, y 0 si es false
        //Porque AND siempre esta entre 2 comparaciones.
        String asm = "";
        RegistroTS op1 = (RegistroTS) GeneradorASM.pila_variables.pop();
        RegistroTS op2 = (RegistroTS) GeneradorASM.pila_variables.pop();

        String nombre_auxiliar = "@aux" + GeneradorASM.numeroVar++; // Nombre de la variable aux que almacenara el resultado

        //Hacemos el and y guardamos el resultado como un 1 o un 0 en una nueva variable auxiliar
        //sabemos que op1 y op2 son variables auxiliares. y que pueden valer 1 o 0, por lo tanto, el resultado del
        //AND es la negacion del ZF (ZF = 0 --> AND = 1)
        asm =  "MOV " + nombre_auxiliar +", 0" + //asumo AND = 0 (false)
                "AND " + op1.getLexema() + ", " + op2.getLexema() + '\n' +
                "JZ " + "L"+nombre_auxiliar+'\n' + //Si el ZF = 1, entonces el AND dio 0, y es falso. Sino dio 1
                "MOV " + nombre_auxiliar + ", 1" + '\n' + //AND = 1
                "L"+nombre_auxiliar+":" + '\n';
        TablaSimbolos.altaTS(nombre_auxiliar);
        TablaSimbolos.punteroTS(nombre_auxiliar).setTipo("asm_bool");
        TablaSimbolos.punteroTS(nombre_auxiliar).setUso("asm_control");

        return asm;
    }
}
