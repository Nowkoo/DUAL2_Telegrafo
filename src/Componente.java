public abstract class Componente {
    private Componente componenteSiguiente;

    public void transmitir(Senyal senyal) throws Exception {
        if (componenteSiguiente == null) {
            System.out.println("No hay componente al que transmitir la señal");
        } else {
            try {
                componenteSiguiente.transmitir(senyal);
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    public void conectar(Componente componente) {
        componenteSiguiente = componente;
    }
}