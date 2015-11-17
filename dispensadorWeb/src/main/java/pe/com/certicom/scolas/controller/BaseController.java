package pe.com.certicom.scolas.controller;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.certicom.scolas.service.ExceptionService;


public class BaseController {
	

	@Autowired
	public ExceptionService exceptionService;
	

	
	public BaseController() {
/*
		if (FacesUtil.getObjectSession("empresaCliente") == null)
			throw new CoreException("Por favor seleccione una empresa");
		

		if (FacesUtil.getObjectSession("empleado") == null)
			throw new CoreException("Por favor vuelva a iniciar sesion");
		*/
	
	}
	
	/*public void showMessage(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("idCodSolicitud", FacesUtil.getFacesMessageError(SEOCommonConstants.CAMPO_OBLIGATORIO));
		
	}*/
}
