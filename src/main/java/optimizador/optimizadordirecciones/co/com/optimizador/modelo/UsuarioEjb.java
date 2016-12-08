package optimizador.optimizadordirecciones.co.com.optimizador.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.bd.ConexionBD;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesQuery;
import optimizador.optimizadordirecciones.co.com.optimizador.dto.ParametroDto;
import optimizador.optimizadordirecciones.co.com.optimizador.entidades.Usuario;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JOptionUtil;

/**
 * 
 * @author Andres Cañón
 * @version 1.0
 * 
 */
public class UsuarioEjb {

	private static final Logger LOGGER = Logger.getLogger(UsuarioEjb.class);
	private static final UsuarioEjb INSTANCE = new UsuarioEjb();

	/**
	 * Login en la aplicación.
	 * 
	 * @param user
	 *            el usuario.
	 * @param pass
	 *            la contraseña.
	 * @return el usuario si existe o null.
	 */
	public Usuario login(String user, String pass) {
		Usuario u = null;
		try {
			ConexionBD.getInstance().setPst(
					ConexionBD.getInstance().getCon()
							.prepareStatement(ConstantesQuery.LOGIN));
			ConexionBD.getInstance().getPst().setString(1, user);
			ConexionBD.getInstance().getPst().setString(2, pass);
			ConexionBD.getInstance().setRs(
					ConexionBD.getInstance().getPst().executeQuery());
			while (ConexionBD.getInstance().getRs().next()) {
				u = new Usuario();
				u.setCodigoUsuario(ConexionBD.getInstance().getRs().getLong(1));
				u.setNombres(ConexionBD.getInstance().getRs().getString(2));
				u.setApellidos(ConexionBD.getInstance().getRs().getString(3));
				u.setCargo(ConexionBD.getInstance().getRs().getString(4));
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return u;
	}

	/**
	 * Guarda datos de usuario en la aplicación.
	 * 
	 * @param u
	 *            el usuario a guardar.
	 */
	public void save(Usuario u) {
		try {
			ConexionBD.getInstance().setPst(
					ConexionBD.getInstance().getCon()
							.prepareStatement(ConstantesQuery.INSERT_USER));
			ConexionBD.getInstance().getPst().setLong(1, u.getCodigoUsuario());
			ConexionBD.getInstance().getPst().setString(2, u.getNombres());
			ConexionBD.getInstance().getPst().setString(3, u.getApellidos());
			ConexionBD.getInstance().getPst().setString(4, u.getUsuario());
			ConexionBD.getInstance().getPst().setString(5, u.getPassword());
			ConexionBD.getInstance().getPst().setString(6, u.getCargo());
			ConexionBD.getInstance().getPst().setString(7, u.getArea());
			ConexionBD.getInstance().getPst().executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
			JOptionUtil
					.mostrarMensajeError(ConstantesInterfaz.E_MSJ_INESPERADO);
		}
	}

	/**
	 * Guarda datos de usuario en la aplicación.
	 * 
	 * @param u
	 *            el usuario a actualizar.
	 */
	public void update(Usuario u) {
		try {
			ConexionBD.getInstance().setPst(
					ConexionBD.getInstance().getCon()
							.prepareStatement(ConstantesQuery.UPDATE_USER));
			ConexionBD.getInstance().getPst().setString(1, u.getNombres());
			ConexionBD.getInstance().getPst().setString(2, u.getApellidos());
			ConexionBD.getInstance().getPst().setString(3, u.getUsuario());
			ConexionBD.getInstance().getPst().setString(4, u.getPassword());
			ConexionBD.getInstance().getPst().setString(5, u.getCargo());
			ConexionBD.getInstance().getPst().setString(6, u.getArea());
			ConexionBD.getInstance().getPst().setLong(7, u.getCodigoUsuario());
			ConexionBD.getInstance().getPst().executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
			JOptionUtil
					.mostrarMensajeError(ConstantesInterfaz.E_MSJ_INESPERADO);
		}
	}

	/**
	 * Guarda datos de usuario en la aplicación.
	 * 
	 * @param u
	 *            el usuario a eliminar.
	 */
	public void delete(Usuario u) {
		try {
			// Elimina al usuario
			ConexionBD.getInstance().setPst(
					ConexionBD.getInstance().getCon()
							.prepareStatement(ConstantesQuery.DELETE_USER));
			ConexionBD.getInstance().getPst().setLong(1, u.getCodigoUsuario());
			ConexionBD.getInstance().getPst().executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
			JOptionUtil
					.mostrarMensajeError(ConstantesInterfaz.E_MSJ_INESPERADO);
		}
	}

	/**
	 * Lista los usuarios presentes en la BD.
	 * 
	 * @return la lista de usuarios.
	 */
	public List<Usuario> list() {
		List<Usuario> lu = new ArrayList<>();
		try {
			ConexionBD.getInstance().setPst(
					ConexionBD.getInstance().getCon()
							.prepareStatement(ConstantesQuery.LISTAR_USUARIOS));
			ConexionBD.getInstance().setRs(
					ConexionBD.getInstance().getPst().executeQuery());
			while (ConexionBD.getInstance().getRs().next()) {
				Usuario u = new Usuario();
				u.setCodigoUsuario(ConexionBD.getInstance().getRs().getLong(1));
				u.setNombres(ConexionBD.getInstance().getRs().getString(2));
				u.setApellidos(ConexionBD.getInstance().getRs().getString(3));
				u.setUsuario(ConexionBD.getInstance().getRs().getString(4));
				u.setCargo(ConexionBD.getInstance().getRs().getString(6));
				u.setArea(ConexionBD.getInstance().getRs().getString(7));
				lu.add(u);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return lu;
	}

	/**
	 * Obtiene la lista de resultados como parametro para busqueda.
	 * 
	 * @return la lista de parametro.
	 */
	public List<ParametroDto> suggest() {
		List<ParametroDto> lu = new ArrayList<>();
		try {
			ConexionBD.getInstance().setPst(
					ConexionBD.getInstance().getCon()
							.prepareStatement(ConstantesQuery.LISTAR_USUARIOS));
			ConexionBD.getInstance().setRs(
					ConexionBD.getInstance().getPst().executeQuery());
			while (ConexionBD.getInstance().getRs().next()) {
				ParametroDto u = new ParametroDto();
				u.setId(ConexionBD.getInstance().getRs().getLong(1));
				u.setValor(ConexionBD.getInstance().getRs().getString(4));
				lu.add(u);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return lu;
	}

	/**
	 * Retorna un usuario dependiendo de su id.
	 * 
	 * @param id
	 *            la pk del usuario.
	 * @return el usuario con dicha clave.
	 */
	public Usuario search(Long id) {
		Usuario u = null;
		try {
			ConexionBD.getInstance().setPst(
					ConexionBD.getInstance().getCon()
							.prepareStatement(ConstantesQuery.SEARCH_USER));
			ConexionBD.getInstance().getPst().setLong(1, id);
			ConexionBD.getInstance().setRs(
					ConexionBD.getInstance().getPst().executeQuery());
			while (ConexionBD.getInstance().getRs().next()) {
				u = new Usuario();
				u.setCodigoUsuario(ConexionBD.getInstance().getRs().getLong(1));
				u.setNombres(ConexionBD.getInstance().getRs().getString(2));
				u.setApellidos(ConexionBD.getInstance().getRs().getString(3));
				u.setUsuario(ConexionBD.getInstance().getRs().getString(4));
				u.setPassword(ConexionBD.getInstance().getRs().getString(5));
				u.setCargo(ConexionBD.getInstance().getRs().getString(6));
				u.setArea(ConexionBD.getInstance().getRs().getString(7));
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return u;
	}

	/**
	 * @return the instance
	 */
	public static UsuarioEjb getInstance() {
		return INSTANCE;
	}

}
