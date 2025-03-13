package telegrafo.componentes;

import telegrafo.Componente;
import telegrafo.Senyal;

public class Repetidor extends Componente {
    private final Interruptor interruptor;

    public Repetidor(boolean encendido) {
        this.interruptor = new Interruptor(encendido);
    }

    public void amplify_signal(Senyal senyal) {
        senyal.restaurar();
    }

    @Override
    public void transmitir(Senyal senyal) throws Exception {
        interruptor.verificarEncendido();
        amplify_signal(senyal);
        System.out.println("LOG: modelo.Repetidor - señal: " + senyal.getPotenciaActual());
        super.transmitir(senyal);
    }
}
