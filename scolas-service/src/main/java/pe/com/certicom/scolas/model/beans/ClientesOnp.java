package pe.com.certicom.scolas.model.beans;

public class ClientesOnp {
    private String dni;

    private String nombres;

    private String adicional2;

    private String adicional1;

    private String esDniPorLector;
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAdicional2() {
        return adicional2;
    }

    public void setAdicional2(String adicional2) {
        this.adicional2 = adicional2;
    }

    public String getAdicional1() {
        return adicional1;
    }

    public void setAdicional1(String adicional1) {
        this.adicional1 = adicional1;
    }

	public String getEsDniPorLector() {
		return esDniPorLector;
	}

	public void setEsDniPorLector(String esDniPorLector) {
		this.esDniPorLector = esDniPorLector;
	}
}