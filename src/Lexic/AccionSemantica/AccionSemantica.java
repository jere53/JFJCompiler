package Lexic.AccionSemantica;

import java.util.Map;

/**
 * Clase abstracta ejecutar acciones semanticas
 */
public abstract class AccionSemantica {
    public abstract void ejecutar(Character simb_actual, Map<String, Integer> tokens);
}
