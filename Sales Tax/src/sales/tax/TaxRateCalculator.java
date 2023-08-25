package sales.tax;

import java.util.List;

class TaxRateCalculator {

	//Calculate total tax applicable on all the items
	public double calculateTotalTax(List<Item> items) {
		double totalTax = 0;
		for (Item item : items) {
			totalTax += item.getProduct().calculateTax() * item.getQuantity();
		}
		return totalTax;
	}

	//Calculate total price for all the items along with taxes
	public double calculateTotalPrice(List<Item> items) {
		double totalPrice = 0;
		for (Item item : items) {
			totalPrice += item.getTotalPrice();
		}
		return totalPrice;
	}
}
