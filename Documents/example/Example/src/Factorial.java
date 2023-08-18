
public class Factorial {
	public static void main(String[] args) {
		int k = 5;
		System.out.println("factorial "+factorial(k));
		
		for(int i=0;i<10;i++)
		System.out.println("fabonacii "+fabonacii(i));
		
	}
	
	public static int fabonacii(int n) {
		if(n==0) return 0;
		if(n==1 || n==2) return 1;
		else
			return fabonacii(n-2) + fabonacii(n-1);
		
	}
	public static int factorial(int fact) {
		if(fact==1) return 1;
		return fact*factorial(fact-1);
	}
}
