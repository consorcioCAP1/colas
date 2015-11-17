package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;
import pe.com.certicom.scolas.model.beans.UsuarioPerfil;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface UsuarioPerfilMapper {

    int deleteByPrimaryKey(Integer primarykey);
    
    int deleteByBean(UsuarioPerfil record);
    
    int insert(UsuarioPerfil record);

    int insertSelective(UsuarioPerfil record);

    List<UsuarioPerfil> selectByExample(CriteriaManager example);
    
    UsuarioPerfil selectByPrimaryKey(Integer idUsuarioPerfil);

    int updateByPrimaryKeySelective(UsuarioPerfil record);

    int updateByPrimaryKey(UsuarioPerfil record);
}