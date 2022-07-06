package programming17;

import java.io.*;
import java.util.Scanner; 

public class Exercise17_14_15 {
		
	public static void main(String[] args) throws Exception, IOException {
		Scanner input = new Scanner(System.in); 
		
		System.out.println("Enter 1 or 2");
		System.out.println("1.) Encrpyt");
		System.out.println("2.) Decrypt");
		
		switch(input.nextInt()) {
		case 1: Encrypt();
			break; 
		case 2: Decrypt(); 
			break; 
		}
		
	}
	
	// create encrypt method 
	public static void Encrypt() throws IOException {
		Scanner input = new Scanner(System.in);
		
		// prompt user and make sure input file exists
		System.out.println("Enter input file: ");
		File inputFile = new File(input.next());
		if(!inputFile.exists()) {
			System.out.println("Source file " + inputFile + " does not exist");
			System.exit(1);
		}
		
		System.out.println("Enter output file: ");
		File outputFile = new File(input.next());
		
		// try having the input read to the output and add 5 to the end 
		try {
			BufferedInputStream input1 = 
					new BufferedInputStream(new FileInputStream(inputFile));
			BufferedOutputStream output = 
					new BufferedOutputStream( new FileOutputStream(outputFile));
			
			int r = 0; 
			while ((r = input1.read()) != -1)
				output.write(r + 5);
			
			System.out.println("file encrypted");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// create Decrypt method 
	public static void Decrypt() throws IOException {
		Scanner input = new Scanner(System.in);
		
		// Prompt user and make sure input value exists
		System.out.println("Enter input file: ");
		File inputFile = new File(input.next());
		if(!inputFile.exists()) {
			System.out.println("Source file " + inputFile + " does not exist");
			System.exit(1);
		}
		
		System.out.println("Enter output file: ");
		File outputFile = new File(input.next());
		
		// read input file and 
		try {
			BufferedInputStream input1 = 
					new BufferedInputStream(new FileInputStream(inputFile));
			BufferedOutputStream output = 
					new BufferedOutputStream( new FileOutputStream(outputFile));
			
			int r = 0; 
			while ((r = input1.read()) != -1)
				output.write(r - 5);
			
			System.out.println("file decrypted");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
