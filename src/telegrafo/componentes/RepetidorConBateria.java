package telegrafo.componentes;

import telegrafo.Senyal;

public class RepetidorConBateria extends Repetidor {
    int vecesUsado;
    int maxUsos;

    public RepetidorConBateria(int maxUsos, boolean encendido) {
        super(encendido);
        this.vecesUsado = 0;
        this.maxUsos = maxUsos;
    }

    public void recargar() {
        vecesUsado = maxUsos;
    }

    public void incrementarVecesUsado() {
        vecesUsado++;
        if (vecesUsado > maxUsos) {
            vecesUsado = maxUsos;
        }
    }

    @Override
    public void transmitir(Senyal senyal) throws Exception {
        if (vecesUsado == maxUsos) {
            throw new Exception("Se ha agotado la batería del repetidor.");
        }
        incrementarVecesUsado();
        super.transmitir(senyal);
    }
}
