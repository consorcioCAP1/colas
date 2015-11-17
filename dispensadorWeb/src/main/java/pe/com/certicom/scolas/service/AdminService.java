package pe.com.certicom.scolas.service;

import java.util.List;

import pe.com.certicom.scolas.model.beans.ClientesOnp;
import pe.com.certicom.scolas.model.beans.Dispensador;
import pe.com.certicom.scolas.model.beans.TipoAtencion;
import pe.com.certicom.scolas.model.beans.TipoTicket;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface AdminService {

	public List<TipoAtencion>listarTipoAtencionByCriteria(CriteriaManager criteriaManager) throws Exception;
	
	public List<TipoTicket>listarTipoTicketByCriteria(CriteriaManager criteriaManager) throws Exception;
	
	public Ticket generarTicket (Ticket bean) throws Exception;
	
	public ClientesOnp selectClienteONPByPrimaryKey(String dni) throws Exception;
	
	public void saveCLienteOnp(ClientesOnp cli) throws Exception;
	
	public List<Ticket> selectTicketByCriteria(CriteriaManager criteriaManager)throws Exception;
	
	public List<Dispensador> selectDispensadorByCriteria(CriteriaManager criteriaManager)throws Exception;
	
	public Ticket buscarRucByTitular(String tipoDocumento,String numeroDocumento,Boolean esTitular) throws Exception;
	
	public List<Ticket> buscarRucByRepreLegal(String tipoDocumento,String numeroDocumento)throws Exception;
	
}
