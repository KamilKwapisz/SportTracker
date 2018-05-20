package tests;
import static org.assertj.core.api.Assertions.*;

import SportPlanner.FitnessTraining;
import core.*;

public class TestSportBuilder {

    private static void testTrainingBuilder(){
        SportBuilder builder = new SportBuilder();
        FitnessTraining exerciseArray = new FitnessTraining(4);

        exerciseArray.addExercise(
                builder.getExercise("push ups", 50, 60)
        );
        exerciseArray.addExercise(
                builder.getExercise("pull ups", 50, 70)
        );
        exerciseArray.addExercise(
                builder.getExercise("chin ups", 50, 60)
        );
        exerciseArray.addExercise(
                builder.getExercise("squats", 50, 20)
        );


        assertThat(exerciseArray.getExercises())
                .as("checking exercises array size")
                .hasSize(4);

        assertThat(exerciseArray.getExercises())
                .as("checking exercises time")
                .extracting("time")
                .containsOnly(50.0);

        assertThat(exerciseArray.getExercises())
                .as("checking exercises reps")
                .extracting("reps")
                .containsOnly(60, 70, 20);

    }

    public void test(){
        testTrainingBuilder();
    }

    public static void main(String[] args) {
        TestSportBuilder testSportBuilder = new TestSportBuilder();
        testSportBuilder.test();
    }

}
