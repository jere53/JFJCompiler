package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;

/*
Reconoce el literal y devuelve el token. 
Recibe como parametro el estado del cual venimos para tratar tokens combinados. 
Ej: si venimos del 11 y viene un =, es <=. Si viene un >, es <>, si viene otro es <.
*/

public class AS1 implements IAccionSemantica {
    private boolean devuelveUltimo = false;

    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {
        switch (estadoActual){
            case 9: //leimos un :, vino un = (porque sino venia =, hubiera habido error lexico)
                devuelveUltimo = false;
                return new Dupla<>(AnalizadorLexico.numeroToken.get(":="), null);
            case 10: //leimos un >, vino un = u otro caracter
                if (c == '=') {
                    devuelveUltimo = false;
                    return new Dupla<>(AnalizadorLexico.numeroToken.get(">="), null);
                }
                devuelveUltimo = true;
                return new Dupla<>(AnalizadorLexico.numeroToken.get(">"), null);
            case 11: //leimos un <, vino =, > u otro caracter
                if (c == '='){
                    devuelveUltimo = false;
                    return new Dupla<>(AnalizadorLexico.numeroToken.get("<="), null);
                }
                if (c == '>'){
                    devuelveUltimo = false;
                    return new Dupla<>(AnalizadorLexico.numeroToken.get("<>"), null);
                }
                devuelveUltimo = true;
                return new Dupla<>(AnalizadorLexico.numeroToken.get("<"), null);
            case 12: //leimos un =, vino otro =
                devuelveUltimo = false;
                return new Dupla<>(AnalizadorLexico.numeroToken.get("=="), null);
            case 13: //leimos  &, vino otro &
                devuelveUltimo = false;
                return new Dupla<>(AnalizadorLexico.numeroToken.get("&&"), null);
            case 14: //leimos |, vino otro |
                devuelveUltimo = false;
                return new Dupla<>(AnalizadorLexico.numeroToken.get("||"), null);
            case 0: //puede haber venido +, -, *, (, ), ",", ;
                devuelveUltimo = false;
                String literal = c.toString();
                return new Dupla<>(AnalizadorLexico.numeroToken.get(literal), null);
        }
        //algo salio mal, no deberiamos haber ejecutado esta AS desde otro estado
        System.out.println("La AS1 no dio de alta lo que deberia haber dado de alta, devolvio null");
        return null;
    }

    @Override
    public boolean devuelveUltimoALaEntrada() {
        return devuelveUltimo;
    }
}