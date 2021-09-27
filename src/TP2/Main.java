package TP2;

import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import Dev.RegistroTS;

public class Main {

    public static void main(String[] args) {
        
    }

    private int yylex(){
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
        }while(token == null);
        return token.first; // Retorno el numero de token
        

    }
}
