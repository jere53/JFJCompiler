
{%

%}

%token

%start

%%

programa	: bloque_sentencias
			;
			
tipo_id	: UINT {helper.setUltimoTipoLeido("UINT");}
		| DOUBLE {helper.setUltimoTipoLeido("DOUBLE");}
		;

bloque_sentencias	: sentencia_decl ',' sentencia_de_ejecucion ';'
					| sentencia_de_ejecucion ';'
					;

sentencia_de_ejecucion :  BEGIN sentencia_ejec RETURN retorno END

retorno : expresion ';'

sentencia_decl	: tipo_id nombre_func params_func cuerpo_func {helper.eliminarUltimoAmbito();}
				| tipo_id lista_variables
				;

lista_variables	: ID {helper.declaracionVar($1.sval);}
				| ID ',' lista_variables {helper.declaracionVar($1.sval);}
				;


nombre_func	: FUNC ID {helper.lecturaIdProc($2.sval);}
			| FUNC {yyerror("Falta el identificador del procedimiento.");}
			;
			
params_func	: '(' param ')'
			| '(' ')'
			| '(' param {yyerror("Falta el parentesis de cierre para los parametros.");}
			| '(' {yyerror("Falta el parentesis de cierre para los parametros.");}
			;

param : tipo_id ID {helper.lecturaParamFormal($2.sval, Celda.USO_PARAM_CV);}
		    | tipo_id {yyerror("Falta el identificador de un parametro.");}
		    ;

separador_variables	:       {yyerror("Falta una ',' para separar dos parametros.");}
					| ','
					;
		
cuerpo_func	: bloque_sentencias
			| '{' '}' {yyerror("Cuerpo del procedimiento vacio.");}
			;

sentencia_ejec	: miembro_sentencia_ejec sentencia_ejec
				| miembro_sentencia_ejec             
				;

miembro_sentencia_ejec : invocacion
                       | asignacion
                       | loop
                       | if
                       | print

invocacion	: ID '(' ')' {helper.invocacionProc($1.sval);}
			| ID '(' lista_params_inv ')' {helper.invocacionProc($1.sval);}
			;

param_inv   : ID {helper.guardaParamsInvoc($1.sval);}
            | CTE_UINT {helper.guardaParamsInvoc($1.sval);}
            | CTE_DOUBLE {helper.guardaParamsInvoc($1.sval);}
            ;
			
lista_params_inv	: param_inv
					| param_inv separador_variables param_inv
					| param_inv separador_variables param_inv separador_variables param_inv
					| param_inv separador_variables param_inv separador_variables param_inv separador_variables lista_params_inv
                                                    {yyerror("Un procedimiento no puede tener mas de 3 parametros.");}
                    ;

asignacion	: ID '=' expresion {helper.lecturaDestAsign($1.sval);}
            | ID '=' error {
                            helper.lecturaDestAsign($1.sval);
                            yyerror("El lado derecho de la asignacio no es valido.");
                            }
            | ID {
                    helper.lecturaDestAsign($1.sval);
                    yyerror("Un identificador en solitario no es una sentencia valida.");
                    }
            | error '=' expresion {yyerror("El lado izquierdo de la asignacion no es valido");}

            ;
			
expresion	: expresion '+' termino {helper.agregarPasosRepr("+");}
			| expresion '-' termino {helper.agregarPasosRepr("-");}
	        | termino
			;
    		
termino	: termino '*' factor {helper.agregarPasosRepr("*");}
		| termino '/' factor {helper.agregarPasosRepr("/");}
		| factor
     	;	
		
factor 	: ID {helper.lecturaFactor($1.sval);}
		| CTE_UINT {helper.agregarPasosRepr($1.sval);helper.setTipoUltimoFactor("UINT");}
		| CTE_DOUBLE {helper.agregarPasosRepr($1.sval);helper.setTipoUltimoFactor("DOUBLE");}
		| '-' factor    {helper.cambioSignoFactor(yylval.sval);}
		;

print	: OUT '(' imprimible ')'
        | OUT '(' imprimible
        | OUT '(' error ')'
		;

imprimible	: CADENA {helper.agregarPasosRepr($1.sval, "OUT_CAD");}
			| factor {helper.impresionFactor();}
			;
		
loop	: encab_loop cuerpo_loop cuerpo_until
		;

encab_loop  : LOOP {helper.puntoControlLoop();}
            ;
		
cuerpo_loop	: bloque_estruct_ctrl
            | {yyerror("Falta el bloque de sentencias ejecutables del LOOP.");}
			;
		
bloque_estruct_ctrl	: sentencia_ejec fin_sentencia
					| '{' bloque_sentencias_ejec '}'
					| '{' '}' {yyerror("Bloque de sentencias vacio.");}
					| sentencia_decl fin_sentencia {yyerror("No se permiten sentencias declarativas dentro de un bloque de estructura de control.");}
					;

bloque_sentencias_ejec	: sentencia_ejec fin_sentencia
						| sentencia_ejec fin_sentencia bloque_sentencias_ejec
					    | sentencia_decl fin_sentencia
					        {yyerror("No se permiten sentencias declarativas dentro de un bloque de estructura de control.");}
					    | sentencia_decl fin_sentencia bloque_sentencias_ejec
					        {yyerror("No se permiten sentencias declarativas dentro de un bloque de estructura de control.");}
						;

cuerpo_until	: UNTIL condicion {helper.puntoControlUntil();}
                | UNTIL {yyerror("Falta la condicion de corte del LOOP.");}
                ;

condicion	: '(' expresion comparador expresion ')' {helper.agregarPasosRepr($3.sval);}
            | '(' expresion comparador expresion {yyerror("Falta parentesis de cierre de la condicion.");}
            | '(' comparador expresion ')' {yyerror("Falta expresion en el lado izquierdo de la condicion.");}
            | '(' expresion comparador ')' {yyerror("Falta expresion en el lado derecho de la condicion.");}
            | '(' error ')' {yyerror("Error en la condicion.");}
			;
			
comparador 	: COMP_MAYOR_IGUAL
			| COMP_MENOR_IGUAL
			| '<'
			| '>'
			| COMP_IGUAL
			| COMP_DISTINTO
			;

if	: encabezado_if rama_then rama_else END_IF
	| encabezado_if rama_then_prima END_IF
	;

encabezado_if	: IF condicion {helper.puntoControlThen();}
                | IF {yyerror("Falta la condicion del IF.");}
				;
				
rama_then	: THEN bloque_estruct_ctrl {helper.puntoControlElse();}
            | THEN {yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.");}
			;

rama_then_prima : THEN bloque_estruct_ctrl {helper.puntoControlFinCondicional();}
                | THEN {yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.");}
                ;
			
rama_else	: ELSE bloque_estruct_ctrl {helper.puntoControlFinCondicional();}
            | ELSE {yyerror("Falta el bloque de sentencias ejecutables de la rama ELSE.");}
			;


%%



