package pe.com.certicom.scolas.service;

import java.util.List;

import pe.com.certicom.scolas.model.beans.ClientesOnp;
import pe.com.certicom.scolas.model.beans.Dispensador;
import pe.com.certicom.scolas.model.beans.TipoAtencion;
import pe.com.certicom.scolas.model.beans.TipoTicket;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface AuthenticationService {

	public List<Dispensador> selectDispensadorByCriteria(CriteriaManager criteriaManager)throws Exception;
	
	
	public Integer autenticarUsuario (String usuario , String clave) throws Exception;
}
