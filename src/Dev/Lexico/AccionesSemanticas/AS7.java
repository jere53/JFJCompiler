package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;

/*
AS7: da de alta una cadena de caracteres
*/

public class AS7 implements IAccionSemantica {
    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {

        var lexema = AnalizadorLexico.lexema;

        if (!TablaSimbolos.perteneceTS(lexema)) {
            TablaSimbolos.altaTS(lexema);
        }

        return new Dupla<>(AnalizadorLexico.numeroToken.get("CADENA"), TablaSimbolos.punteroTS(lexema));
    }

}