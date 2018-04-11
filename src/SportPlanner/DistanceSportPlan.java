package SportPlanner;

public interface DistanceSportPlan extends SportPlan {
    void setDistance(double distance);
    void calculateAvgSpeed();
    void setTime(double time);
    void setCalories(double calories);

}
