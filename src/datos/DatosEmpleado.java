package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Empleado;

public class DatosEmpleado {
    
    public int buscarEmpleado(String nickname, String password){
        int numEmpleado = 0;
        
        try {
            DatosOperaciones consulta = new DatosOperaciones();
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
    
    public Empleado getEmpleado(int idEmpleado){
        Empleado datosEmpleado = null;
        
         try {
            DatosOperaciones consulta = new DatosOperaciones();
            ResultSet resultado = consulta.DBase("select nombre, apellido_paterno, "
                    + "apellido_materno, nickname from Empleados where "
                    + "id_empleado='"+idEmpleado+"';");
            
            resultado.next();
            datosEmpleado = new Empleado();
            datosEmpleado.setNombre(resultado.getString("nombre"));
            datosEmpleado.setApellido_paterno(resultado.getString("apellido_paterno"));
            datosEmpleado.setApellido_materno(resultado.getString("apellido_materno"));
            datosEmpleado.setNickname(resultado.getString("nickname"));
            
            consulta.getStmt().close();
            
            return datosEmpleado;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
        return datosEmpleado;
    }
}
