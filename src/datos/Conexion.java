package datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String driver = "com.mysql.jdbc.Driver";
    private String connectString = "jdbc:mysql://192.168.100.7:3306/dbCaduct";
    private String user="uAdminProyectos";
    private String password="12345";
    public Connection con;
        
    public Conexion(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(connectString, user , password);
        }catch ( Exception e ){
            System.out.println("Error: No se pudo conectar a la base de datos: "+e.getMessage());
        }
    }
}
