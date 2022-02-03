package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import TP2.BYACC.Parser;

/*
Reconoce el literal y devuelve el token. 
Recibe como parametro el estado del cual venimos para tratar tokens combinados. 
Ej: si venimos del 11 y viene un =, es <=. Si viene un >, es <>, si viene otro es <.
*/

public class AS1 implements IAccionSemantica {

    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {
        switch (estadoActual){
            case 9: //leimos un :
                if (c == '=') {
                    //Vino un =, token ASIG
                    AnalizadorLexico.tokensReconocidos.add("ASIG");
                    return new Dupla<>((int) Parser.ASIG, null);
                }
                //vino otra cosa, devolvemos el literal : y el ultimo char vuelve a la entrada
                AnalizadorLexico.indiceUltimoLeido--;
                AnalizadorLexico.tokensReconocidos.add(":");
                return new Dupla<>((int) ':', null);
            case 10: //leimos un >, vino un = u otro caracter
                if (c == '=') {
                    AnalizadorLexico.tokensReconocidos.add("COMP_MAYOR_IGUAL");
                    return new Dupla<>((int) Parser.COMP_MAYOR_IGUAL, null);
                }
                AnalizadorLexico.indiceUltimoLeido--;
                AnalizadorLexico.tokensReconocidos.add(">");
                return new Dupla<>((int) '>', null); //al castear a int conseguimos el valor ASCII del char
            case 11: //leimos un <, vino =, > u otro caracter
                if (c == '='){
                    AnalizadorLexico.tokensReconocidos.add("COMP_MENOR_IGUAL");
                    return new Dupla<>((int) Parser.COMP_MENOR_IGUAL, null);
                }
                if (c == '>'){
                    AnalizadorLexico.tokensReconocidos.add("COMP_DISTINTO");
                    return new Dupla<>((int) Parser.COMP_DISTINTO, null);
                }
                AnalizadorLexico.indiceUltimoLeido--;
                AnalizadorLexico.tokensReconocidos.add("<");
                return new Dupla<>((int) '<', null);
            case 12: //leimos un =, vino otro =
                AnalizadorLexico.tokensReconocidos.add("COMP_IGUAL");
                return new Dupla<>((int) Parser.COMP_IGUAL, null);
            case 13: //leimos  &, vino otro &
                AnalizadorLexico.tokensReconocidos.add("AND");
                return new Dupla<>((int) Parser.AND, null);
            case 14: //leimos |, vino otro |
                AnalizadorLexico.tokensReconocidos.add("OR");
                return new Dupla<>((int) Parser.OR, null);
            case 0: //puede haber venido +, -, *, (, ), ",", ;
                AnalizadorLexico.tokensReconocidos.add(c.toString());
                return new Dupla<>((int) c, null);
        }
        //algo salio mal, no deberiamos haber ejecutado esta AS desde otro estado
        System.out.println("La AS1 no dio de alta lo que deberia haber dado de alta, devolvio null");
        return null;
    }

}