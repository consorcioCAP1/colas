package pe.com.certicom.scolas.model.mybatis.dao.view;

import java.util.List;

import pe.com.certicom.scolas.model.beans.view.ListarPerfilesUsuario;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface ListarUsuarioMapper {
	public List<ListarPerfilesUsuario> selectPerfilesPorUsuario(CriteriaManager example);
}
