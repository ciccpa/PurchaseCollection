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
 * This class contains Purchase member variables and methods.
 *
 * @author Peter Ciccone
 * @version 4.12 @ since 10/5/19
 */
public class Purchase {

	private Product m_Product = new Product(); // Member variables declared.
	private int m_Quantity;

	/**
	 * Default constructor. Sets member variables to default values.
	 * 
	 * @param
	 */
	public Purchase() {
		m_Product.setDescription("NO_DESCRIPTION");
		m_Product.setPrice(0.0);
		m_Quantity = 0;
	}

	/**
	 * Sets product to a value that is used to keep track of it.
	 * 
	 * @param Product p - Stores member variable.
	 */
	public void setProduct(Product p) {
		m_Product = p;
	}

	/**
	 * Sets quantity to a value that is used to keep track of it.
	 * 
	 * @param int q - Stores member variable.
	 */
	public void setQuantity(int q) {
		m_Quantity = q;
	}

	/** Returns product value from set method. @param */
	public Product getProduct() {
		return m_Product;
	}

	/** Returns quantity value from set method. @param */
	public int getQuantity() {
		return m_Quantity;
	}

	/**
	 * Writes values from Read method to PrintStream.
	 * 
	 * @param PrintStream ps - Opened in ConsoleUI.
	 */
	public void Write(PrintStream ps) {
		Product p = new Product();
		p = getProduct();

		ps.printf(p.getDescription()); // Prints using get methods.
		ps.println();
		ps.print(p.getPrice());
		ps.println();
		ps.print(getQuantity());
	}

	/**
	 * Assigns values read from the input file.
	 * 
	 * @param Scanner s - Opened in ConsoleUI.
	 */
	public void Read(Scanner s) {
		int quantity;
		Product p = new Product();
		String description;
		double price;

		description = s.nextLine(); // Assigns data and stores in set methods.
		p.setDescription(description);
		price = s.nextDouble();
		p.setPrice(price);
		quantity = s.nextInt();
		setQuantity(quantity);

		setProduct(p);
	}

	/**
	 * Writes values from ReadJSON method to PrintStream.
	 * 
	 * @param PrintStream ps - Opened in ConsoleUI.
	 */
	public void WriteJSON(PrintStream ps) {
		Purchase pur = new Purchase();
		pur.setProduct(getProduct()); // Assigns using info from get/set
		pur.setQuantity(getQuantity()); // methods to put in current instance.

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		pur.setProduct(getProduct());
		pur.setQuantity(getQuantity());

		String jsonString = gson.toJson(pur);
		ps.print(jsonString); // Prints data in JSON format.
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

		Purchase pur = gson.fromJson(fr, Purchase.class);

		m_Product = pur.getProduct(); // Takes Purchase info from Gson Builder
		m_Quantity = pur.getQuantity(); // and stores it in member variables.
	}

	/**
	 * Overrides the toString method to show descriptive text.
	 * 
	 * @param
	 */
	@Override
	public String toString() {
		Product p = new Product();
		p = getProduct();
		return String.format("%d, %s, $%.2f", getQuantity(), p.getDescription(), p.getPrice());
	}
}
