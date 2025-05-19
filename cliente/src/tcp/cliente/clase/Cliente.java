package tcp.cliente.clase;

import tcp.cliente.serial.servicios.Servicio;

import java.io.File;
import java.net.Socket;

public class Cliente {
    private static final int PUERTO = 5000;
    private static final String IP = "172.31.116.73";
    private static final String FILE_PATH = "C:/Users/APP DISTRIBUIDAS/Documents/App_Dsitribuidas_Josue/Aplicaciones_Distribuidas/Serializacion/src/serial/test/Historial.dat";

    public static void enviarHistorial() {
        try (Socket cliente = new Socket(IP, PUERTO)) {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("El archivo Historial.dat no existe.");
                return;
            }

            // Aquí se enviaría el archivo al servidor (implementación en el servidor)
            System.out.println("Historial enviado al servidor.");
        } catch (Exception ex) {
            System.out.println("Error al enviar historial: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Consumir el servicio de RegistroEmpleado
        /*RegistroEmpleado registro = new RegistroEmpleado();*/
        /*registro.guardarRegistro(FILE_PATH); // Se supone que RegistroEmpleado tiene un método que guarda datos en Historial.dat*/

        // Enviar historial al servidor después del registro
        enviarHistorial();
    }
}
