package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String user = "uAdminProyectos";
    private final String password = "12345";
    private final String host = "192.168.1.66";
    private final String bd = "caductBD";
    private final String url = "jdbc:mysql://" + host + "/" + bd;
    private Connection con = null;

    public Conexion() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("No se pudo conectar a la base de datos: " + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return con;
    }

    public void cerrarConexion() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
