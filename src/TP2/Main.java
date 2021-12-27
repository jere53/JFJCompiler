package TP2;

import Dev.Lexico.AnalizadorLexico;
import Dev.Lexico.Dupla;
import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP2.BYACC.ParserVal;
import TP3.Polaca;
import TP4.GeneradorASM;
import sun.security.jgss.wrapper.GSSNameElement;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AnalizadorLexico.FILE_PATH = "C:\\Users\\jerem\\IdeaProjects\\JFJCompiler\\src\\input.txt";//args[0];
        AnalizadorLexico.inic(); //carga el archivo con el codigo fuente e inicializa el archivo con la salida
        TablaSimbolos.CargarTablaPalabrasReservadas();
        new Parser().run();
        //Pasamos la TS al archivo de salida y lo cerramos.
        try {
            AnalizadorLexico.outputWriter.append("-----Tabla Simbolos-----" + '\n');
            AnalizadorLexico.outputWriter.append(TablaSimbolos.mostrarTS() + '\n');
            AnalizadorLexico.outputWriter.append("-------Errores-------" + '\n');
            AnalizadorLexico.outputWriter.append(AnalizadorLexico.mostrarErrores() +  '\n');
            AnalizadorLexico.outputWriter.append("--------CodigoIntermedio--------" + '\n');
            AnalizadorLexico.outputWriter.append(Polaca.imprimirPolaca());

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(AnalizadorLexico.errores.size() == 0) {

            // Generamos ASM
            GeneradorASM.inic();
            //Los nombres del NameMangling rompen el ASM porque tienene el caracter ":", entonces modificamos los nombres de la TS primero.
            Object[] lexemas = TablaSimbolos.getTabla().keySet().toArray();
            for(Object o : lexemas){
                TablaSimbolos.cambiarNombre(o.toString(),o.toString().replaceAll(":", ""));
            }


            GeneradorASM.generarASM();

            try {
                GeneradorASM.outputWriter.append(GeneradorASM.get_asm());
                GeneradorASM.outputWriter.close();

                AnalizadorLexico.outputWriter.append("\n-----Tabla Simbolos ASM-----" + '\n');
                AnalizadorLexico.outputWriter.append(TablaSimbolos.mostrarTS() + '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try{
            AnalizadorLexico.outputWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }



    }
}


