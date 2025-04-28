package hilos.clase;

import javax.swing.JOptionPane;

public class ProcesoE implements Runnable {
    // Constructor
    private String mensaje;

    public ProcesoE(String mensaje) {
        this.mensaje = mensaje;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void run() {
        System.out.println("-- Proceso E --");
        mostrarMensaje(mensaje);
    }
    }
