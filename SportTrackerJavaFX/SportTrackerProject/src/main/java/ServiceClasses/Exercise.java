package ServiceClasses;
public class Exercise {

    private String name; // exercise name
    private double time; // exercise time in seconds
    private int reps; // number of repetitions in exercise
    private double distance; // distance of sports like running etc

    public Exercise(String exerciseName, double exerciseTime, int repetitions, double exerciseDistance){
        this.name = exerciseName;
        this.time = exerciseTime;
        this.reps = repetitions;
        this.distance = exerciseDistance;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public int getReps() {
        return reps;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
