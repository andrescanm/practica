/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizador.optimizadordirecciones.Modelo;
import java.sql.*;
/**
 *
 * @author Pavilion
 */
import javax.swing.JOptionPane;
public class Conexion {
    /*Variables de conexión a la base de datos*/
    private String url = "jdbc:derby://localhost:1527/db_odd";
    private String usuario = "root";
    private String clave = "12345";

    public Conexion() {
    }
    
    /*
     * Establece la conexión a la base de datos a través de un conector.
     */
    public Connection obtenerConexionDB(){
        Connection conector = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conector = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conector;
    }
    
}
