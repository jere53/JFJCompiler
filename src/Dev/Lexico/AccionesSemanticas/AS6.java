package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;

/*
AS6: devuelve el ultimo caracter y da de alta un /
*/

public class AS6 implements IAccionSemantica {

    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {
        //<token_/, null> es null el registro porque la / no tiene puntero a la TS
        return new Dupla<>(AnalizadorLexico.numeroToken.get("/"), null);
    }

    @Override
    public boolean devuelveUltimoALaEntrada() {
        return true;
    }
}