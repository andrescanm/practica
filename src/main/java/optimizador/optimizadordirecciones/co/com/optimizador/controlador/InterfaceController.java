package optimizador.optimizadordirecciones.co.com.optimizador.controlador;

import optimizador.optimizadordirecciones.co.com.optimizador.util.JPaginateTable;


/**
 * 
 * @author Carol Becerra
 * @version 1.0
 * 
 */
public interface InterfaceController {

	/**
	 * Construye la vista inicial del Panel.
	 */
	public void buildVistaInicial();

	/**
	 * Limpia los campos gestionables.
	 */
	public void clearFields();

	/**
	 * Define el modelo a crear de tabla.
	 * 
	 * @param tabla
	 *            la tabla a definir.
	 */
	public void setTableModel(JPaginateTable tabla);

	/**
	 * Llena con datos la tabla.
	 * 
	 * @param tabla
	 *            la tabla a poblar.
	 */
	public void fillTable(JPaginateTable tabla);

	/**
	 * Almacena valores en BD.
	 */
	public void eventoGuardar();

	/**
	 * Actualiza valores en BD.
	 */
	public void eventoActualizar();

	/**
	 * Elimina valores en BD.
	 */
	public void eventoEliminar();

	/**
	 * Consulta valores en BD.
	 */
	public void eventoConsultar();

}
