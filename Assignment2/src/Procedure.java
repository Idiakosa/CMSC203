/*
 * Class: CMSC203 CRN 23118
 * Program: Assignment #2
 * Instructor: Huseyin Aygun
 * Summary of Description: This class represents a medical Procedure performed on a patient.
 * Due Date: 09/29/2025
 * Integrity Pledge: I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * Programmer: Idia Ighile
 */

public class Procedure {
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double charges;

    public Procedure() {
        this.procedureName = "";
        this.procedureDate = "";
        this.practitionerName = "";
        this.charges = 0.0;
    }

    public Procedure(String procedureName, String procedureDate) {
        this();
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    public Procedure(String procedureName, String procedureDate,
                     String practitionerName, double charges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    public String getProcedureName() { 
    	return procedureName; 
    	}
    public void setProcedureName(String procedureName) { 
    	this.procedureName = procedureName; 
    	}
    public String getProcedureDate() { 
    	return procedureDate; 
    	}
    public void setProcedureDate(String procedureDate) { 
    	this.procedureDate = procedureDate; 
    	}
    public String getPractitionerName() { 
    	return practitionerName; 
    	}
    public void setPractitionerName(String practitionerName) { 
    	this.practitionerName = practitionerName; 
    	}
    public double getCharges() { 
    	return charges; 
    	}
    public void setCharges(double charges) { 
    	this.charges = charges; 
    	}
    public String toString() {
        return "\n	Procedure: " + procedureName + "\t" + "\n	Procedure Date: " + procedureDate + "\t" + "\n	Practitioner Name: " + practitionerName + "\n	Charge = " + String.format("%,.2f", charges) + "\n";
    }
}
