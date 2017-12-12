package com.nagarro.java.training.business;

import java.util.Comparator;

import com.nagarro.java.training.models.Flight;

@SuppressWarnings("rawtypes")
public class FareComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Flight flight1 = (Flight) o1;
		Flight flight2 = (Flight) o2;

		if (flight1.getFare() > flight2.getFare()) {
			return 1;
		} else if (flight1.getFare() < flight2.getFare()) {
			return -1;
		}
		return 0;
	}

}
