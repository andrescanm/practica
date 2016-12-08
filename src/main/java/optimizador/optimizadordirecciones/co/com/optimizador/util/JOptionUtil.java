package optimizador.optimizadordirecciones.co.com.optimizador.util;

import javax.swing.JOptionPane;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;

/**
 * Permite construir mensajes de manera gráfica para las aplicaciones GUI.
 * 
 * @author Yesid Ferrer
 * @version 1.0
 * 
 */
public final class JOptionUtil {

	/**
	 * Constructor por defecto.
	 */
	private JOptionUtil() {

	}

	/**
	 * Invoca un JOptionPane con un mensaje y titulo definidos.
	 * 
	 * @since 1.0
	 * @param titulo
	 *            el titulo a asignar.
	 * @param msj
	 *            el mensaje a mostrar.
	 * @param messageType
	 *            el tipo de mensaje a mostrar.
	 */
	public static void mostrarMensajeApp(String titulo, Object msj, int messageType) {
		JOptionPane.showMessageDialog(null, msj, titulo, messageType);
	}

	/**
	 * Invoca un JOptionPane para mostrar mensajes de éxito.
	 * 
	 * @since 1.0
	 * @param msj
	 *            el mensaje a mostrar.
	 */
	public static void mostrarMensajeInfo(String msj) {
		mostrarMensajeApp(ConstanteGlobal.EXITO, msj, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Invoca un JOptionPane para mostrar mensajes de error.
	 * 
	 * @since 1.0
	 * @param msj
	 *            el mensaje a mostrar.
	 */
	public static void mostrarMensajeError(String msj) {
		mostrarMensajeApp(ConstanteGlobal.ERROR, msj, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Retorna la entrada ingresada en el campo.
	 * 
	 * @since 1.0
	 * @param msj
	 *            el mensaje alusivo al dato que se espera.
	 * @return el valor ingresado.
	 */
	public static String mostrarMensajeEntrada(String msj) {
		return JOptionPane.showInputDialog(null, msj);
	}
}
