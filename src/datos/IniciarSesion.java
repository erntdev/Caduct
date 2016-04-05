package datos;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class IniciarSesion {
     /**Datos-Metodo para Buscar Personas*/
   public String BusquedaAlumnos(String usuario, String password){
        String dato = "";
        try {
             
             Operaciones consulta=new Operaciones();
             
             ResultSet resultado=consulta.ConsultaBase("select id_empleado from EMPLEADOS where nick_name='" +usuario +"' and contrasena='"+password+"'"); 
             dato=resultado.getString(0).toString();
             consulta.getStmt().close(); 
        }
        //
        catch (SQLException ex) {
             System.out.println(ex);
        }
    return dato;
  }
}
