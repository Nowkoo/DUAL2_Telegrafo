package telegrafo.componentes;

public class Interruptor {
    private boolean encendido;

    public Interruptor(boolean encendido) {
        this.encendido = encendido;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public void verificarEncendido() throws Exception {
        if (!encendido) {
            throw new Exception("Apagado");
        }
    }
}
