package optimizador.optimizadordirecciones.co.com.optimizador.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.controlador.PredioController;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.OpcionBoton;
import optimizador.optimizadordirecciones.co.com.optimizador.util.JPaginateTable;

/**
 * 
 * @author Carol Becerra
 * @version 1.0
 */
public class PredioView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPaginateTable tablePredio;

	private JLabel labelFondo;

	private JButton bGuardar;
	private JButton bActualizar;
	private JButton bEliminar;
	private JButton bConsultar;
	private JButton bImportar;
	private static final PredioView INSTANCE = new PredioView();
	/**
	 * Instancia del logger para almacenar la traza de la App.
	 */
	private static final Logger LOGGER = LogManager.getLogger(PredioView.class);

	/**
	 * Create the panel.
	 */
	private PredioView() {
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(ConstanteGlobal.BLANCO));
		// setBackground(Color.BLACK);
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
	 * Inicializa/crea los botones.
	 */
	public void initButtons() {
		final int posYButton = 210;
		final int widthBoton = 150;
		final int heightBoton = 30;
		bImportar = new JButton(ConstantesInterfaz.BOTON_IMPORTAR);
		bImportar.setBounds(40, posYButton, widthBoton, heightBoton);
		bImportar.setIcon(new ImageIcon(getClass().getResource(
				ConstantesInterfaz.IMAGE_GUARDAR)));
		bImportar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionBoton.GUARDAR);
			}
		});
		add(bImportar);

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
		 * bVolver = new JButton(ConstantesInterfaz.BOTON_VOLVER);
		 * bVolver.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent evt) {
		 * seleccionarOpcion(OpcionBoton.VOLVER); } }); add(bVolver);
		 */
	}

	/**
	 * Inicializa/crea la tabla de datos.
	 */
	public void initTable() {
		tablePredio = new JPaginateTable();
		tablePredio.setComponentBounds(40, 260, 600, 180);
		add(tablePredio.getTableFirst());
		add(tablePredio.getTablePrev());
		add(tablePredio.getField());
		add(tablePredio.getLabel());
		add(tablePredio.getTableNext());
		add(tablePredio.getTableLast());
		add(tablePredio.getTableScroll());
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
			PredioController.getInstance().eventoImportar();
			break;
		case ACTUALIZAR:
			PredioController.getInstance().eventoActualizar();
			break;
		case ELIMINAR:
			PredioController.getInstance().eventoEliminar();
			break;
		case CONSULTAR:
			PredioController.getInstance().eventoConsultar();
			break;
		case VOLVER:
			PredioController.eventoVolver();
			break;
		default:
			break;
		}
	}

	/**
	 * @return the tablePredio
	 */
	public JPaginateTable getTablePredio() {
		return tablePredio;
	}

	/**
	 * @param tablePredio
	 *            the tablePredio to set
	 */
	public void setTablePredio(JPaginateTable tablePredio) {
		this.tablePredio = tablePredio;
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
	 * @return the bImportar
	 */
	public JButton getbImportar() {
		return bImportar;
	}

	/**
	 * @param bImportar
	 *            the bImportar to set
	 */
	public void setbImportar(JButton bImportar) {
		this.bImportar = bImportar;
	}

	/**
	 * @return the instance
	 */
	public static PredioView getInstance() {
		return INSTANCE;
	}

}
