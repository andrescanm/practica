package optimizador.optimizadordirecciones.co.com.optimizador.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.bd.ConexionBD;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesQuery;
import optimizador.optimizadordirecciones.co.com.optimizador.dto.ParametroDto;
import optimizador.optimizadordirecciones.co.com.optimizador.entidades.Predio;
import optimizador.optimizadordirecciones.co.com.optimizador.entidades.Usuario;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JOptionUtil;

/**
 * 
 * @author Andres Cañón
 * @version 1.0
 * 
 */
public class PredioEjb {

	private static final Logger LOGGER = Logger.getLogger(PredioEjb.class);
	private static final PredioEjb INSTANCE = new PredioEjb();

	/**
	 * Guarda datos de usuario en la aplicación.
	 * 
	 * @param u
	 *            el usuario a guardar.
	 */
	public void save(Predio p) {
		try {
			ConexionBD.getInstance().setPst(
					ConexionBD.getInstance().getCon()
							.prepareStatement(ConstantesQuery.INSERT_PREDIO));
			ConexionBD.getInstance().getPst().setString(1, p.getIdContrato());
			ConexionBD.getInstance().getPst().setString(2, p.getIdPlan());
			ConexionBD.getInstance().getPst().setString(3, p.getLocalidad());
			ConexionBD.getInstance().getPst().setString(4, p.getSuscritor());
			ConexionBD.getInstance().getPst().setString(5, p.getVisitado());
			ConexionBD.getInstance().getPst().setString(6, p.getDireccion());
			ConexionBD.getInstance().getPst().setString(7, p.getVenAforo());
			ConexionBD.getInstance().getPst().setString(8, p.getNumHabitacionales());
			ConexionBD.getInstance().getPst().setString(9, p.getNumNoHabitaconales());
			ConexionBD.getInstance().getPst().setString(10, p.getProdBasura());
			ConexionBD.getInstance().getPst().setString(11, p.getNumSemana());
			ConexionBD.getInstance().getPst().setString(12, p.getTipoAforo());
			ConexionBD.getInstance().getPst().setString(13, p.getFrecuencia());
			ConexionBD.getInstance().getPst().setString(14, p.getHorario());
			ConexionBD.getInstance().getPst().setString(15, p.getObservaciones());
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
	public List<Predio> list() {
		List<Predio> lu = new ArrayList<>();
		try {
			ConexionBD.getInstance().setPst(
					ConexionBD.getInstance().getCon()
							.prepareStatement(ConstantesQuery.LISTAR_PREDIOS));
			ConexionBD.getInstance().setRs(
					ConexionBD.getInstance().getPst().executeQuery());
			while (ConexionBD.getInstance().getRs().next()) {
				Predio u = new Predio();
				u.setIdContrato(ConexionBD.getInstance().getRs().getString(1));
				u.setIdPlan(ConexionBD.getInstance().getRs().getString(2));
				u.setLocalidad(ConexionBD.getInstance().getRs().getString(3));
				u.setSuscritor(ConexionBD.getInstance().getRs().getString(4));
				u.setVisitado(ConexionBD.getInstance().getRs().getString(5));
				u.setDireccion(ConexionBD.getInstance().getRs().getString(6));
				u.setVenAforo(ConexionBD.getInstance().getRs().getString(7));
				u.setNumHabitacionales(ConexionBD.getInstance().getRs().getString(8));
				u.setNumNoHabitaconales(ConexionBD.getInstance().getRs().getString(9));
				u.setProdBasura(ConexionBD.getInstance().getRs().getString(10));
				u.setNumSemana(ConexionBD.getInstance().getRs().getString(11));
				u.setTipoAforo(ConexionBD.getInstance().getRs().getString(12));
				u.setFrecuencia(ConexionBD.getInstance().getRs().getString(13));
				u.setHorario(ConexionBD.getInstance().getRs().getString(14));
				u.setObservaciones(ConexionBD.getInstance().getRs().getString(15));
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
	public static PredioEjb getInstance() {
		return INSTANCE;
	}

}
