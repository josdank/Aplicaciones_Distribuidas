package rmi.cliente;

import rmi.interfaces.Registro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteGUI extends JFrame {

    private Registro stub;

    private JTextField nombreField;
    private JTextField correoField;
    private JTextField buscarCorreoField;
    private JLabel mensajeLabel;
    private DefaultTableModel tablaModel;

    public ClienteGUI() {
        setTitle("Sistema de Registro RMI");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        conectarServidor();

        mensajeLabel = new JLabel(" ");
        mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeLabel.setForeground(new Color(0, 102, 204));
        add(mensajeLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Registrar nuevo Usuario"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nombreField = new JTextField(20);
        correoField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Nombre completo:"), gbc);
        gbc.gridx = 1;
        formPanel.add(nombreField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Correo electrónico:"), gbc);
        gbc.gridx = 1;
        formPanel.add(correoField, gbc);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> registrarUsuario());
        gbc.gridx = 1; gbc.gridy = 2;
        formPanel.add(btnRegistrar, gbc);

        add(formPanel, BorderLayout.WEST);

        // Panel de búsqueda
        JPanel buscarPanel = new JPanel(new FlowLayout());
        buscarCorreoField = new JTextField(15);
        JButton btnBuscar = new JButton("Buscar usuario");

        btnBuscar.addActionListener(e -> buscarUsuario());

        buscarPanel.setBorder(BorderFactory.createTitledBorder("Buscar usuario por correo"));
        buscarPanel.add(buscarCorreoField);
        buscarPanel.add(btnBuscar);
        add(buscarPanel, BorderLayout.SOUTH);

        // Tabla
        tablaModel = new DefaultTableModel(new Object[]{"Correo", "Usuario Generado"}, 0);
        JTable tabla = new JTable(tablaModel);
        tabla.setEnabled(false);
        JScrollPane tablaScroll = new JScrollPane(tabla);
        tablaScroll.setBorder(BorderFactory.createTitledBorder("Usuarios registrados"));
        add(tablaScroll, BorderLayout.CENTER);
    }

    private void conectarServidor() {
        try {
            String ipServidor = "172.31.116.74";
            int puerto = 1099;
            Registry registry = LocateRegistry.getRegistry(ipServidor, puerto);
            stub = (Registro) registry.lookup("Servicio de registro");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo realizar la conexión al servidor:\n" + e.getMessage(),
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarUsuario() {
        String nombre = nombreField.getText().trim();
        String correo = correoField.getText().trim();

        if (nombre.isEmpty() || correo.isEmpty()) {
            mensajeLabel.setText("⚠️ Debes llenar todos los campos.");
            return;
        }

        try {
            String respuesta = stub.registrarUsuario(nombre, correo);
            mensajeLabel.setText(respuesta);

            if (!respuesta.contains("ya registrado")) {
                String usuario = respuesta.split(": ")[1];
                tablaModel.addRow(new Object[]{correo, usuario});
                nombreField.setText("");
                correoField.setText("");
            }
        } catch (Exception e) {
            mensajeLabel.setText("Error al registrar: " + e.getMessage() + "Favor de revisar los campos");
        }
    }

    private void buscarUsuario() {
        String correo = buscarCorreoField.getText().trim();
        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un correo a buscar.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String resultado = stub.buscarUsuario(correo);
            JOptionPane.showMessageDialog(this, resultado, "Resultado de búsqueda", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteGUI().setVisible(true));
    }
}
