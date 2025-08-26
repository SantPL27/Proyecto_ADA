package acceso;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private static final String URL = "jdbc:ucanaccess://usuarios.accdb"; // Ruta de la BD Access

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            return conn;
        } catch (Exception e) {
            System.out.println("Error en la conexión a BD: " + e.getMessage());
            return null;
        }
    }
}