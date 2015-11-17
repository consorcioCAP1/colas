package pe.com.certicom.scolas.serviceImpl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.common.ScolasCommonConstants;
import pe.com.certicom.scolas.model.beans.Dispensador;
import pe.com.certicom.scolas.model.beans.Usuario;
import pe.com.certicom.scolas.model.beans.UsuarioPerfil;
import pe.com.certicom.scolas.model.service.DispensadorService;
import pe.com.certicom.scolas.model.service.UsuarioPerfilService;
import pe.com.certicom.scolas.model.service.UsuarioService;
import pe.com.certicom.scolas.service.AuthenticationService;
import pe.com.certicom.scolas.util.Criteria;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired 
	DispensadorService dispensadorService;

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioPerfilService usuarioPerfilService;
	
	public List<Dispensador> selectDispensadorByCriteria(CriteriaManager criteriaManager)throws Exception{
		return dispensadorService.select(criteriaManager);
	} 
	
	public Integer autenticarUsuario (String usuario , String clave) throws Exception{
		
		
		try {
		
			List<Usuario> lstUsers = null;
			CriteriaManager criteriManager = new  CriteriaManager();
			Criteria criteria= criteriManager.createCriteria();
			criteria.andFieldEqualTo( "login",usuario);
			criteria.andFieldEqualTo( "clave",clave);
			
			
			lstUsers= usuarioService.select(criteriManager);
			
			if (lstUsers.size()>0 ){
				
				Usuario usuarioBean = new  Usuario();
				usuarioBean=  lstUsers.get(0);
				
			    CriteriaManager criteriaManagerPerfil = new CriteriaManager();
			    criteriaManagerPerfil.createCriteria().andFieldEqualTo("id_perfil", ScolasCommonConstants.CINCO_STRING).
			    andFieldEqualTo("id_usuario", usuarioBean.getIdUsuario());
			    List<UsuarioPerfil> lstusuarioPerfil= usuarioPerfilService.select(criteriaManagerPerfil);
			    
			    if(lstusuarioPerfil.size()>0){
			    	return ScolasCommonConstants.UNO;
			    }
			    else {
			    	return ScolasCommonConstants.TRES;
			    }
				
			}
			else {
				return ScolasCommonConstants.DOS;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	
}
