package Dev.Lexico;

import java.util.HashMap;
import java.util.Map;

import Dev.*;

public class TablaSimbolos {

    private static final Map<String, Integer> tpr = new HashMap<>();

    private static final Map<String, RegistroTS> ts = new HashMap<>();

    public static void CargarTablaSimbolos() {
        tpr.putAll(Map.of("IF", 1, "THEN", 2, "ELSE", 3, "ENDIF", 4, "PRINT", 5, "FUNC", 6, "RETURN", 7, "BEGIN", 8, "END", 9, "BREAK", 10));
        tpr.putAll(Map.of("UINT", 11, "DOUBLE", 12, "REPEAT", 13, "UNTIL", 14));
    }

    public static boolean perteneceTPR(String lexema) {
        return tpr.containsKey(lexema);
    }

    public static boolean perteneceTS(String lexema) {
        return ts.containsKey(lexema);
    }

    public static Integer tokenTPR(String lexema) {
        return tpr.get(lexema);
    }

    public static void altaTS(String lexema) {
        RegistroTS atributos = new RegistroTS(lexema);
        ts.put(lexema, atributos);
    }

    public static RegistroTS punteroTS(String lexema) {
        return ts.get(lexema);
    }

}
