package rmi.servidor.clase;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ServidorImpl extends UnicastRemoteObject implements Servidor{
    private static ArrayList<Persona> listPersonas(){
        ArrayList<Persona> lista = new ArrayList<Persona>();
            lista.add(new Persona(1, "Josué Guerra", "jg@epmpresa", "Adminstrador", 2500.00));
            lista.add(new Persona(2, "Luis Ramos", "lr@epmpresa", "Administrador", 2500.00));
            lista.add(new Persona(3, "Carlos Perez", "cp@epmpresa", "Administrador", 2500.00));
            lista.add(new Persona(4, "Ana Ocampo", "ac@epmpresa", "Encargada de TI", 1500.00));
            lista.add(new Persona(5, "Richard Soria", "rs@epmpresa", "Encargado", 1500.00));
            lista.add(new Persona(6, "Cristhian Herrera", "ch@epmpresa", "operador", 1000.00));
            lista.add(new Persona(7, "Fernando Lovato", "fl@epmpresa", "Director Administrativo", 2000.00));
            lista.add(new Persona(8, "Belgica Lovato", "bl@epmpresa", "Jefa de Producción", 3000.00));

        return lista;
    };

    private static String getPersonas(int id) {
        return  "Nombre: " + listPersonas().get(id - 1).getNombre() + "\n"
                + "Correo:  " + listPersonas().get(id - 1).getCorreo() + "\n"
                + "Cargo:  " + listPersonas().get(id - 1).getCargo() + "\n"
                + "Sueldo:  " + listPersonas().get(id - 1).getSueldo();
    }
    public ServidorImpl() throws RemoteException {
        super();
    }
    @Override
    public String consultar(int id) throws Exception {
        if (id < listPersonas().size()+1) {
            return getPersonas(id);
        }else {
            return "No existen datos del Empleado con el ID: " + id;
        }
    }
}
