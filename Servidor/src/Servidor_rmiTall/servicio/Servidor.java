package Servidor_rmiTall.servicio;

import Servidor_rmiTall.interfaz.EmpleadoService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(1099);
            EmpleadoService servicio = new EmpleadoServiceImpl();
            registro.rebind("EmpleadoService", servicio);
            System.out.println("Servidor RMI listo...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
