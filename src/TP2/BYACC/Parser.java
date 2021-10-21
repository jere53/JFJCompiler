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
	import TP3.Polaca;
	import TP3.Utils;
//#line 25 "Parser.java"




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
    4,    4,    4,    4,    4,    4,    4,    4,    4,   16,
   16,   17,   17,   17,   17,   10,   10,   10,   21,   21,
   21,   22,   22,   22,   22,   22,   22,   22,   20,   20,
   18,   18,    9,    9,    9,    9,    9,    9,   23,   23,
   23,   23,   23,   23,   24,   24,   19,   19,   19,   19,
   19,   19,   19,
};
final static short yylen[] = {                            2,
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
final static short yydefred[] = {                         0,
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
final static short yydgoto[] = {                         11,
   12,   13,   22,   14,   15,  106,  133,  137,   29,   53,
   35,   79,  107,   36,  103,   16,   17,   18,   19,   20,
   55,   56,   74,   95,
};
final static short yysindex[] = {                      -104,
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
final static short yyrindex[] = {                         0,
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
final static short yygindex[] = {                         0,
  -72,    4,  -21,   39,   85,   66,    0,    0,  -59,   13,
    0,    0,    0,   90,    0,   53,    0,    0,    0,    0,
  -10,  -20,  100,    0,
};
final static int YYTABLESIZE=560;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        113,
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
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
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

//#line 155 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"


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
//#line 471 "Parser.java"
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
case 12:
//#line 39 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 16:
//#line 45 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 17:
//#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 18:
//#line 49 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 19:
//#line 50 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el identificador del procedimiento.");}
break;
case 25:
//#line 62 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Cuerpo del procedimiento vacio.");}
break;
case 28:
//#line 69 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Invocacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 29:
//#line 70 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Asignacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 30:
//#line 71 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Iteracion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 31:
//#line 72 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Seleccion (IF) en la linea " + AnalizadorLexico.nroLinea);}
break;
case 32:
//#line 73 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Impresion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 34:
//#line 75 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 35:
//#line 76 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 36:
//#line 77 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 37:
//#line 78 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 38:
//#line 79 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 39:
//#line 80 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 40:
//#line 83 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 41:
//#line 84 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 43:
//#line 88 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
break;
case 44:
//#line 89 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
break;
case 45:
//#line 90 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
break;
case 57:
//#line 113 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
break;
case 58:
//#line 114 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
break;
case 60:
//#line 118 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " invalid argument for PRINT");}
break;
case 62:
//#line 122 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " UNTIL expected");}
break;
case 64:
//#line 126 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta parentesis de cierre de la condicion.");}
break;
case 65:
//#line 127 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
break;
case 66:
//#line 128 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
break;
case 68:
//#line 130 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}
break;
case 79:
//#line 147 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el bloque de sentencias ejecutables de la rama THEN.");}
break;
case 80:
//#line 148 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
break;
case 81:
//#line 149 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el bloque de sentencias ejecutables de la rama THEN.");}
break;
case 82:
//#line 150 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
break;
case 83:
//#line 151 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
break;
//#line 760 "Parser.java"
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
