package tests;

import static org.assertj.core.api.Assertions.*;
import SportPlanner.*;

public class TestFitnessTraining {
    private static void testFitnessTraining() {
        FitnessTrainingMaker fitnessDirector = new FitnessTrainingMaker();
        fitnessDirector.setFitnessTraining(new FitnessTrainingBuilder());
        fitnessDirector.makeFitnessTraining(150.0, 200.0, 3);
        fitnessDirector.makeExercise(new Exercise("Push Ups", 50, 60));
        fitnessDirector.makeExercise(new Exercise("Pull Ups", 50, 70));
        fitnessDirector.makeExercise(new Exercise("Chin Ups", 50, 80));

        assertThat(fitnessDirector.getFitnessTraining().getExercises())
                .as("Checking Fitness Training array size")
                .hasSize(3);

        assertThat(fitnessDirector.getFitnessTraining())
                .as("Checking Fitness Training time")
                .extracting("time")
                .contains(150.0);

        assertThat(fitnessDirector.getFitnessTraining())
                .as("Checking Fitness Training calories")
                .extracting("calories")
                .contains(200.0);
    }

    public void test() {
        testFitnessTraining();
    }

    public static void main(String[] args) {
        TestFitnessTraining testFitnessTraining = new TestFitnessTraining();
        testFitnessTraining.test();
    }
}
