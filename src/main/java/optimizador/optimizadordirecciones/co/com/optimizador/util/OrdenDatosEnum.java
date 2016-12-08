package optimizador.optimizadordirecciones.co.com.optimizador.util;

import java.util.Comparator;
import optimizador.optimizadordirecciones.co.com.optimizador.entidades.Predio;


/**
 * Ordena los resultados.
 * 
 * @author Great System Development Dynamic <GSDD> <br>
 *         Alexander Galvis Grisales <br>
 *         alex.galvis.sistemas@gmail.com <br>
 * @version 1.0
 * @since 2015-11-16
 */
public enum OrdenDatosEnum implements Comparator<Predio> {


	LONGITUD_SORT {
		@Override
		public int compare(Predio o1, Predio o2) {
                    
                    return Double.compare(o1.getLongitud(), o2.getLongitud());
		}
	},
	LATITUD_SORT {
		@Override
		public int compare(Predio o1, Predio o2) {
			return Double.compare(o1.getLatitud(), o2.getLatitud());
		}
	};


	/**
	 * Ordena de manera descendente.
	 * 
	 * @since 1.0
	 * @param other
	 *            comparador.
	 * @return obtiene descendiente.
	 */
	public static Comparator<Predio> decending(
			final Comparator<Predio> other) {
		return (Predio o1, Predio o2) -> -1 * other.compare(o1, o2);
	};

	/**
	 * Ordena de manera ascendente.
	 * 
	 * @since 1.0
	 * @param other
	 *            comparador.
	 * @return obtiene ascendiente.
	 */
	public static Comparator<Predio> ascending(
			final Comparator<Predio> other) {
		return (Predio o1, Predio o2) -> other.compare(o1, o2);
	};

	/**
	 * Obtiene los comparadores adecuados para efectuar el ordenamiento simple o
	 * multiple.
	 * 
	 * @since 1.0
	 * @param multipleOptions
	 *            opciones de comparacion.
	 * @return el comparador.
	 */
	public static Comparator<Predio> getComparator(
			final OrdenDatosEnum... multipleOptions) {
		return new Comparator<Predio>() {
			@Override
			public int compare(Predio o1, Predio o2) {
				for (OrdenDatosEnum option : multipleOptions) {
					int result = option.compare(o1, o2);
					if (result != 0) {
						return result;
					}
				}
				return 0;
			}
		};
	}

}

/*
Invocar...

// Ordena por DOC_REF y VALOR
Collections.sort(lista de tu_objeto, OrdenDatosEnum.decending(OrdenDatosEnum
				.getComparator(OrdenDatosEnum.DOCREF_SORT,
						OrdenDatosEnum.VALOR_SORT)));
*/