package logica;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ConsultasEmpleado {
    
    
    //Busca en base al id del empleado el nombre completo y nickname
    public Empleado getEmpleado(int idEmpleado){
        Empleado datosE= null;
        try {
            datos.DatosEmpleado de = new datos.DatosEmpleado();
            datosE = de.getEmpleado(idEmpleado);
            
            return datosE;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return datosE;
    }
    
    public boolean registrarEmpleado(Empleado empleado) {
        boolean respuesta=true;
        try {
            datos.DatosEmpleado de = new datos.DatosEmpleado();
            respuesta = de.registrarEmpleado(empleado);
            
        } catch (Exception e) {
            System.out.println("Se ha presentado el siguiente Error: "+e);
        }
        return respuesta;
    }
    
    public TableModel listarEmpleados(){
        TableModel modelo = new DefaultTableModel();

        try {
            datos.DatosEmpleado empleados = new datos.DatosEmpleado();
            modelo = empleados.listarEmpleadosVista();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return modelo;
    }
}
