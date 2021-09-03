package Lexic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.io.FileReader;
import java.util.Map;

public class Tokenizer {

    final static String FILE_PATH = "src/input.txt";
    private static List<Character> values = new ArrayList<>();
    final int ESTADO_INICIAL = 0;
    private int[][] matrizDeTransicionEstados = new int[10][];
    private AccionSemantica[][] matrizDeTransicionAS = new AccionSemantica[10][];
    private Map<String,Integer> tokens = new Map<String,Integer>;


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
        return index != values.size()-1;
    }

    public boolean tokenize(){
        int index = 0;
        Character simb_actual = values.get(0);
        AccionSemantica accionSemantica;
        String tipoToken;
        String token_actual = "";

        while(!eof(index)){
            while(!eof(index) && simb_actual != ' '){
                // Avanzo mientras haya blancos
                simb_actual = values.get(index);
                index++;
            }
            if(!eof(index)){
                // Quedan simbolos
                if(simboloValido(simb_actual)){
                    estado_actual = matrizDeTransicionEstados[estado_actual][simb_actual];
                    accionSemantica = matrizDeTransicionAS[estado_actual][simb_actual];
                    accionSemantica.ejecutar();
                }
                else{
                    // Preciso el numero de linea y el numero de caracter de la linea
                    //arrojarWarning();
                }
                if(estado_actual == 1){
                    tokens.put(tipoToken,token_actual);
                }
            }
        }
        for (Character value:values) {
            System.out.println(value);
        }
        return true;
    }

    private boolean simboloValido(Character simb_actual) {
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
