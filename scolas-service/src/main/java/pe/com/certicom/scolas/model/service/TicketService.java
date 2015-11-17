package pe.com.certicom.scolas.model.service;


import pe.com.certicom.scolas.model.beans.Ticket;

public interface TicketService  extends ServiceTemplate<Ticket, Integer> {

	
	public Integer selectMaxOrden(Ticket bean) throws Exception ;
	
	public void updateAletar() throws Exception;
}

