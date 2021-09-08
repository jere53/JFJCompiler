package Lexic.AccionSemantica;

import java.util.Map;
import Lexic.Tokenizer;

public class ASZ extends AccionSemantica {

    public void ejecutar(Character simb_actual, String token_actual, Map<String, Integer> tokens) {
        System.out.println("Se ejecuta la accion semantica Z, recibio: " + simb_actual);
        Tokenizer.estado_actual = Tokenizer.ESTADO_INICIAL;

    }
}