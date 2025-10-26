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

/**
 * This class represents GFA test cases for a ManagementCompany object.
 * 
 * @author Farnaz Eivazi
 * @version 7/12/2022
 * 
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagementCompanyGFATest {
	Property sampleProperty;
	ManagementCompany mangementCo; 
	
	@BeforeEach
	public void setUp() throws Exception {
		mangementCo = new ManagementCompany("Railey", "555555555", 6);
	}

	@AfterEach
	public void tearDown() throws Exception {
		mangementCo = null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 2, 5, 2, 2);		 
		assertEquals(0, mangementCo.addProperty(sampleProperty));	// property has been successfully added to index 0
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 2, 5, 2, 2);		 
		assertEquals(0, mangementCo.addProperty(sampleProperty));	
		assertEquals(1, mangementCo.getPropertiesCount());
	}

	@Test
	public void testToString() {
		sampleProperty = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);
		assertEquals(0, mangementCo.addProperty(sampleProperty));	// property has been successfully added to index 0
		String expectedString = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
				+ "______________________________________________________\n"
				+ " total management Fee: 156.78";
		System.out.println("Expected:");
		System.out.println(expectedString);
		System.out.println("Actual:");
		System.out.println(mangementCo.toString());
		assertEquals(expectedString, mangementCo.toString());
	}
}