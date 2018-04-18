package TextFields;



import javafx.scene.control.TextField;

public class AgeTextField extends TextField {
	public AgeTextField() {
		this.setPromptText("Enter your age :)");
	}
	
	@Override
	public void replaceText(int i, int i1,String string) {
		if(string.matches("[0-9]") || string.isEmpty())
			super.replaceText(i, i1, string);
	}
	
	@Override
	public void replaceSelection(String string) {
		super.replaceSelection(string);
	}
}
