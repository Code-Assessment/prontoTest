
package com.pronto.coding.assessment.validation;

import org.springframework.stereotype.Component;

import com.pronto.coding.assessment.pojo.InputRequest;
import com.pronto.coding.assessment.utility.Constants;
import com.pronto.coding.assessment.utility.Utility;

/**
 * @author Priyanka Vaithiyanathan
 *
 */
@Component
public class InputRequestValidation {

	public String validateInputRequest(InputRequest inputReq) {

		int inputNumber = inputReq.getNumber();
		String validateMsg = Constants.BLANK;

		if (inputNumber > 999999) {
			validateMsg = Utility.getValidationMsg("input.number.exceeds.limit");
		} else if (inputNumber < 0) {
			validateMsg = Utility.getValidationMsg("input.number.below.zero");
		}

		return validateMsg;
	}

}
