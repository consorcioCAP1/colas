package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Usuario;
import pe.com.certicom.scolas.model.mybatis.dao.UsuarioMapper;
import pe.com.certicom.scolas.model.service.UsuarioService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioMapper usuarioDao;
	
	
	public int save(Usuario bean) throws Exception {
		if(bean.getIdUsuario() == null)
			return usuarioDao.insertSelective(bean);
		else
			return usuarioDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(Usuario us)throws Exception{
	
		return usuarioDao.insertSelective(us);
	} 
	
	public List<Usuario> select(CriteriaManager criteriaManager) throws Exception {
		
		return usuarioDao.selectByExample(criteriaManager);
	}
	
	public Usuario selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return usuarioDao.selectByPrimaryKey(primaryKey);
	}


	public int deleteBean(Integer primaryKey) throws Exception {
		
		return usuarioDao.deleteByPrimaryKey(primaryKey);
	}

	
	public int obtenerUltimoIdUsuario() throws Exception {
		
		return usuarioDao.selectMaxId();
	}
}
