public class Cable extends Componente {
    private double longitudKm;
    private double perdidaSenyalPorKm;
    private double umbralPerdidaSenyal;

    public Cable(double longitudKm, double perdidaSenyalPorKm, double umbralPerdidaSenyal) {
        this.longitudKm = longitudKm;
        this.perdidaSenyalPorKm = perdidaSenyalPorKm;
        this.umbralPerdidaSenyal = umbralPerdidaSenyal;
    }

    public double calcularDegradacion() {
        return this.longitudKm * this.perdidaSenyalPorKm;
    }

    @Override
    public void transmitir(Senyal senyal) throws Exception {
        senyal.degradar(calcularDegradacion());
        if (senyal.getPotenciaActual() < this.umbralPerdidaSenyal) {
            throw new Exception("Señal perdida");
        }
        System.out.println("LOG: Cable - señal: " + senyal.getPotenciaActual());
        super.transmitir(senyal);
    }
}