import java.util.ArrayList;

public class Telegrafo {
    private ArrayList<Componente> componentes;

    public Telegrafo(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    public void run() {
        conectarComponentes();

        try {
            Emisor emisor = (Emisor) componentes.getFirst();
            emisor.send_signal();
        } catch (Exception e) {
            System.out.println("Se necesita un emisor de primer componente");
        }
    }

    public void conectarComponentes() {
        for (int i = 0; i < componentes.size(); i++) {
            if (i + 1 < componentes.size()) {
                Componente componenteSiguiente = componentes.get(i + 1);
                componentes.get(i).conectar(componenteSiguiente);
            }
        }
    }
}