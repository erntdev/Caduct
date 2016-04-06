package logica;


public class ConsultasEmpleado {
    public boolean buscarEmpleado(String nickname, String password){
        boolean encontrado=false;
        try {
            datos.DatosEmpleado empleado = new datos.DatosEmpleado();
            Empleado.id_empleado = empleado.buscarEmpleado(nickname,password);
            
            encontrado = Empleado.id_empleado>=1;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return encontrado;
    }
    
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
}
