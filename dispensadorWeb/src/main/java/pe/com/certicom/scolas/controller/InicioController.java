package pe.com.certicom.scolas.controller;

import java.io.Serializable;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.certicom.scolas.service.ExceptionService;
import pe.com.certicom.scolas.util.FacesUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean(name="inicioController")
@SessionScoped
public class InicioController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(InicioController.class);
	
	@Autowired
	private ExceptionService exceptionService;
	  
	
	public String  redirect(String tipoCliente)  {
			String cliente;
		
			if (tipoCliente.equals("1")){
			
				cliente="apoderado";
				System.out.println("entra uno ");
			}	
			
			else if  (tipoCliente.equals("2")){
				
				cliente="titular";
				System.out.println("entra dos ");
			}	
			
			else {
				cliente="tercero";
				System.out.println("entra tres");
			}		
			FacesUtil.setObjectSession("cliente", cliente);
			
		
			
			return "/principal.xhtml?faces-redirect=true";		
		
		}

}
