package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Alarmas;
import pe.com.certicom.scolas.model.mybatis.dao.AlarmasMapper;
import pe.com.certicom.scolas.model.service.AlarmasService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class AlarmasServiceImpl implements AlarmasService{

	@Autowired
	private AlarmasMapper alarmasDao;
	
	
	public int save(Alarmas bean) throws Exception {
		if(bean.getIdAlarmas() == null)
			return alarmasDao.insertSelective(bean);
		else
			return alarmasDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(Alarmas us)throws Exception{
		return alarmasDao.insertSelective(us);
	} 
	
	public List<Alarmas> select(CriteriaManager criteriaManager) throws Exception {
		
		return alarmasDao.selectByExample(criteriaManager);
	}
	
	public Alarmas selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return alarmasDao.selectByPrimaryKey(primaryKey);
	}

	
	public int deleteBean(Integer primaryKey) throws Exception {
		
		return alarmasDao.deleteByPrimaryKey(primaryKey);
	}

}
