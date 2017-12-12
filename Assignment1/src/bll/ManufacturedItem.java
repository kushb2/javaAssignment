package bll;

import shared.Item;
import shared.ItemType;

public class ManufacturedItem extends Item {

	public ManufacturedItem(String name, Double price, int quantity, ItemType type) {
		super(name, price, quantity, type);
		setTax(calculateTax());
	}

	@Override
	public Double calculateTax() {
		Double price = getPrice();
		int quantity = getQuantity();
		// Manufactured: 12.5% of the item cost + 2% of (item cost + 12.5% of
		// item cost)
		Double perItemCost = (price * 12.5) / 100;
		perItemCost += (perItemCost * 2) / 100;
		return (perItemCost + price) * quantity;

	}

}
