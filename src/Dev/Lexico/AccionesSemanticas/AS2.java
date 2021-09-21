package Dev.Lexico.AccionesSemanticas;

import Deprecated.Lexic.TablaSimbolos.RegistroTS;
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
