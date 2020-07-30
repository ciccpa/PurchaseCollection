/* 
 * GetMaxPurchase. Incorrect. Does not return the correct purchase. 
 * This method should declare a max purchase instance before the loop (set it to the 0 element). 
 * Inside the loop just check the current element cost against the max instance cost (cost is quantity * price). 
 * If the current element is higher then set that one to be the max instance. 
 * After the loop just return max instance. You do not need a nested loop for this algorithm.

Write. Should write out the number of purchases to the output file just before writing the purchase data. 
The file that is created with this method will not be usable as input to the Read method.

ShowUI Option 5. The call to getByIndex should be inside of a try/catch block. 
That try/catch block should have a catch for ArrayIndexOutOfBoundsException.

Note: ShowUI. There is no need to create multiple instance of Scanner to System.in. You can just call new for one Scanner connected to System.in at the top of ShowUI and use that for all keyboard input. Did not take off points for this.
 * 
 */

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