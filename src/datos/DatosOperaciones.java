package datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatosOperaciones {

    private Statement stmt;

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public DatosOperaciones() {
    }

    public ResultSet DBase(String consulta) {
        ResultSet resultado = null;
        try {

            Conexion conexion = new Conexion();
            stmt = conexion.con.createStatement();
            resultado = stmt.executeQuery(consulta);
            
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(DatosOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
