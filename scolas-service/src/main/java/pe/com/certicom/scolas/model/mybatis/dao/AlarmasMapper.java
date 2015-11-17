package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.Alarmas;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface AlarmasMapper {
    int deleteByPrimaryKey(Integer idAlarmas);

    int insert(Alarmas record);

    int insertSelective(Alarmas record);

    List<Alarmas> selectByExample(CriteriaManager example);

    Alarmas selectByPrimaryKey(Integer idAlarmas);

    int updateByPrimaryKeySelective(Alarmas record);

    int updateByPrimaryKey(Alarmas record);
}