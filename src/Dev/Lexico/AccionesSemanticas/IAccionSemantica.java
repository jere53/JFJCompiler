package Dev.Lexico.AccionesSemanticas;


import Dev.Lexico.Dupla;

public interface IAccionSemantica {

    // el segundo Integer es la clave del Map que implementa la TS, el primero el numero de token
    default Dupla<Integer, Integer> ejecutar(int estadoActual, Character c) {
        return null;
    }

    default boolean devuelveUltimoALaEntrada() {
        return false;
    }

}
