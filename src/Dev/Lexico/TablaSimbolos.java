package Dev.Lexico;

import java.util.HashMap;
import java.util.Map;

public static class TablaSimbolos {

    private static Map<String, Integer> ts = new HashMap<String, Integer>();

    public static Integer getID() {
        // Obtengo el ID de la tabla de simbolos que corresponde con el token
        String token_actual = Tokenizer.token_actual;
        Integer ID = ts.get(token_actual);
        if (token_actual == null) {
            ID = ts.size() + 1;
            ts.put(token_actual, ID);
        }
        return ID;

    }

    public static boolean estaTS() {
        return true;
    }

    public static void altaToken() {
        // Alta de un token en la tabla de simbolos

    }

    public static boolean perteneceTpr() {
        // Verifica si el token pertenece a la tabla de palabras
        return true;
    }
}
