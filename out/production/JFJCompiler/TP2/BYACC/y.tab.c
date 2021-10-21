#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
	package TP2.BYACC;
	import Dev.Lexico.AnalizadorLexico;
	import Dev.Lexico.Dupla;
	import Dev.Lexico.TablaSimbolos;
	import Dev.RegistroTS;
	import TP3.Polaca;
	import TP3.Utils;
#line 14 "y.tab.c"
#define UINT 257
#define DOUBLE 258
#define BEGIN 259
#define RETURN 260
#define END 261
#define POST 262
#define ID 263
#define FUNC 264
#define CTE_UINT 265
#define CTE_DOUBLE 266
#define CADENA 267
#define PRINT 268
#define REPEAT 269
#define UNTIL 270
#define THEN 271
#define IF 272
#define ELSE 273
#define ASIG 274
#define AND 275
#define OR 276
#define COMP_MAYOR_IGUAL 277
#define COMP_MENOR_IGUAL 278
#define COMP_IGUAL 279
#define COMP_DISTINTO 280
#define ENDIF 281
#define BREAK 282
#define ERR_CTE_FUERA_RANGO 283
#define ERR_FORMATO_CTE 284
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    2,    2,    5,    5,    5,    6,    6,    8,
    7,    1,    1,    1,    1,   14,   14,   11,   11,   12,
   12,   15,   13,   13,   13,    3,    3,    4,    4,    4,
    4,    4,    4,    4,    4,    4,    4,    4,    4,   16,
   16,   17,   17,   17,   17,   10,   10,   10,   21,   21,
   21,   22,   22,   22,   22,   22,   22,   22,   20,   20,
   18,   18,    9,    9,    9,    9,    9,    9,   23,   23,
   23,   23,   23,   23,   24,   24,   19,   19,   19,   19,
   19,   19,   19,
};
short yylen[] = {                                         2,
    2,    1,    4,    1,    1,    1,    1,    5,    6,    6,
    4,    5,    3,    4,    6,    1,    3,    2,    1,    3,
    2,    2,    2,    1,    0,    2,    1,    2,    2,    2,
    2,    2,    2,    2,    2,    2,    2,    2,    2,    3,
    4,    3,    3,    1,    3,    3,    3,    1,    3,    3,
    1,    1,    1,    1,    2,    1,    1,    1,    4,    4,
    4,    2,    5,    4,    4,    4,    5,    3,    1,    1,
    1,    1,    1,    1,    1,    1,    5,    7,    6,    5,
    4,    6,    4,
};
short yydefred[] = {                                      0,
    0,    5,    6,    0,    0,    7,    0,    0,    0,    0,
    0,    0,    2,    4,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   33,
   39,    1,    0,    0,    0,    0,   28,   35,   29,   36,
   30,   37,   31,   34,   32,   38,    0,   53,   54,   57,
   58,    0,    0,   56,    0,   51,    0,   26,   43,    0,
    0,   40,    0,    0,    0,    0,   69,   70,   73,   74,
   71,   72,    0,    0,    0,    0,   18,    0,    0,    0,
   55,    0,    0,    0,    0,    3,   41,   60,   59,   61,
   68,   75,   76,    0,    0,    0,    0,   81,    0,   17,
   21,    0,    0,    0,    0,   24,    0,   14,    0,    0,
   49,   50,   66,    0,    0,   65,    0,    0,   77,   22,
   20,    0,   23,    0,   63,   67,   79,    0,    0,   15,
   78,    0,    0,    0,    8,    0,    0,    0,    0,    9,
   11,    0,    0,    0,   10,
};
short yydgoto[] = {                                      11,
   12,   13,   22,   14,   15,  106,  133,  137,   29,   53,
   35,   79,  107,   36,  103,   16,   17,   18,   19,   20,
   55,   56,   74,   95,
};
short yysindex[] = {                                   -104,
 -264,    0,    0,  -74,  -39,    0,   11,  -89,   28,  -56,
    0,  -89,    0,    0, -249,  -54,  116,  118,  133,  151,
    2, -237,  -74,   94,  -32, -245, -240,   69, -205,    0,
    0,    0,   34, -179,   50,   38,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   59,    0,    0,    0,
    0,    2,    5,    0,  -16,    0,   44,    0,    0,    5,
   68,    0,   71,   83,   28,   84,    0,    0,    0,    0,
    0,    0,   61,    2,  250, -137,    0,  -28, -230, -182,
    0,    2,    2,    2,    2,    0,    0,    0,    0,    0,
    0,    0,    0,  -41,    2,   48,  -89,    0, -248,    0,
    0, -135,   89,  -74, -127,    0,   81,    0,  -16,  -16,
    0,    0,    0,   57,   74,    0, -148,  -89,    0,    0,
    0, -126,    0, -182,    0,    0,    0, -140,  104,    0,
    0,    2, -222,   75,    0,   88, -112,   91,   28,    0,
    0,  107, -111,   99,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,  162,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -207,    0,    0,    0,  179,    0,    0,    0,
    0,    0,  102,  122,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -24,    0,    0,    0,
    0,    0,  187,    0,    1,    0,    0,    0,    0,  202,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  110,  258,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  204,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   26,   51,
    0,    0,    0,   98,    0,    0,  225,    0,    0,    0,
    0,    0,    0,  278,    0,    0,    0,  233,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  -72,    4,  -21,   39,   85,   66,    0,    0,  -59,   13,
    0,    0,    0,   90,    0,   53,    0,    0,    0,    0,
  -10,  -20,  100,    0,
};
#define YYTABLESIZE 560
short yytable[] = {                                     113,
   25,   58,   30,   52,   37,   90,  105,  108,   62,   21,
   63,   27,  101,   33,   34,   32,   52,   52,   52,   52,
   52,   64,   52,   57,  118,   84,    2,    3,  104,   65,
   85,   81,  119,    6,   52,   52,   60,   52,  135,  136,
   73,   48,   23,   48,   48,   48,   52,   82,   31,   83,
   26,  130,   27,   27,   38,   40,   42,   44,   46,   48,
   48,   23,   48,  111,  112,   75,   46,   28,   46,   46,
   46,  109,  110,   54,    2,    3,   54,   76,   99,  142,
   54,    6,  122,   77,   46,   46,   96,   46,  116,   78,
   82,   47,   83,   47,   47,   47,   80,  125,   25,   82,
  117,   83,   86,   82,   54,   83,  114,  115,   87,   47,
   47,   88,   47,   52,  126,  138,   82,   82,   83,   83,
   71,  128,   72,   89,   91,   33,   54,  120,   71,  121,
   72,  104,  127,  129,   54,   54,   54,   54,   52,  124,
  131,   64,   23,  132,  134,  139,   54,   54,  140,  141,
  143,    1,    2,    3,    4,  144,   64,  145,    5,    6,
   16,   19,  102,    7,    8,  100,    1,    9,   25,    4,
  123,    0,   94,    5,   39,    0,   41,   10,    7,    8,
    0,    1,    9,    0,   54,    0,    0,    0,    5,    0,
    0,   43,   10,    7,    8,    0,    0,    9,    0,    1,
    0,    1,    0,    0,    0,    0,    5,   10,    5,   45,
    0,    7,    8,    7,    8,    9,    0,    9,    0,    0,
   44,   47,    0,   48,   49,   10,    0,   10,    2,    3,
   61,   52,    0,    0,   24,    6,    0,   62,   52,    0,
    0,   50,   51,   52,   52,   45,   52,   52,    0,    0,
   52,   52,   52,   52,   52,   52,   48,   52,    0,    0,
   42,    0,   83,   48,   47,    0,   48,   49,   48,   48,
    0,   48,   48,    0,    0,   48,   48,   48,   48,   48,
   48,   46,   48,   80,   50,   51,    0,    0,   46,    0,
    0,   82,    0,   46,   46,    0,   46,   46,    0,    0,
   46,   46,   46,   46,   46,   46,   47,   46,    0,    0,
    0,    0,    0,   47,    0,    0,    0,    0,   47,   47,
    0,   47,   47,    0,   66,   47,   47,   47,   47,   47,
   47,   47,   47,   48,   49,   92,   93,   67,   68,   69,
   70,    0,    0,    0,    0,   67,   68,   69,   70,   59,
    0,   50,   51,   64,    0,    0,   47,    0,   48,   49,
   64,    0,    0,    0,    0,   64,   64,    0,   64,   64,
    0,    1,    0,    1,    0,    0,   50,   51,    5,   64,
    5,    0,    0,    7,    8,    7,    8,    9,    1,    9,
    0,    0,    0,    0,    0,    5,    0,   10,    0,   10,
    7,    8,    0,    0,    9,    0,    1,    0,    0,    0,
    0,    0,    0,    5,   10,    0,    0,   44,    7,    8,
    0,    0,    9,    0,   44,    0,    0,    0,    0,   44,
   44,    0,   10,   44,   62,    0,    0,    0,    0,    0,
    0,   62,   45,   44,    0,    0,   62,   62,    0,   45,
   62,    0,    0,    0,   45,   45,    0,   42,   45,   83,
   62,    0,    0,    0,   42,    0,   83,    0,   45,   42,
   42,   83,   83,   42,    0,   83,    0,    0,    0,    0,
   80,    0,    0,   42,    0,   83,    0,   80,   82,    0,
    0,    0,   80,   80,    0,   82,   80,    0,    0,    0,
   82,   82,    0,    0,   82,    1,   80,    0,    4,    0,
    0,    0,    5,   13,   82,    0,   13,    7,    8,    0,
   13,    9,   97,    0,    0,   13,   13,    0,    0,   13,
   98,   10,    0,   12,    0,    0,   12,    0,    0,   13,
   12,    0,    0,    0,    0,   12,   12,    0,    0,   12,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   12,
};
short yycheck[] = {                                      41,
   40,   23,   59,   45,   59,   65,   79,   80,   41,  274,
  256,    8,   41,  263,  264,   12,   41,   42,   43,   44,
   45,  267,   47,  261,  273,   42,  257,  258,  259,  270,
   47,   52,  281,  264,   59,   60,   24,   62,  261,  262,
   28,   41,    4,   43,   44,   45,   45,   43,   10,   45,
   40,  124,  260,  261,   16,   17,   18,   19,   20,   59,
   60,   23,   62,   84,   85,  271,   41,   40,   43,   44,
   45,   82,   83,   21,  257,  258,   24,   44,   75,  139,
   28,  264,  104,  263,   59,   60,   74,   62,   41,   40,
   43,   41,   45,   43,   44,   45,   59,   41,   40,   43,
   97,   45,   59,   43,   52,   45,   94,   95,   41,   59,
   60,   41,   62,   45,   41,   41,   43,   43,   45,   45,
   60,  118,   62,   41,   41,  263,   74,  263,   60,   41,
   62,  259,  281,  260,   82,   83,   84,   85,   45,   59,
  281,   44,  104,   40,  132,   58,   94,   95,  261,   59,
   44,  256,  257,  258,  259,  267,   59,   59,  263,  264,
   59,   40,   78,  268,  269,   76,  256,  272,   59,  259,
  105,   -1,   73,  263,   59,   -1,   59,  282,  268,  269,
   -1,  256,  272,   -1,  132,   -1,   -1,   -1,  263,   -1,
   -1,   59,  282,  268,  269,   -1,   -1,  272,   -1,  256,
   -1,  256,   -1,   -1,   -1,   -1,  263,  282,  263,   59,
   -1,  268,  269,  268,  269,  272,   -1,  272,   -1,   -1,
   59,  263,   -1,  265,  266,  282,   -1,  282,  257,  258,
  263,  256,   -1,   -1,  274,  264,   -1,   59,  263,   -1,
   -1,  283,  284,  268,  269,   59,  271,  272,   -1,   -1,
  275,  276,  277,  278,  279,  280,  256,  282,   -1,   -1,
   59,   -1,   59,  263,  263,   -1,  265,  266,  268,  269,
   -1,  271,  272,   -1,   -1,  275,  276,  277,  278,  279,
  280,  256,  282,   59,  283,  284,   -1,   -1,  263,   -1,
   -1,   59,   -1,  268,  269,   -1,  271,  272,   -1,   -1,
  275,  276,  277,  278,  279,  280,  256,  282,   -1,   -1,
   -1,   -1,   -1,  263,   -1,   -1,   -1,   -1,  268,  269,
   -1,  271,  272,   -1,  256,  275,  276,  277,  278,  279,
  280,  263,  282,  265,  266,  275,  276,  277,  278,  279,
  280,   -1,   -1,   -1,   -1,  277,  278,  279,  280,  256,
   -1,  283,  284,  256,   -1,   -1,  263,   -1,  265,  266,
  263,   -1,   -1,   -1,   -1,  268,  269,   -1,  271,  272,
   -1,  256,   -1,  256,   -1,   -1,  283,  284,  263,  282,
  263,   -1,   -1,  268,  269,  268,  269,  272,  256,  272,
   -1,   -1,   -1,   -1,   -1,  263,   -1,  282,   -1,  282,
  268,  269,   -1,   -1,  272,   -1,  256,   -1,   -1,   -1,
   -1,   -1,   -1,  263,  282,   -1,   -1,  256,  268,  269,
   -1,   -1,  272,   -1,  263,   -1,   -1,   -1,   -1,  268,
  269,   -1,  282,  272,  256,   -1,   -1,   -1,   -1,   -1,
   -1,  263,  256,  282,   -1,   -1,  268,  269,   -1,  263,
  272,   -1,   -1,   -1,  268,  269,   -1,  256,  272,  256,
  282,   -1,   -1,   -1,  263,   -1,  263,   -1,  282,  268,
  269,  268,  269,  272,   -1,  272,   -1,   -1,   -1,   -1,
  256,   -1,   -1,  282,   -1,  282,   -1,  263,  256,   -1,
   -1,   -1,  268,  269,   -1,  263,  272,   -1,   -1,   -1,
  268,  269,   -1,   -1,  272,  256,  282,   -1,  259,   -1,
   -1,   -1,  263,  256,  282,   -1,  259,  268,  269,   -1,
  263,  272,  273,   -1,   -1,  268,  269,   -1,   -1,  272,
  281,  282,   -1,  256,   -1,   -1,  259,   -1,   -1,  282,
  263,   -1,   -1,   -1,   -1,  268,  269,   -1,   -1,  272,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  282,
};
#define YYFINAL 11
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 284
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,
"':'","';'","'<'",0,"'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,"UINT","DOUBLE","BEGIN","RETURN","END","POST","ID","FUNC",
"CTE_UINT","CTE_DOUBLE","CADENA","PRINT","REPEAT","UNTIL","THEN","IF","ELSE",
"ASIG","AND","OR","COMP_MAYOR_IGUAL","COMP_MENOR_IGUAL","COMP_IGUAL",
"COMP_DISTINTO","ENDIF","BREAK","ERR_CTE_FUERA_RANGO","ERR_FORMATO_CTE",
};
char *yyrule[] = {
"$accept : program",
"program : declaracion bloque_sentencias",
"program : bloque_sentencias",
"bloque_sentencias : BEGIN sentencia_ejec END ';'",
"bloque_sentencias : miembro_sentencia_ejec",
"tipo_id : UINT",
"tipo_id : DOUBLE",
"tipo_id : FUNC",
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno END",
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno post_condicion END",
"post_condicion : POST ':' condicion ',' CADENA ';'",
"retorno : '(' expresion ')' ';'",
"declaracion : tipo_id nombre_func params_func definicion_func ';'",
"declaracion : tipo_id lista_variables ';'",
"declaracion : tipo_id lista_variables ';' declaracion",
"declaracion : tipo_id nombre_func params_func definicion_func ';' declaracion",
"lista_variables : ID",
"lista_variables : ID ',' lista_variables",
"nombre_func : FUNC ID",
"nombre_func : FUNC",
"params_func : '(' param ')'",
"params_func : '(' ')'",
"param : tipo_id ID",
"definicion_func : declaracion cuerpo_func",
"definicion_func : cuerpo_func",
"definicion_func :",
"sentencia_ejec : miembro_sentencia_ejec sentencia_ejec",
"sentencia_ejec : miembro_sentencia_ejec",
"miembro_sentencia_ejec : invocacion ';'",
"miembro_sentencia_ejec : asignacion ';'",
"miembro_sentencia_ejec : iteracion ';'",
"miembro_sentencia_ejec : seleccion ';'",
"miembro_sentencia_ejec : impresion ';'",
"miembro_sentencia_ejec : BREAK ';'",
"miembro_sentencia_ejec : seleccion miembro_sentencia_ejec",
"miembro_sentencia_ejec : invocacion miembro_sentencia_ejec",
"miembro_sentencia_ejec : asignacion miembro_sentencia_ejec",
"miembro_sentencia_ejec : iteracion miembro_sentencia_ejec",
"miembro_sentencia_ejec : impresion miembro_sentencia_ejec",
"miembro_sentencia_ejec : BREAK miembro_sentencia_ejec",
"invocacion : ID '(' ')'",
"invocacion : ID '(' ID ')'",
"asignacion : ID ASIG expresion",
"asignacion : ID ASIG error",
"asignacion : ID",
"asignacion : error ASIG expresion",
"expresion : expresion '+' termino",
"expresion : expresion '-' termino",
"expresion : termino",
"termino : termino '*' factor",
"termino : termino '/' factor",
"termino : factor",
"factor : ID",
"factor : CTE_UINT",
"factor : CTE_DOUBLE",
"factor : '-' factor",
"factor : invocacion",
"factor : ERR_CTE_FUERA_RANGO",
"factor : ERR_FORMATO_CTE",
"impresion : PRINT '(' CADENA ')'",
"impresion : PRINT '(' error ')'",
"iteracion : REPEAT bloque_sentencias UNTIL condicion",
"iteracion : REPEAT bloque_sentencias",
"condicion : '(' expresion comparador expresion ')'",
"condicion : '(' expresion comparador expresion",
"condicion : '(' comparador expresion ')'",
"condicion : '(' expresion comparador ')'",
"condicion : '(' expresion operador_logico expresion ')'",
"condicion : '(' error ')'",
"comparador : COMP_MAYOR_IGUAL",
"comparador : COMP_MENOR_IGUAL",
"comparador : '<'",
"comparador : '>'",
"comparador : COMP_IGUAL",
"comparador : COMP_DISTINTO",
"operador_logico : AND",
"operador_logico : OR",
"seleccion : IF condicion THEN bloque_sentencias ENDIF",
"seleccion : IF condicion THEN bloque_sentencias ELSE bloque_sentencias ENDIF",
"seleccion : IF condicion THEN ELSE bloque_sentencias ENDIF",
"seleccion : IF condicion THEN ELSE bloque_sentencias",
"seleccion : IF condicion THEN ENDIF",
"seleccion : IF condicion THEN bloque_sentencias ELSE bloque_sentencias",
"seleccion : IF condicion THEN bloque_sentencias",
};
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 155 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"


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
#line 406 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 12:
#line 39 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 16:
#line 45 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 17:
#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 18:
#line 49 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 19:
#line 50 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el identificador del procedimiento.");}
break;
case 25:
#line 62 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Cuerpo del procedimiento vacio.");}
break;
case 28:
#line 69 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Invocacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 29:
#line 70 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Asignacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 30:
#line 71 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Iteracion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 31:
#line 72 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Seleccion (IF) en la linea " + AnalizadorLexico.nroLinea);}
break;
case 32:
#line 73 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Impresion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 34:
#line 75 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 35:
#line 76 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 36:
#line 77 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 37:
#line 78 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 38:
#line 79 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 39:
#line 80 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 40:
#line 83 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 41:
#line 84 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 43:
#line 88 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
break;
case 44:
#line 89 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
break;
case 45:
#line 90 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
break;
case 57:
#line 113 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
break;
case 58:
#line 114 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
break;
case 60:
#line 118 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " invalid argument for PRINT");}
break;
case 62:
#line 122 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " UNTIL expected");}
break;
case 64:
#line 126 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta parentesis de cierre de la condicion.");}
break;
case 65:
#line 127 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
break;
case 66:
#line 128 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
break;
case 68:
#line 130 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}
break;
case 79:
#line 147 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el bloque de sentencias ejecutables de la rama THEN.");}
break;
case 80:
#line 148 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
break;
case 81:
#line 149 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el bloque de sentencias ejecutables de la rama THEN.");}
break;
case 82:
#line 150 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
break;
case 83:
#line 151 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
break;
#line 686 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
