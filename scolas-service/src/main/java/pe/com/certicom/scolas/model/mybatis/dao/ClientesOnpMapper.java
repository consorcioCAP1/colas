package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.ClientesOnp;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface ClientesOnpMapper {
    int deleteByPrimaryKey(String dni);

    int insert(ClientesOnp record);

    int insertSelective(ClientesOnp record);

    List<ClientesOnp> selectByExample(CriteriaManager example);

    ClientesOnp selectByPrimaryKey(String dni);

    int updateByPrimaryKeySelective(ClientesOnp record);

    int updateByPrimaryKey(ClientesOnp record);
}