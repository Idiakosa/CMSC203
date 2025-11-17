/* Class: CMSC203 CRN 23118
 Program: Assignment #5
 Instructor: Huseyin Aygun
 Summary of Description: This project involves creating two Java utility classes to process sales data stored in ragged two-dimensional arrays. One class reads, writes, and analyzes the sales figures, while the other calculates holiday bonuses based on highest, lowest, and mid-range sales in each category. These utilities work together with a provided GUI to display store totals, category totals, and bonus amounts. The assignment also requires JUnit testing, UML documentation, screenshots, and reflection on the development process.
 Due Date: 11/16/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Idiakosa Ighile
*/
package application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents GFA test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 */
public class TwoDimRaggedArrayUtilityGFATest {
    private double[][] dataSet1;

    @BeforeEach
    public void setUp() {
        dataSet1 = new double[][]{{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
    }

    @AfterEach
    public void tearDown() {
        dataSet1 = null;
    }

    /**
     * Test getRowTotal method
     * Returns the total of all the elements of row 1.
     * Row 0 refers to the first row in the two dimensional array
     */
    @Test
    public void testGetRowTotal() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), 0.001);
    }
}