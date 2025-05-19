package tcp.cliente.clase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RegistroEmpleado {
    private JComboBox<String> CajadeOpciones;
    private JTextField Nombre_Empleado;
    private JButton Registrar;
    private JLabel Label_de_registro;
    public JPanel RegistroEmpleados;
    private JTextField IngresodeHoras;
    private JButton Historial;
    private JFrame frame;

    private Set<String> registros = new HashSet<>();

    public RegistroEmpleado(JFrame frame) {
        this.frame = frame;

        CajadeOpciones.addItem("Hora de entrada");
        CajadeOpciones.addItem("Inicio Almuerzo");
        CajadeOpciones.addItem("Fin de Almuerzo");
        CajadeOpciones.addItem("Hora de salida");

        Registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = Nombre_Empleado.getText();
                String opcion = Objects.requireNonNull(CajadeOpciones.getSelectedItem()).toString();
                String horas = IngresodeHoras.getText();

                if (nombre.isEmpty() || horas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos antes de registrar.");
                    return;
                }

                // Verificar si ya se ha registrado esta opción
                if (registros.contains(opcion)) {
                    JOptionPane.showMessageDialog(null, "Ya ha registrado la opción '" + opcion + "'. No puede repetir.");
                    return;
                }

                registros.add(opcion);

                if (opcion.equals("Hora de salida")) {
                    boolean tieneEntrada = registros.contains("Hora de entrada");
                    boolean tieneInicioAlmuerzo = registros.contains("Inicio Almuerzo");
                    boolean tieneFinAlmuerzo = registros.contains("Fin de Almuerzo");

                    if (!tieneEntrada || !tieneInicioAlmuerzo || !tieneFinAlmuerzo) {
                        JOptionPane.showMessageDialog(null, "Debe registrar todas las opciones antes de seleccionar 'Hora de salida'.");
                        return;
                    }

                    JOptionPane.showMessageDialog(null, "Que tenga un buen día!");

                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            frame.dispose();
                            SwingUtilities.invokeLater(() -> crearNuevaVentana());
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    Label_de_registro.setText("Registro exitoso para: " + nombre + " con opción " + opcion);
                }
            }
        });
    }

    public static void crearNuevaVentana() {
        JFrame nuevaFrame = new JFrame("Registro de Empleado");
        RegistroEmpleado registro = new RegistroEmpleado(nuevaFrame);
        registro.Nombre_Empleado.setEnabled(true);
        nuevaFrame.setContentPane(registro.RegistroEmpleados);
        nuevaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nuevaFrame.pack();
        nuevaFrame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro de Empleado");
        RegistroEmpleado registro = new RegistroEmpleado(frame);
        frame.setContentPane(registro.RegistroEmpleados);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
