; =======================================
; LITTLE WIN-CGI EXAMPLE by mob aka drcmda
; read the attached win-cgi ref for questions
; i use OmniHTTPd as webserver... download
; it from www.omnicron.ce (i think).
; oh and don't forget to put this executable
; in the win-cgi order... you can reach it
; from your explorer under:
; localhost/win-cgi/test.exe?win32asm=great
; write to drcmda@gmx.de 
; =======================================

.386
.model          flat,stdcall
option          casemap:none

include         \masm32\include\windows.inc
include         \masm32\include\user32.inc
include         \masm32\include\kernel32.inc
includelib      \masm32\lib\user32.lib
includelib      \masm32\lib\kernel32.lib

.DATA

template        db "Content-type: text/html",13,10
                db 13,10,"<html>"
                db 13,10,"<head></head>"
                db 13,10,"<body bgcolor=silver><h1>"
                db 13,10,"hi, this is just a test<br><br><h2>"
                db 13,10,"this text is generated by -asm cgi- "
                db 13,10,"executable...<br><br>"
                db 13,10,"Querry-String: %s"
                db 13,10,"</body> "
                db 13,10,"</html>",0
                                        
templen         db offset templen - offset template

.DATA?

output          dd ?
commandline     dd ?
commandlen      dd ?
filehandle      dd ?
modulename      db 256 dup (?)
pointer         dd 15  dup (?)
buffer          db 500 dup (?)

.CODE

start:          invoke GetCommandLine                   ; get command line (see win-cgi ref!!!!)
                mov commandline,eax
                
                invoke lstrlen,eax
                add eax,commandline
                mov commandlen,eax
                
                invoke GetModuleFileName,NULL,addr modulename,256 
                add eax,2                               ; get full modulefilename and cut it
                add commandline,eax                     ; from the commandline
                mov edi,commandline

                xor ebx,ebx                             ; all commandline parameters are now
                mov eax,offset pointer                  ; stored in a array (pointer is the name)
main_loop:      cmp edi,commandlen                      ; so you can reach a param entry with:
                jge finish                              ; [offset pointer + index * 4]
                inc edi                                 ; EBX should contain the paramcount                
                                                        ; ... i hope ;)                
                mov esi,edi
                inc ebx
bla_loop:       inc esi
                cmp byte ptr [esi],0
                jnz morethanone

                mov [eax],edi

                jmp finish              
morethanone:            
                cmp byte ptr [esi]," "          
                jnz bla_loop
                mov byte ptr [esi],0
                        
                mov [eax],edi
                add eax,4
                mov edi,esi                     
                jmp main_loop           
finish:                                                                 
                                
                invoke _lopen,[eax-4],OF_WRITE          ; [lastvalue-4] should contain the output
                mov filehandle,eax                      ; file... see reference!
                                
                mov eax,offset pointer                  ; should contain the querystring-file (param 4)
                mov eax,[eax + 12]
                invoke wsprintf,addr buffer,addr template,eax                               
                invoke _lwrite,filehandle,addr buffer,eax
                
                invoke _lclose,filehandle
        
exit:           
                invoke ExitProcess,NULL

END             start


