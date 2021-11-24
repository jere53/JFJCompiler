package Dev;

import Dev.Lexico.TablaSimbolos;

public class RegistroTS {
    private String lexema;
    private String tipo;
    private String uso;

    public String getTipo() {
        return tipo;
    }

    public String getUso() {
        return uso;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public RegistroTS(String l) {
        setLexema(l);
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }


    @Override
    public String toString() {
        return "RegistroTS{" +
                "lexema='" + lexema + '\'' +
                "tipo='" + tipo + '\'' +
                "uso='" + uso + '\'' +
                '}';
    }
}