package assignment2;

//Procedure that stores procedure details
public class Procedure {
	
	//Fields
	private String procedureName;
	private String date; 
	private String docName;
	private double charges;

	
	//No argument constructor
	public Procedure(){
		procedureName = "Physical Exam";
		date = "7/20/2019";
		docName = "Dr. Irvine";
		charges = 3250.0;
		
		
	}
	
	//Name and date constructor
	public Procedure(String pName, String d) {
		procedureName = pName; 
		date = d;
		docName = "Dr. Jamison";
		charges = 5500.43; 
	}
	
	//Constructor with all attributes
	public Procedure(String pName, String d, String dName, double c) {
		procedureName = pName; 
		date = d;
		docName = dName;
		charges = c; 
	}
	
	//Mutator Methods
	public void setProcedureName(String pName) {
		procedureName = pName; 
	}
	public void setDate(String d) {
		date = d;
	}
	public void setDocName(String dName) {
		docName  = dName;
	}
	public void setCharges(double c) {
		charges = c;
	}
	
	//getter Methods
	public String getProcedureName() {
		return procedureName;
	}
	public String getDate() {
		return date;
	}
	public String getDocName() {
		return docName;
	}
	public double getCharges() {
		return charges;
	}
	
	public String toString() {
		String str = "\tProcedure: "+ getProcedureName() + "\n\tProcedure Date: " + getDate() + "\n\tPractioner: " + getDocName() + "\n\tCharge is: $" + getCharges()+ "\n";
		return str;
	}
}
