package Lexic.AccionSemantica;

import java.util.Map;
/**
 * Accion semantica 1 : Esta accion semantica es la encargada de
 */
public class AS1 extends AccionSemantica{

    @Override
    public void ejecutar(Character simb_actual, String token_actual, Map<String, Integer> tokens) {
        System.out.print("Se ejecuta la accion semantica 1" + simb_actual);
    }
}