package bll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import shared.Item;
import shared.ItemType;

public class TaxManager {

	private static TaxManager manager = new TaxManager();

	private TaxManager() {
	}

	public static TaxManager getInstance() {
		return manager;
	}

	List<Item> listItem = new ArrayList<>();

	public String Add(String[] inputData) {
		Item item = getType(inputData);
		return item.toString();
	}

	private Item getType(String[] inputData) {
		Item item = null;
		try {
			String name = inputData[0];
			Double price = Double.parseDouble(inputData[1]);
			int quantity = Integer.parseInt(inputData[2]);
			ItemType type = ItemType.values()[Integer.parseUnsignedInt(inputData[3])];
			if (type.equals(ItemType.Raw))
				item = new RawItem(name, price, quantity, type);
			else if (type.equals(ItemType.Imported))
				item = new ImortedItem(name, price, quantity, type);
			else if (type.equals(ItemType.Manufactured))
				item = new ManufacturedItem(name, price, quantity, type);
			
		} catch (Exception e) {
			throw e;
		}
		return item;
	}

}
