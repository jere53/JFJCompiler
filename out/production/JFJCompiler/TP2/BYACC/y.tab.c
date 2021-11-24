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
   11,   11,   10,   17,    1,    1,    1,   19,    1,    1,
    1,   18,   18,   14,   15,   15,   20,   16,   16,   16,
    5,    5,    7,    7,    7,    7,    7,    7,    7,    7,
    7,    7,    7,    7,   21,   21,   22,   22,   22,   22,
   13,   13,   13,   26,   26,   26,   27,   27,   27,   27,
   27,   27,   27,   25,   25,   23,   23,   28,   12,   12,
   12,   12,   12,   12,   29,   29,   29,   29,   29,   29,
   30,   30,   24,   24,   31,   31,   32,   32,   33,   33,
};
short yylen[] = {                                         2,
    0,    6,    0,    5,    4,    3,    2,    1,    4,    4,
    1,    1,    1,    1,    5,    6,    4,    5,    5,    6,
    6,    5,    4,    0,    7,    3,    4,    0,    8,    2,
    3,    1,    3,    1,    3,    2,    2,    2,    1,    0,
    2,    1,    2,    2,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    3,    4,    3,    3,    1,    3,
    3,    3,    1,    3,    3,    1,    1,    1,    1,    2,
    1,    1,    1,    4,    4,    4,    2,    1,    5,    4,
    4,    4,    5,    3,    1,    1,    1,    1,    1,    1,
    1,    1,    3,    4,    2,    1,    2,    1,    2,    1,
};
short yydefred[] = {                                      0,
    0,   12,   13,    0,    0,    0,    0,    0,    8,    0,
    0,    0,    0,    0,    0,    0,   78,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   14,
    0,    7,    0,    0,    0,    0,    6,    0,    0,    0,
    0,    0,   95,   48,   54,    0,   41,   43,   50,   44,
   51,   45,   52,   46,   49,   47,   53,    0,    0,   11,
    0,    0,   33,   34,    0,    0,   31,    0,    0,    5,
    0,   68,   69,   72,   73,    0,    0,   71,    0,   66,
   58,    0,    0,   55,    0,    0,    0,   85,   86,   89,
   90,   87,   88,    0,    0,    9,    0,    0,   97,    0,
   93,    0,    0,    0,   27,    0,    4,   70,    0,    0,
    0,    0,   56,   75,   74,   84,   91,   92,    0,    0,
    0,    0,   76,   99,   94,   36,    0,    0,    0,    0,
   39,    0,    2,    0,    0,   64,   65,   82,    0,    0,
   81,   10,   37,   35,    0,   38,    0,   79,   83,    0,
   25,    0,   17,    0,    0,    0,    0,    0,   29,    0,
   19,    0,    0,   15,    0,   18,    0,   20,    0,   16,
    0,   23,    0,   22,   21,
};
short yydgoto[] = {                                       7,
    8,   68,    9,   69,   20,   59,   21,   10,  131,  157,
  158,   43,   77,   65,  104,  132,  151,   11,  152,  128,
   22,   23,   24,   25,   26,   79,   80,   27,   95,  120,
   28,   62,  102,
};
short yysindex[] = {                                   -137,
  -43,    0,    0,  -98,  -35, -182,    0, -218,    0, -215,
   -7,   11, -123, -216,  -39,   56,    0,   60,  -56, -168,
  -98,  -54,  117,  124,  135,  142,  -96, -167, -215,    0,
 -154,    0,   53, -114,    0, -218,    0,    3,   98,  -26,
 -228,   72,    0,    0,    0,   59,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -98, -146,    0,
  -96, -248,    0,    0,   89, -114,    0, -114, -218,    0,
   93,    0,    0,    0,    0,    3,   41,    0,  -18,    0,
    0,   41,   99,    0,  118,  126,  128,    0,    0,    0,
    0,    0,    0,   64,    3,    0,  -97,   60,    0,  -96,
    0, -112,  -28,  -69,    0, -218,    0,    0,    3,    3,
    3,    3,    0,    0,    0,    0,    0,    0,  -41,    3,
   63,  120,    0,    0,    0,    0,  -83,  151,  -98,  -67,
    0,  138,    0,  -18,  -18,    0,    0,    0,  137,  143,
    0,    0,    0,    0,  -63,    0,    0,    0,    0,  -29,
    0, -114,    0,  146, -196,    3, -183,  -53,    0,   60,
    0,  -44,  162,    0,  -42,    0,  178,    0,  147,    0,
  -57,    0,  169,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,  180,  -23,    0,    0,    0,    0,
    0,    0,    0,    0,  153,    0,    0,  -25,    0,    0,
 -105,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -10,   55,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  165,    0,
 -241,    0,    0,    0,    0,   -9,    0,    0,    0,    0,
  -24,    0,    0,    0,    0,    0,  176,    0,    2,    0,
    0,  183,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -22,
    0,    0,    0,  202,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   28,   54,    0,    0,    0,  102,    0,
    0,    0,    0,    0,    0,    0,  203,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   -3,    0,   24,    0,  -14,  -49,   31,    8,  132,    0,
  -66,  -92,  -17,    0,    0,    0,    0,   -2,    0,    0,
   43,    0,    0,    0,    0,   38,  -37,    0,  170,    0,
    0,    0,    0,
};
#define YYTABLESIZE 468
short yytable[] = {                                     138,
   40,  174,   44,   76,   48,  123,   47,   33,   29,   36,
  156,   99,  126,   31,   84,   13,   67,   67,   67,   67,
   67,   82,   67,  111,   94,  100,   63,   85,  112,  155,
   67,   32,   98,  101,   67,   67,   37,   67,  108,   86,
   98,    4,   63,   97,   63,   63,   63,   76,    5,   45,
  124,   34,   49,   51,   53,   55,   57,   60,   38,   70,
   63,   63,  105,   63,  106,  161,  154,  167,   61,   35,
   61,   61,   61,  136,  137,    2,    3,  121,  164,  154,
   78,   78,   30,  109,   78,  110,   61,   61,  162,   61,
  165,   60,  107,   46,   62,   41,   62,   62,   62,   42,
  130,  139,  140,  141,   61,  109,  109,  110,  110,   64,
  127,   66,   62,   62,  145,   62,   76,   96,   78,    1,
    2,    3,    4,   92,   98,   93,    5,    6,  103,  133,
   60,   92,   40,   93,    2,    3,    4,   78,  163,  113,
    5,    6,   76,    2,    3,   80,  134,  135,  159,    5,
    6,   78,   78,   78,   78,   42,   42,   14,  114,   14,
   80,   78,   78,   58,  122,   15,  115,   15,  116,  125,
   16,   17,   16,   17,   18,   50,   18,  148,  142,  109,
  143,  110,   52,  149,   19,  109,   19,  110,    2,    3,
  129,  144,  129,   54,    5,    6,  147,  150,   78,   14,
   56,   14,  169,  160,  109,  172,  110,   15,  166,   15,
  173,   59,   16,   17,   16,   17,   18,  168,   18,  170,
   12,  171,   71,   77,   72,   73,   19,  175,   19,    2,
    3,   67,  153,  154,   60,   39,   30,   83,   32,   67,
   14,   57,   74,   75,   67,   67,   96,   67,   67,   30,
   26,   67,   67,   67,   67,   67,   67,   63,   67,  100,
   40,  146,    0,  119,    0,   63,   71,    0,   72,   73,
   63,   63,    0,   63,   63,    0,    0,   63,   63,   63,
   63,   63,   63,   61,   63,    0,   74,   75,    0,    0,
    0,   61,    0,    0,    0,    0,   61,   61,    0,   61,
   61,    0,    0,   61,   61,   61,   61,   61,   61,   62,
   61,    0,    1,    1,    3,    0,    0,   62,    1,    1,
    0,    0,   62,   62,    0,   62,   62,   87,    0,   62,
   62,   62,   62,   62,   62,   71,   62,   72,   73,  117,
  118,   88,   89,   90,   91,    0,    0,    0,    0,   88,
   89,   90,   91,   81,    0,   74,   75,   80,    0,    0,
    0,   71,    0,   72,   73,   80,    0,    0,    0,    0,
   80,   80,   14,   80,   80,    0,    0,    0,    0,   14,
   15,   74,   75,    0,   80,   16,   17,   15,    0,   18,
   14,    0,   16,   17,    0,    0,   18,   14,   15,   19,
    0,    0,    0,   16,   17,   15,   19,   18,   59,    0,
   16,   17,    0,    0,   18,    0,   59,   19,    0,    0,
   77,   59,   59,    0,   19,   59,    0,    0,   77,    0,
    0,   60,    0,   77,   77,   59,    0,   77,   57,   60,
    0,    0,    0,    0,   60,   60,   57,   77,   60,    0,
    0,   57,   57,    0,    0,   57,    0,    0,   60,    0,
   28,   28,   24,    0,    0,   57,   28,   28,
};
short yycheck[] = {                                      41,
   40,   59,   59,   45,   59,   98,   21,   10,   44,   13,
   40,   61,   41,    6,   41,   59,   41,   42,   43,   44,
   45,   39,   47,   42,   42,  274,   29,  256,   47,   59,
   34,    8,  274,  282,   59,   60,   13,   62,   76,  268,
  282,  260,   41,   58,   43,   44,   45,   45,  264,   19,
  100,   59,   22,   23,   24,   25,   26,   27,  275,   36,
   59,   60,   66,   62,   68,  262,  263,  160,   41,   59,
   43,   44,   45,  111,  112,  258,  259,   95,  262,  263,
   38,   39,  265,   43,   42,   45,   59,   60,  155,   62,
  157,   61,   69,  262,   41,   40,   43,   44,   45,   40,
  104,  119,  120,   41,  272,   43,   43,   45,   45,  264,
  103,   59,   59,   60,  129,   62,   45,   59,   76,  257,
  258,  259,  260,   60,  271,   62,  264,  265,   40,  106,
  100,   60,   40,   62,  258,  259,  260,   95,  156,   41,
  264,  265,   45,  258,  259,   44,  109,  110,  152,  264,
  265,  109,  110,  111,  112,  261,  262,  256,   41,  256,
   59,  119,  120,  260,  262,  264,   41,  264,   41,  282,
  269,  270,  269,  270,  273,   59,  273,   41,   59,   43,
  264,   45,   59,   41,  283,   43,  283,   45,  258,  259,
  260,   41,  260,   59,  264,  265,   59,  261,  156,  256,
   59,  256,   41,   58,   43,   59,   45,  264,  262,  264,
  268,   59,  269,  270,  269,  270,  273,  262,  273,  262,
  264,   44,  264,   59,  266,  267,  283,   59,  283,  258,
  259,  256,  262,  263,   59,  275,  265,  264,   59,  264,
  264,   59,  284,  285,  269,  270,  272,  272,  273,  260,
  260,  276,  277,  278,  279,  280,  281,  256,  283,  282,
   59,  130,   -1,   94,   -1,  264,  264,   -1,  266,  267,
  269,  270,   -1,  272,  273,   -1,   -1,  276,  277,  278,
  279,  280,  281,  256,  283,   -1,  284,  285,   -1,   -1,
   -1,  264,   -1,   -1,   -1,   -1,  269,  270,   -1,  272,
  273,   -1,   -1,  276,  277,  278,  279,  280,  281,  256,
  283,   -1,  258,  259,  260,   -1,   -1,  264,  264,  265,
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
  258,  259,  260,   -1,   -1,  283,  264,  265,
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
"$$3 :",
"declaracion : FUNC tipo_id nombre_func params_func definicion_func ';' $$3",
"declaracion : tipo_id lista_variables ';'",
"declaracion : tipo_id lista_variables ';' declaracion",
"$$4 :",
"declaracion : FUNC tipo_id nombre_func params_func definicion_func ';' $$4 declaracion",
"declaracion : lista_variables ';'",
"declaracion : lista_variables ';' declaracion",
"lista_variables : ID",
"lista_variables : ID ',' lista_variables",
"nombre_func : ID",
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
#line 192 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"

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
#line 419 "y.tab.c"
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
{ Ambito.borrarAmbito();}
break;
case 25:
#line 52 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.setTipoIDFuncionCacheado(Integer.toString(yyvsp[-6].ival));}
break;
case 26:
#line 53 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(yyvsp[-2].ival));}
break;
case 27:
#line 54 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(yyvsp[-3].ival));}
break;
case 28:
#line 55 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ Ambito.borrarAmbito();}
break;
case 29:
#line 55 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.setTipoIDFuncionCacheado(Integer.toString(yyvsp[-7].ival));}
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
{System.out.println("ANDA LPM" + yyvsp[0].sval); TablaSimbolos.cambiarNombre(yyvsp[0].sval, yyvsp[0].sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(yyvsp[0].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(yyvsp[0].sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 33:
#line 61 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ System.out.println("ANDA LPM2" + yyvsp[-2].sval);  TablaSimbolos.cambiarNombre(yyvsp[-2].sval, yyvsp[-2].sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(yyvsp[-2].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(yyvsp[-2].sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 34:
#line 64 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.cambiarNombre(yyvsp[0].sval, yyvsp[0].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(yyvsp[0].sval + Ambito.retornarNaming()).setUso("nombre_funcion"); Utils.cachearIDFuncion(yyvsp[0].sval + Ambito.retornarNaming()); Ambito.agregarAmbito(yyvsp[0].sval); }
break;
case 37:
#line 71 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(yyvsp[0].sval).setTipo(Integer.toString(yyvsp[-1].ival)); TablaSimbolos.punteroTS(yyvsp[0].sval).setUso("parametro"); TablaSimbolos.cambiarNombre(yyvsp[0].sval, yyvsp[0].sval + Ambito.retornarNaming()); }
break;
case 40:
#line 76 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Cuerpo del procedimiento vacio.");}
break;
case 43:
#line 83 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Invocacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 44:
#line 84 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Asignacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 45:
#line 85 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Iteracion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 46:
#line 86 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Seleccion (IF) en la linea " + AnalizadorLexico.nroLinea);}
break;
case 47:
#line 87 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Impresion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 49:
#line 89 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
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
#line 97 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(yyvsp[-2].sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)));}
break;
case 56:
#line 98 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(yyvsp[-3].sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-3].sval))); if (Ambito.bindAmbito(yyvsp[-3].sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)));}
break;
case 57:
#line 101 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(yyvsp[-2].sval) != null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)));} Polaca.insert(new Integer(ASIG));}
break;
case 58:
#line 102 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
break;
case 59:
#line 103 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
break;
case 60:
#line 104 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
break;
case 61:
#line 107 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('+'));}
break;
case 62:
#line 108 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('-'));}
break;
case 64:
#line 112 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('*'));}
break;
case 65:
#line 113 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('/'));}
break;
case 67:
#line 117 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(yyvsp[0].sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[0].sval)));}
break;
case 68:
#line 118 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(yyvsp[0].sval)); TablaSimbolos.punteroTS(yyvsp[0].sval).setTipo(Integer.toString(Parser.CTE_UINT)); TablaSimbolos.punteroTS(yyvsp[0].sval).setUso("cte");}
break;
case 69:
#line 119 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(yyvsp[0].sval)); TablaSimbolos.punteroTS(yyvsp[0].sval).setTipo(Integer.toString(Parser.CTE_DOUBLE)); TablaSimbolos.punteroTS(yyvsp[0].sval).setUso("cte");}
break;
case 70:
#line 120 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{  /*Sacamos lo ultimo que agregamos a la polaca, porque ya no es valido.
								                Determinamos que signo va a tener la cte.
								                Si es negativa, agregamos "-sval" a la TS.
								                Agregamos el string correcto (devuelto por utils.sig....) a la polaca.*/
                                                Polaca.insert(TablaSimbolos.punteroTS(Utils.signoNegativo(yyvsp[0].sval)));
                                                }
break;
case 72:
#line 127 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
break;
case 73:
#line 128 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
break;
case 74:
#line 131 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(yyvsp[-1].sval)); Polaca.insert(new Integer(PRINT));}
break;
case 75:
#line 132 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " invalid argument for PRINT");}
break;
case 76:
#line 135 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_iteracion_end();}
break;
case 77:
#line 136 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " UNTIL expected");}
break;
case 78:
#line 142 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_iteracion_start();}
break;
case 79:
#line 145 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(yyvsp[-2].ival));}
break;
case 80:
#line 146 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta parentesis de cierre de la condicion.");}
break;
case 81:
#line 147 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
break;
case 82:
#line 148 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
break;
case 83:
#line 149 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(yyvsp[-2].sval));}
break;
case 84:
#line 150 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}
break;
case 93:
#line 176 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 95:
#line 180 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_cond();}
break;
case 96:
#line 181 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en el encabezado de la condicion, falta la condicion del IF");}
break;
case 97:
#line 184 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_then();}
break;
case 98:
#line 185 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia THEN, falta el bloque de sentencias");}
break;
case 99:
#line 188 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 100:
#line 189 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia ELSE, falta el bloque de sentencias");}
break;
#line 848 "y.tab.c"
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
