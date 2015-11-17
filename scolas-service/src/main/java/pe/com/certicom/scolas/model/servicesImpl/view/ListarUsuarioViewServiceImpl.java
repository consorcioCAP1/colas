package pe.com.certicom.scolas.model.servicesImpl.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.view.ListarPerfilesUsuario;
import pe.com.certicom.scolas.model.mybatis.dao.view.ListarUsuarioMapper;
import pe.com.certicom.scolas.model.service.view.ListarUsuarioViewService;
import pe.com.certicom.scolas.util.CriteriaManager;

@Service
public class ListarUsuarioViewServiceImpl implements ListarUsuarioViewService {

	@Autowired	
	private ListarUsuarioMapper listarUsuarioDao;
	
	public List<ListarPerfilesUsuario> selectPerfilesPorUsuario(
			CriteriaManager example) throws Exception {
		
		return listarUsuarioDao.selectPerfilesPorUsuario(example);
	}

}
