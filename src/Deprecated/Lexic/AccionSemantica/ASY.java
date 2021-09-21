package Deprecated.Lexic.AccionSemantica;

import java.util.Map;
import Deprecated.Lexic.Tokenizer;

public class ASY extends AccionSemantica {

    public void ejecutar(Character simb_actual, Map<String, Integer> tokens) {
        System.out.println("Se ejecuta la accion semantica Y, recibio: " + simb_actual);
        Tokenizer.estado_actual = Tokenizer.ESTADO_INICIAL;
        System.out.println("Estado trancisionado: " + Tokenizer.estado_actual);
    }
}