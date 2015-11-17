package pe.com.certicom.scolas.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;

import javax.annotation.PostConstruct;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.com.certicom.scolas.common.ScolasCommonConstants;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.service.AdminService;
import pe.com.certicom.scolas.util.Criteria;
import pe.com.certicom.scolas.util.CriteriaManager;
import pe.com.certicom.scolas.util.FacesUtil;
import pe.com.certicom.scolas.util.FechasUtil;



@Component
@Scope("view")
public class PrincipalController extends BaseController implements SerialPortEventListener{

	private static final Logger LOGGER = Logger.getLogger(PrincipalController.class);

	private String tipoCLiente;
	private String dni;
	private String documento;
	private Boolean mostrarBoton;
	//este es para un ejemplo  de la lectora de barras 2D que creo Omar Francisco Dela cruz Gutierrez
	private String nombreCompleto;
	private String dniPrueba;
	private Boolean renderDni=false;


    private static CommPortIdentifier puertoCOMIdentifier;
    private InputStream flujoDataScanner;
    private SerialPort puertoSerial;
    private Boolean mostrarBotones= false;
    private Boolean mostrarBotonScanner= true;
    private Boolean mostrarRegresarInicio=true;
    private Boolean renderMensajeScanner=false;
    private Boolean eliminarTodo= false; 

	@Autowired
	AdminService adminService;
    

		@PostConstruct
		protected void init() {
			
			System.out.println("este es solo un ejemplo para ver  si  no  se oierde session: "
					+FacesUtil.getObjectSession("cliente").toString());
			mostrarBoton=false;
			
		
		  
		}
		public void mostrarPantalla(){
			renderDni=true;
			mostrarBotones= true;
			mostrarBotonScanner=false;	
			mostrarRegresarInicio=false;
		}
	
		public void borrar(){
			
			if(dni.length()>0){
				dni=dni.substring(0, dni.length()-1);
			}
			
		}	
		
	public void metodo(){
		 try {	
			 
			Enumeration e = CommPortIdentifier.getPortIdentifiers();
            Boolean puerto3=false;
            
            
            while(e.hasMoreElements()){
                CommPortIdentifier p = (CommPortIdentifier)e.nextElement();   
                System.out.println("Puerto encontrado, nombre:"+p.getName());
                if(p.getName().equals("COM3")){
                	puerto3=true;
                }
            } 
			if(puerto3){           
				if ( CommPortIdentifier.getPortIdentifier("COM3") != null ){					
						// open serial port
					 	System.out.println("Trantando de obtener puerto con identificador:"+"COM3");
					 	
					 	puertoCOMIdentifier=null;		        
				        puertoCOMIdentifier = CommPortIdentifier.getPortIdentifier("COM3");
				        System.out.println("Puerto:"+"COM3"+", obtenido...");
				        if(puertoSerial==null){        
					        puertoSerial = (SerialPort) puertoCOMIdentifier.open("ComPort", 2000);
				        
					        // get serial input stream
						   System.out.println("Obteniendo flujo de salida del puerto serial...");
					        flujoDataScanner = puertoSerial.getInputStream();
					        System.out.println("Flujo de salida obtenido.");
				   
					        // add an event listener on the port
					        System.out.println("Intentando agregar un listen-er al puerto serial...");
					        puertoSerial.addEventListener(this);
					        System.out.println("Listener en puerto serial agregado.");			   
			
					        puertoSerial.notifyOnDataAvailable(true);
					 	} 
				  //	renderDni=true;
				        setRenderMensajeScanner(true);
				    mostrarBotonScanner=false;
				    mostrarRegresarInicio=false;
				 
				    FacesContext.getCurrentInstance().addMessage(null,
							 new FacesMessage(FacesMessage.SEVERITY_WARN,ScolasCommonConstants.TIPO_MENSAJE_INFORMACION,ScolasCommonConstants.MSG_MENSAJE_ESCANEAR));  

				 	}
				}
			
				else {
					 FacesContext.getCurrentInstance().addMessage(null,
							 new FacesMessage(FacesMessage.SEVERITY_WARN,ScolasCommonConstants.TIPO_MENSAJE_INFORMACION,ScolasCommonConstants.MSG_ESCANNER_DESCONECTADO));  
					}
				
			} catch (NoSuchPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TooManyListenersException e) {
		        System.out.println("Ocurrió una excepción al agregar un listener al puerto serial...");
		        e.printStackTrace();
		       
		    } catch (IOException e) {
		        System.out.println("Ocurrió una excepción al obtener el flujo de salida...");
		        e.printStackTrace();
		       
		   	} catch (Exception e) {
		        System.out.println("Ocurrió una excepción al abrir el puerto...");
		        e.printStackTrace();
		      
		    }
		 
		}


	    /**
	     * Ejecutado cada vez que se lee un código de barras y además la pantalla
	     * de solicitud lectura está visible
	     */
	public void serialEvent(SerialPortEvent event) {
	        System.out.println("Data leída desde el scanner, tipo de evento:"+event.getEventType()+".");
	        if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
	            System.out.println("Data disponible, empezando a leerla...");
	            
	                StringBuilder stringDataScanner = new StringBuilder();
	                int c;
	                try {
	                    // append the scanned data onto a string builder
	                    System.out.println("Iniciando lectura desde el buffer....");
	                    while (flujoDataScanner.available()>0){
	                        c = flujoDataScanner.read();
	                        stringDataScanner.append((char) c);
	                    }

	                    // cerramos el flujo de datos del scanner
	                    flujoDataScanner.close();

	                    System.out.println("Lectura terminada, cadena recibida:" + stringDataScanner.toString());
	                    
	                    
	                    String dni1 = "";
	    	    		String nombreCompleto1 = "";
	    		    		if(stringDataScanner.toString()!=null && stringDataScanner.toString().length()>140){
	    			            dni1 = stringDataScanner.toString().substring(2,10);
	    			            System.out.println("DNI:*"+dni1+"*");
	    			            String primerApellido = stringDataScanner.toString().substring(10,50);
	    			            System.out.println("Primer Apellido:*"+primerApellido+"*");
	    			            String segundoApellido = stringDataScanner.toString().substring(50,90);
	    			            System.out.println("Segundo Apellido:*"+segundoApellido+"*");
	    			            String nombres = stringDataScanner.toString().substring(90,125);
	    			            System.out.println("Nombres:*"+nombres+"*");
	    			            nombreCompleto1 = nombres.trim()+" "+primerApellido.trim()+" "+segundoApellido.trim();
	    			           
	    			            //puertoCOMIdentifier.removePortOwnershipListener((CommPortOwnershipListener) this);
	    			            puertoSerial.removeEventListener();	    			            
	    			            puertoSerial.close();
	    			            setNombreCompleto(nombreCompleto1);
	    			            setDni(dni1);
	    			            setDniPrueba(dni1);
	    		    		}
	                    
	                } catch (IOException e) {
	                    System.out.println("Ocurrió una excepción al leer el flujo de datos desde el scanner...");
	                    e.printStackTrace();
	                }	           
	                
	        }
	    }    
	  
	public void regresar(){
		
		try{
			
			FacesUtil.setObjectSession("cliente", null);
			FacesUtil.redirect(ScolasCommonConstants.XHTML_INDEX);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void numeros(String numero){		

		if (dni.length()==8){
			 FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage(FacesMessage.SEVERITY_WARN,ScolasCommonConstants.TIPO_MENSAJE_INFORMACION,ScolasCommonConstants.MSG_SUPERO_CANTIDAD_DIGITO));  
			}		
		else {
			if (eliminarTodo){
				dni=numero;
				eliminarTodo=false;
			}
			else dni=dni+numero;
		}
	}
	
	public void redirectLector(){		
		
	try {
			String dni2 = getDni(); 
			
		
			if (getDniPrueba()!=null && getNombreCompleto()!=null)
				{	
				
					dni2 = getDniPrueba(); 
					String nombre2= getNombreCompleto();			
					FacesUtil.setObjectSession("dni2", dni2);
					FacesUtil.setObjectSession("nombre", nombre2);
					FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL2);		
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void redirectAceptar(){		
	
	try {
			if(dni.length()==8){
				
				CriteriaManager criteriaManager= new CriteriaManager();
			    Criteria criteria= criteriaManager.createCriteria();
			    
				criteria.andFieldEqualTo("fecha", FechasUtil.getFechaActualSinHora());					
				criteria.andFieldEqualTo("dni", dni);
				List<String> lstEstados = new ArrayList<String>();
				lstEstados.add("0");
				lstEstados.add("1");
				lstEstados.add("2");
				criteria.andFieldIn("id_estado", lstEstados);
				
				
				List<Ticket> lstTicket = adminService.selectTicketByCriteria(criteriaManager);				
				if(lstTicket.size()>0){
					 FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage(FacesMessage.SEVERITY_WARN,ScolasCommonConstants.TIPO_MENSAJE_INFORMACION,ScolasCommonConstants.MSG_CLIENTE_ATENDIDO));  

				}
				else {
					FacesUtil.setObjectSession("dni2", dni);			
					FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL2);		
				}
			}
			
			else {
				 FacesContext.getCurrentInstance().addMessage(null,
						 new FacesMessage(FacesMessage.SEVERITY_WARN,ScolasCommonConstants.TIPO_MENSAJE_INFORMACION,ScolasCommonConstants.MSG_COMPLETE_DNI));  
				 eliminarTodo=true;	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	

	}
	
		
	
	public void limpiar(){
	
		try {
			
			if(  puertoSerial!=null){
				
				  puertoSerial.removeEventListener();	    			            
		          puertoSerial.close();
			} 
			mostrarRegresarInicio=true;
			FacesUtil.redirect(ScolasCommonConstants.XHTML_PRINCIPAL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public String getDocumento() {
		 return documento;		
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTipoCLiente() {
		return tipoCLiente;
	}

	public void setTipoCLiente(String tipoCLiente) {
		this.tipoCLiente = tipoCLiente;
	}

	public String getDni() {		
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	public Boolean getMostrarBoton() {
		return mostrarBoton;
	}

	public void setMostrarBoton(Boolean mostrarBoton) {
		this.mostrarBoton = mostrarBoton;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getDniPrueba() {
		return dniPrueba;
	}
	public void setDniPrueba(String dniPrueba) {
		this.dniPrueba = dniPrueba;
	}
	public Boolean getMostrarBotones() {
		return mostrarBotones;
	}
	public void setMostrarBotones(Boolean mostrarBotones) {
		this.mostrarBotones = mostrarBotones;
	}
	public Boolean getRenderDni() {
		return renderDni;
	}
	public void setRenderDni(Boolean renderDni) {
		this.renderDni = renderDni;
	}
	public Boolean getMostrarBotonScanner() {
		return mostrarBotonScanner;
	}
	public void setMostrarBotonScanner(Boolean mostrarBotonScanner) {
		this.mostrarBotonScanner = mostrarBotonScanner;
	}
	public Boolean getMostrarRegresarInicio() {
		return mostrarRegresarInicio;
	}
	public void setMostrarRegresarInicio(Boolean mostrarRegresarInicio) {
		this.mostrarRegresarInicio = mostrarRegresarInicio;
	}
	public Boolean getRenderMensajeScanner() {
		return renderMensajeScanner;
	}
	public void setRenderMensajeScanner(Boolean renderMensajeScanner) {
		this.renderMensajeScanner = renderMensajeScanner;
	}
	public Boolean getEliminarTodo() {
		return eliminarTodo;
	}
	public void setEliminarTodo(Boolean eliminarTodo) {
		this.eliminarTodo = eliminarTodo;
	}


}
