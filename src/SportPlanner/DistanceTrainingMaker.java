package SportPlanner;

public class DistanceTrainingMaker {
    private DistanceSportBuilder distanceSport;

    public void setDistanceTraining(DistanceSportBuilder distanceSport) {
        this.distanceSport = distanceSport;
    }

    public  void makeDistanceTraining(double distance, double time, double calories) {
        this.distanceSport.createDistanceSport();
        this.distanceSport.buildDistance(distance);
        this.distanceSport.buildTime(time);
        this.distanceSport.buildAvgSpeed();
        this.distanceSport.buildCalories(calories);
    }

    public DistanceTraining getDistanceTraining() {
        return distanceSport.getDistanceSport();
    }
}
