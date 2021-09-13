package Deprecated.Lexic.AccionSemantica;

import java.util.Map;
import Deprecated.Lexic.Tokenizer;

public class AS4 extends AccionSemantica {

    public void ejecutar(Character simb_actual, Map<String, Integer> tokens) {
        System.out.println("Se ejecuta la accion semantica 4, recibio: " + simb_actual);
        // TODO : Implementar la tabla de palabras reservadas

        if (Tokenizer.token_actual.equals("IF")) {
            System.out.println("Se encontro un IF");
        }

        Tokenizer.token_actual = "";
        Tokenizer.estado_actual = Tokenizer.ESTADO_INICIAL;
        /*
        String token = TablaPalabrasReservadas.get();
        if (token) {
            
        } else {
            TablaSimbolos.get();
        }

         */
    }
}