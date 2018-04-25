package UserInterface.TextFields;

import javafx.scene.control.TextField;

public class AgeTextField extends TextField {

    int limit;

    public AgeTextField() {
        this.setPromptText("Enter your age :)");
        limit = 3;
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
