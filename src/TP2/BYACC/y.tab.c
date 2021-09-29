#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "..\gramatica.y"

#line 8 "y.tab.c"
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
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    2,    2,    5,    5,    5,    6,    6,    8,
    7,    1,    1,   14,   14,   11,   11,   12,   12,   15,
   13,   13,   13,    3,    3,    4,    4,    4,    4,    4,
    4,   16,   16,   17,   17,   17,   17,   10,   10,   10,
   21,   21,   21,   22,   22,   22,   22,   22,   20,   20,
   18,    9,    9,    9,    9,    9,    9,   23,   23,   23,
   23,   23,   23,   24,   24,   19,   19,   25,   19,   26,
   19,
};
short yylen[] = {                                         2,
    3,    1,    3,    1,    1,    1,    1,    5,    6,    6,
    4,    4,    2,    2,    3,    2,    1,    3,    2,    2,
    3,    1,    0,    3,    2,    1,    1,    1,    1,    1,
    1,    3,    4,    3,    3,    1,    3,    3,    3,    1,
    3,    3,    1,    1,    1,    1,    2,    1,    6,    4,
    4,    5,    4,    4,    4,    5,    3,    1,    1,    1,
    1,    1,    1,    1,    1,    6,    8,    0,    8,    0,
    6,
};
short yydefred[] = {                                      0,
    0,    5,    6,    0,    0,    7,    0,    0,    0,   31,
    0,    0,    2,    4,    0,   26,   27,   28,   29,   30,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   13,    0,   45,   46,    0,    0,   48,
    0,   43,    3,    0,   35,    0,   32,    0,    0,    0,
    0,    0,    0,   58,   59,   62,   63,   60,   61,    0,
    0,    0,    1,    0,   14,   16,    0,    0,   47,    0,
    0,    0,    0,   24,   20,   33,   50,    0,   51,   57,
   64,   65,    0,    0,    0,    0,   70,    0,   15,   19,
    0,    0,    0,   22,   12,    0,    0,   41,   42,    0,
   55,    0,    0,   54,    0,    0,    0,    0,   18,    0,
    0,   49,   52,   56,   68,   71,    0,   66,    0,   21,
    0,    0,    0,    0,   69,   67,    0,    8,    0,    0,
    0,    0,    9,   11,    0,    0,    0,   10,
};
short yydgoto[] = {                                      11,
   12,   13,   22,   14,   15,   94,  124,  130,   29,   39,
   33,   68,   95,   34,   49,   40,   17,   18,   19,   20,
   41,   42,   61,   84,  121,  106,
};
short yysindex[] = {                                   -125,
 -271,    0,    0,  -72,  -32,    0,  -25,  -83,   -5,    0,
    0,    6,    0,    0, -223,    0,    0,    0,    0,    0,
  -12, -202,  -21,   -6,  -36,  -33, -196,  -39, -192,  -83,
  -35, -171,   61,    0,   63,    0,    0,  -12,  -27,    0,
  -11,    0,    0,  -72,    0,  -27,    0, -157,   78,   80,
 -144,   -5,   87,    0,    0,    0,    0,    0,    0,  -43,
  -12, -114,    0, -134,    0,    0,   -9, -230,    0,  -12,
  -12,  -12,  -12,    0,    0,    0,    0,   98,    0,    0,
    0,    0,  -19,  -12,   57,  -83,    0, -261,    0,    0,
   95,  -72,   96,    0,    0,  -11,  -11,    0,    0,  100,
    0,   66,   72,    0, -135,   91,  -83,   92,    0, -108,
 -106,    0,    0,    0,    0,    0, -121,    0,  116,    0,
  103,  104,  -12, -185,    0,    0,   77,    0,  106,  -96,
  110,   -5,    0,    0,  126,  -93,  112,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,   51,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  135,    0,    0,    1,    0,    0,    0,   53,    0,
   13,    0,    0, -172,    0,   55,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  133,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   25,   37,    0,    0,    0,
    0,   49,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  111,   75,  -30,    3,  -15,   70,    0,    0,  -41,   43,
    0,    0,    0,  119,  120,   86,    0,    0,    0,    0,
   54,   -8,  128,    0,    0,    0,
};
#define YYTABLESIZE 336
short yytable[] = {                                      70,
   44,   71,   21,   51,   47,   38,   23,   25,   64,   48,
   79,  107,   40,   74,   26,   70,   58,   71,   59,  108,
   58,  101,   59,   65,   38,   38,    2,    3,   92,   69,
   72,   90,   38,    6,   28,   73,   39,   44,   38,   31,
   32,   44,   44,   44,   44,   44,   23,   44,   53,   30,
   36,   48,   37,   40,   34,   40,   40,   40,   43,   44,
   44,  110,   44,   98,   99,   38,   46,   38,   38,   38,
   60,   40,   40,   52,   40,  128,  129,   39,   62,   39,
   39,   39,   27,   38,   38,   16,   38,   25,   25,   16,
  135,   66,   53,   16,   23,   39,   39,  104,   39,   70,
   67,   71,   25,   85,   63,   75,  113,   53,   70,   36,
   71,   37,  114,   34,   70,   16,   71,  131,   76,   70,
   77,   71,   78,   96,   97,  102,  103,   80,   31,   16,
    1,    2,    3,    4,  100,  109,   88,    5,    6,  111,
  112,    1,    7,    8,    4,  115,    9,   16,    5,  116,
  118,  119,   92,    7,    8,  123,   10,    9,   86,  122,
  105,  125,  126,  132,  133,  127,   87,   10,  134,  136,
  138,   16,    1,  137,   17,    4,   23,   16,   93,    5,
  120,  117,   89,    1,    7,    8,   91,   83,    9,    0,
    5,    0,   16,    0,    0,    7,    8,    0,   10,    9,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   10,
    0,    0,    0,    0,    0,    0,   53,    0,    0,    0,
    2,    3,   50,   35,    0,   36,   37,    6,    0,    0,
    0,   81,   82,   54,   55,   56,   57,   54,   55,   56,
   57,   24,    0,   35,    0,   36,   37,    2,    3,   45,
   35,    0,   36,   37,    6,    0,   35,    0,   36,   37,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   44,   44,    0,   44,    0,   44,   44,   44,   44,   44,
   44,   44,   40,   40,    0,   40,    0,   40,   40,   40,
   40,   40,   40,   40,   38,   38,    0,   38,    0,   38,
   38,   38,   38,   38,   38,   38,   39,   39,    0,   39,
    0,   39,   39,   39,   39,   39,   39,   39,   53,   53,
   36,   53,   37,   36,   34,   37,    0,   34,    0,   53,
    0,   36,    0,   37,    0,   34,
};
short yycheck[] = {                                      43,
    0,   45,  274,   37,   41,   45,    4,   40,   44,   25,
   52,  273,    0,   44,   40,   43,   60,   45,   62,  281,
   60,   41,   62,   59,    0,   45,  257,  258,  259,   38,
   42,   41,   45,  264,   40,   47,    0,   59,   45,  263,
  264,   41,   42,   43,   44,   45,   44,   47,    0,   44,
    0,   67,    0,   41,    0,   43,   44,   45,  261,   59,
   60,   92,   62,   72,   73,   41,   24,   43,   44,   45,
   28,   59,   60,  270,   62,  261,  262,   41,  271,   43,
   44,   45,    8,   59,   60,    0,   62,  260,  261,    4,
  132,  263,   44,    8,   92,   59,   60,   41,   62,   43,
   40,   45,   40,   61,   30,  263,   41,   59,   43,   59,
   45,   59,   41,   59,   43,   30,   45,   41,   41,   43,
   41,   45,  267,   70,   71,   83,   84,   41,  263,   44,
  256,  257,  258,  259,   37,   41,   62,  263,  264,   44,
   41,  256,  268,  269,  259,  281,  272,   62,  263,   59,
   59,  260,  259,  268,  269,   40,  282,  272,  273,  281,
   86,   59,   59,   58,  261,  123,  281,  282,   59,   44,
   59,   86,  256,  267,   40,  259,   44,   92,   68,  263,
  111,  107,   64,  256,  268,  269,   67,   60,  272,   -1,
  263,   -1,  107,   -1,   -1,  268,  269,   -1,  282,  272,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  282,
   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,
  257,  258,  256,  263,   -1,  265,  266,  264,   -1,   -1,
   -1,  275,  276,  277,  278,  279,  280,  277,  278,  279,
  280,  274,   -1,  263,   -1,  265,  266,  257,  258,  256,
  263,   -1,  265,  266,  264,   -1,  263,   -1,  265,  266,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  270,  271,   -1,  273,   -1,  275,  276,  277,  278,  279,
  280,  281,  270,  271,   -1,  273,   -1,  275,  276,  277,
  278,  279,  280,  281,  270,  271,   -1,  273,   -1,  275,
  276,  277,  278,  279,  280,  281,  270,  271,   -1,  273,
   -1,  275,  276,  277,  278,  279,  280,  281,  270,  271,
  270,  273,  270,  273,  270,  273,   -1,  273,   -1,  281,
   -1,  281,   -1,  281,   -1,  281,
};
#define YYFINAL 11
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 282
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,"'%'",0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,
"':'","';'","'<'",0,"'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,"UINT","DOUBLE","BEGIN","RETURN","END","POST","ID","FUNC",
"CTE_UINT","CTE_DOUBLE","CADENA","PRINT","REPEAT","UNTIL","THEN","IF","ELSE",
"ASIG","AND","OR","COMP_MAYOR_IGUAL","COMP_MENOR_IGUAL","COMP_IGUAL",
"COMP_DISTINTO","ENDIF","BREAK",
};
char *yyrule[] = {
"$accept : program",
"program : declaracion ',' bloque_sentencias",
"program : bloque_sentencias",
"bloque_sentencias : BEGIN sentencia_ejec END",
"bloque_sentencias : miembro_sentencia_ejec",
"tipo_id : UINT",
"tipo_id : DOUBLE",
"tipo_id : FUNC",
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno END",
"cuerpo_func : BEGIN sentencia_ejec RETURN retorno post_condicion END",
"post_condicion : POST ':' condicion ',' CADENA ';'",
"retorno : '(' expresion ')' ';'",
"declaracion : tipo_id nombre_func params_func definicion_func",
"declaracion : tipo_id lista_variables",
"lista_variables : ID ';'",
"lista_variables : ID ',' lista_variables",
"nombre_func : FUNC ID",
"nombre_func : FUNC",
"params_func : '(' param ')'",
"params_func : '(' ')'",
"param : tipo_id ID",
"definicion_func : declaracion ',' cuerpo_func",
"definicion_func : cuerpo_func",
"definicion_func :",
"sentencia_ejec : miembro_sentencia_ejec ';' sentencia_ejec",
"sentencia_ejec : miembro_sentencia_ejec ';'",
"miembro_sentencia_ejec : invocacion",
"miembro_sentencia_ejec : asignacion",
"miembro_sentencia_ejec : iteracion",
"miembro_sentencia_ejec : seleccion",
"miembro_sentencia_ejec : impresion",
"miembro_sentencia_ejec : BREAK",
"invocacion : ID '(' ')'",
"invocacion : ID '(' param ')'",
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
"impresion : PRINT '(' '%' CADENA '%' ')'",
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
"seleccion : IF condicion THEN bloque_sentencias ENDIF ';'",
"seleccion : IF condicion THEN bloque_sentencias ELSE bloque_sentencias ENDIF ';'",
"$$1 :",
"seleccion : IF condicion THEN ELSE bloque_sentencias ENDIF $$1 ';'",
"$$2 :",
"seleccion : IF condicion THEN ENDIF $$2 ';'",
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
#line 21 "..\gramatica.y"
{}
break;
case 6:
#line 22 "..\gramatica.y"
{}
break;
case 12:
#line 36 "..\gramatica.y"
{}
break;
case 14:
#line 40 "..\gramatica.y"
{}
break;
case 15:
#line 41 "..\gramatica.y"
{}
break;
case 16:
#line 44 "..\gramatica.y"
{}
break;
case 17:
#line 45 "..\gramatica.y"
{yyerror("Falta el identificador del procedimiento.");}
break;
case 23:
#line 57 "..\gramatica.y"
{yyerror("Cuerpo del procedimiento vacio.");}
break;
case 32:
#line 72 "..\gramatica.y"
{}
break;
case 33:
#line 73 "..\gramatica.y"
{}
break;
case 34:
#line 76 "..\gramatica.y"
{}
break;
case 35:
#line 77 "..\gramatica.y"
{yyerror("El lado derecho de la asignacio no es valido.");}
break;
case 36:
#line 78 "..\gramatica.y"
{yyerror("Un identificador en solitario no es una sentencia valida.");}
break;
case 37:
#line 79 "..\gramatica.y"
{yyerror("El lado izquierdo de la asignacion no es valido");}
break;
case 38:
#line 82 "..\gramatica.y"
{}
break;
case 39:
#line 83 "..\gramatica.y"
{}
break;
case 41:
#line 87 "..\gramatica.y"
{}
break;
case 42:
#line 88 "..\gramatica.y"
{}
break;
case 44:
#line 92 "..\gramatica.y"
{}
break;
case 45:
#line 93 "..\gramatica.y"
{}
break;
case 46:
#line 94 "..\gramatica.y"
{}
break;
case 47:
#line 95 "..\gramatica.y"
{}
break;
case 48:
#line 96 "..\gramatica.y"
{}
break;
case 52:
#line 106 "..\gramatica.y"
{}
break;
case 53:
#line 107 "..\gramatica.y"
{yyerror("Falta parentesis de cierre de la condicion.");}
break;
case 54:
#line 108 "..\gramatica.y"
{yyerror("Falta expresion en el lado izquierdo de la condicion.");}
break;
case 55:
#line 109 "..\gramatica.y"
{yyerror("Falta expresion en el lado derecho de la condicion.");}
break;
case 57:
#line 111 "..\gramatica.y"
{yyerror("Error en la condicion.");}
break;
case 68:
#line 128 "..\gramatica.y"
{yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.")}
break;
case 70:
#line 129 "..\gramatica.y"
{yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.")}
break;
#line 568 "y.tab.c"
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
