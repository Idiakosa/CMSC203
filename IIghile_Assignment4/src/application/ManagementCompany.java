package application;

/** 
 * Class: CMSC203 CRN 23118
Program: Assignment #4
Instructor: Huseyin Aygun
Summary of Description: This project is a Java program that simulates a property management system for a real estate company. The system manages up to five properties, each with its own location, size, owner, and rental amount. It uses three main classes (Plot, Property, and ManagementCompany) to model how properties are contained within plots of land and managed collectively. The program implements key object-oriented concepts such as aggregation, encapsulation, copy constructors, method overloading, and array-based object storage. A GUI is provided to interact with the system, allowing users to add properties, calculate total rent, display the highest-rent property, and list all properties. The project also includes JUnit testing for each class to ensure correctness and reliability.
Due Date: 10/27/2025
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Student: Idiakosa Ighile
 */

public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmFeePercent;
    private Plot plot;
    private Property[] properties;
    private int numberOfProperties;

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    public ManagementCompany() {
        this("", "", 0.0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFeePercent) {
        this(name, taxID, mgmFeePercent, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFeePercent,
                             int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePercent = mgmFeePercent;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Getters / Setters
    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public double getMgmFee() { return mgmFeePercent; }
    public void setMgmFee(double mgmFeePercent) { this.mgmFeePercent = mgmFeePercent; }
    public Plot getPlot() { return plot; }
    public Property[] getProperties() { return properties; }
    public int getPropertiesCount() { return numberOfProperties; }

    /**
     * Add a Property object to the management company.
     * Return codes:
     *  -1 : array is full
     *  -2 : property is null
     *  -3 : property plot not encompassed by mgmt plot
     *  -4 : property plot overlaps existing property
     * otherwise : index where property was added
     */
    public int addProperty(Property property) {
        // 1) Null property check
        if (property == null) {
            return -2;
        }

        // 2) Check if the property’s plot is encompassed by management plot
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }

        // 3) Check for overlap with existing properties
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        // 4) Array full check (last)
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1;
        }

        // 5) Add property
        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1;
    }


    // Overloaded convenience methods
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner,
                           int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public double getTotalRent() {
        double total = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        Property highest = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highest.getRentAmount()) {
                highest = properties[i];
            }
        }
        return highest;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY;
    }

    public boolean isManagementFeeValid() {
        return mgmFeePercent >= 0 && mgmFeePercent <= 100;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name)
          .append(", taxID: ").append(taxID).append("\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n");
        double totalFee = getTotalRent() * mgmFeePercent / 100.0;
        sb.append(String.format(" total management Fee: %.2f", totalFee));
        
        // print my name
        sb.append("Programmer: Idiakosa Ighile\n");
        
        return sb.toString();
        
    }
    static {
        System.out.println("Programmer: Idiakosa Ighile");
    }

}
