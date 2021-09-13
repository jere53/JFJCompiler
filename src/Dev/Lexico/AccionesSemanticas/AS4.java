package Dev.Lexico.AccionesSemanticas;

import Dev.Lexico.Dupla;

public class AS4 implements IAccionSemantica{
    @Override
    public Dupla<Integer, Integer> ejecutar(int estadoActual, Character c) {
        /*
         Buscar en la TS
             Si está,
                 Si es PR, devolver la Palabra Reservada
                 Si no, Devolver ID + Punt TS
             Si no está,
                 Alta en la TS
                 Devolver ID + Punt TS
         */

        return null;
    }

    @Override
    public boolean devuelveUltimoALaEntrada() {
        return true;
    }
}
