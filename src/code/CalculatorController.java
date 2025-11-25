package code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

	Float data = 0f;
	int operation = -1;

	@FXML
	private Button moins;

	@FXML
	private Button neuf;

	@FXML
	private Button six;

	@FXML
	private Button mult;

	@FXML
	private Button un;

	@FXML
	private TextField resultat;

	@FXML
	private Button effacer;

	@FXML
	private Button sept;

	@FXML
	private Label label;

	@FXML
	private Button deux;

	@FXML
	private Button trois;

	@FXML
	private Button plus;

	@FXML
	private Button huit;

	@FXML
	private Button zero;

	@FXML
	private Button div;

	@FXML
	private Button quatre;

	@FXML
	private Button egale;

	@FXML
	private Button cinq;

	@FXML
	void handleButtonAction(ActionEvent event) {
		if (event.getSource() == un) {
			resultat.setText(resultat.getText() + "1");
		} else if (event.getSource() == deux) {
			resultat.setText(resultat.getText() + "2");
		} else if (event.getSource() == trois) {
			resultat.setText(resultat.getText() + "3");
		} else if (event.getSource() == quatre) {
			resultat.setText(resultat.getText() + "4");
		} else if (event.getSource() == cinq) {
			resultat.setText(resultat.getText() + "5");
		} else if (event.getSource() == six) {
			resultat.setText(resultat.getText() + "6");
		} else if (event.getSource() == sept) {
			resultat.setText(resultat.getText() + "7");
		} else if (event.getSource() == huit) {
			resultat.setText(resultat.getText() + "8");
		} else if (event.getSource() == neuf) {
			resultat.setText(resultat.getText() + "9");
		} else if (event.getSource() == zero) {
			resultat.setText(resultat.getText() + "0");
		} else if (event.getSource() == effacer) {
			resultat.setText("");
		} else if (event.getSource() == plus) {
			data = Float.parseFloat(resultat.getText());
			operation = 1; // Addition
			resultat.setText("");
		} else if (event.getSource() == moins) {
			data = Float.parseFloat(resultat.getText());
			operation = 2; // Subtraction
			resultat.setText("");
		} else if (event.getSource() == mult) {
			data = Float.parseFloat(resultat.getText());
			operation = 3; // Mult
			resultat.setText("");
		} else if (event.getSource() == div) {
			data = Float.parseFloat(resultat.getText());
			operation = 4; // Division
			resultat.setText("");
		} else if (event.getSource() == egale) {
			Float secondOperand = Float.parseFloat(resultat.getText());
			Float ans = 0f;
			switch (operation) {
			case 1: // Addition
			ans = data + secondOperand;
			resultat.setText(String.valueOf(ans)); break;
			case 2: // Subtraction
				ans = data - secondOperand;
				resultat.setText(String.valueOf(ans)); break;
			case 3: // Mul
				ans = data * secondOperand;
				resultat.setText(String.valueOf(ans)); break;
			case 4: // Div
				ans = 0f;
				try {
					ans = data / secondOperand;
				} catch (Exception e) {
					resultat.setText("Error");
				}
				resultat.setText(String.valueOf(ans));
				break;
			}
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}

