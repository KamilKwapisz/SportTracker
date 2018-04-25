import UserInterface.Controllers.LoginController;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/UserInterface/fxml/Login.fxml"));
		GridPane pane = loader.load();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
                stage.setResizable(false);
		stage.setTitle("SportTracker");
		stage.show();
                
                LoginController loginController; 
            loginController =  loader.getController();
            loginController.setStage(stage);
                    
                    

	}

}
