package optimizador.optimizadordirecciones.co.com.optimizador.constante;

/**
 * Consultas a base de datos.
 * 
 * @author Carol Becerra
 * @version 1.0
 * 
 */
public final class ConstantesQuery {

	// DELETE QUERY
	public static final String DELETE_USER = "DELETE FROM usuario WHERE codigousuario = ?";

	// INSERT QUERY
	public static final String INSERT_USER = "INSERT INTO usuario VALUES (?,?,?,?,?,?,?)";
	public static final String INSERT_PREDIO = "INSERT INTO predio VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	// LIST QUERY
	public static final String LISTAR_USUARIOS = "SELECT codigousuario, nombres, apellidos, username, password, cargo, area "
			+ "FROM usuario ORDER BY nombres, apellidos";
	public static final String LISTAR_PREDIOS = "SELECT * "
			+ "FROM predio ORDER BY suscritor";
	// SP QUERY
	public static final String LOGIN = "SELECT codigousuario, nombres, apellidos, cargo "
			+ "FROM usuario WHERE username = ? AND password = ?";

	// SEARCH QUERY
	public static final String SEARCH_USER = "SELECT codigousuario, nombres, apellidos, username, password, cargo, area "
			+ "FROM usuario WHERE codigousuario = ?";

	// UPDATE QUERY
	public static final String UPDATE_USER = "UPDATE usuario SET nombres = ?, apellidos = ?, "
			+ "username = ?, password = ?, cargo = ?, area = ? WHERE codigousuario = ?";
	// VALIDATION QUERY
	public static final String VALIDAR_DATA = "SELECT COUNT(*) FROM usuario";

	/**
	 * Constructor por defecto.
	 */
	private ConstantesQuery() {

	}

}
