package Cliente_rmiTall.gui;

import Cliente_rmiTall.interfaz.EmpleadoService;
import Cliente_rmiTall.modelo.Empleado;
import Cliente_rmiTall.cliente.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpleadoGUI extends JFrame {
    private JTextField idField;
    private JTextArea resultadoArea;

    public EmpleadoGUI() {
        setTitle("Buscar Empleado");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel idLabel = new JLabel("ID del empleado:");
        idLabel.setBounds(10, 10, 120, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 10, 120, 25);
        add(idField);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(90, 50, 100, 30);
        add(buscarButton);

        resultadoArea = new JTextArea();
        resultadoArea.setBounds(10, 90, 260, 60);
        resultadoArea.setEditable(false);
        add(resultadoArea);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpleadoService servicio = Cliente.obtenerServicio();
                if (servicio != null) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        Empleado emp = servicio.buscarEmpleadoPorId(id);
                        if (emp != null) {
                            resultadoArea.setText("ID: " + emp.getId() + "\nNombre: " + emp.getNombre() + "\nCargo: " + emp.getCargo());
                        } else {
                            resultadoArea.setText("Empleado no encontrado.");
                        }
                    } catch (Exception ex) {
                        resultadoArea.setText("Error: " + ex.getMessage());
                    }
                } else {
                    resultadoArea.setText("Error de conexión con el servidor.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmpleadoGUI().setVisible(true));
    }
}