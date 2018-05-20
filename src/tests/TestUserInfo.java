package tests;
import core.UserInfo;
import static org.assertj.core.api.Assertions.*;

public class TestUserInfo {

    private static void testCalculateBMI(){
        UserInfo ui = new UserInfo();
        assertThatThrownBy(() -> ui.calculateBMI())
                .as("testing upper height boundary")
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Firstly set your weight and height");
        ui.setHeight(200);
        ui.setWeight(100);
        ui.calculateBMI();
        assertThat(ui.getBMI())
                .as("testing BMI calculator")
                .isEqualTo(25);
    }

    private static void testHeightBoundaries(){
        UserInfo ui = new UserInfo();
        assertThatThrownBy(() -> ui.setHeight(320))
                .as("testing upper height boundary")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You can not be that high.");
        assertThatThrownBy(() -> ui.setHeight(20))
                .as("testing lower height boundary")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You can not be that short.");
    }

    private static void testWeightBoundaries(){
        UserInfo ui = new UserInfo();
        assertThatThrownBy(() -> ui.setWeight(720))
                .as("testing upper weight boundary")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You can not be that heavy.");
        assertThatThrownBy(() -> ui.setWeight(10))
                .as("testing lower weight boundary")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You can not be that light.");
    }

    private static void testSetSex(){
        UserInfo ui = new UserInfo();
        assertThatThrownBy(() -> ui.setSex("niemęski"))
                .as("testing sex setter")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Gender possibilities: female, male.");
    }

    public void test(){
        testCalculateBMI();
        testHeightBoundaries();
        testWeightBoundaries();
        testSetSex();
    }

    public static void main(String[] args) {
        TestUserInfo testUserInfo = new TestUserInfo();
        testUserInfo.test();
    }

}
