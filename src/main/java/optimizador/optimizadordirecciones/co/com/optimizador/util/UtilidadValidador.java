package optimizador.optimizadordirecciones.co.com.optimizador.util;

import java.util.List;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;

/**
 * 
 * @author Yesid Ferrer
 * @version 1.0
 * 
 */
public final class UtilidadValidador {

	/**
	 * Constructor privado
	 */
	private UtilidadValidador() {

	}

	/**
	 * Metodo que valida si un objeto es nulo.
	 * 
     * @param obj
	 * @return boolean con el resultado de la operacion.
	 */
	public static boolean esNulo(final Object obj) {
		return obj == null;
	}

	/**
	 * metodo que valida si un objeto es nulo o vacio
	 * 
	 * @param obj
	 *            el objeto a validar
	 * @return True si es nulo o vacio False si no es nulo y si contiene algun
	 *         valor
	 */
	public static boolean vacioNulo(final Object obj) {
		boolean result = Boolean.FALSE;
		if (obj == null) {
			result = Boolean.TRUE;
		} else if (obj instanceof String) {
			String objString = (String) obj;
			if (ConstanteGlobal.BLANCO.equals(objString.trim())) {
				result = Boolean.TRUE;
			}
		} else if (obj instanceof List<?>) {
            List<?> list = (List<?>) obj;
            if (list.isEmpty()) {
                result = Boolean.TRUE;
            }
        }
		return result;
	}

}
