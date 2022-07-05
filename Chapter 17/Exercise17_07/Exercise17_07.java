package programming177;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rmazorow
 */
import java.io.*;
public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new 
FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        outputData(); 
    }
    public static void outputData() throws ClassNotFoundException {
    	try {
			@SuppressWarnings("resource")
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
			int i = 0;
			while(i == 0) {
			Loan loan =(Loan)input.readObject();
			System.out.println("Total Loan Amount for " + loan + ": ");
			System.out.printf("$%1.2f",loan.getLoanAmount());
			System.out.println();
			}
    	} catch (EOFException e) {
    		
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}