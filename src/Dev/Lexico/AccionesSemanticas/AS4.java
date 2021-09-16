package Dev.Lexico.AccionesSemanticas;

import Dev.Lexico.Dupla;

public class AS4 implements IAccionSemantica {

    @Override
    public Dupla<Integer, Integer> ejecutar(int estadoActual, Character c) {

        /*
         * Buscar en la TPR Si está, devolver token de PR Si no está Buscar en la TS Si
         * esta, Devolver ID + Punt TS Si no esta Alta en TS Devolver ID + Punt TS
         */

        // obtenemos la representacion
        Integer tmp;

        if (TablaSimbolos.perteneceTpr()) {

            return new Dupla<Integer, Integer>(tmp, -1);
        } else {

            if (TablaSimbolos.perteneceTs()) {
                return new Dupla<Integer, Integer>(tmp, -1);
            }

        }

        return null;
    }

    @Override
    public boolean devuelveUltimoALaEntrada() {
        return true;
    }
}
