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

class PlotTestStudent {
    private Plot defaultPlot;
    private Plot customPlot;

    @BeforeEach
    void setUp() {
        defaultPlot = new Plot(); // default constructor
        customPlot = new Plot(2, 3, 5, 6); // parameterized constructor
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(0, defaultPlot.getX());
        assertEquals(0, defaultPlot.getY());
        assertEquals(1, defaultPlot.getWidth());
        assertEquals(1, defaultPlot.getDepth());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals(2, customPlot.getX());
        assertEquals(3, customPlot.getY());
        assertEquals(5, customPlot.getWidth());
        assertEquals(6, customPlot.getDepth());
    }

    @Test
    void testCopyConstructor() {
        Plot copyPlot = new Plot(customPlot);
        assertEquals(customPlot.getX(), copyPlot.getX());
        assertEquals(customPlot.getY(), copyPlot.getY());
        assertEquals(customPlot.getWidth(), copyPlot.getWidth());
        assertEquals(customPlot.getDepth(), copyPlot.getDepth());
    }

    @Test
    void testGettersSetters() {
        defaultPlot.setX(10);
        defaultPlot.setY(20);
        defaultPlot.setWidth(15);
        defaultPlot.setDepth(25);
        assertEquals(10, defaultPlot.getX());
        assertEquals(20, defaultPlot.getY());
        assertEquals(15, defaultPlot.getWidth());
        assertEquals(25, defaultPlot.getDepth());
    }

    @Test
    void testToString() {
        assertEquals("2,3,5,6", customPlot.toString());
    }

    @Test
    void testOverlaps() {
        Plot inner = new Plot(3, 4, 2, 2);
        Plot outside = new Plot(10, 10, 2, 2);
        assertTrue(customPlot.overlaps(inner));
        assertFalse(customPlot.overlaps(outside));
    }

    @Test
    void testEncompasses() {
        Plot inner = new Plot(3, 4, 2, 2);
        Plot outside = new Plot(10, 10, 2, 2);
        assertTrue(customPlot.encompasses(inner));
        assertFalse(customPlot.encompasses(outside));
    }
}
