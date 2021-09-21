package Deprecated.Lexic.AccionSemantica;

import java.util.Map;
import Deprecated.Lexic.Tokenizer;

/**
 * Accion semantica 1 : Esta accion semantica es la encargada de
 */
public class AS1 extends AccionSemantica {

    @Override
    public void ejecutar(Character simb_actual, Map<String, Integer> tokens) {

        System.out.println("Se ejecuta la accion semantica 1, recibio: " + simb_actual);
        Tokenizer.estado_actual = Tokenizer.ESTADO_INICIAL;
    }
}
