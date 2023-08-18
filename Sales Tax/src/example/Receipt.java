package example;

import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Receipt {

	private ArrayList<Item> itemList = new ArrayList<Item>();
	private double total;
	private double taxTotal;
	private final DecimalFormat decfor = new DecimalFormat("0.00");  

	NumberFormat numberFormat= NumberFormat.getInstance();
    
	@SuppressWarnings("resource")
	public Receipt(String inputFileName) {
		try {
		    numberFormat.setMaximumFractionDigits(2);

			Scanner input = new Scanner(System.in);

			File file = new File(inputFileName);

			input = new Scanner(file);

			while (input.hasNextLine()) {

				String line = input.nextLine(); // take the line

				String[] words = line.split(" "); // divide the line into tokens

				int qty = Integer.parseInt(words[0]); // first token is the quantity

				boolean isImported = line.contains("imported"); // check if the item is imported

				String[] exemptedItems = new String[] { "book", "chocolate", "pills" }; // check if the item in the
																						// exempted list
//            	
				int exemptedItemIndex = -1; // Find which type of exemption
				String exemptedType = null;

				for (int i = 0; i < exemptedItems.length; i++) {
					if (line.contains(exemptedItems[i])) {
						exemptedItemIndex = i;
					}
				}
				if (exemptedItemIndex != -1) {
					exemptedType = exemptedItems[exemptedItemIndex];
				}

				Item item = null;

				int splitIndex = line.lastIndexOf("at");

				float price = Float.parseFloat((line.substring(splitIndex + 2))); // the price is the token after the
																					// substring "at"

				String name = line.substring(1, splitIndex); // the name is everything between the qty and at

				if (exemptedType == "book")
					item = new Item(name, Itemtype.BOOK, isImported, price);

				else if (exemptedType == "chocolate")
					item = new Item(name, Itemtype.FOOD, isImported, price);

				else if (exemptedType == "pills")
					item = new Item(name, Itemtype.MEDICAL, isImported, price);

				else
					item = new Item(name, Itemtype.OTHER, isImported, price);
//            	
//				System.out.println(item.name + " " + item.basePrice + " " + item.isImported + " " + item.cat);

				itemList.add(item);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void printReceipt() {
		
	    decfor.setRoundingMode(RoundingMode.UP);
	    for (Item item: itemList) {
	        TaxCalculation calc = new BaseTaxCalculator(item);
	        if (item.cat == Itemtype.OTHER)
	            calc = new SalesTaxCalculation(calc);
	        if (item.isImported)
	            calc = new ImportTaxCalculation(calc);
	        calc = new Rounder(calc);
	        double salesTax = roundTwoDecimals(calc.calc());
	        System.out.println(item.name + " " + decfor.format( item.basePrice + salesTax));

	        total += item.basePrice + salesTax;
	        taxTotal += salesTax;
	    }
	    System.out.println("Sales Taxes: " + decfor.format(taxTotal));
	    System.out.println("Total:"+decfor.format(total));
	}
	
	public double roundTwoDecimals(double d) {
		//A rounding method for double values to 2 decimals
	    DecimalFormat twoDForm = new DecimalFormat("0.00");
	    return Double.valueOf(twoDForm.format(d));
	}
}
