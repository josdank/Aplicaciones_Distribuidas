package Servidor_rmiTall.servicio;

import Servidor_rmiTall.interfaz.EmpleadoService;
import Servidor_rmiTall.modelo.Empleado;
import Servidor_rmiTall.persistencia.ConexionBD;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.*;

public class EmpleadoServiceImpl extends UnicastRemoteObject implements EmpleadoService {
    public EmpleadoServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Empleado buscarEmpleadoPorId(int id) throws RemoteException {
        try (Connection conn = ConexionBD.conectar()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM empleados WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getString("cargo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}