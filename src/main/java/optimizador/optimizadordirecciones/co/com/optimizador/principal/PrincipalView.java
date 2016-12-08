package optimizador.optimizadordirecciones.co.com.optimizador.principal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import optimizador.optimizadordirecciones.co.com.optimizador.bd.ConexionBD;
import optimizador.optimizadordirecciones.co.com.optimizador.bd.QueryBD;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstanteGlobal;
import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.controlador.PrincipalController;
import optimizador.optimizadordirecciones.co.com.optimizador.enums.OpcionMenu;
import optimizador.optimizadordirecciones.co.com.optimizador.excepcion.ExcepcionTecnica;

/**
 * 
 * @author Andres Cañón
 * @version 1.0
 */
public class PrincipalView extends JFrame {

	/**
	 * versi\u00F3n serial de esta clase.
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menuAdmon;
	private JMenu menuInfo;
	private JMenu menuSesion;
	private JMenuItem itemPredio;
	private JMenuItem itemReporte;
	private JMenuItem itemRutero;
	private JMenuItem itemUsuario;
	private JMenuItem itemSalir;
	private JMenuItem itemCreditos;
	private JMenuItem itemSesion;

	/**
	 * Instancia del logger para almacenar la traza de la App.
	 */
	private static final Logger LOGGER = LogManager
			.getLogger(PrincipalView.class);
	/**
	 * La instancia de la ventana.
	 */
	private static final PrincipalView INSTANCE = new PrincipalView();

	/**
	 * Construye una instancia de la ventana.
	 */
	private PrincipalView() {
		try {
			buildMenu();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Crea los elementos de la barra de men\u00fa.
	 */
	private void buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuAdmon = new JMenu(ConstantesInterfaz.MENU_ADMON);
		menuBar.add(menuAdmon);
		itemPredio = new JMenuItem(ConstantesInterfaz.MENUITEM_PREDIO);
		itemPredio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionMenu.PREDIO);
			}
		});
		itemReporte = new JMenuItem(ConstantesInterfaz.MENUITEM_REPORTE);
		itemReporte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionMenu.REPORTE);
			}
		});
		itemRutero = new JMenuItem(ConstantesInterfaz.MENUITEM_RUTERO);
		itemRutero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionMenu.RUTERO);
			}
		});
		itemUsuario = new JMenuItem(ConstantesInterfaz.MENUITEM_USUARIO);
		itemUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionMenu.USUARIO);
			}
		});
		
		menuAdmon.add(itemPredio);
		menuAdmon.add(new JSeparator());
		menuAdmon.add(itemReporte);
		menuAdmon.add(new JSeparator());
		menuAdmon.add(itemRutero);
		menuAdmon.add(new JSeparator());
		menuAdmon.add(itemUsuario);

		menuSesion = new JMenu(ConstantesInterfaz.MENU_SESION);
		menuBar.add(menuSesion);
		itemSesion = new JMenuItem(ConstantesInterfaz.MENUITEM_SESION);
		itemSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionMenu.SESION);
			}
		});
		itemSalir = new JMenuItem(ConstantesInterfaz.MENUITEM_SALIR);
		itemSalir.setIcon(new ImageIcon(getClass().getResource(
				ConstantesInterfaz.IMAGE_SALIR)));
		itemSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionMenu.SALIR);
			}
		});
		menuSesion.add(itemSesion);
		menuSesion.add(new JSeparator());
		menuSesion.add(itemSalir);

		menuInfo = new JMenu(ConstantesInterfaz.MENU_INFO);
		itemCreditos = new JMenuItem(ConstantesInterfaz.MENUITEM_CREDITOS);
		itemCreditos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				seleccionarOpcion(OpcionMenu.CREDITOS);
			}
		});
		menuInfo.add(itemCreditos);
		menuBar.add(menuInfo);

		setIconImage(new ImageIcon(getClass().getResource(
				ConstantesInterfaz.IMAGE_ICON)).getImage());
	}

	/**
	 * Selecciona la opción según el menú.
	 * 
	 * @param op
	 *            las posibles opciones.
	 */
	private void seleccionarOpcion(OpcionMenu op) {
		switch (op) {
		case CREDITOS:
			PrincipalController.getInstance().eventoInfo();
			break;
		case PREDIO:
			PrincipalController.getInstance().eventoPredio();
			break;	
		case REPORTE:
			
			break;
		case RUTERO:

			break;
		case SALIR:
			PrincipalController.getInstance().eventoSalir();
			break;
		case SESION:
			PrincipalController.getInstance().eventoSesion();
			break;
		case USUARIO:
			PrincipalController.getInstance().eventoUsuario();
			break;
		default:
			break;
		}
	}

	/**
	 * Evita sobre-cargar el inicio, instancia y añade la vista cuando es
	 * necesaria.
	 * 
	 * @param view
	 *            la vista a agregar.
	 * @param opcion
	 *            la opcion asociada a la vista.
	 * @param titulo
	 *            el titulo asociado a la vista.
	 */
	public void addPanel(JPanel view, String opcion, String titulo) {
		boolean flagAdd = false;
		if (!flagAdd) {
			PrincipalController.getInstance().getCards().add(view, opcion);
			flagAdd = true;
		}
		PrincipalController.getInstance().sendRedirect(opcion, titulo);
	}

	/**
	 * Inicializa los datos (BD).
	 */
	private static void initData() {
		PropertyConfigurator.configure(PrincipalView.class
				.getResourceAsStream(ConstanteGlobal.LOG4J));
		ConexionBD.getInstance();
		try {
			Boolean b = QueryBD.dbExist(ConstanteGlobal.DERBY_MAIN_TABLE,
					ConstanteGlobal.DERBY_CONNECTION,
					ConstanteGlobal.DERBY_LOCATION, ConstanteGlobal.BLANCO,
					ConstanteGlobal.BLANCO);
			LOGGER.info(b);
			if (!b) {
				ConexionBD.getInstance().executeImport(Boolean.TRUE);
				LOGGER.info(ConstanteGlobal.OK);
			}
			if (ConexionBD.getInstance().getCon() == null) {
				ConexionBD.getInstance().conectarBD(
						ConstanteGlobal.DERBY_CONNECTION,
						ConstanteGlobal.DERBY_LOCATION, ConstanteGlobal.BLANCO,
						ConstanteGlobal.BLANCO);
			}
			LOGGER.info(ConexionBD.getInstance().getCon());
		} catch (ExcepcionTecnica e) {
			LOGGER.error(
					ConstanteGlobal.FALLO + ConstanteGlobal.DOS_PUNTOS + e, e);
		}
	}

	/**
	 * @param args
	 *            los Argumentos para construir la ventana.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initData();
					PrincipalView.getInstance().setVisible(true);
					PrincipalView.getInstance().setDefaultCloseOperation(
							JFrame.EXIT_ON_CLOSE);
					PrincipalController.getInstance();
					PrincipalController.getInstance().buildPrincipal();
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
					System.exit(1);
				}
			}
		});
	}

	/**
	 * @return the menuAdmon
	 */
	public JMenu getMenuAdmon() {
		return menuAdmon;
	}

	/**
	 * @param menuAdmon
	 *            the menuAdmon to set
	 */
	public void setMenuAdmon(JMenu menuAdmon) {
		this.menuAdmon = menuAdmon;
	}

	/**
	 * @return the menuInfo
	 */
	public JMenu getMenuInfo() {
		return menuInfo;
	}

	/**
	 * @param menuInfo
	 *            the menuInfo to set
	 */
	public void setMenuInfo(JMenu menuInfo) {
		this.menuInfo = menuInfo;
	}

	/**
	 * @return the menuSesion
	 */
	public JMenu getMenuSesion() {
		return menuSesion;
	}

	/**
	 * @param menuSesion
	 *            the menuSesion to set
	 */
	public void setMenuSesion(JMenu menuSesion) {
		this.menuSesion = menuSesion;
	}

	/**
	 * @return the itemReporte
	 */
	public JMenuItem getItemReporte() {
		return itemReporte;
	}

	/**
	 * @param itemReporte
	 *            the itemReporte to set
	 */
	public void setItemReporte(JMenuItem itemReporte) {
		this.itemReporte = itemReporte;
	}

	/**
	 * @return the itemRutero
	 */
	public JMenuItem getItemRutero() {
		return itemRutero;
	}

	/**
	 * @param itemRutero
	 *            the itemRutero to set
	 */
	public void setItemRutero(JMenuItem itemRutero) {
		this.itemRutero = itemRutero;
	}

	/**
	 * @return the itemUsuario
	 */
	public JMenuItem getItemUsuario() {
		return itemUsuario;
	}

	/**
	 * @param itemUsuario
	 *            the itemUsuario to set
	 */
	public void setItemUsuario(JMenuItem itemUsuario) {
		this.itemUsuario = itemUsuario;
	}

	/**
	 * @return the itemSalir
	 */
	public JMenuItem getItemSalir() {
		return itemSalir;
	}

	/**
	 * @param itemSalir
	 *            the itemSalir to set
	 */
	public void setItemSalir(JMenuItem itemSalir) {
		this.itemSalir = itemSalir;
	}

	/**
	 * @return the itemCreditos
	 */
	public JMenuItem getItemCreditos() {
		return itemCreditos;
	}

	/**
	 * @param itemCreditos
	 *            the itemCreditos to set
	 */
	public void setItemCreditos(JMenuItem itemCreditos) {
		this.itemCreditos = itemCreditos;
	}

	/**
	 * @return the itemSesion
	 */
	public JMenuItem getItemSesion() {
		return itemSesion;
	}

	/**
	 * @param itemSesion
	 *            the itemSesion to set
	 */
	public void setItemSesion(JMenuItem itemSesion) {
		this.itemSesion = itemSesion;
	}

	/**
	 * @return the instance
	 */
	public static PrincipalView getInstance() {
		return INSTANCE;
	}

}
