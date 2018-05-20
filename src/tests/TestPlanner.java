package tests;
import static org.assertj.core.api.Assertions.*;
import core.Planner;
import core.TrainingDay;

public class TestPlanner {

    private static void testAddingTrainingDays(){
        Planner planner = new Planner(5);

        planner.addDay(new TrainingDay("16.05.2018"));
        planner.addDay(new TrainingDay("17.05.2018"));
        planner.addDay(new TrainingDay("30.05.2018"));
        planner.addDay(new TrainingDay("07.06.2018"));
        planner.addDay(new TrainingDay("21.07.2018"));

        assertThat(planner.getTrainingDays())
                .as("Checking training days list")
                .hasSize(5)
                .extracting("date")
                .containsOnly("16.05.2018", "17.05.2018", "30.05.2018", "07.06.2018", "21.07.2018");
    }

    private static void testGetDay(){
        Planner planner = new Planner(5);

        TrainingDay td = new TrainingDay("16.05.2018");
        planner.addDay(td);
        planner.addDay(new TrainingDay("17.05.2018"));

        assertThatThrownBy(() -> planner.getDay(4))
                .as("checking exception when getting index out of bound in days list")
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("There are only 2 elements in the list.");

        assertThat(planner.getDay(0))
                .as("testing getDay returned object")
                .isEqualTo(td)
                .isInstanceOf(TrainingDay.class)
                .extracting("date")
                .containsOnly("16.05.2018");
    }

    private static void testGetDaysBetween(){

        Planner planner = new Planner();

        String date1 = "12.04.2018";
        String date2 = "17.04.2018";

        assertThat(planner.getDaysBetweenDates(date1, date2))
                .as("testing list returned from getDaysBetween")
                .hasSize(5)
                .containsOnly("12.04.2018", "13.04.2018", "14.04.2018", "15.04.2018", "16.04.2018");

        assertThat(planner.getDaysBetweenDates(date2, date1))
                .as("testing list returned from getDaysBetween with days in the wrong order")
                .isEmpty();

        assertThatThrownBy(() -> planner.getDaysBetweenDates("13-12-2017", "14-12-2016"))
                .as("checking exception raised when dates are in invalid format")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid date format. Supported date format is dd.MM.yyyy");

        assertThatThrownBy(() -> planner.getDaysBetweenDates("12.17.2017", "13.18.2018"))
                .as("checking exception raised when dates have invalid month")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid month. Supported date format is dd.MM.yyyy");

        assertThatThrownBy(() -> planner.getDaysBetweenDates("00.11.2017", "33.11.2018"))
                .as("checking exception raised when dates have invalid day")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid day. Supported date format is dd.MM.yyyy");

    }

    public void test(){
        testAddingTrainingDays();
        testGetDay();
        testGetDaysBetween();
    }


    public static void main(String[] args) {
        TestPlanner testPlanner = new TestPlanner();
        testPlanner.test();
    }

}
