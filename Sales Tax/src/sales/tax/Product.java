package sales.tax;

public class Product {
	private String name;
	private double price;
	private boolean isImported;

	public Product(String name, double price, boolean isImported) {
		super();
		this.name = name.replace(" at", "");
		this.price = price;
		this.isImported = isImported;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.replace(" at", "");
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isImported() {
		return isImported;
	}

	public double calculateTax() {
        double exemptRate = (name.contains("chocolate") || name.contains("book") || name.contains("pill")) ? 0.0 : 0.10;

        double taxRate = isImported ? (exemptRate+0.05) : (exemptRate+0); // Basic sales tax rate
//        System.out.println(name.contains("chocolate")+"taxRate : "+taxRate);
//        System.out.println("exemptRate : "+exemptRate);
        return Math.ceil(price * taxRate * 20) / 20.0; // Rounded to nearest 0.05
    }

}
