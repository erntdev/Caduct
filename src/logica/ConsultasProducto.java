package logica;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ConsultasProducto {    
    public boolean registrarProducto(Producto producto) {
        boolean respuesta=true;
        try {
            datos.DatosProducto de = new datos.DatosProducto();
            respuesta = de.registrarProducto(producto);
            
        } catch (Exception e) {
            System.out.println("Se ha presentado el siguiente Error: "+e);
        }
        return respuesta;
    }
    
    public TableModel listarEmpleados(){
        TableModel modelo = new DefaultTableModel();

        try {
            datos.DatosProducto productos = new datos.DatosProducto();
            modelo = productos.listarProductosVista();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return modelo;
    }
}
