package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.Dispensador;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface DispensadorMapper {
    int deleteByPrimaryKey(Integer idDispensador);

    int insert(Dispensador record);

    int insertSelective(Dispensador record);

    List<Dispensador> selectByExample(CriteriaManager example);

    Dispensador selectByPrimaryKey(Integer idDispensador);

    int updateByPrimaryKeySelective(Dispensador record);

    int updateByPrimaryKey(Dispensador record);
}