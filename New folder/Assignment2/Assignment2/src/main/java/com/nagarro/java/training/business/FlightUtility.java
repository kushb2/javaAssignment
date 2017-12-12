package com.nagarro.java.training.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nagarro.java.training.data.FlightCollection;
import com.nagarro.java.training.models.Flight;
import com.nagarro.java.training.models.FlightDTO;

public class FlightUtility {

	@SuppressWarnings("unchecked")
	public static void searchFlight(FlightDTO flightDTO) {
		StringBuilder keyBuilder = new StringBuilder(20);
		List<Flight> searchResults = new ArrayList<Flight>();

		keyBuilder.append(flightDTO.deptLoc.toUpperCase());
		keyBuilder.append(flightDTO.arrLoc.toUpperCase());
		
		if (flightDTO.flightClass.toUpperCase().equals("B")) {
			keyBuilder.append("EB");
			if (FlightCollection.getFlightList().containsKey(keyBuilder.toString())) {
				searchResults = FlightCollection.getFlightList().get(keyBuilder.toString());
			}
		} else if (flightDTO.flightClass.toUpperCase().equals("E")) {
			keyBuilder.append("E");
			if (FlightCollection.getFlightList().containsKey(keyBuilder.toString())) {
				searchResults = FlightCollection.getFlightList().get(keyBuilder.toString());
			}
			keyBuilder.deleteCharAt(6).append("EB");
			if (FlightCollection.getFlightList().containsKey(keyBuilder.toString())) {
				searchResults.addAll(FlightCollection.getFlightList().get(keyBuilder.toString()));
			}
		}
		// FlightCollection.getFlightList().forEach((k, v) ->
		// System.out.println("key: " + k + " value:" + v));
		if (!searchResults.isEmpty()) {

			Collections.sort(searchResults, new FareComparator());

			for (Flight flight : searchResults) {
				if ((flight.getSeatAvailable().equals("Y")) && (flight.getValidTill().isEqual(flightDTO.flightDate)
						|| flight.getValidTill().isAfter(flightDTO.flightDate))) {
					if (flightDTO.flightClass.toUpperCase().equals("B")) {
						flight.setFare(flight.getFare());
					}
					System.out.println(flight);
				}
			}
			// searchResults.forEach(System.out::println);
		} else {
			System.out.println("No Flight available");
		}
	}
}
