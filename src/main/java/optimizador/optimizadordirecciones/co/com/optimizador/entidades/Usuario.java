package optimizador.optimizadordirecciones.co.com.optimizador.entidades;

import java.io.Serializable;

/**
 * Persistencia de objetos de tipo administrador.
 * 
 * @author Andres Cañón
 * @version 1.0
 */
public class Usuario implements Serializable {

	/**
	 * Versión serial por defecto para está clase.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Id del usuario. (Clave primaria).
	 */
	private Long codigoUsuario;
	/**
	 * Uusario con el que se hace login.
	 */
	private String usuario;
	/**
	 * Contraseña de usuario.
	 */
	private String password;
	/**
	 * Nombres del administrador.
	 */
	private String nombres;
	/**
	 * Apellidos del administrador.
	 */
	private String apellidos;
	/**
	 * el cargo del usuario.
	 */
	private String cargo;
	/**
	 * El area de desempeño.
	 */
	private String area;

	/**
	 * @return the codigousuario
	 */
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	/**
	 * @param codigousuario
	 *            the codigousuario to set
	 */
	public void setCodigoUsuario(Long codigousuario) {
		this.codigoUsuario = codigousuario;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 *            the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

}