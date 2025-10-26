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

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(Plot other) {
        this(other.x, other.y, other.width, other.depth);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setDepth(int depth) { this.depth = depth; }

    public boolean overlaps(Plot other) {
        if (other == null) return false;

        // If one rectangle is on left side of the other
        if (x >= other.x + other.width || other.x >= x + width)
            return false;

        // If one rectangle is above the other
        if (y >= other.y + other.depth || other.y >= y + depth)
            return false;

        return true;
    }

    public boolean encompasses(Plot other) {
        if (other == null) return false;

        return (x <= other.x) &&
               (y <= other.y) &&
               (x + width >= other.x + other.width) &&
               (y + depth >= other.y + other.depth);
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
    
}
