package pe.com.certicom.scolas.service;

import java.util.List;

import pe.com.certicom.scolas.model.beans.TextoTicket;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.util.CriteriaManager;
import pe.com.certicom.scolas.util.ImpresoraNoDisponibleException;

public interface ImpresoraService {
	
	public List<TextoTicket> listarTextoTicketByCriteria(CriteriaManager criteriaManager) throws Exception;
	
	public void inicializar(String modeloPrint) throws ImpresoraNoDisponibleException;
	
	public boolean imprimirImage();
	
	public void Transaccion();
	
	public void imprimirLinea(String textoAImprimir,Ticket ticket);
	
	public void finalizar();

	
}
