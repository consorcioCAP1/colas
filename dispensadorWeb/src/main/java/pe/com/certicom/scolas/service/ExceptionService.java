package pe.com.certicom.scolas.service;

import org.jboss.logging.Logger;



public interface ExceptionService {

	public void sendException(Exception e, Logger logger);

}
