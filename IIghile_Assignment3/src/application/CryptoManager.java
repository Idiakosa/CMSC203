/* Class: CMSC203 CRN 23118
Program: Assignment 3 
Instructor: Huseyin Aygun
Description: This project is a Java program that demonstrates three classical ciphers: Caesar, Vigenere, and Playfair. It uses a CryptoManager class to handle encryption and decryption methods, which are connected to a provided GUI for user interaction. The program also includes JUnit tests to check that each cipher works correctly.
Due Date: 10/06/2025
Platform/Compiler: Eclipse
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Student Name: Idiakosa Ighile
*/
package application;

/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = " ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

    
	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
    	if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        StringBuilder encrypted = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder();

        // repeat the key until it matches the plaintext length
        while (extendedKey.length() < plainText.length()) {
            extendedKey.append(key);
        }
        key = extendedKey.substring(0, plainText.length());

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            char k = key.charAt(i);

            int shift = k - LOWER_RANGE;
            int encryptedChar = ch + shift;

            // wrap around if past upper bound
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }

            encrypted.append((char) encryptedChar);
        }

        return encrypted.toString();
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
    	 if (!isStringInBounds(encryptedText)) {
    	        return "The selected string is not in bounds, Try again.";
    	    }

    	    StringBuilder decrypted = new StringBuilder();
    	    StringBuilder extendedKey = new StringBuilder();

    	    // repeat key until it matches encrypted text length
    	    while (extendedKey.length() < encryptedText.length()) {
    	        extendedKey.append(key);
    	    }
    	    key = extendedKey.substring(0, encryptedText.length());

    	    for (int i = 0; i < encryptedText.length(); i++) {
    	        char ch = encryptedText.charAt(i);
    	        char k = key.charAt(i);

    	        int shift = k - LOWER_RANGE;
    	        int decryptedChar = ch - shift;

    	        // wrap around if below lower bound
    	        while (decryptedChar < LOWER_RANGE) {
    	            decryptedChar += RANGE;
    	        }

    	        decrypted.append((char) decryptedChar);
    	    }

    	    return decrypted.toString();
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    
 // helper method to build 8x8 matrix!!
    private static char[][] buildPlayfairMatrix(String key) {
        StringBuilder keyBuilder = new StringBuilder();
        // add key characters first, only unique ones
        for (char c : key.toCharArray()) {
            if (keyBuilder.indexOf(String.valueOf(c)) == -1 && ALPHABET64.indexOf(c) != -1) {
                keyBuilder.append(c);
            }
        }
        // add remaining characters from ALPHABET64
        for (char c : ALPHABET64.toCharArray()) {
            if (keyBuilder.indexOf(String.valueOf(c)) == -1) {
                keyBuilder.append(c);
            }
        }

        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = keyBuilder.charAt(i * 8 + j);
            }
        }
        return matrix;
    }

    // helper method to find row and column of a character
    private static int[] findPosition(char[][] matrix, char c) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] == c) return new int[]{i, j};
            }
        }
        return null; // should never happen if input is valid
    } // end of helper method
    
    public static String playfairEncryption(String plainText, String key) {
    	if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        char[][] matrix = buildPlayfairMatrix(key);
        StringBuilder text = new StringBuilder(plainText);

        // split into digraphs, add X if pair letters are same or final single letter
        for (int i = 0; i < text.length() - 1; i += 2) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                text.insert(i + 1, 'X');
            }
        }
        if (text.length() % 2 != 0) text.append('X');

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            int[] posA = findPosition(matrix, a);
            int[] posB = findPosition(matrix, b);

            if (posA[0] == posB[0]) { // same row
                encrypted.append(matrix[posA[0]][(posA[1] + 1) % 8]);
                encrypted.append(matrix[posB[0]][(posB[1] + 1) % 8]);
            } else if (posA[1] == posB[1]) { // same column
                encrypted.append(matrix[(posA[0] + 1) % 8][posA[1]]);
                encrypted.append(matrix[(posB[0] + 1) % 8][posB[1]]);
            } else { // rectangle
                encrypted.append(matrix[posA[0]][posB[1]]);
                encrypted.append(matrix[posB[0]][posA[1]]);
            }
        }

        return encrypted.toString();
    }

    // Playfair Decryption
    public static String playfairDecryption(String encryptedText, String key) {
        if (!isStringInBounds(encryptedText)) {
            return "The selected string is not in bounds, Try again.";
        }

        char[][] matrix = buildPlayfairMatrix(key);
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i += 2) {
            char a = encryptedText.charAt(i);
            char b = encryptedText.charAt(i + 1);
            int[] posA = findPosition(matrix, a);
            int[] posB = findPosition(matrix, b);

            if (posA[0] == posB[0]) { // same row
                decrypted.append(matrix[posA[0]][(posA[1] + 7) % 8]); // move left
                decrypted.append(matrix[posB[0]][(posB[1] + 7) % 8]);
            } else if (posA[1] == posB[1]) { // same column
                decrypted.append(matrix[(posA[0] + 7) % 8][posA[1]]); // move up
                decrypted.append(matrix[(posB[0] + 7) % 8][posB[1]]);
            } else { // rectangle
                decrypted.append(matrix[posA[0]][posB[1]]);
                decrypted.append(matrix[posB[0]][posA[1]]);
            }
        }

        // remove filler x if inserted between repeated letters
        for (int i = 1; i < decrypted.length() - 1; i++) {
            if (decrypted.charAt(i) == 'X' &&
                decrypted.charAt(i-1) == decrypted.charAt(i+1)) {
                decrypted.deleteCharAt(i);
                i--; // adjust index
            }
        }
        // remove trailing X if added as filler
        if (decrypted.charAt(decrypted.length() - 1) == 'X') {
            decrypted.deleteCharAt(decrypted.length() - 1);
        }

        return decrypted.toString();
    }


    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
    	 if (!isStringInBounds(plainText)) {
    	        return "The selected string is not in bounds, Try again.";
    	    }

    	    StringBuilder encrypted = new StringBuilder();
    	    key = key % RANGE; // normalize key in case it’s larger than the range

    	    for (int i = 0; i < plainText.length(); i++) {
    	        char ch = plainText.charAt(i);
    	        int shifted = ch + key;

    	        // wrap around if past upper bound
    	        while (shifted > UPPER_RANGE) {
    	            shifted -= RANGE;
    	        }

    	        encrypted.append((char) shifted);
    	    }

    	    return encrypted.toString();
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
    	if (!isStringInBounds(encryptedText)) {
            return "The selected string is not in bounds, Try again.";
        }

        StringBuilder decrypted = new StringBuilder();
        key = key % RANGE;

        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            int shifted = ch - key;

            // wrap around if below lower bound
            while (shifted < LOWER_RANGE) {
                shifted += RANGE;
            }

            decrypted.append((char) shifted);
        }

        return decrypted.toString();
    }    

}
