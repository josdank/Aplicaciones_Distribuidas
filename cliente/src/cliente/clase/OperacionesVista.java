package cliente.clase;

import javax.swing.*;
import java.awt.*;

public class OperacionesVista extends JFrame {

    public JPanel ResultadOp;
    private JTextField num1;
    private JButton BtnSuma;
    private JButton BtnMulti;
    private JButton BtnResta;
    private JButton BtnDiv;
    private JTextField num2;
    private JLabel Resultado;
    private JLabel operacion;
    private JButton btnResultado;

    private char operacionSeleccionada;
    private cliente cliente;

    private static final String SERVIDOR_IP = "172.31.116.73"; // Dirección del servidor
    private static final int PUERTO_SERVIDOR = 5000; // Puerto del servidor

    public OperacionesVista() {
        cliente = new cliente(SERVIDOR_IP, PUERTO_SERVIDOR); // Instancia del Cliente

        setTitle("Operaciones Matemáticas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicialización de los componentes
        ResultadOp = new JPanel();
        ResultadOp.setBackground(Color.WHITE);
        ResultadOp.setLayout(new GridLayout(4, 2));

        num1 = new JTextField(10);
        num2 = new JTextField(10);
        operacion = new JLabel("Operación:");
        Resultado = new JLabel("Resultado:");

        BtnSuma = new JButton("+");
        BtnResta = new JButton("-");
        BtnMulti = new JButton("*");
        BtnDiv = new JButton("/");
        btnResultado = new JButton("Calcular");

        // Agregar componentes al panel
        ResultadOp.add(num1);
        ResultadOp.add(num2);
        ResultadOp.add(BtnSuma);
        ResultadOp.add(BtnResta);
        ResultadOp.add(BtnMulti);
        ResultadOp.add(BtnDiv);
        ResultadOp.add(btnResultado);
        ResultadOp.add(Resultado);

        setContentPane(ResultadOp);

        // Configurar eventos
        BtnSuma.addActionListener(e -> seleccionarOperacion('+'));
        BtnResta.addActionListener(e -> seleccionarOperacion('-'));
        BtnMulti.addActionListener(e -> seleccionarOperacion('*'));
        BtnDiv.addActionListener(e -> seleccionarOperacion('/'));

        btnResultado.addActionListener(e -> enviarAlServidor());
    }

    private void seleccionarOperacion(char operador) {
        operacionSeleccionada = operador;
        operacion.setText("Operación: " + operador);
    }

    private void enviarAlServidor() {
        try {
            int numero1 = Integer.parseInt(num1.getText());
            int numero2 = Integer.parseInt(num2.getText());

            // Usamos Cliente para enviar la operación
            String resultadoServidor = cliente.enviarOperacion(numero1, numero2, operacionSeleccionada);
            Resultado.setText("Resultado: " + resultadoServidor);
        } catch (Exception e) {
            Resultado.setText("Error al procesar la operación");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OperacionesVista ventana = new OperacionesVista();
            ventana.setVisible(true);
        });
    }

}
