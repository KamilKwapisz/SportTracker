package tests;
import static org.assertj.core.api.Assertions.*;
import core.TrainingDay;

public class TestTrainingDay {

    private static void testSetDay() {
        TrainingDay td = new TrainingDay();
        assertThatThrownBy(() -> td.setDate("12-12-2012"))
                .as("testing lack of dots in date format")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid date format. Supported date format is dd.MM.yyyy");

        assertThatThrownBy(() -> td.setDate("12.12.3012"))
                .as("testing invalid year")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("you can't add trainings earlier than 2001 and later than 3000");

        assertThatThrownBy(() -> td.setDate("12.14.2012"))
                .as("testing invalid month")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid month. Supported date format is dd.MM.yyyy");

        assertThatThrownBy(() -> td.setDate("00.12.2012"))
                .as("testing invalid day")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid day. Supported date format is dd.MM.yyyy");

    }

    private static void testIsLater(){

        TrainingDay td = new TrainingDay();
        td.setDate("16.05.2018");

        assertThat(td.isLater("22.05.2018"))
                .as("is later test v1")
                .isEqualTo(false);

        assertThat(td.isLater("22.04.2017"))
                .as("is later test v2")
                .isEqualTo(true);

        assertThatThrownBy(() -> td.isLater("12-12-2012"))
                .as("testing lack of dots in date format in isLater")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid date format. Supported date format is dd.MM.yyyy");
    }

    public static void main(String[] args) {
        testSetDay();
        testIsLater();
    }

}
