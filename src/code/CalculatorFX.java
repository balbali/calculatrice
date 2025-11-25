package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorFX extends Application {
  /**
   * Méthode start
   * @param stage
   * @throws Exception
   * @author Adam
   */
    @Override
    public void start(Stage stage) throws Exception {
        // Chemin relatif au package 'code'
    	//lllllll
    	//LLLL
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Calculatrice");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}