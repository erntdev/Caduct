package datos;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import logica.Empleado;
import logica.Producto;

public class DatosProducto {
    public boolean registrarProducto(logica.Producto producto) {
        boolean respuesta = true;
        try {
            DatosOperaciones consulta = new DatosOperaciones();

            respuesta = consulta.insercionBase("insert into Productos "
                    + "(codigo, nombre,costo,cantidad) "
                    + "values ('" + producto.getCodigo() + "','" + producto.getNombre() + "','" + producto.getCosto() + "','" + producto.getCantidad() + "');");
            
            respuesta = consulta.insercionBase("insert into Fechas (fecha_ingreso,fecha_caducidad,id_empleado,codigo) "
                    + "values ('"+producto.getFecha_ingreso()+"','"+producto.getFecha_caducidad()+"',"
                    + "'"+Empleado.id_empleado+"','"+producto.getCodigo()+"');");
            consulta.getStmt().close();
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        }
        return respuesta;
    }

    public TableModel listarProductosVista() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { //Esto se realiza para que las celdas no sean editables
                return false;
            }
        };

        try {
            DatosOperaciones consulta = new DatosOperaciones();

            ResultSet resultado = consulta.DBase("select Productos.codigo, Productos.nombre, "
                    + "Productos.costo, Productos.cantidad, Fechas.fecha_ingreso, "
                    + "Fechas.fecha_caducidad from Productos, Fechas where "
                    + "Productos.codigo=Fechas.codigo;");

            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData Columnas = resultado.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = Columnas.getColumnCount();

            //Establecer como cabezeras el nombre de las columnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(Columnas.getColumnLabel(i)); //Agrega columnas al modelo con el titulo extraido de la metadata
            }
            //Extrae las filas del resultSet y los para al modelo
            while (resultado.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
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
    
    public Producto getProducto(String codigo){
        Producto datosProducto = null;
        
         try {
            DatosOperaciones consulta = new DatosOperaciones();
            ResultSet resultado = consulta.DBase("select Productos.nombre, "
                    + "Productos.costo, Productos.cantidad, Fechas.fecha_ingreso, "
                    + "Fechas.fecha_caducidad from Productos, Fechas where "
                    + "Productos.codigo=Fechas.codigo and "
                    + "Productos.codigo='"+codigo+"';");
            
             if (resultado.next()) {
                 datosProducto = new Producto();
                 datosProducto.setCodigo(codigo);
                 datosProducto.setNombre(resultado.getString("Nombre"));
                 datosProducto.setCosto(resultado.getDouble("costo"));
                 datosProducto.setCantidad(resultado.getInt("cantidad"));
                 datosProducto.setFecha_ingreso(resultado.getString("fecha_ingreso"));
                 datosProducto.setFecha_caducidad(resultado.getString("fecha_caducidad"));
             }
            
            
            consulta.getStmt().close();
            
            return datosProducto;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }       
        return datosProducto;
    }
    
    public boolean eliminarProducto(String codigo) {
        boolean respuesta = true;
        try {
            DatosOperaciones consulta = new DatosOperaciones();
            //delete from Fechas where codigo='D324';
            //delete from Productos where codigo='D324';
            respuesta = consulta.insercionBase("delete from Fechas where codigo='"+codigo+"';");
            respuesta = consulta.insercionBase("delete from Productos where codigo='"+codigo+"';");
            
            consulta.getStmt().close();
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        }
        return respuesta;
    }
}
