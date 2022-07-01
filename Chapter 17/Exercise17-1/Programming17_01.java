package programming171;

import java.io.FileNotFoundException;
import java.io.PrintWriter; 

public class Programming17_01 {

	public static void main(String[] args) {
		
		// create PrintWriter to add Exercise17_01
		try {
			PrintWriter output = new PrintWriter("Exercise17_01.txt");
			for (int i = 0; i < 100; i++) {
				output.print((int)(Math.random() * 10) + " ");
			}
			output.close(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
}
