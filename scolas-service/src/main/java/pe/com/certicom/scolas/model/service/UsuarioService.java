package pe.com.certicom.scolas.model.service;


import pe.com.certicom.scolas.model.beans.Usuario;


public interface UsuarioService  extends ServiceTemplate<Usuario, Integer> {

public int obtenerUltimoIdUsuario() throws Exception;
}

