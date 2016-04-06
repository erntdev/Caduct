package datos;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
    
    public boolean registrarEmpleado(logica.Empleado empleado) {
        boolean respuesta = true;
        try {
            DatosOperaciones consulta = new DatosOperaciones();
            //insert into Empleados values ('','Angélica','Barrón','Cruz','angie','5544');
            respuesta = consulta.insercionBase("insert into Empleados "
                    + "(nombre, apellido_paterno,apellido_materno,nickname,contraseña) "
                    + "values ('" + empleado.getNombre() + "','" + empleado.getApellido_paterno() + "','" + empleado.getApellido_materno() + "','" + empleado.getNickname() + "','" + empleado.getPassword() + "');");
            consulta.getStmt().close();
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        }
        return respuesta;
    }

    public TableModel listarEmpleadosVista() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { //Esto se realiza para que las celdas no sean editables
                return false;
            }
        };

        try {
            DatosOperaciones consulta = new DatosOperaciones();

            ResultSet resultado = consulta.DBase("select * from Empleados;");

            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData Columnas = resultado.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = Columnas.getColumnCount();

            //Establecer como cabezeras el nombre de las columnas
            for (int i = 1; i <= cantidadColumnas - 1; i++) {
                modelo.addColumn(Columnas.getColumnLabel(i)); //Agrega columnas al modelo con el titulo extraido de la metadata
            }
            //Extrae las filas del resultSet y los para al modelo
            while (resultado.next()) {
                Object[] fila = new Object[cantidadColumnas - 1];
                for (int i = 0; i < cantidadColumnas - 1; i++) {
                    fila[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(fila); //agregamos al modelo la fila extraida.
            }
            consulta.getStmt().close(); //Cierra el preparador  de sentencias SQL
            return modelo;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return modelo;
    }
}
