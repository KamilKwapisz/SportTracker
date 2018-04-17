/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

/**
 *
 * @author Game
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("MainScreen.fxml"));
        AnchorPane aPane = loader.load();
        MainScreenController mainC = loader.getController();
        
        
        
        Scene scene = new Scene(aPane, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("SportTracker");
                primaryStage.setResizable(false);
		primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
