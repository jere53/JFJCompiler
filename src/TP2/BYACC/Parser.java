
package TP2.BYACC;

//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "..\gramatica.y"

//#line 19 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short UINT=257;
public final static short DOUBLE=258;
public final static short BEGIN=259;
public final static short RETURN=260;
public final static short END=261;
public final static short POST=262;
public final static short ID=263;
public final static short FUNC=264;
public final static short CTE_UINT=265;
public final static short CTE_DOUBLE=266;
public final static short CADENA=267;
public final static short PRINT=268;
public final static short REPEAT=269;
public final static short UNTIL=270;
public final static short THEN=271;
public final static short IF=272;
public final static short ELSE=273;
public final static short ASIG=274;
public final static short AND=275;
public final static short OR=276;
public final static short COMP_MAYOR_IGUAL=277;
public final static short COMP_MENOR_IGUAL=278;
public final static short COMP_IGUAL=279;
public final static short COMP_DISTINTO=280;
public final static short ENDIF=281;
public final static short BREAK=282;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    2,    2,    5,    5,    5,    6,    6,    8,
    7,    1,    1,   14,   14,   11,   11,   12,   12,   12,
   12,   15,   15,   16,   16,   13,   13,   13,    3,    3,
    4,    4,    4,    4,    4,    4,   17,   17,   18,   18,
   18,   18,   10,   10,   10,   22,   22,   22,   23,   23,
   23,   23,   23,   21,   21,   19,    9,    9,    9,    9,
    9,    9,   24,   24,   24,   24,   24,   24,   25,   25,
   20,   20,   26,   20,   27,   20,
};
final static short yylen[] = {                            2,
    3,    1,    3,    1,    1,    1,    1,    5,    6,    5,
    4,    4,    2,    1,    3,    2,    1,    3,    2,    2,
    1,    2,    1,    0,    1,    3,    1,    0,    3,    2,
    1,    1,    1,    1,    1,    1,    3,    4,    3,    3,
    1,    3,    3,    3,    1,    3,    3,    1,    1,    1,
    1,    2,    1,    6,    4,    4,    5,    4,    4,    4,
    5,    3,    1,    1,    1,    1,    1,    1,    1,    1,
    6,    8,    0,    8,    0,    6,
};
final static short yydefred[] = {                         0,
    0,    5,    6,    0,    0,    7,    0,    0,    0,   36,
    0,    0,    2,    4,    0,   31,   32,   33,   34,   35,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   13,    0,   50,   51,    0,    0,   53,
    0,   48,    3,    0,   40,    0,   37,    0,    0,    0,
    0,    0,    0,   63,   64,   67,   68,   65,   66,    0,
    0,    0,    1,    0,   16,    0,    0,   52,    0,    0,
    0,    0,   29,   22,   38,   55,    0,   56,   62,   69,
   70,    0,    0,    0,    0,   75,    0,   15,   19,    0,
    0,    0,   27,   12,    0,    0,   46,   47,    0,   60,
    0,    0,   59,    0,    0,    0,    0,   18,    0,    0,
   54,   57,   61,   73,   76,    0,   71,    0,   26,    0,
    0,    0,    0,   74,   72,    0,    8,    0,    0,    0,
    0,    9,   11,    0,    0,   10,
};
final static short yydgoto[] = {                         11,
   12,   13,   22,   14,   15,   93,  123,  129,   29,   39,
   33,   67,   94,   34,   49,    0,   40,   17,   18,   19,
   20,   41,   42,   61,   83,  120,  105,
};
final static short yysindex[] = {                      -125,
 -260,    0,    0,  -83,  -32,    0,  -24, -103,  -20,    0,
    0,  -17,    0,    0, -225,    0,    0,    0,    0,    0,
   72, -250,  -30,    2,  -36,  -33, -239,  -39, -212, -103,
   21, -192,   36,    0,   43,    0,    0,   72,   34,    0,
  -14,    0,    0,  -83,    0,   34,    0, -171,   54,   57,
 -162,  -20,   68,    0,    0,    0,    0,    0,    0,  -43,
   72, -114,    0, -150,    0,   -5, -157,    0,   72,   72,
   72,   72,    0,    0,    0,    0,   90,    0,    0,    0,
    0,  -19,   72,   77, -103,    0, -263,    0,    0,   74,
  -83,   93,    0,    0,  -14,  -14,    0,    0,   99,    0,
   78,  129,    0, -140,   87, -103,   92,    0, -108,  -98,
    0,    0,    0,    0,    0, -119,    0,  123,    0,  105,
  116,   72, -158,    0,    0,  150,    0,  118,  -80,  119,
  -20,    0,    0,  138,  -84,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,   51,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  144,    0,    0,    1,    0,    0,    0,   53,    0,
   13,    0,    0, -136,    0,   55,    0,   -9,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -41,  143,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   82,
    0,    0,    0,    0,   25,   37,    0,    0,    0,    0,
   49,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  121,   44,  -29,   20,  -16,   80,    0,    0,  -40,    6,
    0,    0,    0,  130,  131,    0,   86,    0,    0,    0,
    0,   66,  -31,  136,    0,    0,    0,
};
final static int YYTABLESIZE=346;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         69,
   49,   70,   21,   51,   47,   38,   68,   25,   48,  106,
   43,   78,   45,   21,   73,   26,   58,  107,   59,   28,
   58,  100,   59,   23,   43,   38,   30,   71,   44,   46,
   52,   23,   72,   60,   23,   89,   44,   31,   32,   97,
   98,   49,   49,   49,   49,   49,   38,   49,   58,   48,
   41,   27,   42,   45,   39,   45,   45,   45,   62,   49,
   49,  109,   49,   23,   64,   43,   84,   43,   43,   43,
   65,   45,   45,   63,   45,   66,   69,   44,   70,   44,
   44,   44,   25,   43,   43,   16,   43,  101,  102,   16,
  134,   74,   58,   16,   75,   44,   44,   76,   44,    2,
    3,   91,  127,  128,   77,   87,    6,   58,   79,   41,
   23,   42,   31,   39,  108,   16,   38,  103,  112,   69,
   69,   70,   70,   30,   30,   20,   99,  126,  104,   16,
    1,    2,    3,    4,   95,   96,  110,    5,    6,  111,
  114,    1,    7,    8,    4,  115,    9,   16,    5,  116,
  117,  118,    1,    7,    8,    4,   10,    9,   85,    5,
   91,  121,  122,  124,    7,    8,   86,   10,    9,  113,
   16,   69,    1,   70,  125,  131,   16,  133,   10,    5,
  132,  135,  136,   17,    7,    8,   28,   92,    9,  119,
  130,   16,   69,   88,   70,   82,   90,    0,   10,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   53,   21,    0,    0,
    2,    3,   50,   35,    0,   36,   37,    6,    0,    0,
    0,   80,   81,   54,   55,   56,   57,   54,   55,   56,
   57,   24,    0,   35,    0,   36,   37,   23,   23,   23,
    0,    2,    3,    0,   23,    0,    0,   45,    6,    0,
    0,    0,    0,    0,   35,    0,   36,   37,    0,    0,
   49,   49,    0,   49,    0,   49,   49,   49,   49,   49,
   49,   49,   45,   45,    0,   45,    0,   45,   45,   45,
   45,   45,   45,   45,   43,   43,    0,   43,    0,   43,
   43,   43,   43,   43,   43,   43,   44,   44,    0,   44,
    0,   44,   44,   44,   44,   44,   44,   44,   58,   58,
   41,   58,   42,   41,   39,   42,    0,   39,    0,   58,
    0,   41,    0,   42,   35,   39,   36,   37,   20,   20,
   20,    0,    0,    0,    0,   20,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         43,
    0,   45,   44,   37,   41,   45,   38,   40,   25,  273,
  261,   52,    0,  274,   44,   40,   60,  281,   62,   40,
   60,   41,   62,    4,    0,   45,   44,   42,   59,   24,
  270,   41,   47,   28,   44,   41,    0,  263,  264,   71,
   72,   41,   42,   43,   44,   45,   45,   47,    0,   66,
    0,    8,    0,   41,    0,   43,   44,   45,  271,   59,
   60,   91,   62,   44,   44,   41,   61,   43,   44,   45,
  263,   59,   60,   30,   62,   40,   43,   41,   45,   43,
   44,   45,   40,   59,   60,    0,   62,   82,   83,    4,
  131,  263,   44,    8,   41,   59,   60,   41,   62,  257,
  258,  259,  261,  262,  267,   62,  264,   59,   41,   59,
   91,   59,  263,   59,   41,   30,   45,   41,   41,   43,
   43,   45,   45,  260,  261,   44,   37,  122,   85,   44,
  256,  257,  258,  259,   69,   70,   44,  263,  264,   41,
  281,  256,  268,  269,  259,   59,  272,   62,  263,  106,
   59,  260,  256,  268,  269,  259,  282,  272,  273,  263,
  259,  281,   40,   59,  268,  269,  281,  282,  272,   41,
   85,   43,  256,   45,   59,   58,   91,   59,  282,  263,
  261,   44,  267,   40,  268,  269,   44,   67,  272,  110,
   41,  106,   43,   64,   45,   60,   66,   -1,  282,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  256,  259,   -1,   -1,
  257,  258,  256,  263,   -1,  265,  266,  264,   -1,   -1,
   -1,  275,  276,  277,  278,  279,  280,  277,  278,  279,
  280,  274,   -1,  263,   -1,  265,  266,  257,  258,  259,
   -1,  257,  258,   -1,  264,   -1,   -1,  256,  264,   -1,
   -1,   -1,   -1,   -1,  263,   -1,  265,  266,   -1,   -1,
  270,  271,   -1,  273,   -1,  275,  276,  277,  278,  279,
  280,  281,  270,  271,   -1,  273,   -1,  275,  276,  277,
  278,  279,  280,  281,  270,  271,   -1,  273,   -1,  275,
  276,  277,  278,  279,  280,  281,  270,  271,   -1,  273,
   -1,  275,  276,  277,  278,  279,  280,  281,  270,  271,
  270,  273,  270,  273,  270,  273,   -1,  273,   -1,  281,
   -1,  281,   -1,  281,  263,  281,  265,  266,  257,  258,
  259,   -1,   -1,   -1,   -1,  264,
};
}
final static short YYFINAL=11;
final static short YYMAXTOKEN=282;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,"'%'",null,null,"'('","')'","'*'","'+'",
"','","'-'",null,"'/'",null,null,null,null,null,null,null,null,null,null,"':'",
"';'","'<'",null,"'>'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,"UINT","DOUBLE","BEGIN","RETURN","END",
"POST","ID","FUNC","CTE_UINT","CTE_DOUBLE","CADENA","PRINT","REPEAT","UNTIL",
"THEN","IF","ELSE","ASIG","AND","OR","COMP_MAYOR_IGUAL","COMP_MENOR_IGUAL",
"COMP_IGUAL","COMP_DISTINTO","ENDIF","BREAK",
};
final static String yyrule[] = {
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
"post_condicion : POST ':' condicion ',' CADENA",
"retorno : '(' expresion ')' ';'",
"declaracion : tipo_id nombre_func params_func definicion_func",
"declaracion : tipo_id lista_variables",
"lista_variables : ID",
"lista_variables : ID ',' lista_variables",
"nombre_func : FUNC ID",
"nombre_func : FUNC",
"params_func : '(' param ')'",
"params_func : '(' ')'",
"params_func : '(' param",
"params_func : '('",
"param : tipo_id ID",
"param : tipo_id",
"separador_variables :",
"separador_variables : ','",
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

//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 5:
//#line 19 "..\gramatica.y"
{}
break;
case 6:
//#line 20 "..\gramatica.y"
{}
break;
case 12:
//#line 31 "..\gramatica.y"
{}
break;
case 14:
//#line 35 "..\gramatica.y"
{}
break;
case 15:
//#line 36 "..\gramatica.y"
{}
break;
case 16:
//#line 39 "..\gramatica.y"
{}
break;
case 17:
//#line 40 "..\gramatica.y"
{yyerror("Falta el identificador del procedimiento.");}
break;
case 20:
//#line 45 "..\gramatica.y"
{yyerror("Falta el parentesis de cierre para los parametros.");}
break;
case 21:
//#line 46 "..\gramatica.y"
{yyerror("Falta el parentesis de cierre para los parametros.");}
break;
case 22:
//#line 49 "..\gramatica.y"
{;}
break;
case 23:
//#line 50 "..\gramatica.y"
{yyerror("Falta el identificador de un parametro.");}
break;
case 24:
//#line 53 "..\gramatica.y"
{yyerror("Falta una ',' para separar dos parametros.");}
break;
case 28:
//#line 59 "..\gramatica.y"
{yyerror("Cuerpo del procedimiento vacio.");}
break;
case 37:
//#line 74 "..\gramatica.y"
{}
break;
case 38:
//#line 75 "..\gramatica.y"
{}
break;
case 39:
//#line 78 "..\gramatica.y"
{}
break;
case 40:
//#line 79 "..\gramatica.y"
{yyerror("El lado derecho de la asignacio no es valido.");}
break;
case 41:
//#line 80 "..\gramatica.y"
{yyerror("Un identificador en solitario no es una sentencia valida.");}
break;
case 42:
//#line 81 "..\gramatica.y"
{yyerror("El lado izquierdo de la asignacion no es valido");}
break;
case 43:
//#line 84 "..\gramatica.y"
{}
break;
case 44:
//#line 85 "..\gramatica.y"
{}
break;
case 46:
//#line 89 "..\gramatica.y"
{}
break;
case 47:
//#line 90 "..\gramatica.y"
{}
break;
case 49:
//#line 94 "..\gramatica.y"
{}
break;
case 50:
//#line 95 "..\gramatica.y"
{}
break;
case 51:
//#line 96 "..\gramatica.y"
{}
break;
case 52:
//#line 97 "..\gramatica.y"
{}
break;
case 53:
//#line 98 "..\gramatica.y"
{}
break;
case 57:
//#line 108 "..\gramatica.y"
{}
break;
case 58:
//#line 109 "..\gramatica.y"
{yyerror("Falta parentesis de cierre de la condicion.");}
break;
case 59:
//#line 110 "..\gramatica.y"
{yyerror("Falta expresion en el lado izquierdo de la condicion.");}
break;
case 60:
//#line 111 "..\gramatica.y"
{yyerror("Falta expresion en el lado derecho de la condicion.");}
break;
case 62:
//#line 113 "..\gramatica.y"
{yyerror("Error en la condicion.");}
break;
case 73:
//#line 130 "..\gramatica.y"
{yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.")}
break;
case 75:
//#line 131 "..\gramatica.y"
{yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.")}
break;
//#line 668 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
