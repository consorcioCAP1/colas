package pe.com.certicom.scolas.model.service;


import pe.com.certicom.scolas.model.beans.ClientesOnp;


public interface ClientesONPService  extends ServiceTemplate<ClientesOnp, Integer> {

	
	public ClientesOnp selectByPrimaryKeyString(String primaryKey) throws Exception ;

}

