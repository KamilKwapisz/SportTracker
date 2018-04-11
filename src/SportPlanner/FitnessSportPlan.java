package SportPlanner;

public interface FitnessSportPlan extends SportPlan {
    void setTime(double time);
    void setCalories(double calories);
    void addExercise(Exercise exercise);
}
