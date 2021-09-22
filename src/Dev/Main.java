package Dev;

import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;

public class Main {

    public static void main(String[] args) {
        // Variable para saber si debemos seguir pidiendo tokens al analizador Lexico
        Dupla<Integer, RegistroTS> token; // ELEGIR MEJOR NOMBRE

        do {
            // Pedimos un token al analizador lexico el cual es entregado en forma de dupla
            try {
                token = AnalizadorLexico.Instance().analizar();
            } catch (Exception e) {
                e.printStackTrace();
                token = null;
            }
        } while (token != null); // Mientras no se haya terminado el lexema
    }
}
