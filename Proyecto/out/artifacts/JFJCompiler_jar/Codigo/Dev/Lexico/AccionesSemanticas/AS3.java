package Dev.Lexico.AccionesSemanticas;

import Dev.RegistroTS;
import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;

/*
Concatena al string el ultimo char leido
*/

public class AS3 implements IAccionSemantica {

    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {
        AnalizadorLexico.agregarCharALexema(c);
        return null;
    }

}
