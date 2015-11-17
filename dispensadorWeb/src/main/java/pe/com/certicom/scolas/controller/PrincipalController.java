package pe.com.certicom.scolas.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.certicom.scolas.common.ScolasCommonConstants;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.service.AdminService;
import pe.com.certicom.scolas.util.FacesUtil;




@Component
@Scope("view")
public class PrincipalController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(PrincipalController.class);
	
	private String tipoDocumento;
	private String numeroDocumento;
	private String numeroRuc;
	private String cliente;
	private List<Ticket> lstTicket;
	private Ticket ticketBean;
	private Boolean mostrarRadio;
	private Boolean mostrarDatos;
	private List<SelectItem> lstItem;


	private Integer empresaSeleccionada;
	
	@Autowired
	AdminService adminService;
    
	@PostConstruct
	protected void init() {
		setMostrarDatos(false);
		setMostrarRadio(false);
		numeroDocumento=null;
		numeroRuc=null;
		tipoDocumento=ScolasCommonConstants.UNO_STRING;
		cliente=ScolasCommonConstants.UNO_STRING;
		
		
		
	}
	
	
	public void cargarTicketLista(){
		
	
				ticketBean=	lstTicket.get(empresaSeleccionada);
				mostrarRadio=false;
				mostrarDatos=true;
		
		
	}
	
	public void seleccionarTicket(){
	
		try {
		
			FacesUtil.setObjectSession("ticket",ticketBean);
			FacesUtil.setObjectSession("tipoDocumento", tipoDocumento);
			FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void buscarRepreLegal(){
		System.out.println("este es el que quiero ver:"+numeroDocumento);
		if(cliente.equals(ScolasCommonConstants.DOS_STRING)){
			System.out.println("este es el que quiero ver:"+numeroDocumento);
			buscarRuc();
		}
		
	}
	
	
	public void buscarRuc(){
	 try {
			setMostrarDatos(false);
			setMostrarRadio(false);
			
			if(!tipoDocumento.equals(ScolasCommonConstants.CINCO_STRING)){
				
			 	if(cliente.equals(ScolasCommonConstants.DOS_STRING)){
				 	if(numeroDocumento==null || numeroDocumento==""){
						FacesUtil.setMessageError(ScolasCommonConstants.MSG_NUMERO_DOCUMENTO_VACIO,ScolasCommonConstants.MSG_NUMERO_DOCUMENTO_VACIO);
					}
					else {
						
						lstTicket=adminService.buscarRucByRepreLegal(tipoDocumento, numeroDocumento);
						    					
						if(lstTicket.size()>0){
							if(lstTicket.size()==1){//si solo hay una empresa asociada al representante		    						
								//devuelvo el  ticket para mostrar los campos cargados
								ticketBean=lstTicket.get(0);
							}
							else {
								
								
									lstItem = new ArrayList<SelectItem>();
								
									SelectItem map;
									for (int i =0;i<lstTicket.size();i++) {
										map = new SelectItem(i, lstTicket.get(i).getNombrePersona());	
										lstItem.add(map);
						
									}
								
								setMostrarRadio(true);
							}
						}
					}
			 	}
			 	else if (cliente.equals(ScolasCommonConstants.UNO_STRING)){
	    			if(numeroDocumento==null || numeroDocumento==""){
	    				FacesUtil.setMessageError(ScolasCommonConstants.MSG_NUMERO_DOCUMENTO_VACIO,ScolasCommonConstants.MSG_NUMERO_DOCUMENTO_VACIO);
					}	
	    			
	    			else {
	    				ticketBean=adminService.buscarRucByTitular(tipoDocumento, numeroDocumento, true);
	    				if(ticketBean!=null){
	    					setMostrarDatos(true);
	    				}
	    			}
	    		}
	    		else if (cliente.equals(ScolasCommonConstants.TRES_STRING)){
	    			if(numeroRuc==null || numeroRuc==""){
	    				FacesUtil.setMessageError(ScolasCommonConstants.MSG_NUMERO_RUC_VACIO,ScolasCommonConstants.MSG_NUMERO_RUC_VACIO);
					}	
	    			
	    			else {
	    				ticketBean=adminService.buscarRucByTitular(tipoDocumento, numeroRuc, false);
	    				if(ticketBean!=null){
	    					setMostrarDatos(true);
	    				}
	    			}
	    		} 
			}
			else {
				System.out.println("tipo documento:"+ tipoDocumento);
				FacesUtil.setObjectSession("tipoDocumento", tipoDocumento);
				FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL2);	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
	}
	

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNumeroRuc() {
		return numeroRuc;
	}

	public void setNumeroRuc(String numeroRuc) {
		this.numeroRuc = numeroRuc;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Ticket getTicketBean() {
		return ticketBean;
	}

	public void setTicketBean(Ticket ticketBean) {
		this.ticketBean = ticketBean;
	}

	public Boolean getMostrarRadio() {
		return mostrarRadio;
	}

	public void setMostrarRadio(Boolean mostrarRadio) {
		this.mostrarRadio = mostrarRadio;
	}

	public Boolean getMostrarDatos() {
		return mostrarDatos;
	}

	public void setMostrarDatos(Boolean mostrarDatos) {
		this.mostrarDatos = mostrarDatos;
	}


	public Integer getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}


	public void setEmpresaSeleccionada(Integer empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}
	
	public List<SelectItem> getLstItem() {
		return lstItem;
	}
	
	public void setLstItem(List<SelectItem> lstItem) {
		this.lstItem = lstItem;
	}

	


}
