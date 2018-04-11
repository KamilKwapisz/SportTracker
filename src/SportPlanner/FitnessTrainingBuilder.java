package SportPlanner;

public class FitnessTrainingBuilder implements FitnessSportBuilder {
    private FitnessTraining fitnessTraining;

    public void createFitnessSport(int exerciseNumber) {
        this.fitnessTraining = new FitnessTraining(exerciseNumber);
    }

    public void buildExercise(Exercise exercise) {
        this.fitnessTraining.addExercise(exercise);
    }

    public void buildTime(double time) {
        this.fitnessTraining.setTime(time);
    }

    public void buildCalories(double calories) {
        this.fitnessTraining.setCalories(calories);
    }

    public FitnessTraining getFitnessSport() {
        return this.fitnessTraining;
    }
}
