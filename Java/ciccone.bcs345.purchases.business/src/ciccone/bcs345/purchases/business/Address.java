/** 
 * Contains a class to perform file operations.
 */
package ciccone.bcs345.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class contains Address member variables and methods.
 *
 * @author Peter Ciccone
 * @version 4.12 @ since 10/5/19
 */

public class Address {

	private String m_Number, m_Street, m_City, m_State, m_Zip; // Member variables declared.

	/**
	 * Default constructor. Sets member variables to default values.
	 * 
	 * @param
	 */
	public Address() {
		m_Number = "NO_NUMBER";
		m_Street = "NO_STREET";
		m_City = "NO_CITY";
		m_State = "NO_STATE";
		m_Zip = "NO_ZIP";
	}

	/**
	 * Constructor. Sets member variables based on given parameters.
	 * 
	 * @param String - number = Street number. Street = street name. String - city =
	 *               City name. State = State name. Zip = Zip code.
	 */
	public void Address(String number, String street, String city, String state, String zip) {
		m_Number = number;
		m_Street = street;
		m_City = city;
		m_State = state;
		m_Zip = zip;
	}

	/**
	 * Sets name to a value that is used to keep track of it.
	 * 
	 * @param String n - Stores member variable.
	 */
	public void setNumber(String n) {
		m_Number = n;
	}

	/**
	 * Sets Street to a value that is used to keep track of it.
	 * 
	 * @param String s - Stores member variable.
	 */
	public void setStreet(String s) {
		m_Street = s;
	}

	/**
	 * Sets City to a value that is used to keep track of it.
	 * 
	 * @param String c - Stores member variable.
	 */
	public void setCity(String c) {
		m_City = c;
	}

	/**
	 * Sets State to a value that is used to keep track of it.
	 * 
	 * @param String s - Stores member variable.
	 */
	public void setState(String s) {
		m_State = s;
	}

	/**
	 * Sets Zip to a value that is used to keep track of it.
	 * 
	 * @param String z - Stores member variable.
	 */
	public void setZip(String z) {
		m_Zip = z;
	}

	public String getNumber() {
		return m_Number;
	}

	/** Returns number value from set method. @param */

	public String getStreet() {
		return m_Street;
	}

	/** Returns street value from set method. @param */

	public String getCity() {
		return m_City;
	}

	/** Returns city value from set method. @param */

	public String getState() {
		return m_State;
	}

	/** Returns state value from set method. @param */

	public String getZip() {
		return m_Zip;
	}

	/** Returns zip value from set method. @param */

	/**
	 * Writes values from Read method to PrintStream.
	 * 
	 * @param PrintStream ps - Opened in ConsoleUI.
	 */
	public void Write(PrintStream ps) {
		ps.printf(getNumber()); // Prints using get methods.
		ps.println();
		ps.printf(getStreet());
		ps.println();
		ps.printf(getCity());
		ps.println();
		ps.printf(getState());
		ps.println();
		ps.printf(getZip());
	}

	/**
	 * Assigns values read from the input file.
	 * 
	 * @param Scanner s - Opened in ConsoleUI.
	 */
	public void Read(Scanner s) {
		String houseNum, street, city, state, zip;

		houseNum = s.nextLine(); // Assigns data from each line
		setNumber(houseNum); // of the file and stores in set methods.
		street = s.nextLine();
		setStreet(street);
		city = s.nextLine();
		setCity(city);
		state = s.next();
		setState(state);
		zip = s.next();
		setZip(zip);
	}

	/**
	 * Writes values from ReadJSON method to Printstream.
	 * 
	 * @param PrintStream ps - Opened in ConsoleUI.
	 */
	public void WriteJSON(PrintStream ps) {
		Address a = new Address(); // Uses info in get/set methods
		a.setNumber(getNumber()); // from ReadJSON to assign to
		a.setStreet(getStreet()); // the current instance.
		a.setCity(getCity());
		a.setState(getState());
		a.setZip(getZip());

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		String jsonString = gson.toJson(a);
		ps.print(jsonString);
		System.out.println(jsonString); // Prints the data in JSON format.
	}

	/**
	 * Assigns values read from JSON input file.
	 * 
	 * @param FileReader fr - Opened in ConsoleUI.
	 */
	public void ReadJSON(FileReader fr) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		Address a = gson.fromJson(fr, Address.class);

		m_Number = a.getNumber(); // Takes address info from GSON
		m_Street = a.getStreet(); // builder and puts them into
		m_City = a.getCity(); // member variables.
		m_State = a.getState();
		m_Zip = a.getZip();
	}

	/**
	 * Overrides the toString method to show descriptive text.
	 * 
	 * @param
	 */
	@Override
	public String toString() {
		return String.format("%s %s, %s, %s %s", getNumber(), getStreet(), getCity(), getState(), getZip());
	}
}