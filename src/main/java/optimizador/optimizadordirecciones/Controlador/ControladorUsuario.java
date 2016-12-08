/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizador.optimizadordirecciones.Controlador;

import optimizador.optimizadordirecciones.Modelo.UsuarioDAO;
import optimizador.optimizadordirecciones.Vista.JFramePrincipal;
import optimizador.optimizadordirecciones.Vista.JInternalFrameUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import optimizador.optimizadordirecciones.Vista.JInternalFramePredios;

/**
 *
 * @author Pavilion
 */
public class ControladorUsuario implements ActionListener{
    JFramePrincipal vistaPrincipal = new JFramePrincipal();
    JInternalFrameUsuarios vistaUsuario = new JInternalFrameUsuarios();
    JInternalFramePredios vistaPredios = new JInternalFramePredios();
    UsuarioDAO modeloUsuario = new UsuarioDAO();

    public ControladorUsuario(JFramePrincipal vistaPrincipal, JInternalFrameUsuarios vistaUsuario, JInternalFramePredios vistaPredios, UsuarioDAO modeloUsuario) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.setVisible(true);
        this.vistaUsuario = vistaUsuario;
        this.modeloUsuario = modeloUsuario;
        this.vistaPredios = vistaPredios;
        this.vistaPrincipal.menuItemUsuarios.addActionListener(this);
        this.vistaPrincipal.menuItemPredios.addActionListener(this);
        this.vistaUsuario.btnNuevo.addActionListener(this);
        this.vistaUsuario.btnGuardar.addActionListener(this);
        this.vistaUsuario.btnEditar.addActionListener(this);
        this.vistaUsuario.btnEliminar.addActionListener(this);
        this.vistaUsuario.btnCancelar.addActionListener(this);
        this.vistaUsuario.btnBuscar.addActionListener(this);
        inactivarControles();
    }
    
    public void InicializarControladorUsuario(){
        
    }
    
    public void limpiarFormulario(){
        vistaUsuario.txtIdUsuario.setText("");
        vistaUsuario.txtNombres.setText("");
        vistaUsuario.txtApellidos.setText("");
        vistaUsuario.txtCargo.setText("");
        vistaUsuario.txtArea.setText("");
        vistaUsuario.txtUsername.setText("");
        vistaUsuario.cboxSeleccionarTipo.setSelectedIndex(0);
        vistaUsuario.pwdIngresarPassword.setText("");
        vistaUsuario.pwdIngresarPassword1.setText("");
        vistaUsuario.btnNuevo.setEnabled(true);
        inactivarControles();
    }
    
    public void inactivarControles(){        
        vistaUsuario.txtIdUsuario.setEditable(false);
        vistaUsuario.txtNombres.setEditable(false);
        vistaUsuario.txtApellidos.setEditable(false);
        vistaUsuario.txtCargo.setEditable(false);
        vistaUsuario.txtArea.setEditable(false);
        vistaUsuario.txtUsername.setEditable(false);
        vistaUsuario.cboxSeleccionarTipo.setSelectedIndex(0);
        vistaUsuario.pwdIngresarPassword.setEditable(false);
        vistaUsuario.pwdIngresarPassword1.setEditable(false);
        vistaUsuario.btnGuardar.setEnabled(false);
        vistaUsuario.cboxSeleccionarTipo.setEnabled(false);
    }

    public void activarControles(){        
        vistaUsuario.txtIdUsuario.setEditable(true);
        vistaUsuario.txtNombres.setEditable(true);
        vistaUsuario.txtApellidos.setEditable(true);
        vistaUsuario.txtCargo.setEditable(true);
        vistaUsuario.txtArea.setEditable(true);
        vistaUsuario.txtUsername.setEditable(true);
        vistaUsuario.cboxSeleccionarTipo.setSelectedIndex(0);
        vistaUsuario.cboxSeleccionarTipo.setEnabled(true);
        vistaUsuario.pwdIngresarPassword.setEditable(true);
        vistaUsuario.pwdIngresarPassword1.setEditable(true);
        vistaUsuario.btnGuardar.setEnabled(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaPrincipal.menuItemUsuarios){
            vistaPrincipal.jDesktopPane1.add(vistaUsuario);
            vistaUsuario.setVisible(true);
        }
        
        if(e.getSource() == vistaUsuario.btnGuardar){
            String clave1 = String.valueOf(vistaUsuario.pwdIngresarPassword.getPassword());
            String clave2 = String.valueOf(vistaUsuario.pwdIngresarPassword1.getPassword());
            if(clave1.equals(clave2)){
                String idUsuario = vistaUsuario.txtIdUsuario.getText();
                String username = vistaUsuario.txtUsername.getText();
                String clave = String.valueOf(vistaUsuario.pwdIngresarPassword.getPassword());
                String tipousuario = (String) vistaUsuario.cboxSeleccionarTipo.getSelectedItem();
                String nombres = vistaUsuario.txtNombres.getText();
                String apellidos = vistaUsuario.txtApellidos.getText();
                String cargo = vistaUsuario.txtCargo.getText();
                String area = vistaUsuario.txtArea.getText();
                String resultado = modeloUsuario.insertarUsuario(idUsuario, username, clave, tipousuario, nombres, apellidos, cargo, area);

                if(resultado != null){
                    JOptionPane.showMessageDialog(null, resultado);
                    limpiarFormulario();
                }else{
                    JOptionPane.showMessageDialog(null, "Error guardando el registro");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, por favor intente nuevamente.");
            }
        }
        
        if(e.getSource() == vistaUsuario.btnCancelar){
            JOptionPane.showMessageDialog(null, "¡Acción Cancelada!");
            limpiarFormulario();
        }
        
        if(e.getSource() == vistaUsuario.btnNuevo){
            limpiarFormulario();
            activarControles();
            vistaUsuario.btnEditar.setEnabled(false);
            vistaUsuario.btnEliminar.setEnabled(false);
            vistaUsuario.btnNuevo.setEnabled(false);
        }
        
        
        if(e.getSource() == vistaPrincipal.menuItemPredios)
        vistaPrincipal.jDesktopPane1.add(vistaPredios);
            vistaPredios.setVisible(true);        
    }    
}
