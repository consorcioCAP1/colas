package pe.com.certicom.scolas.model.service;


import java.util.List;

import pe.com.certicom.scolas.model.beans.Ticket;

public interface TicketService  extends ServiceTemplate<Ticket, Integer> {

	
	public Integer selectMaxOrden(Ticket bean) throws Exception ;
	
	public void updateAletar() throws Exception;
	
	public List<Ticket> buscarRucByRepreLegal(String tipoDocumento,String numeroDocumento) throws Exception;
	
	public Ticket buscarRucByTitular(String tipoDocumento,String numeroDocumento,Boolean esTitular) throws Exception;
}

