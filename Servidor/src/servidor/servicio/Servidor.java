package servidor.servicio;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Servidor {
    public void servicio() {
        int port = 5000;
        try {
            DatagramSocket socket = new DatagramSocket(port); // Crear socket UDP en el puerto 5000
            System.out.println("Servidor UDP WINDOWS iniciado en el puerto " + port);

            byte[] buffer = new byte[1024]; // Buffer para recibir mensajes
            while (true) {
                // Recibir datagrama del cliente
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                // Procesar datagrama
                String mensaje = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido: " + mensaje);
                // Procesar el mensaje
                String[] partes = mensaje.split(",");
                if (partes.length == 3) {
                    try {
                        int numero1 = Integer.parseInt(partes[0]);
                        int numero2 = Integer.parseInt(partes[1]);
                        String operacion = partes[2].trim();
                        int resultado = 0;
                        boolean error = false;

                        switch (operacion) {
                            case "+":
                                resultado = numero1 + numero2;
                                break;
                            case "-":
                                resultado = numero1 - numero2;
                                break;
                            case "*":
                                resultado = numero1 * numero2;
                                break;
                            case "/":
                                if (numero2 == 0) {
                                    error = true;
                                } else {
                                    resultado = numero1 / numero2;
                                }
                                break;
                            default:
                                error = true;
                        }

                        String respuesta;
                        if (error) {
                            respuesta = "Error: operación no válida o división por cero";
                        } else {
                            respuesta = String.valueOf(resultado);
                        }

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
                } else {
                    String respuesta = "Formato incorrecto. Use: número1,número2,operación (+,-,*,/)";
                    byte[] respuestaBytes = respuesta.getBytes();
                    DatagramPacket respuestaPacket = new DatagramPacket(respuestaBytes, respuestaBytes.length, packet.getAddress(), packet.getPort());
                    socket.send(respuestaPacket);
                    System.out.println("Respuesta enviada: " + respuesta);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
