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

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        this("", "", 0.0, "", 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner,
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount,
             otherProperty.owner, otherProperty.plot.getX(), otherProperty.plot.getY(),
             otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
    }

    public String getPropertyName() { return propertyName; }
    public String getCity() { return city; }
    public double getRentAmount() { return rentAmount; }
    public String getOwner() { return owner; }
    public Plot getPlot() { return new Plot(plot); }

    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }
    public void setCity(String city) { this.city = city; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setPlot(Plot plot) { this.plot = new Plot(plot); }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%.1f", propertyName, city, owner, rentAmount);
    }
}
