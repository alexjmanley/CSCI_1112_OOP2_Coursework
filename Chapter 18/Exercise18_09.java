package programming189;

import java.util.Scanner; 

public class Exercise18_09 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a String");
		String user = input.next(); 
		
		flipString(user);

	}

	public static void flipString(String s) {
	
		if (s.length() <= 1)
			System.out.print(s);
		else {
			System.out.print(s.charAt(s.length() - 1));
			flipString(s.substring(0, s.length() - 1));
		}
	}
	
}
