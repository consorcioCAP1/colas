package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.TextoTicket;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface TextoTicketMapper {
    int deleteByPrimaryKey(Integer idTextoTicket);

    int insert(TextoTicket record);

    int insertSelective(TextoTicket record);

    List<TextoTicket> selectByExample(CriteriaManager example);

    TextoTicket selectByPrimaryKey(Integer idTextoTicket);

    int updateByPrimaryKeySelective(TextoTicket record);

    int updateByPrimaryKey(TextoTicket record);
}