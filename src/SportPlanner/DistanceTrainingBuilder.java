package SportPlanner;

public class DistanceTrainingBuilder implements DistanceSportBuilder{
    private DistanceTraining distanceTraining;

    public void createDistanceSport() {
        this.distanceTraining = new DistanceTraining();
    }

    public void buildDistance(double distance) {
        this.distanceTraining.setDistance(distance);
    }

    public void buildTime(double time) {
        this.distanceTraining.setTime(time);
    }

    public void buildAvgSpeed() {
        this.distanceTraining.calculateAvgSpeed();
    }

    public void buildCalories(double calories) {
        this.distanceTraining.setCalories(calories);
    }

    public DistanceTraining getDistanceSport() {
        return distanceTraining;
    }
}
