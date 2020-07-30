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
 * This class contains Product member variables and methods.
 *
 * @author Peter Ciccone
 * @version 4.12 @ since 10/5/19
 */
public class Product {

	private String m_Description;
	private double m_Price;

	public Product() {
		m_Description = "NO_DESCRIPTION";
		m_Price = 0.0;
	}

	/**
	 * Sets description to a value that is used to keep track of it.
	 * 
	 * @param String d - Stores member variable.
	 */
	public void setDescription(String d) {
		m_Description = d;
	}

	/**
	 * Sets Price to a value that is used to keep track of it.
	 * 
	 * @param Double p - Stores member variable.
	 */
	public void setPrice(double p) {
		m_Price = p;
	}

	public String getDescription() {
		return m_Description;
	}

	/** Returns description value from set method. @param */

	public double getPrice() {
		return m_Price;
	}

	/** Returns price value from set method. @param */

	/**
	 * Writes values from Read method to PrintStream.
	 * 
	 * @param PrintStream ps - Already opened in main.
	 */
	public void Write(PrintStream ps) {
		ps.print(getDescription());
		ps.println();
		ps.print(getPrice());
	}

	/**
	 * Assigns values read from the input file.
	 * 
	 * @param Scanner s - Already opened in main.
	 */
	public void Read(Scanner s) {
		String description;
		double price;

		description = s.nextLine();
		setDescription(description);
		price = s.nextDouble();
		setPrice(price);

	}

	/**
	 * Writes values from ReadJSON method to Printstream.
	 * 
	 * @param PrintStream ps - Already opened in main.
	 */
	public void WriteJSON(PrintStream ps) {
		Product p = new Product();

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		p.setDescription(getDescription());
		p.setPrice(getPrice());

		String jsonString = gson.toJson(p);
		ps.printf(jsonString);
	}

	/**
	 * Assigns values read from JSON input file.
	 * 
	 * @param FileReader fr - Already opened in main.
	 */
	public void ReadJSON(FileReader fr) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		Product p = gson.fromJson(fr, Product.class);

		m_Description = p.getDescription();
		m_Price = p.getPrice();
	}

	/**
	 * Overrides the toString method to show descriptive text.
	 * 
	 * @param
	 */
	@Override
	public String toString() {
		return String.format("%s, $%.2f", getDescription(), getPrice());
	}
}
