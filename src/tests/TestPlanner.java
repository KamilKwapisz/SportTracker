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

    public static void main(String[] args) {
        testAddingTrainingDays();
        testGetDay();
    }

}
