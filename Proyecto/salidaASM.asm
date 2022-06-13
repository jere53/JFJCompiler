.386 
.model flat, stdcall 

.stack 200h
option casemap :none 
include \masm32\include\windows.inc 
include \masm32\include\kernel32.inc 
include \masm32\include\masm32.inc 
includelib \masm32\lib\kernel32.lib 
includelib \masm32\lib\masm32.lib 
.data
@aux7 DW ?
@aux6 DW ?
@aux5 DW ?
@aux4 DW ?
_Errorenlapostcondicion DB "Error en la postcondicion", 0
_amain DQ ?
_ymainf DQ ?
@aux3 DW ?
@aux2 DQ ?
@aux1 DQ ?
@aux0 DQ ?
_xmainf DQ ?
_HolaMundo DB "HolaMundo", 0
@auxL1 DW ?
var1 DW 1
var2 DW 2
var3 DW 3
_Kmainfj DW ?
@auxL9 DW ?
var25182E200 DQ 25.182E+200
var20 DW 20
_amainf DQ ?

.CODE
START: 
L1:

MOV AX, var1
MOV _Kmainfj, AX
MOV @auxL1, Kmainfj
RET
L9:

FLD var25182E200
FSTP _xmainf

FILD var3
FLD _xmainf
FMUL
FSTP @aux0

FLD @aux0
FSTP _ymainf

FILD var3
FLD _xmainf
FMUL
FSTP @aux1

FLD @aux1
FLD _ymainf
FADD
FSTP @aux2
MOV @auxL9, @aux2

FILD var3
FLD _ymainf
MOV @aux3, 1
FCOMP
SAHF 
JC L@aux3
MOV @aux3, 0
L@aux3:
CMP @aux3, 0
JZ L31
JMP L35
L31:
invoke StdOut, addr _Errorenlapostcondicion
invoke ExitProcess, 0
L35:
RET

MOV AX, var2
ADD AX, var1
JC OFSuma
MOV @aux4, AX

MOV AX, var3
ADD AX, @aux4
JC OFSuma
MOV @aux5, AX

FLD _amain
FSTP _amainf
CALL L9

MOV AX, @auxL9
ADD AX, @aux5
JC OFSuma
MOV @aux6, AX

FILD @aux6
FSTP _amain
L53:

FILD var1
FSTP _amain

FILD var20
FLD _amain
MOV @aux7, 1
FCOMP
SAHF 
JC L@aux7
MOV @aux7, 0
L@aux7:
CMP @aux7, 0
JZ L53
END START

DivZero: 
invoke StdOut, "Error: division por 0"
invoke ExitProcess, 0 
OFSuma: 
invoke StdOut, "Error: Overflow en suma de enteros"
invoke ExitProcess, 0 
IncompTipos: 
invoke StdOut, "Error: Overflow en suma de enteros"
invoke ExitProcess, 0 
