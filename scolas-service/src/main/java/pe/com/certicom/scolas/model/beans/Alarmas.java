package pe.com.certicom.scolas.model.beans;

public class Alarmas {
    private Integer idAlarmas;

    private String nombre;

    private String descripcion;

    private Short numParametros;

    private String parametro1;

    private String parametro2;

    private String parametro3;

    private String parametro4;

    private String parametro5;

    private String codigo;

    private String tieneSubalarmas;

    private String indIniciado;

    public Integer getIdAlarmas() {
        return idAlarmas;
    }

    public void setIdAlarmas(Integer idAlarmas) {
        this.idAlarmas = idAlarmas;
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

    public Short getNumParametros() {
        return numParametros;
    }

    public void setNumParametros(Short numParametros) {
        this.numParametros = numParametros;
    }

    public String getParametro1() {
        return parametro1;
    }

    public void setParametro1(String parametro1) {
        this.parametro1 = parametro1;
    }

    public String getParametro2() {
        return parametro2;
    }

    public void setParametro2(String parametro2) {
        this.parametro2 = parametro2;
    }

    public String getParametro3() {
        return parametro3;
    }

    public void setParametro3(String parametro3) {
        this.parametro3 = parametro3;
    }

    public String getParametro4() {
        return parametro4;
    }

    public void setParametro4(String parametro4) {
        this.parametro4 = parametro4;
    }

    public String getParametro5() {
        return parametro5;
    }

    public void setParametro5(String parametro5) {
        this.parametro5 = parametro5;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTieneSubalarmas() {
        return tieneSubalarmas;
    }

    public void setTieneSubalarmas(String tieneSubalarmas) {
        this.tieneSubalarmas = tieneSubalarmas;
    }

    public String getIndIniciado() {
        return indIniciado;
    }

    public void setIndIniciado(String indIniciado) {
        this.indIniciado = indIniciado;
    }
}