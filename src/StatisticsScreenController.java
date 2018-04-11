

import javafx.fxml.FXML;

public class StatisticsScreenController {
	MainScreenController mainScreenController;

	public void setMainScreenController(MainScreenController mainScreenController) {
		this.mainScreenController = mainScreenController;
	}
	
	@FXML
	public void back() {
		mainScreenController.loadMenu();
	}
}
