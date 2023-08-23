package sales.tax;

import java.util.List;

class TaxRateCalculator {

	public double calculateTotalTax(List<Item> items) {
        double totalTax = 0;
        for (Item item : items) {
            totalTax += item.getProduct().calculateTax() * item.getQuantity();
        }
        return totalTax;
    }

    public double calculateTotalPrice(List<Item> items) {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
