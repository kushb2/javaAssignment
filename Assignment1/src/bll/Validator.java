package bll;

import shared.Constants;
import shared.ItemType;

public class Validator {

	public static boolean validate(String[] input) throws Exception {
		boolean isValidate = false;
		
		try{
		if (input.length < 4)
            throw new Exception(Constants.INVALID_INPUT);


		String Name = input[0];
		Double price = Double.parseDouble(input[1]);
		int quantity = Integer.parseInt(input[2]);
		ItemType type = ItemType.values()[Integer.parseInt(input[3])];
		isValidate = true;
		} catch (Exception e) {
			throw e;
		}
		return isValidate;
	}

}
