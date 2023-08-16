/**
 * 
 */
package com.pronto.coding.assessment.utility;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

/**
 * @author Priyanka Vaithiyanathan
 *
 */
@Component
public class Utility {

	
	  static ResourceBundle validationMessage = ResourceBundle.getBundle("validation");
	 
	 /**
		 * Validation Messages from the properties file
		 */
			  public static String getValidationMsg(String key) {
			  
			  String value = "";
			  
			  try { value = validationMessage.getString(key); } catch
			  (MissingResourceException exception) { value =
			  validationMessage.getString(key); }
			  
			  return value;
			  
			 }
			 

}
