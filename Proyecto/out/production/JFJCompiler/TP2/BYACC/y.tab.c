#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "../gramatica.y"
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
    2,    4,    0,    5,    0,    0,    0,    0,    0,    0,
    3,    3,    7,    7,    9,    9,    9,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   14,   15,   16,
   12,   12,   11,    1,    1,    1,   22,    1,    1,    1,
   21,   21,   21,   18,   19,   19,   23,   24,   20,   25,
   20,   20,    6,    6,    8,    8,    8,    8,    8,    8,
    8,    8,    8,    8,    8,    8,   26,   26,   27,   27,
   27,   27,   17,   17,   17,   31,   31,   31,   32,   32,
   32,   32,   32,   32,   32,   30,   30,   28,   28,   33,
   13,   13,   13,   13,   13,   34,   34,   34,   34,   34,
   34,   35,   35,   29,   29,   36,   36,   37,   37,   38,
   38,
};
short yylen[] = {                                         2,
    0,    0,    7,    0,    5,    4,    3,    2,    1,    4,
    4,    3,    4,    1,    1,    1,    1,    5,    6,    4,
    5,    5,    6,    6,    7,    6,    7,    0,    0,    0,
    9,    5,    4,    6,    3,    4,    0,    8,    2,    3,
    1,    3,    2,    1,    3,    2,    2,    0,    3,    0,
    2,    0,    2,    1,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    2,    2,    3,    4,    3,    3,
    1,    3,    3,    3,    1,    3,    3,    1,    1,    1,
    1,    2,    1,    1,    1,    4,    4,    4,    2,    1,
    5,    4,    4,    5,    3,    1,    1,    1,    1,    1,
    1,    1,    1,    3,    4,    2,    1,    2,    1,    2,
    1,
};
short yydefred[] = {                                      0,
    0,   15,   16,    0,    0,    0,    0,    0,    9,    0,
    0,    0,    0,    0,    0,    0,    0,   90,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   43,
    0,   17,    0,    8,    0,    0,    0,    0,    7,    0,
   12,    0,    0,    0,    0,  106,   60,   66,    0,   53,
   55,   62,   56,   63,   57,   64,   58,   61,   59,   65,
    0,    0,   14,    0,    0,   42,   44,    0,    0,   40,
   10,    0,    0,    6,    0,   80,   81,   84,   85,    0,
    0,   83,    0,   78,   70,    0,   67,    0,    0,    0,
    0,   96,   97,  100,  101,   98,   99,    0,    0,    0,
   11,    0,    0,  108,    0,  104,    0,    0,    0,   36,
    2,    5,   82,    0,    0,    0,    0,   68,   87,   86,
   95,  102,  103,    0,    0,    0,    0,   88,  110,  105,
   46,    0,    0,   48,    0,    0,    0,    0,    0,   76,
   77,    0,   93,    0,   92,   13,   47,   45,    0,    0,
    0,   51,    3,   94,   91,   49,    0,    0,   38,    0,
   20,    0,    0,    0,    0,    0,    0,   22,    0,    0,
    0,    0,   21,    0,   23,    0,   26,   24,    0,    0,
   33,   27,   25,    0,   32,   28,   29,   30,   31,
};
short yydgoto[] = {                                       7,
    8,   72,    9,  137,   73,   21,   62,   22,   10,  152,
  165,  166,   46,  187,  188,  189,   81,   68,  109,  135,
   11,  157,  133,  149,  136,   23,   24,   25,   26,   27,
   83,   84,   28,  100,  124,   29,   65,  107,
};
short yysindex[] = {                                    -91,
  -50,    0,    0, -137,  -42, -194,    0, -247,    0, -222,
  -32,   -1,  -68, -214,   16,  -33,   44,    0,   51,  -58,
 -151,  158,   75,   82,   93,  100,  111,  -84, -157,    0,
 -222,    0, -147,    0,   76,   95, -130, -247,    0,   48,
    0,    8,  -35, -233,  -40,    0,    0,    0,   81,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  158, -129,    0,  -84, -237,    0,    0,  104,   95,    0,
    0,   95, -247,    0,  131,    0,    0,    0,    0,   48,
   52,    0,  -11,    0,    0,   52,    0,   37,  110,  138,
  140,    0,    0,    0,    0,    0,    0, -139,   56,   48,
    0,  -80,   51,    0,  -84,    0,  -98,  -37,   95,    0,
    0,    0,    0,   48,   48,   48,   48,    0,    0,    0,
    0,    0,    0,   51,  -30,   57,  128,    0,    0,    0,
    0,  -71,  164,    0,  148,  -27, -247,  -11,  -11,    0,
    0,  179,    0,   67,    0,    0,    0,    0,  -27,    0,
  158,    0,    0,    0,    0,    0,   95,  -38,    0,  -16,
    0,  172, -114,   48, -100,  -14,   51,    0,   -9,   79,
  178,   -3,    0,  214,    0,  202,    0,    0,  186,  -51,
    0,    0,    0,  203,    0,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,   16,    5,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  118,    0,    0,    1,    0,
    0,  -97,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -47,  189,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  129,    0, -197,    0,    0,    0,    0,  -41,    0,
    0,    0,    0,    0,  -13,    0,    0,    0,    0,    0,
  136,    0,    7,    0,    0,  151,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    2,    0,    0,    0,   -8,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   27,   47,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -56,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  219,    0,    0,    0,    0,    0,    0,    0,  220,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
    4,    0,    6,    0,    0,   -6,  -31,  130,   15,  132,
    0,  -60,  -20,    0,    0,    0,   -4,    0,    0,    0,
   50,    0,    0,    0,    0,   14,    0,    0,    0,    0,
   86,  -54,    0,  183,    0,    0,    0,    0,
};
#define YYTABLESIZE 454
short yytable[] = {                                      45,
   47,   31,   34,  131,   80,   87,   43,  185,   13,   80,
  143,   39,    4,   34,   80,   50,   38,   35,   39,   96,
   33,   97,   89,  164,   98,  113,   36,   79,   79,   79,
  116,   79,  104,   79,   90,  117,  105,   86,   88,   70,
   99,    5,  163,   74,  106,   79,   79,   75,   79,   75,
   52,   75,   80,   82,  102,   82,   82,   37,   82,   35,
   40,  140,  141,    2,    3,   75,   75,   73,   75,   73,
   32,   73,  110,  129,   41,  111,  109,  118,  112,  114,
   66,  115,  128,   44,  109,   73,   73,   74,   73,   74,
   45,   74,   80,   82,  114,  126,  115,  145,  114,  114,
  115,  115,  169,  142,  172,   74,   74,  155,   74,  114,
   49,  115,  134,   82,   64,   96,   67,   97,   14,  176,
  144,  114,  132,  115,   15,   71,   16,   82,   82,   82,
   82,   17,   18,   51,   69,   19,  122,  123,   82,  101,
   53,  103,  153,  108,  158,   20,  174,  168,  162,   48,
  119,   55,   52,   54,   56,   58,   60,   63,   57,  170,
  159,  171,  162,   54,   54,    1,    2,    3,    4,   59,
   43,   14,    5,    6,  178,   61,   71,   82,  120,   16,
  121,  127,  183,  130,   17,   18,  146,   89,   19,    2,
    3,    4,  147,   63,   72,    5,    6,   14,   20,  138,
  139,   37,   37,   34,  148,   16,  150,   37,   37,   69,
   17,   18,   39,   12,   19,   91,  184,   30,   35,  154,
    2,    3,  160,   75,   20,   76,   77,   32,   75,  167,
   76,   77,  151,   75,   63,   76,   77,   92,   93,   94,
   95,   42,   79,   78,   79,  161,  162,  173,   78,   79,
   79,   50,  175,   78,   79,   79,   79,  180,  179,   79,
  181,  186,   75,   85,   79,   79,   79,   79,   17,   79,
   75,   75,  107,   76,   77,   75,   75,   18,   19,   75,
  156,  125,   73,  111,   75,   75,   75,   75,    0,   75,
   73,   78,   79,    0,    0,   73,   73,    0,    0,   73,
    0,    0,   74,    0,   73,   73,   73,   73,    0,   73,
   74,   75,    0,   76,   77,   74,   74,    0,    0,   74,
    0,    0,    0,    0,   74,   74,   74,   74,    0,   74,
   14,   78,   79,   92,   93,   94,   95,   14,   16,    0,
    0,    0,    0,   17,   18,   16,    0,   19,   14,    0,
   17,   18,    2,    3,   19,   14,   16,   20,    5,    6,
    0,   17,   18,   16,   20,   19,   14,    0,   17,   18,
    0,    0,   19,   71,   16,   20,    0,    0,    0,   17,
   18,   71,   20,   19,   89,    0,   71,   71,    0,    0,
   71,   72,   89,   20,    0,    0,    0,   89,   89,   72,
   71,   89,    0,    0,   72,   72,   69,    0,   72,    0,
    0,   89,    0,   14,   69,    0,    0,    0,   72,   69,
   69,   16,    0,   69,    0,    0,   17,   18,    0,    0,
   19,    0,    0,   69,    0,    2,    3,  177,    0,    0,
   20,    5,    6,    2,    3,  182,    1,    1,    4,    5,
    6,    0,    1,    1,
};
short yycheck[] = {                                      40,
   59,   44,   59,   41,   45,   41,   40,   59,   59,   45,
   41,   59,  260,    8,   45,   22,   13,   59,   13,   60,
    6,   62,  256,   40,   45,   80,   59,   41,   42,   43,
   42,   45,   64,   47,  268,   47,  274,   42,   43,   36,
   45,  264,   59,   38,  282,   59,   60,   41,   62,   43,
   59,   45,   45,   40,   61,   42,   43,   59,   45,   10,
  275,  116,  117,  258,  259,   59,   60,   41,   62,   43,
  265,   45,   69,  105,   59,   72,  274,   41,   73,   43,
   31,   45,  103,   40,  282,   59,   60,   41,   62,   43,
   40,   45,   45,   80,   43,  100,   45,   41,   43,   43,
   45,   45,  163,  124,  165,   59,   60,   41,   62,   43,
  262,   45,  109,  100,  272,   60,  264,   62,  256,   41,
  125,   43,  108,   45,  262,  256,  264,  114,  115,  116,
  117,  269,  270,   59,   59,  273,  276,  277,  125,   59,
   59,  271,  137,   40,  151,  283,  167,  262,  263,   20,
   41,   59,   23,   24,   25,   26,   27,   28,   59,  164,
  157,  262,  263,  261,  262,  257,  258,  259,  260,   59,
   40,  256,  264,  265,  171,  260,   59,  164,   41,  264,
   41,  262,  179,  282,  269,  270,   59,   59,  273,  258,
  259,  260,  264,   64,   59,  264,  265,  256,  283,  114,
  115,  258,  259,  260,   41,  264,   59,  264,  265,   59,
  269,  270,  260,  264,  273,  256,  268,  260,  260,   41,
  258,  259,  261,  264,  283,  266,  267,  265,  264,   58,
  266,  267,  260,  264,  105,  266,  267,  278,  279,  280,
  281,  275,  256,  284,  285,  262,  263,  262,  284,  285,
  264,  260,  262,  284,  285,  269,  270,   44,  262,  273,
   59,   59,  256,  256,  278,  279,  280,  281,  264,  283,
  264,  264,  272,  266,  267,  269,  270,   59,   59,  273,
  149,   99,  256,  282,  278,  279,  280,  281,   -1,  283,
  264,  284,  285,   -1,   -1,  269,  270,   -1,   -1,  273,
   -1,   -1,  256,   -1,  278,  279,  280,  281,   -1,  283,
  264,  264,   -1,  266,  267,  269,  270,   -1,   -1,  273,
   -1,   -1,   -1,   -1,  278,  279,  280,  281,   -1,  283,
  256,  284,  285,  278,  279,  280,  281,  256,  264,   -1,
   -1,   -1,   -1,  269,  270,  264,   -1,  273,  256,   -1,
  269,  270,  258,  259,  273,  256,  264,  283,  264,  265,
   -1,  269,  270,  264,  283,  273,  256,   -1,  269,  270,
   -1,   -1,  273,  256,  264,  283,   -1,   -1,   -1,  269,
  270,  264,  283,  273,  256,   -1,  269,  270,   -1,   -1,
  273,  256,  264,  283,   -1,   -1,   -1,  269,  270,  264,
  283,  273,   -1,   -1,  269,  270,  256,   -1,  273,   -1,
   -1,  283,   -1,  256,  264,   -1,   -1,   -1,  283,  269,
  270,  264,   -1,  273,   -1,   -1,  269,  270,   -1,   -1,
  273,   -1,   -1,  283,   -1,  258,  259,  260,   -1,   -1,
  283,  264,  265,  258,  259,  260,  258,  259,  260,  264,
  265,   -1,  264,  265,
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
"$$2 :",
"program : PROGRAM ID ';' $$1 declaracion $$2 cuerpo_programa",
"$$3 :",
"program : PROGRAM ID ';' $$3 cuerpo_programa",
"program : PROGRAM ';' declaracion cuerpo_programa",
"program : PROGRAM ';' cuerpo_programa",
"program : declaracion cuerpo_programa",
"program : cuerpo_programa",
"program : PROGRAM ID ';' error",
"cuerpo_programa : BEGIN sentencia_ejec END ';'",
"cuerpo_programa : BEGIN END ';'",
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
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno END declaracion",
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno post_condicion END declaracion",
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno END BEGIN",
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno post_condicion END BEGIN",
"$$4 :",
"$$5 :",
"$$6 :",
"post_condicion : POST ':' condicion ',' CADENA ';' $$4 $$5 $$6",
"post_condicion : POST ':' condicion ',' ';'",
"retorno : '(' expresion ')' ';'",
"declaracion : FUNC tipo_id nombre_func params_func definicion_func ';'",
"declaracion : tipo_id lista_variables ';'",
"declaracion : tipo_id lista_variables ';' declaracion",
"$$7 :",
"declaracion : FUNC tipo_id nombre_func params_func definicion_func ';' $$7 declaracion",
"declaracion : lista_variables ';'",
"declaracion : lista_variables ';' declaracion",
"lista_variables : ID",
"lista_variables : ID ',' lista_variables",
"lista_variables : ID BEGIN",
"nombre_func : ID",
"params_func : '(' param ')'",
"params_func : '(' ')'",
"param : tipo_id ID",
"$$8 :",
"definicion_func : declaracion $$8 cuerpo_func",
"$$9 :",
"definicion_func : $$9 cuerpo_func",
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
"invocacion : ID '(' expresion ')'",
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
"condicion : '(' comparador expresion ')'",
"condicion : '(' expresion comparador ')'",
"condicion : '(' condicion operador_logico condicion ')'",
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
#line 189 "../gramatica.y"

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
#line 435 "y.tab.c"
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
#line 17 "../gramatica.y"
{Ambito.agregarAmbito("main");}
break;
case 2:
#line 17 "../gramatica.y"
{Polaca.insert("-----------FinDeclaraciones-----------");}
break;
case 4:
#line 18 "../gramatica.y"
{Ambito.agregarAmbito("main");}
break;
case 6:
#line 19 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
break;
case 7:
#line 20 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
break;
case 8:
#line 21 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got declaracion instead");}
break;
case 9:
#line 22 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got cuerpo_programa instead");}
break;
case 10:
#line 23 "../gramatica.y"
{}
break;
case 11:
#line 26 "../gramatica.y"
{Polaca.insert("END_PROGRAM");}
break;
case 12:
#line 27 "../gramatica.y"
{Polaca.insert("END_PROGRAM");}
break;
case 18:
#line 39 "../gramatica.y"
{Polaca.insert("RETURN");}
break;
case 19:
#line 40 "../gramatica.y"
{Polaca.insert("RETURN");}
break;
case 20:
#line 41 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 21:
#line 42 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 22:
#line 43 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 23:
#line 44 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 24:
#line 45 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 25:
#line 46 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 26:
#line 47 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 27:
#line 48 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 28:
#line 51 "../gramatica.y"
{Polaca.insert_sentencia_control_cond();}
break;
case 29:
#line 51 "../gramatica.y"
{}
break;
case 30:
#line 51 "../gramatica.y"
{Polaca.insert_sentencia_control_then();}
break;
case 31:
#line 51 "../gramatica.y"
{TablaSimbolos.punteroTS(yyvsp[-4].sval).setTipo("cadena_caracteres"); TablaSimbolos.punteroTS(yyvsp[-4].sval).setUso("msj_postcondicion"); Polaca.insert("PRINT"); Polaca.insert(TablaSimbolos.punteroTS(yyvsp[-4].sval)); Polaca.insert("Quit"); Polaca.insert_sentencia_control_else();}
break;
case 32:
#line 52 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " CADENA expected but got ; instead");}
break;
case 33:
#line 55 "../gramatica.y"
{Polaca.insert("FillReturnReg");}
break;
case 34:
#line 59 "../gramatica.y"
{ Utils.setTipoIDFuncionCacheado(Integer.toString(yyvsp[-4].ival));}
break;
case 35:
#line 60 "../gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(yyvsp[-2].ival)); Utils.clearListaDeVariables();}
break;
case 36:
#line 61 "../gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(yyvsp[-3].ival)); Utils.clearListaDeVariables();}
break;
case 37:
#line 62 "../gramatica.y"
{ Utils.setTipoIDFuncionCacheado(Integer.toString(yyvsp[-4].ival));}
break;
case 39:
#line 63 "../gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 40:
#line 64 "../gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 41:
#line 67 "../gramatica.y"
{TablaSimbolos.cambiarNombre(yyvsp[0].sval, yyvsp[0].sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(yyvsp[0].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(yyvsp[0].sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 42:
#line 68 "../gramatica.y"
{ TablaSimbolos.cambiarNombre(yyvsp[-2].sval, yyvsp[-2].sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(yyvsp[-2].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(yyvsp[-2].sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 43:
#line 69 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 44:
#line 72 "../gramatica.y"
{TablaSimbolos.cambiarNombre(yyvsp[0].sval, yyvsp[0].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(yyvsp[0].sval + Ambito.retornarNaming()).setUso("nombre_funcion"); Utils.cachearIDFuncion(yyvsp[0].sval + Ambito.retornarNaming()); Ambito.agregarAmbito(yyvsp[0].sval); }
break;
case 47:
#line 79 "../gramatica.y"
{TablaSimbolos.punteroTS(yyvsp[0].sval).setTipo(Integer.toString(yyvsp[-1].ival)); TablaSimbolos.punteroTS(yyvsp[0].sval).setUso("parametro"); TablaSimbolos.cambiarNombre(yyvsp[0].sval, yyvsp[0].sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setParametro(TablaSimbolos.punteroTS(yyvsp[0].sval + Ambito.retornarNaming()));}
break;
case 48:
#line 82 "../gramatica.y"
{TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setComienzoCodigoEjecutable(Polaca.posicionActual() + 1); Polaca.insert("FuncStartLabel"); Polaca.insert("L"+ (Polaca.posicionActual() + 1));}
break;
case 49:
#line 82 "../gramatica.y"
{Ambito.borrarAmbito();}
break;
case 50:
#line 83 "../gramatica.y"
{TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setComienzoCodigoEjecutable(Polaca.posicionActual()+1); Polaca.insert("FuncStartLabel"); Polaca.insert("L"+ (Polaca.posicionActual() + 1));}
break;
case 51:
#line 83 "../gramatica.y"
{Ambito.borrarAmbito();}
break;
case 52:
#line 84 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Cuerpo del procedimiento vacio.");}
break;
case 55:
#line 91 "../gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Invocacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 56:
#line 92 "../gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Asignacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 57:
#line 93 "../gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Iteracion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 58:
#line 94 "../gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Seleccion (IF) en la linea " + AnalizadorLexico.nroLinea);}
break;
case 59:
#line 95 "../gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Impresion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 61:
#line 97 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 62:
#line 98 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 63:
#line 99 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 64:
#line 100 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 65:
#line 101 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 66:
#line 102 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 67:
#line 105 "../gramatica.y"
{if ((Ambito.bindAmbito(yyvsp[-2].sval) != null) && (TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)).getParametro()) == null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval))); Polaca.insert("CALL"); TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)).setEsNombre(false);} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una funcion con esa signatura en el ambito actual");}
break;
case 68:
#line 106 "../gramatica.y"
{if ((Ambito.bindAmbito(yyvsp[-3].sval) != null) && (TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-3].sval)).getParametro() != null) && (Ambito.bindAmbito(yyvsp[-1].sval) != null)) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-3].sval)).getParametro()); Polaca.insert(new Integer(Parser.ASIG)); Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-3].sval))); Polaca.insert("CALL"); TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-3].sval)).setEsNombre(false);} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una funcion con esa signatura en el ambito actual");}
break;
case 69:
#line 109 "../gramatica.y"
{if (Ambito.bindAmbito(yyvsp[-2].sval) != null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)));} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una variable con ese nombre en el ambito actual"); Polaca.insert(new Integer(ASIG)); if (yyvsp[0].ival == Parser.ID && TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[0].sval)).getUso().equals("nombre_funcion") && TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[0].sval)).esNombre()){RegistroTS funcionAAsignar = TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[0].sval)); Polaca.removerUltimo(); Polaca.removerUltimo(); Polaca.removerUltimo(); TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)).setTipo(funcionAAsignar.getTipo()); TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)).setUso(funcionAAsignar.getUso()); TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)).setParametro(funcionAAsignar.getParametro()); TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[-2].sval)).setComienzoCodigoEjecutable(funcionAAsignar.getComienzoCodigoEjecutable());} ;}
break;
case 70:
#line 110 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
break;
case 71:
#line 111 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
break;
case 72:
#line 112 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
break;
case 73:
#line 115 "../gramatica.y"
{Polaca.insert(new Integer('+'));}
break;
case 74:
#line 116 "../gramatica.y"
{Polaca.insert(new Integer('-'));}
break;
case 76:
#line 120 "../gramatica.y"
{Polaca.insert(new Integer('*'));}
break;
case 77:
#line 121 "../gramatica.y"
{Polaca.insert(new Integer('/'));}
break;
case 79:
#line 125 "../gramatica.y"
{if (Ambito.bindAmbito(yyvsp[0].sval) != null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[0].sval))); if(((RegistroTS)Polaca.conseguirUltimo()).getUso().equals("nombre_funcion")){TablaSimbolos.punteroTS(Ambito.bindAmbito(yyvsp[0].sval)).setEsNombre(true);}} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una variable con ese nombre en el ambito actual");}
break;
case 80:
#line 126 "../gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(yyvsp[0].sval)); TablaSimbolos.punteroTS(yyvsp[0].sval).setTipo(Integer.toString(Parser.CTE_UINT)); TablaSimbolos.punteroTS(yyvsp[0].sval).setUso("cte");}
break;
case 81:
#line 127 "../gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(yyvsp[0].sval)); TablaSimbolos.punteroTS(yyvsp[0].sval).setTipo(Integer.toString(Parser.CTE_DOUBLE)); TablaSimbolos.punteroTS(yyvsp[0].sval).setUso("cte");}
break;
case 82:
#line 128 "../gramatica.y"
{  /*Sacamos lo ultimo que agregamos a la polaca, porque ya no es valido.
								                Determinamos que signo va a tener la cte.
								                Si es negativa, agregamos "-sval" a la TS.
								                Agregamos el string correcto (devuelto por utils.sig....) a la polaca.*/
                                                Polaca.insert(TablaSimbolos.punteroTS(Utils.signoNegativo(yyvsp[0].sval)));
                                                }
break;
case 84:
#line 135 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
break;
case 85:
#line 136 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
break;
case 86:
#line 139 "../gramatica.y"
{TablaSimbolos.punteroTS(yyvsp[-1].sval).setTipo("cadena_caracteres"); Polaca.insert("PRINT"); Polaca.insert(TablaSimbolos.punteroTS(yyvsp[-1].sval)); }
break;
case 87:
#line 140 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " invalid argument for PRINT");}
break;
case 88:
#line 143 "../gramatica.y"
{Polaca.insert_iteracion_end();}
break;
case 89:
#line 144 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " UNTIL expected");}
break;
case 90:
#line 150 "../gramatica.y"
{Polaca.insert_iteracion_start();}
break;
case 91:
#line 153 "../gramatica.y"
{Polaca.insert(new Integer(yyvsp[-2].ival));}
break;
case 92:
#line 154 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
break;
case 93:
#line 155 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
break;
case 94:
#line 156 "../gramatica.y"
{Polaca.insert(new Integer(yyvsp[-2].ival));}
break;
case 95:
#line 157 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}
break;
case 104:
#line 173 "../gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 106:
#line 177 "../gramatica.y"
{Polaca.insert_sentencia_control_cond();}
break;
case 107:
#line 178 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en el encabezado de la condicion, falta la condicion del IF");}
break;
case 108:
#line 181 "../gramatica.y"
{Polaca.insert_sentencia_control_then();}
break;
case 109:
#line 182 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia THEN, falta el bloque de sentencias");}
break;
case 110:
#line 185 "../gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 111:
#line 186 "../gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia ELSE, falta el bloque de sentencias");}
break;
#line 924 "y.tab.c"
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
