package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Peso;
import pe.com.certicom.scolas.model.mybatis.dao.PesoMapper;
import pe.com.certicom.scolas.model.service.PesoService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class PesoServiceImpl implements PesoService{

	@Autowired
	private PesoMapper pesoDao;
	
	
	public int save(Peso bean) throws Exception {
		if(bean.getIdPeso()== null)
			return pesoDao.insertSelective(bean);
		else
			return pesoDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(Peso pe)throws Exception{
		return pesoDao.insertSelective(pe);
	} 
	
	public List<Peso> select(CriteriaManager criteriaManager) throws Exception {
		
		return pesoDao.selectByExample(criteriaManager);
	}
	
	public Peso selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return pesoDao.selectByPrimaryKey(primaryKey);
	}

	
	public int deleteBean(Integer primaryKey) throws Exception {
	
		return pesoDao.deleteByPrimaryKey(primaryKey);
	}


}
