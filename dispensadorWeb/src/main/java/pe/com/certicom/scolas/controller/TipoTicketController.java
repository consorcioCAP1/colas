package pe.com.certicom.scolas.controller;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.certicom.scolas.common.ScolasCommonConstants;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.model.beans.TipoAtencion;
import pe.com.certicom.scolas.model.beans.TipoTicket;
import pe.com.certicom.scolas.service.AdminService;
import pe.com.certicom.scolas.service.ImpresoraService;
import pe.com.certicom.scolas.util.Criteria;
import pe.com.certicom.scolas.util.CriteriaManager;
import pe.com.certicom.scolas.util.FacesUtil;
import pe.com.certicom.scolas.util.FechasUtil;
import pe.com.certicom.scolas.util.ImpresoraNoDisponibleException;



@Component
@Scope("view")
public class TipoTicketController extends BaseController {

	private static final Logger LOGGER = Logger.getLogger(TipoTicketController.class);

	private String tipoCLiente;
	private String dni;	
	private String nombres;
	private String apellidoCompleto;
	private TipoAtencion tipoatencionBean;
	private List<TipoTicket> lstTipoTicket;
	private String impresion ; 
	private Ticket ticket;

	@Autowired
	ImpresoraService impresoraService;
	
	private Boolean mostrarPopup=false;

	@Autowired
	AdminService adminService;

	@PostConstruct
	protected void init() {	
		try {
			
		
			if (FacesUtil.getObjectFlash("tipoAtencionBean2")!= null){
				tipoatencionBean=(TipoAtencion)FacesUtil.getObjectFlash("tipoAtencionBean2");
				System.out.println("este  es el  tipoAtencion: "+ tipoatencionBean.getDescripcion());
			
				CriteriaManager criteriaManager = new  CriteriaManager();
				Criteria criteria= criteriaManager.createCriteria();
				criteria.andFieldEqualTo("visible",ScolasCommonConstants.UNO_STRING);
				criteria.andFieldEqualTo("activo",ScolasCommonConstants.UNO_STRING);				
				criteria.andFieldEqualTo("id_tipo_atencion",tipoatencionBean.getIdTipoAtencion());
				
				setLstTipoTicket(adminService.listarTipoTicketByCriteria(criteriaManager));
			}			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void redirectInicio(){
		try {
			if (mostrarPopup){
				
				String esgenerico = FacesUtil.getObjectSession("esgenerico").toString();
				
				if(esgenerico.equals(ScolasCommonConstants.CERO_STRING)){
					FacesUtil.setObjectSession("ticket",null);
					FacesUtil.setObjectSession("tipoDocumento",null);
					FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL);
					
					//mostrarprincipal = true;
				}else{
					FacesUtil.setObjectSession("ticket",null);
					FacesUtil.setObjectSession("tipoDocumento",null);
					FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL2);
					
				}
				
				
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void generarTicket(TipoTicket beanTipoTicket){
	try {
			ticket =  new  Ticket();
			
			Ticket ticketBean=(Ticket)FacesUtil.getObjectSession("ticket");	
			if(ticketBean!=null){
				
					ticket.setRazonSocial(ticketBean.getRazonSocial());
					ticket.setNombreCliente(ticketBean.getRazonSocial());
					ticket.setRuc(ticketBean.getRuc());
					ticket.setCodRestricDomicilio(ticketBean.getCodRestricDomicilio());
					ticket.setEstadoContribuyente(ticketBean.getEstadoContribuyente());
					ticket.setCodEstadoContribuyente(ticketBean.getCodEstadoContribuyente());
					ticket.setUbigeoRUC(ticketBean.getUbigeoRUC()); 
					ticket.setCondicionDomicilio(ticketBean.getCondicionDomicilio());			
					ticket.setCodCondicionDomicilio(ticketBean.getCodCondicionDomicilio());
					ticket.setCodDependencia(ticketBean.getCodDependencia());
					ticket.setNombreDependencia(ticketBean.getNombreDependencia());
			}
			
			String esgenerico=FacesUtil.getObjectSession("esgenerico").toString();
			
			
			String tipoDocumentoTemp=FacesUtil.getObjectSession("tipoDocumento").toString();
			
			if(esgenerico.equals(ScolasCommonConstants.UNO_STRING)){

				if(tipoatencionBean.getIdTipoAtencion()==ScolasCommonConstants.TIPO_ATENCION_CABINA){				
					Random randon= new Random();					
					Integer dig9 =randon.nextInt(900000000)+100000000;					
					ticket.setCodGeneradoCab(dig9.toString());
					
				}							
			} 
			
			if(tipoDocumentoTemp!=null){
				ticket.setIdTipoDocumento(Integer.parseInt(tipoDocumentoTemp));
			}
			else {
				ticket.setIdTipoDocumento(Integer.parseInt(ScolasCommonConstants.CINCO_STRING));
			}
			
			ticket.setIdTipoTicket(beanTipoTicket.getIdTipoTicket());
			ticket.setFecha(FechasUtil.getFechaActualSinHora());
			ticket.setDerivado(false);			
			ticket.setHoraEmision(new Date());
			ticket.setIdEstado(ScolasCommonConstants.ESTADO_TICKET_EMITIDO);
			ticket.setEsTitular(false);
			ticket.setEsTercero(false);
			ticket.setEsApoderado(false);
			
			
			
			
			
			Ticket ticketTemp= new Ticket();
			ticketTemp=adminService.generarTicket(ticket);
			impresion= ticketTemp.getCodigoImpresion();
			
			
			imprimirTicket();
			mostrarPopup=true;	
			System.out.println("este es el  codigo  de ticket : "+ ticketTemp.getIdTicket());
			
			FacesUtil.setObjectSession("nombre", null);
			FacesUtil.setObjectSession("dni2", null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public void regresar(){
		
		try {
			FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	public void imprimirTicket(){
		
		try {
			impresoraService.inicializar(ScolasCommonConstants.CONFIGURACION_TSP100);
			impresoraService.imprimirImage();
			impresoraService.imprimirLinea(impresion,ticket);
			impresoraService.Transaccion();
			impresoraService.finalizar();
			
		} catch (ImpresoraNoDisponibleException e) {
			
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


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoCompleto() {
		return apellidoCompleto;
	}


	public void setApellidoCompleto(String apellidoCompleto) {
		this.apellidoCompleto = apellidoCompleto;
	}


	public TipoAtencion getTipoatencionBean() {
		return tipoatencionBean;
	}


	public void setTipoatencionBean(TipoAtencion tipoatencionBean) {
		this.tipoatencionBean = tipoatencionBean;
	}


	public List<TipoTicket> getLstTipoTicket() {
		return lstTipoTicket;
	}


	public void setLstTipoTicket(List<TipoTicket> lstTipoTicket) {
		this.lstTipoTicket = lstTipoTicket;
	}



	public Boolean getMostrarPopup() {
		return mostrarPopup;
	}



	public void setMostrarPopup(Boolean mostrarPopup) {
		this.mostrarPopup = mostrarPopup;
	}



	public String getImpresion() {
		return impresion;
	}



	public void setImpresion(String impresion) {
		this.impresion = impresion;
	}

	
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	
}
