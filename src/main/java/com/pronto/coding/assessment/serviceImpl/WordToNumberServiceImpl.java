/**
 * 
 */
package com.pronto.coding.assessment.serviceImpl;

import org.springframework.stereotype.Service;

import com.pronto.coding.assessment.pojo.InputRequest;
import com.pronto.coding.assessment.service.WordToNumberService;
import com.pronto.coding.assessment.utility.Constants;

/**
 * @author Priyanka
 *
 */
@Service
public class WordToNumberServiceImpl implements WordToNumberService{

	/**
	 * getWord
	 * 
	 * @param inputReq
	 * @return
	 */

	public String getWord(InputRequest inputReq) {

		String resp = Constants.BLANK;

		try {
			resp = convert(inputReq.getNumber());

		} catch (Exception ex) {
			System.err.println(ex);
		}

		return resp;
	}

	private static final String[] numberNames = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	private static final String[] tenNames = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };

	/**
	 * Private utility function that handles numbers upto 99
	 * 
	 * @param number
	 * @return String string representation of the number
	 */
	private String convertUpto99(int number) {
		if (number <= 0 || number > 99) {
			return "Number entered is out of bounds";
		} else if (number < 20) {
			return numberNames[number];
		} else {
			return tenNames[number / 10] + " " + numberNames[number % 10];
		}
	}

	/**
	 * Private utility function that handles numbers upto 999
	 * 
	 * @param number
	 * @return String string representation of the number
	 */
	private String convertUpto999(int number) {
		StringBuilder word = new StringBuilder("");
		if (number <= 0 || number > 999) {
			return "Number entered is out of bounds";
		} else if (number < 100) {
			return convertUpto99(number);
		} else {
			word.append(numberNames[number / 100]);
			number %= 100;
			if (number == 0) {
				word.append(" Hundred");
				return word.toString();
			}
			word.append(" Hundred ");
			return word.append("And " + convertUpto99(number).toString()).toString();
		}
	}

	/**
	 * Private utility function that handles numbers upto 999999
	 * 
	 * @param number
	 * @return String string representation of the number
	 */
	private String convertUpto999999(int number) {
		StringBuilder word = new StringBuilder("");
		if (number <= 0 || number > 999999) {
			return "Number entered is out of bounds";
		} else if (number < 1000) {
			return convertUpto999(number);
		} else {
			word.append(convertUpto999(number / 1000));
			number %= 1000;
			if (number == 0) {
				word.append(" Thousand");
				return word.toString();
			} else if (number < 100 || number / 100 < 9) {
				word.append(" Thousand, ");
			} else {
				word.append(" Thousand ");
			}
			return word.append(convertUpto999(number).toString()).toString();
		}
	}

	/**
	 * 
	 * @param number number to be converted to it's word representation.
	 * @return String converted word string from a number
	 */
	public String convert(int number) {
		if (number < 0 || number > 999999) {
			return "Number entered is out of bounds";
		} else if (number == 0) {
			return "Zero";
		} else {
			String input = convertUpto999999(number);
			return input.substring(0, 1).toUpperCase() + input.substring(1);
		}
	}

}
