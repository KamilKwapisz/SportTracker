package Controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ProfileScreenController {
	MenuController menuController;
	
	@FXML
	private TextField userName;
	@FXML
	private TextField userAge;
	@FXML
	private TextField userHeight;
	@FXML
	private TextField userWeight;
	@FXML
	private Button nameAdd;
	@FXML
	private Button ageAdd;
	@FXML
	private Button heightAdd;
	@FXML
	private Button weightAdd;
	
	@FXML
	private Label nameL;
	@FXML
	private Label ageL;
	@FXML
	private Label heightL;
	@FXML
	private Label weightL;
	
	
	
	



	public void setNameL(String name) {
		nameL.setText(name);
	}


	public void setAgeL(String name) {
		ageL.setText(name);
	}


	public void setHeightL(String name) {
		heightL.setText(name);
	}


	public void setWeightL(String name) {
		weightL.setText(name);
	}
	
	
	
	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}
	
	@FXML
	public void addName() {
		this.setNameL(userName.getText());
	}
	@FXML
	public void addAge() {
		if(userAge.getText().matches("[1-150]")) {
		this.setAgeL(userAge.getText());
		}else {
			userAge.clear();
			userAge.setPromptText("Enter only numbers.");
		}
		
	}
	@FXML
	public void addHeight() {
		if(userHeight.getText().matches("[1-300]")) {
			this.setHeightL(userHeight.getText());
		}else {
			userHeight.clear();
			userHeight.setPromptText("Enter only numbers.");
		}
		
	}
	@FXML
	public void addWeight() {
		if(userWeight.getText().matches("[1-500]")) {
			this.setWeightL(userWeight.getText());
		}else {
			userWeight.clear();
			userWeight.setPromptText("Enter only numbers");
		}
	}
	
}
