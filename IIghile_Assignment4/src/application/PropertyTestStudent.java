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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
    private Property defaultProperty;
    private Property customProperty;

    @BeforeEach
    void setUp() {
        defaultProperty = new Property();
        customProperty = new Property("Lakeview", "Boston", 2000.0, "John Doe", 1, 2, 3, 4);
    }

    @Test
    void testDefaultConstructor() {
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals("", defaultProperty.getOwner());
        assertEquals(0.0, defaultProperty.getRentAmount());
        assertEquals(0, defaultProperty.getPlot().getX());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals("Lakeview", customProperty.getPropertyName());
        assertEquals("Boston", customProperty.getCity());
        assertEquals("John Doe", customProperty.getOwner());
        assertEquals(2000.0, customProperty.getRentAmount());
        assertEquals(1, customProperty.getPlot().getX());
        assertEquals(2, customProperty.getPlot().getY());
    }

    @Test
    void testCopyConstructor() {
        Property copyProp = new Property(customProperty);
        assertEquals(customProperty.getPropertyName(), copyProp.getPropertyName());
        assertEquals(customProperty.getCity(), copyProp.getCity());
        assertEquals(customProperty.getOwner(), copyProp.getOwner());
        assertEquals(customProperty.getRentAmount(), copyProp.getRentAmount());
        assertEquals(customProperty.getPlot().getWidth(), copyProp.getPlot().getWidth());
    }

    @Test
    void testSettersAndGetters() {
        defaultProperty.setPropertyName("OceanView");
        defaultProperty.setCity("Miami");
        defaultProperty.setOwner("Jane Doe");
        defaultProperty.setRentAmount(3000.0);
        defaultProperty.setPlot(new Plot(5, 5, 10, 10));

        assertEquals("OceanView", defaultProperty.getPropertyName());
        assertEquals("Miami", defaultProperty.getCity());
        assertEquals("Jane Doe", defaultProperty.getOwner());
        assertEquals(3000.0, defaultProperty.getRentAmount());
        assertEquals(5, defaultProperty.getPlot().getX());
    }

    @Test
    void testToString() {
        assertEquals("Lakeview,Boston,John Doe,2000.0", customProperty.toString());
    }
}
