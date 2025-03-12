public class Receptor extends Componente {
    private String mensajeRecibido;
    private CodificadorMorse codificador;

    public Receptor(CodificadorMorse codificador) {
        mensajeRecibido = "";
        this.codificador = codificador;
    }

    public void receive_signal(Senyal senyal) {
        String mensajeEnPulsos = senyal.getMensajeEnPulsos();
        mensajeRecibido = codificador.decodificar(mensajeEnPulsos);
        display_message();
    }

    public void display_message() {
        System.out.println(mensajeRecibido);
    }

    @Override
    public void transmitir(Senyal senyal) {
        System.out.println("LOG: Receptor - señal: " + senyal.getPotenciaActual());
        receive_signal(senyal);
    }
}