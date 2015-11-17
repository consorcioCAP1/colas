package pe.com.certicom.scolas.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpos.JposConst;
import jpos.JposException;
import jpos.POSPrinter;
import jpos.POSPrinterConst;
import jpos.events.ErrorEvent;
import jpos.events.ErrorListener;
import jpos.events.OutputCompleteEvent;
import jpos.events.OutputCompleteListener;
import jpos.events.StatusUpdateEvent;
import jpos.events.StatusUpdateListener;
import jpos.util.JposPropertiesConst;
import pe.com.certicom.scolas.service.ImpresoraService;
import pe.com.certicom.scolas.model.beans.TextoTicket;
import pe.com.certicom.scolas.model.beans.Ticket;
import pe.com.certicom.scolas.util.Criteria;
import pe.com.certicom.scolas.util.CriteriaManager;
import pe.com.certicom.scolas.util.ImpresoraNoDisponibleException;
import pe.com.certicom.scolas.model.service.TextoTicketService;

@Service
public class ImpresoraServiceImpl implements ImpresoraService, OutputCompleteListener,
StatusUpdateListener, ErrorListener  {

	public ImpresoraServiceImpl() {
		super();
	}

	private String ESC = ((char) 0x1b) + "";
	private String LF = ((char) 0x0a) + "";
	private String SPACES = "                                                                      ";
	private POSPrinter printer = null;
	private boolean ERROR = false;
	
	
	@Autowired
	private TextoTicketService textoTicketService;

	public List<TextoTicket> listarTextoTicketByCriteria(CriteriaManager criteriaManager) throws Exception{
		return textoTicketService.select(criteriaManager);
	}

	public void inicializar(String tipoConfiguracion)
			throws ImpresoraNoDisponibleException {

		try {
			System.setProperty(
					JposPropertiesConst.JPOS_POPULATOR_FILE_PROP_NAME,"C:/Program Files/StarMicronics/TSP100/Software/20100314/JavaPOSExamples/jpos.xml");
			printer = new POSPrinter();
			printer.addOutputCompleteListener(this);
			printer.addStatusUpdateListener(this);
			printer.addErrorListener(this);
			printer.open(tipoConfiguracion);
			printer.claim(1);
			printer.setDeviceEnabled(true);
			printer.setAsyncMode(true);
			printer.setMapMode(POSPrinterConst.PTR_MM_METRIC);
			// printer.setMapMode(POSPrinterConst.PTR_MM_TWIPS);
			//System.out.println("printer.getEnabled: "
			//		+ printer.getDeviceEnabled());

		} catch (JposException e) {
			// e.printStackTrace();
			e.printStackTrace(System.out);
			throw new ImpresoraNoDisponibleException(e.getMessage());
		}
	}

	public boolean imprimirImage() {
		boolean inicializado=true;
		try {
			printer.transactionPrint(POSPrinterConst.PTR_S_RECEIPT,
					POSPrinterConst.PTR_TP_TRANSACTION);
			if (printer.getCapRecBitmap() == true) {
				// print an image file
				try {
					printer.printBitmap(POSPrinterConst.PTR_S_RECEIPT,"C:/Program Files/StarMicronics/TSP100/Software/20100314/JavaPOSExamples/logoONP1.png", POSPrinterConst.PTR_BM_ASIS,
							POSPrinterConst.PTR_BM_CENTER);
				} catch (JposException e) {
					if (e.getErrorCode() != JposConst.JPOS_E_NOEXIST) {
						throw e;
					}
				}
			}
		} catch (JposException e) {
			e.printStackTrace(System.out);
			inicializado = false;
		}
		return inicializado;
	}
	
	public void Transaccion(){
		
		 try {
	        	printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|100fP");
				printer.transactionPrint(POSPrinterConst.PTR_S_RECEIPT, POSPrinterConst.PTR_TP_NORMAL);
			} catch (JposException e) {
				e.printStackTrace();
			}
	} 


	public void imprimirLinea(String codigoTicket,Ticket ticket) {
		// call printNormal repeatedly to generate out receipt
        // the following JavaPOS-POSPrinter control code sequences are used here
        // ESC + "|cA" -> center alignment
        // ESC + "|4C" -> double high double wide character printing
        // ESC + "|bC" -> bold character printing
        // ESC + "|uC" -> underline character printing
        // ESC + "|rA" -> right alignment
		try {	CriteriaManager criteriaManager = new  CriteriaManager();
		Criteria criteria= criteriaManager.createCriteria();
		
		TextoTicket textoTicket=new TextoTicket();
		textoTicket=listarTextoTicketByCriteria(criteriaManager).get(0);
		
		//TITULO PRINCIPAL 
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ESC + "|bC" +textoTicket.getTituloprincipal()+ LF);
        //java.util.Date date=new java.util.Date();
        Date date = ticket.getFecha();
        Date hora=	ticket.getHoraEmision();
        SimpleDateFormat formatoHora=new SimpleDateFormat("HH:mm:ss");
        //FECHA Y HORA (TICKET)
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + "Fecha: "+formatoFecha.format(date)+" Hora: "+formatoHora.format(hora) + LF);
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, textoTicket.getMensajebienvenida() + LF);
     
        //NOMBRE CLIENTE (TICKET)
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ticket.getNombreCliente().toUpperCase()+LF);
        
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, "SU ORDEN DE ATENCION ES: " + LF+ LF);
        //CODIGO DE IMPRESION (TICKET)
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|cA" + ESC + "|4C" + ESC + "|bC" + codigoTicket + LF );

        
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, ESC + "|uC"  + SPACES.substring(0, printer.getRecLineChars()) + LF + LF);
        //MENSAJE 1
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, textoTicket.getMensaje1() + LF);
        //MENSAJE 2
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, textoTicket.getMensaje2() + LF);
        //MENSAJE DESPEDIDA
        printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, textoTicket.getMensajedespedida() + LF);

		} catch (JposException ex) {
			ex.printStackTrace(System.out);
		} catch (Exception ex) {		
			ex.printStackTrace(System.out);
		}
	}	
	
	public void finalizar()  {
		if (printer != null) {

				if(printer.getState() != JposConst.JPOS_S_CLOSED) {	
					try {
						while (printer.getState() != JposConst.JPOS_S_IDLE && !ERROR) {
							Thread.sleep(0); 
						}
						printer.close();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						printer = null;
					}
				
				}
				
		}
	}
	public void outputCompleteOccurred(OutputCompleteEvent event) {
		ERROR = false;
	}

	public void statusUpdateOccurred(StatusUpdateEvent event) {

	}

	public void errorOccurred(ErrorEvent event) {
		ERROR = true;
	
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		event.setErrorResponse(JposConst.JPOS_ER_RETRY);
	}

}
