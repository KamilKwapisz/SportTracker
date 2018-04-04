public class DistanceTraining extends Training {

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

    public static void main(String[] args) {
        Exercise e = new Exercise("running", 5880, 0, 3000);
        Exercise e2 = new Exercise("running2", 120, 0, 500);
        DistanceTraining dt = new DistanceTraining(3500, 6000,2 );
        dt.addExercise(e);
        dt.addExercise(e2);
        System.out.println(dt.getAvgSpeed());
    }
}
