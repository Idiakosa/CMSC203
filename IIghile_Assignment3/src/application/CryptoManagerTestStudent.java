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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CryptoManagerTestStudent {
	@Test // caesar cipher tests
	public void testCaesarEncryptionDecryption() {
	    // Normal case
	    String plain = "HELLO";
	    int key = 3;
	    String encrypted = CryptoManager.caesarEncryption(plain, key);
	    assertEquals("KHOOR", encrypted);
	    String decrypted = CryptoManager.caesarDecryption(encrypted, key);
	    assertEquals(plain, decrypted);

	    // Negative/large key
	    plain = "WORLD";
	    key = 70; // normalized key
	    encrypted = CryptoManager.caesarEncryption(plain, key);
	    decrypted = CryptoManager.caesarDecryption(encrypted, key);
	    assertEquals(plain, decrypted);
	    
	    // Out-of-bounds string
	    plain = "hello!"; // lowercase & '!'
	    encrypted = CryptoManager.caesarEncryption(plain, 4);
	    assertEquals("The selected string is not in bounds, Try again.", encrypted);
	}
	@Test // vigenere cipher tests
	public void testVigenereEncryptionDecryption() {
	    String plain = "HELLO";
	    String key = "KEY";
	    String encrypted = CryptoManager.vigenereEncryption(plain, key);
	    String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
	    assertEquals(plain, decrypted);

	    plain = "CS203";
	    key = "KEY";
	    encrypted = CryptoManager.vigenereEncryption(plain, key);
	    decrypted = CryptoManager.vigenereDecryption(encrypted, key);
	    assertEquals(plain, decrypted);

	    // Out-of-bounds string
	    plain = "hello!";
	    encrypted = CryptoManager.vigenereEncryption(plain, "KEY");
	    assertEquals("The selected string is not in bounds, Try again.", encrypted);
	}
	@Test // playfair cipher tests
	public void testPlayfairEncryptionDecryption() {
	    String plain = "HELLO";
	    String key = "KEY";
	    String encrypted = CryptoManager.playfairEncryption(plain, key);
	    String decrypted = CryptoManager.playfairDecryption(encrypted, key);
	    assertEquals(plain, decrypted);

	    plain = "CS203";
	    key = "KEY";
	    encrypted = CryptoManager.playfairEncryption(plain, key);
	    decrypted = CryptoManager.playfairDecryption(encrypted, key);
	    assertEquals(plain, decrypted);

	    // Out-of-bounds string
	    plain = "hello!";
	    encrypted = CryptoManager.playfairEncryption(plain, "KEY");
	    assertEquals("The selected string is not in bounds, Try again.", encrypted);
	    
	}

}

