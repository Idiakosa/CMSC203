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

class ManagementCompanyTestStudent {
    private ManagementCompany mgmCompany;
    private Property prop1, prop2, prop3;

    @BeforeEach
    void setUp() {
        mgmCompany = new ManagementCompany("BestMgmt", "12345", 10.0);
        prop1 = new Property("Prop1", "CityA", 1000.0, "OwnerA", 0, 0, 2, 2);
        prop2 = new Property("Prop2", "CityB", 2000.0, "OwnerB", 3, 0, 2, 2);
        prop3 = new Property("Prop3", "CityC", 3000.0, "OwnerC", 1, 1, 2, 2); // overlaps prop1
    }

    @Test
    void testAddPropertySuccess() {
        int index = mgmCompany.addProperty(prop1);
        assertEquals(0, index);
        index = mgmCompany.addProperty(prop2);
        assertEquals(1, index);
        assertEquals(2, mgmCompany.getPropertiesCount());
    }

    @Test
    void testAddPropertyFull() {
        mgmCompany.addProperty(new Property("P1","C1",1000,"O1",0,0,1,1));
        mgmCompany.addProperty(new Property("P2","C2",1000,"O2",1,0,1,1));
        mgmCompany.addProperty(new Property("P3","C3",1000,"O3",2,0,1,1));
        mgmCompany.addProperty(new Property("P4","C4",1000,"O4",3,0,1,1));
        mgmCompany.addProperty(new Property("P5","C5",1000,"O5",4,0,1,1));
        int result = mgmCompany.addProperty(new Property("P6","C6",1000,"O6",5,0,1,1));
        assertEquals(-1, result); // Array is full
    }

    @Test
    void testAddPropertyNull() {
        int result = mgmCompany.addProperty(null);
        assertEquals(-2, result);
    }

    @Test
    void testAddPropertyEncompass() {
        Property outside = new Property("Outside", "CityX", 1000, "OwnerX", 20, 20, 5, 5);
        int result = mgmCompany.addProperty(outside);
        assertEquals(-3, result);
    }

    @Test
    void testAddPropertyOverlap() {
        mgmCompany.addProperty(prop1);
        int result = mgmCompany.addProperty(prop3); // overlaps prop1
        assertEquals(-4, result);
    }

    @Test
    void testGetTotalRent() {
        mgmCompany.addProperty(prop1);
        mgmCompany.addProperty(prop2);
        assertEquals(3000.0, mgmCompany.getTotalRent());
    }

    @Test
    void testGetHighestRentProperty() {
        mgmCompany.addProperty(prop1);
        mgmCompany.addProperty(prop2);
        assertEquals(prop2, mgmCompany.getHighestRentProperty());
    }

    @Test
    void testRemoveLastProperty() {
        mgmCompany.addProperty(prop1);
        mgmCompany.addProperty(prop2);
        mgmCompany.removeLastProperty();
        assertEquals(1, mgmCompany.getPropertiesCount());
        assertEquals(prop1, mgmCompany.getProperties()[0]);
    }

    @Test
    void testIsPropertiesFull() {
        mgmCompany.addProperty(new Property("P1","C1",1000,"O1",0,0,1,1));
        mgmCompany.addProperty(new Property("P2","C2",1000,"O2",1,0,1,1));
        mgmCompany.addProperty(new Property("P3","C3",1000,"O3",2,0,1,1));
        mgmCompany.addProperty(new Property("P4","C4",1000,"O4",3,0,1,1));
        mgmCompany.addProperty(new Property("P5","C5",1000,"O5",4,0,1,1));
        assertTrue(mgmCompany.isPropertiesFull());
    }

    @Test
    void testIsManagementFeeValid() {
        assertTrue(mgmCompany.isManagementFeeValid());
        mgmCompany.setMgmFee(-5);
        assertFalse(mgmCompany.isManagementFeeValid());
        mgmCompany.setMgmFee(150);
        assertFalse(mgmCompany.isManagementFeeValid());
    }

    @Test
    void testToStringFormat() {
        mgmCompany.addProperty(prop1);
        mgmCompany.addProperty(prop2);
        String output = mgmCompany.toString();
        assertTrue(output.contains("Prop1,CityA,OwnerA,1000.0"));
        assertTrue(output.contains("Prop2,CityB,OwnerB,2000.0"));
    }
    
    static {
        System.out.println("Programmer: Idiakosa Ighile");
    }

}
