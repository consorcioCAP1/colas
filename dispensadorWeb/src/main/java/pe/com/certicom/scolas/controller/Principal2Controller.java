package pe.com.certicom.scolas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.certicom.scolas.common.ScolasCommonConstants;
import pe.com.certicom.scolas.model.beans.ClientesOnp;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.model.beans.TipoAtencion;
import pe.com.certicom.scolas.service.AdminService;
import pe.com.certicom.scolas.util.Criteria;
import pe.com.certicom.scolas.util.CriteriaManager;
import pe.com.certicom.scolas.util.FacesUtil;
import pe.com.certicom.scolas.util.FechasUtil;



@Component
@Scope("view")
public class Principal2Controller extends BaseController {

	private static final Logger LOGGER = Logger.getLogger(Principal2Controller.class);

	private String tipoCLiente;
	private String dni;
	private String data;
	private String nombres;
	
	private String nombreCompleto;
	
	private Boolean mostrarNombreCompleto=false;
	private List<TipoAtencion>lstTipoAtencion;
	private Boolean mostrarPopup=false;
	
	
	@Autowired
	AdminService adminService;

	@PostConstruct
	protected void init() {	
		
	try {
			 
			
			CriteriaManager criteriaManager = new  CriteriaManager();
			Criteria criteria= criteriaManager.createCriteria();
			criteria.andFieldEqualTo("visible",ScolasCommonConstants.UNO_STRING);
			criteria.andFieldEqualTo("activo",ScolasCommonConstants.UNO_STRING);
			
			lstTipoAtencion=adminService.listarTipoAtencionByCriteria(criteriaManager);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}


	public void regresar(){
		try {
			FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL);
			FacesUtil.setObjectSession("ticket",null);
			FacesUtil.setObjectSession("tipoDocumento",null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void redirectPage(TipoAtencion tipoAtencionBean){		
		
	try {
			FacesUtil.setObjectFlash("tipoAtencionBean2", tipoAtencionBean);		
			FacesUtil.redirect(ScolasCommonConstants.XHTML_TIPOTICKET);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public String getTipoCLiente() {
		return tipoCLiente;
	}


	public void setTipoCLiente(String tipoCLiente) {
		this.tipoCLiente = tipoCLiente;
	}


	public String getDni() {		
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Boolean getMostrarNombreCompleto() {
		return mostrarNombreCompleto;
	}


	public void setMostrarNombreCompleto(Boolean mostrarNombreCompleto) {
		this.mostrarNombreCompleto = mostrarNombreCompleto;
	}


	public List<TipoAtencion> getLstTipoAtencion() {
		return lstTipoAtencion;
	}


	public void setLstTipoAtencion(List<TipoAtencion> lstTipoAtencion) {
		this.lstTipoAtencion = lstTipoAtencion;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Boolean getMostrarPopup() {
		return mostrarPopup;
	}

	public void setMostrarPopup(Boolean mostrarPopup) {
		this.mostrarPopup = mostrarPopup;
	}

}
