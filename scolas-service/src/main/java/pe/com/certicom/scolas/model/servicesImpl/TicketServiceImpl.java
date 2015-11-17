package pe.com.certicom.scolas.model.servicesImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.model.client.RucByRucBean;
import pe.com.certicom.scolas.model.client.RucByTitularBean;
import pe.com.certicom.scolas.model.client.ServicioRucAdmColWebServiceProxy;
import pe.com.certicom.scolas.model.mybatis.dao.TicketMapper;
import pe.com.certicom.scolas.model.service.TicketService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class TicketServiceImpl  implements TicketService{

	@Autowired
	private TicketMapper ticketMapper;

	@Override
	public int save(Ticket bean) throws Exception {
		if(bean.getIdTicket() == null)
			return ticketMapper.insertSelective(bean);
		else
			return ticketMapper.updateByPrimaryKeySelective(bean);
	}

	@Override
	public List<Ticket> select(CriteriaManager criteriaManager)
			throws Exception {
		return ticketMapper.selectByExample(criteriaManager);
	}

	@Override
	public Ticket selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return ticketMapper.selectByPrimaryKey(primaryKey);
	}

	@Override
	public int insertBean(Ticket bean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBean(Integer primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer selectMaxOrden(Ticket bean) throws Exception {
		Integer maximo = ticketMapper.selectMaxOrden(bean);
		if(maximo==null)return 1;
		else return maximo;
	}

	public void updateAletar() throws Exception{
		ticketMapper.updateAletar();
	}

	
	public List<Ticket> buscarRucByRepreLegal(String tipoDocumento,String numeroDocumento) throws Exception {
//		try {
//			
//			ServicioRucAdmColWebServiceProxy servicio= new  ServicioRucAdmColWebServiceProxy();
//			RucByRucBean[]  	arrayRucBean;
//			arrayRucBean = servicio.buscarRucByRepreLegal(tipoDocumento,numeroDocumento);
//				
//			if(arrayRucBean!=null) {
//			
//				List<Ticket> lstTicket= new ArrayList<Ticket>();
//				
//				for(RucByRucBean b : arrayRucBean){
//					Ticket ticketBean = new Ticket();
//					ticketBean.setNombrePersona(b.getNombre());
//					ticketBean.setNombreCliente(b.getNombre());
//					ticketBean.setUbigeoRUC(b.getUbigeoRuc());
//					ticketBean.setUbigeoDescripcion(ticketMapper.selectUbigeoByCodigo(b.getUbigeoRuc()));
//					ticketBean.setRuc(b.getNumRuc());
//					ticketBean.setCodRestricDomicilio(b.getIndResDom());
//					ticketBean.setCodEstadoContribuyente(b.getEstado());
//					ticketBean.setEstadoContribuyente(b.getEstadoDesc());
//					ticketBean.setCodCondicionDomicilio(b.getFlag22());
//					ticketBean.setCondicionDomicilio(b.getFlag22Desc());
//					ticketBean.setCodDependencia(b.getNumReg());
//					ticketBean.setNombreDependencia(b.getNumRegDesc());
//					
//					lstTicket.add(ticketBean);			
//				}
//				return lstTicket;
//			}
//			
//
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		return null;
		
		
			List<Ticket> lstTicket= new ArrayList<Ticket>();
			
			Ticket ticketBean = new Ticket();
			ticketBean.setNombrePersona("omar de la cruz");
			ticketBean.setNombreCliente("omar de la cruz");
			ticketBean.setUbigeoRUC("010108");			
			ticketBean.setRuc("47810085100");			
			ticketBean.setUbigeoDescripcion(ticketMapper.selectUbigeoByCodigo("010106"));			
			ticketBean.setCodRestricDomicilio("12");
			ticketBean.setCodEstadoContribuyente("123");
			ticketBean.setEstadoContribuyente("no pasa nada");
			ticketBean.setNombreDependencia("no habido");
			ticketBean.setCodDependencia("22");
			ticketBean.setCodCondicionDomicilio("00");
			ticketBean.setCondicionDomicilio("HABIDO");
			lstTicket.add(ticketBean);
			
			Ticket ticketBean2 = new Ticket();
			ticketBean2.setNombrePersona("21212123");
			ticketBean2.setNombreCliente("fdsfsdfsd");
			ticketBean2.setUbigeoRUC("010108");
			ticketBean2.setUbigeoDescripcion(ticketMapper.selectUbigeoByCodigo("030608"));
			ticketBean2.setRuc("15484512454");
			ticketBean2.setCodRestricDomicilio("12");
			ticketBean2.setCodEstadoContribuyente("123");
			ticketBean2.setEstadoContribuyente("kjnkjnm,nijnkjn");
			ticketBean2.setNombreDependencia("no habido");
			ticketBean2.setCodDependencia("22");
			ticketBean2.setCodCondicionDomicilio("00");
			ticketBean2.setCondicionDomicilio("HABIDO");
			lstTicket.add(ticketBean2);
			
			
			
	
			return lstTicket;
			
			
	}
	public Ticket buscarRucByTitular(String tipoDocumento,String numeroDocumento,Boolean esTitular) throws Exception {
//		try {
//			
//			ServicioRucAdmColWebServiceProxy servicio= new  ServicioRucAdmColWebServiceProxy();
//			Ticket ticketBean = new Ticket();
//		if(esTitular){
//			
//			RucByTitularBean 	rucBean;
//			rucBean = servicio.buscarRucByTitular(tipoDocumento,numeroDocumento);
//			
//			if(rucBean!=null) {
//				ticketBean.setNombrePersona(rucBean.getNombre());
//				ticketBean.setNombreCliente(rucBean.getNombre());
//				ticketBean.setUbigeoRUC(rucBean.getUbigeoRuc());
//				ticketBean.setUbigeoDescripcion(ticketMapper.selectUbigeoByCodigo(rucBean.getUbigeoRuc()));		
//				ticketBean.setRuc(rucBean.getNumRuc());
//				ticketBean.setCodRestricDomicilio(rucBean.getIndResDom());
//				ticketBean.setCodEstadoContribuyente(rucBean.getEstado());
//				ticketBean.setEstadoContribuyente(rucBean.getEstadoDesc());
//				ticketBean.setCodCondicionDomicilio(rucBean.getFlag22());
//				ticketBean.setCondicionDomicilio(rucBean.getFlag22Desc());
//				ticketBean.setUbigeo(rucBean.getUbigeo());
//				ticketBean.setCodDependencia(rucBean.getNumReg());
//				ticketBean.setNombreDependencia(rucBean.getNumRegDesc());
//				
//			}
//		}
//			
//		else {
//			RucByRucBean 	rucBean;
//			rucBean = servicio.buscarRuc(numeroDocumento);
//			if(rucBean!=null) {
//			
//				ticketBean.setNombrePersona(rucBean.getNombre());
//				ticketBean.setNombreCliente(rucBean.getNombre());
//				ticketBean.setUbigeoRUC(rucBean.getUbigeoRuc());
//				ticketBean.setUbigeoDescripcion(ticketMapper.selectUbigeoByCodigo(rucBean.getUbigeoRuc()));		
//				ticketBean.setRuc(rucBean.getNumRuc());
//				ticketBean.setCodRestricDomicilio(rucBean.getIndResDom());
//				ticketBean.setCodEstadoContribuyente(rucBean.getEstado());
//				ticketBean.setEstadoContribuyente(rucBean.getEstadoDesc());
//				ticketBean.setCodCondicionDomicilio(rucBean.getFlag22());
//				ticketBean.setCondicionDomicilio(rucBean.getFlag22Desc());
//				ticketBean.setCodDependencia(rucBean.getNumReg());
//				ticketBean.setNombreDependencia(rucBean.getNumRegDesc());
//				
//			}
//			
//		}
//		
//			return ticketBean;
//		
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
	
	
		Ticket ticketBean = new Ticket();

		ticketBean.setNombrePersona("PIERE CARDINI");
		ticketBean.setNombreCliente("PIERE CARDINI");
		ticketBean.setUbigeoRUC("010108");			
		ticketBean.setRuc("47810085200");			
		ticketBean.setUbigeoDescripcion(ticketMapper.selectUbigeoByCodigo("010106"));			
		ticketBean.setCodRestricDomicilio("11");
		ticketBean.setCodEstadoContribuyente("124");
		ticketBean.setEstadoContribuyente("completado por omar");
		ticketBean.setNombreDependencia("habido");
		ticketBean.setCodDependencia("22");
		ticketBean.setCodCondicionDomicilio("00");
		ticketBean.setCondicionDomicilio("HABIDO");
	
		return ticketBean;
	}
	

	
}
