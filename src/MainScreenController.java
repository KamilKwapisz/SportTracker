/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Game
 */
public class MainScreenController implements Initializable{

    @FXML
    private Button bProfile;
    
    @FXML
    private AnchorPane display;
    
   // ProfileController profileController;
    public MainScreenController(){
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void showProfile() throws IOException{
     display.getChildren().clear();
     AnchorPane pane = FXMLLoader.load(getClass().getResource("Profile.fxml"));
     display.getChildren().setAll(pane);
      
	}

    @FXML
    public void showStat() throws IOException{
     display.getChildren().clear();
     AnchorPane pane = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
     display.getChildren().setAll(pane);
        }
    
    @FXML
    public void showHistory() throws IOException{
     display.getChildren().clear();
     AnchorPane pane = FXMLLoader.load(getClass().getResource("History.fxml"));
     display.getChildren().setAll(pane);
        }
    
    @FXML
    public void showSport() throws IOException{
     display.getChildren().clear();
     AnchorPane pane = FXMLLoader.load(getClass().getResource("Sport.fxml"));
     display.getChildren().setAll(pane);
        }
    
    @FXML
    public void showCalendar() throws IOException{
     display.getChildren().clear();
     AnchorPane pane = FXMLLoader.load(getClass().getResource("Calendar.fxml"));
     display.getChildren().setAll(pane);
        }
    }

