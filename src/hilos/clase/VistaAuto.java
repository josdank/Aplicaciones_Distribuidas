package hilos.clase;

import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class VistaAuto {
    private JPanel panelPrincipal;
    private JLabel lblMarca;
    private JLabel lblModelo;
    private JLabel lblPrecio;

    public VistaAuto(String marca, String modelo, String precio) {
        lblMarca.addComponentListener(new ComponentAdapter() {
            @Override
            public String toString() {
                return super.toString();
            }
        });
        lblModelo.addComponentListener(new ComponentAdapter() {
            @Override
            public String toString() {
                return super.toString();
            }
        });
        lblPrecio.addComponentListener(new ComponentAdapter() {
            @Override
            public String toString() {
                return super.toString();
            }
        });

        // Asignar texto a los labels
        lblMarca.setText(marca);
        lblModelo.setText(modelo);
        lblPrecio.setText(precio);

        // Crear ventana JFrame para mostrar esta vista
        JFrame frame = new JFrame("Vista Auto");
        frame.setContentPane(panelPrincipal);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
