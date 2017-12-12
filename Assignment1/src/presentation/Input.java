package presentation;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import bll.TaxManager;
import bll.Validator;
import shared.Constants;

public class Input {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void start() {
		boolean isContinue = false;
		String[] input;
		try {
			do {
				input();
				System.out.println(Constants.ADD_MORE);
				isContinue = br.readLine().equals("Y") ? true : false;
			} while (isContinue);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private static void input() throws Exception {
		boolean isValid = true;
		try {
			do {
				inputMsg();
				String[] input = br.readLine().split(" ");
				isValid = Validator.validate(input);
				String res = TaxManager.getInstance().Add(input);
				System.out.println(res);
			} while (!isValid);
		} catch (Exception e) {
			throw e;
		}

	}

	private static void inputMsg() {
//		System.out.println("\f");
		System.out.println(Constants.INPUT_MSG);
		System.out.println(Constants.TYPE);
	}

	

}
