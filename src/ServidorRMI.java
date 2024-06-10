import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {

    public static void main(String[] args) {
        try {
            // Iniciar el registro RMI en el puerto 1099
            LocateRegistry.createRegistry(1099);

            // Crear el objeto remoto
            ConversorRemotoImpl objetoRemoto = new ConversorRemotoImpl();

            // Registrar el objeto remoto usando Naming
            Naming.rebind("Conversor", objetoRemoto);

            System.out.println("Servidor RMI iniciado...");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
