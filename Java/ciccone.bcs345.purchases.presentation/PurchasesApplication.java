package ciccone.bcs345.purchases.presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *	Creates the scene that the GUI will be displayed.
 */
public class PurchasesApplication extends Application {
		   @Override
		   public void start(Stage primaryStage) {
		      Parent root = null;
		      Scene scene = null;
		      try {
		         FXMLLoader loader= new FXMLLoader(getClass().getResource("Main.fxml"));
		         root = loader.load();
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
		      // Put the root containing the FXML into the scene
		      scene = new Scene(root, 300, 275);
		      primaryStage.setScene(scene);
		      primaryStage.setTitle("Purchases");
		      primaryStage.show();
			
		   }
		}

