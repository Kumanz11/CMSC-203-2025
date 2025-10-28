package test;

public class ManagementCompany {
	static final int MAX_PROPERTY = 5; 
	private double mgmFeePer; 
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10; 
	private String name; 
	private int numberOfProperties;
	private Plot plot; 
	private Property[] properties; 
	private String taxID; 
	
	//Creates a ManagementCompany object using empty strings, creates a default Plot with maximum width and depth and it initializes the properties array.
	 public ManagementCompany() {
	        this.name = "";
	        this.taxID = "";
	        this.mgmFeePer = 0;
	        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	        this.properties = new Property[MAX_PROPERTY];
	        this.numberOfProperties = 0;
	    }
	 public ManagementCompany(String name, String taxID, double mgmFee) {
	        this.name = name;
	        this.taxID = taxID;
	        this.mgmFeePer = mgmFee;
	        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	        this.properties = new Property[MAX_PROPERTY];
	        this.numberOfProperties = 0;
	    }

	 public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
	        this.name = name;
	        this.taxID = taxID;
	        this.mgmFeePer = mgmFee;
	        this.plot = new Plot(x, y, width, depth);
	        this.properties = new Property[MAX_PROPERTY];
	        this.numberOfProperties = 0;
	    }
	    //Creates a new ManagementCompany copy of the given ManagementCompany.
	    public ManagementCompany(ManagementCompany otherCompany) {
	        this.name = otherCompany.name; 
	        this.taxID = otherCompany.taxID;
	        this.mgmFeePer = otherCompany.mgmFeePer;
	        this.properties = new Property[MAX_PROPERTY];
			this.plot = new Plot(otherCompany.plot.getX(),otherCompany.plot.getY(),otherCompany.plot.getWidth(),otherCompany.plot.getDepth());
	        this.numberOfProperties = otherCompany.numberOfProperties;
	        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
	            this.properties[i] = new Property(otherCompany.properties[i]);
	        }
	    }
	    //Adds a new property to the properties array
	    
	    public int addProperty(String name, String city, double rent, String owner) {
	        return addProperty(new Property(name, city, rent, owner));

	    }
	    public int addProperty(String name, String city, double rent, String owner,
	                           int x, int y, int width, int depth) {
	        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	    }
	    
	    //Creates a property object by copying from another property and adds it to the properties array.
	    public int addProperty(Property property) {
	        if (property == null) {
	        	return -2;
	        }else if (numberOfProperties >= MAX_PROPERTY) {
	        	return -1;
	        }else if (!plot.encompasses(property.getPlot())) {
	        	return -3;
	        }
	        for (int i = 0; i < numberOfProperties; i++) {
	            if (properties[i].getPlot().overlaps(property.getPlot())) {
	            	return -4;
	            }
	        }
	        properties[numberOfProperties++] = new Property(property);
	        return numberOfProperties - 1;
	    }
	    // Removes(nullifies) the LAST property in the properties array
	    public void removeLastProperty() {
	        if (numberOfProperties > 0) {
	            properties[--numberOfProperties] = null;
	        }
	    }
	    //Checks if the properties array has reached the maximum capacity
	    public boolean isPropertiesFull() {
	        return numberOfProperties >= MAX_PROPERTY;
	    }

	    public int getPropertiesCount() {
	        return numberOfProperties;
	    }

	    public boolean isMangementFeeValid() {
	        return mgmFeePer >= 0 && mgmFeePer <= 100;
	    }

	    public double getTotalRent() {
	        double total = 0;
	        for (int i = 0; i < numberOfProperties; i++) {
	            total += properties[i].getRentAmount();
	        }
	        return total;
	    }

	    private int getHighestRentPropertyIndex() {
	        if (numberOfProperties == 0) {
	        	return -1;
	        }
	        int index = 0;
	        double highest = properties[0].getRentAmount();
	        for (int i = 1; i < numberOfProperties; i++) {
	            if (properties[i].getRentAmount() > highest) {
	                highest = properties[i].getRentAmount();
	                index = i;
	            }
	        }
	        return index;
	    }
	    public Property getHighestRentProperty() {
	        int index = getHighestRentPropertyIndex();
	        if (index == -1) {
	        	return null;
	        }
	        return new Property(properties[index]);
	    }
	    // Getters
	    public String getName() {
	    	return name; 
	    	}
	    public String getTaxID() {
	    	return taxID;
	    	} 
	    public double getMgmFeePer() {
			return mgmFeePer; 
			}	    
	    public Plot getPlot() { 
	    	return new Plot(plot); 
	    	}
	    public Property[] getProperties() { 
	    	return properties; 
	    	}
	    //Represents the information of all the properties in the properties array.
	    public String toString() {
	    	String str = "List of the properties for " + name + ", taxID: " + taxID+"\n______________________________________________________\n";
	    	for(int i = 0; i < numberOfProperties; i++) {
	    		str += properties[i].toString() + "\n";
	    	}
	    	str += "______________________________________________________\n\n total management Fee: " + (Math.round(getTotalRent() * (mgmFeePer / 100) * 100.0) / 100.0);

	    	return str;
	    }
}
