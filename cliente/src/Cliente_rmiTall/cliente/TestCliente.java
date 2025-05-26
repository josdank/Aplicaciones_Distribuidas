package Cliente_rmiTall.cliente;

import Cliente_rmiTall.cliente.Cliente;
import Cliente_rmiTall.interfaz.EmpleadoService;
import Cliente_rmiTall.modelo.Empleado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EmpleadoGUI extends JFrame {
    private JTextField campoId;
    private JTextArea areaResultado;

    public EmpleadoGUI() {
        setTitle("Buscar Empleado");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("ID Empleado:");
        label.setBounds(10, 10, 100, 25);
        add(label);

        campoId = new JTextField();
        campoId.setBounds(120, 10, 150, 25);
        add(campoId);

        JButton boton = new JButton("Buscar");
        boton.setBounds(10, 45, 260, 25);
        add(boton);

        areaResultado = new JTextArea();
        areaResultado.setBounds(10, 80, 260, 70);
        add(areaResultado);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEmpleado();
            }
        });
    }

    private void buscarEmpleado() {
        try {
            int id = Integer.parseInt(campoId.getText());
            EmpleadoService servicio = Cliente.obtenerServicio();
            Empleado emp = servicio.buscarEmpleadoPorId(id);
            if (emp != null) {
                areaResultado.setText("ID: " + emp.getId() + "\nNombre: " + emp.getNombre() + "\nPuesto: " + emp.getPuesto());
            } else {
                areaResultado.setText("Empleado no encontrado.");
            }
        } catch (Exception ex) {
            areaResultado.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new EmpleadoGUI().setVisible(true);
    }
}
