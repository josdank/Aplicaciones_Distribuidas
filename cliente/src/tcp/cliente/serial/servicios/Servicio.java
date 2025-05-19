package tcp.cliente.serial.servicios;
import tcp.cliente.serial.entidad.Persona;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Servicio {
    // Escribir el archivo Binario
    /*public void escribir ( Persona p, String ruta) throws Exception{
        FileOutputStream fos = new FileOutputStream(ruta);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.close();

    }

    // Leer archivo Binario
    public Persona leer ( String ruta) throws Exception{
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Persona p = (Persona) ois.readObject();
        ois.close();
        return p;
    }*/
    public void escribir ( List<Persona> lista, String ruta) throws Exception{
        FileOutputStream fos = new FileOutputStream(ruta);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lista); //Guarda toda la lista en el archivo
        oos.close();
    }

    public List<Persona> leer ( String ruta) throws Exception{
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List <Persona> lista = (List<Persona>) ois.readObject();
        ois.close();
        return lista;
    }
}
