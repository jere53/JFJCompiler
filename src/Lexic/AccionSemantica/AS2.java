package Lexic.AccionSemantica;

import java.util.Map;
import Lexic.Tokenizer;

/**
 * Accion semantica 2 : Esta accion semantica es la encargada de
 */
public class AS2 extends AccionSemantica {

    public void ejecutar(Character simb_actual, String token_actual, Map<String, Integer> tokens) {
        System.out.println("Se ejecuta la accion semantica 2, recibio: " + simb_actual);
        token_actual += simb_actual;

    }
}
