package UserInterface.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class ProfileScreenController {
	MenuController menuController;
	
        @FXML
        private Label pUser;
        
	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}
        
        @FXML
        void initialize(){
            pUser.setText("Daniel");
        }

}
