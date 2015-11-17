package pe.com.certicom.scolas.model.beans;

public class Peso {
    private Integer idPeso;

    private String nombrePeso;

    private String descripcion;

    private Integer idModoLlamado;

    private Integer tiempomaxesperaprioridad;

    private Integer factorprioridad;

    public Integer getIdPeso() {
        return idPeso;
    }

    public void setIdPeso(Integer idPeso) {
        this.idPeso = idPeso;
    }

    public String getNombrePeso() {
        return nombrePeso;
    }

    public void setNombrePeso(String nombrePeso) {
        this.nombrePeso = nombrePeso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdModoLlamado() {
        return idModoLlamado;
    }

    public void setIdModoLlamado(Integer idModoLlamado) {
        this.idModoLlamado = idModoLlamado;
    }

    public Integer getTiempomaxesperaprioridad() {
        return tiempomaxesperaprioridad;
    }

    public void setTiempomaxesperaprioridad(Integer tiempomaxesperaprioridad) {
        this.tiempomaxesperaprioridad = tiempomaxesperaprioridad;
    }

    public Integer getFactorprioridad() {
        return factorprioridad;
    }

    public void setFactorprioridad(Integer factorprioridad) {
        this.factorprioridad = factorprioridad;
    }
}