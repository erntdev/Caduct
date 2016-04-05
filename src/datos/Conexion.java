package datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //conexion con php myadmin
    
    private String driver = "com.mysql.jdbc.Driver";
    private String connectString = "jdbc:mysql://172.24.33.124:3306/caduct";
    private String user="u132029";
    private String password="iliprinc";
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
