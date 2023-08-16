/**
 * 
 */
package com.pronto.coding.assessment.validation;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pronto.coding.assessment.pojo.InputRequest;
import com.pronto.coding.assessment.utility.Utility;

/**
 * @author Priyanka Vaithiyanathan
 *
 */
@Component
public class InputRequestValidation {
	

	public String validateInputRequest(InputRequest inputReq) {
		
		int inputNumber = inputReq.getNumber();
		String validateMsg ="";
		String format = String.valueOf(inputNumber);
		Pattern pattern = Pattern.compile(".*[^0-9].*");
		
		if(inputNumber > 999999) {
			validateMsg = Utility.getValidationMsg("input.number.exceeds.limit");
		}
		else if(inputNumber < 0){
			validateMsg = Utility.getValidationMsg("input.number.below.zero");
		}
		else if(!pattern.matcher(format).matches()) {
			validateMsg = Utility.getValidationMsg("input.number.invalid");
		}
		
		return validateMsg;
	}

}
