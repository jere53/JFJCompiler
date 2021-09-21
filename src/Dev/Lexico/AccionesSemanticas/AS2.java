package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;

public class AS2 implements IAccionSemantica {

    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {
        AnalizadorLexico.InicNuevoLexema();
        AnalizadorLexico.agregarCharALexema(c);
        return null;
    }
}
