package com.nagarro.bill;

import shared.Item;
import shared.ItemType;

public class RawItem extends Item {

	public RawItem(String name, Double price, int quantity, ItemType type) {
		super(name, price, quantity, type);
		 setTax( calculateTax());
	}

	@Override
	public Double calculateTax() {
//		12.5% of the item cost
		Double price = getPrice();
		int quantity = getQuantity();
		Double perItemCost = (price * 12.5)/100;;
		return (perItemCost + price)* quantity ;
	}

}
