package Dev.Lexico;

import Dev.*;

import java.util.List;

public class AnalizadorLexico {

    public static Map<String, Integer> numeroToken = new HashMap<String, Integer>();

    private static AnalizadorLexico instance;

    public static AnalizadorLexico Instance() {
        if (instance == null) {
            instance = new AnalizadorLexico();
        }
        return instance;
    }

    private AnalizadorLexico() {
        numeroToken.put("Identificador", 300); // el numero de token que corresponde a un ID es 300
    }

    private static final int estadoFinal = 16;

    private static final int[][] matrizTransicionEstados = {

    };

    private static final AccionSemantica[][] matrizDeTransicionAS = {

    };

    private static List<Character> codigoFuente;

    private static int indiceUltimoLeido = 0;

    public static String lexema;

    public static void InicNuevoLexema() {
        lexema = null;
    }

    public static void agregarCharALexema(Character c) {
        lexema += c;
    }

    // en realidad devuelve Token+Puntero a TS

    public static int analizar() {

        int tokenDetectado = 0;
        int nroLinea = 1;
        int estadoActual = 0;
        int leidos = 0;

        for (Character c : codigoFuente.subList(indiceUltimoLeido, codigoFuente.size() - 1)) {
            // traducir c a un indice en la matriz
            // int estadoAnterior = estadoActual;
            // estadoActual = matrizDeTransicionEstados[estadoActual][cTraducida];

            leidos++;

            if (c.equals('\n')) {
                nroLinea++;
            }

            if (estadoActual == estadoFinal) {
                // si el proxEstado es el final sabemos que la AS devuelve lo que deba
                // devolverle al Sintactico
                // dependiendo la AS, puede que devuelva el ultimo caracter a la entrada
                // (leidos--) o no.

                /*
                 * if (AS.devuelveUltimoALaEntrada()){ leidos--; }
                 */

                indiceUltimoLeido += leidos;

                // return ejecutar AS[estadoActual][cTraducida](estadoAnterior, c);
                // esta AS devuelve el token y el puntero a la TS si es necesario
            } else {

                // la AS no va a devolver nada
                // ejecutar AccionSemantica[estadoActual][cTraducida](estadoAnterior, c);
            }

        }

        return -1;
    }
}