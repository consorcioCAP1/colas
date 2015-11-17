package pe.com.certicom.scolas.util;

import java.math.BigDecimal;
import java.util.regex.*;

import pe.com.certicom.scolas.common.ScolasCommonConstants;

public class ValidateUtil {

                /***
                 * Recibe una cadena y evalua si es una hora valida HH:mm:ss
                 * @param strVal Cadena a evaluar
                 * @return retorna True si es una hora vÃ¡lida
                 */
                
    public static boolean isNumeric(String cadena){               
                   try {                       
                                   Integer.parseInt(cadena);                          
                                   return true;       
                   } catch (Exception e){
                                   return false;      
                   }
    }

    public static Boolean isHour(String strVal) {

                   if (isEmpty(strVal))
                                   return false;

                   String[] arrStr = strVal.toString().split(":");

                   if (arrStr.length != 3 && arrStr.length != 2)
                                   return false;

                   for (String str : arrStr)
                                   if (!isNumber(str))
                                                   return false;

                   Integer intHora = Integer.parseInt(arrStr[0]);
                   Integer intMinuto = Integer.parseInt(arrStr[1]);
                   Integer intSegundo = 0;
                   
                   if(arrStr.length == 3)
                                   intSegundo = Integer.parseInt(arrStr[2]);
                   

                   if (intHora < 0 || intHora > 23)
                                   return false;

                   if (intMinuto < 0 || intMinuto > 59)
                                   return false;

                   if (intSegundo < 0 || intSegundo > 59)
                                   return false;

                   return true;

    }

    public static Boolean isNumber(String strVal) {

                   if (isEmpty(strVal))
                                   return false;

                   char[] arrCar = strVal.toCharArray();

                   for (char chaCar : arrCar)
                                   if (chaCar < 48 || chaCar > 57)
                                                   return false;

                   return true;
    }
    
    /***
     * Valida: 
     * Si un String es nulo o cadena vacia. 
     * Si es Integer valida si es nulo o Cero.
     * Si es un arreglo de objetos valida si es nulo o si el contenido de cada objeto del arreglo es nulo.
     * Si un Bigdecimal es nulo o si es Cero o un valor menor
     * @param strVal
     * @return True si el valor es nulo o vacio
     */
	public static Boolean isEmpty(Object strVal) {
	                   if (strVal == null)
	                                   return true;
	
	                   if (strVal instanceof String) {
	                                   String temp = (String) strVal;
	                                   return (temp.trim().equals(""))?true:false;
	               } 
	               else if (strVal instanceof Integer) {
	                               return ((Integer) strVal == 0)?true: false;
	               }
	               else if (strVal instanceof Short) {
	                               return ((Short) strVal == 0)?true: false;
	               }
	               else if (strVal instanceof BigDecimal) {
	                               return (((BigDecimal) strVal).compareTo(new BigDecimal("0")) <= 0)?true: false;
	               }
	               else if (strVal instanceof Object[]) {
	                               byte bit = 0;
	                               for(Object temp : (Object[]) strVal) {                                                   
	                                               if(temp != null) {
	                                                              bit = 1;
	                                                              break;                  
	                                               }
	                               }
	                               return (bit==1) ? false : true;
	               }                              
	               
	               return false;
	}
	
	/***
	 * Indica si un objeto no esta vacio.
	 * @see ValidateUtil#isEmpty(Object)
	 * @param strVal Objeto a evaluar
	 * @return True si el objeto esta vacio
	 */
	public static Boolean isNotEmpty(Object strVal) {
	               return !isEmpty(strVal);
	}              
	
	/***
	 * Indica si un objeto esta vacio o contiene el caracter "0".
	 * @see ValidateUtil#isEmpty(Object)
	 * @param strVal Objeto a evaluar
	 * @return True si el objeto esta vacio o es "0".
	 */
	public static Boolean isEmptyOrCero(String strVal) {
	               if (isEmpty(strVal))
	                               return true;
	               if (strVal.equals(ScolasCommonConstants.CERO))
	                               return true;
	               return false;
	}
	
	/***
	 * Metodo para validar campos obligatorios o que cumplan una expresion regular
	 * @param expresion Indica si una cadena tiene el valor "obligatorio" indica que el valor del campo es Obligatorio, este metodo evalua 
	 * los demas casos se evaluan como expresiones regulares JAVA
	 * @param valorCampo es el valor que contiene el campo a validar
	 * @return devuelve True si el campo no pasa la validacion
	 * @throws Exception
	 */
	public static Boolean isNotValidField(String expresion, Object valorCampo) throws Exception {
	               if (expresion.compareTo(ScolasCommonConstants.VALIDACION_CAMPO_OBLIGATORIO) == 0) {
	                               if (ValidateUtil.isEmpty(valorCampo))
	                                               return true;
	               }
	               return false;
	}
	
	/***
	 * Método para validar el número de placa.
	 * @param expresion contiene el número de placa ingresado en el campo.
	 * @return TRUE si la expresion contiene un número o letra del alfabeto.
	 * @CaracteresNoAceptados Â¿?Â°Â¬|!#$%&+=â€™Â¡*~\{}^<>@_-
	 * @throws Exception FALSE si el número de placa no cumple con el patrón.
	 */
	
	            
	            /***
	 * Método para validar el correo electrónico.
	 * @param expresion contiene el correo ingresado en el campo.
	 * @return TRUE si la expresion tiene el formato establecido en el patrón.
	 * @throws Exception FALSE si el correo no cumple con el patrón.
	 */
	public static Boolean isCorreoValidate(String expresion) throws Exception{
	               
	               Boolean resultado=false;
	               
	               Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    Matcher mat = pat.matcher(expresion);
	               
	               if (mat.find()){
	                               
	                               resultado=true;
	               }
	               
	               return resultado;
	               
	}
	
	/***
	 * Método para validar el número de un celular.
	 * @param expresion contiene el número de celular ingresado en el campo.
	 * @return TRUE si la expresion contiene exactamente un número de 9 cifras.
	 * @throws Exception FALSE si el número no cumple con el patrón.
	 */
	public static Boolean isCelularValidate(String expresion) throws Exception{
	               
	               Boolean resultado=false;
	               
	               Pattern pat4 = Pattern.compile("[0-9]{9}");
	               Matcher mat4 = pat4.matcher(expresion);
	               
	               Pattern pat2 = Pattern.compile("^9");
	    Matcher mat2 = pat2.matcher(expresion);
	               
	    
	               if (mat2.find() && mat4.find() ){
	                               
	                               resultado=true;
	               }
	                               
	               return resultado;
	               
	}
	
	/***
	 * Método para validar el año.
	 * @param expresion contiene el año ingresado en el campo.
	 * @return TRUE si la expresion contiene exactamente un número de 4 cifras.
	 * @throws Exception FALSE si el año no cumple con el patrón.
	 */
	public static Boolean isAnioValidate(String expresion) throws Exception{
	               
	               Boolean resultado=false;
	               
	               Pattern pat4 = Pattern.compile("[0-9]{4}");
	               Matcher mat4 = pat4.matcher(expresion);
	               
	    
	               if (mat4.find() && expresion.length()==4){
	                               
	                               resultado=true;
	               }
	                               
	               return resultado;
	               
	}
	
	/***
	 * Método para validar un campo numérico.
	 * @param expresion contiene un número.
	 * @return TRUE si expresion es un número, una cifra puede coincidir
	 * al menos 1 vez  y como máximo 50 veces.
	 * @throws Exception false si no es un número.
	 */
	public static Boolean isNumericValidate(String expresion) throws Exception{
	               
	               Boolean resultado=false;
	               
	               Pattern pat4 = Pattern.compile("^([0-9]{1,50})$");
	               Matcher mat4 = pat4.matcher(expresion);
	               
	    
	               if (mat4.find()){
	                               
	                               resultado=true;
	               }
	                               
	               return resultado;
	               
	}
	
	/***
	 * Método para validar un campo alfabético.
	 * @param expresion contiene una cadena de tipo alfabético.
	 * @return TRUE si la expresion pertecene al alfabeto, se incluye la letra ñ minúscula y mayúscula.
	 * @throws Exception 
	 */
	public static boolean isAlphabetical(String expresion) throws Exception{
	                               
	               Pattern pat = Pattern.compile("^[a-zA-ZñÑ\\s\\.]*$");
	               Matcher mat1 = pat.matcher(expresion);
	                               
	               return mat1.find(); 
	}
	
	/***
	 * Método para validar un campo alfanumérico con los siguientes carácteres especiales . - /
	 * @param expresion contiene una cadena de tipo alfanumérico.
	 * @return TRUE si la expresion pertecenece al alfabeto, incluye
	 * la letra ñ mayúscula y minúscula.
	 * @CaracteresAceptados Espacio en blanco, punto, guión y backslash.
	 * @throws Exception FALSE si se encuentran los siguientes carácteres especiales !•$%&()=#@|~€¬'¡+{}º.
	 */
	public static boolean isAlphabeticalAndNumeric(String expresion) throws Exception{
	               
	               Boolean resultado=false;
	               
	               Pattern pat = Pattern.compile("^[A-Za-zñÑ0-9\\s\\.\\-\\/]*$");
	               Matcher mat = pat.matcher(expresion);
	               
	               Pattern pat2 = Pattern.compile("[^!•$%&()=#@|~€¬'¡+{}*º]");
	               Matcher mat2 = pat2.matcher(expresion);
	               
	               if (mat2.find() && mat.find()) {
	                               resultado = true;
	               } 
	                                               
	               return resultado;
	}
	
	/***
	 * Método para validar un campo solo alfanumérico
	 * @param expresion contiene una cadena de tipo alfanumérico.
	 * @return TRUE si la expresion pertecenece al alfabeto, incluye
	 * la letra ñ mayúscula y minúscula.
	 * @CaracteresAceptados Espacio en blanco, punto, guión y backslash.
	 * @throws Exception FALSE si se encuentran los siguientes carácteres especiales !•$%&()=#@|~€¬'¡+{}º.
	 */
	public static boolean isOnlyAlphabeticalAndNumeric(String expresion) throws Exception{
	               
	               Boolean resultado=false;
	               
	               Pattern pat = Pattern.compile("^[A-Za-zñÑ0-9]*$");
	               Matcher mat = pat.matcher(expresion);
	               
	               Pattern pat2 = Pattern.compile("[^!•$%&()=#@|~€¬'¡+{}*º/*-+]");
	               Matcher mat2 = pat2.matcher(expresion);
	               
	               if (mat2.find() && mat.find()) {
	                               resultado = true;
	               } 
	                                               
	               return resultado;
	}
	
	/***
	 * Método para validar un campo numérico.
	 * @param string indica si una cadena es un número entero.
	 * @return TRUE si la expresion es un número.
	 * throws Exception FALSE si es diferente a un número.
	 */
	public static boolean isOnlyNumber(String expresion) throws Exception{
	               
	               Pattern pat4 = Pattern.compile("[0-9]");
	               Matcher mat4 = pat4.matcher(expresion);
	
	               return mat4.find();
	}
}
