package optimizador.optimizadordirecciones.co.com.optimizador.dto;

import java.io.Serializable;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteNumerica;

/**
 * Utilizado por el paquete servicios. Se usa para recibir objetos genericos que
 * pueden ser descritos por la llave id, valor.
 * 
 * @author Andres Cañón
 * @version 1.0
 * @date 2015-04-04
 */
public class ParametroDto implements Serializable {

	/**
	 * version serializada por defecto.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id del objeto.
	 */
	private Long id;

	/**
	 * nombre del objeto.
	 */
	private String valor;

	/**
	 * Constructor por defecto.
	 */
	public ParametroDto() {
		super();
	}

	/**
	 * @param id
	 *            el id a setear.
	 */
	public ParametroDto(Long id) {
		this.id = id;
	}

	/**
	 * @param id
	 *            el id a setear.
	 * @param valor
	 *            el valor a obtener.
	 */
	public ParametroDto(Long id, String valor) {
		this.id = id;
		this.valor = valor;
	}

	/**
	 * @param id
	 *            el id a setear.
	 * @param valor1
	 *            el valor a obtener.
	 * @param valor2
	 *            el valor a obtener.
	 */
	public ParametroDto(Long id, String valor1, String valor2) {
		this.id = id;
		this.valor = valor1 + ConstanteGlobal.COMA + valor2;
	}

	/**
	 * Con este método mostrará el valor en el JComboBox.
	 */
	@Override
	public String toString() {
		return valor;
	}

	/**
	 * Genera el código hash del objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = ConstanteNumerica.NUMERO_TREINTA_Y_UNO;
		int result = ConstanteNumerica.NUMERO_UNO;
		result = prime
				* result
				+ ((id == null) ? ConstanteNumerica.NUMERO_CERO : id.hashCode());
		result = prime
				* result
				+ ((valor == null) ? ConstanteNumerica.NUMERO_CERO : valor
						.hashCode());
		return result;
	}

	/**
	 * Con este método validará si los objetos a analizar son o no iguales.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (!(o instanceof ParametroDto)) {
			return false;
		}
		ParametroDto p = (ParametroDto) o;

		if (id != p.id) {
			return false;
		}
		if (valor != null ? !valor.equals(p.valor) : p.valor != null) {
			return false;
		}
		return true;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

}
