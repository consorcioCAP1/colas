package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.Usuario;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface UsuarioMapper {
    int deleteByPrimaryKey(Integer idUsuario);

    int insert(Usuario record);

    int insertSelective(Usuario record);

    List<Usuario> selectByExample(CriteriaManager example);

    Usuario selectByPrimaryKey(Integer idUsuario);

    int updateByPrimaryKeySelective(Usuario record);

    int updateByPrimaryKey(Usuario record);
    int selectMaxId ();
}