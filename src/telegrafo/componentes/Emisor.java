package telegrafo.componentes;

import telegrafo.CodificadorMorse;
import telegrafo.Componente;
import telegrafo.Senyal;

public class Emisor extends Componente {
    private final Interruptor interruptor;
    private final String mensaje;
    private final CodificadorMorse codificador;

    public Emisor(String mensaje, CodificadorMorse codificador, boolean encendido) {
        this.mensaje = mensaje;
        this.codificador = codificador;
        this.interruptor = new Interruptor(encendido);
    }

    public void sendSignal() throws Exception {
        interruptor.verificarEncendido();
        String mensajeCodificado = codificador.codificar(mensaje);
        Senyal senyal = new Senyal(mensajeCodificado);
        super.getComponenteSiguiente().transmitir(senyal);
    }

    @Override
    public void transmitir(Senyal senyal) throws Exception {
        throw new Exception("El emisor no puede transmitir la señal");
    }
}