package pe.com.certicom.scolas.common;

public class ScolasCommonConstants {

	public final static int CERO=0;

	public final static String VALIDACION_CAMPO_OBLIGATORIO = "Obligatorio";
	/**
	 * Mensajes a mostrarse despues del grabado de una pagina. 
	 */	


	public final static String WEBAPP_NAME = "/dispensadorWeb";
	
	
	public final static String VACIO = "";
	public final static String CAMPO_OBLIGATORIO_TEXTO = "Debe ingresar el campo";
	public final static String DATOS_GUARDADOS = "Datos almacenados";
	public final static String USUARIO_EXISTENTE = "Debe ingresar un usuario diferente";
	
	//URLS PAGINAS XHTML ADMIN
	public static final String XHTML_REGISTRAR_USUARIO = "/pages/admin/registrarUsuario.xhtml?faces-redirect=true";

	public static final String XHTML_PRINCIPAL = "/principal.xhtml?faces-redirect=true";
	public static final String XHTML_PRINCIPAL2 = "/principal2.xhtml?faces-redirect=true";
	public static final String XHTML_TIPOTICKET = "/tipoTicket.xhtml?faces-redirect=true";
	public static final String XHTML_INDEX = "/index.xhtml?faces-redirect=true";
	
	
	

	public static final String XHTML_LISTAR_USUARIO = "/pages/admin/listarUsuario.xhtml?faces-redirect=true";

	public static final String XHTML_LOGOUT = "/index.xhtml";


	public static final String XHTML_LISTAR_USUARIO_PERFIL = "/pages/admin/listarUsuarioPerfil.xhtml?faces-redirect=true";

	public static final String XHTML_LISTAR_PERFIL =  "/pages/admin/listarPerfil.xhtml?faces-redirect=true";	
	
	//mensajes  del servidor
	
	public final static String MSG_SUPERO_CANTIDAD_DIGITO = "Supero  limite maximo de digitos";
	public final static String MSG_LOGIN_INCORRECTO = "Usuario o password incorrecto";
	public final static String MSG_ESCANNER_DESCONECTADO = "No hay dispositivo conectado en puerto COM3";
	public final static String MSG_COMPLETE_DNI= "Ingrese los 8 digitos completos del DNI";
	public final static String MSG_MENSAJE_ESCANEAR = "pase el  DNI por la lectora";
	//tipos de mensajes 
	public final static String TIPO_MENSAJE_INFORMACION = "mensaje de informacion:";
	public final static String TIPO_MENSAJE_ERROR= "mensaje de error:";
	public final static String MSG_CLIENTE_ATENDIDO= "El cliente se encuentra en atención";
	
	
	public final static String UNO_STRING= "1";
	public final static String CERO_STRING= "0";
	
	
	
	/***
	 * Caracteres Especiales
	 */
	
	public final static String ESPACIO = " ";
	public final static String DOS_PUNTOS = ":";
	public final static String BACK_SLASH = "\\";
	public final static String SLASH = "/";
	public final static String PUNTO = ".";
	public final static String TAB = "\t";
	public final static String NUEVA_LINEA = "\n";
	public final static String GUION = "-";
	public final static String GUION_ABAJO = "_";
	public final static String ASTERISCO = "*";
	public static final String PLECA = "|";
	public final static String PUNTO_Y_COMA = ";";
	public final static String COMA = ",";
	public static final String PORCENTAJE = "%";
	public static final String NO_TIENE = "NO TIENE";
	
	
	/*MODELOS DE IMPRESORAS*/
	public static final String CONFIGURACION_TSP100 = "Star TSP100 Cutter (TSP143)_1";

	
	
	
	//estado  ticket  de  solicitud	
	public final static int	 ESTADO_TICKET_EMITIDO=0;
	

}
