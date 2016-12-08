package optimizador.optimizadordirecciones.co.com.optimizador.enums;

/**
 * 
 * @author Andres Cañón
 * @version 1.0
 */
public enum RolEnum {
	ADMINISTRADOR("Administrador"), SUPERVISOR("Supervisor"), AFORADOR(
			"Aforador");

	/**
	 * Código que identifica al rol.
	 */
	private String code;

	/**
	 * Constructor.
	 * 
	 * @param cod
	 *            codigo asignado.
	 */
	private RolEnum(String cod) {
		this.code = cod;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

}
