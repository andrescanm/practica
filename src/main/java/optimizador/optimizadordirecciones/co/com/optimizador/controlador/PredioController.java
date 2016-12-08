package optimizador.optimizadordirecciones.co.com.optimizador.controlador;

import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.dto.ParametroDto;
import optimizador.optimizadordirecciones.co.com.optimizador.entidades.Predio;
import optimizador.optimizadordirecciones.co.com.optimizador.entidades.Usuario;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.OpcionMenu;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.RolEnum;
import optimizador.optimizadordirecciones.co.com.optimizador.modelo.PredioEjb;
import optimizador.optimizadordirecciones.co.com.optimizador.principal.PredioView;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JOptionListBox;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JOptionUtil;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JPaginateTable;
import optimizador.optimizadordirecciones.co.com.optimizador.util.LeerExcel;

/**
 * 
 * @author Carol Becerra
 * @version 1.0
 */
public class PredioController implements InterfaceController {
	/**
	 * La instancia definida para la vista.
	 */
	private PredioView view;
	/**
	 * La instancia definida como modelo.
	 */
	private PredioEjb modelo;
	/**
	 * La instancia definida de la clase.
	 */
	private static final PredioController INSTANCE = new PredioController();
	/**
	 * Instancia del logger para almacenar la traza de la App.
	 */
	private static final Logger LOGGER = LogManager
			.getLogger(PredioController.class);

	/**
	 * Constructor por Defecto.
	 */
	private PredioController() {
		this.modelo = PredioEjb.getInstance();
		this.view = PredioView.getInstance();
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
	private PredioController(PredioView vista, PredioEjb modelo) {
		this.view = vista;
		this.modelo = modelo;
		buildVistaInicial();
	}

	public void buildVistaInicial() {
		try {
			startButtons(false);
			startTable();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Inicializa y crea la tabla.
	 */
	public void startTable() {
		setTableModel(view.getTablePredio());
		fillTable(view.getTablePredio());
	}

	/**
	 * @param flag
	 *            habilita/deshabilita los botones.
	 */
	public void startButtons(boolean flag) {
		view.getbActualizar().setEnabled(flag);
		view.getbEliminar().setEnabled(flag);
		view.getbImportar().setEnabled(!flag);
	}

	
	public void clearFields() {

	}

	@SuppressWarnings("rawtypes")
	public void setTableModel(JPaginateTable tabla) {
		Class[] types = new Class[] { java.lang.Object.class,
				java.lang.Object.class, java.lang.Object.class,
				java.lang.Object.class, java.lang.Object.class,
				java.lang.Object.class, java.lang.Object.class,
				java.lang.Object.class, java.lang.Object.class,
				java.lang.Object.class, java.lang.Object.class,
				java.lang.Object.class, java.lang.Object.class,
				java.lang.Object.class, java.lang.Object.class };
		tabla.setTableModel(ConstantesInterfaz.getTablaPredio(), types);
		tabla.setItemsPerPage(ConstantesInterfaz.LIMITE_TABLA_PAG);
	}

	public void fillTable(JPaginateTable tabla) {
		List<Predio> listaBD = modelo.list();
		DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
		int tam;
		tam = dtm.getRowCount();
		for (int i = 0; i < tam; i++) {
			dtm.removeRow(dtm.getRowCount() - 1);
		}
		if (listaBD != null) {
			for (int i = 0; i < listaBD.size(); i++) {
				dtm.addRow(new Object[1]);
				dtm.setValueAt(listaBD.get(i).getIdContrato(), i, 0);
				dtm.setValueAt(listaBD.get(i).getIdPlan(), i, 1);
				dtm.setValueAt(listaBD.get(i).getLocalidad(), i, 2);
				dtm.setValueAt(listaBD.get(i).getSuscritor(), i, 3);
				dtm.setValueAt(listaBD.get(i).getVisitado(), i, 4);
				dtm.setValueAt(listaBD.get(i).getDireccion(), i, 5);
				dtm.setValueAt(listaBD.get(i).getVenAforo(), i, 6);
				dtm.setValueAt(listaBD.get(i).getNumHabitacionales(), i, 7);
				dtm.setValueAt(listaBD.get(i).getNumNoHabitaconales(), i, 8);
				dtm.setValueAt(listaBD.get(i).getProdBasura(), i, 9);
				dtm.setValueAt(listaBD.get(i).getNumSemana(), i, 10);
				dtm.setValueAt(listaBD.get(i).getTipoAforo(), i, 11);
				dtm.setValueAt(listaBD.get(i).getFrecuencia(), i, 12);
				dtm.setValueAt(listaBD.get(i).getHorario(), i, 13);
				dtm.setValueAt(listaBD.get(i).getObservaciones(), i, 14);
			}
		}
		tabla.setPaginateSorter(new TableRowSorter<TableModel>(dtm));
		tabla.setRowSorter(tabla.getPaginateSorter());
		tabla.initFilterAndButton(tabla.getPaginateSorter(),
				tabla.getItemsPerPage());
	}

	public void eventoGuardar() {
		/*
		 * try { Usuario datos = getDataFromForm(); if (mensajeValidacion(datos,
		 * ConstantesInterfaz.E_MSJ_NO_ADMIN)) { modelo.save(datos);
		 * accionPosBoton(datos, ConstantesInterfaz.I_MSJ_GUARDADO,
		 * Boolean.FALSE); } } catch (Exception e) {
		 * LOGGER.error(e.getMessage(), e);
		 * JOptionUtil.mostrarMensajeError(e.getMessage()); }
		 */
	}

	/**
	 * Toma los datos del formulario y los actualiza en base de datos.
	 */
	public void eventoActualizar() {
		/*
		 * try { Usuario datos = getDataFromForm(); if (mensajeValidacion(datos,
		 * ConstantesInterfaz.E_MSJ_NO_ADMIN)) { modelo.update(datos);
		 * accionPosBoton(datos, ConstantesInterfaz.I_MSJ_ACTUALIZADO,
		 * Boolean.TRUE); } } catch (Exception e) { LOGGER.error(e.getMessage(),
		 * e); JOptionUtil.mostrarMensajeError(e.getMessage()); }
		 */
	}

	/**
	 * Toma los datos del formulario y los actualiza en base de datos.
	 */
	public void eventoEliminar() {
		/*
		 * try { Usuario datos = getDataFromForm(); if (mensajeValidacion(datos,
		 * ConstantesInterfaz.E_MSJ_ELIM_ADMIN)) { modelo.delete(datos);
		 * accionPosBoton(datos, ConstantesInterfaz.I_MSJ_BORRADO,
		 * Boolean.TRUE); } } catch (Exception e) { LOGGER.error(e.getMessage(),
		 * e); JOptionUtil.mostrarMensajeError(e.getMessage()); }
		 */
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
					// setFields(u);
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
	 * Evento de importacion de datos.
	 */
	public void eventoImportar() {
		try {
			if (PrincipalController.getInstance().getLoControl().getDto() != null
					&& PrincipalController.getInstance().getLoControl()
							.getDto().getCargo()
							.equals(RolEnum.SUPERVISOR.getCode())) {
				String out = getDirectory(ConstantesInterfaz.JOP_TITULO_CHOOSER);
				if (out == null) {
					JOptionUtil.mostrarMensajeApp(
							ConstantesInterfaz.JOP_TITULO_EXPORTAR,
							ConstantesInterfaz.I_MSJ_EXPORTAR,
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					LeerExcel le = new LeerExcel();
					List<Predio> lo = le.readExcelData(out);
					PredioController.getInstance().almacenarPredioImportacion(
							lo);
					fillTable(view.getTablePredio());
					PrincipalController.getInstance().setReload(Boolean.TRUE);
					clearFields();
				}
			} else {
				JOptionUtil.mostrarMensajeError(ConstantesInterfaz.E_MSJ_LOGIN);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Permite almacenar masivamente los datos de predio de la aplicación.
	 * 
	 * @param datos
	 *            los datos recolectados e excel.
	 */
	private void almacenarPredioImportacion(List<Predio> datos) {
		if (datos != null && !datos.isEmpty()) {
			for (Predio p : datos) {
				LOGGER.info(p.toString());
				try {
					modelo.save(p);
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
			JOptionUtil.mostrarMensajeApp(ConstantesInterfaz.JOP_TITULO_EXITO,
					ConstantesInterfaz.I_MSJ_IMPORTAR,
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			LOGGER.info("Lista Vacia");
		}
	}

	/**
	 * Valida que los datos ingresados sean correctos.
	 * 
	 * @param datos
	 *            objeto a validar.
	 * @return TRUE si los campos obligatorios han sido diligenciados.
	 */
	private Boolean validateData(Predio datos) {
		return (datos != null);
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
		fillTable(view.getTablePredio());
		JOptionUtil.mostrarMensajeApp(ConstantesInterfaz.JOP_TITULO_EXITO, msg,
				JOptionPane.INFORMATION_MESSAGE);
		PrincipalController.getInstance().setReload(Boolean.TRUE);
		clearFields();
		if (botones) {
			startButtons(false);
		}
	}

	/**
	 * Obtiene el directorio en el cual se va a guardar los datos exportados
	 * desde la aplicación.
	 * 
	 * @param msj
	 *            , titulo del filechooser.
	 * @return la representación en cadena de texto de la ruta de salida.
	 */
	private String getDirectory(String msj) {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(ConstanteGlobal.PUNTO));
		// Titulo que llevara la ventana
		chooser.setDialogTitle(msj);
		// Elegiremos archivos del directorio
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		// Si seleccionamos algún archivo retornaremos su directorio
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath();
		} else {
			return null;
		}
	}

	/**
	 * @return the view
	 */
	public PredioView getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(PredioView view) {
		this.view = view;
	}

	/**
	 * @return the modelo
	 */
	public PredioEjb getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(PredioEjb modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the instance
	 */
	public static PredioController getInstance() {
		return INSTANCE;
	}

}
