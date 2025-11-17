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

import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {

    // Reads a file and returns a ragged 2D array of doubles
    public static double[][] readFile(File file) throws FileNotFoundException {
        ArrayList<double[]> rows = new ArrayList<>();
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            double[] row = new double[parts.length];
            for (int i = 0; i < parts.length; i++)
                row[i] = Double.parseDouble(parts[i]);
            rows.add(row);
        }
        input.close();
        return rows.toArray(new double[rows.size()][]);
    }

    // Writes a ragged 2D array to a file
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);
        for (double[] row : data) {
            for (int i = 0; i < row.length; i++) {
                out.print(row[i]);
                if (i < row.length - 1) out.print(" ");
            }
            out.println();
        }
        out.close();
    }

    // Total of all elements
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data)
            for (double val : row)
                total += val;
        return total;
    }

    // Average of all elements
    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;
        for (double[] row : data) {
            for (double val : row) {
                total += val;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    // Total of a row
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double val : data[row])
            total += val;
        return total;
    }

    // Total of a column
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data)
            if (col < row.length)
                total += row[col];
        return total;
    }

    // Highest in a row
    public static double getHighestInRow(double[][] data, int row) {
        double max = data[row][0];
        for (double val : data[row])
            if (val > max)
                max = val;
        return max;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = 0;
        for (int i = 1; i < data[row].length; i++)
            if (data[row][i] > data[row][index])
                index = i;
        return index;
    }

    // Lowest in a row
    public static double getLowestInRow(double[][] data, int row) {
        double min = data[row][0];
        for (double val : data[row])
            if (val < min)
                min = val;
        return min;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = 0;
        for (int i = 1; i < data[row].length; i++)
            if (data[row][i] < data[row][index])
                index = i;
        return index;
    }

    // Highest in a column
    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data)
            if (col < row.length && row[col] > max)
                max = row[col];
        return max;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++)
            if (col < data[i].length && data[i][col] > max) {
                max = data[i][col];
                index = i;
            }
        return index;
    }

    // Lowest in a column
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data)
            if (col < row.length && row[col] < min)
                min = row[col];
        return min;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++)
            if (col < data[i].length && data[i][col] < min) {
                min = data[i][col];
                index = i;
            }
        return index;
    }

    // Highest and lowest in entire array
    public static double getHighestInArray(double[][] data) {
        double max = data[0][0];
        for (double[] row : data)
            for (double val : row)
                if (val > max)
                    max = val;
        return max;
    }

    public static double getLowestInArray(double[][] data) {
        double min = data[0][0];
        for (double[] row : data)
            for (double val : row)
                if (val < min)
                    min = val;
        return min;
    }
}
