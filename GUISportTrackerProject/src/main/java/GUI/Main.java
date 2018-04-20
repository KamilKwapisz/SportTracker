package GUI;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Konrad/Menu.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane, 900, 600);

		stage.setScene(scene);
                stage.setResizable(false);
		stage.setTitle("SportTracker");
		stage.show();

	}

}
