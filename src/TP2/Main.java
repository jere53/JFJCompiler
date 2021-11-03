package TP2;

import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP2.BYACC.ParserVal;
import TP3.Polaca;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AnalizadorLexico.FILE_PATH = "C:\\Users\\jerem\\IdeaProjects\\JFJCompiler\\src\\input.txt"; //args[0];
        AnalizadorLexico.inic(); //carga el archivo con el codigo fuente e inicializa el archivo con la salida
        TablaSimbolos.CargarTablaPalabrasReservadas();
        new Parser().run();
        //Pasamos la TS al archivo de salida y lo cerramos.
        try {
            AnalizadorLexico.outputWriter.append("-----Tokens Reconocidos-----" + '\n');
            AnalizadorLexico.outputWriter.append(AnalizadorLexico.tokensReconocidos.toString() + '\n');
            AnalizadorLexico.outputWriter.append("-----Estructuras Sintacticas-----" + '\n');
            AnalizadorLexico.outputWriter.append(AnalizadorLexico.estructurasReconocidas.toString() + '\n');
            AnalizadorLexico.outputWriter.append("-----Tabla Simbolos-----" + '\n');
            AnalizadorLexico.outputWriter.append(TablaSimbolos.mostrarTS() + '\n');
            AnalizadorLexico.outputWriter.append("-------Errores-------" + '\n');
            AnalizadorLexico.outputWriter.append(AnalizadorLexico.errores.toString() +  '\n');
            AnalizadorLexico.outputWriter.append("--------CodigoIntermedio--------" + '\n');
            AnalizadorLexico.outputWriter.append(Polaca.imprimirPolaca());
            AnalizadorLexico.outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


