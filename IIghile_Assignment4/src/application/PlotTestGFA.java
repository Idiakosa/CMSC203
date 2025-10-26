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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestGFA {
	private Plot plot1, plot5;

	@BeforeEach
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot5 = new Plot(3, 4, 4, 3);
	}

	@AfterEach
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
	}
	
	@Test
	public void testToString() {
		assertEquals("3,4,4,3", plot5.toString());	
	}
}