package ServiceClasses;
public class UserInfo {

    private double weight;
    private double height;
    private double BMI;
    private String sex;


    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getBMI() {
        return BMI;
    }

    public void calculateBMI() {
        try {
            this.BMI = this.weight / ((this.height/100) * (this.height/100));
        } catch (Exception e){
            System.out.println("Firstly set your weight and height");
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if( sex != "male" && sex != "female")
                this.sex = "undefined";
        this.sex = sex;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.sex == "male")
            sb.append("he ");
        else if(this.sex == "female")
            sb.append("she ");
        else
            sb.append("it ");
        sb.append("weights ").append(this.weight).append(" kilos and is ").append(this.height)
                .append(" cm high. BMI=").append(getBMI());
        return sb.toString();
    }

    // main for quick testing
    public static void main(String[] args) {
        UserInfo ui = new UserInfo();
        ui.setWeight(72);
        ui.setHeight(185);
        ui.calculateBMI();
        ui.setSex("male");
        System.out.println(ui);
    }

}
