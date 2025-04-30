import javax.swing.*;

import clase.vista.Ventana;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {

        // Crear la ventana de login
        JFrame VentFrame = new JFrame("Calculadora");
        VentFrame.setContentPane(new Ventana().ventanaform);
        VentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VentFrame.pack();
        VentFrame.setLocationRelativeTo(null);
        VentFrame.setVisible(true);
    }
}