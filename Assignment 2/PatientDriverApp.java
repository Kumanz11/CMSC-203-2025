package assignment2;
import java.util.Scanner;

public class PatientDriverApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter Patients first name: ");
		String firstName = keyboard.nextLine();
		System.out.println("Enter Patients middle name: ");
		String middleName = keyboard.nextLine();
		System.out.println("Enter Patients last name: ");
		String lastName = keyboard.nextLine();
		
		System.out.println("Enter street address: ");
		String street = keyboard.nextLine();
		System.out.println("Enter city: ");
		String city = keyboard.nextLine();
		System.out.println("Enter State: ");
		String state = keyboard.nextLine();
		System.out.println("Enter zip code: ");
		String zipCode = keyboard.nextLine();
		
		System.out.println("Enter phone number: ");
		String phoneNumber = keyboard.nextLine();
		
		System.out.println("Enter emergency contact name: ");
		String ermName = keyboard.nextLine();
		System.out.println("Enter emergency phone number: ");
		String ermNumber = keyboard.nextLine();
		
		Patient patient1 =new Patient(firstName,middleName,lastName,street,city,state,zipCode,phoneNumber,ermName,ermNumber);
		
		
		Procedure procedure1  = new Procedure(); 
		
		System.out.println("Please Enter procedure name for procedure 2");
		String pro2Name = keyboard.nextLine();
		System.out.println("Please Enter procedure date for procedure 2");
		String pro2Date = keyboard.nextLine();
		
		Procedure procedure2 = new Procedure (pro2Name, pro2Date);
		
		System.out.println("Please Enter procedure name for procedure 3");
		String pro3Name = keyboard.nextLine();
		System.out.println("Please Enter procedure date for procedure 3: ");
		String pro3Date = keyboard.nextLine();
		System.out.println("Please Enter doctor name for procedure 3: ");
		String pro3Doc = keyboard.nextLine();
		System.out.println("Please Enter procedure charge for procedure 3");
		double pro3Charges = keyboard.nextDouble();
		
		Procedure procedure3 = new Procedure(pro3Name,pro3Date,pro3Doc,pro3Charges);
		displayPatient(patient1);
		displayProcedure(procedure1);
		displayProcedure(procedure2);
		displayProcedure(procedure3);

		System.out.printf("Total charges: $%,.2f\n\n", calculateTotalCharges(procedure1,procedure2,procedure3));	
		System.out.println("Student Name: Kevin Umanzor");
		System.out.println("MC#: M21188839");
		System.out.println("Due Date: 09/29/2025");
		
		keyboard.close();
		
	}

	public static void displayPatient(Patient pat) {
		System.out.println(pat.toString());
	}
	
	public static void displayProcedure(Procedure pro) {
		System.out.println(pro.toString());
	}
	
	public static double calculateTotalCharges(Procedure pro1, Procedure pro2, Procedure pro3) {
		double total = 0.0; 
		total = pro1.getCharges()+pro2.getCharges()+pro3.getCharges();
		return total;
	}

}

