package programming17;

import java.io.*; 
import java.util.Scanner; 

public class Exercise17_14_15 {
	
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter 1 or 2:");
		System.out.println("1.) Encrypt File");
		System.out.println("2.) Decrypt File");
		
		switch(input.nextInt()) {
		case 1: Encrypt();
			break; 
		case 2: Decrypt(); 
			break; 
		}
	}

	// make Encrypt method
	public static void Encrypt() throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter input File: ");
		File sourceFile = new File(input.next());
		if (!sourceFile.exists()) {
			System.out.println("Source file " + sourceFile + " does not exist");
			System.exit(2);
		}
		
		System.out.println("Enter output File: ");
		File targetFile = new File(input.next());
		
		try (
			BufferedInputStream input1 = 
					new BufferedInputStream(new FileInputStream(sourceFile));
			
			BufferedOutputStream output = 
					new BufferedOutputStream(new FileOutputStream(targetFile));
			
		) {
			
			int r = 0; 
			while ((r = input1.read()) != -1) {
				output.write(((byte)r) + 5);
			}
			
			System.out.println("File Encrypted");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// make decrypt method 
	public static void Decrypt() throws IOException {
		
	Scanner input = new Scanner(System.in);
		
		System.out.println("Enter input File: ");
		File sourceFile = new File(input.next());
		if (!sourceFile.exists()) {
			System.out.println("Source file " + sourceFile + " does not exist");
			System.exit(2);
		}
		
		System.out.println("Enter output File: ");
		File targetFile = new File(input.next());
		
		try (
			BufferedInputStream input1 = 
					new BufferedInputStream(new FileInputStream(sourceFile));
			
			BufferedOutputStream output = 
					new BufferedOutputStream(new FileOutputStream(targetFile));
			
		) {
			
			int r = 0; 
			while ((r = input1.read()) != -1) {
				output.write(((byte)r) - 5);
			}
			
			System.out.println("File Decrypted");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
