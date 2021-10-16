package TP2;

import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP2.BYACC.ParserVal;

public class Main {
    public static void main(String[] args) {
        AnalizadorLexico.FILE_PATH = args[0];
        TablaSimbolos.CargarTablaPalabrasReservadas();
        new Parser().run();
        for (String s : AnalizadorLexico.errores){
            System.out.println(s);
        }
    }

}
