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

public class Patient {
    private String firstName;
    private String middleName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String emergencyName;
    private String emergencyPhone;

    public Patient() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phoneNumber = "";
        this.emergencyName = "";
        this.emergencyPhone = "";
    }

    public Patient(String firstName, String middleName, String lastName) {
        this();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Patient(String firstName, String middleName, String lastName,
                   String streetAddress, String city, String state, String zip,
                   String phoneNumber, String emergencyName, String emergencyPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emergencyName = emergencyName;
        this.emergencyPhone = emergencyPhone;
    }

    // Accessors and Mutators
    public String getFirstName() { 
    	return firstName; 
    	}
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; 
    	}
    public String getMiddleName() { 
    	return middleName; 
    	}
    public void setMiddleName(String middleName) { 
    	this.middleName = middleName; 
    	}
    public String getLastName() { 
    	return lastName; 
    	}
    public void setLastName(String lastName) { 
    	this.lastName = lastName; 
    	}
    public String getStreetAddress() { 
    	return streetAddress; 
    	}
    public void setStreetAddress(String streetAddress) { 
    	this.streetAddress = streetAddress; 
    	}
    public String getCity() { 
    	return city; 
    	}
    public void setCity(String city) { 
    	this.city = city; 
    	}
    public String getState() { 
    	return state; 
    	}
    public void setState(String state) { 
    	this.state = state; 
    	}
    public String getZip() { 
    	return zip; 
    	}
    public void setZip(String zip) { 
    	this.zip = zip; 
    	}
    public String getPhoneNumber() { 
    	return phoneNumber; 
    	}
    public void setPhoneNumber(String phoneNumber) { 
    	this.phoneNumber = phoneNumber; 
    	}
    public String getEmergencyName() { 
    	return emergencyName; 
    	}
    public void setEmergencyName(String emergencyName) { 
    	this.emergencyName = emergencyName; 
    	}
    public String getEmergencyPhone() { 
    	return emergencyPhone; 
    	}
    public void setEmergencyPhone(String emergencyPhone) { 
    	this.emergencyPhone = emergencyPhone; 
    	}

    public String buildFullName() { 
    	return firstName + " " + middleName + " " + lastName; 
    	}
    public String buildAddress() { 
    	return streetAddress + ", " + city + ", " + state + " " + zip; 
    	}
    public String buildEmergencyContact() { 
    	return emergencyName + " (" + emergencyPhone + ")"; 
    	}
    
    public String toString() {
        return " Name: " + buildFullName() + "\n" +
               " Address: " + buildAddress() + "\n" +
               " Phone Number: " + phoneNumber + "\n" +
               " Emergency Contact: " + buildEmergencyContact();
    }
}
