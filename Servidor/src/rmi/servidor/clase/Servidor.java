package rmi.servidor.clase;
import java.rmi.Remote;

public interface Servidor extends Remote {
    //consultar id del empleado
    public String consultar(int id) throws Exception;

}
