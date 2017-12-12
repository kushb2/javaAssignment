package Flight.Assignment2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.nagarro.java.training.business.CSVLookUp;
import com.nagarro.java.training.business.FlightUtility;
import com.nagarro.java.training.models.FlightDTO;

public class App {
	private static final String dateFormat = "dd-MM-yyyy";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		String choice = null;
		try {
			CSVLookUp csvThread = new CSVLookUp("look up tread");
			csvThread.start();
			FlightDTO flightDTO = new FlightDTO();
			do {
				choice = inputData(scanner, formatter, flightDTO);
			} while (choice.equals("y"));

			if (!choice.equals("y")) {
				System.exit(0);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	private static String inputData(Scanner scanner, DateTimeFormatter formatter, FlightDTO flightDTO) {
		System.out.print("Enter Departure Location:");
		flightDTO.deptLoc = scanner.nextLine().toUpperCase();
		System.out.print("Enter Arrival Location:");
		flightDTO.arrLoc = scanner.nextLine().toUpperCase();
		System.out.println("Enter Date");
		flightDTO.flightDate = LocalDate.parse(scanner.nextLine(), formatter);
		System.out.print("Enter Class:");
		flightDTO.flightClass = scanner.nextLine().toUpperCase();

		FlightUtility.searchFlight(flightDTO);

		System.out.print("Want to search more(y/n):");
		return scanner.nextLine();

	}
}
