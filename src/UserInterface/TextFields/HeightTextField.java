package UserInterface.TextFields;

import javafx.scene.control.TextField;

public class HeightTextField extends TextField {

    int limit;

    public HeightTextField() {
        limit = 3;
        this.setPromptText("Enter you height in centimeters :)");
    }

    @Override
    public void replaceText(int i, int i1, String string) {
        if (string.matches("[0-9]") || string.isEmpty()) {
            super.replaceText(i, i1, string);
        }
    }

    @Override
    public void replaceSelection(String string) {
        super.replaceSelection(string);
    }

    public void verify() {
        if (getText().length() > limit) {
            setText(getText().substring(0, limit));
        }
    }
}
