%{
	package TP2.BYACC;
	import Dev.Lexico.AnalizadorLexico;
	import Dev.Lexico.Dupla;
	import Dev.Lexico.TablaSimbolos;
	import Dev.RegistroTS;
	import TP3.Polaca;
	import TP3.Utils;
%}

%token UINT, DOUBLE, BEGIN, RETURN, END, POST, ID, FUNC, CTE_UINT, CTE_DOUBLE, CADENA, PRINT, REPEAT , UNTIL, THEN, IF , ELSE, ASIG, AND, OR, COMP_MAYOR_IGUAL, COMP_MENOR_IGUAL, COMP_IGUAL, COMP_DISTINTO, ENDIF, BREAK, ERR_CTE_FUERA_RANGO, ERR_FORMATO_CTE

%start program

%%
program 						: declaracion bloque_sentencias //como en Pascal "program mi_prog;"'
								| bloque_sentencias
								;

bloque_sentencias 				: BEGIN sentencia_ejec END ';'
				  				| miembro_sentencia_ejec
								;
			
tipo_id							: UINT
								| DOUBLE
								| FUNC
								;
								
cuerpo_func  					: BEGIN sentencia_ejec RETURN retorno END
                        		| BEGIN sentencia_ejec RETURN retorno post_condicion END
								;

post_condicion          		: POST ':' condicion ',' CADENA ';'
								;

retorno             			: '(' expresion ')' ';'
								;

declaracion 					: tipo_id nombre_func params_func definicion_func ';' {}
								| tipo_id lista_variables ';'
								| tipo_id lista_variables ';' declaracion
								| tipo_id nombre_func params_func definicion_func ';' declaracion
								;

lista_variables					: ID {}
								| ID ',' lista_variables {}
								;	

nombre_func						: FUNC ID {}
								| FUNC {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el identificador del procedimiento.");}
								;
			
params_func						: '(' param ')'
								| '(' ')'
								;

param 							: tipo_id ID
		    					;
		
definicion_func					: declaracion cuerpo_func
								| cuerpo_func
								| {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Cuerpo del procedimiento vacio.");}
								;

sentencia_ejec					: miembro_sentencia_ejec sentencia_ejec
								| miembro_sentencia_ejec
								;

miembro_sentencia_ejec 			: invocacion ';' {AnalizadorLexico.estructurasReconocidas.add("Invocacion en la linea " + AnalizadorLexico.nroLinea);}
                       			| asignacion ';' {AnalizadorLexico.estructurasReconocidas.add("Asignacion en la linea " + AnalizadorLexico.nroLinea);}
                       			| iteracion ';' {AnalizadorLexico.estructurasReconocidas.add("Iteracion en la linea " + AnalizadorLexico.nroLinea);}
                       			| seleccion ';' {AnalizadorLexico.estructurasReconocidas.add("Seleccion (IF) en la linea " + AnalizadorLexico.nroLinea);}
                       			| impresion ';' {AnalizadorLexico.estructurasReconocidas.add("Impresion en la linea " + AnalizadorLexico.nroLinea);}
								| BREAK ';'
								| seleccion miembro_sentencia_ejec {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
                       			| invocacion miembro_sentencia_ejec {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
                       			| asignacion miembro_sentencia_ejec {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
                       			| iteracion miembro_sentencia_ejec {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
                       			| impresion miembro_sentencia_ejec {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
                       			| BREAK miembro_sentencia_ejec {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
                       			;

invocacion						: ID '(' ')' {}
								| ID '(' ID ')' {}
								;

asignacion						: ID ASIG expresion //{Polaca.insert(new RegistroTS(":="));} usamos un RegistroTS para que tenga el mismo tipo, en realidad puede ser el lexema solo.
            					| ID ASIG error {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
            					| ID {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
            					| error ASIG expresion {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
            					;
			
expresion						: expresion '+' termino //{Polaca.insert(new RegistroTS("+"));}
								| expresion '-' termino //{Polaca.insert(new RegistroTS("-"));}
	        					| termino
								;

termino							: termino '*' factor //{Polaca.insert(new RegistroTS("*"));}
								| termino '/' factor //{Polaca.insert(new RegistroTS("/"));}
								| factor
     							;	
		
factor 							: ID //{Polaca.insert(TablaSimbolos.punteroTS($1.sval));}
								| CTE_UINT //{Polaca.insert(TablaSimbolos.punteroTS($1.sval));}
								| CTE_DOUBLE //{Polaca.insert(TablaSimbolos.punteroTS($1.sval));}
								| '-' factor //{  Sacamos lo ultimo que agregamos a la polaca, porque ya no es valido.
								                //Determinamos que signo va a tener la cte.
								                //Si es negativa, agregamos "-sval" a la TS.
								                //Agregamos el string correcto (devuelto por utils.sig....) a la polaca.
                                                //  Polaca.insert(new RegistroTS(Utils.signoNegativo($2.sval)));
                                                // }
								| invocacion //{Polaca.insert(TablaSimbolos.punteroTS($1.sval));}
								| ERR_CTE_FUERA_RANGO {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
								| ERR_FORMATO_CTE {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
								;

impresion						: PRINT '(' CADENA ')' //{Polaca.insert(new RegistroTS("PRINT(" + $3.sval + ")"));}
        						| PRINT '(' error ')'
								;

iteracion						: REPEAT bloque_sentencias UNTIL condicion
                                | REPEAT bloque_sentencias {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + "UNTIL expected");}
								;

condicion						: '(' expresion comparador expresion ')' //{Polaca.insert(new RegistroTS($3.sval));}
            					| '(' expresion comparador expresion {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta parentesis de cierre de la condicion.");}
            					| '(' comparador expresion ')' {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
            					| '(' expresion comparador ')' {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
            					| '(' expresion operador_logico expresion ')'// {Polaca.insert(new RegistroTS($3.sval));}
            					| '(' error ')' {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}  // verificar el error
								;
			
comparador 						: COMP_MAYOR_IGUAL //{$$ = new ParserVal(">=");}
								| COMP_MENOR_IGUAL //{$$ = new ParserVal("<=");}
								| '<' //{$$ = new ParserVal("<");}
								| '>' //{$$ = new ParserVal(">");}
								| COMP_IGUAL // {$$ = new ParserVal("==");}
								| COMP_DISTINTO //{$$ = new ParserVal("<>");}
								;

operador_logico 				: AND //{$$ = new ParserVal("AND");}
                				| OR //{$$ = new ParserVal("OR");}
								;

seleccion						: IF condicion THEN bloque_sentencias ENDIF
								| IF condicion THEN bloque_sentencias ELSE bloque_sentencias ENDIF
								| IF condicion THEN ELSE bloque_sentencias ENDIF {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el bloque de sentencias ejecutables de la rama THEN.");}
								| IF condicion THEN ELSE bloque_sentencias {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
								| IF condicion THEN ENDIF {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el bloque de sentencias ejecutables de la rama THEN.");}
								| IF condicion THEN bloque_sentencias ELSE bloque_sentencias {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
								| IF condicion THEN bloque_sentencias {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
								;

%%


private int yylex() {

  Dupla<Integer, RegistroTS> token = null;
  do {
    try {
      token = AnalizadorLexico.producirToken();

      if(token.second != null)
        yylval = new ParserVal(token.second.getLexema());
      else yylval = new ParserVal();

    } catch (Exception e) {
      AnalizadorLexico.indiceUltimoLeido++;
      e.printStackTrace();
      System.out.println("hubo un error lexico");
    }
  } while (token == null);

  return token.first;

}

private void yyerror(String mensajeError) {
	AnalizadorLexico.errores.add(mensajeError + "\n");
}
