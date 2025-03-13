package telegrafo.componentes;

import telegrafo.Componente;
import telegrafo.Senyal;

public class Cable extends Componente {
    private final double longitudKm;
    private final double porcentajePerdidaSenyal;
    private final double umbralPerdidaSenyal;
    private final double probabilidadPerdidaSenyal;

    public Cable(double longitudKm, double porcentajePerdidaSenyal, double umbralPerdidaSenyal, double probabilidadPerdidaSenyal) {
        this.longitudKm = longitudKm;
        this.porcentajePerdidaSenyal = porcentajePerdidaSenyal;
        this.umbralPerdidaSenyal = umbralPerdidaSenyal;
        this.probabilidadPerdidaSenyal = probabilidadPerdidaSenyal;
    }

    public void calcularPerdidaDeSenyalAleatoria(Senyal senyal) throws Exception {
        if (Math.random() < probabilidadPerdidaSenyal
                && senyal.getPotenciaActual() < this.umbralPerdidaSenyal) {
            throw new Exception("Pérdida de señal aleatoria");
        }
    }

    public void aplicarDegradacionSenyal(Senyal senyal) throws Exception {
        double degradacionPorKm = (senyal.getMaximaPotencia() * porcentajePerdidaSenyal) / 100;
        double degradacionTotal = degradacionPorKm * longitudKm;
        senyal.degradar(degradacionTotal);

        if (senyal.getPotenciaActual() < this.umbralPerdidaSenyal) {
            throw new Exception("Perdida de señal por degradación");
        }
    }

    @Override
    public void transmitir(Senyal senyal) throws Exception {
        calcularPerdidaDeSenyalAleatoria(senyal);
        aplicarDegradacionSenyal(senyal);

        System.out.println("LOG: Cable - señal: " + senyal.getPotenciaActual());
        super.transmitir(senyal);
    }
}