package scolas.core.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.certicom.scolas.model.beans.Usuario;
import pe.com.certicom.scolas.model.service.UsuarioService;
import pe.com.certicom.scolas.util.Criteria;
import pe.com.certicom.scolas.util.CriteriaManager;
import scolas.core.test.SCOLASUnitTest;

public class usuarioTest  extends SCOLASUnitTest{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	public void listarUsuarios(){
		

		try {
			CriteriaManager criteriManager = new  CriteriaManager();
			Criteria criteria= criteriManager.createCriteria();
			criteria.andFieldEqualTo( "id_usuario", 34);
			
		
			List<Usuario> lstUsu= usuarioService.select(criteriManager);
			
			
			if (lstUsu.size()>0){
				System.out.println("este es un ejemplo:"+lstUsu.get(0).getLogin());
				System.out.println("este es un ejemplo:"+lstUsu.get(0).getClave());
				System.out.println("este es un ejemplo:"+lstUsu.get(0).getDni());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
	

}
