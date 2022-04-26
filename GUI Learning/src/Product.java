public class Product { //we need name, price, and quantity data for each item
	private String name;
	private double price;
	private int quantity;
	
	public Product() { //default constructor
		this.name = "";
		this.price = 0.0;
		this.quantity = 0;
	}

	public Product(String name, double price, int quantity) {//override constructor
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
