package dataManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.Flight;

public class FlightCollection {

	private static Map<String, List<Flight>> flightList = new HashMap<String, List<Flight>>();

	

	public static Map<String, List<Flight>> getFlightList() {
		return flightList;
	}



	public static void setFlightList(Map<String, List<Flight>> flightList) {
		FlightCollection.flightList = flightList;
	}



	public static void addFlight(String key, Flight flight) {

		if (flightList.containsKey(key)) {
			flightList.get(key).add(flight);
		} else {
			List<Flight> fList = new ArrayList<>();
			fList.add(flight);
			FlightCollection.flightList.put(key, fList);
		}
	}
	
	
}
