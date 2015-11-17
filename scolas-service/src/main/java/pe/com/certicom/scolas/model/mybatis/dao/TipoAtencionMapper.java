package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.TipoAtencion;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface TipoAtencionMapper {
    int deleteByPrimaryKey(Integer idTipoAtencion);

    int insert(TipoAtencion record);

    int insertSelective(TipoAtencion record);

    List<TipoAtencion> selectByExample(CriteriaManager example);

    TipoAtencion selectByPrimaryKey(Integer idTipoAtencion);

    int updateByPrimaryKeySelective(TipoAtencion record);

    int updateByPrimaryKey(TipoAtencion record);
}