package pe.com.certicom.scolas.model.service.view;

import java.util.List;

import pe.com.certicom.scolas.model.beans.view.ListarPerfilesUsuario;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface ListarUsuarioViewService {
	public List<ListarPerfilesUsuario> selectPerfilesPorUsuario(CriteriaManager example) throws Exception;

}
