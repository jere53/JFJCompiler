package Lexic.ConversorSimbolos;

public class ConversorSimbolos {
    public static int convertirSimbolo(Character simbolo) {
        if (simbolo == '(' | simbolo == ')' | simbolo == ';' | simbolo == ',')
            return 0;
        if (Character.isLowerCase(simbolo))
            return 1;
        if (Character.isUpperCase(simbolo))
            return 2;
        if (Character.isDigit(simbolo))
            return 3;
        if (simbolo == '_')
            return 4;
        return 5;
    }
}
