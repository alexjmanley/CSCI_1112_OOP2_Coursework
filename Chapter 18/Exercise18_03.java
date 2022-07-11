package programming18;

import java.util.Scanner; 

public class Exercise18_03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter two numbers "
				+ "seperated by a space to find there GCD: ex. (2 5)");
		int m = input.nextInt();
		int n = input.nextInt();
		
		System.out.println("The GCD of " + m + " and " + n + " is " + findGCD(m, n)); 
		
	}

	public static int findGCD(int m, int n) {
		
		if (m % n == 0)
			return n; 
		else
			return findGCD(n, m % n);
		
	}
	
}
