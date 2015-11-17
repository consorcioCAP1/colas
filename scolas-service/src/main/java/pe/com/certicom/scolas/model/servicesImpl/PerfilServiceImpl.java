package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Perfil;
import pe.com.certicom.scolas.model.mybatis.dao.PerfilMapper;
import pe.com.certicom.scolas.model.service.PerfilService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilMapper perfilDao;
	
	
	public int save(Perfil bean) throws Exception {
		if(bean.getIdPerfil()== null)
			return perfilDao.insertSelective(bean);
		else
			return perfilDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(Perfil per)throws Exception{
		return perfilDao.insertSelective(per);
	} 
	
	public List<Perfil> select(CriteriaManager criteriaManager) throws Exception {
		
		return perfilDao.selectByExample(criteriaManager);
	}
	
	public Perfil selectByPrimaryKey(Short primaryKey) throws Exception {
		
		return perfilDao.selectByPrimaryKey(primaryKey);
	}


	public int deleteBean(Short primaryKey) throws Exception {
		
		return perfilDao.deleteByPrimaryKey(primaryKey);
	}


}
