package TP4.Generadores;

import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP4.GeneradorASM;

public class GeneradorAsignacion {
    public static String getASM() {
        RegistroTS op1 = (RegistroTS) GeneradorASM.pila_variables.pop();
        RegistroTS op2 = (RegistroTS) GeneradorASM.pila_variables.pop();
        if (op1 == null || op2 == null) System.out.println("HAY UN OPERADOR NULL");
        // Verificacion de conversion previa implicita antes de la generacion del codigo ASM
        boolean convertirOp2aDouble = (op1.getTipo().equals(String.valueOf(Parser.DOUBLE)) || op1.getTipo().equals(String.valueOf(Parser.CTE_DOUBLE)))
                && (op2.getTipo().equals(String.valueOf(Parser.UINT)) || op2.getTipo().equals(String.valueOf(Parser.CTE_UINT)));



        boolean convertirOp1aDouble =  (op2.getTipo().equals(String.valueOf(Parser.DOUBLE)) || op2.getTipo().equals(String.valueOf(Parser.CTE_DOUBLE)))
                && (op1.getTipo().equals(String.valueOf(Parser.UINT)) || op1.getTipo().equals(String.valueOf(Parser.CTE_UINT)));

        if (convertirOp1aDouble){
            // Convertir op1 a DOUBLE
        }

        if (convertirOp2aDouble){
            // Convertir op2 a Double
        }

        boolean opFloat = (op2.getTipo().equals(String.valueOf(Parser.DOUBLE)) || op2.getTipo().equals(String.valueOf(Parser.CTE_DOUBLE)))
                || (op1.getTipo().equals(String.valueOf(Parser.DOUBLE)) || op1.getTipo().equals(String.valueOf(Parser.CTE_DOUBLE)));


        String asm = "";

        String nombre_auxiliar = "@aux" + GeneradorASM.numeroVar++; // Nombre del nuevo registro que almacenara el resultado

        boolean op2Inmediate = !(op2.getUso().equals("variable") || op2.getUso().equals("parametro"));

        if (opFloat) {
           if(op2Inmediate) {
                asm = "FILD " + op2.getLexema() + '\n' + // Mover al registro EBX el operador 1
                        "FSTP _" + op1.getLexema() + '\n'; // Generar el resultado de la operacion sobre EBX
            } else {
               asm = "FLD _" + op2.getLexema() + '\n' + // Mover al registro EBX el operador 1
                       "FSTP _" + op1.getLexema() + '\n'; // Generar el resultado de la operacion sobre EBX
           }
        } else {
            if (op2Inmediate){
                asm = "MOV BX, " + op2.getLexema() + '\n' +
                        "MOV _" + op1.getLexema() + ", BX" + '\n';
            } else {
                asm = "MOV BX, _" + op2.getLexema() + '\n' +
                        "MOV _" + op1.getLexema() + ", BX" + '\n';
            }
        }

        return asm;
    }
}
