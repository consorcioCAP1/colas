package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.TipoAtencion;
import pe.com.certicom.scolas.model.mybatis.dao.TipoAtencionMapper;
import pe.com.certicom.scolas.model.service.TipoAtencionService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class TipoAtencionServiceImpl implements TipoAtencionService{

	@Autowired
	private TipoAtencionMapper tipoAtencionDao;
	
	
	public int save(TipoAtencion bean) throws Exception {
		if(bean.getIdTipoAtencion() == null)
			return tipoAtencionDao.insertSelective(bean);
		else
			return tipoAtencionDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(TipoAtencion ta)throws Exception{
		return tipoAtencionDao.insertSelective(ta);
	} 
	
	public List<TipoAtencion> select(CriteriaManager criteriaManager) throws Exception {
		
		return tipoAtencionDao.selectByExample(criteriaManager);
	}
	
	public TipoAtencion selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return tipoAtencionDao.selectByPrimaryKey(primaryKey);
	}


	public int deleteBean(Integer primaryKey) throws Exception {
		
		return tipoAtencionDao.deleteByPrimaryKey(primaryKey);
	}

}
