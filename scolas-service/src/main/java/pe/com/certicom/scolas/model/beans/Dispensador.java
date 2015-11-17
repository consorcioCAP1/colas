package pe.com.certicom.scolas.model.beans;

import java.util.Date;

public class Dispensador {
    private Integer idDispensador;

    private String nombre;

    private String descripcion;

    private Integer puerto;

    private Integer velocidad;

    private Boolean indImpresion;

    private Integer codNivelMenu;

    private Boolean idEstado;

    private Integer numDemoraPantallas;

    private Date fecUltimaConexion;

    private String indAlarmaIniciada;

    private String generico;

    private String ip;

    public Integer getIdDispensador() {
        return idDispensador;
    }

    public void setIdDispensador(Integer idDispensador) {
        this.idDispensador = idDispensador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuerto() {
        return puerto;
    }

    public void setPuerto(Integer puerto) {
        this.puerto = puerto;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Boolean getIndImpresion() {
        return indImpresion;
    }

    public void setIndImpresion(Boolean indImpresion) {
        this.indImpresion = indImpresion;
    }

    public Integer getCodNivelMenu() {
        return codNivelMenu;
    }

    public void setCodNivelMenu(Integer codNivelMenu) {
        this.codNivelMenu = codNivelMenu;
    }

    public Boolean getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Boolean idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getNumDemoraPantallas() {
        return numDemoraPantallas;
    }

    public void setNumDemoraPantallas(Integer numDemoraPantallas) {
        this.numDemoraPantallas = numDemoraPantallas;
    }

    public Date getFecUltimaConexion() {
        return fecUltimaConexion;
    }

    public void setFecUltimaConexion(Date fecUltimaConexion) {
        this.fecUltimaConexion = fecUltimaConexion;
    }

    public String getIndAlarmaIniciada() {
        return indAlarmaIniciada;
    }

    public void setIndAlarmaIniciada(String indAlarmaIniciada) {
        this.indAlarmaIniciada = indAlarmaIniciada;
    }

    public String getGenerico() {
        return generico;
    }

    public void setGenerico(String generico) {
        this.generico = generico;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}