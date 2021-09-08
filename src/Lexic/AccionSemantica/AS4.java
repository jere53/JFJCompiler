package Lexic.AccionSemantica;

import java.util.Map;
import Lexic.Tokenizer;

public class AS4 extends AccionSemantica {

    public void ejecutar(Character simb_actual, String token_actual, Map<String, Integer> tokens) {
        System.out.println("Se ejecuta la accion semantica 4, recibio: " + simb_actual);
        // TODO : Implementar la tabla de palabras reservadas

        System.out.println("token_actual " + token_actual);
        if (token_actual.equals("IF")) {
            System.out.println("Se encontro un IF");
        }

        Tokenizer.estado_actual = Tokenizer.ESTADO_INICIAL;

    }
}