package pe.com.certicom.scolas.model.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.certicom.scolas.model.beans.Ventanilla;
import pe.com.certicom.scolas.model.mybatis.dao.VentanillaMapper;
import pe.com.certicom.scolas.model.service.VentanillaService;
import pe.com.certicom.scolas.util.CriteriaManager;


@Service
public class VentanillaServiceImpl implements VentanillaService{

	@Autowired
	private VentanillaMapper ventanillaDao;
	
	
	public int save(Ventanilla bean) throws Exception {
		if(bean.getIdUsuario() == null)
			return ventanillaDao.insertSelective(bean);
		else
			return ventanillaDao.updateByPrimaryKeySelective(bean);
	}
	
	public int insertBean(Ventanilla up)throws Exception{
		return ventanillaDao.insertSelective(up);
	} 
	
	public List<Ventanilla> select(CriteriaManager criteriaManager) throws Exception {
		
		return ventanillaDao.selectByExample(criteriaManager);
	}
	
	public Ventanilla selectByPrimaryKey(Integer primaryKey) throws Exception {
		
		return ventanillaDao.selectByPrimaryKey(primaryKey);
	}

	public int deleteBean(Integer primaryKey) throws Exception {

		return ventanillaDao.deleteByPrimaryKey(primaryKey);
	}

}
