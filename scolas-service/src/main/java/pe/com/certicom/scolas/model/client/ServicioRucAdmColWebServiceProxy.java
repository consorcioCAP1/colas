package pe.com.certicom.scolas.model.client;
import java.rmi.RemoteException;


public class ServicioRucAdmColWebServiceProxy implements   pe.com.certicom.scolas.model.client.ServicioRucAdmColWebService {
  private String _endpoint = null;
  private  pe.com.certicom.scolas.model.client.ServicioRucAdmColWebService servicioRucAdmColWebService = null;
  
  public ServicioRucAdmColWebServiceProxy() {
    _initServicioRucAdmColWebServiceProxy();
  }
  
  public ServicioRucAdmColWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioRucAdmColWebServiceProxy();
  }
  
  private void _initServicioRucAdmColWebServiceProxy() {
    try {
      servicioRucAdmColWebService = (new  pe.com.certicom.scolas.model.client.ServicioRucAdmColWebServiceImplServiceLocator()).getServicioRucAdmColWebServiceImplPort();
      if (servicioRucAdmColWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioRucAdmColWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioRucAdmColWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioRucAdmColWebService != null)
      ((javax.xml.rpc.Stub)servicioRucAdmColWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public  pe.com.certicom.scolas.model.client.ServicioRucAdmColWebService getServicioRucAdmColWebService() {
    if (servicioRucAdmColWebService == null)
      _initServicioRucAdmColWebServiceProxy();
    return servicioRucAdmColWebService;
  }
  
  public   pe.com.certicom.scolas.model.client.RucByTitularBean buscarRucByTitular(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (servicioRucAdmColWebService == null)
      _initServicioRucAdmColWebServiceProxy();
    return servicioRucAdmColWebService.buscarRucByTitular(arg0, arg1);
  }
  
  public  pe.com.certicom.scolas.model.client.RucByRucBean buscarRuc(java.lang.String arg0) throws java.rmi.RemoteException{
    if (servicioRucAdmColWebService == null)
      _initServicioRucAdmColWebServiceProxy();
    return servicioRucAdmColWebService.buscarRuc(arg0);
  }
  
  public  pe.com.certicom.scolas.model.client.RucByRucBean[] buscarRucByRepreLegal(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (servicioRucAdmColWebService == null)
      _initServicioRucAdmColWebServiceProxy();
    return servicioRucAdmColWebService.buscarRucByRepreLegal(arg0, arg1);
  }
  
  
}