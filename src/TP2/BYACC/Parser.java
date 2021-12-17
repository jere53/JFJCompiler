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
    2,    4,    0,    5,    0,    0,    0,    0,    0,    0,
    3,    3,    7,    7,    9,    9,    9,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   14,   15,   16,
   12,   12,   11,    1,    1,    1,   22,    1,    1,    1,
   21,   21,   21,   18,   19,   19,   23,   24,   20,   25,
   20,   20,    6,    6,    8,    8,    8,    8,    8,    8,
    8,    8,    8,    8,    8,    8,   26,   26,   27,   27,
   27,   27,   17,   17,   17,   31,   31,   31,   32,   32,
   32,   32,   32,   32,   32,   30,   30,   28,   28,   33,
   13,   13,   13,   13,   13,   13,   34,   34,   34,   34,
   34,   34,   35,   35,   29,   29,   36,   36,   37,   37,
   38,   38,
};
final static short yylen[] = {                            2,
    0,    0,    7,    0,    5,    4,    3,    2,    1,    4,
    4,    3,    4,    1,    1,    1,    1,    5,    6,    4,
    5,    5,    6,    6,    7,    6,    7,    0,    0,    0,
    9,    5,    4,    6,    3,    4,    0,    8,    2,    3,
    1,    3,    2,    1,    3,    2,    2,    0,    3,    0,
    2,    0,    2,    1,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    2,    2,    3,    4,    3,    3,
    1,    3,    3,    3,    1,    3,    3,    1,    1,    1,
    1,    2,    1,    1,    1,    4,    4,    4,    2,    1,
    5,    4,    4,    4,    5,    3,    1,    1,    1,    1,
    1,    1,    1,    1,    3,    4,    2,    1,    2,    1,
    2,    1,
};
final static short yydefred[] = {                         0,
    0,   15,   16,    0,    0,    0,    0,    0,    9,    0,
    0,    0,    0,    0,    0,    0,    0,   90,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   43,
    0,   17,    0,    8,    0,    0,    0,    0,    7,    0,
   12,    0,    0,    0,    0,  107,   60,   66,    0,   53,
   55,   62,   56,   63,   57,   64,   58,   61,   59,   65,
    0,    0,   14,    0,    0,   42,   44,    0,    0,   40,
   10,    0,    0,    6,    0,   80,   81,   84,   85,    0,
    0,   83,    0,   78,   70,    0,    0,   67,    0,    0,
    0,   97,   98,  101,  102,   99,  100,    0,    0,   11,
    0,    0,  109,    0,  105,    0,    0,    0,   36,    2,
    5,   82,    0,    0,    0,    0,   68,   87,   86,   96,
  103,  104,    0,    0,    0,    0,   88,  111,  106,   46,
    0,    0,   48,    0,    0,    0,    0,    0,   76,   77,
   94,    0,    0,   93,   13,   47,   45,    0,    0,    0,
   51,    3,   91,   95,   49,    0,    0,   38,    0,   20,
    0,    0,    0,    0,    0,    0,   22,    0,    0,    0,
    0,   21,    0,   23,    0,   26,   24,    0,    0,   33,
   27,   25,    0,   32,   28,   29,   30,   31,
};
final static short yydgoto[] = {                          7,
    8,   72,    9,  136,   73,   21,   62,   22,   10,  151,
  164,  165,   46,  186,  187,  188,   81,   68,  108,  134,
   11,  156,  132,  148,  135,   23,   24,   25,   26,   27,
   83,   84,   28,   99,  124,   29,   65,  106,
};
final static short yysindex[] = {                      -102,
  -53,    0,    0, -134,  -42, -199,    0, -236,    0, -230,
  -31,  -15,   31, -218,    8,  -39,   30,    0,   37,  -56,
 -173,  -85,  -54,  117,  124,  135,  142,  -92, -179,    0,
 -230,    0, -154,    0,   59, -153, -119, -236,    0,    3,
    0,   98,  -26, -231,   72,    0,    0,    0,   86,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -85, -130,    0,  -92, -241,    0,    0,  110, -153,    0,
    0, -153, -236,    0,  111,    0,    0,    0,    0,    3,
   49,    0,   11,    0,    0,   49,  112,    0,  126,  128,
  129,    0,    0,    0,    0,    0,    0,   64,    3,    0,
  -97,   37,    0,  -92,    0, -109,  -28, -153,    0,    0,
    0,    0,    3,    3,    3,    3,    0,    0,    0,    0,
    0,    0,  -41,    3,   82,  116,    0,    0,    0,    0,
  -84,  141,    0,  127,  -73, -236,   11,   11,    0,    0,
    0,   88,   99,    0,    0,    0,    0,  -73,    0,  -85,
    0,    0,    0,    0,    0, -153,  -72,    0,  -29,    0,
  132, -178,    3, -162,  -70,   37,    0,  -66,  152,  203,
  -63,    0,  159,    0,  145,    0,    0,  211,  -47,    0,
    0,    0,  146,    0,    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    8,  -58,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  153,    0,    0,  -65,    0,
    0, -159,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -51,  219,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  165,    0, -219,    0,    0,    0,    0,  -32,    0,
    0,    0,    0,    0,  -24,    0,    0,    0,    0,    0,
  176,    0,    2,    0,    0,  183,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -62,    0,    0,    0,  -19,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   28,   54,    0,    0,
    0,  102,    0,    0,    0,    0,    0,    0,   56,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  163,
    0,    0,    0,    0,    0,    0,    0,  180,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   -4,    0,   18,    0,    0,  -12,  -50,   55,    1,  103,
    0,  -88,  -80,    0,    0,    0,   -3,    0,    0,    0,
   19,    0,    0,    0,    0,  374,    0,    0,    0,    0,
   34,  -64,    0,  149,    0,    0,    0,    0,
};
final static int YYTABLESIZE=537;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        141,
   43,   31,   47,   80,   51,   13,   33,   39,   38,   50,
  163,  184,  130,  103,   88,  112,   79,   79,   79,   79,
   79,  127,   79,    4,   89,   34,   35,   36,   35,  162,
   39,   70,  104,    5,   79,   79,   90,   79,   86,   52,
  105,   98,   75,   37,   75,   75,   75,   80,  101,   66,
  139,  140,  115,  128,  110,   74,   40,  116,    2,    3,
   75,   75,  110,   75,  109,   32,   41,  110,   73,   44,
   73,   73,   73,  168,   48,  171,   45,   52,   54,   56,
   58,   60,   63,  167,  161,  173,   73,   73,   49,   73,
  111,  113,   64,  114,   74,  125,   74,   74,   74,  170,
  161,   54,   54,  133,    2,    3,  113,  131,  114,   67,
    5,    6,   74,   74,   34,   74,   80,   69,   63,  142,
  143,   14,  144,   96,  113,   97,  114,   15,  153,   16,
  113,   96,  114,   97,   17,   18,   71,  157,   19,  154,
  102,  113,   80,  114,  100,   92,  137,  138,   20,  107,
   43,  158,  117,  152,    1,    2,    3,    4,   63,  169,
   92,    5,    6,   14,  126,  177,  118,   61,  119,  120,
   14,   16,  129,  182,  145,   53,   17,   18,   16,  146,
   19,  147,   55,   17,   18,  149,  150,   19,  159,  166,
   20,  172,  175,   57,  113,  174,  114,   20,  178,   14,
   59,   14,  179,  180,  185,   17,  108,   16,   39,   16,
   12,   71,   17,   18,   17,   18,   19,   30,   19,  112,
  183,   18,   75,   89,   76,   77,   20,   35,   20,    2,
    3,   79,  160,  161,   72,   42,   32,   87,   19,   79,
   50,   69,   78,   79,   79,   79,  123,   79,   79,    0,
  155,   79,   79,   79,   79,   79,   79,   75,   79,    0,
    0,    0,    0,    0,    0,   75,   75,    0,   76,   77,
   75,   75,    0,   75,   75,    0,    0,   75,   75,   75,
   75,   75,   75,   73,   75,    0,   78,   79,    2,    3,
    4,   73,    0,    0,    5,    6,   73,   73,    0,   73,
   73,    0,    0,   73,   73,   73,   73,   73,   73,   74,
   73,    0,    0,   37,   37,   34,    0,   74,    0,   37,
   37,    0,   74,   74,    0,   74,   74,   91,    0,   74,
   74,   74,   74,   74,   74,   75,   74,   76,   77,  121,
  122,   92,   93,   94,   95,    0,    0,    0,    0,   92,
   93,   94,   95,   85,    0,   78,   79,   92,    0,    0,
    0,   75,    0,   76,   77,   92,    0,    0,    0,    0,
   92,   92,   14,   92,   92,    0,    0,    0,    0,   14,
   16,   78,   79,    0,   92,   17,   18,   16,    0,   19,
   14,    0,   17,   18,    0,    0,   19,   14,   16,   20,
    0,    0,    0,   17,   18,   16,   20,   19,   71,    0,
   17,   18,    0,   82,   19,   82,   71,   20,   82,    0,
   89,   71,   71,    0,   20,   71,    0,    0,   89,    0,
    0,   72,    0,   89,   89,   71,    0,   89,   69,   72,
    0,    0,    0,    0,   72,   72,   69,   89,   72,    0,
    0,   69,   69,   82,    0,   69,    0,    0,   72,    0,
    2,    3,  176,    0,    0,   69,    5,    6,    2,    3,
  181,    0,   82,    0,    5,    6,    1,    1,    4,    0,
    0,    0,    1,    1,    0,    0,   82,   82,   82,   82,
    0,    0,    0,    0,    0,    0,   82,   82,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   82,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   40,   44,   59,   45,   59,   59,    6,   59,   13,   22,
   40,   59,   41,   64,   41,   80,   41,   42,   43,   44,
   45,  102,   47,  260,  256,    8,   59,   59,   10,   59,
   13,   36,  274,  264,   59,   60,  268,   62,   42,   59,
  282,   45,   41,   59,   43,   44,   45,   45,   61,   31,
  115,  116,   42,  104,  274,   38,  275,   47,  258,  259,
   59,   60,  282,   62,   69,  265,   59,   72,   41,   40,
   43,   44,   45,  162,   20,  164,   40,   23,   24,   25,
   26,   27,   28,  262,  263,  166,   59,   60,  262,   62,
   73,   43,  272,   45,   41,   99,   43,   44,   45,  262,
  263,  261,  262,  108,  258,  259,   43,  107,   45,  264,
  264,  265,   59,   60,   59,   62,   45,   59,   64,  123,
  124,  256,   41,   60,   43,   62,   45,  262,   41,  264,
   43,   60,   45,   62,  269,  270,  256,  150,  273,   41,
  271,   43,   45,   45,   59,   44,  113,  114,  283,   40,
   40,  156,   41,  136,  257,  258,  259,  260,  104,  163,
   59,  264,  265,  256,  262,  170,   41,  260,   41,   41,
  256,  264,  282,  178,   59,   59,  269,  270,  264,  264,
  273,   41,   59,  269,  270,   59,  260,  273,  261,   58,
  283,  262,   41,   59,   43,  262,   45,  283,  262,  256,
   59,  256,   44,   59,   59,  264,  272,  264,  260,  264,
  264,   59,  269,  270,  269,  270,  273,  260,  273,  282,
  268,   59,  264,   59,  266,  267,  283,  260,  283,  258,
  259,  256,  262,  263,   59,  275,  265,  264,   59,  264,
  260,   59,  284,  285,  269,  270,   98,  272,  273,   -1,
  148,  276,  277,  278,  279,  280,  281,  256,  283,   -1,
   -1,   -1,   -1,   -1,   -1,  264,  264,   -1,  266,  267,
  269,  270,   -1,  272,  273,   -1,   -1,  276,  277,  278,
  279,  280,  281,  256,  283,   -1,  284,  285,  258,  259,
  260,  264,   -1,   -1,  264,  265,  269,  270,   -1,  272,
  273,   -1,   -1,  276,  277,  278,  279,  280,  281,  256,
  283,   -1,   -1,  258,  259,  260,   -1,  264,   -1,  264,
  265,   -1,  269,  270,   -1,  272,  273,  256,   -1,  276,
  277,  278,  279,  280,  281,  264,  283,  266,  267,  276,
  277,  278,  279,  280,  281,   -1,   -1,   -1,   -1,  278,
  279,  280,  281,  256,   -1,  284,  285,  256,   -1,   -1,
   -1,  264,   -1,  266,  267,  264,   -1,   -1,   -1,   -1,
  269,  270,  256,  272,  273,   -1,   -1,   -1,   -1,  256,
  264,  284,  285,   -1,  283,  269,  270,  264,   -1,  273,
  256,   -1,  269,  270,   -1,   -1,  273,  256,  264,  283,
   -1,   -1,   -1,  269,  270,  264,  283,  273,  256,   -1,
  269,  270,   -1,   40,  273,   42,  264,  283,   45,   -1,
  256,  269,  270,   -1,  283,  273,   -1,   -1,  264,   -1,
   -1,  256,   -1,  269,  270,  283,   -1,  273,  256,  264,
   -1,   -1,   -1,   -1,  269,  270,  264,  283,  273,   -1,
   -1,  269,  270,   80,   -1,  273,   -1,   -1,  283,   -1,
  258,  259,  260,   -1,   -1,  283,  264,  265,  258,  259,
  260,   -1,   99,   -1,  264,  265,  258,  259,  260,   -1,
   -1,   -1,  264,  265,   -1,   -1,  113,  114,  115,  116,
   -1,   -1,   -1,   -1,   -1,   -1,  123,  124,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  163,
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

//#line 190 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"

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
//#line 517 "Parser.java"
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
case 10:
//#line 23 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 11:
//#line 26 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("END_PROGRAM");}
break;
case 12:
//#line 27 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("END_PROGRAM");}
break;
case 18:
//#line 39 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("RETURN");}
break;
case 19:
//#line 40 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("RETURN");}
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
//#line 44 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " return cannot be empty");}
break;
case 24:
//#line 45 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 25:
//#line 46 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 26:
//#line 47 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 27:
//#line 48 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 28:
//#line 51 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_cond();}
break;
case 29:
//#line 51 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{}
break;
case 30:
//#line 51 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_then();}
break;
case 31:
//#line 51 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(val_peek(4).sval).setTipo("cadena_caracteres"); TablaSimbolos.punteroTS(val_peek(4).sval).setUso("msj_postcondicion"); Polaca.insert("PRINT"); Polaca.insert(TablaSimbolos.punteroTS(val_peek(4).sval)); Polaca.insert("Quit"); Polaca.insert_sentencia_control_else();}
break;
case 32:
//#line 52 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " CADENA expected but got ; instead");}
break;
case 33:
//#line 55 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert("FillReturnReg");}
break;
case 34:
//#line 59 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ Utils.setTipoIDFuncionCacheado(Integer.toString(val_peek(4).ival));}
break;
case 35:
//#line 60 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(val_peek(2).ival));}
break;
case 36:
//#line 61 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Utils.asignarTipoListaDeVariables(Integer.toString(val_peek(3).ival));}
break;
case 37:
//#line 62 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ Utils.setTipoIDFuncionCacheado(Integer.toString(val_peek(4).ival));}
break;
case 39:
//#line 63 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 40:
//#line 64 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + (AnalizadorLexico.nroLinea - 1) + " missing variable type");}
break;
case 41:
//#line 67 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.cambiarNombre(val_peek(0).sval, val_peek(0).sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(val_peek(0).sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(val_peek(0).sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 42:
//#line 68 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{ TablaSimbolos.cambiarNombre(val_peek(2).sval, val_peek(2).sval + Ambito.retornarNaming()); Utils.agregarAListaDeVariables(val_peek(2).sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(val_peek(2).sval + Ambito.retornarNaming()).setUso("variable"); }
break;
case 43:
//#line 69 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected");}
break;
case 44:
//#line 72 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.cambiarNombre(val_peek(0).sval, val_peek(0).sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(val_peek(0).sval + Ambito.retornarNaming()).setUso("nombre_funcion"); Utils.cachearIDFuncion(val_peek(0).sval + Ambito.retornarNaming()); Ambito.agregarAmbito(val_peek(0).sval); }
break;
case 47:
//#line 79 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(val_peek(0).sval).setTipo(Integer.toString(val_peek(1).ival)); TablaSimbolos.punteroTS(val_peek(0).sval).setUso("parametro"); TablaSimbolos.cambiarNombre(val_peek(0).sval, val_peek(0).sval + Ambito.retornarNaming()); TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setParametro(TablaSimbolos.punteroTS(val_peek(0).sval + Ambito.retornarNaming()));}
break;
case 48:
//#line 82 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setComienzoCodigoEjecutable(Polaca.posicionActual() + 1); Polaca.insert("L"+ (Polaca.posicionActual() + 1));}
break;
case 49:
//#line 82 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Ambito.borrarAmbito();}
break;
case 50:
//#line 83 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{TablaSimbolos.punteroTS(Utils.idFuncCacheada()).setComienzoCodigoEjecutable(Polaca.posicionActual()+1); Polaca.insert("L"+ (Polaca.posicionActual() + 1));}
break;
case 51:
//#line 83 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Ambito.borrarAmbito();}
break;
case 52:
//#line 84 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Cuerpo del procedimiento vacio.");}
break;
case 55:
//#line 91 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Invocacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 56:
//#line 92 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Asignacion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 57:
//#line 93 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Iteracion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 58:
//#line 94 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Seleccion (IF) en la linea " + AnalizadorLexico.nroLinea);}
break;
case 59:
//#line 95 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{AnalizadorLexico.estructurasReconocidas.add("Impresion en la linea " + AnalizadorLexico.nroLinea);}
break;
case 61:
//#line 97 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 62:
//#line 98 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 63:
//#line 99 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 64:
//#line 100 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 65:
//#line 101 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 66:
//#line 102 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " ; expected but got: miembro_sentencia_ejec instead");}
break;
case 67:
//#line 105 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if ((Ambito.bindAmbito(val_peek(2).sval) != null) && (TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(2).sval)).getParametro()) == null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(2).sval)).getComienzoCodigoEjecutable()); Polaca.insert("CALL"); } else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una funcion con esa signatura en el ambito actual");}
break;
case 68:
//#line 106 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if ((Ambito.bindAmbito(val_peek(3).sval) != null) && (TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(3).sval)).getParametro() != null) && (Ambito.bindAmbito(val_peek(1).sval) != null)) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(1).sval))); Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(3).sval)).getParametro()); Polaca.insert(Parser.ASIG); Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(3).sval)).getComienzoCodigoEjecutable()); Polaca.insert("CALL");} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una funcion con esa signatura en el ambito actual");}
break;
case 69:
//#line 109 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(val_peek(2).sval) != null) {Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(2).sval)));} else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una variable con ese nombre en el ambito actual"); Polaca.insert(new Integer(ASIG));}
break;
case 70:
//#line 110 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado derecho de la asignacio no es valido.");}
break;
case 71:
//#line 111 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Un identificador en solitario no es una sentencia valida.");}
break;
case 72:
//#line 112 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " El lado izquierdo de la asignacion no es valido");}
break;
case 73:
//#line 115 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('+'));}
break;
case 74:
//#line 116 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('-'));}
break;
case 76:
//#line 120 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('*'));}
break;
case 77:
//#line 121 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer('/'));}
break;
case 79:
//#line 125 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{if (Ambito.bindAmbito(val_peek(0).sval) != null) Polaca.insert(TablaSimbolos.punteroTS(Ambito.bindAmbito(val_peek(0).sval))); else yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + ": No se encontro una variable con ese nombre en el ambito actual");}
break;
case 80:
//#line 126 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(0).sval)); TablaSimbolos.punteroTS(val_peek(0).sval).setTipo(Integer.toString(Parser.CTE_UINT)); TablaSimbolos.punteroTS(val_peek(0).sval).setUso("cte");}
break;
case 81:
//#line 127 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(0).sval)); TablaSimbolos.punteroTS(val_peek(0).sval).setTipo(Integer.toString(Parser.CTE_DOUBLE)); TablaSimbolos.punteroTS(val_peek(0).sval).setUso("cte");}
break;
case 82:
//#line 128 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{  /*Sacamos lo ultimo que agregamos a la polaca, porque ya no es valido.
								                Determinamos que signo va a tener la cte.
								                Si es negativa, agregamos "-sval" a la TS.
								                Agregamos el string correcto (devuelto por utils.sig....) a la polaca.*/
                                                Polaca.insert(TablaSimbolos.punteroTS(Utils.signoNegativo(val_peek(0).sval)));
                                                }
break;
case 84:
//#line 135 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Constante fuera de rango en la linea " + AnalizadorLexico.nroLinea);}
break;
case 85:
//#line 136 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error de formato en constante en la linea " + AnalizadorLexico.nroLinea);}
break;
case 86:
//#line 139 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(TablaSimbolos.punteroTS(val_peek(1).sval)); Polaca.insert(new Integer(PRINT));}
break;
case 87:
//#line 140 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " invalid argument for PRINT");}
break;
case 88:
//#line 143 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_iteracion_end();}
break;
case 89:
//#line 144 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " UNTIL expected");}
break;
case 90:
//#line 150 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_iteracion_start();}
break;
case 91:
//#line 153 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(val_peek(2).ival));}
break;
case 92:
//#line 154 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta parentesis de cierre de la condicion.");}
break;
case 93:
//#line 155 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado izquierdo de la condicion.");}
break;
case 94:
//#line 156 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Falta expresion en el lado derecho de la condicion.");}
break;
case 95:
//#line 157 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert(new Integer(val_peek(2).sval));}
break;
case 96:
//#line 158 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en la condicion.");}
break;
case 105:
//#line 174 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 107:
//#line 178 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_cond();}
break;
case 108:
//#line 179 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en el encabezado de la condicion, falta la condicion del IF");}
break;
case 109:
//#line 182 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_then();}
break;
case 110:
//#line 183 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia THEN, falta el bloque de sentencias");}
break;
case 111:
//#line 186 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{Polaca.insert_sentencia_control_else();}
break;
case 112:
//#line 187 "C:\Users\jerem\IdeaProjects\JFJCompiler\src\TP2\gramatica.y"
{yyerror("ERROR: LINE " + AnalizadorLexico.nroLinea + " Error en cuerpo de sentencia ELSE, falta el bloque de sentencias");}
break;
//#line 1019 "Parser.java"
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
