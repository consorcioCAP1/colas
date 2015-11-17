package pe.com.certicom.scolas.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechasUtil {

	private static SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
	
	private static SimpleDateFormat formateadorYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date getFechaActualSinHora(){
		Date fecha = new Date();  
		Calendar cal = Calendar.getInstance();  
		cal.setTime(fecha);  
		cal.set(Calendar.HOUR_OF_DAY, 0);  
		cal.set(Calendar.MINUTE, 0);  
		cal.set(Calendar.SECOND, 0);  
		cal.set(Calendar.MILLISECOND, 0);  
		fecha = cal.getTime(); 
		return fecha;
	}
	
    public static String getFechaActualStringSinHora(){
        return formateador.format(new Date());
    }
	
	public static Date getFechaLimiteReactivacion(Date fechaAbandono, Integer minutos){
		Date fecha = new Date();  
		Calendar cal = Calendar.getInstance();  
		cal.setTime(fechaAbandono);
		cal.add(Calendar.MINUTE, minutos);
		fecha = cal.getTime(); 
		return fecha;
	}
	
	
	public static Date getFecha(String fecha){
		Date fechaSalida = null;
		try{
			 fechaSalida = formateadorYYYYMMDD.parse(fecha);	 
		}catch(Exception e){
		}
		return fechaSalida;
	}
	
	
	public static Date getFechaLimiteDepuracion(Date fechaEmision, Integer minutos){
		Date fecha = new Date();  
		Calendar cal = Calendar.getInstance();  
		cal.setTime(fechaEmision);
		cal.add(Calendar.MINUTE, minutos);
		fecha = cal.getTime(); 
		return fecha;
	}
	
	
	public static Date fechaActualReemplazandoHora(Date fechaConHora){
		//FEcha a retornar modificada:
		Date fecha = new Date();
		Calendar cal = Calendar.getInstance();  
		cal.setTime(fecha);
		
		//Fecha del parametro
		Calendar calParam = Calendar.getInstance();  
		calParam.setTime(fechaConHora);
		
		//Seteo la hora minutos segundo y miliosegundos del parametro:
		cal.set(Calendar.HOUR_OF_DAY, calParam.get(Calendar.HOUR_OF_DAY));  
		cal.set(Calendar.MINUTE, calParam.get(Calendar.MINUTE));  
		cal.set(Calendar.SECOND, calParam.get(Calendar.SECOND));  
		cal.set(Calendar.MILLISECOND, calParam.get(Calendar.MILLISECOND));  
		fecha = cal.getTime(); 
		return fecha; 
	}
	
}
