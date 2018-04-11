package SportPlanner;

public class FitnessTrainingMaker {
    private FitnessSportBuilder fitnessSport;

    public void setFitnessTraining(FitnessSportBuilder fitnessSport) {
        this.fitnessSport = fitnessSport;
    }

    public void makeExercise(Exercise exercise) {
        this.fitnessSport.buildExercise(exercise);
    }

    public void makeFitnessTraining(double time, double calories, int exerciseNumber) {
        this.fitnessSport.createFitnessSport(exerciseNumber);
        this.fitnessSport.buildTime(time);
        this.fitnessSport.buildCalories(calories);
    }

    public FitnessTraining getFitnessTraining() {
        return fitnessSport.getFitnessSport();
    }
}
