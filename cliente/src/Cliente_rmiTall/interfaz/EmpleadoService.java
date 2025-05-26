package Cliente_rmiTall.interfaz;

import Cliente_rmiTall.modelo.Empleado;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmpleadoService extends Remote {
    Empleado buscarEmpleadoPorId(int id) throws RemoteException;
}
