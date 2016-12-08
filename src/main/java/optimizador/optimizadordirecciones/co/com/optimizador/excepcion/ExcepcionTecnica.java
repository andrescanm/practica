package optimizador.optimizadordirecciones.co.com.optimizador.excepcion;

/**
 * Esta clase crea una excepción propia para manejo de eventos de error en
 * aplicación. Estos errores pueden ser lanzados cuando se violen reglas del
 * negocio y cuando ocurran problemas inesperados.
 * 
 * @author Andres Cañón
 * @version 1.0
 * 
 */
public class ExcepcionTecnica extends RuntimeException {
	/**
	 * Version serial de la clase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor mediante excepcion lanzada y mensaje personalizado.
	 * 
	 * @since 1.0
	 * @param mensaje
	 *            el mensaje de error.
	 * @param causa
	 *            la causa del error.
	 */
	public ExcepcionTecnica(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

	/**
	 * Constructor con mensaje del error.
	 * 
	 * @since 1.0
	 * @param mensaje
	 *            el mensaje de error.
	 */
	public ExcepcionTecnica(String mensaje) {
		super(mensaje);
	}

	/**
	 * Constructor con objeto de excepción lanzada.
	 * 
	 * @since 1.0
	 * @param causa
	 *            la causa del error.
	 */
	public ExcepcionTecnica(Throwable causa) {
		super(causa);
	}
}