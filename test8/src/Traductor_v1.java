import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Traductor_v1 {
    private static Map<String, String> englishToSpanish = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargarCorpus("english.txt", "spanish.txt");
    }

    public static void cargarCorpus(String archivoIngles, String archivoEspanol) {
        try {
            List<String> lineasIngles = Files.readAllLines(Path.of(archivoIngles));
            List<String> lineasEspanol = Files.readAllLines(Path.of(archivoEspanol));

            for (int i = 0; i < lineasIngles.size(); i++) {
                String frasesIngles = lineasIngles.get(i);
                String frasesEspanol = lineasEspanol.get(i);
                englishToSpanish.put(frasesIngles, frasesEspanol);
            }
        } catch (Exception e) {
            System.out.println("Error al leer ficheros: " + e.getMessage());
        }
    }

    private static void menu() {
        while(true) {
            System.out.println("1. Traducir");
            System.out.println("0. Salir");

            int opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    traducir();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}