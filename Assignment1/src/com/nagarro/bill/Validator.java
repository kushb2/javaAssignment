package com.nagarro.bill;

import shared.Constants;
import shared.ItemType;
import utility.CustomException;

public class Validator {

	
	public static boolean validate(String[] input) throws CustomException {
		boolean isValidate = true;
		try{
			if (input.length < 4)
				isValidate = false;

			Double.parseDouble(input[1]);
			Integer.parseInt(input[2]);
			@SuppressWarnings("unused")
			ItemType item = ItemType.values()[Integer.parseInt(input[3])];
			isValidate = true;
		} catch (Exception e) {
			new CustomException(Constants.INVALID_INPUT);
			isValidate = false;
		}
		return isValidate;
		
	}

}
