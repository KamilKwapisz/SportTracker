package tests;

import static org.assertj.core.api.Assertions.*;
import SportPlanner.Exercise;

public class TestExercise {
    private static void  testExercise() {
        Exercise exercise = new Exercise.ExerciseBuilder("Swimming")
                .time(20.0)
                .reps(10)
                .buildExercise();

        assertThat(exercise)
                .as("Checking exercise's time")
                .extracting("time")
                .contains(20.0);

        assertThat(exercise)
                .as("Checking exercise's reps")
                .extracting("reps")
                .contains(10);

        assertThat(exercise)
                .as("Checking exercise's name")
                .extracting("name")
                .contains("Swimming");
    }

    public void test() {
        testExercise();
    }

    public static void main(String[] args) {
        TestExercise testExercise = new TestExercise();
        testExercise.test();
    }
}
