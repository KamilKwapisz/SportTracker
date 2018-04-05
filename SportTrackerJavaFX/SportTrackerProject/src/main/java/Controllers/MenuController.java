package Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class MenuController {
	MainScreenController mainScreenController;
	public void setMainScreenController(MainScreenController mainScreenController) {
		this.mainScreenController = mainScreenController;
	}

	@FXML
	public void openProfile() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ProfileScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainScreenController.setScene(pane);
		ProfileScreenController profileScreenController = loader.getController();
		profileScreenController.setMainScreenController(mainScreenController);
		
	}
	
	@FXML
	public void openStatistics(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/StatisticsScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainScreenController.setScene(pane);
		StatisticsScreenController statisticsScreenController = loader.getController();
		statisticsScreenController.setMainScreenController(mainScreenController);
	}
	
	@FXML
	public void openHistory(){
		
	}
	
	@FXML
	public void openSportPlan(){
		
	}
	
	@FXML
	public void openCalendar(){
		
	}
	
}
