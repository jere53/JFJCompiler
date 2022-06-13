package Dev.Lexico.AccionesSemanticas;

import Dev.*;
import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import TP2.BYACC.Parser;

/*
Da de alta una constante
*/

public class AS5 implements IAccionSemantica {
    @Override
    public Dupla<Integer, RegistroTS> ejecutar(int estadoActual, Character c) {
        //nota: Rango de Integer: -2^31,  2^31-1
        String lexema = AnalizadorLexico.lexema;
        if (estadoActual == 2) {
            //constante entera sin signo
            try {

                int uint = Integer.parseInt(lexema);

                if (uint > (65536 - 1) || uint < 0) {//si esta fuera de rango devolvemos token de error
                    //return new Dupla<>((int) Parser.ERR_CTE_FUERA_RANGO, null);
                    AnalizadorLexico.tokensReconocidos.add("ERR_CTE_FUERA_RANGO");
                    return new Dupla<>((int) Parser.ERR_CTE_FUERA_RANGO, null);
                }

                //damos de alta la CTE en la TS y devolvemos el puntero y token CTE_UINT
                if (!TablaSimbolos.perteneceTS(lexema))
                    TablaSimbolos.altaTS(lexema);

                AnalizadorLexico.tokensReconocidos.add("CTE_UINT");
                return new Dupla<>((int) Parser.CTE_UINT, TablaSimbolos.punteroTS(lexema));

            } catch (NumberFormatException e) {
                //si por alguna razon no se pudo parsear el lexema, no interrumpimos la ejecucion
                //return new Dupla<>(Parser.ERR_FORMATO_CTE, null);
                AnalizadorLexico.tokensReconocidos.add("ERR_FORMATO_CTE");
                return new Dupla<>((int) Parser.ERR_FORMATO_CTE, null);

                //nunca deberia pasar, la maquina de estados ya deberia haber encontrado el error al hacer la
                //transicion, pero por las dudas.
            }
        } else if (estadoActual == 3 || estadoActual == 4 || estadoActual == 5) {
            //Double

            //El rango de un double en Java es:
            //1.7976931348623157E+308, 4.9406564584124654E-324 (positivo o negativo)
            //Necesitamos rango:
            //-1.7976931348623157E+308, -2.2250738585072014E-308 para los negativos
            //2.2250738585072014E-308, 1.7976931348623157E+308 para los
            //(nota, son el mismo rango, cambia el signo solamente, pero el lexema tiene el "valor absoluto",
            //si controlamos el rango con ese valor absoluto controlamos tanto para positivos como para negativos.
            //el rango superior del TP coincide con el de Java, entonces podemos usar isInfinite para controlarlo
            //2.2250738585072014E-308 esta dentro del rango del double de java, entonces usamos una comparacion
            try {

                double dou = Double.parseDouble(lexema); //acepta todos los formatos considerados en el TP

                if (Double.isInfinite(dou)) {
                    //numero demasiado grande (si es pos) o demasiado chico (si es neg)
                    //TODO: Agregar los errores al parser
                    //return new Dupla<>((int) Parser.ERR_CTE_FUERA_RANGO, null);
                    AnalizadorLexico.tokensReconocidos.add("ERR_CTE_FUERA_RANGO");
                    return new Dupla<>((int) Parser.ERR_CTE_FUERA_RANGO, null);

                }

                if (dou > 0 && dou < 2.2250738585072014E-308) {
                    //numero demasiado chico (si es pos) o demasiado grande (si es neg)
                    //return new Dupla<>((int) Parser.ERR_CTE_FUERA_RANGO, null);
                    AnalizadorLexico.tokensReconocidos.add("ERR_CTE_FUERA_RANGO");
                    return new Dupla<>((int) Parser.ERR_CTE_FUERA_RANGO, null);
                }

                //esta dentro del rango

                if (!TablaSimbolos.perteneceTS(lexema))
                    TablaSimbolos.altaTS(lexema);

                AnalizadorLexico.tokensReconocidos.add("CTE_DOUBLE");
                return new Dupla<>((int) Parser.CTE_DOUBLE, TablaSimbolos.punteroTS(lexema));

            } catch (NumberFormatException e) {
                //return new Dupla<>(Parser.ERR_FORMATO_CTE, null);
                AnalizadorLexico.tokensReconocidos.add("ERR_FORMATO_CTE");
                return new Dupla<>((int) Parser.ERR_FORMATO_CTE, null);
            }
        }
        // algo salio mal, no deberiamos haber ejecutado esta AS desde otro estado
        System.out.println("La AS5 no dio de alta lo que deberia haber dado de alta, devolvio null");
        return null;
    }

    @Override
    public boolean devuelveUltimoALaEntrada() {
        return true;
    }
}