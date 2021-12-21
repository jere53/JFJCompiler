package TP4.Generadores;

import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;
import TP3.Polaca;
import TP4.GeneradorASM;
import TP4.InstruccionASM;

import static TP4.GeneradorASM.pila_variables;

public class GeneradorComparacion{
    public static String getASM(String comp, int indiceBF) {
        RegistroTS op1 = (RegistroTS) GeneradorASM.pila_variables.pop();
        RegistroTS op2 = (RegistroTS) GeneradorASM.pila_variables.pop();

        // Verificacion de conversion previa implicita antes de la generacion del codigo ASM
        boolean convertirOp2aDouble = (op1.getTipo().equals(String.valueOf(Parser.DOUBLE)) || op1.getTipo().equals(String.valueOf(Parser.CTE_DOUBLE)))
                && (op2.getTipo().equals(String.valueOf(Parser.UINT)) || op2.getTipo().equals(String.valueOf(Parser.CTE_UINT)));

        boolean convertirOp1aDouble = (op2.getTipo().equals(String.valueOf(Parser.DOUBLE)) || op2.getTipo().equals(String.valueOf(Parser.CTE_DOUBLE)))
                && (op1.getTipo().equals(String.valueOf(Parser.UINT)) || op1.getTipo().equals(String.valueOf(Parser.CTE_UINT)));

        if (convertirOp1aDouble) {
            // Convertir op1 a DOUBLE
        }

        if (convertirOp2aDouble) {
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
                        "FLD " + op2.getLexema() + '\n' + // Generar el resultado de la operacion sobre EBX
                        "FCOMP" + '\n';
                switch (comp) {
                    case "May":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MayI":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Men":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MenI":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Ig":
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Dist":
                        asm += "JNZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                }


            } else if (op1Inmediate) {
                asm = "FLD " + op1.getLexema() + '\n' + // Mover al registro EBX el operador 1
                        "FLD _" + op2.getLexema() + '\n' + // Generar el resultado de la operacion sobre EBX
                        "FCOMP " + nombre_auxiliar + '\n'; // Guardar en un registro lo que esta en EBX
                switch (comp) {
                    case "May":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MayI":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Men":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MenI":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Ig":
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Dist":
                        asm += "JNZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                }

            } else if (op2Inmediate) {
                asm = "FLD _" + op1.getLexema() + '\n' + // Mover al registro EBX el operador 1
                        "FLD " + op2.getLexema() + '\n' + // Generar el resultado de la operacion sobre EBX
                        "FCOMP " + nombre_auxiliar + '\n'; // Guardar en un registro lo que esta en EBX
                switch (comp) {
                    case "May":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MayI":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Men":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MenI":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Ig":
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Dist":
                        asm += "JNZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                }

            } else {
                asm = "FLD _" + op1.getLexema() + '\n' + // Mover al registro EBX el operador 1
                        "FLD _" + op2.getLexema() + '\n' + // Generar el resultado de la operacion sobre EBX
                        "FCOKP " + nombre_auxiliar + '\n'; // Guardar en un registro lo que esta en EBX
                switch (comp) {
                    case "May":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MayI":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Men":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MenI":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Ig":
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Dist":
                        asm += "JNZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                }

            }
        } else {
            if (op1Inmediate && op2Inmediate) {
                asm = "MOV BX, " + op1.getLexema() + '\n' +
                        "MOV AX, " + op2.getLexema() + '\n' +
                        "CMP " + "AX, " + " BX" + '\n'; // Guardar en un registro lo que esta en EBX
                switch (comp) {
                    case "May":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MayI":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Men":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MenI":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Ig":
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Dist":
                        asm += "JNZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                }

            } else if (op1Inmediate) {
                asm = "MOV BX, " + op1.getLexema() + '\n' +
                        "MOV AX, _" + op2.getLexema() + '\n' +
                        "CMP " + "AX, " + " BX" + '\n'; // Guardar en un registro lo que esta en EBX
                switch (comp) {
                    case "May":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MayI":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Men":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MenI":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Ig":
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Dist":
                        asm += "JNZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                }

            } else if (op2Inmediate) {
                asm = "MOV BX, _" + op1.getLexema() + '\n' +
                        "MOV AX, " + op2.getLexema() + '\n' +
                        "CMP " + "AX, " + " BX" + '\n'; // Guardar en un registro lo que esta en EBX
                switch (comp) {
                    case "May":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MayI":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Men":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MenI":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Ig":
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Dist":
                        asm += "JNZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                }

            } else {
                asm = "MOV BX, _" + op1.getLexema() + '\n' +
                        "MOV AX, _" + op2.getLexema() + '\n' +
                        "CMP " + "AX, " + " BX" + '\n'; // Guardar en un registro lo que esta en EBX
                switch (comp) {
                    case "May":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MayI":
                        asm += "JS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Men":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "MenI":
                        asm += "JNS " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Ig":
                        asm += "JZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                    case "Dist":
                        asm += "JNZ " + "L" + Polaca.getRepresentacionIntermedia().get(indiceBF - 1);
                        return asm;
                }

            }

        }

        return asm;
    }
}
