package SportPlanner;

public interface DistanceSportBuilder {
    void createDistanceSport();
    void buildDistance(double distance);
    void buildTime(double time);
    void buildAvgSpeed();
    void buildCalories(double calories);
    DistanceTraining getDistanceSport();
}
