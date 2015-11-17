package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Turnos;
import pe.com.certicom.scolas.model.mybatis.dao.TurnosMapper;
import pe.com.certicom.scolas.model.service.TurnosService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class TurnosServiceImpl implements TurnosService{

	@Autowired
	private TurnosMapper turnosDao;
	
	
	public int save(Turnos bean) throws Exception {
		if(bean.getIdTurno() == null)
			return turnosDao.insertSelective(bean);
		else
			return turnosDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(Turnos ta)throws Exception{
		return turnosDao.insertSelective(ta);
	} 
	
	public List<Turnos> select(CriteriaManager criteriaManager) throws Exception {
		
		return turnosDao.selectByExample(criteriaManager);
	}
	
	public Turnos selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return turnosDao.selectByPrimaryKey(primaryKey);
	}


	public int deleteBean(Integer primaryKey) throws Exception {
		
		return turnosDao.deleteByPrimaryKey(primaryKey);
	}

}
