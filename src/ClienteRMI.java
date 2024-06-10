import java.rmi.Naming;
import java.util.Scanner;

public class ClienteRMI {

    public static void main(String[] args) {
        try {
            // Obtener la referencia del objeto remoto desde el registro RMI
            ConversorRemoto servicio = (ConversorRemoto) Naming.lookup("rmi://localhost/Conversor");

            Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            do {
                System.out.println("Elija una opción:");
                System.out.println("1. Fahrenheit a Celsius");
                System.out.println("2. Celsius a Fahrenheit");
                System.out.println("3. Salir");

                opcion = scanner.nextInt();

                if (opcion == 1 || opcion == 2) {
                    System.out.print("Ingrese la temperatura: ");
                    double temperatura = scanner.nextDouble();

                    if (opcion == 1) {
                        double resultado = servicio.fahrenheitToCelsius(temperatura);
                        System.out.println("Resultado: " + resultado + " grados Celsius");
                    } else if (opcion == 2) {
                        double resultado = servicio.celsiusToFahrenheit(temperatura);
                        System.out.println("Resultado: " + resultado + " grados Fahrenheit");
                    }
                }
            } while (opcion != 3);

            System.out.println("Cliente finalizado.");
            scanner.close();

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
