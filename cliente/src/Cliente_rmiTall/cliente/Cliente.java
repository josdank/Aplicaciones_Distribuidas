// Cliente.java
package Cliente_rmiTall.cliente;

import Cliente_rmiTall.interfaz.EmpleadoService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static EmpleadoService obtenerServicio() {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            return (EmpleadoService) registro.lookup("EmpleadoService");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
