package pe.com.certicom.scolas.model.service;


import pe.com.certicom.scolas.model.beans.UsuarioPerfil;


public interface UsuarioPerfilService  extends ServiceTemplate<UsuarioPerfil, Integer> {

	public 	int deleteBeanB(UsuarioPerfil bean) throws Exception;

	public int insertBeanB(UsuarioPerfil up)throws Exception;
}

