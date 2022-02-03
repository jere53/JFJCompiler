package TP4.Generadores;

import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP3.Polaca;
import TP4.GeneradorASM;
import TP4.InstruccionASM;

import static TP4.GeneradorASM.pila_variables;

public class GeneradorComparacion{
    public static String getASM(String comp) {

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


        String nombre_auxiliar = "@aux" + GeneradorASM.numeroVar++; // Nombre de la variable aux que almacenara el resultado

        //Si los operandos son flotantes, cargamos la pila y hacemos la multiplicacionb.

        /*
        FCOMI: Source = ST1

        Comparison 	ZF	PF	CF
        ST0 > ST(i)	0	0	0
        ST0 < ST(i)	0	0	1
        ST0 = ST(i)	1	0	0
        Unordered*	1	1	1
        NOTE: * Flags not set if unmasked invalid-arithmetic-operand (#IA) exception is generated.


         */

        //determinamos que instruccion de salto usar.
        String tipoSalto = "";

        switch (comp){
            case "May":
                //La condicion es verdadera si ZF,PF, y CF son 0. (mayor). Equivalentemente, saltamos sii ZF y CF tienen un 0. Esto es un JA, Jump Avobe
                //Entonces, JA: ponemos una variable aux con el resultado de la comparacion en 1. Sino es 0.
                tipoSalto = "JA";
                break;
            case "MayI":
                //La condicion es verdadera sii CF es un 0. Esto es un JNC, Jump if Not Carry.
                tipoSalto = "JNC";
                break;
            case "Men":
                //Sii CF es un 1. Es un JC, Jump if Carry.
                tipoSalto = "JC";
                break;
            case "MenI":
                //Sii ZF o CF son 1. Es un JNA, Jump if Not Avobe.
                tipoSalto = "JNA";
                break;
            case "Ig":
                //Sii ZF es 1. Es un JZ, Jump if Zero.
                tipoSalto = "JZ";
                break;
            case "Dist":
                //Sii ZF es 0. Es un JNZ, Jump if Not Zero
                tipoSalto = "JNZ";
                break;
        }

        if (opFloat) {
            if (convertirOp1aDouble) { //significa que ya se hizo el FILD de OP1
                asm =   "FILD " +sOp1 + '\n' + //ST1
                        "FLD " + sOp2 + '\n' + // ST
                        "MOV " + nombre_auxiliar + ", 1" + '\n' + //Asumo comparacion es true.
                        "FCOMP" + '\n' + "FSTSW AX" +'\n'+ "SAHF \n" +

                        tipoSalto + " L"+nombre_auxiliar+'\n'+ //si no fue true, setteamos el resultado en falso
                        "MOV " +nombre_auxiliar + ", 0" + '\n' +
                        "L" + nombre_auxiliar +":" + '\n';
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo("asm_bool");
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("asm_control");
            } else if(convertirOp2aDouble) { //significa que ya se hizo el FILD de OP2
                asm =   "FLD " +sOp1 + '\n' + //ST1
                        "FILD " + sOp2 + '\n' + // ST
                        "MOV " + nombre_auxiliar + ", 1" + '\n' +
                        "FCOMP" + '\n' + "FSTSW AX" +'\n'+ "SAHF \n" +
                        tipoSalto + " L"+nombre_auxiliar+'\n'+
                        "MOV " +nombre_auxiliar + ", 0" + '\n' +
                        "L" + nombre_auxiliar +":" + '\n';
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo("asm_bool");
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("asm_control");
            } else { //No se cargo nada en ST
                asm =   "FLD " +sOp1 + '\n' + //ST1
                        "FLD " + sOp2 + '\n' + // ST
                        "MOV " + nombre_auxiliar + ", 1" + '\n' +
                        "FCOMP" + '\n' + "FSTSW AX" +'\n'+ "SAHF \n" +
                        tipoSalto +" L"+nombre_auxiliar+'\n'+
                        "MOV " +nombre_auxiliar + ", 0" + '\n' +
                        "L" + nombre_auxiliar +":" + '\n';
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo("asm_bool");
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("asm_control");
            }
        } else { //ambos operandos son enteros
            asm =   "MOV AX, " + sOp1 + '\n' +
                    "MOV " + nombre_auxiliar + ", 1" + '\n' +
                    "CMP AX, " + sOp2 + '\n' + //hacemos op1 (AX) - op2
                    tipoSalto +" L"+nombre_auxiliar+'\n'+
                    "MOV " +nombre_auxiliar + ", 0" + '\n' +
                    "L" + nombre_auxiliar +":" + '\n';
            TablaSimbolos.altaTS(nombre_auxiliar);
            TablaSimbolos.punteroTS(nombre_auxiliar).setTipo("asm_bool");
            TablaSimbolos.punteroTS(nombre_auxiliar).setUso("asm_control");
        }

        pila_variables.push(TablaSimbolos.punteroTS(nombre_auxiliar));

        if (TablaSimbolos.punteroTS(nombre_auxiliar) == null){
            System.out.println("Se agrego null en Comparacion" );
        }

        return asm;
    }

}
