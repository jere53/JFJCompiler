package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.Dupla;

public interface IAccionSemantica {

    default Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {
        return null;
    }

    default boolean devuelveUltimoALaEntrada() {
        return false;
    }

}
