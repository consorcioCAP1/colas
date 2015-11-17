package pe.com.certicom.scolas.serviceImpl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import pe.com.certicom.scolas.common.ScolasCommonConstants;
import pe.com.certicom.scolas.model.beans.ClientesOnp;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.model.beans.TipoAtencion;
import pe.com.certicom.scolas.model.beans.TipoTicket;
import pe.com.certicom.scolas.model.service.ClientesONPService;
import pe.com.certicom.scolas.model.service.TicketService;
import pe.com.certicom.scolas.model.service.TipoAtencionService;
import pe.com.certicom.scolas.model.service.TipoTicketService;
import pe.com.certicom.scolas.service.AdminService;
import pe.com.certicom.scolas.util.CriteriaManager;
import pe.com.certicom.scolas.util.FechasUtil;

@Service
public class AdminServiceImpl implements AdminService {

	private static final Logger LOGGER = Logger.getLogger(AdminServiceImpl.class);
	@Autowired
	TipoAtencionService tipoAtencionService;
	
	@Autowired
	TipoTicketService tipoTicketService;
	
	@Autowired 
	TicketService ticketService;
	
	
	@Autowired 
	ClientesONPService	clienteONPService;

	public List<TipoAtencion>listarTipoAtencionByCriteria(CriteriaManager criteriaManager) throws Exception{
				return tipoAtencionService.select(criteriaManager);
	}

	public List<TipoTicket>listarTipoTicketByCriteria(CriteriaManager criteriaManager) throws Exception{
		return tipoTicketService.select(criteriaManager);
	}
	
	public ClientesOnp selectClienteONPByPrimaryKey(String dni) throws Exception{
		return clienteONPService.selectByPrimaryKeyString(dni);
	}
	
	public void saveCLienteOnp(ClientesOnp cli) throws Exception{
		clienteONPService.save(cli);
	}
	
	public Ticket generarTicket (Ticket bean) throws Exception{
		
		ClientesOnp clienteONPBean= clienteONPService.selectByPrimaryKeyString(bean.getDni().trim());
		
		if (clienteONPBean!=null) {
			if(bean.getNombreCliente()==null){
				 bean.setNombreCliente(clienteONPBean.getNombres());	
			} 	
		}
		else {
			ClientesOnp cliente = new ClientesOnp();
			cliente.setDni(bean.getDni().trim());
			if(bean.getNombreCliente()!=null){
				cliente.setNombres(bean.getNombreCliente().trim());
				cliente.setEsDniPorLector(ScolasCommonConstants.UNO_STRING);
				
			 } 
			else {cliente.setNombres("--");
					bean.setNombreCliente("--");
			
				}
			
			clienteONPService.insertBean(cliente);
			
		}
		TipoTicket tipoTicket = tipoTicketService.selectByPrimaryKey(bean.getIdTipoTicket()); 
		bean.setOrden(this.cantidadTicketsEmitidosEnDiaPorTipoTicket(bean.getIdTipoTicket()));
		bean.setCodigoImpresion(tipoTicket.getCodigoImpresion()+bean.getOrden());
		ticketService.save(bean);
		ticketService.updateAletar();		
		return bean;
		
	}

	
	public Integer cantidadTicketsEmitidosEnDiaPorTipoTicket(Integer idTipoTicket) throws Exception {
		Ticket ticketParam = new Ticket();
		ticketParam.setFecha(FechasUtil.getFechaActualSinHora());
		ticketParam.setIdTipoTicket(idTipoTicket);
		return Integer.valueOf(this.ticketService.selectMaxOrden(ticketParam));
	}	
	
	public List<Ticket> selectTicketByCriteria(CriteriaManager criteriaManager)throws Exception{
		return ticketService.select(criteriaManager);
	} 
	
}
