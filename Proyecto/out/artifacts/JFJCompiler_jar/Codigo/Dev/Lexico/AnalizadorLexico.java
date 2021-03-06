package Dev.Lexico;

import Dev.RegistroTS;
import Dev.Lexico.AccionesSemanticas.*;

import java.io.FileWriter;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;

public class AnalizadorLexico {

    private static final String outputFilePath = "salida.txt";

    public static FileWriter outputWriter;

    public static void inic(){
        loadValues();
        try {
            File file = new File(outputFilePath);
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
            outputWriter = new FileWriter(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private AnalizadorLexico() {

    }

    private static final int estadoFinal = 16;

    //region Matrices
    private static final int[][] matrizDeTransicionEstados = {
        {1,1,1,2,estadoFinal,estadoFinal,estadoFinal,0,0,0,6,15,3,9,10,11,12,13,14,estadoFinal}, //0
        {1,estadoFinal,1,1,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {estadoFinal,estadoFinal,estadoFinal,2,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,3,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {4,4,estadoFinal,3,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {estadoFinal,estadoFinal,estadoFinal,4,estadoFinal,estadoFinal,5,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {estadoFinal,estadoFinal,estadoFinal,5,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,7,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {7,7,7,7,7,7,7,7,7,7,8,7,7,7,7,7,7,7,7,-1}, //7
        {7,7,7,7,7,7,7,7,7,7,0,7,7,7,7,7,7,7,7,-1}, // 8
        {estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal,estadoFinal},
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal,-1,-1,-1}, //12
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal,-1,-1}, //13
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,estadoFinal,-1}, //14
        {15,15,15,15,15,15,15,15,-1,15,15,estadoFinal,15,15,15,15,15,15,15,-1} //15
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
        {AS5, AS5, AS5, AS3, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS3, AS5, AS5, AS5, AS5, AS5, AS5, AS5}, //2
        {AS3, AS3, AS5, AS3, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5},//3
        {AS5, AS5, AS5, AS3, AS5, AS5, AS3, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5},//4
        {AS5, AS5, AS5, AS3, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5},//5
        {AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6, null, AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6, AS6},//6
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},//7
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},//8
        {AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1, AS1},//9
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
3         AS3   AS3	    AS3	AS5			AS5	AS5
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

    public static int indiceUltimoLeido = 0;

    public static String lexema;

    public static Set<String> tokensReconocidos = new HashSet<>();

    public static List<String> estructurasReconocidas = new ArrayList<>();

    public static List<String> errores = new ArrayList<>();

    //region FileRead

    public static String FILE_PATH = "";

    private static void loadValues() {
        File file = new File(FILE_PATH);
        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                if ((char) content == '\r') continue;
                codigoFuente.add((char) content);
            }
            codigoFuente.add('$'); //agregamos el simbolo EOF
        } catch (IOException e) {
            System.out.println("Archivo invalido (IOException)");
            System.exit(1);
            e.printStackTrace();
        }
    }

    //endregion

    public static void InicNuevoLexema() {
        lexema = "";
    }

    public static void agregarCharALexema(Character c) {
        lexema += c;
    }

    public static int traducirCaracter(Character c) {
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

    public static int nroLinea = 1;

    public static String mostrarErrores(){
        String res = "";
        for(String s : errores){
            res += s + '\n';
        }
        return res;
    }

    /**
     * Encontrar en la sublist y encontrar el respectivo subindice.
     */
    public static void avanzarASincronizador() {
        //TODO: DEBUGGEAR ESTO

        // Agarrar la sublist y encontrar el indic
        int indiceSinc = codigoFuente.subList(indiceUltimoLeido, codigoFuente.size() -1).indexOf(';');
        if (indiceSinc == -1){
            //no hay un ; al cual ir, avanzamos al proximo caracter
            indiceUltimoLeido++;
        }
        indiceUltimoLeido = indiceSinc;
    }

    // en realidad devuelve Token+Puntero a TS

    public static Dupla<Integer, RegistroTS> producirToken() {

        //producirToken se llama una vez por lexema. Si hay un error lexico, se lanza una excepcion que indica cual
        //fue el error, para mostrarlo. El A.S. luego ejecuta el producirToken de nuevo, ahora sobre la proxima letra,
        //partiendo desde el estado inicial. el String lexema se vacia, y se incrementa el indiceUltimoLeido.

        int estadoActual = 0;
        int leidos = 0;
        int estadoAnterior;

        int cIndex;

        for (Character c : codigoFuente.subList(indiceUltimoLeido, codigoFuente.size() - 1)) {

            cIndex = traducirCaracter(c); // traducir c a un indice en la matriz
            if (cIndex == -1){
                //caracter invalido, se ignora y se pasa al siguiente
                errores.add("caracter invalido en la linea " + nroLinea + "\n");
                leidos++;
                continue;
            }
            
            estadoAnterior = estadoActual;
            
            estadoActual = matrizDeTransicionEstados[estadoAnterior][cIndex]; // obtener el estado siguiente

            leidos++;

            if (c.equals('\n')) {
                // Para que no cuente los saltos de linea mas de una vez si devuelve un caracter a la entrada,
                // despues de actualizar el numero de linea cambiamos el \n por un \t para que no lo vuelva a contar.
                // el \t es equivalente al \n excepto en el caso de la Cadena de caracteres, pero como en el estado
                // que corresponde a la Cadena se usa la AS3, que no devuelve el char a la entrada, no hay problema.
                //
                codigoFuente.set(indiceUltimoLeido + leidos - 1, '\t');
                nroLinea++;
            }

            if (estadoActual == -1){
                //error lexico
                switch(estadoAnterior){
                    //estados 0-6 no pueden transicionar al -1
                    case 7: // 7 y 8 solo van al -1 ante $
                        errores.add("Lexic error on line " + nroLinea + ": " + "unexpected EoF\n");
                    case 8:
                        errores.add("Lexic error on line " + nroLinea + ": " + "unexpected EoF\n");
                    //estados 9-11 no pueden transicionar al -1
                    case 12:
                        errores.add("Lexic error on line " + nroLinea + ": " + "'=' expected but got " + c + " instead\n");
                    case 13:
                        errores.add("Lexic error on line " + nroLinea + ": " + "'&' expected but got " + c + " instead\n");
                    case 14:
                        errores.add("Lexic error on line " + nroLinea + ": " + "'|' expected but got " + c + " instead\n");
                    case 15:
                        errores.add("Lexic error on line " + nroLinea + ": " + "String cant contain new line char or EoF found\n");
                    default:
                        errores.add("\n");
                }
                return null;
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

        //aca llegamos al EOF.
        return new Dupla<>(0, null);
    }
}