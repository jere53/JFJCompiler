package Dev.Lexico.AccionesSemanticas;

import Dev.*;

public class AS4 implements IAccionSemantica {

    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {

        // El numero de token que corresponde a un ID es lo que este guardado en el
        // hashmap del
        // AL
        Integer tokenID = AnalizadorLexico.numeroToken.get("Identificador");

        /*
         * Buscar en la TPR Si está, devolver token de PR Si no está Buscar en la TS Si
         * esta, Devolver ID + Punt TS Si no esta Alta en TS Devolver ID + Punt TS
         */

        var lexema = AnalizadorLexico.lexema;

        // Revisamos si el lexema esta en la tabla de palabras reservadas, si lo esta
        // devolvemos el token que corresponde
        if (TablaSimbolos.perteneceTPR(lexema)) {
            var token = TablaSimbolos.tokenTPR(lexema);
            return new Dupla<Integer, RegistroTS>(token, null);
        }

        // si no es PR, revisamos si esta en la TS. Si no esta, damos de alta el lexema
        // en la TS y devolvemos
        // tokenID + PunteroTS
        if (!TablaSimbolos.perteneceTS(lexema)) {
            TablaSimbolos.altaTS(lexema);
        }

        return new Dupla<Integer, RegistroTS>(tokenID, TablaSimbolos.punteroTS(lexema));
    }

    @Override
    public boolean devuelveUltimoALaEntrada() {
        return true;
    }
}
