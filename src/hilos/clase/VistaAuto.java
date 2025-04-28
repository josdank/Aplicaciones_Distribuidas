package hilos.clase;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAuto {
    @Getter @Setter private JTextField imptMarca;
    @Getter @Setter private JTextField ImptModelo;
    @Getter @Setter private JTextField ImptPrecio;
    @Getter @Setter private JButton procesarButton;
    public  JPanel VistaAutoP;

    public VistaAuto() {
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

            }
        });
    }
}
