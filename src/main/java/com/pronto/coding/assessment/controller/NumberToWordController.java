/**
 * 
 */
package com.pronto.coding.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pronto.coding.assessment.pojo.InputRequest;
import com.pronto.coding.assessment.service.WordToNumberService;
import com.pronto.coding.assessment.utility.Constants;
import com.pronto.coding.assessment.validation.InputRequestValidation;

/**
 * @author Priyanka Vaithiyanathan
 *
 */
@RestController
@RequestMapping("/convert")
public class NumberToWordController {

	@Autowired
	InputRequestValidation reqValidation;
	@Autowired
	WordToNumberService numberService;

	@PostMapping("/numberToWord")
	public String getWordFromNumber(@RequestBody InputRequest inputReq) {

		String response = Constants.BLANK;
		String errMsg = Constants.BLANK;
		
		errMsg = reqValidation.validateInputRequest(inputReq);
		if (errMsg != null && errMsg.equals(Constants.BLANK)) {
			response = numberService.getWord(inputReq);
		} else {
			response = errMsg;
		}

		return response;
	}

}
