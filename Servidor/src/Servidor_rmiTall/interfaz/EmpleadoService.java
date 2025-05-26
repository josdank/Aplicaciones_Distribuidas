package Servidor_rmiTall.interfaz;

import Servidor_rmiTall.modelo.Empleado;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmpleadoService extends Remote {
    Empleado buscarEmpleadoPorId(int id) throws RemoteException;
}