package UserInterface.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class StatisticsScreenController {
	MenuController menuController;

	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}
	@FXML
        private Label totalTimeRunning;
        
        @FXML
        private Label totalDistance;

       @FXML
        private Label avgSpeed;
       
       @FXML
        private Label totalRepetitions;
       
       @FXML
        private Label totalTrainingsThisMonth;
       
       @FXML
        private Label mostUsedTraining;
       
       @FXML
        private Label totalDistanceToday;
       
       @FXML
        private Label timeRunningToday;
       
       @FXML
        private Label avgSpeedToday;
       
       
    public void setTotalTimeRunning(String value) {
        this.totalTimeRunning.setText(value);
    }

    public void setTotalDistance(String value) {
        this.totalDistance.setText(value);
    }

    public void setAvgSpeed(String value) {
        this.avgSpeed.setText(value);
    }

    public void setTotalRepetitions(String value) {
        this.totalRepetitions.setText(value);
    }

    public void setTotalTrainingsThisMonth(String value) {
        this.totalTrainingsThisMonth.setText(value);
    }

    public void setMostUsedTraining(String value) {
        this.mostUsedTraining.setText(value);
    }

    public void setTotalDistanceToday(String value) {
        this.totalDistanceToday.setText(value);
    }

    public void setTimeRunningToday(String value) {
        this.timeRunningToday.setText(value);
    }

    public void setAvgSpeedToday(String value) {
        this.avgSpeedToday.setText(value);
    }
}
