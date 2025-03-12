public class Repetidor extends Componente {
    private Estado estado;

    public Repetidor() {
         this.estado = Estado.ENCENDIDO;
    }

    public void amplify_signal(Senyal senyal) {
        senyal.restaurar();
    }

    @Override
    public void transmitir(Senyal senyal) throws Exception {
        amplify_signal(senyal);
        System.out.println("LOG: Repetidor - señal: " + senyal.getPotenciaActual());
        super.transmitir(senyal);
    }
}
