import SportPlanner.FitnessTraining;
import SportPlanner.Exercise;

public class DistanceTraining extends FitnessTraining {

    private double distance; // distance reached during training in meters
    private double avgSpeed; // training average speed in m/s

    public DistanceTraining(double trainingDistance, double trainingTime){
        super(trainingTime);
        this.distance = trainingDistance;
    }

    public DistanceTraining(double trainingDistance, double trainingTime, int exercisesNumber){
        super(trainingTime, exercisesNumber);
        this.distance = trainingDistance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void calculateAvgSpeed() {
        this.avgSpeed = this.distance / super.getTime();
    }

}
