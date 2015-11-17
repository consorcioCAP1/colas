package pe.com.certicom.scolas.model.beans;

import java.util.Date;

public class Usuario {
    private Integer idUsuario;

    private String nombre;

    private Integer idTurno;

    private String dni;

    private String login;

    private String clave;

    private Date fechaIngreso;

    private String nombreOficinaProcedencia;

    private Integer idPeso;

    private Integer idArea;

    private Boolean visible;

    private Byte prellamado;

    private String codigo;

    private Integer idOficina;

    private String apePaterno;

    private String apeMaterno;

    private Integer idPerfil;

    private Integer idTipoAtencion;

    private Date ultFecModif;

    private String ultUserModif;
    
    private boolean editable;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombreOficinaProcedencia() {
        return nombreOficinaProcedencia;
    }

    public void setNombreOficinaProcedencia(String nombreOficinaProcedencia) {
        this.nombreOficinaProcedencia = nombreOficinaProcedencia;
    }

    public Integer getIdPeso() {
        return idPeso;
    }

    public void setIdPeso(Integer idPeso) {
        this.idPeso = idPeso;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Byte getPrellamado() {
        return prellamado;
    }

    public void setPrellamado(Byte prellamado) {
        this.prellamado = prellamado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(Integer idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

    public Date getUltFecModif() {
        return ultFecModif;
    }

    public void setUltFecModif(Date ultFecModif) {
        this.ultFecModif = ultFecModif;
    }

    public String getUltUserModif() {
        return ultUserModif;
    }

    public void setUltUserModif(String ultUserModif) {
        this.ultUserModif = ultUserModif;
    }

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}