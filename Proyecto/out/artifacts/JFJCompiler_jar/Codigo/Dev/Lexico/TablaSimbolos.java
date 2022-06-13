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
        String res = "";
        for(RegistroTS r : ts.values()){
            res += r.toString() + '\n';
        }
        return res;
    }

    // Cambiar nombre se utiliza para actualizar el ambito de la variable. El ambito esta representado
    // en el nombre de la misma
    public static void cambiarNombre(String viejo, String nuevo){
        if (perteneceTS(nuevo)) {
            AnalizadorLexico.errores.add("Repeated identifier " + viejo + " on line " + AnalizadorLexico.nroLinea);
            return;
        }
        RegistroTS old = ts.get(viejo);
        ts.remove(viejo);
        old.setLexema(nuevo);
        ts.put(nuevo, old);

    }

    public static void removePuntero(String lexema){
        ts.remove(lexema);
    }

}