%{

%}

%token UINT, DOUBLE, BEGIN, RETURN, END, POST, ID, FUNC, CTE_UINT, CTE_DOUBLE, CADENA, PRINT, REPEAT , UNTIL, THEN, IF , ELSE, ASIG, AND, OR, COMP_MAYOR_IGUAL, COMP_MENOR_IGUAL, COMP_IGUAL, COMP_DISTINTO, ENDIF, BREAK

%start program

// TODO : Revisar tema (;)
// TODO : Se debe incorporar al Análisis Léxico el reconocimiento de la palabra reservada POST, y el símbolo ':'.}

%%
program 						: declaracion ',' bloque_sentencias
								| bloque_sentencias

bloque_sentencias 				: BEGIN sentencia_ejec END
				  				| miembro_sentencia_ejec
			
tipo_id							: UINT {}
								| DOUBLE {}
								| FUNC
								;
								
cuerpo_func  					: BEGIN sentencia_ejec RETURN retorno END
                        		| BEGIN sentencia_ejec RETURN retorno post_condicion END

post_condicion          		: POST ':' condicion ',' CADENA

retorno             			: '(' expresion ')' ';'

declaracion 					: tipo_id nombre_func params_func definicion_func {}
								| tipo_id lista_variables
								;

lista_variables					: ID {}
								| ID ',' lista_variables {}
								;	

nombre_func						: FUNC ID {}
								| FUNC {yyerror("Falta el identificador del procedimiento.");}
								;
			
params_func						: '(' param ')'
								| '(' ')'
								| '(' param {yyerror("Falta el parentesis de cierre para los parametros.");}
								| '(' {yyerror("Falta el parentesis de cierre para los parametros.");}
								;

param 							: tipo_id ID {;}
		    					| tipo_id {yyerror("Falta el identificador de un parametro.");}
		    					;

separador_variables				: {yyerror("Falta una ',' para separar dos parametros.");}
								| ','
								;
		
definicion_func					: declaracion ',' cuerpo_func
								| cuerpo_func
								| {yyerror("Cuerpo del procedimiento vacio.");}
								;

sentencia_ejec					: miembro_sentencia_ejec ';' sentencia_ejec
								| miembro_sentencia_ejec ';'             
								;

miembro_sentencia_ejec 			: invocacion
                       			| asignacion
                       			| iteracion
                       			| seleccion
                       			| impresion
								| BREAK
                       			;

invocacion						: ID '(' ')' {}
								| ID '(' param ')' {}
								;

asignacion						: ID ASIG expresion {}
            					| ID ASIG error {yyerror("El lado derecho de la asignacio no es valido.");}
            					| ID {yyerror("Un identificador en solitario no es una sentencia valida.");}
            					| error ASIG expresion {yyerror("El lado izquierdo de la asignacion no es valido");}
            					;
			
expresion						: expresion '+' termino {}
								| expresion '-' termino {}
	        					| termino
								;
    		
termino							: termino '*' factor {}
								| termino '/' factor {}
								| factor
     							;	
		
factor 							: ID {}
								| CTE_UINT {}
								| CTE_DOUBLE {}
								| '-' factor    {}
								| invocacion    {}
								;

impresion						: PRINT '(' '%' CADENA '%' ')'
        						| PRINT '(' error ')'
								;

iteracion						: REPEAT bloque_sentencias UNTIL condicion
								;

condicion						: '(' expresion comparador expresion ')' {}
            					| '(' expresion comparador expresion {yyerror("Falta parentesis de cierre de la condicion.");}
            					| '(' comparador expresion ')' {yyerror("Falta expresion en el lado izquierdo de la condicion.");}
            					| '(' expresion comparador ')' {yyerror("Falta expresion en el lado derecho de la condicion.");}
            					| '(' expresion operador_logico expresion ')'
            					| '(' error ')' {yyerror("Error en la condicion.");}  // verificar el error
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

seleccion						: IF condicion THEN bloque_sentencias ENDIF ';'
								| IF condicion THEN bloque_sentencias ELSE bloque_sentencias ENDIF ';'
								| IF condicion THEN ELSE bloque_sentencias ENDIF {yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.")} ';'
								| IF condicion THEN ENDIF {yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.")} ';'
								;
%%