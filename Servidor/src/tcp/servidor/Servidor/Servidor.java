package tcp.servidor.Servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {
    //Servicio
    public static String getFecha(String nombre) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Fecha y hora de ingreso " + dateFormat.format(date) + " - " + "Bienvenido " + nombre;
    }

    //Procesar la solicitud
    public static void procesarSolicitud(int puerto) throws Exception {
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor de Fechas corriendo ....");

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente Conectado");
            InputStream in = cliente.getInputStream();
            OutputStream out = cliente.getOutputStream();

        //Leer el nombre del empleado
            DataInputStream dis = new DataInputStream(in);
            String nombre = dis.readUTF();
            if ( nombre.equals("x")) break;
            String resultado = Servidor.getFecha(nombre);
            System.out.println("Mensaje Recibido exitosamente");
        //Devolver la respuesta al cliente
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF(resultado);
            cliente.close();
        }
        servidor.close();
    }
}
