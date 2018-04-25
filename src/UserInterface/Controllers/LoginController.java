/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class LoginController  {
    Stage stage;
    
    @FXML
    private JFXTextField usernameL;
    @FXML
    private Button loginB;
    @FXML
    private JFXPasswordField passwordL;
    @FXML
    private JFXTextField usernameR;
    @FXML
    private JFXPasswordField passwordR;
    @FXML
    private Button registerB;
 
    public void setStage(Stage stage){
        this.stage=stage;
    }

    @FXML
    private void signIn() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/UserInterface/fxml/Menu.fxml"));
        AnchorPane pane = null;
        
        try{
            pane = loader.load();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void registerUser(ActionEvent event) {
        
    }
    
}
