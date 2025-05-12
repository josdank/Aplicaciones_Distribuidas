package servidor.test;

import servidor.servicio.Estudiante;

public class test {
    public static void main(String[] args) {
        // Creamos una instancia de estudiante con datos de prueba
        Estudiante estudiante = new Estudiante(
                1,
                "Estudiante Prueba",
                "0912345678",
                "Informática",
                1,
                true
        );

        // Iniciamos el servicio
        estudiante.servicio();
    }
}