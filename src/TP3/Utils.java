package TP3;

import Dev.Lexico.TablaSimbolos;
import Dev.RegistroTS;
import TP2.BYACC.Parser;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static List<String> listaVariablesTemp = new ArrayList<>();
    private static String idFuncCacheado;

    public static void agregarAListaDeVariables(String variable){
        listaVariablesTemp.add(variable);
    }

    public static void asignarTipoListaDeVariables(String tipo){
        for (String s : listaVariablesTemp) {
            TablaSimbolos.punteroTS(s).setTipo(tipo);
        }
        listaVariablesTemp = new ArrayList<>();
    }

    public static void setTipoIDFuncionCacheado(String t){
        TablaSimbolos.punteroTS(idFuncCacheado).setTipo(t);
    }

    public static void cachearIDFuncion(String s){
        idFuncCacheado = s;
    }

    public static String signoNegativo(String s){
        Polaca.removerUltimo();
        //si ya era negativa, queda positiva y no agregamos nada a la TS
        if (s.startsWith("-"))
            return s.substring(1);

        String res = "-" + s;

        if (!TablaSimbolos.perteneceTS(res)) {
            RegistroTS punteroOriginal = TablaSimbolos.punteroTS(s);
            TablaSimbolos.altaTS(res);
            if (punteroOriginal.getTipo().equals(Integer.toString(Parser.CTE_UINT))) {
                TablaSimbolos.punteroTS(res).setTipo(Integer.toString(Parser.ERR_CTE_FUERA_RANGO));
                TablaSimbolos.punteroTS(res).setUso("error");
            }
            if (punteroOriginal.getTipo().equals(Integer.toString(Parser.CTE_DOUBLE))) {
                TablaSimbolos.punteroTS(res).setTipo(Integer.toString(Parser.CTE_DOUBLE));
                TablaSimbolos.punteroTS(res).setUso(punteroOriginal.getUso());
            }
        }

        return res;
    }
}
