package presentation;

import utility.CustomException;

public class Starter {

	public static void main(String[] args) throws CustomException {

		try {
			Input.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new CustomException(e.toString());
		}

	}

}
