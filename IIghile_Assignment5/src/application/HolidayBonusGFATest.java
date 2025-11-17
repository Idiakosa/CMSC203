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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class HolidayBonusGFATest {

    private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateHolidayBonusA() {
        try {
            double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
            assertEquals(3000.0, result[0], 0.001);
            assertEquals(4000.0, result[1], 0.001);
            assertEquals(15000.0, result[2], 0.001);
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonusA() {
        assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), 0.001);
    }
}
