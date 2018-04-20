package Controllers;

/*Dodaj do Profile.fxml jeœli b³edy wyskakuj¹:
 * 		<?import TextFields.*?>  		
 * to siê chrzani po modyfikacji pliku Profile.fxml*/

import java.text.DecimalFormat;

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
	private Button buttonBMI;
	
	@FXML
	private Label nameL;
	@FXML
	private Label ageL;
	@FXML
	private Label heightL;
	@FXML
	private Label weightL;
	@FXML
	private Label bmiL;
	
	
	
	



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
		if(userAge.getText().isEmpty())
			return;
		int age = Integer.parseInt(userAge.getText());
		if(age>0 && age<150 ) {
		this.setAgeL(userAge.getText());
		}else {
			userAge.clear();
			userAge.setPromptText("Don't lie to me...");
		}
		
	}
	@FXML
	public void addHeight() {
		if(userHeight.getText().isEmpty())
			return;
		int height =Integer.parseInt(userHeight.getText());
		if(height>40 && height<300) {
		this.setHeightL(userHeight.getText());
		}else {
			userHeight.clear();
			userHeight.setPromptText("Don't lie to me...");
		}
		
	}
	@FXML
	public void addWeight() {
		if(userWeight.getText().isEmpty())
			return;
		int weight=Integer.parseInt(userWeight.getText());
		if(weight>0 && weight<500) {
		this.setWeightL(userWeight.getText());
		}else {
			userWeight.clear();
			userWeight.setPromptText("Don't lie to me...");
		}
		
		
	}
	
	@FXML
	public void calculateBMI() {
		if(weightL.getText().isEmpty() || heightL.getText().isEmpty()) {
			buttonBMI.setText("Values first!");
			return;
		}
		double height = Double.parseDouble(heightL.getText());
		double weight = Double.parseDouble(weightL.getText());
		height*=0.01;
		double BMI = 0;
		String result;
                
		BMI = weight/(height*height);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
                if(BMI<=18.49){
                    result = "niedowaga";
                }else if(BMI<=24.99){
                    result = "prawid³owa";
                }else {
                    result = "nadwaga";
                }
                    
                    
                    bmiL.setText(df.format(BMI)+" "+result);
        }
	
        
       
}
