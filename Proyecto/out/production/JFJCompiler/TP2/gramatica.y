%{
	package TP2.BYACC;
	import Dev.Lexico.AnalizadorLexico;
	import Dev.Lexico.Dupla;
	import Dev.Lexico.TablaSimbolos;
	import Dev.RegistroTS;
	import TP3.Polaca;
	import TP3.Utils;
	import TP3.Ambito;
%}

%token PROGRAM, UINT, DOUBLE, BEGIN, RETURN, END, POST, ID, FUNC, CTE_UINT, CTE_DOUBLE, CADENA, PRINT, REPEAT , UNTIL, THEN, IF , ELSE, ASIG, AND, OR, COMP_MAYOR_IGUAL, COMP_MENOR_IGUAL, COMP_IGUAL, COMP_DISTINTO, ENDIF, BREAK, ERR_CTE_FUERA_RANGO, ERR_FORMATO_CTE

%start program

%%
program 						: PROGRAM ID ';' {Ambito.agregarAmbito("main");} declaracion {Polaca.insert("-----------FinDeclaraciones-----------");} cuerpo_programa
								| PROGRAM ID ';' {Ambito.agregarAmbito("main");} cuerpo_programa
								| PROGRAM ';' declaracion cuerpo_programa {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
								| PROGRAM ';' cuerpo_programa {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
								| declaracion cuerpo_programa {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got declaracion instead");}
								| cuerpo_programa {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got cuerpo_programa instead");}
								| PROGRAM ID ';' error {}
								;

cuerpo_programa                 : BEGIN sentencia_ejec END ';' {Polaca.insert("END_PROGRAM");}
                                | BEGIN END ';' {Polaca.insert("END_PROGRAM");}
                                ;

bloque_sentencias 				: BEGIN sentencia_ejec END ';'
				  				| miembro_sentencia_ejec
								;

tipo_id							: UINT
								| DOUBLE
								| FUNC
								;

cuerpo_func  					: BEGIN sentencia_ejec RETURN retorno END {Polaca.insert("RETURN");}
                        		| BEGIN sentencia_ejec RETURN retorno post_condicion END {Polaca.insert("RETURN");}
                        		| BEGIN sentencia_ejec RETURN END {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
                        		| BEGIN sentencia_ejec RETURN post_condicion END {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
								| BEGIN sentencia_ejec RETURN ';' END {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
								| BEGIN sentencia_ejec RETURN ';' post_condicion END {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
								| BEGIN sentencia_ejec RETURN retorno END declaracion {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
								| BEGIN sentencia_ejec RETURN retorno post_condicion END declaracion {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
								| BEGIN sentencia_ejec RETURN retorno END BEGIN {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
								| BEGIN sentencia_ejec RETURN retorno post_condicion END BEGIN {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
								;

post_condicion          		: POST ':' condicion ',' CADENA ';' {Polaca.insert_sentencia_control_cond();} {} {Polaca.insert_sentencia_control_then();} {TablaSimbolos.punteroTS($5.sval).setTipo("cadena_caracteres"); TablaSimbolos.punteroTS($5.sval).setUso("msj_postcondicion"); Polaca.insert("PRINT"); Polaca.insert(TablaSimbolos.punteroTS($5.sval)); Polaca.insert("Quit"); Polaca.insert_sentencia_control_else();}
                                | POST ':' condicion ',' ';' {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " CADENA expected but got ; instead");}
								;

retorno             			: '(' expresion ')' ';' {Polaca.insert("FillReturnReg");}
								;


declaracion 					: FUNC tipo_id nombre_func params_func definicion_func  ';' { Utils.setTipoIDFuncionCacheado(Integer.toString($2.ival));}
								| tipo_id lista_variables ';' {Utils.asignarTipoListaDeVariables(Integer.toString($1.ival)); Utils.clearListaDeVariables();} // Asigna el tipo a cada variable de la lista
								| tipo_id lista_variables ';' declaracion {Utils.asignarTipoListaDeVariables(Integer.toString($1.ival)); Utils.clearListaDeVariables();}
								| FUNC tipo_id nombre_func params_func definicion_func ';' { Utils.setTipoIDFuncionCacheado(Integer.toString($2.ival));} declaracion
								| lista_variables ';' {yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");} //la linea es la primer sentencia ejecutable del programa principal, restamos 1 para que devuelva la linea donde empieza el programa
								| lista_variables ';' declaracion {yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
								;

lista_variables					: ID {TablaSimbolos.cambiarNombre($1.sval, $1.sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables($1.sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS($1.sval + Ambito.retornarNaming()).setUso("variable"); }
								| ID ',' lista_variables { TablaSimbolos.cambiarNombre($1.sval, $1.sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables($1.sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS($1.sval + Ambito.retornarNaming()).setUso("variable"); }
								| ID BEGIN {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
								;

nombre_func						: ID {TablaSimbolos.cambiarNombre($1.sval, $1.sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS($1.sval + Ambito.retornarNaming()).setUso("nombre_funcion"); Utils.cachearIDFuncion($1.sval + Ambito.retornarNaming()); Ambito.agregarAmbito($1.sval); }
								;

params_func						: '(' param ')'
								| '(' ')'
								;

param 							: tipo_id ID {TablaSimbolos.punteroTS($2.sval).setTipo(Integer.toString($1.ival)); TablaSimbolos.punteroTS($2.sval).setUso("parametro"); TablaSimbolos.cambiarNombre($2.sval, $2.sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setParametro(TablaSimbolos.punteroTS($2.sval + Ambito.retornarNaming()));} //le damos a la entrada en la TS de la funcion un puntero al parametro
		    					;

definicion_func					: declaracion {TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setComienzoCodigoEjecutable(Polaca.posicionActual() + 1); Polaca.insert("FuncStartLabel"); Polaca.insert("L"+ (Polaca.posicionActual() + 1));} cuerpo_func {Ambito.borrarAmbito();} //seteamos la direccion en la que comienza el codigo ejecutable. Ademas, si tiene parametro, lo asignamos a lo que se pase (dejando un lugar)
								| {TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setComienzoCodigoEjecutable(Polaca.posicionActual()+1); Polaca.insert("FuncStartLabel"); Polaca.insert("L"+ (Polaca.posicionActual() + 1));} cuerpo_func {Ambito.borrarAmbito();}
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

invocacion						: ID '(' ')' {if ((Ambito.bindAmbito($1.sval) != null) && (TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).getParametro()) == null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval))); Polaca.insert("CALL"); TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).setEsNombre(false);} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una funcion con esa signatura en el ambito actual");}
								| ID '(' expresion ')' {if ((Ambito.bindAmbito($1.sval) != null) && (TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).getParametro() != null) && (Ambito.bindAmbito($3.sval) != null)) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).getParametro()); Polaca.insert(new Integer(Parser.ASIG)); Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval))); Polaca.insert("CALL"); TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).setEsNombre(false);} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una funcion con esa signatura en el ambito actual");}
								;

asignacion						: ID ASIG expresion {if (Ambito.bindAmbito($1.sval) != null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)));} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una variable con ese nombre en el ambito actual"); Polaca.insert(new Integer(ASIG)); if ($3.ival == Parser.ID && TablaSimbolos.punteroTS(Ambito.bindAmbito($3.sval)).getUso().equals("nombre_funcion") && TablaSimbolos.punteroTS(Ambito.bindAmbito($3.sval)).esNombre()){RegistroTS funcionAAsignar = TablaSimbolos.punteroTS(Ambito.bindAmbito($3.sval)); Polaca.removerUltimo(); Polaca.removerUltimo(); Polaca.removerUltimo(); TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).setTipo(funcionAAsignar.getTipo()); TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).setUso(funcionAAsignar.getUso()); TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).setParametro(funcionAAsignar.getParametro()); TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).setComienzoCodigoEjecutable(funcionAAsignar.getComienzoCodigoEjecutable());} ;} //Usamos Integer para que se pueda meter en la lista.
            					| ID ASIG error {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
            					| ID {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
            					| error ASIG expresion {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
            					;

expresion						: expresion '+' termino {Polaca.insert(new Integer('+'));}
								| expresion '-' termino {Polaca.insert(new Integer('-'));}
	        					| termino
								;

termino							: termino '*' factor {Polaca.insert(new Integer('*'));}
								| termino '/' factor {Polaca.insert(new Integer('/'));}
								| factor
     							;

factor 							: ID {if (Ambito.bindAmbito($1.sval) != null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval))); if(((RegistroTS)Polaca.conseguirUltimo()).getUso().equals("nombre_funcion")){TablaSimbolos.punteroTS(Ambito.bindAmbito($1.sval)).setEsNombre(true);}} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una variable con ese nombre en el ambito actual");}
								| CTE_UINT {Polaca.insert(TablaSimbolos.punteroTS($1.sval)); TablaSimbolos.punteroTS($1.sval).setTipo(Integer.toString(Parser.CTE_UINT)); TablaSimbolos.punteroTS($1.sval).setUso("cte");}
								| CTE_DOUBLE {Polaca.insert(TablaSimbolos.punteroTS($1.sval)); TablaSimbolos.punteroTS($1.sval).setTipo(Integer.toString(Parser.CTE_DOUBLE)); TablaSimbolos.punteroTS($1.sval).setUso("cte");}
								| '-' factor {  /*Sacamos lo ultimo que agregamos a la polaca, porque ya no es valido.
								                Determinamos que signo va a tener la cte.
								                Si es negativa, agregamos "-sval" a la TS.
								                Agregamos el string correcto (devuelto por utils.sig....) a la polaca.*/
                                                Polaca.insert(TablaSimbolos.punteroTS(Utils.signoNegativo($2.sval)));
                                                }
								| invocacion
								| ERR_CTE_FUERA_RANGO {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
								| ERR_FORMATO_CTE {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
								;

impresion						: PRINT '(' CADENA ')' {TablaSimbolos.punteroTS($3.sval).setTipo("cadena_caracteres"); Polaca.insert("PRINT"); Polaca.insert(TablaSimbolos.punteroTS($3.sval)); }
        						| PRINT '(' error ')' {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " invalid argument for PRINT");}
								;

iteracion						: encabezado_iteracion bloque_sentencias UNTIL condicion {Polaca.insert_iteracion_end();}
                                | encabezado_iteracion bloque_sentencias {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " UNTIL expected");}
								;

								//Para el repeat es basicamente un IF-ELSE. Cuando se lee la palabra "repeat", se guarda el indice en el que esta la polaca,
								//diciendo "el Repeat arranca aca". Cuando se llega a la cond, si es verdadera se salta a ese indice. Sino no se hace nada.

encabezado_iteracion:           REPEAT {Polaca.insert_iteracion_start();}
                                ;

condicion						: '(' expresion comparador expresion ')' {Polaca.insert(new Integer($3.ival));}
            					| '(' comparador expresion ')' {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
            					| '(' expresion comparador ')' {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
            					| '(' condicion operador_logico condicion ')' {Polaca.insert(new Integer($3.ival));}
            					| '(' error ')' {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}  // verificar el error
								;

comparador 						: COMP_MAYOR_IGUAL
								| COMP_MENOR_IGUAL
								| '<'
								| '>'
								| COMP_IGUAL
								| COMP_DISTINTO
								;

operador_logico 				: AND
                				| OR
								;


seleccion                       : encabezado_if rama_then ENDIF {Polaca.insert_sentencia_control_else();} //si no hay else, se mete el final del THEN.
                                | encabezado_if rama_then rama_else ENDIF
                                ;

encabezado_if                   : IF condicion {Polaca.insert_sentencia_control_cond();}
                                | IF {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en el encabezado de la condicion, falta la condicion del IF");}
                                ;

rama_then                       : THEN bloque_sentencias {Polaca.insert_sentencia_control_then();}
                                | THEN {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia THEN, falta el bloque de sentencias");}
                                ;

rama_else                       : ELSE bloque_sentencias {Polaca.insert_sentencia_control_else();}
                                | ELSE {yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia ELSE, falta el bloque de sentencias");}
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
      yylval.ival = token.first; //Para conseguir el numero de token de un comparador u operador logico en la generacion de codigo
    } catch (Exception e) {
      AnalizadorLexico.indiceUltimoLeido++;

      System.out.println("hubo un error lexico en la linea " + AnalizadorLexico.nroLinea);
    }
  } while (token == null);

  return token.first;

}

private void yyerror(String mensajeError) {
	AnalizadorLexico.errores.add(mensajeError + "\n");
}
