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
	import TP3.Ambito;
//#line 26 "Parser.java"




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
    2,    4,    0,    5,    0,    0,    0,    0,    0,    3,
    3,    7,    7,    9,    9,    9,   10,   10,   10,   10,
   10,   10,   14,   15,   16,   12,   12,   11,    1,    1,
    1,   22,    1,    1,    1,   21,   21,   18,   19,   19,
   23,   24,   20,   25,   20,   20,    6,    6,    8,    8,
    8,    8,    8,    8,    8,    8,    8,    8,    8,    8,
   26,   26,   27,   27,   27,   27,   17,   17,   17,   31,
   31,   31,   32,   32,   32,   32,   32,   32,   32,   30,
   30,   28,   28,   33,   13,   13,   13,   13,   13,   13,
   34,   34,   34,   34,   34,   34,   35,   35,   29,   29,
   36,   36,   37,   37,   38,   38,
};
final static short yylen[] = {                            2,
    0,    0,    7,    0,    5,    4,    3,    2,    1,    4,
    3,    4,    1,    1,    1,    1,    5,    6,    4,    5,
    5,    6,    0,    0,    0,    9,    5,    4,    6,    3,
    4,    0,    8,    2,    3,    1,    3,    1,    3,    2,
    2,    0,    3,    0,    2,    0,    2,    1,    2,    2,
    2,    2,    2,    2,    2,    2,    2,    2,    2,    2,
    3,    4,    3,    3,    1,    3,    3,    3,    1,    3,
    3,    1,    1,    1,    1,    2,    1,    1,    1,    4,
    4,    4,    2,    1,    5,    4,    4,    4,    5,    3,
    1,    1,    1,    1,    1,    1,    1,    1,    3,    4,
    2,    1,    2,    1,    2,    1,
};
final static short yydefred[] = {                         0,
    0,   14,   15,    0,    0,    0,    0,    0,    9,    0,
    0,    0,    0,    0,    0,    0,    0,   84,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   16,    0,    8,    0,    0,    0,    0,    7,    0,   11,
    0,    0,    0,    0,  101,   54,   60,    0,   47,   49,
   56,   50,   57,   51,   58,   52,   55,   53,   59,    0,
    0,   13,    0,    0,   37,   38,    0,    0,   35,    0,
    0,    6,    0,   74,   75,   78,   79,    0,    0,   77,
    0,   72,   64,    0,    0,   61,    0,    0,    0,   91,
   92,   95,   96,   93,   94,    0,    0,   10,    0,    0,
  103,    0,   99,    0,    0,    0,   31,    2,    5,   76,
    0,    0,    0,    0,   62,   81,   80,   90,   97,   98,
    0,    0,    0,    0,   82,  105,  100,   40,    0,    0,
   42,    0,    0,    0,    0,    0,   70,   71,   88,    0,
    0,   87,   12,   41,   39,    0,    0,    0,   45,    3,
   85,   89,   43,    0,    0,   33,    0,   19,    0,    0,
    0,    0,    0,    0,   21,    0,    0,   17,    0,   20,
    0,   22,    0,   18,    0,   28,    0,   27,   23,   24,
   25,   26,
};
final static short yydgoto[] = {                          7,
    8,   70,    9,  134,   71,   21,   61,   22,   10,  149,
  162,  163,   45,  180,  181,  182,   79,   67,  106,  132,
   11,  154,  130,  146,  133,   23,   24,   25,   26,   27,
   81,   82,   28,   97,  122,   29,   64,  104,
};
final static short yysindex[] = {                       -68,
  -43,    0,    0,  -96,  -35, -202,    0, -236,    0, -223,
    7,   11, -205, -242,   18,  -39,   61,    0,   75,  -56,
 -204,  -85,  -54,  117,  124,  135,  142, -133, -147, -223,
    0, -136,    0,   74,  137,    0, -236,    0,    3,    0,
   98,  -26, -231,   72,    0,    0,    0,   76,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -85,
 -127,    0, -133, -248,    0,    0,  105,  137,    0,  137,
 -236,    0,  107,    0,    0,    0,    0,    3,   -1,    0,
   32,    0,    0,   -1,  108,    0,  111,  116,  118,    0,
    0,    0,    0,    0,    0,   64,    3,    0, -104,   75,
    0, -133,    0, -120,  -28,  137,    0,    0,    0,    0,
    3,    3,    3,    3,    0,    0,    0,    0,    0,    0,
  -41,    3,   39,  106,    0,    0,    0,    0,  -97,  129,
    0,  113,  -82, -236,   32,   32,    0,    0,    0,   48,
   51,    0,    0,    0,    0,  -82,    0,  -85,    0,    0,
    0,    0,    0,  137,  -81,    0,  -29,    0,  123, -151,
    3, -144,  -87,   75,    0,  -80,   59,    0,  -76,    0,
  149,    0,  136,    0,  -57,    0,  140,    0,    0,    0,
    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,   11,  -60,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  153,    0,    0,  -67,    0,
    0, -140,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -51,   31,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  165,    0, -243,    0,    0,    0,    0,  -42,    0,    0,
    0,    0,  -24,    0,    0,    0,    0,    0,  176,    0,
    2,    0,    0,  183,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -62,    0,    0,    0,  -53,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   28,   54,    0,    0,    0,  102,
    0,    0,    0,    0,    0,    0,   55,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,
};
final static short yygindex[] = {                         0,
   -3,    0,   14,    0,    0,  -10,  -34,  437,    1,   60,
    0,  -52,  -86,    0,    0,    0,    8,    0,    0,    0,
   -2,    0,    0,    0,    0,   42,    0,    0,    0,    0,
   30,  -38,    0,  126,    0,    0,    0,    0,
};
final static int YYTABLESIZE=539;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        139,
   42,  178,   46,   78,   50,   46,   32,   34,   30,   37,
  161,   49,  128,  125,   86,   13,   73,   73,   73,   73,
   73,   33,   73,    4,   87,  102,   38,   65,  101,  160,
  104,   69,   39,  103,   73,   73,   88,   73,  104,  110,
    5,  111,   69,  112,   69,   69,   69,   78,   84,   99,
   72,   96,    2,    3,    4,    2,    3,   48,    5,    6,
   69,   69,   31,   69,  107,   35,  108,  126,   67,   36,
   67,   67,   67,  113,  137,  138,   40,  171,  114,  142,
   80,  111,   80,  112,  109,   80,   67,   67,  151,   67,
  111,  152,  112,  111,   68,  112,   68,   68,   68,  173,
   43,  111,  131,  112,  123,  129,  111,  166,  112,  169,
  165,  159,   68,   68,   44,   68,   78,  168,  159,   80,
   48,   48,   14,   94,   63,   95,   60,   66,  140,  141,
   16,   94,   68,   95,   98,   17,   18,  155,   80,   19,
  135,  136,   78,  100,  105,   86,   42,  150,  115,   20,
  156,  116,   80,   80,   80,   80,  117,  124,  118,   14,
   86,  127,   80,   80,  143,   15,  144,   16,  167,  145,
   14,  147,   17,   18,  170,   52,   19,  148,   16,  157,
  164,  172,   54,   17,   18,  174,   20,   19,    1,    2,
    3,    4,  175,   56,  176,    5,    6,   20,  179,   14,
   58,   14,   80,   16,  102,  153,   44,   16,   34,   16,
  177,   65,   17,   18,   17,   18,   19,   30,   19,  106,
   12,  121,   73,   83,   74,   75,   20,    0,   20,    2,
    3,   73,  158,  159,   66,   41,   31,   85,    0,   73,
    0,   63,   76,   77,   73,   73,    0,   73,   73,    0,
    0,   73,   73,   73,   73,   73,   73,   69,   73,    0,
    0,    0,    0,    0,    0,   69,   73,    0,   74,   75,
   69,   69,    0,   69,   69,    0,    0,   69,   69,   69,
   69,   69,   69,   67,   69,    0,   76,   77,    1,    1,
    4,   67,    0,    0,    1,    1,   67,   67,    0,   67,
   67,    0,    0,   67,   67,   67,   67,   67,   67,   68,
   67,    0,   32,   32,   29,    0,    0,   68,   32,   32,
    0,    0,   68,   68,    0,   68,   68,   89,    0,   68,
   68,   68,   68,   68,   68,   73,   68,   74,   75,  119,
  120,   90,   91,   92,   93,    0,    0,    0,    0,   90,
   91,   92,   93,   83,    0,   76,   77,   86,    0,    0,
    0,   73,    0,   74,   75,   86,    0,    0,    0,    0,
   86,   86,   14,   86,   86,    0,    0,    0,    0,   14,
   16,   76,   77,    0,   86,   17,   18,   16,    0,   19,
   14,    0,   17,   18,    2,    3,   19,   14,   16,   20,
    5,    6,    0,   17,   18,   16,   20,   19,   65,    0,
   17,   18,    0,    0,   19,    0,   65,   20,    0,    0,
   83,   65,   65,    0,   20,   65,    0,    0,   83,    0,
    0,   66,    0,   83,   83,   65,    0,   83,   63,   66,
    0,    0,    0,    0,   66,   66,   63,   83,   66,    0,
    0,   63,   63,    0,    0,   63,   47,    0,   66,   51,
   53,   55,   57,   59,   62,   63,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   62,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   62,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   40,   59,   59,   45,   59,   59,    6,   10,   44,   13,
   40,   22,   41,  100,   41,   59,   41,   42,   43,   44,
   45,    8,   47,  260,  256,  274,   13,   30,   63,   59,
  274,   35,  275,  282,   59,   60,  268,   62,  282,   78,
  264,   43,   41,   45,   43,   44,   45,   45,   41,   60,
   37,   44,  258,  259,  260,  258,  259,  262,  264,  265,
   59,   60,  265,   62,   68,   59,   70,  102,   41,   59,
   43,   44,   45,   42,  113,  114,   59,  164,   47,   41,
   39,   43,   41,   45,   71,   44,   59,   60,   41,   62,
   43,   41,   45,   43,   41,   45,   43,   44,   45,   41,
   40,   43,  106,   45,   97,  105,   43,  160,   45,  162,
  262,  263,   59,   60,   40,   62,   45,  262,  263,   78,
  261,  262,  256,   60,  272,   62,  260,  264,  121,  122,
  264,   60,   59,   62,   59,  269,  270,  148,   97,  273,
  111,  112,   45,  271,   40,   44,   40,  134,   41,  283,
  154,   41,  111,  112,  113,  114,   41,  262,   41,  256,
   59,  282,  121,  122,   59,  262,  264,  264,  161,   41,
  256,   59,  269,  270,  262,   59,  273,  260,  264,  261,
   58,  262,   59,  269,  270,  262,  283,  273,  257,  258,
  259,  260,   44,   59,   59,  264,  265,  283,   59,  256,
   59,  256,  161,  264,  272,  146,  260,  264,  260,  264,
  268,   59,  269,  270,  269,  270,  273,  260,  273,  282,
  264,   96,  264,   59,  266,  267,  283,   -1,  283,  258,
  259,  256,  262,  263,   59,  275,  265,  264,   -1,  264,
   -1,   59,  284,  285,  269,  270,   -1,  272,  273,   -1,
   -1,  276,  277,  278,  279,  280,  281,  256,  283,   -1,
   -1,   -1,   -1,   -1,   -1,  264,  264,   -1,  266,  267,
  269,  270,   -1,  272,  273,   -1,   -1,  276,  277,  278,
  279,  280,  281,  256,  283,   -1,  284,  285,  258,  259,
  260,  264,   -1,   -1,  264,  265,  269,  270,   -1,  272,
  273,   -1,   -1,  276,  277,  278,  279,  280,  281,  256,
  283,   -1,  258,  259,  260,   -1,   -1,  264,  264,  265,
   -1,   -1,  269,  270,   -1,  272,  273,  256,   -1,  276,
  277,  278,  279,  280,  281,  264,  283,  266,  267,  276,
  277,  278,  279,  280,  281,   -1,   -1,   -1,   -1,  278,
  279,  280,  281,  256,   -1,  284,  285,  256,   -1,   -1,
   -1,  264,   -1,  266,  267,  264,   -1,   -1,   -1,   -1,
  269,  270,  256,  272,  273,   -1,   -1,   -1,   -1,  256,
  264,  284,  285,   -1,  283,  269,  270,  264,   -1,  273,
  256,   -1,  269,  270,  258,  259,  273,  256,  264,  283,
  264,  265,   -1,  269,  270,  264,  283,  273,  256,   -1,
  269,  270,   -1,   -1,  273,   -1,  264,  283,   -1,   -1,
  256,  269,  270,   -1,  283,  273,   -1,   -1,  264,   -1,
   -1,  256,   -1,  269,  270,  283,   -1,  273,  256,  264,
   -1,   -1,   -1,   -1,  269,  270,  264,  283,  273,   -1,
   -1,  269,  270,   -1,   -1,  273,   20,   -1,  283,   23,
   24,   25,   26,   27,   28,  283,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   63,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  102,
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
"$$1 :",
"$$2 :",
"program : PROGRAM ID ';' $$1 declaracion $$2 cuerpo_programa",
"$$3 :",
"program : PROGRAM ID ';' $$3 cuerpo_programa",
"program : PROGRAM ';' declaracion cuerpo_programa",
"program : PROGRAM ';' cuerpo_programa",
"program : declaracion cuerpo_programa",
"program : cuerpo_programa",
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

//#line 183 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"

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
//#line 509 "Parser.java"
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
case 1:
//#line 17 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Ambito.agregarAmbito("main");}
break;
case 2:
//#line 17 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("-----------FinDeclaraciones-----------");}
break;
case 4:
//#line 18 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Ambito.agregarAmbito("main");}
break;
case 6:
//#line 19 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
break;
case 7:
//#line 20 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " program has no name");}
break;
case 8:
//#line 21 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got declaracion instead");}
break;
case 9:
//#line 22 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " PROGRAM expected but got cuerpo_programa instead");}
break;
case 19:
//#line 40 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 20:
//#line 41 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 21:
//#line 42 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 22:
//#line 43 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 23:
//#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_cond();}
break;
case 24:
//#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("Return");}
break;
case 25:
//#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_then();}
break;
case 26:
//#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(val_peek(4).sval).setTipo("cadena_caracteres"); TablaSimbolos.punteroTS(val_peek(4).sval).setUso("msj_postcondicion"); Polaca.insert("PRINT"); Polaca.insert(TablaSimbolos.punteroTS(val_peek(4).sval)); Polaca.insert("Quit"); Polaca.insert_sentencia_control_else();}
break;
case 27:
//#line 47 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " CADENA expected but got ; instead");}
break;
case 28:
//#line 50 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("FillReturnReg");}
break;
case 29:
//#line 53 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ Utils.setTipoIDFuncionCacheado(Integer.toString(val_peek(4).ival));}
break;
case 30:
//#line 54 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(val_peek(2).ival));}
break;
case 31:
//#line 55 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(val_peek(3).ival));}
break;
case 32:
//#line 56 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ Utils.setTipoIDFuncionCacheado(Integer.toString(val_peek(4).ival));}
break;
case 34:
//#line 57 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 35:
//#line 58 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 36:
//#line 61 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.cambiarNombre(val_peek(0).sval, val_peek(0).sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(val_peek(0).sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(val_peek(0).sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 37:
//#line 62 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ TablaSimbolos.cambiarNombre(val_peek(2).sval, val_peek(2).sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(val_peek(2).sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(val_peek(2).sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 38:
//#line 65 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.cambiarNombre(val_peek(0).sval, val_peek(0).sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(val_peek(0).sval + Ambito.retornarNaming()).setUso("nombre_funcion"); Utils.cachearIDFuncion(val_peek(0).sval + Ambito.retornarNaming()); Ambito.agregarAmbito(val_peek(0).sval); }
break;
case 41:
//#line 72 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(val_peek(0).sval).setTipo(Integer.toString(val_peek(1).ival)); TablaSimbolos.punteroTS(val_peek(0).sval).setUso("parametro"); TablaSimbolos.cambiarNombre(val_peek(0).sval, val_peek(0).sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setParametro(TablaSimbolos.punteroTS(val_peek(0).sval + Ambito.retornarNaming()));}
break;
case 42:
//#line 75 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setComienzoCodigoEjecutable(Polaca.posicionActual() + 1); }
break;
case 43:
//#line 75 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Ambito.borrarAmbito();}
break;
case 44:
//#line 76 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setComienzoCodigoEjecutable(Polaca.posicionActual()+1); }
break;
case 45:
//#line 76 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Ambito.borrarAmbito();}
break;
case 46:
//#line 77 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Cuerpo del procedimiento vacio.");}
break;
case 49:
//#line 84 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Invocacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 50:
//#line 85 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Asignacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 51:
//#line 86 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Iteracion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 52:
//#line 87 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Seleccion (IF) en la linea " + AnalizadorLexico.nroLinea);}
break;
case 53:
//#line 88 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Impresion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 55:
//#line 90 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 56:
//#line 91 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 57:
//#line 92 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 58:
//#line 93 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 59:
//#line 94 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 60:
//#line 95 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 61:
//#line 98 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if ((Ambito.bindAmbito(val_peek(2).sval) != null) && (TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(2).sval)).getParametro()) == null) {Polaca.insert("JumpTo: "); Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(2).sval)).getComienzoCodigoEjecutable());} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una funcion con esa signatura en el ambito actual");}
break;
case 62:
//#line 99 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if ((Ambito.bindAmbito(val_peek(3).sval) != null) && (TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(3).sval)).getParametro() != null) &&  Ambito.bindAmbito(val_peek(1).sval) != null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(1).sval))); Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(3).sval)).getParametro()); Polaca.insert(Parser.ASIG); Polaca.insert("JumpTo: "); Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(3).sval)).getComienzoCodigoEjecutable());} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una funcion con esa signatura en el ambito actual");}
break;
case 63:
//#line 102 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(val_peek(2).sval) != null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(2).sval)));} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una variable con ese nombre en el ambito actual"); Polaca.insert(new Integer(ASIG));}
break;
case 64:
//#line 103 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
break;
case 65:
//#line 104 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
break;
case 66:
//#line 105 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
break;
case 67:
//#line 108 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('+'));}
break;
case 68:
//#line 109 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('-'));}
break;
case 70:
//#line 113 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('*'));}
break;
case 71:
//#line 114 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('/'));}
break;
case 73:
//#line 118 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(val_peek(0).sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(0).sval))); else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una variable con ese nombre en el ambito actual");}
break;
case 74:
//#line 119 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(0).sval)); TablaSimbolos.punteroTS(val_peek(0).sval).setTipo(Integer.toString(Parser.CTE_UINT)); TablaSimbolos.punteroTS(val_peek(0).sval).setUso("cte");}
break;
case 75:
//#line 120 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(0).sval)); TablaSimbolos.punteroTS(val_peek(0).sval).setTipo(Integer.toString(Parser.CTE_DOUBLE)); TablaSimbolos.punteroTS(val_peek(0).sval).setUso("cte");}
break;
case 76:
//#line 121 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{  /*Sacamos lo ultimo que agregamos a la polaca, porque ya no es valido.
								                Determinamos que signo va a tener la cte.
								                Si es negativa, agregamos "-sval" a la TS.
								                Agregamos el string correcto (devuelto por utils.sig....) a la polaca.*/
                                                Polaca.insert(TablaSimbolos.punteroTS(Utils.signoNegativo(val_peek(0).sval)));
                                                }
break;
case 78:
//#line 128 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
break;
case 79:
//#line 129 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
break;
case 80:
//#line 132 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(1).sval)); Polaca.insert(new Integer(PRINT));}
break;
case 81:
//#line 133 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " invalid argument for PRINT");}
break;
case 82:
//#line 136 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_iteracion_end();}
break;
case 83:
//#line 137 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " UNTIL expected");}
break;
case 84:
//#line 143 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_iteracion_start();}
break;
case 85:
//#line 146 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(val_peek(2).ival));}
break;
case 86:
//#line 147 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta parentesis de cierre de la condicion.");}
break;
case 87:
//#line 148 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
break;
case 88:
//#line 149 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
break;
case 89:
//#line 150 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(val_peek(2).sval));}
break;
case 90:
//#line 151 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}
break;
case 99:
//#line 167 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 101:
//#line 171 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_cond();}
break;
case 102:
//#line 172 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en el encabezado de la condicion, falta la condicion del IF");}
break;
case 103:
//#line 175 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_then();}
break;
case 104:
//#line 176 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia THEN, falta el bloque de sentencias");}
break;
case 105:
//#line 179 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 106:
//#line 180 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia ELSE, falta el bloque de sentencias");}
break;
//#line 971 "Parser.java"
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
