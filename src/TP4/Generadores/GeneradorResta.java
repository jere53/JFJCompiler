package TP4.Generadores;

import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP4.GeneradorASM;
import TP4.InstruccionASM;

import static TP4.GeneradorASM.pila_variables;

public class GeneradorResta {
    public static String getASM() {
        RegistroTS op1 = (RegistroTS) GeneradorASM.pila_variables.pop();
        RegistroTS op2 = (RegistroTS) GeneradorASM.pila_variables.pop();

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

        boolean op1Inmediate = !(op1.getUso().equals("variable") || op1.getUso().equals("parametro"));
        boolean op2Inmediate = !(op2.getUso().equals("variable") || op2.getUso().equals("parametro"));

        if (opFloat) {
            if (op1Inmediate && op2Inmediate) {
                asm = "FLD " + op1.getLexema() + '\n' + // Mover al registro EBX el operador 1
                        "FSUB " + op2.getLexema() + '\n' + // Generar el resultado de la operacion sobre EBX
                        "FSTP " + nombre_auxiliar + '\n'; // Guardar en un registro lo que esta en EBX
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.DOUBLE));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            } else if(op1Inmediate) {
                asm = "FLD " + op1.getLexema() + '\n' + // Mover al registro EBX el operador 1
                        "FSUB _" + op2.getLexema() + '\n' + // Generar el resultado de la operacion sobre EBX
                        "FSTP " + nombre_auxiliar + '\n'; // Guardar en un registro lo que esta en EBX
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.DOUBLE));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            } else if (op2Inmediate){
                asm = "FLD _" + op1.getLexema() + '\n' + // Mover al registro EBX el operador 1
                        "FISUB " + op2.getLexema() + '\n' + // Generar el resultado de la operacion sobre EBX
                        "FSTP " + nombre_auxiliar + '\n'; // Guardar en un registro lo que esta en EBX
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.DOUBLE));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            } else {
                asm = "FLD _" + op1.getLexema() + '\n' + // Mover al registro EBX el operador 1
                        "FSUB _" + op2.getLexema() + '\n' + // Generar el resultado de la operacion sobre EBX
                        "FSTP " + nombre_auxiliar + '\n'; // Guardar en un registro lo que esta en EBX
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.DOUBLE));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            }
        } else {
            if (op1Inmediate && op2Inmediate) {
                asm = "MOV BX, " + op1.getLexema() + '\n' +
                        "SUBI BX, " + op2.getLexema() + '\n' +
                        "MOV " + nombre_auxiliar + " BX"+'\n'; // Guardar en un registro lo que esta en EBX
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.UINT));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            } else if (op1Inmediate){
                asm = "MOV BX, " + op1.getLexema() + '\n' +
                        "SUB BX, _" + op2.getLexema() + '\n' +
                        "MOV " + nombre_auxiliar + " BX"+'\n'; // Guardar en un registro lo que esta en EBX
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.UINT));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            } else if (op2Inmediate) {
                asm = "MOV BX, _" + op1.getLexema() + '\n' +
                        "SUBI BX, " + op2.getLexema() + '\n' +
                        "MOV " + nombre_auxiliar + " BX"+ '\n'; // Guardar en un registro lo que esta en EBX
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.UINT));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            } else {
                asm = "MOV BX, _" + op1.getLexema() + '\n' +
                        "SUB BX, _" + op2.getLexema() + '\n' +
                        "MOV " + nombre_auxiliar + " BX"+ '\n'; // Guardar en un registro lo que esta en EBX
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.UINT));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            }

        }

        pila_variables.push(TablaSimbolos.punteroTS(nombre_auxiliar));
        if (TablaSimbolos.punteroTS(nombre_auxiliar) == null){
            System.out.println("Se agrego null en RESTA" );
        }
        return asm;
    }
}
