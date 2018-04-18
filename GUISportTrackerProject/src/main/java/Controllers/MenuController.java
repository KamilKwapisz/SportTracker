package Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;



public class MenuController {
	@FXML
	private AnchorPane display;
	@FXML
	private AnchorPane menuScreen;
	



	public void setScene(AnchorPane pane) {
		display.getChildren().clear();
		display.getChildren().add(pane);
	}

	
	public void openProfile() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Konrad/Profile.fxml"));
		AnchorPane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setScene(pane);
		ProfileScreenController profileScreenController = loader.getController();
		profileScreenController.setMenuController(this);
		
	}
	
	@FXML
	public void openStatistics(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Konrad/Statistics.fxml"));
		AnchorPane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setScene(pane);
		StatisticsScreenController statisticsScreenController = loader.getController();
		statisticsScreenController.setMenuController(this);
	}
	
	@FXML
	public void openHistory(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Konrad/History.fxml"));
		AnchorPane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setScene(pane);
		HistoryController historyController = loader.getController();
		historyController.setMenuController(this);
	}
	
	@FXML
	public void openSport(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Konrad/Sport.fxml/"));
		AnchorPane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setScene(pane);
		SportController sportController = loader.getController();
		sportController.setMenuController(this);
		
	}
	
	@FXML
	public void openCalendar(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Konrad/Calendar.fxml/"));
		AnchorPane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setScene(pane);
		CalendarController calendarController = loader.getController();
		calendarController.setMenuController(this);
	}
}
