package shared;

import utility.StringWriter;

public abstract class Item {

	private String name;
	private Double price;
	private int quantity;
	private ItemType type;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public ItemType getType() {
		return type;
	}


	public void setType(ItemType type) {
		this.type = type;
	}


	public Double getTax() {
		return tax;
	}


	public void setTax(Double tax) {
		this.tax = tax;
	}

	protected Double tax;
	
	public Item(String name, Double price, int quantity, ItemType type) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}

	
	@Override
	public String toString() {
		StringBuilder br = StringWriter.getInstance();
		br.append("name : "  + name + "\n");
		br.append("price : " + price + "\n");
		br.append("quantity : " + quantity + "\n");
		br.append("item Type : " + type.toString() + "\n");
		br.append("Tax : " + tax); 
		return br.toString();
	}
	
	public abstract Double calculateTax();

}
