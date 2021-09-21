package Dev.Lexico;

import java.util.HashMap;
import java.util.Map;

import Dev.*;

public class TablaSimbolos {

    private static Map<String, Integer> tpr = new HashMap<String, Integer>();

    private static Map<String, RegistroTS> ts = new HashMap<String, RegistroTS>();

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
