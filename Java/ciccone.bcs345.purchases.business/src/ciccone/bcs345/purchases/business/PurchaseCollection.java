/** 
 * Contains a class to perform PurchaseCollection operations.
 */
package ciccone.bcs345.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class contains PurchaseCollection member variables and methods.
 *
 * @author Peter Ciccone
 * @version 4.12 @ since 10/19/19
 */
public class PurchaseCollection {

	private Customer m_Customer = new Customer();
	Purchase[] m_Purchase = new Purchase[4];

	/**
	 * Default constructor. Sets member variables to default values.
	 * 
	 * @param
	 */
	public PurchaseCollection() {
		m_Customer.setFirstName("NO_FIRSTNAME");
		m_Customer.setLastName("NO_LASTNAME");
		Address a = new Address();
		a.setNumber("NO_NUMBER");
		a.setStreet("NO_STREET");
		a.setCity("NO_CITY");
		a.setState("NO_STATE");
		a.setZip("NO_ZIP");
		m_Customer.setAddress(a);

		m_Purchase[0] = new Purchase(); // New called for each element of the array.
		m_Purchase[1] = new Purchase();
		m_Purchase[2] = new Purchase();
		m_Purchase[3] = new Purchase();
		Product p = new Product();

		for (int i = 0; i < 4; i++) {
			p.setDescription("NO_DESCRIPTION");
			p.setPrice(0.0);
			m_Purchase[i].setProduct(p);
			m_Purchase[i].setQuantity(0);
		}
	}

	/**
	 * Sets customer to a value that is used to keep track of it.
	 * 
	 * @param Customer c - Stores member variable.
	 */
	public void setCustomer(Customer c) {
		m_Customer = c;
	}

	/** Returns Customer value from set method. @param */
	public Customer getCustomer() {
		return m_Customer;
	}

	/**
	 * Sets purchase array to a value that is used to keep track of it.
	 * 
	 * @param Purchase[] p - Stores member variable for purchase array.
	 */
	public void setPurchase(Purchase[] p) {
		m_Purchase = p;
	}

	/** Returns Purchase[] member variable from array set method. @param */
	public Purchase[] getPurchase() {
		return m_Purchase;
	}

	public Purchase GetMaxPurchase() {

		double maxPurchase = m_Purchase[0].getQuantity() * m_Purchase[0].getProduct().getPrice();
		int maxPurchaseElement = 0;

		for (int i = 1; i < m_Purchase.length; i++) {
			double currentPurchase = m_Purchase[i].getQuantity() * m_Purchase[i].getProduct().getPrice();
			if (currentPurchase > maxPurchase) {
				maxPurchaseElement++;
			}
		}
		return m_Purchase[maxPurchaseElement];
	}

	public Purchase GetByIndex(int index) {
		if (index > m_Purchase.length || index < 0) {
			throw new ArrayIndexOutOfBoundsException("Array index is out of bounds.");
		}
		return m_Purchase[index];
	}

	/**
	 * Assigns values read from the input file.
	 * 
	 * @param Scanner s - Opened in PurchaseCollectionConsoleUI.
	 */
	public void Read(Scanner s) {
		Customer c = new Customer();
		String firstName, lastName, houseNum, street, city, state, zip;
		Address a = new Address();

		firstName = s.nextLine(); // Assigns data and stores in set methods.
		c.setFirstName(firstName);
		lastName = s.nextLine();
		c.setLastName(lastName);

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

		c.setAddress(a);
		setCustomer(c);
		int purchaseCount;
		purchaseCount = s.nextInt();

		int quantity;
		String description = null;
		double price;
		Product[] p = new Product[purchaseCount];

		for (int i = 0; i < p.length; i++) {
			p[i] = new Product(); // New called for every element of Product instance.
		}

		for (int i = 0; i < m_Purchase.length; i++) { // For loop used to store values in proper sequence.
			s.nextLine();
			description = s.nextLine();
			p[i].setDescription(description);
			price = s.nextDouble();
			p[i].setPrice(price);
			m_Purchase[i].setProduct(p[i]);
			quantity = s.nextInt();
			m_Purchase[i].setQuantity(quantity);
		}
	}

	/**
	 * Writes values from Read method to PrintStream.
	 * 
	 * @param PrintStream ps - Opened in PurchaseCollectionConsoleUI.
	 */
	public void Write(PrintStream ps) {

		ps.printf(m_Customer.getFirstName());
		ps.println();
		ps.printf(m_Customer.getLastName());
		ps.println();
		ps.print(m_Customer.getAddress().getNumber()); // Calling getAddress() on m_Customer allows use of the accessor
														// methods within the address class,
		ps.println(); // and so on.
		ps.print(m_Customer.getAddress().getStreet());
		ps.println();
		ps.print(m_Customer.getAddress().getCity());
		ps.println();
		ps.print(m_Customer.getAddress().getState());
		ps.println();
		ps.print(m_Customer.getAddress().getZip());
		ps.println();
		ps.print(m_Purchase.length);
		ps.println();

		for (int i = 0; i < m_Purchase.length; i++) {
			ps.printf(m_Purchase[i].getProduct().getDescription());
			ps.println();
			ps.print(m_Purchase[i].getProduct().getPrice());
			ps.println();
			ps.print(m_Purchase[i].getQuantity());
			ps.println();
		}
	}

	/**
	 * Generates a report/makes calculations based on file data.
	 * 
	 * @param Scanner s - Opened in PurchaseCollectionConsoleUI.
	 */
	public void Report(PrintStream ps) {
		ps.printf("Purchase Report");
		ps.println();
		ps.printf("---------------");
		ps.println();
		ps.printf("%s %s", m_Customer.getFirstName(), m_Customer.getLastName());
		ps.println();
		ps.printf("%s %s", m_Customer.getAddress().getNumber(), m_Customer.getAddress().getStreet());
		ps.println();
		ps.printf("%s, %s %s", m_Customer.getAddress().getCity(), m_Customer.getAddress().getState(),
				m_Customer.getAddress().getZip());
		ps.println();
		ps.println();

		ps.printf("%-30s %10s %20s %10s\n", "Description", "Price", "Quantity", "Cost");
		ps.printf("%-30s %10s %20s %10s\n", "-----------", "-----", "--------", "----");

		double cost = 0, totalQuantity = 0, totalCost = 0;
		for (int i = 0; i < m_Purchase.length; i++) {
			int quantity = m_Purchase[i].getQuantity();
			double price = m_Purchase[i].getProduct().getPrice();
			String description = m_Purchase[i].getProduct().getDescription();

			cost = price * quantity;
			totalQuantity = totalQuantity + quantity;
			totalCost = totalCost + cost;
			// ps.printf("%-30s %-10.2f %8.0f %20.2f\n", description, price, quantity,
			// cost);
			System.out.printf("%-30s %10.2f %20d %10.2f\n", description, price, quantity, cost);
		}
		ps.printf("%-30s %10s %20s %10s\n", "-----------", "-----", "--------", "----");
		ps.printf("%-30s %31.0f %10.2f\n", "Total", totalQuantity, totalCost);
		ps.println();
	}

	/**
	 * Assigns values read from the input file.
	 * 
	 * @param FileReader fr - Opened in PurchaseCollectionConsoleUI.
	 */
	public void ReadJSON(FileReader fr) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		PurchaseCollection pc = gson.fromJson(fr, PurchaseCollection.class);

		m_Customer = pc.getCustomer();
		m_Purchase = pc.getPurchase();
	}

	/**
	 * Writes values from ReadJSON method to PrintStream.
	 * 
	 * @param PrintStream ps - Opened in PurchaseCollectionConsoleUI.
	 */
	public void WriteJSON(PrintStream ps) {
		PurchaseCollection pc = new PurchaseCollection();
		pc.setCustomer(getCustomer());
		pc.setPurchase(getPurchase());

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		String jsonString = gson.toJson(pc);
		ps.print(jsonString);
	}

	/**
	 * Overrides the toString method to show descriptive text.
	 * 
	 * @param
	 */
	@Override
	public String toString() {
		String toString = "";
		for (int i = 0; i < m_Purchase.length; i++) {
			toString = toString + m_Purchase[i].toString() + "\n";
		}
		return m_Customer.toString() + "\n" + toString;
	}
}
