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

//            String[] itemDetails = itemInput.split(" ");
            
            int splitIndex = itemInput.lastIndexOf("at");
                String name = itemInput.substring(1, splitIndex);
                double price = Double.parseDouble(itemInput.substring(splitIndex + 2));
                boolean isImported = itemInput.contains("imported");
                Product product = new Product(name, price, isImported);
                Item item = new Item(product, Integer.parseInt(itemInput.substring(0, 1)));
//                System.out.println("details: " + name+"  " + price +"  " + isImported);

                receipt.addItem(item);
        }
        receipt.printReceipt();
		scanner.close();

    }
}
