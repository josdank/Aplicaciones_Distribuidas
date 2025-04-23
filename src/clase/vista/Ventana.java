package clase.vista;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    public JPanel ventanaform;
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

    public Ventana() {
        ventanaform.setBackground(Color.WHITE);

        personalizarCampo(num1);
        personalizarCampo(num2);

        personalizarBoton(BtnSuma, "+");
        personalizarBoton(BtnResta, "-");
        personalizarBoton(BtnMulti, "*");
        personalizarBoton(BtnDiv, "/");
        personalizarBoton(btnResultado, "=");

        operacion.setFont(new Font("Arial", Font.BOLD, 20));
        operacion.setHorizontalAlignment(SwingConstants.CENTER);
        operacion.setText("");
        operacion.setPreferredSize(new Dimension(30, 30));

        Resultado.setFont(new Font("Arial", Font.BOLD, 16));

        BtnSuma.addActionListener(e -> seleccionarOperacion('+'));
        BtnResta.addActionListener(e -> seleccionarOperacion('-'));
        BtnMulti.addActionListener(e -> seleccionarOperacion('*'));
        BtnDiv.addActionListener(e -> seleccionarOperacion('/'));

        btnResultado.addActionListener(e -> calcular());
    }

    private void seleccionarOperacion(char operador) {
        operacionSeleccionada = operador;
        operacion.setText(String.valueOf(operador));
    }

    private void calcular() {
        try {
            double numero1 = Double.parseDouble(num1.getText());
            double numero2 = Double.parseDouble(num2.getText());
            double resultado;

            switch (operacionSeleccionada) {
                case '+': resultado = numero1 + numero2; break;
                case '-': resultado = numero1 - numero2; break;
                case '*': resultado = numero1 * numero2; break;
                case '/':
                    if (numero2 == 0) {
                        Resultado.setText("No se divide por 0");
                        return;
                    }
                    resultado = numero1 / numero2; break;
                default:
                    Resultado.setText("Operación inválida");
                    return;
            }

            DecimalFormat df = new DecimalFormat("#.###");
            Resultado.setText(df.format(resultado));
        } catch (NumberFormatException ex) {
            Resultado.setText("Valores inválidos");
        }
    }

    private void personalizarBoton(JButton boton, String texto) {
        boton.setText(texto);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 14));

        boton.setBackground(new Color(215, 183, 255));
        boton.setBorder(new RoundedBorder(15));
        boton.setPreferredSize(new Dimension(40, 30));
    }

    private void personalizarCampo(JTextField campo) {
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        campo.setBorder(new RoundedBorder(10));
        campo.setPreferredSize(new Dimension(150, 30));
    }

    private static class RoundedBorder extends AbstractBorder {
        private final int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.GRAY);
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(2, 8,0, 8);
            return insets;
        }
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