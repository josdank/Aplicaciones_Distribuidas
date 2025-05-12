package servidor.servicio;

import lombok.Getter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;

@Getter  // Esto generará todos los getters, pero los haremos explícitos para mayor claridad
public class Estudiante {
    private final int id;
    private final String nombre;
    private final String telefono;
    private final String carrera;
    private final int semestre;
    private final boolean gratuidad;

    public Estudiante(int id, String nombre, String telefono, String carrera, int semestre, boolean gratuidad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.carrera = carrera;
        this.semestre = semestre;
        this.gratuidad = gratuidad;
    }

    // Métodos getter explícitos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public boolean isGratuidad() {
        return gratuidad;
    }

    public void servicio() {
        int port = 5000;

        try {
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Servidor UDP iniciado en el puerto " + port);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String mensaje = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido: " + mensaje);

                String respuesta = procesarMensaje(mensaje);
                byte[] respuestaBytes = respuesta.getBytes();

                DatagramPacket respuestaPacket = new DatagramPacket(
                        respuestaBytes, respuestaBytes.length,
                        packet.getAddress(), packet.getPort()
                );
                socket.send(respuestaPacket);
                System.out.println("Respuesta enviada: " + respuesta);
            }
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    private String procesarMensaje(String mensaje) {
        try {
            int idBuscado = Integer.parseInt(mensaje.trim());
            List<Estudiante> estudiantes = EstudianteDB.getEstudiantes();

            return estudiantes.stream()
                    .filter(e -> e.getId() == idBuscado)
                    .findFirst()
                    .map(Object::toString)
                    .orElse("Error: estudiante no encontrado");
        } catch (NumberFormatException e) {
            return "Error: formato incorrecto. Ingrese un ID válido.";
        }
    }

    @Override
    public String toString() {
        return String.format("Estudiante{id=%d, nombre='%s', telefono='%s', carrera='%s', semestre=%d, gratuidad=%b}",
                id, nombre, telefono, carrera, semestre, gratuidad);
    }

    public static void main(String[] args) {
        new Estudiante(0, "", "", "", 0, false).servicio();
    }
}