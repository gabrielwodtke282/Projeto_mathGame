package entities;

public class Contador {
    Long tempoInicial = null;
    Long tempoFinal = null;

    public void iniciarTimer(){
        tempoInicial = System.currentTimeMillis();
    }

    public long finalizarTimer(){
        tempoFinal = System.currentTimeMillis();
        return tempoFinal - tempoInicial;
    }
}
