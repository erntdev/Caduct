package logica;

public class Empleado {
    public static int id_empleado;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String nickname;
    private String password;
    
    public boolean buscarEmpleado(String nickname, String password){
        boolean encontrado=false;
        try {
            datos.Empleado empleado = new datos.Empleado();
            id_empleado = empleado.buscarEmpleado(nickname,password);
            
            if (id_empleado>=1)
                encontrado=true;
            else
                encontrado=false;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return encontrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
