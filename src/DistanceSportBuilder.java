public class DistanceSportBuilder implements DistanceTrainingBuilder {
    private DistanceTraining distanceTraining;

    public DistanceSportBuilder() {
        this.distanceTraining = new DistanceTraining();
    }

    public void buildDistance(double distance) {
        this.distanceTraining.setDistance(distance);
    }

    public void buildTime(double time) {
        this.distanceTraining.setTime(time);
    }

    public void buildAvgSpeed(double avgSpeed) {
        this.distanceTraining.calculateAvgSpeed(avgSpeed);
    }

    public void buildCalories(int calories) {
        this.distanceTraining.setCalories(calories);
    }

    public DistanceTraining getDistanceTraining() {
        return distanceTraining;
    }

}
