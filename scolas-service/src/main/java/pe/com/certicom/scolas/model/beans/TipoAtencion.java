package pe.com.certicom.scolas.model.beans;

public class TipoAtencion {
    private Integer idTipoAtencion;

    private String nombre;

    private String descripcion;

    private Boolean visible;

    private Boolean activo;

    public Integer getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(Integer idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
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

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}