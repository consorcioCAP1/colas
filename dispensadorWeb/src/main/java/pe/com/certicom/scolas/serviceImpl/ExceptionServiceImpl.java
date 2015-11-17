package pe.com.certicom.scolas.serviceImpl;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.stereotype.Service;
import pe.com.certicom.scolas.service.ExceptionService;

@Service
public class ExceptionServiceImpl implements ExceptionService {
	
 
	
	public void sendException(Exception e, Logger logger) {
		logger.log(Level.ERROR, e);
		/*StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		FacesUtil.setMessageError(SEOCommonConstants.DATOS_NO_GUARDADOS , errors.toString());
		
		Map<String, Object> velocityparam = new HashMap<String, Object>();
		velocityparam.put("detalleMensaje", errors.toString());
		try {
			seoService.sendMailTemplate(LSACommonConstants.CORREO_TEMPLATE_ERROR_WEB_SEO, LSACommonConstants.GRUPO_CORREO_ERROR_WEB_SEO, velocityparam, "ERROR EN WEB SEO", false);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		*/
		e.printStackTrace();
	}

}
