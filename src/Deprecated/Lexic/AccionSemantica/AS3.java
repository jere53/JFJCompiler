package Deprecated.Lexic.AccionSemantica;

import java.util.Map;
import Deprecated.Lexic.Tokenizer;

/**
 * Accion semantica 3 : Esta accion semantica es la encargada de
 */
public class AS3 extends AccionSemantica {

    public void ejecutar(Character simb_actual, Map<String, Integer> tokens) {
        System.out.println("Se ejecuta la accion semantica 3, recibio: " + simb_actual);
        Tokenizer.token_actual += simb_actual;
    }
}