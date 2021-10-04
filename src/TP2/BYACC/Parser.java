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






//#line 2 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
	package TP2.BYACC;
	import Dev.Lexico.AnalizadorLexico;
	import Dev.Lexico.Dupla;
	import Dev.Lexico.TablaSimbolos;
	import Dev.RegistroTS;
//#line 23 "Parser.java"




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
public final static short ERR_CTE_FUERA_RANGO=283;
public final static short ERR_FORMATO_CTE=284;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    2,    2,    5,    5,    5,    6,    6,    8,
    7,    1,    1,    1,    1,   14,   14,   11,   11,   12,
   12,   15,   13,   13,   13,    3,    3,    4,    4,    4,
    4,    4,    4,   16,   16,   17,   17,   17,   17,   10,
   10,   10,   21,   21,   21,   22,   22,   22,   22,   22,
   20,   20,   18,    9,    9,    9,    9,    9,    9,   23,
   23,   23,   23,   23,   23,   24,   24,   19,   19,   19,
   19,
};
final static short yylen[] = {                            2,
    2,    1,    4,    1,    1,    1,    1,    5,    6,    6,
    4,    5,    3,    4,    6,    1,    3,    2,    1,    3,
    2,    2,    2,    1,    0,    2,    1,    2,    2,    2,
    2,    2,    2,    3,    4,    3,    3,    1,    3,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    2,    1,
    4,    4,    4,    5,    4,    4,    4,    5,    3,    1,
    1,    1,    1,    1,    1,    1,    1,    5,    7,    6,
    4,
};
final static short yydefred[] = {                         0,
    0,    5,    6,    0,    0,    7,    0,    0,    0,    0,
    0,    0,    2,    4,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   33,
    1,    0,    0,    0,    0,   28,   29,   30,   31,   32,
    0,   47,   48,    0,    0,   50,    0,   45,    0,   26,
   37,    0,   34,    0,    0,    0,    0,    0,    0,   60,
   61,   64,   65,   62,   63,    0,    0,    0,    0,   18,
    0,    0,    0,   49,    0,    0,    0,    0,    3,   22,
   35,   52,   51,   53,   59,   66,   67,    0,    0,    0,
    0,   71,    0,   17,   21,    0,    0,    0,   24,    0,
   14,    0,    0,   43,   44,   57,    0,    0,   56,    0,
    0,   68,   20,    0,   23,    0,   54,   58,   70,    0,
    0,   15,   69,    0,    0,    0,    8,    0,    0,    0,
    0,    9,   11,    0,    0,    0,   10,
};
final static short yydgoto[] = {                         11,
   12,   13,   22,   14,   15,   99,  125,  129,   29,   45,
   34,   72,  100,   35,   55,   46,   17,   18,   19,   20,
   47,   48,   67,   89,
};
final static short yysindex[] = {                      -153,
 -218,    0,    0,  -98,  -33,    0,   22, -133,   34,   43,
    0, -133,    0,    0, -179,   58,   66,   68,   72,   81,
   25, -169,  -98,   33,  -36, -212, -128,   15, -126,    0,
    0,  108, -103,  122,  105,    0,    0,    0,    0,    0,
  126,    0,    0,   25,    9,    0,   11,    0,  114,    0,
    0,    9,    0,  -85,  138,  139,  140,   34,  142,    0,
    0,    0,    0,    0,    0,   -3,   25, -135,  -78,    0,
  -32, -176, -191,    0,   25,   25,   25,   25,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   20,   25,   48,
 -133,    0, -236,    0,    0,  145,  -98,  -72,    0,  129,
    0,   11,   11,    0,    0,    0,   54,   55,    0,  -92,
 -133,    0,    0,  -70,    0, -191,    0,    0,    0,  -90,
  152,    0,    0,   25, -149,   77,    0,  135,  -67,  136,
   34,    0,    0,  153,  -71,  141,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,   68,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -110,    0,    0,    0,    0,    0,    0,    0,
    0,  143,  158,    0,    0,    0,    0,    0,    0,    0,
  -41,    0,    0,    0,   72,    0,  -31,    0,    0,    0,
    0,   58,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  144, -115,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -21,  -11,    0,    0,    0,   -9,    0,    0,    0,
    0,    0,    0,    0,    0, -100,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  -47,    3,   -7,    4,   -8,  103,    0,    0,  -22,   19,
    0,    0,    0,  130,  133,   64,    0,    0,    0,    0,
  101,    2,  146,    0,
};
final static int YYTABLESIZE=299;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         46,
   46,   46,   46,   46,   53,   46,   25,   23,   95,   42,
   27,   42,   42,   42,   31,   50,   54,   46,   46,   40,
   46,   40,   40,   40,   98,  101,   23,   42,   42,   41,
   42,   41,   41,   41,   55,   84,  111,   40,   40,   75,
   40,   76,   52,   56,  112,   74,   66,   41,   41,   55,
   41,   75,   77,   76,   57,   21,   64,   78,   65,   44,
  106,   26,   54,   16,   44,    2,    3,   16,  122,   44,
   93,   16,    6,   28,   64,   16,   65,   44,  104,  105,
    2,    3,   97,   32,   33,   90,   16,    6,  109,  114,
   75,   49,   76,  110,  117,  118,   75,   75,   76,   76,
   23,   30,    1,    2,    3,    4,  107,  108,  134,    5,
    6,  127,  128,  120,    7,    8,   36,  130,    9,   75,
    1,   76,    1,    4,   37,    4,   38,    5,   10,    5,
   39,   16,    7,    8,    7,    8,    9,   91,    9,   40,
   13,   58,  126,   13,   68,   92,   10,   13,   10,   27,
   27,   69,   13,   13,   16,   12,   13,    1,   12,   70,
   16,   71,   12,   73,    5,   25,   13,   12,   12,    7,
    8,   12,   79,    9,   16,  102,  103,   80,   81,   82,
   83,   12,   85,   10,   32,  113,   97,  116,  119,  121,
  123,  124,  131,  132,  133,  136,  135,   19,   94,  137,
  115,   16,   25,   96,    0,    0,    0,    0,    0,    0,
    0,   88,    0,    0,    0,    0,    0,    0,    0,    0,
    2,    3,    0,    0,    2,    3,    0,    6,    0,   46,
    0,    6,    0,   46,   46,   46,   46,   46,   46,   42,
   24,    0,    0,   42,   42,   42,   42,   42,   42,   40,
    0,    0,    0,   40,   40,   40,   40,   40,   40,   41,
    0,   55,    0,   41,   41,   41,   41,   41,   41,    0,
   59,   86,   87,   60,   61,   62,   63,   41,    0,   42,
   43,    0,   41,    0,   42,   43,    0,   41,   51,   42,
   43,   60,   61,   62,   63,   41,    0,   42,   43,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   42,   43,   44,   45,   41,   47,   40,    4,   41,   41,
    8,   43,   44,   45,   12,   23,   25,   59,   60,   41,
   62,   43,   44,   45,   72,   73,   23,   59,   60,   41,
   62,   43,   44,   45,   44,   58,  273,   59,   60,   43,
   62,   45,   24,  256,  281,   44,   28,   59,   60,   59,
   62,   43,   42,   45,  267,  274,   60,   47,   62,   45,
   41,   40,   71,    0,   45,  257,  258,    4,  116,   45,
   68,    8,  264,   40,   60,   12,   62,   45,   77,   78,
  257,  258,  259,  263,  264,   67,   23,  264,   41,   97,
   43,  261,   45,   91,   41,   41,   43,   43,   45,   45,
   97,   59,  256,  257,  258,  259,   88,   89,  131,  263,
  264,  261,  262,  111,  268,  269,   59,   41,  272,   43,
  256,   45,  256,  259,   59,  259,   59,  263,  282,  263,
   59,   68,  268,  269,  268,  269,  272,  273,  272,   59,
  256,  270,  124,  259,  271,  281,  282,  263,  282,  260,
  261,   44,  268,  269,   91,  256,  272,  256,  259,  263,
   97,   40,  263,   59,  263,   40,  282,  268,  269,  268,
  269,  272,   59,  272,  111,   75,   76,  263,   41,   41,
   41,  282,   41,  282,  263,   41,  259,   59,  281,  260,
  281,   40,   58,  261,   59,  267,   44,   40,   69,   59,
   98,   59,   59,   71,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   66,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  257,  258,   -1,   -1,  257,  258,   -1,  264,   -1,  271,
   -1,  264,   -1,  275,  276,  277,  278,  279,  280,  271,
  274,   -1,   -1,  275,  276,  277,  278,  279,  280,  271,
   -1,   -1,   -1,  275,  276,  277,  278,  279,  280,  271,
   -1,  271,   -1,  275,  276,  277,  278,  279,  280,   -1,
  256,  275,  276,  277,  278,  279,  280,  263,   -1,  265,
  266,   -1,  263,   -1,  265,  266,   -1,  263,  256,  265,
  266,  277,  278,  279,  280,  263,   -1,  265,  266,
};
}
final static short YYFINAL=11;
final static short YYMAXTOKEN=284;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,"'('","')'","'*'","'+'","','",
"'-'",null,"'/'",null,null,null,null,null,null,null,null,null,null,"':'","';'",
"'<'",null,"'>'",null,null,null,null,null,null,null,null,null,null,null,null,
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
null,null,null,null,null,null,"UINT","DOUBLE","BEGIN","RETURN","END","POST",
"ID","FUNC","CTE_UINT","CTE_DOUBLE","CADENA","PRINT","REPEAT","UNTIL","THEN",
"IF","ELSE","ASIG","AND","OR","COMP_MAYOR_IGUAL","COMP_MENOR_IGUAL",
"COMP_IGUAL","COMP_DISTINTO","ENDIF","BREAK","ERR_CTE_FUERA_RANGO",
"ERR_FORMATO_CTE",
};
final static String yyrule[] = {
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

//#line 138 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"

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
//#line 399 "Parser.java"
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
//#line 25 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 6:
//#line 26 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 12:
//#line 40 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 16:
//#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 17:
//#line 47 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 18:
//#line 50 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 19:
//#line 51 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta el identificador del procedimiento.");}
break;
case 25:
//#line 63 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Cuerpo del procedimiento vacio.");}
break;
case 34:
//#line 78 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 35:
//#line 79 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 36:
//#line 82 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 37:
//#line 83 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("El lado derecho de la asignacio no es valido.");}
break;
case 38:
//#line 84 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Un identificador en solitario no es una sentencia valida.");}
break;
case 39:
//#line 85 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("El lado izquierdo de la asignacion no es valido");}
break;
case 40:
//#line 88 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 41:
//#line 89 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 43:
//#line 93 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 44:
//#line 94 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 46:
//#line 98 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 47:
//#line 99 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 48:
//#line 100 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 49:
//#line 101 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 50:
//#line 102 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 54:
//#line 112 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 55:
//#line 113 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta parentesis de cierre de la condicion.");}
break;
case 56:
//#line 114 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta expresion en el lado izquierdo de la condicion.");}
break;
case 57:
//#line 115 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta expresion en el lado derecho de la condicion.");}
break;
case 59:
//#line 117 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Error en la condicion.");}
break;
case 70:
//#line 134 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.");}
break;
case 71:
//#line 135 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("Falta el bloque de sentencias ejecutables de la rama THEN.");}
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
