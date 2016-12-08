package optimizador.optimizadordirecciones.co.com.optimizador.bd;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Está clase sólo tiene como objetivo evaluar la BD mediante query especifico.
 * 
 * @author Carol Becerra
 * @version 1.0
 */
public final class QueryBD {

	/**
	 * Logger de la clase.
	 */
	private static final Logger LOGGER = Logger.getLogger(QueryBD.class);

	/**
	 * Constructor por defecto.
	 */
	private QueryBD() {

	}

	/**
	 * Permite identificar si la BD existe o no. Para eso trata de establecer
	 * una conexión y obtener la metadata de la BD.
	 * 
	 * @since 1.0
	 * @param mainTable
	 *            la tabla a checar para validar existencia de BD.
	 * @param driver
	 *            el conector para la BD.
	 * @param url
	 *            la url de conexión a BD.
	 * @param user
	 *            el usuario de conexión a BD.
	 * @param pass
	 *            la contraseña de conexión a BD.
	 * @return TRUE si existe, FALSE en caso contrario.
	 */
	public static Boolean dbExist(String mainTable, String driver, String url,
			String user, String pass) {
		DatabaseMetaData metas = null;
		try {
			if (ConexionBD.getInstance().getCon() == null) {
				ConexionBD.getInstance().conectarBD(driver, url, user, pass);
			}
			metas = ConexionBD.getInstance().getCon().getMetaData();
			ConexionBD.getInstance().setSt(
					ConexionBD.getInstance().getCon().createStatement());
			ConexionBD.getInstance().setRs(
					metas.getTables(ConexionBD.getInstance().getCon()
							.getCatalog(), null, mainTable, null));

			if (!ConexionBD.getInstance().getRs().next()) {
				return Boolean.FALSE;
			}
			return Boolean.TRUE;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
			return Boolean.FALSE;
		} finally {
			ConexionBD.getInstance().cerrarConsulta();
		}
	}

}
