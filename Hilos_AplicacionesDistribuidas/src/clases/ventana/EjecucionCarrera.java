package clases.ventana;

import clases.hilo.carrera;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjecucionCarrera {
    private JLabel Arakune;
    private JLabel Pikachu;
    private JLabel Steve;
    private JLabel posicion;
    private JLabel posicion2;
    private JLabel posicion3;
    private JButton iniciarCarreraButton;
    public JPanel PanelCarrera;

    public static int lugar = 1;

    public EjecucionCarrera() {
        // Cargar imágenes GIF sin redimensionar para mantener la animación
        ImageIcon imgArakune = new ImageIcon("gifs/Arakune.gif");
        ImageIcon imgPikachu = new ImageIcon("gifs/pikachu.gif");
        ImageIcon imgSteve = new ImageIcon("gifs/Steve.gif");

        // Asignar imágenes directamente para mantener animación
        Arakune.setIcon(imgArakune);
        Pikachu.setIcon(imgPikachu);
        Steve.setIcon(imgSteve);

        iniciarCarreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Resetear posiciones
                posicion.setText("");
                posicion2.setText("");
                posicion3.setText("");

                // Iniciar la carrera de los participantes
                new carrera("Arakune", Arakune, posicion);
                new carrera("Pikachu", Pikachu, posicion2);
                new carrera("Steve", Steve, posicion3);
            }
        });
    }
}
