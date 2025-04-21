package clase.vista;

import javax.swing.*;

public class Ventana extends JFrame{

    public JPanel ventanaform;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public Ventana() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ventana ventFrame = new Ventana();
            ventFrame.setContentPane(ventFrame.ventanaform);
            ventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventFrame.pack();
            ventFrame.setLocationRelativeTo(null);
            ventFrame.setVisible(true);
        });
    }
}