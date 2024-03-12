import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Utilizando Factory Design Pattern para seleccionar la implementación de Map
        private static Scanner scanner;

        public static void main(String[] args) {
            MapFactory mapFactory = new MapFactory();
            Scanner scanner = new Scanner(System.in);
            Map<String, String> cardCollection = mapFactory.getMap(); // Usar la implementación seleccionada

            // Leer el archivo de cartas
            Map<String, String> cardCollection = mapFactory.getMap();

            try (BufferedReader br = new BufferedReader(new FileReader("cards_desc.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    @@ -21,8 +20,9 @@ public static void main(String[] args) {
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Menú de opciones

                    scanner = new Scanner(System.in);

                    while (true) {
                        System.out.println("\nMenú:");
                        System.out.println("1. Agregar una carta a la colección del usuario");
                        @@ -33,15 +33,20 @@ public static void main(String[] args) {
                            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo");
                            System.out.println("0. Salir");
                            System.out.print("Seleccione una opción: ");
                            int option = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer

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
                                        // Agregar carta a la colección del usuario
                                        cardCollection.put(cardName, cardCollection.get(cardName));
                                        System.out.println("Carta agregada correctamente a la colección.");
                                    } else {
                                        @@ -92,4 +97,4 @@ public static void main(String[] args) {
                                        }
                                    }
                            }
                        }
                    }