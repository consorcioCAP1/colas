/**
 * ServicioRucAdmColWebServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.certicom.scolas.model.client;

public class ServicioRucAdmColWebServiceImplServiceLocator extends org.apache.axis.client.Service implements pe.com.certicom.scolas.model.client.ServicioRucAdmColWebServiceImplService {

    public ServicioRucAdmColWebServiceImplServiceLocator() {
    }


    public ServicioRucAdmColWebServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioRucAdmColWebServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioRucAdmColWebServiceImplPort
    private java.lang.String ServicioRucAdmColWebServiceImplPort_address = "http://wssunat:8080/cl-ti-iaconsultaruc-ws/ServicioRucAdmColService.htm";

    public java.lang.String getServicioRucAdmColWebServiceImplPortAddress() {
        return ServicioRucAdmColWebServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioRucAdmColWebServiceImplPortWSDDServiceName = "ServicioRucAdmColWebServiceImplPort";

    public java.lang.String getServicioRucAdmColWebServiceImplPortWSDDServiceName() {
        return ServicioRucAdmColWebServiceImplPortWSDDServiceName;
    }

    public void setServicioRucAdmColWebServiceImplPortWSDDServiceName(java.lang.String name) {
        ServicioRucAdmColWebServiceImplPortWSDDServiceName = name;
    }

    public pe.com.certicom.scolas.model.client.ServicioRucAdmColWebService getServicioRucAdmColWebServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioRucAdmColWebServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioRucAdmColWebServiceImplPort(endpoint);
    }

    public pe.com.certicom.scolas.model.client.ServicioRucAdmColWebService getServicioRucAdmColWebServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	pe.com.certicom.scolas.model.client.ServicioRucAdmColWebServiceImplPortBindingStub _stub = new pe.com.certicom.scolas.model.client.ServicioRucAdmColWebServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getServicioRucAdmColWebServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioRucAdmColWebServiceImplPortEndpointAddress(java.lang.String address) {
        ServicioRucAdmColWebServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.com.certicom.scolas.model.client.ServicioRucAdmColWebService.class.isAssignableFrom(serviceEndpointInterface)) {
            	pe.com.certicom.scolas.model.client.ServicioRucAdmColWebServiceImplPortBindingStub _stub = new pe.com.certicom.scolas.model.client.ServicioRucAdmColWebServiceImplPortBindingStub(new java.net.URL(ServicioRucAdmColWebServiceImplPort_address), this);
                _stub.setPortName(getServicioRucAdmColWebServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioRucAdmColWebServiceImplPort".equals(inputPortName)) {
            return getServicioRucAdmColWebServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.consultarucws.registro.servicio2.sunat.gob.pe/", "ServicioRucAdmColWebServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.consultarucws.registro.servicio2.sunat.gob.pe/", "ServicioRucAdmColWebServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioRucAdmColWebServiceImplPort".equals(portName)) {
            setServicioRucAdmColWebServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
