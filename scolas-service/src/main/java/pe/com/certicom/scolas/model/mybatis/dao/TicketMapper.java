package pe.com.certicom.scolas.model.mybatis.dao;

import java.util.List;

import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.util.CriteriaManager;

public interface TicketMapper {
    int deleteByPrimaryKey(Integer idTicket);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectByExample(CriteriaManager example);

    Ticket selectByPrimaryKey(Integer idTicket);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
    

	Integer selectMaxOrden(Ticket bean);
	
	public void updateAletar();
	
	public String selectUbigeoByCodigo(String idUbigeo);
}