package datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operaciones {

    private Statement stmt;

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public Operaciones() throws SQLException {
    }

    public ResultSet ConsultaBase(String consulta) {
        ResultSet resultado = null;
        try {

            Conexion conexion = new Conexion();
            stmt = conexion.con.createStatement();
            resultado = stmt.executeQuery(consulta);
            conexion.con.close();
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public boolean InsercionBase(String consulta) {
        boolean respuesta = true;
        try {

            Conexion conexion = new Conexion();
            stmt = conexion.con.createStatement();
            respuesta = stmt.execute(consulta);
            conexion.con.close();
            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public boolean ActualizacionBase(String consulta) {
        boolean respuesta = true;
        try {

            Conexion conexion = new Conexion();
            stmt = conexion.con.createStatement();
            respuesta = stmt.execute(consulta);
            conexion.con.close();
            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

}
