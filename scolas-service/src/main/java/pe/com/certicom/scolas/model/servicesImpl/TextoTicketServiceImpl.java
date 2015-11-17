package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Peso;
import pe.com.certicom.scolas.model.beans.TextoTicket;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.model.mybatis.dao.TextoTicketMapper;
import pe.com.certicom.scolas.model.mybatis.dao.TicketMapper;
import pe.com.certicom.scolas.model.service.TextoTicketService;
import pe.com.certicom.scolas.model.service.TicketService;
import pe.com.certicom.scolas.util.Criteria;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class TextoTicketServiceImpl  implements TextoTicketService{

	@Autowired
	private TextoTicketMapper textoticketMapper;

	@Override
	public int save(TextoTicket bean) throws Exception {
		if(bean.getIdTextoTicket() == null)
			return textoticketMapper.insertSelective(bean);
		else
			return textoticketMapper.updateByPrimaryKeySelective(bean);
	}

	@Override
	public List<TextoTicket> select(CriteriaManager criteriaManager)
			throws Exception {
	
		return textoticketMapper.selectByExample(criteriaManager);
	}

	@Override
	public TextoTicket selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return textoticketMapper.selectByPrimaryKey(primaryKey);
	}
	
	public int insertBean(TextoTicket bean)throws Exception{
		return textoticketMapper.insertSelective(bean);
	}

	@Override
	public int deleteBean(Integer primaryKey) throws Exception {
		return textoticketMapper.deleteByPrimaryKey(primaryKey);
	} 

}
