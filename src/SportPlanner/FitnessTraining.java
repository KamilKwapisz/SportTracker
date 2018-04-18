package SportPlanner;

public class FitnessTraining implements FitnessSportPlan {

    private Exercise[] exercises; // exercises array in particular training
    private double time; // training duration
    private double calories; // calories burnt during this training
    private int n; // exercises counter

    public FitnessTraining(int exercisesNumber) {
        this.n = 0;
        exercises = new Exercise[exercisesNumber];
    }

    public FitnessTraining(double trainingTime){
        this.time = trainingTime;
        this.n = 0;
        exercises = new Exercise[5];
    }

    public FitnessTraining(double trainingTime, int exercisesNumber){
        this.time = trainingTime;
        this.n = 0;
        exercises = new Exercise[exercisesNumber];
    }

    public Exercise[] getExercises() {
        return exercises;
    }

    public void setExercises(Exercise[] exercises) {
        this.exercises = exercises;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }

    public int getn() {
        return n;
    }

    public void addExercise(Exercise exercise){
        if( n == exercises.length )
            doubleSize();
        exercises[n++] = exercise;
    }

    private void doubleSize() {
        Exercise[] newExercises = new Exercise[2 * exercises.length];
        for(int i = 0; i < n; i++)
            newExercises[i] = exercises[i];
        exercises = newExercises;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("My Fitness Training" + "(");

        for(int i = 0; i < n; i++) {
            str.append(exercises[i].getReps() + " " + exercises[i].getName() + ", ");
        }

        str.append(") " + "time: " + time + " calories: " + calories);
        return str.toString();
    }
}
