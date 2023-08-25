package sales.tax;

import java.util.Scanner;

public class SalesApplication {
	public static void main(String[] args) {
		Receipt receipt = new Receipt();

		collectItemDetails(receipt);
		receipt.printReceipt();

	}

	public static void collectItemDetails(Receipt receipt) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Enter item details or type 'done' to finish: ");
			String itemInput = scanner.nextLine();

			if (itemInput.equalsIgnoreCase("done")) {
				break;
			}

			int splitIndex = itemInput.lastIndexOf("at");
			String name = itemInput.substring(2, splitIndex-1);
			double price = Double.parseDouble(itemInput.substring(splitIndex + 2));
			boolean isImported = itemInput.contains("imported");
			Product product = new Product(name, price, isImported);
			Item item = new Item(product, Integer.parseInt(itemInput.substring(0, 1)));

			receipt.addItem(item);
		}
		scanner.close();
	}
}
