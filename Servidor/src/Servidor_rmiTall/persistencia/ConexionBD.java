package Servidor_rmiTall.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    public static Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:database/empleados.db");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}