package optimizador.optimizadordirecciones.co.com.optimizador.util;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.dto.ParametroDto;

/**
 * Permite crear un dialogo con elementos en lista para seleccionar determinado
 * elemento.
 * 
 * @author Yesid Ferrer
 * @version 1.0
 */
public class JOptionListBox {

	/**
	 * Lista de entradas.
	 */
	private List<ParametroDto> input;
	/**
	 * Seleccion de la salida.
	 */
	private ParametroDto output;
	/**
	 * Titulo para el joption.
	 */
	private String titulo;
	/**
	 * El criterio de busqueda.
	 */
	private String value;
	/**
	 * Logger de la clase.
	 */
	private static final Logger LOGGER = Logger.getLogger(JOptionListBox.class);

	/**
	 * @param input
	 *            la lista de objetos de entrada.
	 * @param titulo
	 *            para definir propiedades en titulos.
	 * @param value
	 *            el valor fijo a elegir.
	 */
	public JOptionListBox(List<ParametroDto> input, String titulo, String value) {
		this.input = input;
		this.titulo = titulo;
		this.value = value;
	}

	/**
	 * @return el valor seleccionado en la lista.
	 */
	public ParametroDto getSelectedValue() {
		try {
			ParametroDto[] choices = new ParametroDto[input.size()];
			int i = 0;
			for (ParametroDto dto : input) {
				choices[i] = dto;
				i++;
			}
			if (choices.length > 0) {
				String criterio = value + ConstanteGlobal.DOS_PUNTOS;
				this.output = (ParametroDto) JOptionPane.showInputDialog(null,
						criterio, titulo, JOptionPane.QUESTION_MESSAGE, null, // Use
																				// default
																				// icon
						choices, // Array of choices
						choices[0]); // Initial choice
				return output;
			} else {
				return null;
			}
		} catch (NullPointerException n) {
			LOGGER.error(n.getMessage(), n);
			return null;
		}
	}

}
