package pe.com.certicom.scolas.model.beans;

import java.util.Date;

public class TextoTicket {
    private Integer idTextoTicket;

    private String tituloprincipal;

    private String area;

    private String mensajebienvenida;

    private String mensajedespedida;

    private String mensaje1;

    private String mensaje2;

    private String indVigenciaMensaje1;

    private String indVigenciaMensaje2;

    private Date fecInivigMensaje1;

    private Date fecFinvigMensaje1;

    private Date fecInivigMensaje2;

    private Date fecFinvigMensaje2;

    public Integer getIdTextoTicket() {
        return idTextoTicket;
    }

    public void setIdTextoTicket(Integer idTextoTicket) {
        this.idTextoTicket = idTextoTicket;
    }

    public String getTituloprincipal() {
        return tituloprincipal;
    }

    public void setTituloprincipal(String tituloprincipal) {
        this.tituloprincipal = tituloprincipal;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMensajebienvenida() {
        return mensajebienvenida;
    }

    public void setMensajebienvenida(String mensajebienvenida) {
        this.mensajebienvenida = mensajebienvenida;
    }

    public String getMensajedespedida() {
        return mensajedespedida;
    }

    public void setMensajedespedida(String mensajedespedida) {
        this.mensajedespedida = mensajedespedida;
    }

    public String getMensaje1() {
        return mensaje1;
    }

    public void setMensaje1(String mensaje1) {
        this.mensaje1 = mensaje1;
    }

    public String getMensaje2() {
        return mensaje2;
    }

    public void setMensaje2(String mensaje2) {
        this.mensaje2 = mensaje2;
    }

    public String getIndVigenciaMensaje1() {
        return indVigenciaMensaje1;
    }

    public void setIndVigenciaMensaje1(String indVigenciaMensaje1) {
        this.indVigenciaMensaje1 = indVigenciaMensaje1;
    }

    public String getIndVigenciaMensaje2() {
        return indVigenciaMensaje2;
    }

    public void setIndVigenciaMensaje2(String indVigenciaMensaje2) {
        this.indVigenciaMensaje2 = indVigenciaMensaje2;
    }

    public Date getFecInivigMensaje1() {
        return fecInivigMensaje1;
    }

    public void setFecInivigMensaje1(Date fecInivigMensaje1) {
        this.fecInivigMensaje1 = fecInivigMensaje1;
    }

    public Date getFecFinvigMensaje1() {
        return fecFinvigMensaje1;
    }

    public void setFecFinvigMensaje1(Date fecFinvigMensaje1) {
        this.fecFinvigMensaje1 = fecFinvigMensaje1;
    }

    public Date getFecInivigMensaje2() {
        return fecInivigMensaje2;
    }

    public void setFecInivigMensaje2(Date fecInivigMensaje2) {
        this.fecInivigMensaje2 = fecInivigMensaje2;
    }

    public Date getFecFinvigMensaje2() {
        return fecFinvigMensaje2;
    }

    public void setFecFinvigMensaje2(Date fecFinvigMensaje2) {
        this.fecFinvigMensaje2 = fecFinvigMensaje2;
    }
}