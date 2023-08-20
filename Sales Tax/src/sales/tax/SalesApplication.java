package sales.tax;

import java.util.Scanner;

public class SalesApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Receipt receipt = new Receipt();
		
		while (true) {
            System.out.print("Enter item details (name, price, imported separated by commas) or type 'done' to finish: ");
            String itemInput = scanner.nextLine();

            if (itemInput.equalsIgnoreCase("done")) {
                break;
            }

            String[] itemDetails = itemInput.split(",");
//            for(int i=0;i <itemDetails.length;i++)
//            	System.out.println("details: " + itemDetails[i]);
            
                String name = itemDetails[1].trim();
                double price = Double.parseDouble(itemDetails[2].trim());
                boolean isImported = itemDetails[1].trim().toLowerCase().contains("imported");
                Product product = new Product(name, price, isImported);
                Item item = new Item(product, Integer.parseInt(itemDetails[0].trim()));
//                System.out.println("details: " + name+"  " + price +"  " + isImported);

                receipt.addItem(item);
        }
        receipt.printReceipt();
		scanner.close();

    }
}
