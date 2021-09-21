package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.Dupla;

public interface IAccionSemantica {

    // el segundo Integer es la clave del Map que implementa la TS, el primero el
    // numero de token

    // TODO : Revisar tema default, podria ser una abstracta
    // TODO : Revisar tema puntero

    default Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {
        return null;
    }

    default boolean devuelveUltimoALaEntrada() {
        return false;
    }

}
