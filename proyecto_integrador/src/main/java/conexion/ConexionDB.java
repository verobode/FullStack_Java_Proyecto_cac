package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String url = "jdbc:mysql://localhost:3306/java_proyecto";
    private static final String user = "root";
    private static final String password = "";

    public static Connection obtenerConexion() throws SQLException {
        try {
            // Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver JDBC", e);
        }
        return DriverManager.getConnection(url, user, password);
    }
}
