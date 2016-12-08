/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizador.optimizadordirecciones.Modelo;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Pavilion
 */
public class UsuarioDAO {
    Conexion conexion;

    public UsuarioDAO() {
        conexion = new Conexion();
    }
    
    public String insertarUsuario(String idUsuario, String username, String clave, String tipoUsuario, String nombres, String apellidos, String cargo, String area){
        String resultadoRegistro = null;
        Connection enlaceDB = conexion.obtenerConexionDB();
        String sqlQuery = "INSERT INTO app.tbl_usuarios (idUsuario,username,clave,tipousuario,nombres,apellidos,cargo,area) VALUES (?,?,?,?,?,?,?,?)";
        int numeroFilasAfectadas = 0;
        try {
            PreparedStatement ps = enlaceDB.prepareStatement(sqlQuery);
            ps.setString(1, idUsuario);
            ps.setString(2, username);
            ps.setString(3, clave);
            ps.setString(4, tipoUsuario);
            ps.setString(5, nombres);
            ps.setString(6, apellidos);
            ps.setString(7, cargo);
            ps.setString(8, area);
            
            numeroFilasAfectadas = ps.executeUpdate();
            
            if(numeroFilasAfectadas > 0){
                resultadoRegistro = "Registro exitoso";
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return resultadoRegistro;
    }
}
