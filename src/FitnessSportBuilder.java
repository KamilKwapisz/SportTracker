import SportPlanner.Exercise;
import SportPlanner.FitnessTraining;

public class FitnessSportBuilder implements SportPlanner.FitnessSportBuilder {
    private FitnessTraining fitnessTraining;

    public FitnessSportBuilder() {
        this.fitnessTraining = new FitnessTraining();
    }

    public void buildExercise(Exercise exercise) {
        this.fitnessTraining.addExercise(exercise);
    }

    public void buildTime(double time) {
        this.fitnessTraining.setTime(time);
    }

    public void buildCalories(int calories) {
        this.fitnessTraining.setCalories(calories);
    }

    public FitnessTraining getFitnessTraining() {
        return fitnessTraining;
    }
}
