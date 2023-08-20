package sales.tax;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	private List<Item> items = new ArrayList<Item>();
	private SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator();
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void printReceipt() {

        for (Item item : items) {
            System.out.println(item);
        }
        

		/* We can calculate total tax and price in single function also
		double totalTax = 0;
		double totalPrice = 0;
		for (Item item : items) {
			totalPrice += item.getTotalPrice();
			totalTax += item.product.calculateTax() * item.quantity;
		}*/
        
        System.out.println("Sales Taxes: " + String.format("%.2f", salesTaxCalculator.calculateTotalTax(items)));
        System.out.println("Total: " + String.format("%.2f", salesTaxCalculator.calculateTotalPrice(items)));

	}
}
