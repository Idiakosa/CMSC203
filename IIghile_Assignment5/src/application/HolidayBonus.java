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

public class HolidayBonus {

    public static final double HIGHEST_BONUS = 5000.0;
    public static final double LOWEST_BONUS = 1000.0;
    public static final double OTHER_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        int maxCol = 0;
        for (double[] row : data)
            if (row.length > maxCol) maxCol = row.length;

        for (int col = 0; col < maxCol; col++) {
            // Find stores with valid sales (>0)
            int countValid = 0;
            for (int r = 0; r < data.length; r++)
                if (col < data[r].length && data[r][col] > 0)
                    countValid++;

            double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
            double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);

            for (int row = 0; row < data.length; row++) {
                if (col >= data[row].length || data[row][col] <= 0) continue;

                // Single-store category
                if (countValid == 1) {
                    bonuses[row] += HIGHEST_BONUS;
                } else if (data[row][col] == highest) {
                    bonuses[row] += HIGHEST_BONUS;
                } else if (data[row][col] == lowest) {
                    bonuses[row] += LOWEST_BONUS;
                } else {
                    bonuses[row] += OTHER_BONUS;
                }
            }
        }

        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double total = 0;
        double[] bonuses = calculateHolidayBonus(data);
        for (double b : bonuses)
            total += b;
        return total;
    }
}
