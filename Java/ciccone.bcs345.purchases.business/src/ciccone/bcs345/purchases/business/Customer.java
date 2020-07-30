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
 * This class contains Customer member variables and methods.
 *
 * @author Peter Ciccone
 * @version 4.12 @ since 10/5/19
 */
public class Customer {

	private String m_FirstName; // Member variables declared.
	private String m_LastName;
	private Address m_Address = new Address();

	/**
	 * Default constructor. Sets member variables to default values.
	 * 
	 * @param
	 */
	public Customer() {
		m_FirstName = "NO_FIRSTNAME";
		m_LastName = "NO_LASTNAME";
		m_Address.setNumber("NO_NUMBER");
		m_Address.setStreet("NO_STREET");
		m_Address.setCity("NO_CITY");
		m_Address.setState("NO_STATE");
		m_Address.setZip("NO_ZIP");
	}

	/**
	 * Sets first name to a value that is used to keep track of it.
	 * 
	 * @param String fn - Stores member variable.
	 */
	public void setFirstName(String fn) {
		m_FirstName = fn;
	}

	/**
	 * Sets last name to a value that is used to keep track of it.
	 * 
	 * @param String ln - Stores member variable.
	 */
	public void setLastName(String ln) {
		m_LastName = ln;
	}

	/**
	 * Sets Address to a value that is used to keep track of it.
	 * 
	 * @param Address a - Stores member variable.
	 */
	public void setAddress(Address a) {
		m_Address = a;
	}

	/** Returns first name value from set method. @param */
	public String getFirstName() {
		return m_FirstName;
	}

	/** Returns last name value from set method. @param */
	public String getLastName() {
		return m_LastName;
	}

	/** Returns address value from set method. @param */
	public Address getAddress() {
		return m_Address;
	}

	/** Returns zip value from set method. @param */

	/**
	 * Writes values from Read method to PrintStream.
	 * 
	 * @param PrintStream ps - Opened in ConsoleUI.
	 */
	public void Write(PrintStream ps) {
		Address a = new Address();
		a = getAddress();

		ps.printf(getFirstName());
		ps.println();
		ps.printf(getLastName());
		ps.println();
		ps.printf(a.getNumber());
		ps.println();
		ps.printf(a.getStreet());
		ps.println();
		ps.printf(a.getCity());
		ps.println();
		ps.printf(a.getState());
		ps.println();
		ps.printf(a.getZip());
	}

	/**
	 * Assigns values read from the input file.
	 * 
	 * @param Scanner s - Opened in ConsoleUI.
	 */
	public void Read(Scanner s) {
		String firstName, lastName, houseNum, street, city, state, zip;
		Address a = new Address();

		firstName = s.nextLine(); // Assigns data and stores in set methods.
		setFirstName(firstName);
		lastName = s.nextLine();
		setLastName(lastName);

		houseNum = s.nextLine();
		a.setNumber(houseNum);
		street = s.nextLine();
		a.setStreet(street);
		city = s.nextLine();
		a.setCity(city);
		state = s.next();
		a.setState(state);
		zip = s.next();
		a.setZip(zip);

		setAddress(a);
	}

	/** Returns zip value from set method. @param */

	/**
	 * Writes values from Read method to PrintStream.
	 * 
	 * @param PrintStream ps - Opened in ConsoleUI.
	 */
	public void WriteJSON(PrintStream ps) {
		Customer c = new Customer();
		c.setFirstName(getFirstName());
		c.setLastName(getLastName());
		c.setAddress(getAddress());

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		String jsonString = gson.toJson(c);
		ps.print(jsonString);
	}

	/**
	 * Assigns values read from the input file.
	 * 
	 * @param FileReader fr - Opened in ConsoleUI.
	 */
	public void ReadJSON(FileReader fr) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		Customer c = gson.fromJson(fr, Customer.class);

		m_FirstName = c.getFirstName();
		m_LastName = c.getLastName();
		m_Address = c.getAddress();
	}

	@Override
	public String toString() {
		Address a = new Address();
		a = getAddress();
		return String.format(" %s %s %n %s %s %n %s, %s %s", getFirstName(), getLastName(), a.getNumber(),
				a.getStreet(), a.getCity(), a.getState(), a.getZip());
	}
}
