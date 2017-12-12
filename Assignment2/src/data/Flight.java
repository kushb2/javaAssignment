package data;

import java.time.LocalDate;

import dataManager.FlightCollection;
import shared.EnumFlightClass;

public class Flight {


	
	
	
	
	private String flightNo;
	private String depLoc;
	private String arrLoc;
	private LocalDate validTill;
	private String flightTime;
	private String flightDur;
	private double fare;
	private String seatAvailable;
	private EnumFlightClass flightClass;
	public Flight(String flightNo, String depLoc, String arrLoc, LocalDate validTill, String flightTime,
			String flightDur, double fare, String seatAvailable, EnumFlightClass flightClass) {
		super();
		this.flightNo = flightNo;
		this.depLoc = depLoc;
		this.arrLoc = arrLoc;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDur = flightDur;
		this.fare = fare;
		this.seatAvailable = seatAvailable;
		this.flightClass = flightClass;
		
		FlightCollection.addFlight(this.getFlightNo() + this.getDepLoc() + this.getArrLoc() ,this);
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepLoc() {
		return depLoc;
	}
	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}
	public String getArrLoc() {
		return arrLoc;
	}
	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}
	public LocalDate getValidTill() {
		return validTill;
	}
	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getFlightDur() {
		return flightDur;
	}
	public void setFlightDur(String flightDur) {
		this.flightDur = flightDur;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		if (this.flightClass.equals(EnumFlightClass.EB)) {
			this.fare = 1.4 * fare;
		} else {
			this.fare = fare;
		}
	}
	public String getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(String seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
	public EnumFlightClass getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(EnumFlightClass flightClass) {
		this.flightClass = flightClass;
	}
	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		data.append(flightNo);
		data.append("\t");
		data.append(depLoc);
		data.append("\t");
		data.append(arrLoc);
		data.append("\t");
		data.append(validTill);
		data.append("\t");
		data.append(flightTime);
		data.append("\t");
		data.append(flightDur);
		data.append(" Hours\t");
		data.append((float) fare);
		data.append("\t");
		data.append(flightClass);

		return data.toString();
	}
		
	
}
