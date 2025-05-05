package clases.hilo;

import javax.swing.*;

public class carrera implements Runnable {
    Thread hilo;
    String nombre;
    JLabel participante;
    JLabel posicion;
    public static int lugar = 1; // Empieza desde 1

    public carrera(String nombre, JLabel participante, JLabel posicion) {
        this.nombre = nombre;
        this.participante = participante;
        this.posicion = posicion;

        hilo = new Thread(this, nombre);
        hilo.start();
    }

    @Override
    public void run() {
        int retardo;
        try {
            retardo = (int) (Math.random() * 30) + 1;
            int limiteX = participante.getParent().getWidth() - participante.getWidth(); // Límite de movimiento

            for (int i = participante.getX(); i < limiteX; i++) {
                final int posicionX = i; // Variable final para lambda
                SwingUtilities.invokeLater(() -> participante.setLocation(posicionX, participante.getY()));
                Thread.sleep(retardo);
            }
            participante.setVisible(false);
            participante.setVisible(true);

            // Formatear la posición
            String posicionTexto;
            switch (lugar) {
                case 1:
                    posicionTexto = "1er lugar";
                    break;
                case 2:
                    posicionTexto = "2do lugar";
                    break;
                case 3:
                    posicionTexto = "3er lugar";
                    break;
                default:
                    posicionTexto = lugar + "° lugar"; // Para posiciones superiores
            }

            SwingUtilities.invokeLater(() -> posicion.setText(nombre + " ha llegado en " + posicionTexto));
            lugar++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
