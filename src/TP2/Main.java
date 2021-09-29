package TP2;

import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;

public class Main {

    public static void main(String[] args) {
        Dupla<Integer, RegistroTS> token = new Dupla<>(0, null);
        do {
            try {
                token = AnalizadorLexico.Instance().analizar();
                System.out.println(token.first + " : " + token.second.getLexema());
            } catch (Exception e) {
                System.out.println("F");
            }
        } while (token.first != 69);
    }

    private static int yylex(){
        TablaSimbolos.CargarTablaSimbolos(); //invocamos el constructor para que cargue los primeros valores a los mapas
        // Variable para saber si debemos seguir pidiendo tokens al analizador Lexico
        Dupla<Integer, RegistroTS> token; // ELEGIR MEJOR NOMBRE
        // Pedimos un token al analizador lexico el cual es entregado en forma de dupla
        do{
            try {
                token = AnalizadorLexico.Instance().analizar();
            } catch (Exception e) {
                e.printStackTrace();
                token = null;
            }
        } while (token == null);
        return token.first; // Retorno el numero de token
    }
}
