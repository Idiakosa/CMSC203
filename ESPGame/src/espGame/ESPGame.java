/*
 * Class: 	CMSC203 CRN 23118
Program: Assignment #1
Instructor: Aygun Huseyin
Summary of Description: This game allows a user to try and guess a color (or number) that the computer selects at random three times, and then display how many they get correct. IT will give them the option of restarting the game as many times as they like, and they will be able to see all the information they input displayed at the end of the program.
Due Date: 09/8/2025
Platform/compiler: Eclipse JAVA
Integrity Pledge: I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student. 
Student’s name: Idia Ighile
 */

package espGame;

// imports
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.io.FileWriter;


public class ESPGame{
	public static void main(String[] args) {
		// CONSTANTS GO HERE
			// string literals
		final String WELCOME_MESSAGE = "Welcome to the ESP Game!";
		final String THINKING_MESSAGE = "I am thinking of a color. Enter your guess.";
		final String GAME_OVER_MESSAGE = "Game Over";
		final String FILE_NAME = "EspGameResults.txt";
		final String USERNAME_PROMPT = "Enter your name:";
		final String DESCRIPTION_PROMPT = "Enter a sentence that describes yourself:";
		final String DUE_DATE_PROMPT = "Enter the due date in MM/DD/YY format:";
		final String DATE_PROMPT = "Enter the date: ";
			// game constraints 
		final int MAX_COLORS = 16;
		final int MEDIUM_COLORS = 10;
		final int MIN_COLORS = 5;
		final int ROUNDS = 3;
		// end of constants
		
		Scanner sc = new Scanner(System.in); // setting up scanner
		//welcome statements and menu display
		System.out.println("Welcome to CMSC203 Assignment 1: Test your ESP skills!");
		System.out.println(WELCOME_MESSAGE + " - extrasensory perception!");
		// prompt user to enter their choice and start game
		boolean continueGame = true;
		while(continueGame) { //while loop for continue game being true
			System.out.println("\nWould you please choose one of the following 4 options from the menu:");
			System.out.println("\n1-read and display on the screen first 16 names of colors from a file colors.txt, so the player can select one of them names of colors.\r\n"
					+ "2-read and display on the screen first 10 names of colors from a file colors.txt, so the player can select one of them names of colors.\r\n"
					+ "3-read and display on the screen first 5 names of colors from a file colors.txt, so the player can select one of them names of colors.\r\n"
					+ "4-Exit from a program\n");
			System.out.println("Enter here: ");
			String choice = sc.nextLine();
			if(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
				switch (choice) {
				// starting cases
				case "1":
					System.out.println("Enter the filename: ");
					String filename = sc.nextLine();
					int correctGuesses = 0; // sets up correct guess counter
					Random rand = new Random(); //initializes random func
					
					// display all 16 colors 
					 try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
					        String line;
					        int count = 0;
					        System.out.println("Available colors:");
					        while ((line = reader.readLine()) != null && count < MAX_COLORS) {
					            System.out.println(line);
					            count++;
					        }
					    } catch (IOException e) {
					        System.out.println("Error reading file: " + e.getMessage());
					    }
					 
					 // start rounds
					try {
					    BufferedReader reader = new BufferedReader(new FileReader(filename));

					    for (int round = 1; round <= ROUNDS; round++) {
					        System.out.println("\nRound " + round);
					        System.out.println(THINKING_MESSAGE);

					        // Select a random color from the first 16 lines
					        String selectedColor = null;
					        String line;
					        int count = 0;

					        while ((line = reader.readLine()) != null && count < MAX_COLORS) {
					            count++;
					            if (rand.nextInt(count) == 0) {
					                selectedColor = line;
					            }
					        }

					        // Reset reader for next round
					        reader.close();
					        reader = new BufferedReader(new FileReader(filename));

					        // Get user's guess
					        System.out.print("Your guess: ");
					        String userGuess = sc.nextLine();

					        if (userGuess.equalsIgnoreCase(selectedColor)) {
					            System.out.println("Correct!");
					            correctGuesses++;
					        } else if(!userGuess.equalsIgnoreCase("black") &&
					        !userGuess.equalsIgnoreCase("white") &&
					        !userGuess.equalsIgnoreCase("gray") &&
					        !userGuess.equalsIgnoreCase("silver") &&
					        !userGuess.equalsIgnoreCase("maroon") &&
					        !userGuess.equalsIgnoreCase("red") &&
					        !userGuess.equalsIgnoreCase("purple") &&
					        !userGuess.equalsIgnoreCase("fuchsia") &&
					        !userGuess.equalsIgnoreCase("green") &&
					        !userGuess.equalsIgnoreCase("lime") &&
					        !userGuess.equalsIgnoreCase("olive") &&
					        !userGuess.equalsIgnoreCase("yellow") &&
					        !userGuess.equalsIgnoreCase("navy") &&
					        !userGuess.equalsIgnoreCase("blue") &&
					        !userGuess.equalsIgnoreCase("teal") &&
					        !userGuess.equalsIgnoreCase("aqua") ) {
					        System.out.println("Invalid color. Please choose one from the list above.");
					        round--; // repeat the round
				        } else {
				            System.out.println("Wrong! I was thinking of: " + selectedColor);
					        }
					    }

					    reader.close();
					} catch (IOException e) {
					    System.out.println("Error reading file: " + e.getMessage());
					    continue; // displays error message and sends user back to menu loop
					}

					System.out.println(GAME_OVER_MESSAGE);
					System.out.println("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.");
					
					try { // writing data to file
					    FileWriter writer = new FileWriter(FILE_NAME);
					    writer.write(GAME_OVER_MESSAGE + "\n");
					    writer.write("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.\n");
					    writer.close();
					} catch (IOException ignored) { 
						// ignores errors and doesn't notify user to keep going with game
					}
					// asking user to continue game
					while (true) {
					    System.out.println("Do you want to continue the game? (Y/N): ");
					    String option = sc.nextLine().trim().toUpperCase();

					    if (option.equals("Y")) {
					        continueGame = true;
					        break;
					    } else if (option.equals("N")) {
					        continueGame = false;
					        break;
					    } else {
					        System.out.println("Invalid input. Please enter Y or N.");
					    }
					}
					
					break;
				case "2":
					System.out.println("Enter the filename: ");
					filename = sc.nextLine();
					correctGuesses = 0; // sets up correct guess counter
					rand = new Random(); //initializes random func
					
					// display all 10 colors
					 try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
					        String line;
					        int count = 0;
					        System.out.println("Available colors:");
					        while ((line = reader.readLine()) != null && count < MEDIUM_COLORS) {
					            System.out.println(line);
					            count++;
					        }
					    } catch (IOException e) {
					        System.out.println("Error reading file: " + e.getMessage());
					    }
					 
					 // start rounds
					try {
					    BufferedReader reader = new BufferedReader(new FileReader(filename));

					    for (int round = 1; round <= ROUNDS; round++) {
					        System.out.println("\nRound " + round);
					        System.out.println(THINKING_MESSAGE);

					        // Select a random color from the first 16 lines
					        String selectedColor = null;
					        String line;
					        int count = 0;

					        while ((line = reader.readLine()) != null && count < MEDIUM_COLORS) {
					            count++;
					            if (rand.nextInt(count) == 0) {
					                selectedColor = line;
					            }
					        }

					        // Reset reader for next round
					        reader.close();
					        reader = new BufferedReader(new FileReader(filename));

					        // Get user's guess
					        System.out.print("Your guess: ");
					        String userGuess = sc.nextLine();

					        if (userGuess.equalsIgnoreCase(selectedColor)) {
					            System.out.println("Correct!");
					            correctGuesses++;
					        } else if(!userGuess.equalsIgnoreCase("black") &&
							        !userGuess.equalsIgnoreCase("white") &&
							        !userGuess.equalsIgnoreCase("gray") &&
							        !userGuess.equalsIgnoreCase("silver") &&
							        !userGuess.equalsIgnoreCase("maroon") &&
							        !userGuess.equalsIgnoreCase("red") &&
							        !userGuess.equalsIgnoreCase("purple") &&
							        !userGuess.equalsIgnoreCase("fuchsia") &&
							        !userGuess.equalsIgnoreCase("green") &&
							        !userGuess.equalsIgnoreCase("lime") ) {
							        System.out.println("Invalid color. Please choose one from the list above.");
							        round--; // repeat the round
						        } else {
						            System.out.println("Wrong! I was thinking of: " + selectedColor);
							        }
							    }

					    reader.close();
					} catch (IOException e) {
					    System.out.println("Error reading file: " + e.getMessage());
					    continue; // displays error message and sends user back to menu loop
					}

					System.out.println(GAME_OVER_MESSAGE);
					System.out.println("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.");
					
					try { // writing data to file
					    FileWriter writer = new FileWriter(FILE_NAME);
					    writer.write(GAME_OVER_MESSAGE + "\n");
					    writer.write("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.\n");
					    writer.close();
					} catch (IOException ignored) { 
						// ignores errors and doesn't notify user to keep going with game
					}

					// asking user to continue game
					while (true) {
					    System.out.println("Do you want to continue the game? (Y/N): ");
					    String option = sc.nextLine().trim().toUpperCase();

					    if (option.equals("Y")) {
					        continueGame = true;
					        break;
					    } else if (option.equals("N")) {
					        continueGame = false;
					        break;
					    } else {
					        System.out.println("Invalid input. Please enter Y or N.");
					    }
					}
					
					break;
				case "3":
					System.out.println("Enter the filename: ");
					filename = sc.nextLine();
					correctGuesses = 0; // sets up correct guess counter
					rand = new Random(); //initializes random func
					
					// display all colors
					 try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
					        String line;
					        int count = 0;
					        System.out.println("Available colors:");
					        while ((line = reader.readLine()) != null && count < MIN_COLORS) {
					            System.out.println(line);
					            count++;
					        }
					    } catch (IOException e) {
					        System.out.println("Error reading file: " + e.getMessage());
					    }
					 
					 //start rounds
					try {
					    BufferedReader reader = new BufferedReader(new FileReader(filename));

					    for (int round = 1; round <= ROUNDS; round++) {
					        System.out.println("\nRound " + round);
					        System.out.println(THINKING_MESSAGE);

					        // Select a random color from the first 16 lines
					        String selectedColor = null;
					        String line;
					        int count = 0;

					        while ((line = reader.readLine()) != null && count < MIN_COLORS) {
					            count++;
					            if (rand.nextInt(count) == 0) {
					                selectedColor = line;
					            }
					        }

					        // Reset reader for next round
					        reader.close();
					        reader = new BufferedReader(new FileReader(filename));

					        // Get user's guess
					        System.out.print("Your guess: ");
					        String userGuess = sc.nextLine();

					        if (userGuess.equalsIgnoreCase(selectedColor)) {
					            System.out.println("Correct!");
					            correctGuesses++;
					        } else if(!userGuess.equalsIgnoreCase("black") &&
							        !userGuess.equalsIgnoreCase("white") &&
							        !userGuess.equalsIgnoreCase("gray") &&
							        !userGuess.equalsIgnoreCase("silver") &&
							        !userGuess.equalsIgnoreCase("maroon") ) {
							        System.out.println("Invalid color. Please choose one from the list above.");
							        round--; // repeat the round
						        } else {
						            System.out.println("Wrong! I was thinking of: " + selectedColor);
							        }
							    }

					    reader.close();
					} catch (IOException e) {
					    System.out.println("Error reading file: " + e.getMessage());
					    continue; // displays error message and sends user back to menu loop
					}

					System.out.println(GAME_OVER_MESSAGE);
					System.out.println("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.");
					
					try { // writing data to file
					    FileWriter writer = new FileWriter(FILE_NAME);
					    writer.write(GAME_OVER_MESSAGE + "\n");
					    writer.write("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.\n");
					    writer.close();
					} catch (IOException ignored) { 
						// ignores errors and doesn't notify user to keep going with game
					}

					// asking user to continue game
					while (true) {
					    System.out.println("Do you want to continue the game? (Y/N): ");
					    String option = sc.nextLine().trim().toUpperCase();

					    if (option.equals("Y")) {
					        continueGame = true;
					        break;
					    } else if (option.equals("N")) {
					        continueGame = false;
					        break;
					    } else {
					        System.out.println("Invalid input. Please enter Y or N.");
					    }
					}
					
					break;
				case "4":
					continueGame = false;
					continue;
				}
					
			} else {
				System.out.println("Please enter a valid choice (1-4)");
				choice = sc.nextLine(); //just in case user doesnt enter option 1-4
			}
		}
		// after game is exited procedure
			//collecting data
		System.out.println(USERNAME_PROMPT);
		String name = sc.nextLine();
		System.out.println(DATE_PROMPT);
		String date = sc.nextLine();
		System.out.println(DESCRIPTION_PROMPT);
		String description = sc.nextLine();
		System.out.println(DUE_DATE_PROMPT);
		String due_date = sc.nextLine();
			// displaying the data
		System.out.println("\nDue Date: " + due_date + "\nUsername: " + name + "\nUser Description: " + description + "\nDate: " + date);
			// writing to output file
		try { // writing data to file
			FileWriter writer = new FileWriter(FILE_NAME, true);
		    writer.write(due_date + "\n" + name + "\n" + description + "\n" + date + "\n");
		    writer.close();
		} catch (IOException ignored) { 
			// ignores errors and doesn't notify user to keep going with game
		}
		System.out.println("\nProgrammer name: Idia Ighile");
		sc.close(); // closing scanner at the end
	}
}