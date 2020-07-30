/** 
 * Contains a class to display a user interface.
 */
package ciccone.bcs345.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import ciccone.bcs345.purchases.business.Customer;
import ciccone.bcs345.purchases.business.Purchase;

/**
 * This class contains the Customer Purchase UI menu for the program.
 *
 * @author Peter Ciccone
 * @version 4.12 @ since 10/5/19
 */
public class CustomerPurchaseConsoleUI {
	/**
	 * ShowUI method. Contains while loop with menu options inside of it.
	 * 
	 * @param
	 */
	public void ShowUI() {
		Customer c = new Customer(); // One instance of each class created.
		Purchase p = new Purchase();

		Scanner inputFileScanner = null; // Scanner, PrintStream and FileReader variables all
		PrintStream ps = null; // created beforehand.
		FileReader fr = null;

		int userChoice = 0;
		while (userChoice != 11) // Displays menu until the user enters 11.
		{
			System.out.println("Customer/Purchase UI");
			System.out.println("--------------------");
			System.out.println("1 - Read customer from file\n");
			System.out.println("2 - Read customer from file as JSON\n");
			System.out.println("3 - Write customer to file\n");
			System.out.println("4 - Write customer to file as JSON\n");
			System.out.println("5 - Show customer info on screen\n");
			System.out.println("6 - Read purchase from file\n");
			System.out.println("7 - Read purchase from file as JSON\n");
			System.out.println("8 - Write purchase to file\n");
			System.out.println("9 - Write purchase to file as JSON\n");
			System.out.println("10 - Show purchase info on screen\n");
			System.out.println("11 - Exit\n");
			System.out.println("Enter Choice:\n");
			Scanner menuChoice = new Scanner(System.in);
			userChoice = menuChoice.nextInt();

			if (userChoice == 1) // Opens keyboard Scanner based on user choice.
			{
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Customer Input Filename:");
				String filename = input.nextLine();
				try {
					inputFileScanner = new Scanner(new FileReader(filename)); // FileReader opens based on what the user
																				// types in.
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				c.Read(inputFileScanner); // Read method called.
			}

			if (userChoice == 2) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Customer JSON Input Filename:");
				String filename = input.nextLine();

				try {
					fr = new FileReader(filename);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				c.ReadJSON(fr); // Read JSON method called.
			}

			if (userChoice == 3) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Customer Output Filename:");
				String outputFilename = input.nextLine();
				try {
					ps = new PrintStream(outputFilename);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				c.Write(ps); // Write method called.
			}

			if (userChoice == 4) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Customer JSON Output Filename:");
				String outputFilename = input.nextLine();
				try {
					ps = new PrintStream(outputFilename);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				c.WriteJSON(ps); // Write JSON method called.
			}
			if (userChoice == 5) {
				System.out.println(c.toString()); // Uses toString method to print
				System.out.println(); // file data.
			}
			if (userChoice == 6) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Purchase Input Filename:");
				String filename = input.nextLine();
				try {
					inputFileScanner = new Scanner(new FileReader(filename));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				p.Read(inputFileScanner); // Read method called.
			}
			if (userChoice == 7) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Purchase JSON Input Filename:");
				String filename = input.nextLine();

				try {
					fr = new FileReader(filename);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				p.ReadJSON(fr); // Read JSON method called.
			}
			if (userChoice == 8) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Purchase Output Filename:");
				String outputFilename = input.nextLine();
				try {
					ps = new PrintStream(outputFilename);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				p.Write(ps); // Write method called.
			}
			if (userChoice == 9) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Purchase JSON Output Filename:");
				String outputFilename = input.nextLine();
				try {
					ps = new PrintStream(outputFilename);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				p.WriteJSON(ps); // Write JSON method called.
			}
			if (userChoice == 10) {
				System.out.println(p.toString()); // Uses toString method to
				System.out.println(); // print file data.
			}
		}
	}
}
