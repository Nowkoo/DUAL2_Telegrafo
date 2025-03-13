package telegrafo;

import telegrafo.componentes.Emisor;

import java.util.ArrayList;

public class Telegrafo {
    private final ArrayList<Componente> componentes;

    public Telegrafo(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    public void run() throws Exception {
        conectarComponentes();

        Emisor emisor;
        try {
            emisor = (Emisor) componentes.getFirst();
        } catch (Exception e) {
            throw new Exception("Se necesita un emisor de primer componente");
        }

        if (emisor != null) {
            emisor.sendSignal();
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