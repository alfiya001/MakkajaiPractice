package sales.tax;

import java.util.List;

class SalesTaxCalculator {
//    public double calculateSalesTax(Item item) {
//        double salesTaxRate = getSalesTaxRate(item);
//        double salesTax = Math.round(item.getProduct().getPrice() * salesTaxRate * item.getQuantity() * 20.0) / 20.0;
//        return salesTax;
//    }
//
//    private double getSalesTaxRate(Item item) {
//        double basicRate = item.getProduct().isImported() ? 0.15 : 0.10;
//        double exemptRate = (item.getProduct().getName().contains("book") || item.getProduct().getName().contains("chocolate") || item.getProduct().getName().contains("pill")) ? 0.0 : basicRate;
//        return exemptRate;
//    }
	
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
