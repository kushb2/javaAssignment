package dataManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.Flight;

public class FlightCollection {

	 static FlightCollection flightCollection = null;
	
	
	
	private FlightCollection() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static FlightCollection getInstance() {
		if(flightCollection == null){
			flightCollection = new FlightCollection();
		}
		return flightCollection;
	}



	private  Map<String, List<Flight>> flightList = new HashMap<String, List<Flight>>();

	

	public  Map<String, List<Flight>> getFlightList() {
		return flightList;
	}



	public  void setFlightList(Map<String, List<Flight>> flightList) {
		this.flightList = flightList;
	}



	public  void addFlight(String key, Flight flight) {

		if (flightList.containsKey(key)) {
			flightList.get(key).add(flight);
		} else {
			List<Flight> fList = new ArrayList<>();
			fList.add(flight);
			this.flightList.put(key, fList);
		}
	}
	
	
}
