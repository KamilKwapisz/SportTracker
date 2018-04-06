public class Printer {

    private String text;

    public Printer(String text){
        this.text = text;
    }

    public void give(){
        System.out.println(text);
    }
}
