public class Emisor extends Componente {
    private Estado estado;
    private String mensaje;
    private CodificadorMorse codificador;

    public Emisor(String mensaje, CodificadorMorse codificador) {
        this.estado = Estado.ENCENDIDO;
        this.mensaje = mensaje;
        this.codificador = codificador;
    }

    public void send_signal() throws Exception {
        String mensajeCodificado = codificador.codificar(mensaje);
        Senyal senyal = new Senyal(mensajeCodificado);
        transmitir(senyal);
    }

    public void apagar() {
        this.estado = Estado.APAGADO;
    }

    public void encender() {
        this.estado = Estado.ENCENDIDO;
    }

    @Override
    public void transmitir(Senyal senyal) throws Exception {
        System.out.println("LOG: Emisor - señal: " + senyal.getPotenciaActual());
        super.transmitir(senyal);
    }
}