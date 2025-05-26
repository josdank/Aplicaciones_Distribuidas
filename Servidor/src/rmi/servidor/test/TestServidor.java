package rmi.servidor.test;
import rmi.servidor.clase.ServidorImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class TestServidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            ServidorImpl servidor = new ServidorImpl();
            String rmiObjectName = "rmi://localhost/Servidor";
            Naming.rebind(rmiObjectName, servidor);
            System.out.println("Servidor Remoto Corriendo");

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    Naming.unbind(rmiObjectName);
                    System.out.println("Servidor detenido correctamente");
                } catch (Exception e) {
                    System.err.println("Error al detener el servidor: " + e.getMessage());
                }
            }));
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

