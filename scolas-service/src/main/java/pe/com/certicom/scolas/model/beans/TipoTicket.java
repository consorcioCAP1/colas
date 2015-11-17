package pe.com.certicom.scolas.model.beans;

import java.util.Date;

public class TipoTicket {
    private Integer idTipoTicket;

    private String nombre;

    private Integer idTipoAtencion;

    private String codigoImpresion;

    private String codigoTarjeta;

    private String descripcion;

    private Date tiempoOptimoAtencion;

    private Date tiempoOptimoEspera;

    private Integer idSeccion;

    private Integer tiempoDemoraAtencion;

    private Integer idOficina;

    private Boolean activo;

    private Boolean visible;

    private Boolean especial;

    private Integer tiempoEsperaMin;

    private Integer tiempoEsperaMax;

    private Integer tiempoAtencionMin;

    private Integer tiempoAtencionMax;

    private Integer tiempomaxesperaprioridad2;

    private Integer factorprioridad2;

    private Boolean esTitular;

    private Boolean esApoderado;

    private Boolean esTercero;

    public Integer getIdTipoTicket() {
        return idTipoTicket;
    }

    public void setIdTipoTicket(Integer idTipoTicket) {
        this.idTipoTicket = idTipoTicket;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(Integer idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

    public String getCodigoImpresion() {
        return codigoImpresion;
    }

    public void setCodigoImpresion(String codigoImpresion) {
        this.codigoImpresion = codigoImpresion;
    }

    public String getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public void setCodigoTarjeta(String codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getTiempoOptimoAtencion() {
        return tiempoOptimoAtencion;
    }

    public void setTiempoOptimoAtencion(Date tiempoOptimoAtencion) {
        this.tiempoOptimoAtencion = tiempoOptimoAtencion;
    }

    public Date getTiempoOptimoEspera() {
        return tiempoOptimoEspera;
    }

    public void setTiempoOptimoEspera(Date tiempoOptimoEspera) {
        this.tiempoOptimoEspera = tiempoOptimoEspera;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Integer getTiempoDemoraAtencion() {
        return tiempoDemoraAtencion;
    }

    public void setTiempoDemoraAtencion(Integer tiempoDemoraAtencion) {
        this.tiempoDemoraAtencion = tiempoDemoraAtencion;
    }

    public Integer getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getEspecial() {
        return especial;
    }

    public void setEspecial(Boolean especial) {
        this.especial = especial;
    }

    public Integer getTiempoEsperaMin() {
        return tiempoEsperaMin;
    }

    public void setTiempoEsperaMin(Integer tiempoEsperaMin) {
        this.tiempoEsperaMin = tiempoEsperaMin;
    }

    public Integer getTiempoEsperaMax() {
        return tiempoEsperaMax;
    }

    public void setTiempoEsperaMax(Integer tiempoEsperaMax) {
        this.tiempoEsperaMax = tiempoEsperaMax;
    }

    public Integer getTiempoAtencionMin() {
        return tiempoAtencionMin;
    }

    public void setTiempoAtencionMin(Integer tiempoAtencionMin) {
        this.tiempoAtencionMin = tiempoAtencionMin;
    }

    public Integer getTiempoAtencionMax() {
        return tiempoAtencionMax;
    }

    public void setTiempoAtencionMax(Integer tiempoAtencionMax) {
        this.tiempoAtencionMax = tiempoAtencionMax;
    }

    public Integer getTiempomaxesperaprioridad2() {
        return tiempomaxesperaprioridad2;
    }

    public void setTiempomaxesperaprioridad2(Integer tiempomaxesperaprioridad2) {
        this.tiempomaxesperaprioridad2 = tiempomaxesperaprioridad2;
    }

    public Integer getFactorprioridad2() {
        return factorprioridad2;
    }

    public void setFactorprioridad2(Integer factorprioridad2) {
        this.factorprioridad2 = factorprioridad2;
    }

    public Boolean getEsTitular() {
        return esTitular;
    }

    public void setEsTitular(Boolean esTitular) {
        this.esTitular = esTitular;
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
}