import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el mensaje que quieres transmitir: ");
        String mensaje = scanner.nextLine();
        CodificadorMorse codificador = new CodificadorMorse();

        Emisor emisor = new Emisor(mensaje, codificador);
        Cable cable = new Cable(5, 1, 5);
        Repetidor repetidor = new Repetidor();
        Receptor receptor = new Receptor(codificador);
        Emisor emisor2 = new Emisor(mensaje, codificador);


        ArrayList<Componente> componentes = new ArrayList<>();
        componentes.add(emisor);
        componentes.add(cable);
        componentes.add(emisor2);

        componentes.add(repetidor);
        componentes.add(receptor);

        Telegrafo telegrafo = new Telegrafo(componentes);
        telegrafo.run();
    }
}
