package colecciondecartas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static Scanner scanner;

	public static void main(String[] args) {
        MapFactory mapFactory = new MapFactory();
        Map<String, String> cardCollection = mapFactory.getMap();

        try (BufferedReader br = new BufferedReader(new FileReader("cards_desc.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                cardCollection.put(parts[0].trim(), parts[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar una carta a la colección del usuario");
            System.out.println("2. Mostrar el tipo de una carta específica");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta en la colección del usuario");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta en la colección del usuario, ordenadas por tipo");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            int option = 0;
            try {
                option = Integer.parseInt(scanner.nextLine()); // Lee la opción ingresada por el usuario
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                continue;
            }
            
            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre de la carta que desea agregar: ");
                    String cardName = scanner.nextLine();
                    if (cardCollection.containsKey(cardName)) {
                        cardCollection.put(cardName, cardCollection.get(cardName));
                        System.out.println("Carta agregada correctamente a la colección.");
                    } else {
                        System.out.println("Error: La carta no se encuentra entre las disponibles.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la carta: ");
                    String card = scanner.nextLine();
                    if (cardCollection.containsKey(card)) {
                        System.out.println("Tipo de la carta: " + cardCollection.get(card));
                    } else {
                        System.out.println("La carta no se encuentra en la colección.");
                    }
                    break;
                case 3:
                    System.out.println("Cartas en la colección del usuario:");
                    for (Map.Entry<String, String> entry : cardCollection.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    break;
                case 4:
                    System.out.println("Cartas en la colección del usuario, ordenadas por tipo:");
                    TreeMap<String, String> sortedCollection = new TreeMap<>(cardCollection);
                    for (Map.Entry<String, String> entry : sortedCollection.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    break;
                case 5:
                    System.out.println("Todas las cartas existentes:");
                    for (Map.Entry<String, String> entry : cardCollection.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    break;
                case 6:
                    System.out.println("Todas las cartas existentes, ordenadas por tipo:");
                    TreeMap<String, String> sortedCards = new TreeMap<>(cardCollection);
                    for (Map.Entry<String, String> entry : sortedCards.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
