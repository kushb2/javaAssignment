package bll;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import data.Flight;
import dataManager.FileCollection;
import dataManager.FlightCollection;
import shared.EnumFlightClass;

public class CsvReader extends Thread {

	public CsvReader(String name) {
		super(name);
	}

	@Override
	public void run() {

		File[] listFile = new File("src/resources").listFiles();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (File file : listFile) {

			// add files in collection of file names
			if (FileCollection.getListFileName().contains(file.getName())) {
				FileCollection.addFileName(file.getName());
			}

			String line;
			String[] data;
			try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath().toString()))) {

				while ((line = reader.readLine()) != null) {
					data = line.split("[|]");
					if (data[0].equals("FLIGHT_NO")) { // cehck header
						continue;

					} else {
						new Flight(data[0], data[1], data[2], LocalDate.parse(data[3], format), data[4], data[5],
								Double.parseDouble(data[6]), data[7], EnumFlightClass.valueOf(data[8]));
					}
				}
				
				FlightCollection.getFlightList().forEach(
						(x,y) -> { System.out.println(x);
						y.forEach(f -> {
							System.out.println(f.toString());
						});
						});

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
