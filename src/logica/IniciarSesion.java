package logica;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class IniciarSesion {

    /**
     * Lógica- Buscar Personas registradas
     */
    public String BusquedaPersona(String usuario, String pass) {
        String dato = "";

        try {
            datos.IniciarSesion ins = new datos.IniciarSesion();
            dato = ins.BusquedaAlumnos(usuario, pass);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dato;
    }
}
