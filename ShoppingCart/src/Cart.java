import java.math.BigDecimal;


public class Cart {
	
	private String name;
	private double price;
	private int quantity;
	
	
	public Cart() {

		this.name = "";
		this.price = 0;
		this.quantity = 0;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
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

	public void setPrice(double bigDecimal) {
		this.price = bigDecimal;
	}
	
}
