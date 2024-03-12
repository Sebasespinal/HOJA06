package colecciondecartas;

import java.util.*;

class MapFactory {
    private Scanner scanner;

	public Map<String, String> getMap() {
        scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de Map que desea utilizar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Ingrese el número correspondiente a la implementación deseada: ");
        
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine()); // Lee la opción ingresada por el usuario
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número válido.");
        }
        
        switch (choice) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                System.out.println("Opción inválida. Seleccionando HashMap por defecto.");
                return new HashMap<>();
        }
    }
}
