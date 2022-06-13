package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import TP2.BYACC.Parser;

/*
AS7: da de alta una cadena de caracteres
*/

public class AS7 implements IAccionSemantica {
    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {

        String lexema = AnalizadorLexico.lexema.substring(1);
        //no tomamos el primer char porque sabemos que va a ser un '%' que no es parte del lexema

        if (!TablaSimbolos.perteneceTS(lexema)) {
            TablaSimbolos.altaTS(lexema);
        }

        AnalizadorLexico.tokensReconocidos.add("CADENA");
        return new Dupla<>((int) Parser.CADENA, TablaSimbolos.punteroTS(lexema));
    }

}