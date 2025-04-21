package clase.test;

import clase.impl.OperacionesImpl;
import clase.interfaz.Operaciones;

import javax.swing.*;
import java.util.Scanner;

public class OperacionesTest {
    public static void main(String[] args) {
        /*double y=0;
        double x=0;

        System.out.println("Hola Mundo");
        Operaciones op = new OperacionesImpl();
        Scanner scanner = new Scanner(System.in);

        x=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el primer número"));
        /*System.out.println("Ingrese el primer número:");
        //x= scanner.nextDouble();

        y=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el segundo número"));
        //System.out.println("Ingrese el primer número:");
        //y= scanner.nextDouble();

        JOptionPane.showMessageDialog(null,"El resultado es: "+op.sumar(x,y))*/;

        double x = 0, y = 0;
        Operaciones op = new OperacionesImpl();

        // Menú de opciones
        String[] opciones = {"Suma", "Resta", "Multiplicación", "División"};
        String seleccion = (String) JOptionPane.showInputDialog(null,
                "Seleccione una operación:",
                "Menú de Operaciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        // Ingreso de números
        x = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el primer número:"));
        y = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el segundo número:"));

        // Procesar la operación seleccionada
        String resultado = "";
        switch (seleccion) {
            case "Suma":
                resultado = "La suma es: " + op.sumar(x, y);
                break;
            case "Resta":
                resultado = "La resta es: " + op.resta(x, y);
                break;
            case "Multiplicación":
                resultado = "La multiplicación es: " + op.multiplicacion(x, y);
                break;
            case "División":
                if (y != 0) {
                    resultado = "La división es: " + op.division(x, y);
                } else {
                    resultado = "Error: División por cero.";
                }
                break;
        }

        // Mostrar resultado en interfaz
        JOptionPane.showMessageDialog(null, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}
