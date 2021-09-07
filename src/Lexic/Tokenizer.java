package Lexic;

import Lexic.AccionSemantica.*;
import Lexic.ConversorSimbolos.ConversorSimbolos;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.io.FileReader;

public class Tokenizer {

    final static String FILE_PATH = "src/input.txt";
    private static List<Character> values = new ArrayList<>();
    final int ESTADO_INICIAL = 0;

    // matrizDeTransicionEstados[estado_actual][simbolo]
    // F=-1  | Y = -2  |  Z = -3
    // l= 1  | L = 2   |  d = 3
    private final int[][] matrizDeTransicionEstados = {
           // 0  1  2   3  4   5
            {-1, 1, 1, -2, 1, -3},
            {-1, 1, 1,  1, 1, -1}
    };

    private final AccionSemantica[][] matrizDeTransicionAS = {
            {new AS1(), new AS2(), new AS2(), new ASY(), new AS2(), new ASZ()},
            {new AS4(), new AS3(), new AS3(), new AS3(), new AS3(), new AS4()}
    };
    private final Map<String,Integer> tokens = new HashMap<>();

    int estado_actual = 0;
    // TODO: Tiene que pasarse por parametro

    public Tokenizer(){
        loadValues();
        tokenize();
    }

    private static void loadValues() {
        File file = new File(FILE_PATH);

        try (FileReader fr = new FileReader(file))
        {
            int content;
            while ((content = fr.read()) != -1) {
                values.add((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean eof(int index){
        return index == values.size();
    }

    public boolean tokenize(){

        int index = 0;
        Character simb_actual;
        AccionSemantica accionSemantica;
        String tipoToken = "";
        String token_actual = "";

        // Quedan letras en el archivo generico
        while(!eof(index)){

            //Hay que indicar la representacion
            // l= 1  | L = 2   |  d = 3
            simb_actual = values.get(index);
            int indexSimbolo = ConversorSimbolos.convertirSimbolo(simb_actual);
            accionSemantica = matrizDeTransicionAS[estado_actual][indexSimbolo];
            accionSemantica.ejecutar(simb_actual,token_actual,tokens);
            index++;
        }

        return true;
    }

/*
    while simb not $:  # Pesos significa que termino el archivo
        # Por cada simbolo del archivo
        # llegar al primer simbolo
        while(todos los blancos):
    avanzar
        # iterar hasta llegar a F, o obtener un caracter invalido
        while(()):
            if (pertenece(simb)):  # Verifica que el simbolo sea parte del diccionario aceptado
                # Si es parte del diccionario aceptado, se pasa al estado correspondiente
    as = matrizDeTransicionAS[estado_actual][simb]
    as()  # Los datos necesarios para cada accion semantica se obtienen a partir de la clase
    estado_actual = matrizDeTransicion[estado_actual][simb]
            else:
    tirarWarningPorCaracterNoValido()
        # si el estado es F, -> termine, agrego Map<id, num>

    # Simbolos acpetados por el automata como miembros del token L l d _
    # Simbolos que son acpetados pero terminan un token, que son C - L l d c _
    # Simbolos ilegales que tiran warning?

            # CONSUMIDOR PIDE A TOKENIZER??? ( [1,a][2,5][3,_a_w_69][if])

            # Ejemplo --> "SIMBOLO"*/
}
