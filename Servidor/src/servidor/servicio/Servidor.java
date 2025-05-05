package servidor.servicio;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public void servicio() {

        int port = 5000;

        try {

            DatagramSocket socket = new DatagramSocket(port); // Crear socket UDP en el puerto 5000
            System.out.println("Servidor iniciado en el puerto " + port);

            byte[] buffer = new byte[1024]; // Convertir el mensaje a bytes

            while (true) {
                // Recibir datagrama del cliente
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // Procesar datagrama
                String mensaje = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido: " + mensaje);

                // Procesar el mensaje
                String[] numeros = mensaje.split(",");
                if (numeros.length == 2) {
                    try {
                        int numero1 = Integer.parseInt(numeros[0]);
                        int numero2 = Integer.parseInt(numeros[1]);
                        int resultado = numero1 + numero2;
                        String respuesta = String.valueOf(resultado);
                        byte[] respuestaBytes = respuesta.getBytes();

                        DatagramPacket respuestaPacket = new DatagramPacket(
                                respuestaBytes,
                                respuestaBytes.length,
                                packet.getAddress(),
                                packet.getPort());
                        socket.send(respuestaPacket);
                        System.out.println("Respuesta enviada: " + respuesta);

                    } catch (Exception e) {
                        System.out.println("Error al procesar los números: " + e.getMessage());
                        String respuesta = "Error al procesar los números";
                        byte[] respuestaBytes = respuesta.getBytes();
                        DatagramPacket respuestaPacket = new DatagramPacket(respuestaBytes, respuestaBytes.length, packet.getAddress(), packet.getPort());
                        socket.send(respuestaPacket);
                        System.out.println("Respuesta enviada: " + respuesta);
                    }
                }
            }
        } catch (Exception e) {

        }
    }
}