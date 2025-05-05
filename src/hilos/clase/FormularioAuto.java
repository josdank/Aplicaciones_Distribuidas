package hilos.clase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioAuto extends JFrame implements Runnable {
    private JTextField imptMarca;
    private JTextField ImptModelo;
    private JTextField ImptPrecio;
    private JButton procesarButton;
    public JPanel VistaAutoP;

    public FormularioAuto() {
        setTitle("Formulario Auto");
        setContentPane(VistaAutoP);
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        imptMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        ImptModelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        ImptPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        procesarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = imptMarca.getText();
                String modelo = ImptModelo.getText();
                String precio = ImptPrecio.getText();

                // Abrir la nueva ventana con los datos ingresados
                new VistaAuto(marca, modelo, precio);

                // Cerrar esta ventana
                dispose();
            }
        });
    }

    @Override
    public void run() {
        setVisible(true);
    }
}
