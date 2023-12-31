package sales.tax;

public class Item {
	private Product product;
	private int quantity;

	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//Return total price of single item 
	public double getTotalPrice() {
		return (product.getPrice() + product.calculateTax()) * quantity;
	}

	@Override
	public String toString() {
		return quantity + " " + product.getName() + ": " + String.format("%.2f", getTotalPrice());
	}

}
