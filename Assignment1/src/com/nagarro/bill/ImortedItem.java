package com.nagarro.bill;

import shared.Item;
import shared.ItemType;

public class ImortedItem  extends Item{

	

	public ImortedItem(String name, Double price, int quantity, ItemType type) {
		super(name, price, quantity, type);
		 setTax( calculateTax());
	}

	/*
	 * 10% import duty on item cost + a surcharge
		(surcharge is: Rs. 5 if the final cost after applying tax
		& import duty is up to Rs. 100, Rs. 10 if the cost exceeds 100 
		and up to 200 and 5% of the final cost if it exceeds 200).
	 */
	@Override
	public Double calculateTax() {
		Double price = getPrice();
		int quantity = getQuantity();
		Double importDity = (price * 10)/100;
		Double perItemCost = (price * 12.5)/100;
		perItemCost += (perItemCost* 2)/100;
		return (perItemCost + price + importDity) * quantity;	
	}
}
