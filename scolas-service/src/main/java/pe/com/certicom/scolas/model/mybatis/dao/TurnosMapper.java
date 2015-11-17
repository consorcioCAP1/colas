package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.Turnos;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface TurnosMapper {
    int deleteByPrimaryKey(Integer idTurno);

    int insert(Turnos record);

    int insertSelective(Turnos record);

    List<Turnos> selectByExample(CriteriaManager example);

    Turnos selectByPrimaryKey(Integer idTurno);

    int updateByPrimaryKeySelective(Turnos record);

    int updateByPrimaryKey(Turnos record);
}