package core;

public class UserInfo {

    private double weight = 0;
    private double height = 0;
    private double BMI;
    private String sex;


    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IllegalArgumentException {
        if (weight < 30)
            throw new IllegalArgumentException("You can not be that light.");
        else if (weight > 500)
            throw new IllegalArgumentException("You can not be that heavy.");
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) throws IllegalArgumentException {
        if( height > 300)
            throw new IllegalArgumentException("You can not be that high.");
        else if (height < 50)
            throw new IllegalArgumentException("You can not be that short.");
        this.height = height;
    }

    public double getBMI() {
        return BMI;
    }

    public void calculateBMI() throws NullPointerException {
        if (this.height == 0 || this.weight == 0)
            throw new NullPointerException("Firstly set your weight and height");
        this.BMI = this.weight / ((this.height / 100) * (this.height / 100));
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws IllegalStateException{
        if( sex != "male" && sex != "female")
            throw new IllegalStateException("Gender possibilities: female, male.");
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
