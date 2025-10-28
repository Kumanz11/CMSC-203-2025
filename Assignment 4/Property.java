package test;

public class Property {
	private String city; 
	private String owner; 
	private Plot plot; 
	private String propertyName; 
	private double rentAmount; 
	
	//Creates a new Property using empty Strings
	public Property() {
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0.0;
	    this.plot = new Plot();
		
	}
	//Creates a new Property object using given values.
	public Property(String propertyName, String city, double rentAmount, String owner ) {
		this.propertyName = propertyName; 
		this.city = city;
		this.rentAmount = rentAmount; 
		this.owner = owner; 
		this.rentAmount = rentAmount;
	    this.plot = new Plot();
	}
	//Creates a new Property object using given values.
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName; 
		this.city = city;
		this.rentAmount = rentAmount; 
		this.owner = owner; 
		this.plot = new Plot(x,y,width,depth);
	}
	//Creates a new copy of the given property object.
	public Property(Property otherProperty) {
		if(otherProperty == null) {
			return;
		}
		this.propertyName = otherProperty.propertyName; 
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount; 
		this.owner = otherProperty.owner; 
		this.plot = new Plot(otherProperty.plot.getX(),otherProperty.plot.getY(),otherProperty.plot.getWidth(),otherProperty.plot.getDepth());
	}
	
	//getter methods
	public String getCity() {
		return city; 
	}
	public String getOwner() {
		return owner; 
	}
	public Plot getPlot() {
	    return new Plot(plot);
	}
	public String getPropertyName() {
		return propertyName;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	//Represents a Property object in the following String format: propertyName,city,owner,rentAmount
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount; 
	}
}
