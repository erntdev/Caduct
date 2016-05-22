package logica;

public class Producto {
    private String codigo;
    private String nombre;
    private double costo;
    private int cantidad;
    private String fecha_ingreso;
    private String fecha_caducidad;
    private String fecha_salida;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fecha_ingreso
     */
    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * @return the fecha_caducidad
     */
    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    /**
     * @param fecha_caducidad the fecha_caducidad to set
     */
    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    /**
     * @return the fecha_salida
     */
    public String getFecha_salida() {
        return fecha_salida;
    }

    /**
     * @param fecha_salida the fecha_salida to set
     */
    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
}
