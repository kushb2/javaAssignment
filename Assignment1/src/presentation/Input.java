package presentation;

import java.io.BufferedReader;
import java.io.IOException;

import com.nagarro.bill.TaxManager;
import com.nagarro.bill.Validator;

import shared.Constants;
import shared.EnumReader;
import utility.CustomException;
import utility.ReaderWriterUtility;

public class Input {

	/*
	 * take input from user add in cache return the tax on the product
	 */
	public static void start() throws Exception {
		boolean isContinue = false;
		try {
			do {
				input();
				System.out.println(Constants.ADD_MORE);
				isContinue = ((BufferedReader) ReaderWriterUtility.getInstance(EnumReader.BUFFER_READER)).readLine()
						.equals("Y") ? true : false;
			} while (isContinue);
			System.exit(0);
		} catch (CustomException ex) {
			new CustomException(ex.getMessage());
		} catch (IOException e) {
			new CustomException(e.toString());
		} catch (Exception e) {
			new CustomException(e.toString());
		}

	}

	/*
	 * validate user input
	 */
	private static void input() throws Exception {
		boolean isValid = true;
		try {
			do {
				inputMsg();
				String[] input = ((BufferedReader) ReaderWriterUtility.getInstance(EnumReader.BUFFER_READER)).readLine()
						.split(" ");
				isValid = Validator.validate(input);
				if (isValid) {
					String res = TaxManager.getInstance().add(input);
					System.out.println(res);
				}
			} while (!isValid);
		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * print input msg format on console
	 */
	private static void inputMsg() {
		System.out.println(Constants.INPUT_MSG);
		System.out.println(Constants.TYPE);
	}

}
