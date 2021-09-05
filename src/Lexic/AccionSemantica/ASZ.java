package Lexic.AccionSemantica;

import java.util.Map;

public class ASZ extends AccionSemantica {

    public void ejecutar(Character simb_actual, String token_actual, Map<String, Integer> tokens) {
        System.out.print("Se ejecuta la accion semantica Z" + simb_actual);
    }
}