package Lexic.TablaPalabrasReservadas;

import java.util.Map;

public class TablaPalabrasReservadas{

    // private static Map<String ,Integer> palabrasReservadas = new HashMap<>();

    private static Map<String ,Integer> palabrasReservadas = Map.of(
            "IF", 1
            ,"THEN",2
            ,"ELSE", 3
            ,"ENDIF", 4
            ,"PRINT", 5
            ,"FUNC", 6
            ,"RETURN", 7
            ,"BEGIN", 8
            ,"END", 9
            ,"BREAK", 10);

    public Integer get(String key){
            return palabrasReservadas.get(key);
    }


}
// IF, THEN, ELSE, ENDIF, PRINT, FUNC, RETURN, BEGIN, END, BREAK