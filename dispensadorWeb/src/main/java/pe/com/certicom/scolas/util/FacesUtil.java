package pe.com.certicom.scolas.util;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import pe.com.certicom.scolas.common.ScolasCommonConstants;

public class FacesUtil {

	public static FacesMessage getFacesMessageWarning(String strMessage, String detalleMensaje){
		return new FacesMessage(FacesMessage.SEVERITY_WARN, strMessage, detalleMensaje);
	}

	public static FacesMessage getFacesMessageError(String strMessage, String detalleMensaje){
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, strMessage, detalleMensaje);
	}

	public static FacesMessage getFacesMessageInfo(String strMessage, String detalleMensaje){
		return new FacesMessage(FacesMessage.SEVERITY_INFO, strMessage, detalleMensaje);
	}
	
	public static String getActionAttribute(ActionEvent event, String name) {
		if (event.getComponent().getAttributes().get(name) != null)
			return event.getComponent().getAttributes().get(name).toString();
		return null;
	}

	public static Object getObjectFlash(String var) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		return flash.get(var);
	}

	public static void setObjectFlash(String name, Object var) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.put(name, var);
	}

	public static void removeObjectSession(String name) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		sessionMap.remove(name);
	}

	public static Object getObjectSession(String var) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		return sessionMap.get(var);
	}

	public static void setObjectSession(String name, Object var) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		
		sessionMap.put(name, var);
	}

	public static void redirect(String url) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect(ScolasCommonConstants.WEBAPP_NAME + url);
	}
	
	public static void redirect(String url, String parameters) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect(ScolasCommonConstants.WEBAPP_NAME + url + parameters);
	}
	
	public static Object getParameterByName(String param) {
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return parameterMap.get(param);
	}
	
	public static String getPath() {
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	}
	
	public static HttpSession getSession(Boolean flag){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(flag);
		return session;
	}

	public static void setMessageConfirmacion(String mensaje, String detalleMensaje){
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary(mensaje);
		message.setDetail(detalleMensaje);
		FacesContext.getCurrentInstance().addMessage(ScolasCommonConstants.VACIO, message);
		setObjectFlash("titulo", "Mensaje de Confirmacion");
		setObjectFlash("mostrarMensaje", true);
	}
	
	public static void setMessageError(String mensaje, String detalleMensaje){
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		message.setSummary(mensaje);
		message.setDetail(detalleMensaje);
		FacesContext.getCurrentInstance().addMessage(ScolasCommonConstants.VACIO, message);
		setObjectFlash("titulo", "Mensaje de Error");
		setObjectFlash("detalleMensaje", detalleMensaje);
		setObjectFlash("mostrarMensaje", true);
	}
	
	public static void setMessageErrorPorID(String id, String mensaje, String detalleMensaje){
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		message.setSummary(mensaje);
		message.setDetail(detalleMensaje);
		FacesContext.getCurrentInstance().addMessage(id, message);
		setObjectFlash("titulo", "Mensaje de Error");
		setObjectFlash("detalleMensaje", detalleMensaje);
		setObjectFlash("mostrarMensaje", true);
	}
	public static HttpServletRequest request(){
		return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
}