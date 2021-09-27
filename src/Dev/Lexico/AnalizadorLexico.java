package Dev.Lexico;

import Dev.RegistroTS;
import Dev.Lexico.AccionesSemanticas.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

public class AnalizadorLexico {

    public static Map<String, Integer> numeroToken = new HashMap<>();

    private static AnalizadorLexico instance;

    public static AnalizadorLexico Instance() {
        if (instance == null)
            instance = new AnalizadorLexico();
        return instance;
    }

    private AnalizadorLexico() {
        loadValues();
        numeroToken.put("Identificador", 300); // el numero de token que corresponde a un ID es 300
    }

    private static final int estadoFinal = 16;

    //region Matrices
    private static final int[][] matrizDeTransicionEstados = {
        {1,1,1,2,estadoFinal,estadoFinal,estadoFinal,0,0,0,6,15,3,9,10,11,12,13,14,estadoFinal},
        {1,estadoFinal,1,1,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {-1,-1,-1,2,estadoFinal,-1,-1,estadoFinal,estadoFinal,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,estadoFinal},
        {-1,4,-1,3,estadoFinal,-1,-1,estadoFinal,estadoFinal,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal},
        {-1,-1,-1,4,estadoFinal,-1,5,estadoFinal,estadoFinal,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal},
        {-1,-1,-1,5,estadoFinal,-1,-1,estadoFinal,estadoFinal,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal},
        {estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,7,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {7,7,7,7,7,7,7,7,7,7,8,7,7,7,7,7,7,7,7,-1},
        {7,7,7,7,7,7,7,7,7,7,0,7,7,7,7,7,7,7,7,-1},
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal,-1,-1,-1},
        {estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal,-1,-1,-1},
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal,-1,-1},
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal,-1},
        {15,15,15,15,15,15,15,15,-1,15,15,estadoFinal,15,15,15,15,15,15,15,-1}
    };
    
    static IAccionSemantica AS1 = new AS1();
    static IAccionSemantica AS2 = new AS2();
    static IAccionSemantica AS3 = new AS3();
    static IAccionSemantica AS4 = new AS4();
    static IAccionSemantica AS5 = new AS5();
    static IAccionSemantica AS6 = new AS6();
    static IAccionSemantica AS7 = new AS7();
    
    private static final IAccionSemantica[][] matrizDeTransicionAS = {
        {AS2, AS2, AS2, AS2, AS1, AS1, AS1, null, null, null, null, AS2, AS2, null, null, null, null, null, null, null}, //0
        {AS3, AS3, AS3, AS3, AS4, AS4, AS4, AS4, AS4, AS4, AS4, AS4, AS4, AS4, AS4, AS4, AS4, AS4, AS4, AS4}, //1
        {null, null, null, AS3, AS5, null, null, AS5, AS5, null, null, null, AS3, null, null, null, null, null, null, null}, //2
        {null, AS3, null, AS3, AS5, null, null, AS5, AS5, null, null, null, null, null, null, null, null, null, null, null},//3
        {null, null, null, AS3, AS5, null, AS3, AS5, AS5, null, null, null, null, null, null, null, null, null, null, null},//4
        {null, null, null, AS3, AS5, null, null, AS5, AS5, null, null, null, null, null, null, null, null, null, null, null},//5
        {AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6, null, AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6},//6
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},//7
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},//8
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, AS1, null, null, null},//9
        {AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1}, //10
        {AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1}, //11 
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, AS1, null, null, null},//12
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, AS1, null, null},//13
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, AS1, null},//14
        {AS3, AS3, AS3, AS3, AS3, AS3, AS3, AS3, null, AS3, AS3, AS7, AS3, AS3, AS3, AS3, AS3, AS3, AS3, null} //15

        
/*
           L    "E" "_"  d  ";" (),* +- " " \n  tab  /   %  "." ":"  >   <   =   &   |   $
0         AS2	AS2	AS2	AS2	AS1	AS1	AS1					AS2	AS2							
1         AS3	AS3	AS3	AS3	AS4	AS4	AS4	AS4	AS4	AS4	AS4	AS4	AS4	AS4	AS4	AS4	AS4	AS4	AS4	AS4
2                       AS3	AS5			AS5	AS5				AS3							
3               AS3	    AS3	AS5			AS5	AS5											
4                       AS3	AS5		AS3	AS5	AS5											
5                       AS3	AS5			AS5	AS5											
6         AS6	AS6	AS6	AS6	AS6	AS6	AS6	AS6	AS6	AS6		AS6	AS6	AS6	AS6	AS6	AS6	AS6	AS6	AS6
7                                                                                     
8                                                                                     
9                                                                           AS1			
10        AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1
11        AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1	AS1
12                                                                          AS1			
13                                                                              AS1		
14                                                                                  AS1	
15        AS3	AS3	AS3	AS3	AS3	AS3	AS3	AS3		AS3	AS3	AS7	AS3	AS3	AS3	AS3	AS3	AS3	AS3	
*/
    };

    //endregion

    private static List<Character> codigoFuente = new ArrayList<>();

    private static int indiceUltimoLeido = 0;

    public static String lexema;

    //region FileRead

    final static String FILE_PATH = "src/input.txt";

    private void loadValues() {
        File file = new File(FILE_PATH);
        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                codigoFuente.add((char) content);
            }
            codigoFuente.add('$'); //agregamos el simbolo EOF
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //endregion

    public static void InicNuevoLexema() {
        lexema = null;
    }

    public static void agregarCharALexema(Character c) {
        lexema += c;
    }

    public int traducirCaracter(Character c) {
        //  L    "E" "_"  d  ";" (),* +- " " \n  tab  /   %  "." ":"  >   <   =   &   |   $
        if (Character.isAlphabetic(c)) 
            return 0;
        if (c == 'E')
            return 1;
        if (c == '_')
            return 2;
        if (Character.isDigit(c))
            return 3;
        if (c == ';')
            return 4;
        if (c == '(' | c == ')' | c == ',' | c == '*')
            return 5;
        if (c == '+' | c == '-')
            return 6;
        if (c == ' ')
            return 7;
        if (c == '\n')
            return 8;
        if (c == '\t')
            return 9;
        if (c == '/')
            return 10;
        if (c == '%')
            return 11;
        if (c == '.')
            return 12;
        if (c == ':')
            return 13;
        if (c == '>')
            return 14;
        if (c == '<')
            return 15;
        if (c == '=')
            return 16;
        if (c == '&')
            return 17;
        if (c == '|')
            return 18;
        if (c == '$')
            return 19;
        return -1;
    }

    // en realidad devuelve Token+Puntero a TS

    public Dupla<Integer, RegistroTS> analizar() throws Exception {

        //Analizar se llama una vez por lexema. Si hay un error lexico, se lanza una excepcion que indica cual
        //fue el error, para mostrarlo. El A.S. luego ejecuta el analizar de nuevo, ahora sobre la proxima letra,
        //partiendo desde el estado inicial. el String lexema se vacia, y se incrementa el indiceUltimoLeido.

        int tokenDetectado = 0;
        int nroLinea = 1;
        int estadoActual = 0;
        int leidos = 0;
        int estadoAnterior = 0;

        int cIndex = 0;

        for (Character c : codigoFuente.subList(indiceUltimoLeido, codigoFuente.size() - 1)) {

            cIndex = traducirCaracter(c); // traducir c a un indice en la matriz
            if (cIndex == -1){
                //caracter invalido, se ignora y se pasa al siguiente
            }
            
            estadoAnterior = estadoActual;
            
            estadoActual = matrizDeTransicionEstados[estadoActual][cIndex]; // obtener el estado siguiente

            leidos++;

            if (c.equals('\n')) {
                nroLinea++;
            }

            //me fui a cenar -J

            if (estadoActual == -1){
                //error lexico
                switch(estadoAnterior){
                    case 0:
                        throw new Exception("");
                    case 1:
                        throw new Exception("");
                    case 2:
                        throw new Exception("");
                    case 3:
                        throw new Exception("");
                    case 4:
                        throw new Exception("");
                    case 5:
                        throw new Exception("");
                    case 6:
                        throw new Exception("");
                    case 7:
                        throw new Exception("");
                    case 8:
                        throw new Exception("");
                    case 9:
                        throw new Exception("");
                    case 10:
                        throw new Exception("");
                    case 11:
                        throw new Exception("");
                    case 12:
                        throw new Exception("");
                    case 13:
                        throw new Exception("");
                    case 14:
                        throw new Exception("");
                    case 15:
                        throw new Exception("");
                    default:
                        throw new Exception("");
                }
            }
            
            IAccionSemantica AS = matrizDeTransicionAS[estadoAnterior][cIndex];

            if (AS == null) //si no tenemos que hacer una AS, avanzamos
                continue;

            if (estadoActual == estadoFinal) {
                // si el proxEstado es el final sabemos que la AS devuelve lo que deba
                // devolverle al Sintactico
                // dependiendo la AS, puede que devuelva el ultimo caracter a la entrada
                // (leidos--) o no.

                if (AS.devuelveUltimoALaEntrada()) {
                    leidos--;
                }

                indiceUltimoLeido += leidos;

                // return ejecutar AS[estadoActual][cTraducida](estadoAnterior, c);
                // esta AS devuelve el token y el puntero a la TS si es necesario

                return AS.ejecutar(estadoAnterior, c);

            } else {

                // la AS no va a devolver nada
                // ejecutar AccionSemantica[estadoActual][cTraducida](estadoAnterior, c);
                AS.ejecutar(estadoAnterior, c);
            }
        }

        return null;
        // TODO : Hacer Handling de lexema sin final
    }
}