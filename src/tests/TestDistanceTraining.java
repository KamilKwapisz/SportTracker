package tests;

import SportPlanner.*;

import static org.assertj.core.api.Assertions.*;

public class TestDistanceTraining {
    private static void testDistanceTraining() {
        DistanceTrainingMaker distanceDirector = new DistanceTrainingMaker();
        distanceDirector.setDistanceTraining(new DistanceTrainingBuilder());
        distanceDirector.makeDistanceTraining(1000.0, 1000.0, 500.0);

        assertThat(distanceDirector.getDistanceTraining())
                .as("Checking Distance Training distance")
                .extracting("distance")
                .contains(1000.0);

        assertThat(distanceDirector.getDistanceTraining())
                .as("Checking Distance Training time")
                .extracting("time")
                .contains(1000.0);

        assertThat(distanceDirector.getDistanceTraining())
                .as("Checking Distance Training calories")
                .extracting("calories")
                .contains(500.0);
    }

    public void test() {
        testDistanceTraining();
    }

    public static void main(String[] args) {
        TestDistanceTraining testDistanceTraining = new TestDistanceTraining();
        testDistanceTraining.test();
    }
}
