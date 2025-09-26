/*
Class: CMSC203 CRN 23118
Program: Lab 1
Instructor: Huseyin Aygun
Summary of Description:  This program serves as the driver class for Lab 1. It demonstrates how to  write a Java program from pseudocode and 
test a separate data element class. The driver creates a Movie object, prompts the user for movie details (title, rating, and number of tickets sold), 
stores the data using setter methods, and prints the information using the Movie class’s toString method. In Task 2, the driver is 
extended with a loop to allow input and display of multiple movies until the user chooses to stop.
Due Date: 09/26/2025 
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
 */
import java.util.Scanner;

public class MovieDriver_Task2 {
    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);

    String continueInput;  // variable to store user response

    do {
        // Create a new movie object
        Movie movie = new Movie();

        // Prompt the user to enter the title of a movie
        System.out.println("Enter the name of a movie");
        String title = keyboard.nextLine();
        movie.setTitle(title);

        // Prompt the user to enter the movie’s rating
        System.out.println("Enter the rating of the movie");
        String rating = keyboard.nextLine();
        movie.setRating(rating);

        // Prompt the user to enter the number of tickets sold
        System.out.println("Enter the number of tickets sold for this movie");
        int ticketsSold = keyboard.nextInt();
        movie.setSoldTickets(ticketsSold);

        // Print out the information using the movie’s toString method
        System.out.println(movie.toString());

        // Clear newline left in the buffer
        keyboard.nextLine();

        // Ask user if they want to continue
        System.out.println("Do you want to enter another? (y or n)");
        continueInput = keyboard.nextLine();

    } while (continueInput.equalsIgnoreCase("y"));

    // Print goodbye message
    System.out.println("Goodbye");

    // Close the scanner
    keyboard.close();
    }
}
