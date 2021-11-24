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
	import TP3.Ambito;
#line 15 "y.tab.c"
#define PROGRAM 257
#define UINT 258
#define DOUBLE 259
#define BEGIN 260
#define RETURN 261
#define END 262
#define POST 263
#define ID 264
#define FUNC 265
#define CTE_UINT 266
#define CTE_DOUBLE 267
#define CADENA 268
#define PRINT 269
#define REPEAT 270
#define UNTIL 271
#define THEN 272
#define IF 273
#define ELSE 274
#define ASIG 275
#define AND 276
#define OR 277
#define COMP_MAYOR_IGUAL 278
#define COMP_MENOR_IGUAL 279
#define COMP_IGUAL 280
#define COMP_DISTINTO 281
#define ENDIF 282
#define BREAK 283
#define ERR_CTE_FUERA_RANGO 284
#define ERR_FORMATO_CTE 285
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    2,    0,    4,    0,    0,    0,    0,    0,    3,    6,
    6,    8,    8,    8,    9,    9,    9,    9,    9,    9,
   11,   11,   10,    1,    1,   18,    1,   19,    1,    1,
    1,   17,   17,   14,   14,   15,   15,   20,   16,   16,
   16,    5,    5,    7,    7,    7,    7,    7,    7,    7,
    7,    7,    7,    7,    7,   21,   21,   22,   22,   22,
   22,   13,   13,   13,   26,   26,   26,   27,   27,   27,
   27,   27,   27,   27,   25,   25,   23,   23,   28,   12,
   12,   12,   12,   12,   12,   29,   29,   29,   29,   29,
   29,   30,   30,   24,   24,   31,   31,   32,   32,   33,
   33,
};
short yylen[] = {                                         2,
    0,    6,    0,    5,    4,    3,    2,    1,    4,    4,
    1,    1,    1,    1,    5,    6,    4,    5,    5,    6,
    6,    5,    4,    5,    3,    0,    5,    0,    7,    2,
    3,    1,    3,    2,    1,    3,    2,    2,    2,    1,
    0,    2,    1,    2,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    2,    3,    4,    3,    3,    1,
    3,    3,    3,    1,    3,    3,    1,    1,    1,    1,
    2,    1,    1,    1,    4,    4,    4,    2,    1,    5,
    4,    4,    4,    5,    3,    1,    1,    1,    1,    1,
    1,    1,    1,    3,    4,    2,    1,    2,    1,    2,
    1,
};
short yydefred[] = {                                      0,
    0,   12,   13,    0,    0,   14,    0,    0,    8,    0,
    0,    0,    0,    0,    0,    0,   79,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    7,
    0,    0,    0,    0,    0,    0,    6,    0,    0,    0,
    0,    0,   96,   49,   55,    0,   42,   44,   51,   45,
   52,   46,   53,   47,   50,   48,   54,    0,    0,   11,
    0,    0,   33,   34,    0,    0,    0,   31,    0,    0,
    5,    0,   69,   70,   73,   74,    0,    0,   72,    0,
   67,   59,    0,    0,   56,    0,    0,    0,   86,   87,
   90,   91,   88,   89,    0,    0,    9,    0,    0,   98,
    0,   94,    0,   37,    0,    0,    0,    0,   40,    0,
    0,    0,    4,   71,    0,    0,    0,    0,   57,   76,
   75,   85,   92,   93,    0,    0,    0,    0,   77,  100,
   95,   38,   36,    0,   39,    0,   27,    2,    0,    0,
   65,   66,   83,    0,    0,   82,   10,    0,    0,   80,
   84,   17,    0,    0,    0,    0,    0,   29,    0,   19,
    0,    0,   15,    0,   18,    0,   20,    0,   16,    0,
   23,    0,   22,   21,
};
short yydgoto[] = {                                       7,
    8,   69,    9,   70,   20,   59,   21,   10,  109,  156,
  157,   43,   78,   32,   66,  110,   11,  111,  149,  106,
   22,   23,   24,   25,   26,   80,   81,   27,   96,  126,
   28,   62,  103,
};
short yysindex[] = {                                   -102,
  -43,    0,    0, -189,  -36,    0,    0, -218,    0, -224,
   -2,   15,  -80, -192,  -39,   56,    0,   68,  -56, -147,
 -189,  -54,  117,  124,  135,  142, -131, -153, -142,    0,
 -137,   88,   71, -205,    0, -218,    0,    3,   98,  -26,
 -246,   72,    0,    0,    0,   77,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -189, -136,    0,
 -131, -230,    0,    0,  -28,  -72,    0,    0, -205, -218,
    0,   97,    0,    0,    0,    0,    3,   13,    0,   76,
    0,    0,   13,   99,    0,  103,  110,  112,    0,    0,
    0,    0,    0,    0,   64,    3,    0, -108,   68,    0,
 -131,    0, -123,    0, -104,  123, -189,  -94,    0,  108,
 -205, -218,    0,    0,    3,    3,    3,    3,    0,    0,
    0,    0,    0,    0,  -41,    3,  104,  115,    0,    0,
    0,    0,    0,  -86,    0,    0,    0,    0,   76,   76,
    0,    0,    0,  177,  219,    0,    0,  -29, -205,    0,
    0,    0,  119, -186,    3, -177,  -81,    0,   68,    0,
  -53,  220,    0,  -34,    0,  138,    0,  147,    0,  -57,
    0,  180,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,  182,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  153,    0,    0,  -67,    0,    0,
 -169,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  210,    0,    0,   -9,  -69,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  165,    0,
 -204,    0,    0,    0,    0,  209,  -61,    0,    0,    0,
    0,  -24,    0,    0,    0,    0,    0,  176,    0,    2,
    0,    0,  183,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   -6,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   31,    0,    0,   28,   54,
    0,    0,    0,  102,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   -1,    0,   19,    0,   -7,  -22,  146,  208,  169,    0,
 -125,  -93,   -5,    0,    0,    0,   -3,    0,    0,    0,
  -14,    0,    0,    0,    0,  -10,  -68,    0,  191,    0,
    0,    0,    0,
};
#define YYTABLESIZE 466
short yytable[] = {                                     143,
   40,  173,   44,   77,   48,  129,   33,   29,  114,   86,
  155,   36,  104,   47,   85,   13,   68,   68,   68,   68,
   68,   87,   68,   79,   79,   63,   30,   79,  161,  154,
  164,   37,   68,   83,   68,   68,   95,   68,  100,    5,
   31,    4,   64,  101,   64,   64,   64,   77,  141,  142,
   98,  102,    2,    3,   71,  115,   34,  116,    5,    6,
   64,   64,   79,   64,  108,  166,   14,  112,   62,   99,
   62,   62,   62,   35,   15,  160,  153,   99,  130,   16,
   17,   79,   38,   18,  163,  153,   62,   62,  113,   62,
  127,   43,   43,   19,   63,   41,   63,   63,   63,  134,
   79,   79,   79,   79,  139,  140,  115,   42,  116,  137,
   79,   79,   63,   63,   46,   63,   77,  117,   61,  144,
  145,    5,  118,   93,   14,   94,   64,   65,   58,   67,
  138,   93,   15,   94,   99,   97,   40,   16,   17,  119,
   79,   18,   77,  120,  146,   81,  115,  158,  116,  162,
  121,   19,  122,  128,    1,    2,    3,    4,  131,  132,
   81,    5,    6,  133,   45,  107,  136,   49,   51,   53,
   55,   57,   60,  147,  148,   50,  159,    2,    3,    4,
  165,  170,   52,    5,    6,    2,    3,  107,    1,    1,
    3,    5,    6,   54,    1,    1,   26,   26,   25,   14,
   56,   14,   26,   26,   97,  171,   60,   15,  167,   15,
  172,   60,   16,   17,   16,   17,   18,  150,   18,  115,
   12,  116,   72,   78,   73,   74,   19,  169,   19,    2,
    3,   68,  152,  153,   61,   39,    6,   84,  174,   68,
   32,   58,   75,   76,   68,   68,   60,   68,   68,   35,
   30,   68,   68,   68,   68,   68,   68,   64,   68,  151,
  168,  115,  115,  116,  116,   64,   72,   41,   73,   74,
   64,   64,  105,   64,   64,  101,  135,   64,   64,   64,
   64,   64,   64,   62,   64,  125,   75,   76,   28,   28,
   24,   62,    0,    0,   28,   28,   62,   62,    0,   62,
   62,    0,    0,   62,   62,   62,   62,   62,   62,   63,
   62,    0,    0,    0,    0,    0,    0,   63,    0,    0,
    0,    0,   63,   63,    0,   63,   63,   88,    0,   63,
   63,   63,   63,   63,   63,   72,   63,   73,   74,  123,
  124,   89,   90,   91,   92,    0,    0,    0,    0,   89,
   90,   91,   92,   82,    0,   75,   76,   81,    0,    0,
    0,   72,    0,   73,   74,   81,    0,    0,    0,    0,
   81,   81,   14,   81,   81,    0,    0,    0,    0,   14,
   15,   75,   76,    0,   81,   16,   17,   15,    0,   18,
   14,    0,   16,   17,    0,    0,   18,   14,   15,   19,
    0,    0,    0,   16,   17,   15,   19,   18,   60,    0,
   16,   17,    0,    0,   18,    0,   60,   19,    0,    0,
   78,   60,   60,    0,   19,   60,    0,    0,   78,    0,
    0,   61,    0,   78,   78,   60,    0,   78,   58,   61,
    0,    0,    0,    0,   61,   61,   58,   78,   61,    0,
    0,   58,   58,    0,    0,   58,    0,    0,   61,    0,
    0,    0,    0,    0,    0,   58,
};
short yycheck[] = {                                      41,
   40,   59,   59,   45,   59,   99,   10,   44,   77,  256,
   40,   13,   41,   21,   41,   59,   41,   42,   43,   44,
   45,  268,   47,   38,   39,   29,    8,   42,  154,   59,
  156,   13,   34,   39,   59,   60,   42,   62,   61,  264,
  265,  260,   41,  274,   43,   44,   45,   45,  117,  118,
   58,  282,  258,  259,   36,   43,   59,   45,  264,  265,
   59,   60,   77,   62,   66,  159,  256,   69,   41,  274,
   43,   44,   45,   59,  264,  262,  263,  282,  101,  269,
  270,   96,  275,  273,  262,  263,   59,   60,   70,   62,
   96,  261,  262,  283,   41,   40,   43,   44,   45,  107,
  115,  116,  117,  118,  115,  116,   43,   40,   45,  111,
  125,  126,   59,   60,  262,   62,   45,   42,  272,  125,
  126,  264,   47,   60,  256,   62,  264,   40,  260,   59,
  112,   60,  264,   62,  271,   59,   40,  269,  270,   41,
  155,  273,   45,   41,   41,   44,   43,  149,   45,  155,
   41,  283,   41,  262,  257,  258,  259,  260,  282,  264,
   59,  264,  265,   41,   19,  260,   59,   22,   23,   24,
   25,   26,   27,   59,  261,   59,   58,  258,  259,  260,
  262,   44,   59,  264,  265,  258,  259,  260,  258,  259,
  260,  264,  265,   59,  264,  265,  258,  259,  260,  256,
   59,  256,  264,  265,  272,   59,   61,  264,  262,  264,
  268,   59,  269,  270,  269,  270,  273,   41,  273,   43,
  264,   45,  264,   59,  266,  267,  283,  262,  283,  258,
  259,  256,  262,  263,   59,  275,  265,  264,   59,  264,
   59,   59,  284,  285,  269,  270,  101,  272,  273,   40,
  260,  276,  277,  278,  279,  280,  281,  256,  283,   41,
   41,   43,   43,   45,   45,  264,  264,   59,  266,  267,
  269,  270,   65,  272,  273,  282,  108,  276,  277,  278,
  279,  280,  281,  256,  283,   95,  284,  285,  258,  259,
  260,  264,   -1,   -1,  264,  265,  269,  270,   -1,  272,
  273,   -1,   -1,  276,  277,  278,  279,  280,  281,  256,
  283,   -1,   -1,   -1,   -1,   -1,   -1,  264,   -1,   -1,
   -1,   -1,  269,  270,   -1,  272,  273,  256,   -1,  276,
  277,  278,  279,  280,  281,  264,  283,  266,  267,  276,
  277,  278,  279,  280,  281,   -1,   -1,   -1,   -1,  278,
  279,  280,  281,  256,   -1,  284,  285,  256,   -1,   -1,
   -1,  264,   -1,  266,  267,  264,   -1,   -1,   -1,   -1,
  269,  270,  256,  272,  273,   -1,   -1,   -1,   -1,  256,
  264,  284,  285,   -1,  283,  269,  270,  264,   -1,  273,
  256,   -1,  269,  270,   -1,   -1,  273,  256,  264,  283,
   -1,   -1,   -1,  269,  270,  264,  283,  273,  256,   -1,
  269,  270,   -1,   -1,  273,   -1,  264,  283,   -1,   -1,
  256,  269,  270,   -1,  283,  273,   -1,   -1,  264,   -1,
   -1,  256,   -1,  269,  270,  283,   -1,  273,  256,  264,
   -1,   -1,   -1,   -1,  269,  270,  264,  283,  273,   -1,
   -1,  269,  270,   -1,   -1,  273,   -1,   -1,  283,   -1,
   -1,   -1,   -1,   -1,   -1,  283,
};
#define YYFINAL 7
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 285
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,
"':'","';'","'<'",0,"'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,"PROGRAM","UINT","DOUBLE","BEGIN","RETURN","END","POST","ID",
"FUNC","CTE_UINT","CTE_DOUBLE","CADENA","PRINT","REPEAT","UNTIL","THEN","IF",
"ELSE","ASIG","AND","OR","COMP_MAYOR_IGUAL","COMP_MENOR_IGUAL","COMP_IGUAL",
"COMP_DISTINTO","ENDIF","BREAK","ERR_CTE_FUERA_RANGO","ERR_FORMATO_CTE",
};
char *yyrule[] = {
"$accept : program",
"$$1 :",
"program : PROGRAM ID ';' $$1 declaracion cuerpo_programa",
"$$2 :",
"program : PROGRAM ID ';' $$2 cuerpo_programa",
"program : PROGRAM ';' declaracion cuerpo_programa",
"program : PROGRAM ';' cuerpo_programa",
"program : declaracion cuerpo_programa",
"program : cuerpo_programa",
"cuerpo_programa : BEGIN sentencia_ejec END ';'",
"bloque_sentencias : BEGIN sentencia_ejec END ';'",
"bloque_sentencias : miembro_sentencia_ejec",
"tipo_id : UINT",
"tipo_id : DOUBLE",
"tipo_id : FUNC",
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno END",
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno post_condicion END",
"cuerpo_func : BEGIN sentencia_ejec RETURN END",
"cuerpo_func : BEGIN sentencia_ejec RETURN post_condicion END",
"cuerpo_func : BEGIN sentencia_ejec RETURN ';' END",
"cuerpo_func : BEGIN sentencia_ejec RETURN ';' post_condicion END",
"post_condicion : POST ':' condicion ',' CADENA ';'",
"post_condicion : POST ':' condicion ',' ';'",
"retorno : '(' expresion ')' ';'",
"declaracion : tipo_id nombre_func params_func definicion_func ';'",
"declaracion : tipo_id lista_variables ';'",
"$$3 :",
"declaracion : tipo_id lista_variables ';' $$3 declaracion",
"$$4 :",
"declaracion : tipo_id nombre_func params_func definicion_func ';' $$4 declaracion",
"declaracion : lista_variables ';'",
"declaracion : lista_variables ';' declaracion",
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
"iteracion : encabezado_iteracion bloque_sentencias UNTIL condicion",
"iteracion : encabezado_iteracion bloque_sentencias",
"encabezado_iteracion : REPEAT",
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
"seleccion : encabezado_if rama_then ENDIF",
"seleccion : encabezado_if rama_then rama_else ENDIF",
"encabezado_if : IF condicion",
"encabezado_if : IF",
"rama_then : THEN bloque_sentencias",
"rama_then : THEN",
"rama_else : ELSE bloque_sentencias",
"rama_else : ELSE",
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
#line 193 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"

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
#line 422 "y.tab.c"
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
case 1:
#line 17 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Ambito.agregarAmbito("main");}
break;
case 3:
#line 18 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Ambito.agregarAmbito("main");}
break;
case 5:
#line 19 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
break;
case 6:
#line 20 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
break;
case 7:
#line 21 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got declaracion instead");}
break;
case 8:
#line 22 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got cuerpo_programa instead");}
break;
case 17:
#line 39 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 18:
#line 40 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 19:
#line 41 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 20:
#line 42 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 21:
#line 45 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(yyvsp[-1].sval).setTipo("cadena_caracteres"); TablaSimbolos.punteroTS(yyvsp[-1].sval).setUso("msj_postcondicion");}
break;
case 22:
#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " CADENA expected but got ; instead");}
break;
case 23:
#line 49 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("Retorno");}
break;
case 24:
#line 52 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.setTipoIDFuncionCacheado(Integer.toString(yyvsp[-4].ival));}
break;
case 25:
#line 53 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(yyvsp[-2].ival));}
break;
case 26:
#line 54 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ Ambito.borrarAmbito();}
break;
case 27:
#line 54 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(yyvsp[-4].ival));}
break;
case 28:
#line 55 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ Ambito.borrarAmbito();}
break;
case 29:
#line 55 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.setTipoIDFuncionCacheado(Integer.toString(yyvsp[-6].ival));}
break;
case 30:
#line 56 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 31:
#line 57 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 32:
#line 60 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{System.out.println("ANDA LPM"); TablaSimbolos.cambiarNombre(yyvsp[0].sval, yyvsp[0].sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(yyvsp[0].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(yyvsp[0].sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 33:
#line 61 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ System.out.println("ANDA LPM2");  TablaSimbolos.cambiarNombre(yyvsp[-2].sval, yyvsp[-2].sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(yyvsp[-2].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(yyvsp[-2].sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 34:
#line 64 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.cambiarNombre(yyvsp[0].sval, yyvsp[0].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(yyvsp[0].sval + Ambito.retornarNaming()).setUso("nombre_funcion"); Utils.cachearIDFuncion(yyvsp[0].sval + Ambito.retornarNaming()); Ambito.agregarAmbito(yyvsp[0].sval); }
break;
case 35:
#line 65 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el identificador del procedimiento.");}
break;
case 38:
#line 72 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(yyvsp[0].sval).setTipo(Integer.toString(yyvsp[-1].ival)); TablaSimbolos.punteroTS(yyvsp[0].sval).setUso("parametro"); TablaSimbolos.cambiarNombre(yyvsp[0].sval, yyvsp[0].sval + Ambito.retornarNaming()); }
break;
case 41:
#line 77 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Cuerpo del procedimiento vacio.");}
break;
case 44:
#line 84 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Invocacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 45:
#line 85 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Asignacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 46:
#line 86 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Iteracion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 47:
#line 87 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Seleccion (IF) en la linea " + AnalizadorLexico.nroLinea);}
break;
case 48:
#line 88 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Impresion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 50:
#line 90 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 51:
#line 91 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 52:
#line 92 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 53:
#line 93 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 54:
#line 94 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 55:
#line 95 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 56:
#line 98 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(yyvsp[-2].sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)));}
break;
case 57:
#line 99 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(yyvsp[-3].sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-3].sval))); if (Ambito.bindAmbito(yyvsp[-3].sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)));}
break;
case 58:
#line 102 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(yyvsp[-2].sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval))); Polaca.insert(new Integer(ASIG));}
break;
case 59:
#line 103 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
break;
case 60:
#line 104 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
break;
case 61:
#line 105 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
break;
case 62:
#line 108 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('+'));}
break;
case 63:
#line 109 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('-'));}
break;
case 65:
#line 113 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('*'));}
break;
case 66:
#line 114 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('/'));}
break;
case 68:
#line 118 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(yyvsp[0].sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[0].sval)));}
break;
case 69:
#line 119 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(yyvsp[0].sval)); TablaSimbolos.punteroTS(yyvsp[0].sval).setTipo(Integer.toString(Parser.CTE_UINT)); TablaSimbolos.punteroTS(yyvsp[0].sval).setUso("cte");}
break;
case 70:
#line 120 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(yyvsp[0].sval)); TablaSimbolos.punteroTS(yyvsp[0].sval).setTipo(Integer.toString(Parser.CTE_DOUBLE)); TablaSimbolos.punteroTS(yyvsp[0].sval).setUso("cte");}
break;
case 71:
#line 121 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{  /*Sacamos lo ultimo que agregamos a la polaca, porque ya no es valido.
								                Determinamos que signo va a tener la cte.
								                Si es negativa, agregamos "-sval" a la TS.
								                Agregamos el string correcto (devuelto por utils.sig....) a la polaca.*/
                                                Polaca.insert(TablaSimbolos.punteroTS(Utils.signoNegativo(yyvsp[0].sval)));
                                                }
break;
case 73:
#line 128 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
break;
case 74:
#line 129 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
break;
case 75:
#line 132 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(yyvsp[-1].sval)); Polaca.insert(new Integer(PRINT));}
break;
case 76:
#line 133 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " invalid argument for PRINT");}
break;
case 77:
#line 136 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_iteracion_end();}
break;
case 78:
#line 137 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " UNTIL expected");}
break;
case 79:
#line 143 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_iteracion_start();}
break;
case 80:
#line 146 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(yyvsp[-2].ival));}
break;
case 81:
#line 147 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta parentesis de cierre de la condicion.");}
break;
case 82:
#line 148 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
break;
case 83:
#line 149 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
break;
case 84:
#line 150 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(yyvsp[-2].sval));}
break;
case 85:
#line 151 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}
break;
case 94:
#line 177 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 96:
#line 181 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_cond();}
break;
case 97:
#line 182 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en el encabezado de la condicion, falta la condicion del IF");}
break;
case 98:
#line 185 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_then();}
break;
case 99:
#line 186 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia THEN, falta el bloque de sentencias");}
break;
case 100:
#line 189 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 101:
#line 190 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia ELSE, falta el bloque de sentencias");}
break;
#line 855 "y.tab.c"
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
