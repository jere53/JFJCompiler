package TP4.Generadores;

import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP4.GeneradorASM;
import TP4.InstruccionASM;

import static TP4.GeneradorASM.pila_variables;

public class GeneradorDivision {

    public static String getASM() {
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

        boolean op1Inmediate = !(op1.getUso().equals("variable") || op1.getUso().equals("parametro"));
        boolean op2Inmediate = !(op2.getUso().equals("variable") || op2.getUso().equals("parametro"));

        //Si los operandos son flotantes, cargamos la pila y hacemos la division.

        if (opFloat) {
            if (convertirOp1aDouble) { //significa que ya se hizo el FILD de OP1
                asm =   "FILD " +sOp1 + '\n' +
                        "FLD " + sOp2 + '\n' + // cargamos el segundo operando en la pila.
                        "FTST " +'\n' + //Revisamos que el divisopr no sea 0
                        "JZ DivZero" +'\n' +
                        "FDIV" + '\n' + // Dividimos Op1/Op2 (ST(1)/ST)
                        "FSTP " + nombre_auxiliar + '\n'; // Guardar en una variable aux el resultado.
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.DOUBLE));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            } else if(convertirOp2aDouble) { //significa que ya se hizo el FILD de OP2
                asm =   "FILD " +sOp2 + '\n' +
                        "FTST " +'\n' + //Revisamos que el divisopr no sea 0
                        "JZ DivZero" +'\n' +
                        "FLD " + sOp1 + '\n' + //  cargamos el primer operando en la pila.
                        "FXCH" + '\n' + // Cambiamos ST por ST(1) para que nos queden en orden los operandos (<tope>Op2, Op1 <base>)
                        "FDIV" + '\n' + // Dividimos Op1/Op2 (ST(1)/ST)
                        "FSTP " + nombre_auxiliar + '\n'; // Guardar en una variable aux el resultado.
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.DOUBLE));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            } else { //No se cargo nada en ST
                asm = "FLD " + sOp1 + '\n' + // cargamos los operandos
                        "FLD " + sOp2 + '\n' +
                        "FTST " +'\n' + //Revisamos que el divisopr no sea 0
                        "JZ DivZero" +'\n' +
                        "FDIV" + '\n' + // Dividimos Op1/Op2
                        "FSTP " + nombre_auxiliar + '\n'; // Guardar en una variable aux el resultado.
                TablaSimbolos.altaTS(nombre_auxiliar);
                TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.DOUBLE));
                TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
            }
        } else { //ambos operandos son enteros
            asm =   "CMP " + sOp2 + " , 0" + '\n' + //revisamos que no se este dividiendo por 0
                    "JZ DivZero" + '\n' +
                    "MOV AX, " + sOp1 + '\n' +
                    "CWD" + '\n' + //extendemos AX a AX:DX
                    "DIV " + sOp2 + '\n' + //hacemos op1 (AX) / op2
                    "MOV " + nombre_auxiliar + ", AX" + '\n';
            TablaSimbolos.altaTS(nombre_auxiliar);
            TablaSimbolos.punteroTS(nombre_auxiliar).setTipo(String.valueOf(Parser.UINT));
            TablaSimbolos.punteroTS(nombre_auxiliar).setUso("variable");
        }

        pila_variables.push(TablaSimbolos.punteroTS(nombre_auxiliar));

        if (TablaSimbolos.punteroTS(nombre_auxiliar) == null){
            System.out.println("Se agrego null en dIV" );
        }

        return asm;
    }
}
