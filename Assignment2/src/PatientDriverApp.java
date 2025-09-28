/*
 * Class: CMSC203 CRN 23118
 * Program: Assignment #2
 * Instructor: Huseyin Aygun
 * Summary of Description: This program manages patient information and tracks medical procedures. 
 * It allows a user to enter personal information for a patient, including name, address, phone number, 
 * and emergency contact. The user then enters details for three medical procedures, such as the procedure 
 * name, date, practitioner, and charges. The program displays all the entered information in an organized 
 * format and calculates the total cost of the procedures. It is designed to be user-friendly, providing 
 * clear prompts and messages throughout, and it saves the information for future reference.
 * Due Date: 09/29/2025
 * Integrity Pledge: I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * Programmer: Idia Ighile
 */

import java.util.Scanner;

public class PatientDriverApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Patient Management Program");

        // Get patient info with non-empty validation
        String firstName = getNonEmptyInput(input, "Enter First Name: ");
        String middleName = getNonEmptyInput(input, "Enter Middle Name: ");
        String lastName = getNonEmptyInput(input, "Enter Last Name: ");
        String street = getNonEmptyInput(input, "Enter Street Address: ");
        String city = getNonEmptyInput(input, "Enter City: ");
        String state = getNonEmptyInput(input, "Enter State: ");
        String zip = getNonEmptyInput(input, "Enter ZIP Code: ");
        String phone = getNonEmptyInput(input, "Enter Phone Number: ");
        String emergencyName = getNonEmptyInput(input, "Enter Emergency Contact Name: ");
        String emergencyPhone = getNonEmptyInput(input, "Enter Emergency Contact Phone: ");

        Patient patient = new Patient(firstName, middleName, lastName, street, city, state, zip, phone, emergencyName, emergencyPhone);

        Procedure[] procedures = new Procedure[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter information for Procedure #" + (i + 1));
            String procName = getNonEmptyInput(input, "Procedure Name: ");
            String procDate = getNonEmptyInput(input, "Procedure Date (MM/DD/YY): ");
            String practitioner = getNonEmptyInput(input, "Practitioner Name: ");
            double charges = getValidDouble(input, "Procedure Charges: ");

            if (i == 0) {
                procedures[i] = new Procedure();
                procedures[i].setProcedureName(procName);
                procedures[i].setProcedureDate(procDate);
                procedures[i].setPractitionerName(practitioner);
                procedures[i].setCharges(charges);
            } else if (i == 1) {
                procedures[i] = new Procedure(procName, procDate);
                procedures[i].setPractitionerName(practitioner);
                procedures[i].setCharges(charges);
            } else {
                procedures[i] = new Procedure(procName, procDate, practitioner, charges);
            }
        }

        // Display patient info
        displayPatient(patient);

        // Display procedures
        for (Procedure p : procedures) {
            displayProcedure(p);
        }

        // Calculate total charges and print
        double total = calculateTotalCharges(procedures[0], procedures[1], procedures[2]);
        System.out.println("\nTotal Charges: $" + String.format("%,.2f", total) + "\n");
        // Display programmer details
        System.out.println("Student Name: Idia Ighile\nM#: M21191742\nDue Date: 09/29/2025");

        input.close();
    }

    public static void displayPatient(Patient patient) {
        System.out.println("\nPatient Info:");
        System.out.println(patient.toString());
    }

    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString());
    }

    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharges() + p2.getCharges() + p3.getCharges();
    }
    
    // Ensures non-empty input for text fields
    public static String getNonEmptyInput(Scanner sc, String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = sc.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("This field cannot be blank. Please enter a value.");
            }
        } while (value.isEmpty());
        return value;
    }

    // Ensures valid numeric input for charges
    public static double getValidDouble(Scanner sc, String prompt) {
        double number = 0.0;
        boolean valid = false;
        do {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                number = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid numeric value.");
            }
        } while (!valid);
        return number;
    }

}

