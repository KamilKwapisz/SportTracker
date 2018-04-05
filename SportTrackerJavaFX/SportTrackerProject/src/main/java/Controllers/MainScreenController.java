 package Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainScreenController {
	@FXML
	private StackPane mainScreen;

	@FXML
	public void initialize() {
		loadMenu();
		
	}

	public void loadMenu() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Menu.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setScene(pane);
		MenuController menuController = loader.getController();
		menuController.setMainScreenController(this);
	}

	public void setScene(Pane pane) {
		mainScreen.getChildren().clear();
		mainScreen.getChildren().add(pane);
	}

}
