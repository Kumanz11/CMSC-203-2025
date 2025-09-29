


package assignment2;

// Patient class that stores patient contact information
public class Patient {
	
	//class fields
	private String firstName; 
	private String middleName;
	private String lastName;
	
	private String street;
	private String city; 
	private String state; 
	private String zipCode;
	
	private String phoneNumber; 
	
	private String ermName;
	private String ermNumber;
	
	//No argument constructor 
	public Patient() {
		firstName = "";
	}
	//Constructor with only full name
	public Patient(String fName, String mName,String lname) {
		firstName = fName;
		middleName = mName;
		lastName = lname;
	}
	//Constructor with all attributes
	public Patient(String fName, String mName,String lname,String st, String c, String s, String z, String pNum, String eName, String eNum) {
		firstName = fName;
		middleName = mName;
		lastName = lname;
		
		street = st;
		city = c;
		state = s;
		zipCode = z;
		
		phoneNumber = pNum;
		
		ermName = eName;
		ermNumber = eNum;
	}
	
	// Mutator Methods
	public void setFirstName(String fName) {
		firstName = fName;
	}
	public void setMiddleName(String mName) {
		middleName = mName;
	}
	public void setLastName(String lName) {
		lastName = lName;
	}
	public void setStreet(String st) {
		street = st;
	}
	public void setCity(String c) {
		city = c;
	}
	public void setState(String s) {
		state = s;
	}
	public void setZipCode(String z) {
		zipCode = z;
	}
	public void setPhoneNumber(String pNum) {
		phoneNumber = pNum;
	}
	public void setEmergencyName(String eName) {
		ermName = eName;
	}
	public void setEmergencyNum(String eNum) {
		ermNumber = eNum;
	}
	
	// Getter methods
	public String getFirstName() {
		return firstName ;
	}
	public String getMiddleName() {
		return middleName ;
	}
	public String getLastName() {
		return lastName ;
	}
	public String getStreet() {
		return street ;
	}
	public String getCity() {
		return city ;
	}
	public String getState() {
		return state ;
	}
	public String getZipCode() {
		return zipCode ;
	}
	public String getPhoneNumber() {
		return phoneNumber ;
	}
	public String getEmergencyName() {
		return ermName ;
	}
	public String getEmergencyNum() {
		return ermNumber;
	}
	
	public String buildFullName() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	public String buildAdress() {
		return street + " " + city + " " + state + " " + zipCode;
	}
	
	public String buildEmergencyContact() {
		return ermName + " " + ermNumber;
	}
	
	public String toString() {
		String str = "Patient info:\n  Name: " + buildFullName() + "\n  Address: " + buildAdress() + "\n  Emergency Contact: " + buildEmergencyContact() + "\n\t";
		return str;
	}
}