/**
 * ServicioRucAdmColWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.certicom.scolas.model.client;

public interface ServicioRucAdmColWebService extends java.rmi.Remote {
    public  pe.com.certicom.scolas.model.client.RucByTitularBean buscarRucByTitular(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public pe.com.certicom.scolas.model.client.RucByRucBean buscarRuc(java.lang.String arg0) throws java.rmi.RemoteException;
    public  pe.com.certicom.scolas.model.client.RucByRucBean[] buscarRucByRepreLegal(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
