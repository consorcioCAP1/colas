package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Ticket;
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


	
}
