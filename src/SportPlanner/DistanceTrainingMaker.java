package SportPlanner;

public class DistanceTrainingMaker {
    private DistanceSportBuilder distanceSport;

    public void setDistanceSport(DistanceSportBuilder distanceSport) {
        this.distanceSport = distanceSport;
    }

    public  void makeDistanceSport(double distance, double time, double calories) {
        this.distanceSport.createDistanceSport();
        this.distanceSport.buildDistance(distance);
        this.distanceSport.buildTime(time);
        this.distanceSport.buildAvgSpeed();
        this.distanceSport.buildCalories(calories);
    }

    public DistanceTraining getDistanceSport() {
        return distanceSport.getDistanceSport();
    }
}
