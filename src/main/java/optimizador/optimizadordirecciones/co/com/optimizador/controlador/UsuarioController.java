package optimizador.optimizadordirecciones.co.com.optimizador.controlador;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.dto.ParametroDto;
import optimizador.optimizadordirecciones.co.com.optimizador.entidades.Usuario;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.OpcionMenu;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.RolEnum;
import optimizador.optimizadordirecciones.co.com.optimizador.modelo.UsuarioEjb;
import optimizador.optimizadordirecciones.co.com.optimizador.principal.UsuarioView;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JOptionListBox;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JOptionUtil;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JPaginateTable;
import optimizador.optimizadordirecciones.co.com.optimizador.util.UtilidadValidador;

/**
 * 
 * @author Carol Becerra
 * @version 1.0
 */
public class UsuarioController implements InterfaceController {
	/**
	 * La instancia definida para la vista.
	 */
	private UsuarioView view;
	/**
	 * La instancia definida como modelo.
	 */
	private UsuarioEjb modelo;
	/**
	 * La instancia definida de la clase.
	 */
	private static final UsuarioController INSTANCE = new UsuarioController();
	/**
	 * Instancia del logger para almacenar la traza de la App.
	 */
	private static final Logger LOGGER = LogManager
			.getLogger(UsuarioController.class);

	/**
	 * Constructor por Defecto.
	 */
	private UsuarioController() {
		this.modelo = UsuarioEjb.getInstance();
		this.view = UsuarioView.getInstance();
		buildVistaInicial();
	}

	/**
	 * Instancia un objeto de esta clase.
	 * 
	 * @param vista
	 *            la vista definida para la clase.
	 * @param modelo
	 *            el modelo definido para la clase.
	 */
	private UsuarioController(UsuarioView vista, UsuarioEjb modelo) {
		this.view = vista;
		this.modelo = modelo;
		buildVistaInicial();
	}

	
	public void buildVistaInicial() {
		try {
			fillCombo();
			startButtons(false);
			startTable();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Inicializa los combos.
	 */
	public void fillCombo() {
		view.getComboCargo().removeAll();
		for (RolEnum re : RolEnum.values()) {
			view.getComboCargo().addItem(re);
		}
	}

	/**
	 * Inicializa y crea la tabla.
	 */
	public void startTable() {
		setTableModel(view.getTableUsuario());
		fillTable(view.getTableUsuario());
	}

	/**
	 * @param flag
	 *            habilita/deshabilita los botones.
	 */
	public void startButtons(boolean flag) {
		view.getbActualizar().setEnabled(flag);
		view.getbEliminar().setEnabled(flag);
		view.getbGuardar().setEnabled(!flag);
	}

	/**
	 * Obtiene los datos del formulario y los mapea a un DTO.
	 * 
	 * @return el dto si supera el proceso de validacion.
	 */
	public Usuario getDataFromForm() {
		Usuario datos = null;
		try {
			datos = new Usuario();
			String textoLabel = view.getLabelPk().getText();
			Long id = (textoLabel != null
					&& !textoLabel.equals(ConstanteGlobal.BLANCO) ? Long
					.parseLong(textoLabel.trim())
					: (long) (System.nanoTime() * (Math.random())));
			datos.setCodigoUsuario(id);
			datos.setNombres(view.getTextPNombre().getText().trim());
			datos.setApellidos(view.getTextPApellido().getText().trim());
			datos.setUsuario(view.getTextUserName().getText().trim());
			datos.setPassword(new String(view.getTextPass().getPassword())
					.trim());
			datos.setArea(view.getTextArea().getText().trim());
			datos.setCargo(((RolEnum) view.getComboCargo().getSelectedItem())
					.getCode());
			return datos;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Llena los campos del formulario con lo obtenido en base de datos.
	 * 
	 * @param dto
	 *            el resultado obtenido de base de datos.
	 */
	public void setFields(Usuario dto) {
		view.getLabelPk().setText(String.valueOf(dto.getCodigoUsuario()));
		view.getTextPNombre().setText(dto.getNombres());
		view.getTextPApellido().setText(dto.getApellidos());
		view.getTextUserName().setText(dto.getUsuario());
		view.getTextPass().setText(dto.getPassword());
		for (RolEnum re : RolEnum.values()) {
			if (re.getCode().equals(dto.getCargo())) {
				view.getComboCargo().setSelectedItem(re);
			}
		}
		view.getTextArea().setText(dto.getArea());
	}

	
	public void clearFields() {
		view.getLabelPk().setText(ConstanteGlobal.BLANCO);
		view.getTextPNombre().setText(ConstanteGlobal.BLANCO);
		view.getTextPApellido().setText(ConstanteGlobal.BLANCO);
		view.getTextUserName().setText(ConstanteGlobal.BLANCO);
		view.getTextPass().setText(ConstanteGlobal.BLANCO);
		view.getTextArea().setText(ConstanteGlobal.BLANCO);
		fillCombo();
	}

	
	@SuppressWarnings("rawtypes")
	public void setTableModel(JPaginateTable tabla) {
		Class[] types = new Class[] { java.lang.Object.class,
				java.lang.Object.class, java.lang.Object.class,
				java.lang.Object.class, java.lang.Object.class,
				java.lang.Object.class };
		tabla.setTableModel(ConstantesInterfaz.getTablaUsuario(), types);
		tabla.setItemsPerPage(ConstantesInterfaz.LIMITE_TABLA_PAG);
	}

	
	public void fillTable(JPaginateTable tabla) {
		List<Usuario> listaBD = modelo.list();
		DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
		int tam;
		tam = dtm.getRowCount();
		for (int i = 0; i < tam; i++) {
			dtm.removeRow(dtm.getRowCount() - 1);
		}
		if (listaBD != null) {
			for (int i = 0; i < listaBD.size(); i++) {
				dtm.addRow(new Object[1]);
				dtm.setValueAt(
						String.valueOf(listaBD.get(i).getCodigoUsuario()), i, 0);
				dtm.setValueAt(listaBD.get(i).getNombres(), i, 1);
				dtm.setValueAt(listaBD.get(i).getApellidos(), i, 2);
				dtm.setValueAt(listaBD.get(i).getUsuario(), i, 3);
				dtm.setValueAt(listaBD.get(i).getCargo(), i, 4);
				dtm.setValueAt(listaBD.get(i).getArea(), i, 5);
			}
		}
		tabla.setPaginateSorter(new TableRowSorter<TableModel>(dtm));
		tabla.setRowSorter(tabla.getPaginateSorter());
		tabla.initFilterAndButton(tabla.getPaginateSorter(),
				tabla.getItemsPerPage());
	}

	
	public void eventoGuardar() {
		try {
			Usuario datos = getDataFromForm();
			if (mensajeValidacion(datos, ConstantesInterfaz.E_MSJ_NO_ADMIN)) {
				modelo.save(datos);
				accionPosBoton(datos, ConstantesInterfaz.I_MSJ_GUARDADO,
						Boolean.FALSE);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			JOptionUtil.mostrarMensajeError(e.getMessage());
		}
	}

	/**
	 * Toma los datos del formulario y los actualiza en base de datos.
	 */
	public void eventoActualizar() {
		try {
			Usuario datos = getDataFromForm();
			if (mensajeValidacion(datos, ConstantesInterfaz.E_MSJ_NO_ADMIN)) {
				modelo.update(datos);
				accionPosBoton(datos, ConstantesInterfaz.I_MSJ_ACTUALIZADO,
						Boolean.TRUE);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			JOptionUtil.mostrarMensajeError(e.getMessage());
		}
	}

	/**
	 * Toma los datos del formulario y los actualiza en base de datos.
	 */
	public void eventoEliminar() {
		try {
			Usuario datos = getDataFromForm();
			if (mensajeValidacion(datos, ConstantesInterfaz.E_MSJ_ELIM_ADMIN)) {
				modelo.delete(datos);
				accionPosBoton(datos, ConstantesInterfaz.I_MSJ_BORRADO,
						Boolean.TRUE);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			JOptionUtil.mostrarMensajeError(e.getMessage());
		}
	}

	/**
	 * Busca mediante los datos ingresados el usuario correspondiente.
	 */
	public void eventoConsultar() {
		try {
			List<ParametroDto> param = modelo.suggest();
			JOptionListBox jolb = new JOptionListBox(param,
					ConstantesInterfaz.JOP_TITULO_BUSCAR,
					ConstantesInterfaz.LABEL_U_USER);
			ParametroDto id = jolb.getSelectedValue();
			if (id != null) {
				Usuario u = modelo.search(id.getId());
				if (u != null) {
					setFields(u);
					startButtons(true);
				} else {
					JOptionUtil
							.mostrarMensajeError(ConstantesInterfaz.E_MSJ_INESPERADO);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			JOptionUtil.mostrarMensajeError(e.getMessage());
		}
	}

	/**
	 * permite regresar a la ventana principal.
	 */
	public static void eventoVolver() {
		PrincipalController.getInstance().sendRedirect(OpcionMenu.LOGIN.name(),
				ConstantesInterfaz.TITULO_LOGIN);
	}

	/**
	 * Valida que los datos ingresados sean correctos.
	 * 
	 * @param datos
	 *            objeto a validar.
	 * @return TRUE si los campos obligatorios han sido diligenciados.
	 */
	private Boolean validateData(Usuario datos) {
		return (datos != null
				&& !UtilidadValidador.vacioNulo(datos.getNombres())
				&& !UtilidadValidador.vacioNulo(datos.getApellidos())
				&& !UtilidadValidador.vacioNulo(datos.getUsuario())
				&& !UtilidadValidador.vacioNulo(datos.getPassword())
				&& !UtilidadValidador.vacioNulo(datos.getCargo()) && !UtilidadValidador
					.vacioNulo(datos.getArea()));
	}

	/**
	 * Permite procesar posibles escenarios y mostrar un mensaje de acuerdo a
	 * ello.
	 * 
	 * @param datos
	 *            los datos a procesar.
	 * @param msjAdmin
	 *            mensaje a mostrar.
	 * @return TRUE si supera las pruebas.
	 */
	private Boolean mensajeValidacion(Usuario datos, String msjAdmin) {
		if (validateData(datos)
				&& !datos.getCargo().equals(RolEnum.ADMINISTRADOR.getCode())) {
			return Boolean.TRUE;
		} else if (!validateData(datos)) {
			JOptionUtil.mostrarMensajeError(ConstantesInterfaz.E_MSJ_DATOS);
			return Boolean.FALSE;
		} else if (datos.getCargo().equals(RolEnum.ADMINISTRADOR.getCode())) {
			JOptionUtil.mostrarMensajeError(msjAdmin);
			return Boolean.FALSE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Acciones luego de guardar/editar/eliminar.
	 * 
	 * @param datos
	 *            los datos del usuario.
	 * @param msj
	 *            el mensaje a mostrar.
	 * @param botones
	 *            indica si habilita o no los botones.
	 */
	private void accionPosBoton(Usuario datos, String msj, Boolean botones) {
		String msg = msj + datos.getUsuario();
		LOGGER.info(msg);
		fillTable(view.getTableUsuario());
		JOptionUtil.mostrarMensajeApp(ConstantesInterfaz.JOP_TITULO_EXITO, msg,
				JOptionPane.INFORMATION_MESSAGE);
		PrincipalController.getInstance().setReload(Boolean.TRUE);
		clearFields();
		if (botones) {
			startButtons(false);
		}
	}

	/**
	 * @return the view
	 */
	public UsuarioView getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(UsuarioView view) {
		this.view = view;
	}

	/**
	 * @return the modelo
	 */
	public UsuarioEjb getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(UsuarioEjb modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the instance
	 */
	public static UsuarioController getInstance() {
		return INSTANCE;
	}

}
