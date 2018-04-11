package SportPlanner;

public class DistanceTraining implements DistanceSportPlan {
    private double distance;
    private double time;
    private double avgSpeed;
    private double calories;

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void calculateAvgSpeed() {
        this.avgSpeed = distance / time;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "My Distance Training"
                + "\n" + "Distance: " + distance
                + "\n" + "Time: " + time
                + "\n" + "AvgSpeed: " + avgSpeed
                + "\n" + "Calories: " + calories;
    }
}
