import rmi.cliente.ClienteGUI;
import javax.swing.*;


public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new ClienteGUI().setVisible(true));
}
