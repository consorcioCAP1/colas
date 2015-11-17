package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.UsuarioPerfil;
import pe.com.certicom.scolas.model.mybatis.dao.UsuarioPerfilMapper;
import pe.com.certicom.scolas.model.service.UsuarioPerfilService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class UsuarioPerfilServiceImpl implements UsuarioPerfilService{

	@Autowired
	private UsuarioPerfilMapper usuarioPerfilDao;
	
	
	public int save(UsuarioPerfil bean) throws Exception {
		if(bean.getIdPerfil() == null)
			return usuarioPerfilDao.insertSelective(bean);
		else
			return usuarioPerfilDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(UsuarioPerfil up)throws Exception{
		return usuarioPerfilDao.insertSelective(up);
	} 
	
	public int insertBeanB(UsuarioPerfil up)throws Exception{
		return usuarioPerfilDao.insert(up);
	} 
	
	
	public List<UsuarioPerfil> select(CriteriaManager criteriaManager) throws Exception {
		
		return usuarioPerfilDao.selectByExample(criteriaManager);
	}
	
	public UsuarioPerfil selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return usuarioPerfilDao.selectByPrimaryKey(primaryKey);
	}

	
	public int deleteBean(Integer primaryKey) throws Exception {
		
		return usuarioPerfilDao.deleteByPrimaryKey(primaryKey);
	}

	public int deleteBeanB(UsuarioPerfil up) throws Exception {
		
		return usuarioPerfilDao.deleteByBean(up);
	}

	
}
