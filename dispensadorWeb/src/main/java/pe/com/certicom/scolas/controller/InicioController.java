package pe.com.certicom.scolas.controller;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.jboss.logging.Logger;
import pe.com.certicom.scolas.common.ScolasCommonConstants;
import pe.com.certicom.scolas.model.beans.Dispensador;
import pe.com.certicom.scolas.service.AuthenticationService;
import pe.com.certicom.scolas.util.Criteria;
import pe.com.certicom.scolas.util.CriteriaManager;
import pe.com.certicom.scolas.util.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "inicioController")
@SessionScoped
public class InicioController  implements Serializable  {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(InicioController.class);
	
	
	@ManagedProperty(value = "#{authenticationService}")
	private AuthenticationService authenticationService;
	

	private String vacio;
	private String usuario; 
	private String password;
	private Dispensador dispensadorBean;
	
	private Boolean mostrarprincipal=null;
	


	@PostConstruct
	protected void init() {	
		
		
			mostrarprincipal=null;
			
		
	}
	
	
	public void login (){
		
		try {
			
			Integer resultado;
			resultado= authenticationService.autenticarUsuario(usuario.trim(), password.trim());
			
			if(resultado==ScolasCommonConstants.UNO){
				
				String ip = InetAddress.getLocalHost().getHostAddress();
				CriteriaManager criteriaManager= new CriteriaManager();
				Criteria criteria = criteriaManager.createCriteria();
				criteria.andFieldEqualTo("ip", ip.trim());
				
				List<Dispensador> lstDispensador=	authenticationService.selectDispensadorByCriteria(criteriaManager);
		
				if(lstDispensador.size()>0){
					dispensadorBean= lstDispensador.get(0);
					
					if(dispensadorBean.getGenerico().equals(ScolasCommonConstants.CERO_STRING)){
						
						FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL);
						FacesUtil.setObjectSession("esgenerico", ScolasCommonConstants.CERO_STRING);	
						//mostrarprincipal = true;
					}else{
						FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL2);
						FacesUtil.setObjectSession("esgenerico", ScolasCommonConstants.UNO_STRING);
					}
					
				}
				
			}
			
			else if (resultado==2){
				FacesUtil.setMessageError(ScolasCommonConstants.MSG_LOGIN_INCORRECTO,	ScolasCommonConstants.MSG_LOGIN_INCORRECTO);
			}
			else {
				FacesUtil.setMessageError(ScolasCommonConstants.MSG_LOGIN_SINPEFIL,	ScolasCommonConstants.MSG_LOGIN_SINPEFIL);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
				
	}
	
	public String getVacio() {
		return vacio;
	}

	public void setVacio(String vacio) {
		this.vacio = vacio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Dispensador getDispensadorBean() {
		return dispensadorBean;
	}



	public void setDispensadorBean(Dispensador dispensadorBean) {
		this.dispensadorBean = dispensadorBean;
	}
	
	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public Boolean getMostrarprincipal() {
		return mostrarprincipal;
	}

	public void setMostrarprincipal(Boolean mostrarprincipal) {
		this.mostrarprincipal = mostrarprincipal;
	}

	
	
}
