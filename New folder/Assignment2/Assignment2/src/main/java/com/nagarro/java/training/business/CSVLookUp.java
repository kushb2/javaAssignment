package com.nagarro.java.training.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.nagarro.java.training.data.FileNameCollection;
import com.nagarro.java.training.models.Flight;

public class CSVLookUp extends Thread {

	public CSVLookUp(String id) {
		super(id);
	}

	@Override
	public void run() {
		new java.util.Timer().scheduleAtFixedRate(new java.util.TimerTask() {
			@Override
			public void run() {
				// System.out.println("Look up started");

				File[] fileArray = new File("src/main/java/com/nagarro/java/training/resources").listFiles();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String line = null;
				String[] data = null;
				for (File f : fileArray) {
					if (f.getName().endsWith(".csv")) {
						if (!FileNameCollection.getFileName().contains(f.getName())) {
							FileNameCollection.setFileName(f.getName());
							try (BufferedReader reader = Files
									.newBufferedReader(Paths.get(f.getAbsolutePath().toString()))) {

								while ((line = reader.readLine()) != null) {
									data = line.split("[|]");
									if (data[0].equals("FLIGHT_NO")) {
										continue;
									} else {
										new Flight(data[0], data[1], data[2], LocalDate.parse(data[3], formatter),
												data[4], data[5], Double.parseDouble(data[6]), data[7], data[8]);
									}
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}

			}
		}, 0, 60000);
	}
}