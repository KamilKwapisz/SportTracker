/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Game
 */
public class LoginController implements Initializable {

    @FXML
    private TextField UserNameL;
    @FXML
    private Button loginB;
    @FXML
    private PasswordField passwordL;
    @FXML
    private TextField UsernameR;
    @FXML
    private PasswordField passwordR;
    @FXML
    private Button registerB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signIn(ActionEvent event) {
        
    }

    @FXML
    private void registerUser(ActionEvent event) {
        
    }
    
}
