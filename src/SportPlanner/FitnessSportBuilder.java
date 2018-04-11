package SportPlanner;

public interface FitnessSportBuilder {
    void createFitnessSport(int exerciseNumber);
    void buildExercise(Exercise exercise);
    void buildCalories(double calories);
    void buildTime(double time);
    FitnessTraining getFitnessSport();
}
