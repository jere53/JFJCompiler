package Dev;

public class RegistroTS {
    private String lexema;
    private String tipo;
    private String uso;
    private int comienzoCodigoEjecutable;
    private int finCodigoEjecutable;
    private RegistroTS parametro;
    private boolean esNombre;

    public boolean esNombre() {
        return esNombre;
    }

    public void setEsNombre(boolean esNombre) {
        this.esNombre = esNombre;
    }

    public int getFinCodigoEjecutable() {
        return finCodigoEjecutable;
    }

    public void setFinCodigoEjecutable(int finCodigoEjecutable) {
        this.finCodigoEjecutable = finCodigoEjecutable;
    }

    public RegistroTS getParametro() {
        return parametro;
    }

    public void setParametro(RegistroTS parametro) {
        this.parametro = parametro;
    }

    public int getComienzoCodigoEjecutable() {
        return comienzoCodigoEjecutable;
    }

    public void setComienzoCodigoEjecutable(int comienzoCodigoEjecutable) {
        this.comienzoCodigoEjecutable = comienzoCodigoEjecutable;
    }

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
        String res = "RegistroTS{" +
                "lexema='" + lexema + '\'' +
                "tipo='" + tipo + '\'' +
                "uso='" + uso + '\'';
        if (uso == "nombre_funcion"){
            res += "comienzoCodigoEjecutable='" + comienzoCodigoEjecutable + '\'';
        }
        if (parametro != null){
            res += "paramtero='" + parametro.toString() + '\'';
        }
        res += '}';
        return res;
    }
}