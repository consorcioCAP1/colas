package pe.com.certicom.scolas.model.beans;

import java.util.Date;

public class Ticket {
    private Integer idTicket;

    private Date fecha;

    private Integer idTipoTicket;

    private Integer orden;

    private String nombreCliente;

    private Date horaEmision;

    private Date horaAsignacion;

    private Date horaInicioAtencion;

    private Date horaFinAtencion;

    private Integer idEstado;

    private Integer idVentanilla;

    private Integer idUsuario;

    private String flagMigracion;

    private Integer idBotonEncuesta;

    private Date horaClicLlegada;

    private Byte prellamado;

    private Byte conClicLlegada;

    private Integer idArea;

    private Integer idDispensador;

    private String dni;

    private String ruc;

    private Date horaRellamada;

    private Integer idUbigeo;

    private Boolean esDerivadoSector;

    private Boolean derivadoSectorEnvia;

    private Integer idTipoDocumento;

    private Integer idTipoServicioRuc;

    private String codCondicionDomicilio;

    private String codRestricDomicilio;

    private String codEstadoContribuyente;

    private String codDependencia;

    private String nombreDependencia;

    private String razonSocial;

    private Integer idOficina;

    private Boolean derivado;

    private String codGeneradoCab;

    private String nombrePersona;

    private String condicionDomicilio;

    private String estadoContribuyente;

    private String codExpediente;

    private String codSolicitud;

    private Boolean esTitular;

    private Integer idTipoVentanilla;

    private String numeroticket;

    private Boolean esApoderado;

    private Boolean esTercero;

    private Integer numLlamados;

    private Integer idTicketDerreac;

    private Boolean reactivado;

    private String indDerivadoPrioridad;

    private String codigoImpresion;

    private Integer idPrecola;

    private String indTicketInterno;

    private String indTipoLlamado;

    private String ubigeo;

    private Date fechanac;

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdTipoTicket() {
        return idTipoTicket;
    }

    public void setIdTipoTicket(Integer idTipoTicket) {
        this.idTipoTicket = idTipoTicket;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getHoraEmision() {
        return horaEmision;
    }

    public void setHoraEmision(Date horaEmision) {
        this.horaEmision = horaEmision;
    }

    public Date getHoraAsignacion() {
        return horaAsignacion;
    }

    public void setHoraAsignacion(Date horaAsignacion) {
        this.horaAsignacion = horaAsignacion;
    }

    public Date getHoraInicioAtencion() {
        return horaInicioAtencion;
    }

    public void setHoraInicioAtencion(Date horaInicioAtencion) {
        this.horaInicioAtencion = horaInicioAtencion;
    }

    public Date getHoraFinAtencion() {
        return horaFinAtencion;
    }

    public void setHoraFinAtencion(Date horaFinAtencion) {
        this.horaFinAtencion = horaFinAtencion;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdVentanilla() {
        return idVentanilla;
    }

    public void setIdVentanilla(Integer idVentanilla) {
        this.idVentanilla = idVentanilla;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFlagMigracion() {
        return flagMigracion;
    }

    public void setFlagMigracion(String flagMigracion) {
        this.flagMigracion = flagMigracion;
    }

    public Integer getIdBotonEncuesta() {
        return idBotonEncuesta;
    }

    public void setIdBotonEncuesta(Integer idBotonEncuesta) {
        this.idBotonEncuesta = idBotonEncuesta;
    }

    public Date getHoraClicLlegada() {
        return horaClicLlegada;
    }

    public void setHoraClicLlegada(Date horaClicLlegada) {
        this.horaClicLlegada = horaClicLlegada;
    }

    public Byte getPrellamado() {
        return prellamado;
    }

    public void setPrellamado(Byte prellamado) {
        this.prellamado = prellamado;
    }

    public Byte getConClicLlegada() {
        return conClicLlegada;
    }

    public void setConClicLlegada(Byte conClicLlegada) {
        this.conClicLlegada = conClicLlegada;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdDispensador() {
        return idDispensador;
    }

    public void setIdDispensador(Integer idDispensador) {
        this.idDispensador = idDispensador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Date getHoraRellamada() {
        return horaRellamada;
    }

    public void setHoraRellamada(Date horaRellamada) {
        this.horaRellamada = horaRellamada;
    }

    public Integer getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(Integer idUbigeo) {
        this.idUbigeo = idUbigeo;
    }

    public Boolean getEsDerivadoSector() {
        return esDerivadoSector;
    }

    public void setEsDerivadoSector(Boolean esDerivadoSector) {
        this.esDerivadoSector = esDerivadoSector;
    }

    public Boolean getDerivadoSectorEnvia() {
        return derivadoSectorEnvia;
    }

    public void setDerivadoSectorEnvia(Boolean derivadoSectorEnvia) {
        this.derivadoSectorEnvia = derivadoSectorEnvia;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getIdTipoServicioRuc() {
        return idTipoServicioRuc;
    }

    public void setIdTipoServicioRuc(Integer idTipoServicioRuc) {
        this.idTipoServicioRuc = idTipoServicioRuc;
    }

    public String getCodCondicionDomicilio() {
        return codCondicionDomicilio;
    }

    public void setCodCondicionDomicilio(String codCondicionDomicilio) {
        this.codCondicionDomicilio = codCondicionDomicilio;
    }

    public String getCodRestricDomicilio() {
        return codRestricDomicilio;
    }

    public void setCodRestricDomicilio(String codRestricDomicilio) {
        this.codRestricDomicilio = codRestricDomicilio;
    }

    public String getCodEstadoContribuyente() {
        return codEstadoContribuyente;
    }

    public void setCodEstadoContribuyente(String codEstadoContribuyente) {
        this.codEstadoContribuyente = codEstadoContribuyente;
    }

    public String getCodDependencia() {
        return codDependencia;
    }

    public void setCodDependencia(String codDependencia) {
        this.codDependencia = codDependencia;
    }

    public String getNombreDependencia() {
        return nombreDependencia;
    }

    public void setNombreDependencia(String nombreDependencia) {
        this.nombreDependencia = nombreDependencia;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
    }

    public Boolean getDerivado() {
        return derivado;
    }

    public void setDerivado(Boolean derivado) {
        this.derivado = derivado;
    }

    public String getCodGeneradoCab() {
        return codGeneradoCab;
    }

    public void setCodGeneradoCab(String codGeneradoCab) {
        this.codGeneradoCab = codGeneradoCab;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getCondicionDomicilio() {
        return condicionDomicilio;
    }

    public void setCondicionDomicilio(String condicionDomicilio) {
        this.condicionDomicilio = condicionDomicilio;
    }

    public String getEstadoContribuyente() {
        return estadoContribuyente;
    }

    public void setEstadoContribuyente(String estadoContribuyente) {
        this.estadoContribuyente = estadoContribuyente;
    }

    public String getCodExpediente() {
        return codExpediente;
    }

    public void setCodExpediente(String codExpediente) {
        this.codExpediente = codExpediente;
    }

    public String getCodSolicitud() {
        return codSolicitud;
    }

    public void setCodSolicitud(String codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

    public Boolean getEsTitular() {
        return esTitular;
    }

    public void setEsTitular(Boolean esTitular) {
        this.esTitular = esTitular;
    }

    public Integer getIdTipoVentanilla() {
        return idTipoVentanilla;
    }

    public void setIdTipoVentanilla(Integer idTipoVentanilla) {
        this.idTipoVentanilla = idTipoVentanilla;
    }

    public String getNumeroticket() {
        return numeroticket;
    }

    public void setNumeroticket(String numeroticket) {
        this.numeroticket = numeroticket;
    }

    public Boolean getEsApoderado() {
        return esApoderado;
    }

    public void setEsApoderado(Boolean esApoderado) {
        this.esApoderado = esApoderado;
    }

    public Boolean getEsTercero() {
        return esTercero;
    }

    public void setEsTercero(Boolean esTercero) {
        this.esTercero = esTercero;
    }

    public Integer getNumLlamados() {
        return numLlamados;
    }

    public void setNumLlamados(Integer numLlamados) {
        this.numLlamados = numLlamados;
    }

    public Integer getIdTicketDerreac() {
        return idTicketDerreac;
    }

    public void setIdTicketDerreac(Integer idTicketDerreac) {
        this.idTicketDerreac = idTicketDerreac;
    }

    public Boolean getReactivado() {
        return reactivado;
    }

    public void setReactivado(Boolean reactivado) {
        this.reactivado = reactivado;
    }

    public String getIndDerivadoPrioridad() {
        return indDerivadoPrioridad;
    }

    public void setIndDerivadoPrioridad(String indDerivadoPrioridad) {
        this.indDerivadoPrioridad = indDerivadoPrioridad;
    }

    public String getCodigoImpresion() {
        return codigoImpresion;
    }

    public void setCodigoImpresion(String codigoImpresion) {
        this.codigoImpresion = codigoImpresion;
    }

    public Integer getIdPrecola() {
        return idPrecola;
    }

    public void setIdPrecola(Integer idPrecola) {
        this.idPrecola = idPrecola;
    }

    public String getIndTicketInterno() {
        return indTicketInterno;
    }

    public void setIndTicketInterno(String indTicketInterno) {
        this.indTicketInterno = indTicketInterno;
    }

    public String getIndTipoLlamado() {
        return indTipoLlamado;
    }

    public void setIndTipoLlamado(String indTipoLlamado) {
        this.indTipoLlamado = indTipoLlamado;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }
}