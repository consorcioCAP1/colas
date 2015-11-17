package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.TipoTicket;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface TipoTicketMapper {
    int deleteByPrimaryKey(Integer idTipoTicket);

    int insert(TipoTicket record);

    int insertSelective(TipoTicket record);

    List<TipoTicket> selectByExample(CriteriaManager example);

    TipoTicket selectByPrimaryKey(Integer idTipoTicket);

    int updateByPrimaryKeySelective(TipoTicket record);

    int updateByPrimaryKey(TipoTicket record);
}