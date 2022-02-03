set projectName=salidaASM
\masm32\bin\ml /c /coff %projectName%.asm
\masm32\bin\link /subsystem:windows %projectName%.obj
%projectName%.exe