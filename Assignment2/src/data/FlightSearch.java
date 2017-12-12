package data;

import java.time.LocalDate;

import shared.EnumFlightClass;

public class FlightSearch {
		 String deptLoc;
		 String arrLoc;
		 LocalDate flightDate;
		 public String getDeptLoc() {
			return deptLoc;
		}
		public void setDeptLoc(String deptLoc) {
			this.deptLoc = deptLoc;
		}
		public String getArrLoc() {
			return arrLoc;
		}
		public void setArrLoc(String arrLoc) {
			this.arrLoc = arrLoc;
		}
		public LocalDate getFlightDate() {
			return flightDate;
		}
		public void setFlightDate(LocalDate flightDate) {
			this.flightDate = flightDate;
		}
		public EnumFlightClass getFlightClass() {
			return flightClass;
		}
		public void setFlightClass(EnumFlightClass flightClass) {
			this.flightClass = flightClass;
		}
		EnumFlightClass flightClass;
}

