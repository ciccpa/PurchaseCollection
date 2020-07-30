/** 
 * Contains a class to display a user interface.
 */
package ciccone.bcs345.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import ciccone.bcs345.purchases.business.PurchaseCollection;

/**
 * This class contains the PurchaseCollection UI.
 *
 * @author Peter Ciccone
 * @version 4.12 @ since 10/19/19
 */
public class PurchaseCollectionConsoleUI {

	public void ShowUI() {

		PurchaseCollection pc = new PurchaseCollection();

		Scanner inputFileScanner = null; // Scanner, PrintStream and FileReader variables all
		PrintStream ps = null; // created beforehand.
		FileReader fr = null;

		int userChoice = 0;
		while (userChoice != 9) // Displays menu until the user enters 11.
		{
			System.out.println("PurchaseCollection UI");
			System.out.println("--------------------");
			System.out.println("1 - Read PurchaseCollection from file\n");
			System.out.println("2 - Read PurchaseCollection from file as JSON\n");
			System.out.println("3 - Write PurchaseCollection to file\n");
			System.out.println("4 - Write PurchaseCollection to file as JSON\n");
			System.out.println("5 - Show purchase by index\n");
			System.out.println("6 - Show maximum purchase\n");
			System.out.println("7 - Show PurchaseCollection report on screen\n");
			System.out.println("8 - Show PurchaseCollection toString on screen\n");
			System.out.println("9 - Exit\n");
			System.out.println("Enter Choice:\n");
			Scanner menuChoice = new Scanner(System.in);
			Scanner input = new Scanner(System.in);
			userChoice = menuChoice.nextInt();

			if (userChoice == 1) // Opens keyboard Scanner based on user choice.
			{
				System.out.println("Enter PurchaseCollection Input Filename:");
				String filename = input.nextLine();
				try {
					inputFileScanner = new Scanner(new FileReader(filename)); // FileReader opens based on what the user
																				// types in.
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				pc.Read(inputFileScanner); // Read method called.
			}

			if (userChoice == 2) {
				System.out.println("Enter PurchaseCollection JSON Input Filename:");
				String filename = input.nextLine();

				try {
					fr = new FileReader(filename);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				pc.ReadJSON(fr); // Read JSON method called.
			}

			if (userChoice == 3) {
				System.out.println("Enter PurchaseCollection Output Filename:");
				String outputFilename = input.nextLine();
				try {
					ps = new PrintStream(outputFilename);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				pc.Write(ps); // Write method called.
			}

			if (userChoice == 4) {
				System.out.println("Enter PurchaseCollectionr JSON Output Filename:");
				String outputFilename = input.nextLine();
				try {
					ps = new PrintStream(outputFilename);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				pc.WriteJSON(ps); // Write JSON method called.
			}
			if (userChoice == 5) {
				int index;
				System.out.println("Enter purchase index.");
				index = input.nextInt();
				try {
					System.out.println(pc.GetByIndex(index));
				} catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}

			if (userChoice == 6) {
				System.out.println(pc.GetMaxPurchase());
			}

			if (userChoice == 7) {
				try {
					ps = new PrintStream(System.out);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				pc.Report(ps);
			}

			if (userChoice == 8) {
				System.out.println();
				System.out.println(pc.toString());
			}
		}
	}
}
