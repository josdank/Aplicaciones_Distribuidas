package servidor.servicio;

import java.util.ArrayList;
import java.util.List;

public class EstudianteDB {
    private static final List<Estudiante> estudiantes = new ArrayList<>();

    static {
        estudiantes.add(new Estudiante(01, "Carlos Pérez", "0991234567", "Ingeniería en Sistemas", 4, true));
        estudiantes.add(new Estudiante(02, "Ana Gómez", "0987654321", "Medicina", 3, false));
        estudiantes.add(new Estudiante(03, "Luis Torres", "0971234567", "Administración", 2, true));
        estudiantes.add(new Estudiante(04, "María López", "0965432167", "Arquitectura", 5, false));
        estudiantes.add(new Estudiante(05, "Pedro Jiménez", "0956789234", "Psicología", 1, true));
        estudiantes.add(new Estudiante(06, "Andrea Castillo", "0945678912", "Derecho", 6, false));
        estudiantes.add(new Estudiante(07, "Juan Sánchez", "0934567891", "Contabilidad", 7, true));
        estudiantes.add(new Estudiante(8, "Mónica Rivas", "0923456789", "Biología", 8, false));
        estudiantes.add(new Estudiante(9, "Luis Ramos", "0912345678", "Desarrollo de Software", 9, true));
        estudiantes.add(new Estudiante(10, "Josué Guerra", "0964030442", "Desarrollo de Software", 10, true));
    }

    public static List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
