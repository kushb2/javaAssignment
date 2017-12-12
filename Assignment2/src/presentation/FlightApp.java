package presentation;

import bll.CsvReader;

public class FlightApp {

	public static void main(String[] args) {
		
		try {
			
			
			CsvReader csvReader = new CsvReader("File Read Thread");
			csvReader.start();
			
		}catch (Exception e) {
			
		}
		
		
	}
	
	
}
