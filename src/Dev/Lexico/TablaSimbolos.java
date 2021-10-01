package Dev.Lexico;

import java.util.HashMap;
import java.util.Map;
import Dev.*;
import TP2.BYACC.Parser;

public class TablaSimbolos {

    private static final Map<String, Integer> tpr = new HashMap<>();

    private static final Map<String, RegistroTS> ts = new HashMap<>();

    public static void CargarTablaPalabrasReservadas() {

        tpr.putAll(Map.of(
                "IF", (int) Parser.IF,
                "THEN", (int) Parser.THEN,
                "ELSE", (int) Parser.ELSE,
                "ENDIF", (int) Parser.ENDIF,
                "PRINT", (int) Parser.PRINT,
                "FUNC", (int) Parser.FUNC,
                "RETURN", (int) Parser.RETURN,
                "BEGIN", (int) Parser.BEGIN,
                "END", (int) Parser.END,
                "BREAK", (int) Parser.BREAK)
        );

        tpr.putAll(Map.of(
                "UINT", (int) Parser.UINT,
                "DOUBLE", (int) Parser.DOUBLE,
                "REPEAT", (int) Parser.REPEAT,
                "UNTIL", (int) Parser.UNTIL,
                "POST", (int) Parser.POST)
        );

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