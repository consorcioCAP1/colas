package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Alarmas;
import pe.com.certicom.scolas.model.beans.Dispensador;
import pe.com.certicom.scolas.model.mybatis.dao.AlarmasMapper;
import pe.com.certicom.scolas.model.mybatis.dao.DispensadorMapper;
import pe.com.certicom.scolas.model.service.AlarmasService;
import pe.com.certicom.scolas.model.service.DispensadorService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class DispensadorServiceImpl implements DispensadorService{

	@Autowired
	private DispensadorMapper dispensadorDao;
	
	
	public int save(Dispensador bean) throws Exception {
		if(bean.getIdDispensador() == null)
			return dispensadorDao.insertSelective(bean);
		else
			return dispensadorDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(Dispensador us)throws Exception{
		return dispensadorDao.insertSelective(us);
	} 
	
	public List<Dispensador> select(CriteriaManager criteriaManager) throws Exception {
		
		return dispensadorDao.selectByExample(criteriaManager);
	}
	
	public Dispensador selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return dispensadorDao.selectByPrimaryKey(primaryKey);
	}

	
	public int deleteBean(Integer primaryKey) throws Exception {
		
		return dispensadorDao.deleteByPrimaryKey(primaryKey);
	}

}
