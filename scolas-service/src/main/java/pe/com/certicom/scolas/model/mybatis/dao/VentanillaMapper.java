package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.Ventanilla;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface VentanillaMapper {
    int deleteByPrimaryKey(Integer idVentanilla);

    int insert(Ventanilla record);

    int insertSelective(Ventanilla record);

    List<Ventanilla> selectByExample(CriteriaManager example);

    Ventanilla selectByPrimaryKey(Integer idVentanilla);

    int updateByPrimaryKeySelective(Ventanilla record);

    int updateByPrimaryKey(Ventanilla record);
}