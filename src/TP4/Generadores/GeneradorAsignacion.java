package TP4.Generadores;

import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP4.GeneradorASM;

import static TP4.GeneradorASM.pila_variables;

public class GeneradorAsignacion {
    public static String getASM() {

        //Op1 es el lado izquierdo de la asignacion
        String asm = "";
        RegistroTS op1 = (RegistroTS) GeneradorASM.pila_variables.pop();
        RegistroTS op2 = (RegistroTS) GeneradorASM.pila_variables.pop();

        boolean op1Double = (op1.getTipo().equals(String.valueOf(Parser.DOUBLE)) || op1.getTipo().equals(String.valueOf(Parser.CTE_DOUBLE)));
        boolean op2Double = (op2.getTipo().equals(String.valueOf(Parser.DOUBLE)) || op2.getTipo().equals(String.valueOf(Parser.CTE_DOUBLE)));

        // Verificacion de conversion previa implicita antes de la generacion del codigo ASM
        boolean convertirOp2aDouble = op1Double && !op2Double;

        boolean convertirOp1aDouble = !op1Double && op2Double;


        //determinamos como debemos escribir los operandos en Asm.
        String sOp1 ="";
        String sOp2 ="";


        switch (op1.getUso()){
            case "parametro":
            case "variable":
                if(op1.getLexema().startsWith("@")){ //el op es una variable auxiliar.
                    sOp1 = op1.getLexema();
                } else { //es una variable normal
                    sOp1 = "_" + op1.getLexema();
                }
                break;
            case "cte":
                if(op1Double){ //si es una cte double, usamos la variable ASM que se declaro para almacenar esa CTE.
                    sOp1 = "var" + op1.getLexema().replaceAll("[-+\\.]", "");
                } else { //sino, la variable entera
                    sOp1 = "var" + op1.getLexema();
                }
        }

        switch (op2.getUso()){
            case "parametro":
            case "variable":
                if(op2.getLexema().startsWith("@")){ //el op es una variable auxiliar.
                    sOp2 = op2.getLexema();
                } else { //es una variable normal
                    sOp2 = "_" + op2.getLexema();
                }
                break;
            case "cte":
                if(op1Double){ //si es una cte double, usamos la variable ASM que se declaro para almacenar esa CTE.
                    sOp2 = "var" + op2.getLexema().replaceAll("[-+\\.]", "");
                } else { //sino, la variable entera
                    sOp2 = "var" + op2.getLexema();
                }
        }

        boolean opFloat = op1Double || op2Double;

        //Si los operandos son flotantes, cargamos la pila y hacemos la multiplicacionb.

        if (opFloat) {
            if (convertirOp2aDouble) { //Lado derecho debe hacerse double
                asm =   "FILD " +sOp2 + '\n' +
                        "FSTP " + sOp1 + '\n'; // Guardamos en op1 la variable de punto flotante cargada por el FILD
            } else if (convertirOp1aDouble){ //se tiene que convertir el lado izq (error)
               asm = "JMP IncompTipos \n";
            } else { //No se cargo nada en ST
                asm =   "FLD " + sOp2 + '\n' + // cargamos op2 en la pila
                        "FSTP " + sOp1 + '\n'; // lo movemos a op1
            }
        } else { //ambos operandos son enteros
            asm =   "MOV AX, " + sOp2 + '\n' +
                    "MOV " + sOp1 + ", AX" +'\n' ; //movemos a op1 lo que este en op2
        }

        return asm;
    }
}
