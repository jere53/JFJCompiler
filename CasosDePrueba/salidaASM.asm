.386 
.model flat, stdcall 

.stack 200h
option casemap :none 
include \masm32\include\windows.inc
include \masm32\include\kernel32.inc
include \masm32\include\user32.inc
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\user32.lib
.DATA
_funcionActual DW ? 
 _funcionAInvocar DW ? 
 _funcionAnterior DW ? 
_xmainf DQ ?
_Errorenlapostcondicion DB "Error en la postcondicion", 0
@auxL1 DW ?
_Funcionfinvocada DB "Funcion f invocada", 0
var0 DW 0
var1 DW 1
var3 DW 3
_Kmainfj DW ?
@auxL9 DQ ?
var25182E200 DQ 25.182E+200
_ymainf DQ ?
@aux2 DW ?
var20 DW 20
@aux1 DQ ?
_amainf DQ ?
@aux0 DQ ?
_ErrDivZero DB  "Division por 0", 0
_ErrOFSuma DB "Overflow en suma de enteros", 0 
_ErrIncompTipos DB "No se puede realizar la conversion de tipos", 0 
_ErrRecursionMutua DB  "Recursion Mutua detectada", 0 

.CODE

DivZero: 
invoke MessageBox, NULL, addr _ErrDivZero, addr _ErrDivZero, MB_OK 
invoke ExitProcess, 0 
OFSuma: 
invoke MessageBox, NULL, addr _ErrOFSuma, addr _ErrOFSuma, MB_OK 
invoke ExitProcess, 0 
IncompTipos: 
invoke MessageBox, NULL, addr _ErrIncompTipos, addr _ErrIncompTipos, MB_OK 
invoke ExitProcess, 0 
ErrInvocacionMutua: 
invoke MessageBox, NULL, addr _ErrRecursionMutua, addr _ErrRecursionMutua, MB_OK 
invoke ExitProcess, 0 
L1:
MOV _funcionActual, 1

MOV AX, var1
MOV _Kmainfj, AX
MOV AX, _Kmainfj
MOV @auxL1, AX
MOV _funcionActual, 0 
RET
L9:
MOV _funcionActual, 9

FLD var25182E200
FSTP _xmainf
invoke MessageBox, NULL, addr _Funcionfinvocada,addr _Funcionfinvocada, MB_OK

FILD var0
FLD _xmainf
FMUL
FSTP @aux0

FLD @aux0
FSTP _ymainf

FLD _xmainf
FLD _ymainf
FADD
FSTP @aux1
FLD @aux1
FSTP @auxL9

FILD var3
FLD _ymainf
MOV @aux2, 1
FCOMP
FSTSW AX
SAHF 
JC L@aux2
MOV @aux2, 0
L@aux2:
CMP @aux2, 0
JZ L31
JMP L35
L31:
invoke MessageBox, NULL, addr _Errorenlapostcondicion,addr _Errorenlapostcondicion, MB_OK
invoke ExitProcess, 0
L35:
MOV _funcionActual, 0 
RET
START: 

FILD var20
FSTP _amainf
MOV _funcionAInvocar, 9
MOV AX, _funcionAnterior
CMP AX, _funcionAInvocar
JZ ErrInvocacionMutua
MOV AX, _funcionActual
MOV _funcionAnterior, AX
CALL L9
END START
