package optimizador.optimizadordirecciones.co.com.optimizador.constante;

/**
 * Constantes generales que son ampliamente usadas en otros desplegables.
 * 
 * @author Andres Cañón
 * @version 1.0
 * 
 */
public final class ConstanteGlobal {

	/**
	 * Para denotar aproximación.
	 */
	public static final String APROX = "~";
	/**
	 * Para denotar asterisco.
	 */
	public static final String AST = "*";
	/**
	 * Para denotar el vacio.
	 */
	public static final String BLANCO = "";
	/**
	 * Para denotar espacio en blanco.
	 */
	public static final String ESPACIO_BLANCO = " ";
	/**
	 * Usado como Split o separador.
	 */
	public static final String COMA = ",";
	/**
	 * Corchete Abre.
	 */
	public static final String CORCHETE_ABRE = "[";
	/**
	 * Corchete Cierra.
	 */
	public static final String CORCHETE_CIERRA = "]";
	/**
	 * Para algunos datos de muestra.
	 */
	public static final String DOS_PUNTOS = " : ";
	/**
	 * Tipo de ejecución local (IDE).
	 */
	public static final String FILE = "file";
	/**
	 * Para algunos datos de muestra.
	 */
	public static final String GUION_PISO = "_";
	/**
	 * Simbolo de igualdad.
	 */
	public static final String IGUAL = "=";
	/**
	 * Llave abre.
	 */
	public static final String LLAVE_ABRE = "{";
	/**
	 * Llave cierra.
	 */
	public static final String LLAVE_CIERRA = "}";
	/**
	 * utilizado como comodin de busqueda en query.
	 */
	public static final String PORCENTAJE = "%";
	/**
	 * utilizado como separador de querys (import).
	 */
	public static final String PUNTO = ".";
	/**
	 * utilizado como separador de querys (import).
	 */
	public static final String PUNTO_Y_COMA = ";";
	/**
	 * separador de algunas URL o directorios.
	 */
	public static final String SLASH = "/";
	/**
	 * Para salida de sistema.
	 */
	public static final String SYS_IN = "<<";
	/**
	 * Para salida de sistema.
	 */
	public static final String SYS_OUT = ">>";
	/**
	 * utilizado como tabulador en la app.
	 */
	public static final String TAB = "\n";
	/**
	 * Usada para hacer encodind de texto.
	 */
	public static final String TEXT_ENCODING_UTF8 = "UTF-8";
	
	// Carga de datos
	/**
	 * para importar en BD.
	 */
	public static final String IMPORT = "/sql/import.sql";
	/**
	 * para el logger.
	 */
	public static final String LOG4J = "/logger/log4j.properties";
	
	// Conexión bd
	public static final String DERBY_CONNECTION = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String DERBY_LOCATION = "jdbc:derby:.\\optimizador\\odd.DB;create=true";
	public static final String DERBY_MAIN_TABLE = "usuario";
	public static final String FALLO = "[FALLO]";
	public static final String OK = "[OK]";
	
	// Titulo de las ventanas
	public static final String EXITO = "Éxito";
	public static final String ERROR = "Error";

	/**
	 * Constructor por defecto.
	 */
	private ConstanteGlobal() {

	}

}