package optimizador.optimizadordirecciones.co.com.optimizador.controlador;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.entidades.Usuario;
import optimizador.optimizadordirecciones.co.com.optimizador.modelo.UsuarioEjb;
import optimizador.optimizadordirecciones.co.com.optimizador.principal.LoginView;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JOptionUtil;

/**
 * 
 * @author Andres Cañón
 * @version 1.0
 */
public class LoginController {
	/**
	 * la instancia obtenida de la vista.
	 */
	private LoginView view;
	/**
	 * la instancia obtenida del modelo.
	 */
	private UsuarioEjb modelo;
	/**
	 * lleva los datos de sesi\u00f3n.
	 */
	private Usuario dto;
	/**
	 * La instancia definida de la clase.
	 */
	private static final LoginController INSTANCE = new LoginController();
	/**
	 * Instancia del logger para almacenar la traza de la App.
	 */
	private static final Logger LOGGER = LogManager
			.getLogger(LoginController.class);

	/**
	 * Constructor por Defecto.
	 */
	private LoginController() {
		this.view = LoginView.getInstance();
	}

	/**
	 * Instancia un objeto de esta clase.
	 * 
	 * @param vista
	 *            la vista definida para la clase.
	 * @param modelo
	 *            el modelo definido para la clase.
	 */
	private LoginController(LoginView vista, UsuarioEjb modelo) {
		this.view = vista;
		this.modelo = modelo;
	}

	/**
	 * limpia los campos de texto.
	 */
	public void clearText() {
		view.getTextUsuario().setText(ConstanteGlobal.BLANCO);
		view.getTextPass().setText(ConstanteGlobal.BLANCO);
	}

	/**
	 * @param flag
	 *            indica si los componentes se ven o no.
	 */
	public void enableComponents(boolean flag) {
		view.getLabelUsuario().setVisible(flag);
		view.getLabelPass().setVisible(flag);
		view.getTextUsuario().setVisible(flag);
		view.getTextPass().setVisible(flag);
		view.getBtnIngresar().setVisible(flag);
	}

	/**
	 * accion de logeado.
	 */
	public void getLoged() {
		enableComponents(false);
	}

	/**
	 * estado inicial del panel.
	 */
	public void getInit() {
		clearText();
		PrincipalController.getInstance().getView().getMenuSesion()
				.setText(ConstanteGlobal.BLANCO);
		enableComponents(true);
	}

	/**
	 * logea al usuario en el sistema.
	 */
	public void autenticar() {
		try {
			// Primer conexion con BD Lenta?
			this.modelo = UsuarioEjb.getInstance();
			String username = view.getTextUsuario().getText().trim();
			// Encripta el valor ingresado
			String pass = new String(view.getTextPass().getPassword()).trim();
			LOGGER.info(pass);
			dto = modelo.login(username, pass);
			if (dto != null) {
				// acciones de seteo de login.
				getLoged();
				dto.setUsuario(username);
				PrincipalController.getInstance().changeTitle(
						ConstantesInterfaz.TITULO_LOGIN);
				String sesion = ConstantesInterfaz.LABEL_LOGGED
						+ dto.getNombres()
						+ ConstanteGlobal.ESPACIO_BLANCO
						+ dto.getApellidos();
				PrincipalController.getInstance().getView().getMenuSesion()
						.setText(sesion);
				PrincipalController.getInstance().getLoControl().setDto(dto);
			} else {
				LOGGER.info(ConstantesInterfaz.E_MSJ_NO_EXISTE);
				JOptionUtil
						.mostrarMensajeError(ConstantesInterfaz.E_MSJ_NO_EXISTE);
				view.getTextPass().setText(ConstanteGlobal.BLANCO);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			JOptionUtil.mostrarMensajeError(e.getMessage());
		}
	}

	/**
	 * @return the view
	 */
	public LoginView getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(LoginView view) {
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
	 * @return the dto
	 */
	public Usuario getDto() {
		return dto;
	}

	/**
	 * @param dto
	 *            the dto to set
	 */
	public void setDto(Usuario dto) {
		this.dto = dto;
	}

	/**
	 * @return the instance
	 */
	public static LoginController getInstance() {
		return INSTANCE;
	}

}
