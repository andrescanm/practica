package optimizador.optimizadordirecciones.co.com.optimizador.principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.controlador.UsuarioController;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.OpcionBoton;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.RolEnum;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JPaginateTable;

/**
 * 
 * @author Carol Becerra
 * @version 1.0
 */
public class UsuarioView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPaginateTable tableUsuario;

	private JLabel labelPk;
	private JLabel labelPNombre;
	private JLabel labelPApellido;
	private JLabel labelUserName;
	private JLabel labelPassword;
	private JLabel labelCargo;
	private JLabel labelArea;
	private JLabel labelFondo;

	private JTextField textPNombre;
	private JTextField textPApellido;
	private JTextField textUserName;
	private JPasswordField textPass;
	private JComboBox<RolEnum> comboCargo;
	private JTextField textArea;

	private JButton bGuardar;
	private JButton bActualizar;
	private JButton bEliminar;
	private JButton bConsultar;
	private JButton bVolver;

	private final int posInixLabelC1 = 40;
	private final int posInixLabelC2 = 260;
	private final int posInixTextC1 = 150;
	private final int posInixTextC2 = 370;
	private final int posYFila1 = 60;
	private final int posYFila2 = 90;
	private final int posYFila3 = 120;

	private static final UsuarioView INSTANCE = new UsuarioView();
	/**
	 * Instancia del logger para almacenar la traza de la App.
	 */
	private static final Logger LOGGER = LogManager
			.getLogger(UsuarioView.class);

	/**
	 * Create the panel.
	 */
	private UsuarioView() {
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(ConstanteGlobal.BLANCO));
		// setBackground(Color.BLACK);
		initFields();
		initButtons();
		initTable();
		initBackGround();
	}

	/**
	 * Construye elementos de ventana.
	 */
	private void initBackGround() {
		try {
			labelFondo = new JLabel();
			ImageIcon ii = new ImageIcon(getClass().getResource(
					ConstantesInterfaz.IMAGE_USER));
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
	public void initFields() {
		final int colLenght1 = 64;
		final int width = 100;
		final int height = 20;
		// Label utilizado para almacenar la PK en caso de ser necesario.
		labelPk = new JLabel(ConstanteGlobal.BLANCO);
		labelPk.setBounds(0, 0, 0, 0);
		labelPk.setVisible(false);

		labelPNombre = new JLabel(ConstantesInterfaz.LABEL_U_PN);
		labelPNombre.setBounds(posInixLabelC1, posYFila1, width, height);
		labelPNombre.setForeground(Color.WHITE);
		add(labelPNombre);

		textPNombre = new JTextField();
		textPNombre.setBounds(posInixTextC1, posYFila1, width, height);
		textPNombre.setColumns(colLenght1);
		add(textPNombre);

		labelPApellido = new JLabel(ConstantesInterfaz.LABEL_U_PA);
		labelPApellido.setBounds(posInixLabelC2, posYFila1, width, height);
		labelPApellido.setForeground(Color.WHITE);
		add(labelPApellido);

		textPApellido = new JTextField();
		textPApellido.setBounds(posInixTextC2, posYFila1, width, height);
		textPApellido.setColumns(colLenght1);
		add(textPApellido);

		labelUserName = new JLabel(ConstantesInterfaz.LABEL_U_USER);
		labelUserName.setBounds(posInixLabelC1, posYFila2, width, height);
		labelUserName.setForeground(Color.WHITE);
		add(labelUserName);

		textUserName = new JTextField();
		textUserName.setBounds(posInixTextC1, posYFila2, width, height);
		textUserName.setColumns(colLenght1);
		add(textUserName);

		labelPassword = new JLabel(ConstantesInterfaz.LABEL_U_PASS);
		labelPassword.setBounds(posInixLabelC2, posYFila2, width, height);
		labelPassword.setForeground(Color.WHITE);
		add(labelPassword);

		textPass = new JPasswordField();
		textPass.setBounds(posInixTextC2, posYFila2, width, height);
		textPass.setColumns(colLenght1);
		add(textPass);

		labelCargo = new JLabel(ConstantesInterfaz.LABEL_U_ROL);
		labelCargo.setBounds(posInixLabelC1, posYFila3, width, height);
		labelCargo.setForeground(Color.WHITE);
		add(labelCargo);

		comboCargo = new JComboBox<RolEnum>();
		comboCargo.setBounds(posInixTextC1, posYFila3, width, height);
		add(comboCargo);

		labelArea = new JLabel(ConstantesInterfaz.LABEL_U_AREA);
		labelArea.setBounds(posInixLabelC2, posYFila3, width, height);
		labelArea.setForeground(Color.WHITE);
		add(labelArea);

		textArea = new JTextField();
		textArea.setBounds(posInixTextC2, posYFila3, width, height);
		textArea.setColumns(colLenght1);
		add(textArea);
	}

	/**
	 * Inicializa/crea los botones.
	 */
	public void initButtons() {
		final int posYButton = 210;
		final int widthBoton = 150;
		final int heightBoton = 30;
		bGuardar = new JButton(ConstantesInterfaz.BOTON_GUARDAR);
		bGuardar.setBounds(40, posYButton, widthBoton, heightBoton);
		bGuardar.setIcon(new ImageIcon(getClass().getResource(
					ConstantesInterfaz.IMAGE_GUARDAR)));
		bGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionBoton.GUARDAR);
			}
		});
		add(bGuardar);

		bActualizar = new JButton(ConstantesInterfaz.BOTON_ACTUALIZAR);
		bActualizar.setBounds(200, posYButton, widthBoton, heightBoton);
		bActualizar.setIcon(new ImageIcon(getClass().getResource(
				ConstantesInterfaz.IMAGE_ACTUALIZAR)));
		bActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionBoton.ACTUALIZAR);
			}
		});
		add(bActualizar);

		bEliminar = new JButton(ConstantesInterfaz.BOTON_ELIMINAR);
		bEliminar.setBounds(360, posYButton, widthBoton, heightBoton);
		bEliminar.setIcon(new ImageIcon(getClass().getResource(
				ConstantesInterfaz.IMAGE_ELIMINAR)));
		bEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionBoton.ELIMINAR);
			}
		});
		add(bEliminar);

		bConsultar = new JButton(ConstantesInterfaz.BOTON_CONSULTAR);
		bConsultar.setBounds(520, posYButton, widthBoton, heightBoton);
		bConsultar.setIcon(new ImageIcon(getClass().getResource(
				ConstantesInterfaz.IMAGE_BUSCAR)));
		bConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionBoton.CONSULTAR);
			}
		});
		add(bConsultar);

		/*
		bVolver = new JButton(ConstantesInterfaz.BOTON_VOLVER);
		bVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionBoton.VOLVER);
			}
		});
		add(bVolver);
		*/
	}

	/**
	 * Inicializa/crea la tabla de datos.
	 */
	public void initTable() {
		tableUsuario = new JPaginateTable();
		tableUsuario.setComponentBounds(40, 260, 600, 180);
		add(tableUsuario.getTableFirst());
		add(tableUsuario.getTablePrev());
		add(tableUsuario.getField());
		add(tableUsuario.getLabel());
		add(tableUsuario.getTableNext());
		add(tableUsuario.getTableLast());
		add(tableUsuario.getTableScroll());
	}

	/**
	 * Selecciona la opción según el botón.
	 * 
	 * @param op
	 *            las posibles opciones.
	 */
	private void seleccionarOpcion(OpcionBoton op) {
		switch (op) {
		case GUARDAR:
			UsuarioController.getInstance().eventoGuardar();
			break;
		case ACTUALIZAR:
			UsuarioController.getInstance().eventoActualizar();
			break;
		case ELIMINAR:
			UsuarioController.getInstance().eventoEliminar();
			break;
		case CONSULTAR:
			UsuarioController.getInstance().eventoConsultar();
			break;
		case VOLVER:
			UsuarioController.eventoVolver();
			break;
		default:
			break;
		}
	}

	/**
	 * @return the tableUsuario
	 */
	public JPaginateTable getTableUsuario() {
		return tableUsuario;
	}

	/**
	 * @param tableUsuario
	 *            the tableUsuario to set
	 */
	public void setTableUsuario(JPaginateTable tableUsuario) {
		this.tableUsuario = tableUsuario;
	}

	/**
	 * @return the textPNombre
	 */
	public JTextField getTextPNombre() {
		return textPNombre;
	}

	/**
	 * @param textPNombre
	 *            the textPNombre to set
	 */
	public void setTextPNombre(JTextField textPNombre) {
		this.textPNombre = textPNombre;
	}

	/**
	 * @return the textPApellido
	 */
	public JTextField getTextPApellido() {
		return textPApellido;
	}

	/**
	 * @param textPApellido
	 *            the textPApellido to set
	 */
	public void setTextPApellido(JTextField textPApellido) {
		this.textPApellido = textPApellido;
	}

	/**
	 * @return the textUserName
	 */
	public JTextField getTextUserName() {
		return textUserName;
	}

	/**
	 * @param textUserName
	 *            the textUserName to set
	 */
	public void setTextUserName(JTextField textUserName) {
		this.textUserName = textUserName;
	}

	/**
	 * @return the textArea
	 */
	public JTextField getTextArea() {
		return textArea;
	}

	/**
	 * @param textArea
	 *            the textArea to set
	 */
	public void setTextArea(JTextField textArea) {
		this.textArea = textArea;
	}

	/**
	 * @return the labelPk
	 */
	public JLabel getLabelPk() {
		return labelPk;
	}

	/**
	 * @param labelPk
	 *            the labelPk to set
	 */
	public void setLabelPk(JLabel labelPk) {
		this.labelPk = labelPk;
	}

	/**
	 * @return the labelPNombre
	 */
	public JLabel getLabelPNombre() {
		return labelPNombre;
	}

	/**
	 * @param labelPNombre
	 *            the labelPNombre to set
	 */
	public void setLabelPNombre(JLabel labelPNombre) {
		this.labelPNombre = labelPNombre;
	}

	/**
	 * @return the labelPApellido
	 */
	public JLabel getLabelPApellido() {
		return labelPApellido;
	}

	/**
	 * @param labelPApellido
	 *            the labelPApellido to set
	 */
	public void setLabelPApellido(JLabel labelPApellido) {
		this.labelPApellido = labelPApellido;
	}

	/**
	 * @return the labelUserName
	 */
	public JLabel getLabelUserName() {
		return labelUserName;
	}

	/**
	 * @param labelUserName
	 *            the labelUserName to set
	 */
	public void setLabelUserName(JLabel labelUserName) {
		this.labelUserName = labelUserName;
	}

	/**
	 * @return the labelPassword
	 */
	public JLabel getLabelPassword() {
		return labelPassword;
	}

	/**
	 * @param labelPassword
	 *            the labelPassword to set
	 */
	public void setLabelPassword(JLabel labelPassword) {
		this.labelPassword = labelPassword;
	}

	/**
	 * @return the labelCargo
	 */
	public JLabel getLabelCargo() {
		return labelCargo;
	}

	/**
	 * @param labelCargo
	 *            the labelCargo to set
	 */
	public void setLabelCargo(JLabel labelCargo) {
		this.labelCargo = labelCargo;
	}

	/**
	 * @return the labelArea
	 */
	public JLabel getLabelArea() {
		return labelArea;
	}

	/**
	 * @param labelArea
	 *            the labelArea to set
	 */
	public void setLabelArea(JLabel labelArea) {
		this.labelArea = labelArea;
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
	 * @return the comboCargo
	 */
	public JComboBox<RolEnum> getComboCargo() {
		return comboCargo;
	}

	/**
	 * @param comboCargo
	 *            the comboCargo to set
	 */
	public void setComboCargo(JComboBox<RolEnum> comboCargo) {
		this.comboCargo = comboCargo;
	}

	/**
	 * @return the bGuardar
	 */
	public JButton getbGuardar() {
		return bGuardar;
	}

	/**
	 * @param bGuardar
	 *            the bGuardar to set
	 */
	public void setbGuardar(JButton bGuardar) {
		this.bGuardar = bGuardar;
	}

	/**
	 * @return the bActualizar
	 */
	public JButton getbActualizar() {
		return bActualizar;
	}

	/**
	 * @param bActualizar
	 *            the bActualizar to set
	 */
	public void setbActualizar(JButton bActualizar) {
		this.bActualizar = bActualizar;
	}

	/**
	 * @return the bEliminar
	 */
	public JButton getbEliminar() {
		return bEliminar;
	}

	/**
	 * @param bEliminar
	 *            the bEliminar to set
	 */
	public void setbEliminar(JButton bEliminar) {
		this.bEliminar = bEliminar;
	}

	/**
	 * @return the bConsultar
	 */
	public JButton getbConsultar() {
		return bConsultar;
	}

	/**
	 * @param bConsultar
	 *            the bConsultar to set
	 */
	public void setbConsultar(JButton bConsultar) {
		this.bConsultar = bConsultar;
	}

	/**
	 * @return the bVolver
	 */
	public JButton getbVolver() {
		return bVolver;
	}

	/**
	 * @param bVolver
	 *            the bVolver to set
	 */
	public void setbVolver(JButton bVolver) {
		this.bVolver = bVolver;
	}

	/**
	 * @return the instance
	 */
	public static UsuarioView getInstance() {
		return INSTANCE;
	}

}
