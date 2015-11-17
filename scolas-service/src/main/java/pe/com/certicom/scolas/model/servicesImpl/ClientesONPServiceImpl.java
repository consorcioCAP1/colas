package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.ClientesOnp;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.model.mybatis.dao.ClientesOnpMapper;
import pe.com.certicom.scolas.model.mybatis.dao.TicketMapper;
import pe.com.certicom.scolas.model.service.ClientesONPService;
import pe.com.certicom.scolas.model.service.TicketService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class ClientesONPServiceImpl  implements ClientesONPService{

	@Autowired
	private ClientesOnpMapper clienteONPMapper;

	@Override
	public int save(ClientesOnp bean) throws Exception {
		if(bean.getDni() == null)
			return clienteONPMapper.insertSelective(bean);
		else
			return clienteONPMapper.updateByPrimaryKeySelective(bean);
	}

	@Override
	public int deleteBean(Integer primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<ClientesOnp> select(CriteriaManager criteriaManager)
			throws Exception {		
		return null;
	}



	@Override
	public ClientesOnp selectByPrimaryKeyString(String primaryKey) throws Exception {
		
		return clienteONPMapper.selectByPrimaryKey(primaryKey);
	}



	@Override
	public int insertBean(ClientesOnp bean) throws Exception {
	
		return clienteONPMapper.insertSelective(bean);
	}



	@Override
	public ClientesOnp selectByPrimaryKey(Integer primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
