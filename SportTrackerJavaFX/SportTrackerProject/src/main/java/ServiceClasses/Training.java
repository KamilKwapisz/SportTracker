package ServiceClasses;
public class Training {

    private Exercise [] exercises; // exercises array in particular training
    private double time; // training duration
    private int calories; // calories burnt during this training
    private int n; // exercises counter

    public Training(double trainingTime){
        this.time = trainingTime;
        this.n = 0;
        exercises = new Exercise[5];
    }

    public Training(double trainingTime, int exercisesNumber){
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

    public int getCalories() {
        return calories;
    }

    public void calculateCalories(int calories) {
        this.calories = calories;
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
}
