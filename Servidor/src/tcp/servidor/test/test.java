package tcp.servidor.test;
import tcp.servidor.Servidor.Servidor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) throws Exception {
        /*System.out.println(Servidor.getFecha("Josué Guerra"));*/
        Servidor.procesarSolicitud(5000);
    }
}
