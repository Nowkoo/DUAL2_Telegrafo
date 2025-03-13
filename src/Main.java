import telegrafo.componentes.*;
import telegrafo.CodificadorMorse;
import telegrafo.Componente;
import telegrafo.Telegrafo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el mensaje que quieres transmitir: ");
        String mensaje = scanner.nextLine();
        CodificadorMorse codificador = new CodificadorMorse();

        ArrayList<Componente> componentes = getComponentes(mensaje, codificador);
        Telegrafo telegrafo = new Telegrafo(componentes);

        try {
            telegrafo.run();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static ArrayList<Componente> getComponentes(String mensaje, CodificadorMorse codificador) {
        Emisor emisor = new Emisor(mensaje, codificador, true);
        Cable cable = new Cable(5, 10, 5, 0.05);
        Repetidor repetidor = new Repetidor(true);
        Repetidor repetidorConBateria = new RepetidorConBateria(3, true);
        Receptor receptor = new Receptor(codificador);
//        Emisor emisor2 = new Emisor(mensaje, codificador, true);


        ArrayList<Componente> componentes = new ArrayList<>();
        componentes.add(emisor);
        componentes.add(cable);
//        componentes.add(emisor2);
        componentes.add(repetidor);
        componentes.add(repetidorConBateria);
        componentes.add(receptor);
        return componentes;
    }
}
