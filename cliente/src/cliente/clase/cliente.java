package cliente.clase;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class cliente {
    private final String IP_SERVIDOR;
    private final int PUERTO_SERVIDOR;
    public cliente(String ip, int puerto) {
        this.IP_SERVIDOR = ip;
        this.PUERTO_SERVIDOR = puerto;
    }

    public String enviarOperacion(int num1, int num2, char operador) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress direccionIpServidor = InetAddress.getByName(IP_SERVIDOR);
            String mensajeSalida = num1 + "," + num2 + "," + operador;
            byte[] bufferSalida = mensajeSalida.getBytes();
            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIpServidor, PUERTO_SERVIDOR);
            socket.send(paqueteSalida);
            // Esperar respuesta del servidor
            byte[] bufferEntrada = new byte[1024];
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            socket.receive(paqueteEntrada);

            String respuestaServidor = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
            socket.close();
            return respuestaServidor;
        } catch (Exception e) {
            return "Error en la conexión con el servidor";
        }
    }
}
