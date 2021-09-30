package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import TP2.BYACC.Parser;

/*
Da de alta un identificador y su valor en la tabla de simbolos, busca TPR, devuelve el ultimo char, etc.
*/



public class AS4 implements IAccionSemantica {

    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {
        /*
         * Buscar en la TPR Si está, devolver token de PR Si no está Buscar en la TS Si
         * esta, Devolver ID + Punt TS Si no esta Alta en TS Devolver ID + Punt TS
         */

        var lexema = AnalizadorLexico.lexema;

        // Revisamos si el lexema esta en la tabla de palabras reservadas, si lo esta
        // devolvemos el token que corresponde
        if (TablaSimbolos.perteneceTPR(lexema)) {
            return new Dupla<>(TablaSimbolos.tokenTPR(lexema), null);
        }

        // si no es PR, revisamos si esta en la TS. Si no esta, damos de alta el lexema
        // en la TS y devolvemos
        // tokenID + PunteroTS
        if (!TablaSimbolos.perteneceTS(lexema)) {
            TablaSimbolos.altaTS(lexema);
        }

        return new Dupla<>((int) Parser.ID, TablaSimbolos.punteroTS(lexema));
    }

    @Override
    public boolean devuelveUltimoALaEntrada() {
        return true;
    }
}
