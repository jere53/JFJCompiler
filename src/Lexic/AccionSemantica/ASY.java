package Lexic.AccionSemantica;

import java.util.Map;

public class ASY extends AccionSemantica {

    public void ejecutar(Character simb_actual, String token_actual, Map<String, Integer> tokens) {
        System.out.print("Se ejecuta la accion semantica Y" + simb_actual);
    }
}