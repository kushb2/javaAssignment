package bll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import data.Flight;
import data.FlightSearch;
import dataManager.FlightCollection;
import shared.EnumFlightClass;
import shared.EnumReader;
import utility.ReaderWriterUtility;

public class FlightFinder {

	@SuppressWarnings("unchecked")
	public static void find(FlightSearch flightSearch) {
		
			StringBuilder builder = (StringBuilder) ReaderWriterUtility.getInstance(EnumReader.STRING_BUILDRR);
			List<Flight> searchResults = new ArrayList<Flight>();

			builder.append(flightSearch.getDeptLoc().toUpperCase());
			builder.append(flightSearch.getArrLoc().toUpperCase());
			
			if (flightSearch.getClass().equals(EnumFlightClass.EB)) {
				builder.append("EB");
				if (FlightCollection.getInstance().getFlightList().containsKey(builder.toString())) {
					searchResults = FlightCollection.getInstance().getFlightList().get(builder.toString());
				}
			} else if (flightSearch.getClass().equals(EnumFlightClass.E)) {
				builder.append("E");
				if (FlightCollection.getInstance().getFlightList().containsKey(builder.toString())) {
					searchResults = FlightCollection.getInstance().getFlightList().get(builder.toString());
				}
				builder.deleteCharAt(6).append("EB");
				if (FlightCollection.getInstance().getFlightList().containsKey(builder.toString())) {
					searchResults.addAll(FlightCollection.getInstance().getFlightList().get(builder.toString()));
				}
			}
			// FlightCollection.getFlightList().forEach((k, v) ->
			// System.out.println("key: " + k + " value:" + v));
			if (!searchResults.isEmpty()) {

				Collections.sort(searchResults, new Comparator() {

					@Override
					public int compare(Object arg0, Object arg1) {
						// TODO Auto-generated method stub
						Flight flight1 = (Flight) arg0;
						Flight flight2 = (Flight) arg1;

						if (flight1.getFare() > flight2.getFare()) {
							return 1;
						} else if (flight1.getFare() < flight2.getFare()) {
							return -1;
						}
						return 0;
					}
					
				});

				for (Flight flight : searchResults) {
					if ((flight.getSeatAvailable().equals("Y")) && (flight.getValidTill().isEqual(flightSearch.getFlightDate())
							|| flight.getValidTill().isAfter(flightSearch.getFlightDate()))) {
						if (flightSearch.getFlightClass().equals(EnumFlightClass.EB)) {
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
