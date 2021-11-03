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
public final static short PROGRAM=257;
public final static short UINT=258;
public final static short DOUBLE=259;
public final static short BEGIN=260;
public final static short RETURN=261;
public final static short END=262;
public final static short POST=263;
public final static short ID=264;
public final static short FUNC=265;
public final static short CTE_UINT=266;
public final static short CTE_DOUBLE=267;
public final static short CADENA=268;
public final static short PRINT=269;
public final static short REPEAT=270;
public final static short UNTIL=271;
public final static short THEN=272;
public final static short IF=273;
public final static short ELSE=274;
public final static short ASIG=275;
public final static short AND=276;
public final static short OR=277;
public final static short COMP_MAYOR_IGUAL=278;
public final static short COMP_MENOR_IGUAL=279;
public final static short COMP_IGUAL=280;
public final static short COMP_DISTINTO=281;
public final static short ENDIF=282;
public final static short BREAK=283;
public final static short ERR_CTE_FUERA_RANGO=284;
public final static short ERR_FORMATO_CTE=285;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    0,    0,    0,    0,    2,    4,    4,    6,
    6,    6,    7,    7,    7,    7,    7,    7,    9,    9,
    8,    1,    1,    1,    1,    1,    1,   15,   15,   12,
   12,   13,   13,   16,   14,   14,   14,    3,    3,    5,
    5,    5,    5,    5,    5,    5,    5,    5,    5,    5,
    5,   17,   17,   18,   18,   18,   18,   11,   11,   11,
   22,   22,   22,   23,   23,   23,   23,   23,   23,   23,
   21,   21,   19,   19,   10,   10,   10,   10,   10,   10,
   24,   24,   24,   24,   24,   24,   25,   25,   20,   20,
   20,   20,   20,   20,   20,
};
final static short yylen[] = {                            2,
    5,    4,    4,    3,    2,    1,    4,    4,    1,    1,
    1,    1,    5,    6,    4,    5,    5,    6,    6,    5,
    4,    5,    3,    4,    6,    2,    3,    1,    3,    2,
    1,    3,    2,    2,    2,    1,    0,    2,    1,    2,
    2,    2,    2,    2,    2,    2,    2,    2,    2,    2,
    2,    3,    4,    3,    3,    1,    3,    3,    3,    1,
    3,    3,    1,    1,    1,    1,    2,    1,    1,    1,
    4,    4,    4,    2,    5,    4,    4,    4,    5,    3,
    1,    1,    1,    1,    1,    1,    1,    1,    5,    7,
    6,    5,    4,    6,    4,
};
final static short yydefred[] = {                         0,
    0,   10,   11,    0,    0,   12,    0,    0,    6,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    5,    0,    0,
    0,    0,    0,    0,    4,    0,    0,    0,    0,    0,
    0,    9,    0,    0,   45,   51,    0,   38,   40,   47,
   41,   48,   42,   49,   43,   46,   44,   50,   29,   30,
    0,    0,    0,   27,    0,    2,    3,    0,   65,   66,
   69,   70,    0,    0,   68,    0,   63,   55,    0,    0,
   52,    0,    0,    0,    0,    0,   81,   82,   85,   86,
   83,   84,    0,    0,    0,    7,   33,    0,    0,    0,
    0,   36,    0,   24,    1,   67,    0,    0,    0,    0,
   53,   72,   71,    0,   73,   80,   87,   88,    0,    0,
    0,    0,   93,    0,   34,   32,    0,   35,    0,    0,
    0,   61,   62,    8,   78,    0,    0,   77,    0,    0,
   89,    0,   25,   75,   79,   91,    0,   15,    0,    0,
    0,    0,    0,   90,    0,   17,    0,    0,   13,    0,
   16,    0,   18,    0,   14,    0,   21,    0,   20,   19,
};
final static short yydgoto[] = {                          7,
    8,    9,   20,   41,   21,   10,  102,  152,  153,   44,
   74,   30,   62,  103,   11,   99,   22,   23,   24,   25,
   26,   76,   77,   94,  120,
};
final static short yysindex[] = {                      -129,
  -43,    0,    0,  239,  -35,    0,    0, -248,    0, -225,
  -32,  -15, -101, -244,  -39,   10,  194,   23,  -56, -202,
  239,  -54,  117,  124,  135,  142, -194,    0, -183,   44,
   41,  -91, -101, -248,    0,    3,   98,  -26, -246,  239,
 -163,    0,   72, -152,    0,    0,   53,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -28,  -74,  -91,    0, -248,    0,    0,   75,    0,    0,
    0,    0,    3,   35,    0,   -5,    0,    0,   35,   82,
    0,   92,   96, -115,   23,  107,    0,    0,    0,    0,
    0,    0,   64,    3, -104,    0,    0, -109,  121,  239,
  -89,    0,  116,    0,    0,    0,    3,    3,    3,    3,
    0,    0,    0,  118,    0,    0,    0,    0,  -41,    3,
   34,  194,    0, -250,    0,    0,  -80,    0,  -91,   -5,
   -5,    0,    0,    0,    0,   48,  152,    0, -102,  194,
    0,  -29,    0,    0,    0,    0,  -95,    0,  130, -160,
    3, -157,  -73,    0,   23,    0,  -70,  162,    0,  -66,
    0,  154,    0,  140,    0,  -57,    0,  145,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,  147,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  153,    0,    0,    0,    0,    0,
 -143,    0,    0,    0,    0,    0,    0,    0,  169,    0,
    0,  -42,    0,    0,    0,    0,    0,    0,    0,    0,
  165,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  161,  -38,    0,    0,    0,    0,  -24,    0,    0,
    0,    0,    0,  176,    0,    2,    0,    0,  183,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  201,    0,    0,    0,    0,  -21,   28,
   54,    0,    0,    0,    0,  102,    0,    0,  217,    0,
    0,    0,    0,    0,    0,    0,  232,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   20,   88,  -14,  -81,   32,  167,  146,    0,  -58,  -79,
   -9,    0,    0,    0,   -2,    0,   31,    0,    0,    0,
    0,   37,  -44,  148,    0,
};
final static int YYTABLESIZE=522;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        135,
   38,  169,   45,   73,   49,  115,   48,   31,   27,   82,
  151,    4,   97,  124,   81,   13,   64,   64,   64,   64,
   64,   83,   64,  140,   59,   84,   32,   79,  106,  150,
   36,  141,   34,   93,   64,   64,  109,   64,    5,   29,
  139,  110,   60,   33,   60,   60,   60,   73,   42,   39,
   46,   64,   65,   50,   52,   54,   56,   58,  147,   47,
   60,   60,   43,   60,  132,  133,   75,   75,   58,    5,
   58,   58,   58,   75,  138,  162,  107,  107,  108,  108,
   60,  101,  104,   61,  121,  127,   58,   58,  144,   58,
  107,  157,  108,  160,   59,   28,   59,   59,   59,   63,
   35,  156,  149,   75,  159,  149,  107,   85,  108,  136,
  137,   96,   59,   59,   38,   59,   73,   39,   39,   95,
   66,   67,  111,   91,   75,   92,   42,    1,    2,    3,
    4,   91,  112,   92,    5,    6,  113,   75,   75,   75,
   75,  158,   73,  130,  131,   76,  114,  116,  143,   75,
   75,   14,  105,   42,  125,   40,    2,    3,    4,   15,
   76,  126,    5,    6,   16,   17,    2,    3,   18,  122,
  100,   42,    5,    6,  129,   51,  134,  123,   19,  146,
  142,   75,   53,    2,    3,  100,  154,  155,  161,    5,
    6,  163,  145,   55,  107,  165,  108,  166,  167,   14,
   57,   14,  164,  170,  107,   28,  108,   15,   31,   15,
  168,   56,   16,   17,   16,   17,   18,   26,   18,   37,
   12,   23,   68,   74,   69,   70,   19,   98,   19,    2,
    3,   64,  148,  149,   57,   37,    6,   80,   22,   64,
  119,   54,   71,   72,   64,   64,  128,   64,   64,    0,
    0,   64,   64,   64,   64,   64,   64,   60,   64,   95,
    0,    0,    0,    0,    0,   60,   68,    0,   69,   70,
   60,   60,    0,   60,   60,   92,    0,   60,   60,   60,
   60,   60,   60,   58,   60,    0,   71,   72,    0,    0,
   94,   58,    0,    0,    0,    0,   58,   58,    0,   58,
   58,    0,    0,   58,   58,   58,   58,   58,   58,   59,
   58,    0,    0,    0,    0,    0,    0,   59,    0,    0,
    0,    0,   59,   59,    0,   59,   59,   86,    0,   59,
   59,   59,   59,   59,   59,   68,   59,   69,   70,  117,
  118,   87,   88,   89,   90,    0,    0,    0,    0,   87,
   88,   89,   90,   78,    0,   71,   72,   76,    0,    0,
    0,   68,    0,   69,   70,   76,    0,    0,    0,    0,
   76,   76,   14,   76,   76,    0,    0,    0,    0,   14,
   15,   71,   72,    0,   76,   16,   17,   15,    0,   18,
   14,    0,   16,   17,    0,    0,   18,   14,   15,   19,
    0,    0,    0,   16,   17,   15,   19,   18,   56,    0,
   16,   17,    0,    0,   18,    0,   56,   19,    0,    0,
   74,   56,   56,    0,   19,   56,    0,    0,   74,    0,
    0,   57,    0,   74,   74,   56,    0,   74,   54,   57,
    0,    0,    0,    0,   57,   57,   54,   74,   57,   14,
    0,   54,   54,   40,    0,   54,   95,   15,   57,    0,
    0,    0,   16,   17,   95,   54,   18,    0,    0,   95,
   95,    0,   92,   95,    0,    0,   19,    0,    0,    0,
   92,    0,    0,   95,    0,   92,   92,   94,    0,   92,
    0,    0,    0,    0,   14,   94,    0,    0,    0,   92,
   94,   94,   15,    0,   94,    0,    0,   16,   17,    0,
    0,   18,    0,    0,   94,    0,    0,    0,    0,    0,
    0,   19,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   40,   59,   59,   45,   59,   85,   21,   10,   44,  256,
   40,  260,   41,   95,   41,   59,   41,   42,   43,   44,
   45,  268,   47,  274,   27,   40,   59,   37,   73,   59,
  275,  282,   13,   43,   59,   60,   42,   62,  264,  265,
  122,   47,   41,   59,   43,   44,   45,   45,   17,   40,
   19,   32,   33,   22,   23,   24,   25,   26,  140,  262,
   59,   60,   40,   62,  109,  110,   36,   37,   41,  264,
   43,   44,   45,   43,   41,  155,   43,   43,   45,   45,
  264,   62,   63,   40,   94,  100,   59,   60,   41,   62,
   43,  150,   45,  152,   41,    8,   43,   44,   45,   59,
   13,  262,  263,   73,  262,  263,   43,  271,   45,  119,
  120,   59,   59,   60,   40,   62,   45,  261,  262,  272,
   33,   34,   41,   60,   94,   62,   95,  257,  258,  259,
  260,   60,   41,   62,  264,  265,   41,  107,  108,  109,
  110,  151,   45,  107,  108,   44,  262,   41,  129,  119,
  120,  256,   65,  122,  264,  260,  258,  259,  260,  264,
   59,   41,  264,  265,  269,  270,  258,  259,  273,  274,
  260,  140,  264,  265,   59,   59,   59,  282,  283,  282,
  261,  151,   59,  258,  259,  260,  282,   58,  262,  264,
  265,  262,   41,   59,   43,  262,   45,   44,   59,  256,
   59,  256,   41,   59,   43,   59,   45,  264,   40,  264,
  268,   59,  269,  270,  269,  270,  273,  260,  273,   59,
  264,  260,  264,   59,  266,  267,  283,   61,  283,  258,
  259,  256,  262,  263,   59,  275,  265,  264,  260,  264,
   93,   59,  284,  285,  269,  270,  101,  272,  273,   -1,
   -1,  276,  277,  278,  279,  280,  281,  256,  283,   59,
   -1,   -1,   -1,   -1,   -1,  264,  264,   -1,  266,  267,
  269,  270,   -1,  272,  273,   59,   -1,  276,  277,  278,
  279,  280,  281,  256,  283,   -1,  284,  285,   -1,   -1,
   59,  264,   -1,   -1,   -1,   -1,  269,  270,   -1,  272,
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
   -1,   -1,   -1,   -1,  269,  270,  264,  283,  273,  256,
   -1,  269,  270,  260,   -1,  273,  256,  264,  283,   -1,
   -1,   -1,  269,  270,  264,  283,  273,   -1,   -1,  269,
  270,   -1,  256,  273,   -1,   -1,  283,   -1,   -1,   -1,
  264,   -1,   -1,  283,   -1,  269,  270,  256,   -1,  273,
   -1,   -1,   -1,   -1,  256,  264,   -1,   -1,   -1,  283,
  269,  270,  264,   -1,  273,   -1,   -1,  269,  270,   -1,
   -1,  273,   -1,   -1,  283,   -1,   -1,   -1,   -1,   -1,
   -1,  283,
};
}
final static short YYFINAL=7;
final static short YYMAXTOKEN=285;
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
null,null,null,null,null,null,"PROGRAM","UINT","DOUBLE","BEGIN","RETURN","END",
"POST","ID","FUNC","CTE_UINT","CTE_DOUBLE","CADENA","PRINT","REPEAT","UNTIL",
"THEN","IF","ELSE","ASIG","AND","OR","COMP_MAYOR_IGUAL","COMP_MENOR_IGUAL",
"COMP_IGUAL","COMP_DISTINTO","ENDIF","BREAK","ERR_CTE_FUERA_RANGO",
"ERR_FORMATO_CTE",
};
final static String yyrule[] = {
"$accept : program",
"program : PROGRAM ID ';' declaracion cuerpo_programa",
"program : PROGRAM ID ';' cuerpo_programa",
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
"declaracion : tipo_id lista_variables ';' declaracion",
"declaracion : tipo_id nombre_func params_func definicion_func ';' declaracion",
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

//#line 169 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"

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
//#line 485 "Parser.java"
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
case 3:
//#line 18 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
break;
case 4:
//#line 19 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
break;
case 5:
//#line 20 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got declaracion instead");}
break;
case 6:
//#line 21 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got cuerpo_programa instead");}
break;
case 15:
//#line 38 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 16:
//#line 39 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 17:
//#line 40 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 18:
//#line 41 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 20:
//#line 45 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " CADENA expected but got ; instead");}
break;
case 21:
//#line 48 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("Retorno");}
break;
case 26:
//#line 55 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 27:
//#line 56 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 28:
//#line 59 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 29:
//#line 60 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 30:
//#line 63 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 31:
//#line 64 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el identificador del procedimiento.");}
break;
case 37:
//#line 76 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Cuerpo del procedimiento vacio.");}
break;
case 40:
//#line 83 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Invocacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 41:
//#line 84 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Asignacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 42:
//#line 85 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Iteracion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 43:
//#line 86 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Seleccion (IF) en la linea " + AnalizadorLexico.nroLinea);}
break;
case 44:
//#line 87 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Impresion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 46:
//#line 89 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 47:
//#line 90 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 48:
//#line 91 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 49:
//#line 92 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 50:
//#line 93 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 51:
//#line 94 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 52:
//#line 97 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 53:
//#line 98 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 54:
//#line 101 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(2).sval)); Polaca.insert(new Integer(ASIG));}
break;
case 55:
//#line 102 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
break;
case 56:
//#line 103 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
break;
case 57:
//#line 104 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
break;
case 58:
//#line 107 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('+'));}
break;
case 59:
//#line 108 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('-'));}
break;
case 61:
//#line 112 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('*'));}
break;
case 62:
//#line 113 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('/'));}
break;
case 64:
//#line 117 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(0).sval));}
break;
case 65:
//#line 118 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(0).sval));}
break;
case 66:
//#line 119 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(0).sval));}
break;
case 67:
//#line 120 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{  /*Sacamos lo ultimo que agregamos a la polaca, porque ya no es valido.
								                Determinamos que signo va a tener la cte.
								                Si es negativa, agregamos "-sval" a la TS.
								                Agregamos el string correcto (devuelto por utils.sig....) a la polaca.*/
                                                Polaca.insert(TablaSimbolos.punteroTS(Utils.signoNegativo(val_peek(0).sval)));
                                                }
break;
case 68:
//#line 126 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(0).sval));}
break;
case 69:
//#line 127 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
break;
case 70:
//#line 128 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
break;
case 71:
//#line 131 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(1).sval)); Polaca.insert(new Integer(PRINT));}
break;
case 72:
//#line 132 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " invalid argument for PRINT");}
break;
case 74:
//#line 136 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " UNTIL expected");}
break;
case 75:
//#line 139 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(val_peek(2).ival));}
break;
case 76:
//#line 140 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta parentesis de cierre de la condicion.");}
break;
case 77:
//#line 141 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
break;
case 78:
//#line 142 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
break;
case 79:
//#line 143 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(val_peek(2).sval));}
break;
case 80:
//#line 144 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}
break;
case 91:
//#line 161 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el bloque de sentencias ejecutables de la rama THEN.");}
break;
case 92:
//#line 162 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
break;
case 93:
//#line 163 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta el bloque de sentencias ejecutables de la rama THEN.");}
break;
case 94:
//#line 164 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
break;
case 95:
//#line 165 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ENDIF expected");}
break;
//#line 875 "Parser.java"
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
