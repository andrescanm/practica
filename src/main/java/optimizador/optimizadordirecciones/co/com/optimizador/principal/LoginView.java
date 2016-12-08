package optimizador.optimizadordirecciones.co.com.optimizador.principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.controlador.LoginController;

/**
 * 
 * @author Carol Becerra
 * @version 1.0
 */
public class LoginView extends JPanel {

	/**
	 * La versi\u00f3n serial por defecto para est\u00e1 clase.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelUsuario;
	private JLabel labelPass;
	private JLabel labelFondo;

	private JTextField textUsuario;
	private JPasswordField textPass;

	private JButton btnIngresar;

	private final int posIniXLabel = 100;
	private final int posIniYLabel = 100;
	private final int posIniXText = 210;
	private final int espacioY = 30;
	private final int width = 150;
	private final int height = 20;

	private static final LoginView INSTANCE = new LoginView();
	/**
	 * Instancia del logger para almacenar la traza de la App.
	 */
	private static final Logger LOGGER = LogManager
			.getLogger(LoginView.class);

	/**
	 * Create the panel.
	 */
	public LoginView() {
		getVistaInicial();
	}

	/**
	 * Obtiene la vista inicial del aplicativo.
	 */
	private void getVistaInicial() {
		setLayout(null);
		initLabels();
		initFields();
		initButtons();
		initBackGround();
	}

	/**
	 * Construye elementos de ventana.
	 */
	private void initBackGround() {
		try {
			labelFondo = new JLabel();
			ImageIcon ii = new ImageIcon(getClass().getResource(
					ConstantesInterfaz.IMAGE_PPAL));
			labelFondo.setIcon(ii);
			labelFondo.setBounds(0, 0, ii.getIconWidth(), ii.getIconHeight());
			add(labelFondo);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Inicializa/Crea los labels.
	 */
	public void initLabels() {
		labelUsuario = new JLabel(ConstantesInterfaz.LABEL_USUARIO);
		labelUsuario.setBounds(posIniXLabel, posIniYLabel, width, height);
		labelUsuario.setForeground(Color.WHITE);
		add(labelUsuario);

		labelPass = new JLabel(ConstantesInterfaz.LABEL_PASS);
		labelPass.setBounds(posIniXLabel, posIniYLabel + espacioY, width,
				height);
		labelPass.setForeground(Color.WHITE);
		add(labelPass);
	}

	/**
	 * Inicializa/Crea los campos gestionables.
	 */
	public void initFields() {
		final int colLenght1 = 16;
		textUsuario = new JTextField();
		textUsuario.setBounds(posIniXText, posIniYLabel, width, height);
		textUsuario.setColumns(colLenght1);
		add(textUsuario);

		textPass = new JPasswordField();
		textPass.setBounds(posIniXText, posIniYLabel + espacioY, width, height);
		textPass.setColumns(colLenght1);
		add(textPass);
	}

	/**
	 * Inicializa/Crea los botones.
	 */
	public void initButtons() {
		btnIngresar = new JButton(ConstantesInterfaz.BOTON_LOGIN);
		btnIngresar.setBounds(posIniXText, posIniYLabel + (espacioY * 2),
				width, height);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				autenticar(evt);
			}
		});
		add(btnIngresar);
	}

	/**
	 * @param evt
	 *            el evento de oprimir boton Ingresar.
	 */
	public void autenticar(ActionEvent evt) {
		LoginController.getInstance().autenticar();
	}

	/**
	 * @return the labelFondo
	 */
	public JLabel getLabelFondo() {
		return labelFondo;
	}

	/**
	 * @param labelFondo
	 *            the labelFondo to set
	 */
	public void setLabelFondo(JLabel labelFondo) {
		this.labelFondo = labelFondo;
	}

	/**
	 * @return the textUsuario
	 */
	public JTextField getTextUsuario() {
		return textUsuario;
	}

	/**
	 * @param textUsuario
	 *            the textUsuario to set
	 */
	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	/**
	 * @return the textPass
	 */
	public JPasswordField getTextPass() {
		return textPass;
	}

	/**
	 * @param textPass
	 *            the textPass to set
	 */
	public void setTextPass(JPasswordField textPass) {
		this.textPass = textPass;
	}

	/**
	 * @return the labelUsuario
	 */
	public JLabel getLabelUsuario() {
		return labelUsuario;
	}

	/**
	 * @param labelUsuario
	 *            the labelUsuario to set
	 */
	public void setLabelUsuario(JLabel labelUsuario) {
		this.labelUsuario = labelUsuario;
	}

	/**
	 * @return the labelPass
	 */
	public JLabel getLabelPass() {
		return labelPass;
	}

	/**
	 * @param labelPass
	 *            the labelPass to set
	 */
	public void setLabelPass(JLabel labelPass) {
		this.labelPass = labelPass;
	}

	/**
	 * @return the btnIngresar
	 */
	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	/**
	 * @param btnIngresar
	 *            the btnIngresar to set
	 */
	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	/**
	 * @return the instance
	 */
	public static LoginView getInstance() {
		return INSTANCE;
	}

}
