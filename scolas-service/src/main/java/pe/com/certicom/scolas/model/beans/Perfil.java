package pe.com.certicom.scolas.model.beans;

public class Perfil {
    private Short idPerfil;

    private String codigo;

    private String descripcion;

    private String nombre;

    public Short getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Short idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}