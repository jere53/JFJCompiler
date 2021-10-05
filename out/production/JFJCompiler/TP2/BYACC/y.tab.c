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
#line 12 "y.tab.c"
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
    4,    4,    4,   16,   16,   17,   17,   17,   17,   10,
   10,   10,   21,   21,   21,   22,   22,   22,   22,   22,
   20,   20,   18,    9,    9,    9,    9,    9,    9,   23,
   23,   23,   23,   23,   23,   24,   24,   19,   19,   19,
   19,
};
short yylen[] = {                                         2,
    2,    1,    4,    1,    1,    1,    1,    5,    6,    6,
    4,    5,    3,    4,    6,    1,    3,    2,    1,    3,
    2,    2,    2,    1,    0,    2,    1,    2,    2,    2,
    2,    2,    2,    3,    4,    3,    3,    1,    3,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    2,    1,
    4,    4,    4,    5,    4,    4,    4,    5,    3,    1,
    1,    1,    1,    1,    1,    1,    1,    5,    7,    6,
    4,
};
short yydefred[] = {                                      0,
    0,    5,    6,    0,    0,    7,    0,    0,    0,    0,
    0,    0,    2,    4,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   33,
    1,    0,    0,    0,    0,   28,   29,   30,   31,   32,
    0,   47,   48,    0,    0,   50,    0,   45,    0,   26,
   37,    0,    0,   34,    0,    0,    0,    0,   60,   61,
   64,   65,   62,   63,    0,    0,    0,    0,   18,    0,
    0,    0,   49,    0,    0,    0,    0,    3,   35,   52,
   51,   53,   59,   66,   67,    0,    0,    0,    0,   71,
    0,   17,   21,    0,    0,    0,    0,   24,    0,   14,
    0,    0,   43,   44,   57,    0,    0,   56,    0,    0,
   68,   22,   20,    0,   23,    0,   54,   58,   70,    0,
    0,   15,   69,    0,    0,    0,    8,    0,    0,    0,
    0,    9,   11,    0,    0,    0,   10,
};
short yydgoto[] = {                                      11,
   12,   13,   22,   14,   15,   98,  125,  129,   29,   45,
   34,   71,   99,   35,   95,   46,   17,   18,   19,   20,
   47,   48,   66,   87,
};
short yysindex[] = {                                   -160,
 -229,    0,    0, -135,  -33,    0,   27, -113,   54,   36,
    0, -113,    0,    0, -238,   42,   46,   47,   48,   51,
   25, -147, -135,   33,  -32, -212, -152,   15, -148,    0,
    0,   83, -131,   95,   77,    0,    0,    0,    0,    0,
  101,    0,    0,   25,   13,    0,   24,    0,   89,    0,
    0,   13,  108,    0,  111,  116,   54,  120,    0,    0,
    0,    0,    0,    0,   -3,   25, -143, -101,    0,  -36,
  -72, -195,    0,   25,   25,   25,   25,    0,    0,    0,
    0,    0,    0,    0,    0,   20,   25,   45, -113,    0,
 -227,    0,    0,  -98,  125, -135,  -89,    0,  113,    0,
   24,   24,    0,    0,    0,   74,   99,    0, -108, -113,
    0,    0,    0,  -84,    0, -195,    0,    0,    0, -103,
  139,    0,    0,   25, -182,  148,    0,  124,  -78,  129,
   54,    0,    0,  146,  -71,  136,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,   47,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -178,    0,    0,    0,    0,    0,    0,    0,
    0,  138,  158,    0,    0,    0,    0,    0,    0,    0,
  -41,    0,    0,    0,   48,    0,  -31,    0,    0,    0,
    0,   42,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  140, -105,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -21,  -11,    0,    0,    0,   -9,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -88,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  -35,   35,   -7,    4,  130,  104,    0,    0,  -40,  -13,
    0,    0,    0,  134,    0,   64,    0,    0,    0,    0,
   18,    8,  141,    0,
};
#define YYTABLESIZE 299
short yytable[] = {                                      46,
   46,   46,   46,   46,   93,   46,   25,   23,   54,   42,
   52,   42,   42,   42,   65,   50,   82,   46,   46,   40,
   46,   40,   40,   40,   32,   33,   23,   42,   42,   41,
   42,   41,   41,   41,   55,   97,  100,   40,   40,   74,
   40,   75,   27,   55,   21,  110,   31,   41,   41,   55,
   41,   73,   88,  111,   56,   74,   63,   75,   64,   44,
  105,    2,    3,   16,   44,   76,   26,   16,    6,   44,
   77,   16,  106,  107,   63,   16,   64,   44,  127,  128,
  122,   27,   27,  103,  104,  108,   16,   74,  114,   75,
  134,  101,  102,   28,   30,    1,    2,    3,    4,   23,
   36,   91,    5,    6,   37,   38,   39,    7,    8,   40,
  126,    9,    1,   49,  117,    4,   74,   57,   75,    5,
    1,   10,   67,  109,    7,    8,   68,    5,    9,   89,
   16,   69,    7,    8,   70,   72,    9,   90,   10,  118,
   25,   74,    1,   75,  120,    4,   10,   78,   79,    5,
   13,   80,   16,   13,    7,    8,   81,   13,    9,   16,
   83,   32,   13,   13,  112,  113,   13,   12,   10,   96,
   12,  116,  119,   16,   12,  121,   13,  123,  124,   12,
   12,  131,  132,   12,    2,    3,   96,  133,  130,  135,
   74,    6,   75,   12,  137,  136,   16,   19,   25,   94,
  115,   92,    0,    0,    0,   86,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    2,    3,    0,    0,    0,    0,    0,    6,    0,   46,
   53,    0,    0,   46,   46,   46,   46,   46,   46,   42,
   24,    0,    0,   42,   42,   42,   42,   42,   42,   40,
    0,    0,    0,   40,   40,   40,   40,   40,   40,   41,
    0,   55,    0,   41,   41,   41,   41,   41,   41,    0,
   58,   84,   85,   59,   60,   61,   62,   41,    0,   42,
   43,    0,   41,    0,   42,   43,    0,   41,   51,   42,
   43,   59,   60,   61,   62,   41,    0,   42,   43,
};
short yycheck[] = {                                      41,
   42,   43,   44,   45,   41,   47,   40,    4,   41,   41,
   24,   43,   44,   45,   28,   23,   57,   59,   60,   41,
   62,   43,   44,   45,  263,  264,   23,   59,   60,   41,
   62,   43,   44,   45,   44,   71,   72,   59,   60,   43,
   62,   45,    8,  256,  274,  273,   12,   59,   60,   59,
   62,   44,   66,  281,  267,   43,   60,   45,   62,   45,
   41,  257,  258,    0,   45,   42,   40,    4,  264,   45,
   47,    8,   86,   87,   60,   12,   62,   45,  261,  262,
  116,  260,  261,   76,   77,   41,   23,   43,   96,   45,
  131,   74,   75,   40,   59,  256,  257,  258,  259,   96,
   59,   67,  263,  264,   59,   59,   59,  268,  269,   59,
  124,  272,  256,  261,   41,  259,   43,  270,   45,  263,
  256,  282,  271,   89,  268,  269,   44,  263,  272,  273,
   67,  263,  268,  269,   40,   59,  272,  281,  282,   41,
   40,   43,  256,   45,  110,  259,  282,   59,   41,  263,
  256,   41,   89,  259,  268,  269,   41,  263,  272,   96,
   41,  263,  268,  269,  263,   41,  272,  256,  282,  259,
  259,   59,  281,  110,  263,  260,  282,  281,   40,  268,
  269,   58,  261,  272,  257,  258,  259,   59,   41,   44,
   43,  264,   45,  282,   59,  267,   59,   40,   59,   70,
   97,   68,   -1,   -1,   -1,   65,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  257,  258,   -1,   -1,   -1,   -1,   -1,  264,   -1,  271,
  263,   -1,   -1,  275,  276,  277,  278,  279,  280,  271,
  274,   -1,   -1,  275,  276,  277,  278,  279,  280,  271,
   -1,   -1,   -1,  275,  276,  277,  278,  279,  280,  271,
   -1,  271,   -1,  275,  276,  277,  278,  279,  280,   -1,
  256,  275,  276,  277,  278,  279,  280,  263,   -1,  265,
  266,   -1,  263,   -1,  265,  266,   -1,  263,  256,  265,
  266,  277,  278,  279,  280,  263,   -1,  265,  266,
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
"impresion : PRINT '(' CADENA ')'",
"impresion : PRINT '(' error ')'",
"iteracion : REPEAT bloque_sentencias UNTIL condicion",
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
"seleccion : IF condicion THEN ENDIF",
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
#line 138 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"

private int yylex() {

  Dupla<Integer, RegistroTS> token = null;
  do {
    try {
      token = AnalizadorLexico.Instance().producirToken();

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
	System.out.println(mensajeError);
}
#line 334 "y.tab.c"
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
case 5:
#line 25 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 6:
#line 26 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 12:
#line 40 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 16:
#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 17:
#line 47 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 18:
#line 50 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 19:
#line 51 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta el identificador del procedimiento.");}
break;
case 25:
#line 63 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Cuerpo del procedimiento vacio.");}
break;
case 34:
#line 78 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 35:
#line 79 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 36:
#line 82 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 37:
#line 83 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("El lado derecho de la asignacio no es valido.");}
break;
case 38:
#line 84 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Un identificador en solitario no es una sentencia valida.");}
break;
case 39:
#line 85 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("El lado izquierdo de la asignacion no es valido");}
break;
case 40:
#line 88 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 41:
#line 89 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 43:
#line 93 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 44:
#line 94 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 46:
#line 98 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 47:
#line 99 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 48:
#line 100 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 49:
#line 101 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 50:
#line 102 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 54:
#line 112 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 55:
#line 113 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta parentesis de cierre de la condicion.");}
break;
case 56:
#line 114 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta expresion en el lado izquierdo de la condicion.");}
break;
case 57:
#line 115 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta expresion en el lado derecho de la condicion.");}
break;
case 59:
#line 117 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Error en la condicion.");}
break;
case 70:
#line 134 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.");}
break;
case 71:
#line 135 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.");}
break;
#line 594 "y.tab.c"
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
