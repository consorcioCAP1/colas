package pe.com.certicom.scolas.model.service;

import java.util.List;

import pe.com.certicom.scolas.util.CriteriaManager;



public interface ServiceTemplate<B, P> {
	
	public int save(B bean) throws Exception;
	
	public List<B> select(CriteriaManager criteriaManager) throws Exception;
	
	public B selectByPrimaryKey(P primaryKey) throws Exception;
	
	public  int  insertBean(B bean) throws Exception;
	
	public int deleteBean(P primaryKey) throws Exception;
	
	
}
