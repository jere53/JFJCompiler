package TP3;

import Dev.Lexico.TablaSimbolos;

public class Utils {

    public static String signoNegativo(String s){
        Polaca.removerUltimo();
        //si ya era negativa, queda positiva y no agregamos nada a la TS
        if (s.startsWith("-"))
            return s.substring(1);

        String res = "-" + s;

        if (!TablaSimbolos.perteneceTS(res))
            TablaSimbolos.altaTS(res);

        return res;
    }
}
