package datos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Empleado {
    public int id_empleado;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String nickname;
    private String password;
    
    public int buscarEmpleado(String nickname, String password){
        int numEmpleado = 0;
        
        try {
            Operaciones consulta = new Operaciones();
            ResultSet resultado = consulta.DBase("select id_empleado from Empleados where "
                    + "nickname='"+nickname+"' and contraseña='"+password+"';");
            
            resultado.next();
            numEmpleado = resultado.getInt("id_empleado");
            
            consulta.getStmt().close();
            
            return numEmpleado;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return numEmpleado;
    }
}
