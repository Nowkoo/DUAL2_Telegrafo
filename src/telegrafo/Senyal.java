package telegrafo;

public class Senyal {
    private final double maximaPotencia = 10f;
    private double potenciaActual;
    private final String mensajeEnPulsos;

    public Senyal(String mensajeEnPulsos) {
        potenciaActual = maximaPotencia;
        this.mensajeEnPulsos = mensajeEnPulsos;
    }

    public void restaurar() {
        potenciaActual = maximaPotencia;
    }

    public void degradar(double degradacion) {
        potenciaActual -= degradacion;
        if (potenciaActual < 0) {
            potenciaActual = 0;
        }
    }

    public String getMensajeEnPulsos() {
        return mensajeEnPulsos;
    }

    public double getPotenciaActual() {
        return potenciaActual;
    }

    public double getMaximaPotencia() {
        return maximaPotencia;
    }
}
