import clases.ventana.EjecucionCarrera;
import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear la ventana principal
                JFrame ventanaCarrera = new JFrame("Carrera de personajes");
                ventanaCarrera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventanaCarrera.setSize(400, 300);
                ventanaCarrera.setLocationRelativeTo(null);

                // Instanciar la clase EjecucionCarrera
                EjecucionCarrera ejecucionCarrera = new EjecucionCarrera();

                ventanaCarrera.setContentPane(ejecucionCarrera.PanelCarrera);

                ventanaCarrera.setVisible(true);
            }

        });
    }
}
