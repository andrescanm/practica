package optimizador.optimizadordirecciones.co.com.optimizador.controlador;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.OpcionMenu;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.RolEnum;
import optimizador.optimizadordirecciones.co.com.optimizador.principal.PrincipalView;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JOptionUtil;

/**
 * 
 * @author Carol Becerra
 * @version 1.0
 */
public class PrincipalController {
	/**
	 * Administra los diferentes paneles de la App.
	 */
	private JPanel cards;
	/**
	 * El layout recomendado para el cambio panel.
	 */
	private CardLayout cl;
	/**
	 * la vista principal que se administra.
	 */
	private PrincipalView view;
	/**
	 * Obtiene los datos necesarios del control (login).
	 */
	private LoginController loControl;
	/**
	 * Bandera que indica que debe ser recargado algun elemento.
	 */
	private Boolean reload;
	/**
	 * Instancia del logger para almacenar la traza de la App.
	 */
	private static final Logger LOGGER = LogManager
			.getLogger(PrincipalController.class);
	/**
	 * 
	 */
	public static final PrincipalController INSTANCE = new PrincipalController();

	/**
	 * Constructor por Defecto.
	 */
	public PrincipalController() {
		reload = Boolean.FALSE;
		view = PrincipalView.getInstance();
	}

	/**
	 * construye la ventana a llenar con elementos.
	 */
	public void buildPrincipal() {
		reload = Boolean.FALSE;
		changeTitle(ConstantesInterfaz.TITULO_INICIO);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		view.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
		addPanel();
	}

	/**
	 * añade los paneles a la vista principal.
	 */
	public void addPanel() {
		this.loControl = LoginController.getInstance();
		cards = new JPanel(new CardLayout());
		cards.add(this.loControl.getView(), OpcionMenu.LOGIN.name());
		cl = (CardLayout) (cards.getLayout());
		cl.show(cards, OpcionMenu.LOGIN.name());
		view.getContentPane().add(cards);
	}

	/**
	 * cambia el titulo de la ventana.
	 * 
	 * @param title
	 *            el titulo de la ventana.
	 */
	public void changeTitle(String title) {
		view.setTitle(ConstantesInterfaz.TITULO_MAIN + title);
	}

	/**
	 * Método general de redirección.
	 * 
	 * @param panel
	 *            el panel a pintar(mostrar).
	 * @param titulo
	 *            el titulo a cambiar.
	 */
	public void sendRedirect(String panel, String titulo) {
		changeTitle(titulo);
		cl.show(cards, panel);
	}

	/**
	 * cierra la sesi\u00f3n .
	 */
	public void eventoSesion() {
		sendRedirect(OpcionMenu.LOGIN.name(), ConstantesInterfaz.TITULO_INICIO);
		// Elimina la sesión asociada
		loControl.setDto(null);
		loControl.getInit();
	}

	/**
	 * evento de clic en info.
	 */
	public void eventoInfo() {
		try {
			JTextArea areaMC = new JTextArea();
			areaMC.setVisible(true);
			areaMC.setEditable(false);
			areaMC.setText(ConstantesInterfaz.C_MSJ_INFO_A1
					+ ConstanteGlobal.TAB + ConstantesInterfaz.C_MSJ_INFO_A2);
			JOptionPane.showMessageDialog(null, areaMC,
					ConstantesInterfaz.C_MSJ_INFO_T,
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * evento de clic en predio.
	 */
	public void eventoPredio() {
		try {
			if (PrincipalController.getInstance().getLoControl().getDto() != null
					&& PrincipalController.getInstance().getLoControl().getDto()
					.getCargo().equals(RolEnum.SUPERVISOR.getCode())) {
				view.addPanel(PredioController.getInstance().getView(),
						OpcionMenu.PREDIO.name(),
						ConstantesInterfaz.TITULO_PREDIO);
			} else {
				JOptionUtil.mostrarMensajeError(ConstantesInterfaz.E_MSJ_LOGIN);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Evento del menu de usuario.
	 */
	public void eventoUsuario() {
		// Sólo puede ingresar a está vista el administrador
		if (PrincipalController.getInstance().getLoControl().getDto() != null
				&& PrincipalController.getInstance().getLoControl().getDto()
						.getCargo().equals(RolEnum.ADMINISTRADOR.getCode())) {
			view.addPanel(UsuarioController.getInstance().getView(),
					OpcionMenu.USUARIO.name(),
					ConstantesInterfaz.TITULO_USUARIO);
		} else {
			JOptionUtil.mostrarMensajeError(ConstantesInterfaz.E_MSJ_LOGIN);
		}
	}

	/**
	 * El evento de salir de la app.
	 */
	public void eventoSalir() {
		int z = JOptionPane.showConfirmDialog(null,
				ConstantesInterfaz.I_MSJ_SALIR,
				ConstantesInterfaz.C_MSJ_INFO_T, JOptionPane.YES_NO_OPTION);
		if (z == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * @return the cards
	 */
	public JPanel getCards() {
		return cards;
	}

	/**
	 * @param cards
	 *            the cards to set
	 */
	public void setCards(JPanel cards) {
		this.cards = cards;
	}

	/**
	 * @return the cl
	 */
	public CardLayout getCl() {
		return cl;
	}

	/**
	 * @param cl
	 *            the cl to set
	 */
	public void setCl(CardLayout cl) {
		this.cl = cl;
	}

	/**
	 * @return the view
	 */
	public PrincipalView getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(PrincipalView view) {
		this.view = view;
	}

	/**
	 * @return the loControl
	 */
	public LoginController getLoControl() {
		return loControl;
	}

	/**
	 * @param loControl
	 *            the loControl to set
	 */
	public void setLoControl(LoginController loControl) {
		this.loControl = loControl;
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return LOGGER;
	}

	/**
	 * @return the reload
	 */
	public Boolean getReload() {
		return reload;
	}

	/**
	 * @param reload
	 *            the reload to set
	 */
	public void setReload(Boolean reload) {
		this.reload = reload;
	}

	/**
	 * @return the instance
	 */
	public static PrincipalController getInstance() {
		return INSTANCE;
	}

}
