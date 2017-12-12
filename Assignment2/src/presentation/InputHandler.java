package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import bll.FlightFinder;
import data.FlightSearch;
import shared.EnumFlightClass;

public class InputHandler {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public static void query() {
		String isValid;
		FlightSearch flightSearch = new FlightSearch();
		do {
			isValid = inputData(flightSearch);
		} while (isValid.equals("y"));
		System.exit(0);
	}

	private static String inputData(FlightSearch flightSearch) {
		String res = "";
		try {
			System.out.print("Enter , seprated values : ");
			System.out.println("depatrure location , Arrival Location ,  Date , Class");
			String[] input = br.readLine().split(",");
			flightSearch.setDeptLoc(input[0]);
			flightSearch.setArrLoc(input[1]);
			flightSearch.setFlightDate(LocalDate.parse(input[2], format));
			flightSearch.setFlightClass((EnumFlightClass) EnumFlightClass.valueOf(input[3]));

			FlightFinder.find(flightSearch);
			System.out.print("Want to Find more Flight ( y/n):");
			res = br.readLine();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
