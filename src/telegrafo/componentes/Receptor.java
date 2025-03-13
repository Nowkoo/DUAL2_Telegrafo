package telegrafo.componentes;

import telegrafo.CodificadorMorse;
import telegrafo.Componente;
import telegrafo.Senyal;

public class Receptor extends Componente {
    private String mensajeRecibido;
    private final CodificadorMorse codificador;

    public Receptor(CodificadorMorse codificador) {
        mensajeRecibido = "";
        this.codificador = codificador;
    }

    public void receiveSignal(Senyal senyal) {
        String mensajeEnPulsos = senyal.getMensajeEnPulsos();
        mensajeRecibido = codificador.decodificar(mensajeEnPulsos);
        display_message();
    }

    public void display_message() {
        System.out.println(mensajeRecibido);
    }

    @Override
    public void transmitir(Senyal senyal) {
        System.out.println("LOG: modelo.Receptor - señal: " + senyal.getPotenciaActual());
        receiveSignal(senyal);
    }
}