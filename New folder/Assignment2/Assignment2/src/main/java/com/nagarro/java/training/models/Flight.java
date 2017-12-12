package com.nagarro.java.training.models;

import java.time.LocalDate;

import com.nagarro.java.training.data.FlightCollection;

public class Flight {
	private String flightNo;
	private String departmentLocation;
	private String arrivalLocation;
	private LocalDate validTill;
	private String flightTime;
	private String flightDuration;
	private double fare;
	private String seatAvailable;
	private String flightClass;

	public Flight(String flightNo, String departmentLocation, String arrivalLocation, LocalDate validTill,
			String flightTime, String flightDuration, double fare, String seatAvailable, String flightClass) {
		this.flightNo = flightNo;
		this.departmentLocation = departmentLocation;
		this.arrivalLocation = arrivalLocation;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDuration = flightDuration;
		this.seatAvailable = seatAvailable;
		this.flightClass = flightClass;
		this.fare = fare;

		FlightCollection.setFlightList(this.departmentLocation + this.arrivalLocation + this.flightClass, this);
	}

	public void setFare(double fare) {
		if (this.flightClass.equals("EB")) {
			this.fare = 1.4 * fare;
		} else {
			this.fare = fare;
		}
	}

	public String getFlightNo() {
		return flightNo;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public LocalDate getValidTill() {
		return validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public String getFlightDuration() {
		return flightDuration;
	}

	public double getFare() {
		return fare;
	}

	public String getSeatAvailable() {
		return seatAvailable;
	}

	public String getFlightClass() {
		return flightClass;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		data.append(flightNo);
		data.append("\t");
		data.append(departmentLocation);
		data.append("\t");
		data.append(arrivalLocation);
		data.append("\t");
		data.append(validTill);
		data.append("\t");
		data.append(flightTime);
		data.append("\t");
		data.append(flightDuration);
		data.append(" Hours\t");
		data.append((float) fare);
		data.append("\t");
		data.append(flightClass);

		return data.toString();
	}
}
