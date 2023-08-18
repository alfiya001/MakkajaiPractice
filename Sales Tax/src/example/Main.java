package example;
public class Main {

	public static void main(String[] args) {
		Receipt receipt = new Receipt("C:\\Users\\2106421\\Documents\\MakkajaiPractice\\Sales Tax\\src\\example\\test1");	
		receipt.printReceipt();
		
		Receipt receipt2 = new Receipt("C:\\Users\\2106421\\Documents\\MakkajaiPractice\\Sales Tax\\src\\example\\test2");	
		receipt2.printReceipt();
		
		Receipt receipt3 = new Receipt("C:\\Users\\2106421\\Documents\\MakkajaiPractice\\Sales Tax\\src\\example\\test3");	
		receipt3.printReceipt();
	}

}
