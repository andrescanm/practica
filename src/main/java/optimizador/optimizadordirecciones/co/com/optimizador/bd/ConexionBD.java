package optimizador.optimizadordirecciones.co.com.optimizador.bd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.excepcion.ExcepcionTecnica;

/**
 * Está clase gestiona la conexión con una base de datos, manejando los objetos
 * más comúnmente utilizados en las consultas, resultados, conexión y demás.
 * 
 * @author Carol Becerra
 * @version 1.0
 */
public class ConexionBD {
	/**
	 * objeto para conectar.
	 */
	private Connection con;
	/**
	 * objeto para definir consultas.
	 */
	private PreparedStatement pst;
	/**
	 * objeto para definir consultas.
	 */
	private Statement st;
	/**
	 * objeto para obtener resultados.
	 */
	private ResultSet rs;
	/**
	 * url a la que se conecta la BD.
	 */
	private String url;
	/**
	 * usuario con el que conecta a BD.
	 */
	private String username;
	/**
	 * pass con el que conecta a BD.
	 */
	private String password;
	/**
	 * la instancia de la conexion a base de datos.
	 */
	public static final ConexionBD INSTANCE = new ConexionBD();
	/**
	 * Logger de la clase.
	 */
	private static final Logger LOGGER = Logger.getLogger(ConexionBD.class);

	/**
	 * Constructor por defecto.
	 * 
	 * @since 1.0
	 */
	private ConexionBD() {

	}

	/**
	 * realiza la conexi\u00F3n a base de datos mediante parametros (props).
	 * 
	 * @since 1.0
	 * @param driver
	 *            el driver para conectar a BD.
	 * @param url
	 *            la ruta de conexión a BD.
	 * @param user
	 *            el usuario para autenticar a BD si no hay definir en vacio.
	 * @param pass
	 *            el password para autenticar en BD si no hay definir en vacio.
	 */
	public void conectarBD(String driver, String url, String user, String pass) {
		try {
			Class.forName(driver);
			this.url = url;
			this.username = user;
			this.password = pass;
			this.con = DriverManager.getConnection(this.url, this.username,
					this.password);
		} catch (Exception e) {
			throw new ExcepcionTecnica(e);
		}
	}

	/**
	 * Permite obtener la ruta del archivo de importación independiente del
	 * medio de ejecución.
	 * 
	 * @param path
	 *            la ruta relativa dentro del jar.
	 * @return el archivo de importación.
	 */
	private File obtenerArchivoImport(URL path) {
		try {
			if (path.getProtocol().equals(ConstanteGlobal.FILE)) {
				File f = new File(path.toURI());
				LOGGER.info(f.getAbsolutePath());
				return f;
			} else {
				File pos = new File(ConstanteGlobal.PUNTO).getAbsoluteFile();
				LOGGER.info(pos);
				return new File(pos.getAbsolutePath().substring(
						0,
						pos.getAbsolutePath()
								.lastIndexOf(ConstanteGlobal.PUNTO))
						+ ConstanteGlobal.IMPORT);
			}
		} catch (URISyntaxException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Método que permite la lectura de un archivo .sql y mediante este se
	 * ejecuten una serie de sentencias SQL para crear/actualizar la base de
	 * datos. Ignora la presencia de SQL erroneos y ejecuta hata el final.
	 * 
	 * @since 1.0
	 * @param bandera
	 *            si posee está bandera finaliza la ejecución del archivo de
	 *            importación al detectar un error.
	 * @throws Exception
	 *             cuando ocurre un error en la logica interna.
	 * @throws SQLException
	 *             si alguna sentencia falla.
	 */
	public void executeImport(Boolean bandera) throws ExcepcionTecnica {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			URL path = ConexionBD.class.getResource(ConstanteGlobal.IMPORT);
			File f = obtenerArchivoImport(path);
			fr = new FileReader(f);
			String s = ConstanteGlobal.BLANCO;
			StringBuffer sb = new StringBuffer();
			// Asegurarse de no tener comentarios en el .sql
			br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();
			// Se hace split mediante ; en las instrucciones
			String[] inst = sb.toString().split(ConstanteGlobal.PUNTO_Y_COMA);
			st = con.createStatement();
			int max = inst.length;
			for (int i = 0; i < max; i++) {
				try {
					// para asegurarse de no ejecutar sentencias vacias.
					if (!inst[i].trim().equals(ConstanteGlobal.BLANCO)) {
						st.executeUpdate(inst[i]);
						LOGGER.info(ConstanteGlobal.SYS_OUT + inst[i]);
					}
				} catch (SQLException sql) {
					LOGGER.error(ConstanteGlobal.SYS_OUT + sql.getMessage(),
							sql);
					if (bandera) {
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new ExcepcionTecnica(e.getMessage(), e);
		} finally {
			cerrarImport(fr, br, st);
		}
	}

	/**
	 * Permite cerrar adecuamente los recursos utilizados en la importación de
	 * SQL.
	 * 
	 * @param fr
	 *            el filereader.
	 * @param br
	 *            el bufferedreader.
	 * @param s
	 *            el statement.
	 */
	private void cerrarImport(FileReader fr, BufferedReader br, Statement s) {
		if (fr != null) {
			try {
				fr.close();
			} catch (IOException ioe) {
				LOGGER.error(ioe.getMessage(), ioe);
			}
		}

		if (br != null) {
			try {
				br.close();
			} catch (IOException ioe) {
				LOGGER.error(ioe.getMessage(), ioe);
			}
		}

		if (s != null) {
			try {
				s.close();
			} catch (SQLException ioe) {
				LOGGER.error(ioe.getMessage(), ioe);
			}
		}
	}

	/**
	 * Cierra los objetos asociados a la consulta en BD.
	 * 
	 * @since 1.0
	 */
	public void cerrarConsulta() {

		if (this.rs != null) {
			try {
				this.rs.close();
			} catch (SQLException ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		}

		if (this.pst != null) {
			try {
				this.pst.close();
			} catch (SQLException ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		}

		if (this.st != null) {
			try {
				this.st.close();
			} catch (SQLException ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		}
	}

	/**
	 * Desconecta de la base de datos.
	 * 
	 * @since 1.0
	 */
	public void desconectarBD() {
		cerrarConsulta();

		if (this.con != null) {
			try {
				this.con.close();
			} catch (SQLException ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		}
	}

	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}

	/**
	 * @param con
	 *            the con to set
	 */
	public void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * @return the pst
	 */
	public PreparedStatement getPst() {
		return pst;
	}

	/**
	 * @param pst
	 *            the pst to set
	 */
	public void setPst(PreparedStatement pst) {
		this.pst = pst;
	}

	/**
	 * @return the st
	 */
	public Statement getSt() {
		return st;
	}

	/**
	 * @param st
	 *            the st to set
	 */
	public void setSt(Statement st) {
		this.st = st;
	}

	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}

	/**
	 * @param rs
	 *            the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the instance
	 */
	public static ConexionBD getInstance() {
		return INSTANCE;
	}

}
