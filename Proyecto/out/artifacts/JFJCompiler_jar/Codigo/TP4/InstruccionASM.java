package TP4;

public class InstruccionASM {
    public String tipoInstruccion;
    public String primerOperando;
    public String segundoOperando;

    public InstruccionASM(String tipoInstruccion, String primerOperando, String segundoOperando) {
        this.tipoInstruccion = tipoInstruccion;
        this.primerOperando = primerOperando;
        this.segundoOperando = segundoOperando;
    }

    @Override
    public String toString() {
        return tipoInstruccion + ", " + primerOperando + ' ' + segundoOperando;
    }
}
