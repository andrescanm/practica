package optimizador.optimizadordirecciones.co.com.optimizador.constante;

/**
 * Constantes Generales usadas en los objetos de interfaz.
 * 
 * @author Andres Cañón
 * @version 1.0
 */
public final class ConstantesInterfaz {

	public static final String BOTON_LOGIN = "Ingresar";
	public static final String BOTON_GUARDAR = "Guardar";
	public static final String BOTON_ACTUALIZAR = "Actualizar";
	public static final String BOTON_ELIMINAR = "Eliminar";
	public static final String BOTON_CONSULTAR = "Consultar";
	public static final String BOTON_VOLVER = "Volver";
	public static final String BOTON_IMPORTAR = "Importar";

	public static final String IMAGE_ICON = "/imagenes/icono_ventana.png";
	public static final String IMAGE_PPAL = "/imagenes/KeyMgr-Ppal.png";
	public static final String IMAGE_REPORTE = "/imagenes/KeyMgr-User.png";
	public static final String IMAGE_RUTERO = "/imagenes/KeyMgr-User.png";
	public static final String IMAGE_USER = "/imagenes/KeyMgr-User.png";
	public static final String IMAGE_SALIR = "/imagenes/salir.png";
	public static final String IMAGE_GUARDAR = "/imagenes/guardar.png";
	public static final String IMAGE_ACTUALIZAR = "/imagenes/actualizar.png";
	public static final String IMAGE_ELIMINAR = "/imagenes/eliminar.png";
	public static final String IMAGE_BUSCAR = "/imagenes/buscar.png";

	public static final String LABEL_USUARIO = "Usuario: ";
	public static final String LABEL_PASS = "Contraseña: ";
	public static final String LABEL_LOGGED = "Bienvenido (a): ";

	public static final String LABEL_U_PN = "Nombres:";
	public static final String LABEL_U_PA = "Apellidos:";
	public static final String LABEL_U_USER = "Usuario:";
	public static final String LABEL_U_PASS = "Contraseña:";
	public static final String LABEL_U_ROL = "Cargo:";
	public static final String LABEL_U_AREA = "Area:";

	public static final String MENU_ADMON = "Administración";
	public static final String MENU_INFO = "Información";
	public static final String MENU_SESION = "Sesión";
	public static final String MENUITEM_PREDIO = "Predio";
	public static final String MENUITEM_REPORTE = "Reporte";
	public static final String MENUITEM_RUTERO = "Rutero";
	public static final String MENUITEM_USUARIO = "Usuarios";
	public static final String MENUITEM_SESION = "Cerrar Sesión";
	public static final String MENUITEM_CREDITOS = "Créditos";
	public static final String MENUITEM_SALIR = "Salir";

	public static final Integer LIMITE_TABLA_PAG = 10;

	protected static final String TABLA_USUARIO[] = { "Código", "Nombres",
			"Apellidos", "Usuario", "Cargo", "Area" };

	protected static final String TABLA_PREDIO[] = { "Contrato", "Plan",
			"Localidad", "Suscritor", "Visitado", "Direccion", "Vencimiento",
			"# Habitacionales", "# No Habitacionales", "Basura", "# Semana",
			"Tipo", "Frecuencia", "Horario", "Observación" };

	public static final String TITULO_MAIN = "Optimizador v 1.0 - ";
	public static final String TITULO_INICIO = "Inicio de Sesión";
	public static final String TITULO_LOGIN = "Inicio [Logeado]";
	public static final String TITULO_PREDIO = "Gestión de Predios";
	public static final String TITULO_USUARIO = "Gestión de Usuarios";

	public static final String JOP_TITULO_EXPORTAR = "EXPORTAR";
	public static final String JOP_TITULO_EXITO = "ÉXITO";
	public static final String JOP_TITULO_ERROR = "ERROR";
	public static final String JOP_TITULO_BUSCAR = "BUSCAR";
	public static final String JOP_TITULO_CHOOSER = "Seleccione el archivo con los datos de predios.";

	public static final String I_MSJ_SALIR = "¿Realmente desea salir?";
	public static final String I_MSJ_ACTUALIZADO = "Se actualizó correctamente: ";
	public static final String I_MSJ_BORRADO = "Se eliminó correctamente: ";
	public static final String I_MSJ_GUARDADO = "Se guardo correctamente: ";
	public static final String I_MSJ_EXT = "El archivo seleccionado NO corresponde a archivos Excel (.xls , .xlsx)";
	public static final String I_MSJ_IMPORTAR = "Se terminaron de importar los datos exitosamente.";
	public static final String I_MSJ_EXPORTAR = "Se canceló el proceso de exportación.";
	public static final String E_MSJ_NO_EXISTE = "Usuario o contraseña incorrectas";
	public static final String E_MSJ_LOGIN = "Debes hacer login para navegar al menú o quizás no tienes los permisos necesarios para ver este menú.";
	public static final String E_MSJ_NO_ADMIN = "Sólo puede haber un administrador del sistema.";
	public static final String E_MSJ_ELIM_ADMIN = "No se puede eliminar al administrador del sistema.";
	public static final String E_MSJ_INESPERADO = "Ooops... Acaba de ocurrir un error inesperado.";
	public static final String E_MSJ_DATOS = "Los datos que acaba de ingresar son incorrectos.";
	public static final String E_MSJ_FK_C = "Quizás otro usuario está utilizando la cuenta.";
	public static final String E_MSJ_EXPORT = "Como administrador no se pueden exportar datos de usuario.";
	public static final String E_MSJ_XLS = "No se pudieron exportar los datos.";
	public static final String E_MSJ_ADMIN = "Se requiere permisos de administrador para realizar la acción.";

	public static final String C_MSJ_INFO_T = "Optimizador v 1.0";
	public static final String C_MSJ_INFO_A1 = "Elaborado por: \n Carol Becerra \n Andres Cañón \n Yesid Ferrer";
	public static final String C_MSJ_INFO_A2 = "© 2016-2100 Todos los derechos reservados.";

	public static String ARROW_FIRST = "|<";
	public static String ARROW_PREV = "<";
	public static String ARROW_NEXT = ">";
	public static String ARROW_LAST = ">|";

	/**
	 * Constructor por defecto.
	 */
	private ConstantesInterfaz() {

	}

	/**
	 * @return the tablaUsuario
	 */
	public static String[] getTablaUsuario() {
		return TABLA_USUARIO;
	}

	/**
	 * @return the tablaPredio
	 */
	public static String[] getTablaPredio() {
		return TABLA_PREDIO;
	}

}
