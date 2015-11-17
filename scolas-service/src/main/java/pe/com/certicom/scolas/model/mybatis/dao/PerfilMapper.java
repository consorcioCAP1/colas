package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.Perfil;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface PerfilMapper {
    int deleteByPrimaryKey(Short idPerfil);

    int insert(Perfil record);

    int insertSelective(Perfil record);

    List<Perfil> selectByExample(CriteriaManager example);

    Perfil selectByPrimaryKey(Short idPerfil);

    int updateByPrimaryKeySelective(Perfil record);

    int updateByPrimaryKey(Perfil record);
}