/** 
 * Contains a class to display user interfaces.
 */
package ciccone.bcs345.purchases.presentation;

import java.util.Scanner;

/**
 * This class contains a UI menu.
 * 
 * @author Peter Ciccone
 * @version 4.12 @ since 10/19/19
 */

public class Main {
	/**
	 * Contains main program code. This class creates instances of the
	 * CustomerPurchaseConsoleUI and PurchaseCollectionUI objects, and displays the
	 * menu for reading/writing/showing file data.
	 *
	 * 
	 * @param String[] args.
	 * 
	 */
	public static void main(String[] args) {

		CustomerPurchaseConsoleUI console = new CustomerPurchaseConsoleUI();
		PurchaseCollectionConsoleUI pc = new PurchaseCollectionConsoleUI();

		int userChoice = 0;
		while (userChoice != 3) {
			System.out.println("Choose UI");
			System.out.println("---------");
			System.out.println("1 - CustomerPurchaseConsoleUI");
			System.out.println("2 - PurchaseCollectionConsoleUI");
			System.out.println("3 - Exit");
			System.out.println("Enter Choice:\n");
			Scanner menuChoice = new Scanner(System.in);
			userChoice = menuChoice.nextInt();

			if (userChoice == 1) {
				console.ShowUI();
				System.out.println();
			}

			if (userChoice == 2) {
				pc.ShowUI();
				System.out.println();
			}
		}
	}
}
