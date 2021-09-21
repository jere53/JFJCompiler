package Deprecated.Lexic.TablaSimbolos;

import java.util.HashMap;
import java.util.Map;

import Deprecated.Lexic.Tokenizer;

public class TablaSimbolos {

    private static Map<String, Integer> ts = new HashMap<String, Integer>();

    // TODO : PREGUNTAR POR QUE DEVOLVEMOS ID + PUNT TS
    public static Integer getData() {
        String token_actual = Tokenizer.token_actual;
        Integer ID = ts.get(token_actual);
        if (token_actual == null) {
            ID = ts.size() + 1;
            ts.put(token_actual, ID);
        }
        return ID;
        /*
         * 
         * <IF, 1> <ELSE, 2> <WHILE, 3> <SWITCH, 4>
         * 
         */
    }

}
