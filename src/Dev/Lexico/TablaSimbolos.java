package Dev.Lexico;

import java.util.HashMap;
import java.util.Map;
import Dev.*;
import TP2.BYACC.Parser;

public class TablaSimbolos {

    private static final Map<String, Integer> tpr = new HashMap<>();

    private static final Map<String, RegistroTS> ts = new HashMap<>();

    public static void CargarTablaPalabrasReservadas() {

        tpr.put("IF", (int) Parser.IF);
        tpr.put("THEN", (int) Parser.THEN);
        tpr.put("ELSE", (int) Parser.ELSE);
        tpr.put("ENDIF", (int) Parser.ENDIF);
        tpr.put("PRINT", (int) Parser.PRINT);
        tpr.put("UINT", (int) Parser.UINT);
        tpr.put("DOUBLE", (int) Parser.DOUBLE);
        tpr.put("FUNC", (int) Parser.FUNC);
        tpr.put("REPEAT", (int) Parser.REPEAT);
        tpr.put("RETURN", (int) Parser.RETURN);
        tpr.put("POST", (int) Parser.POST);
        tpr.put("UNTIL", (int) Parser.UNTIL);
        tpr.put("BEGIN", (int) Parser.BEGIN);
        tpr.put("END", (int) Parser.END);
        tpr.put("BREAK", (int) Parser.BREAK);
        tpr.put("PROGRAM", (int) Parser.PROGRAM);

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

    public static String mostrarTS() {
        return "TablaSimbolos{ " + "ts: " + ts.toString() + " }";
    }
}