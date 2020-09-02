package ciccone.bcs345.purchases.presentation;
/** 
 * Contains a controller class to the Graphical UI.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import ciccone.bcs345.purchases.business.Purchase;
import ciccone.bcs345.purchases.business.PurchaseCollection;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * This is the controller class for all Graphical UI operations. 
 * 
 * @author Peter Ciccone
 * @version 4.12 @ since 10/23/19
 */

public class PurchasesController {

	/**
	 * FXML overrides for each element/method used:
	 */
	@FXML						
	private MenuItem openMenuItem;
	@FXML
	private MenuItem saveAsMenuItem;
	@FXML
	private MenuItem saveMenuItem;
	@FXML
	private MenuItem exitMenuItem;
	
	@FXML
	private TextField firstNameTextField;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private TextField numberTextField;
	@FXML
	private TextField streetTextField;
	@FXML
	private TextField cityTextField;
	@FXML
	private TextField stateTextField;
	@FXML
	private TextField zipTextField;
	@FXML
	private PurchaseCollection pc;
	@FXML
	private Purchase p[];
	
	@FXML
	private ListView<String> listViewItems;

	/**
	 * Displays data in textfields depending on which
	 * file the user chooses.
	 * 
	 * @param ActionEvent event - Uses event handler.
	 */
	@FXML
	private void handleOpenMenuItemAction(final ActionEvent event)
	{
		listViewItems.getItems().clear();
		this.firstNameTextField.clear();
		this.lastNameTextField.clear();
		this.numberTextField.clear();
		this.streetTextField.clear();
		this.cityTextField.clear();
		this.stateTextField.clear();
		this.zipTextField.clear();
		
	  	FileChooser fc = new FileChooser();
	  	fc.setTitle("Open PurchaseCollection File");
		File file = fc.showOpenDialog(null);
		 
		if (file != null)
		{
			try 
			{
				Scanner s = new Scanner(new FileReader(file));
				
				this.pc = new PurchaseCollection();
				this.pc.Read(s);
				String firstName = this.pc.getCustomer().getFirstName();
				String lastName = this.pc.getCustomer().getLastName();
				String number = this.pc.getCustomer().getAddress().getNumber();
				String street = this.pc.getCustomer().getAddress().getStreet();
				String city = this.pc.getCustomer().getAddress().getCity();
				String state = this.pc.getCustomer().getAddress().getState();
				String zip = this.pc.getCustomer().getAddress().getZip(); 
				
				this.firstNameTextField.setText(firstName);
				this.lastNameTextField.setText(lastName);
				this.numberTextField.setText(number);
				this.streetTextField.setText(street);
				this.cityTextField.setText(city);
				this.stateTextField.setText(state);
				this.zipTextField.setText(zip); 
		
				
				Purchase p[] = new Purchase[pc.getPurchase().length];	
				pc.GetPurchaseArray(p);	// New method created in PurchaseCollection to get the Purchase array values 
										// since PurchaseCollection has an array of purchases that are inaccessible.
				
				for(int i = 0; i < pc.getPurchase().length; i++)
				{
					listViewItems.getItems().addAll(p[i].toString());	// Adds each piece of data to its own ListView item.
				} 
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
				
		}
	}
	
	/**
	 * Writes PurchaseCollection data to whichever file
	 * the user chooses. 
	 * 
	 * @param ActionEvent event - Uses event handler.
	 */
	@FXML
	private void handleSaveAsMenuItemAction(final ActionEvent event)
	{
			try 
			{
				Scanner s = new Scanner(new FileReader("PurchaseCollection.txt"));
				this.pc = new PurchaseCollection();
				pc.Read(s);
				
				FileChooser fc = new FileChooser();
			  	fc.setTitle("Save As PurchaseCollection");
				
				File outputFile = fc.showOpenDialog(null);
				PrintStream ps = new PrintStream(outputFile);
				pc.Write(ps);
		
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
				
	}
	
	/**
	 * Writes PurchaseCollection data to a report file
	 * that the user chooses. 
	 * 
	 * @param ActionEvent event - Uses event handler.
	 */
	@FXML
	private void handleSaveMenuItemAction(final ActionEvent event)
	{
		try 
		{
			Scanner s = new Scanner(new FileReader("PurchaseCollection.txt"));
			this.pc = new PurchaseCollection();
			pc.Read(s);
			
			FileChooser fc = new FileChooser();
		  	fc.setTitle("Save PurchasesCollection Report");
			
			File outputFile = fc.showOpenDialog(null);
			PrintStream ps = new PrintStream(outputFile);
			pc.Report(ps);
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exits the Graphical UI. 
	 * 
	 * @param ActionEvent event - Uses event handler.
	 */
	@FXML
	private void handleExitMenuItemAction(final ActionEvent event)
	{
		Platform.exit();
	}
}