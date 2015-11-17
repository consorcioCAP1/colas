package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.TipoTicket;
import pe.com.certicom.scolas.model.mybatis.dao.TipoTicketMapper;
import pe.com.certicom.scolas.model.service.TipoTicketService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class TipoTicketServiceImpl implements TipoTicketService{

	@Autowired
	private TipoTicketMapper tipoTicketDao;
	
	
	public int save(TipoTicket bean) throws Exception {
		if(bean.getIdTipoAtencion() == null)
			return tipoTicketDao.insertSelective(bean);
		else
			return tipoTicketDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(TipoTicket ta)throws Exception{
		return tipoTicketDao.insertSelective(ta);
	} 
	
	public List<TipoTicket> select(CriteriaManager criteriaManager) throws Exception {
		
		return tipoTicketDao.selectByExample(criteriaManager);
	}
	
	public TipoTicket selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return tipoTicketDao.selectByPrimaryKey(primaryKey);
	}


	public int deleteBean(Integer primaryKey) throws Exception {
	
		return tipoTicketDao.deleteByPrimaryKey(primaryKey);
	}

}
