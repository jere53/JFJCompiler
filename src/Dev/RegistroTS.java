package Dev;

public class RegistroTS {
    private String lexema;
    private String tipo;
    private String ambito;
    private String uso;

    public String getTipo() {
        return tipo;
    }

    public String getAmbito() {
        return ambito;
    }

    public String getUso() {
        return uso;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
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
                "ambito='" + ambito + '\'' +
                "uso='" + uso + '\'' +
                '}';
    }
}