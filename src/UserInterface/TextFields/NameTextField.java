package UserInterface.TextFields;

import javafx.scene.control.TextField;

public class NameTextField extends TextField {

    int limit;

    public NameTextField() {

        this.setPromptText("Enter your username :)");
        limit = 40;
    }

    public void verify() {
        if (getText().length() > limit) {
            setText(getText().substring(0, limit));
        }
    }

}
