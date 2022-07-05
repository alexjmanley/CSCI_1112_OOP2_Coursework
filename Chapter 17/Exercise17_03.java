package programming173;

import java.io.*;

public class Exercise17_03 {
	
	public static void main(String[] args) throws IOException {
			
		createFile(); 
		readFile(); 
	}
	public static void createFile() throws IOException {
		try {
			DataOutputStream output = 
					new DataOutputStream(new FileOutputStream("Exercise17_03.dat"));
			for (int i = 0; i < 100; i++) 
				output.writeInt((int)(Math.random() * 10));
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void readFile() throws IOException {
		try {
			DataInputStream input = 
					new DataInputStream(new FileInputStream("Exercise17_03.dat"));
			int sum = 0; 
			while (input.available() > 0)
				sum = sum + input.readInt();
			System.out.println("The sum of the Integers: " + sum); 
			input.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
