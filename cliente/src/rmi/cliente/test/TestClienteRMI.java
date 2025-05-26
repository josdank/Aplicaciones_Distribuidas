package rmi.cliente.test;

import rmi.cliente.clase.Cliente;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TestClienteRMI {
    public static void main(String[] args) throws Exception {
        String op = null;
        int id = -1;
        Scanner scanner = null;
        do {
            scanner = new Scanner(System.in);
            System.out.print("Buscar datos del empleado: ");
            id = scanner.nextInt();
            System.out.println(Cliente.consultar(id));
            System.out.print("Desea salir? (S/N): ");
            scanner.nextLine();
            op = scanner.nextLine().toUpperCase();
        } while (!op.equals("S"));

        if (scanner != null) {
            scanner.close();
        }
    }
}