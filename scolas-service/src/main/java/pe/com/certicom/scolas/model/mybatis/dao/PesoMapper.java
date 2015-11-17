package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.Peso;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface PesoMapper {
    int deleteByPrimaryKey(Integer idPeso);

    int insert(Peso record);

    int insertSelective(Peso record);

    List<Peso> selectByExample(CriteriaManager example);

    Peso selectByPrimaryKey(Integer idPeso);

    int updateByPrimaryKeySelective(Peso record);

    int updateByPrimaryKey(Peso record);
}