package ServiceClasses;
public class Statistics {

    private double totalTime; // total training time in seconds
    private double totalDistance; // total distance from running and cycling in meters;
    private int repsNumber; // number of repetitions from all trainings
    private String sport; // sport type
    private Training training;
    private DistanceTraining distanceTraining;

    public Statistics(String sportName){
        this.totalDistance = 0.0;
        this.totalTime = 0.0;
        this.repsNumber = 0;
        this.sport = sportName;
    }

    public Statistics(Training training){
        this.totalDistance = 0.0;
        this.totalTime = training.getTime();
        this.repsNumber = 0;
        this.training = training;
    }

    public Statistics(DistanceTraining distanceTraining){
        this.totalDistance = distanceTraining.getDistance();
        this.totalTime = 0.0;
        this.repsNumber = 0;
        this.distanceTraining = DistanceTraining;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public int getRepsNumber() {
        return repsNumber;
    }

    public int getTraining() {
        return training;
    }

    public int getDistanceTraining() {
        return distanceTraining;
    }

    public String getSport() {
        return sport;
    }


    public void increaseTotalTime(double trainingTime){
        this.totalTime += trainingTime;
    }

    public void increaseTotalDistance(double trainingDistance){
        this.totalDistance += trainingDistance;
    }

    public void increaseRepsNumber(int repetitions){
        this.repsNumber += repetitions;
    }


    public double calculateAvgSpeed(){
        double speed = this.totalDistance / this.totalTime;
        return speed;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.sport)
                .append("(").append(this.training).append("):")
                .append("time= ").append(this.totalTime).append("s, ")
                .append("distance = ").append(this.totalDistance).append("m, ")
                .append("reps = ").append(this.repsNumber);
        return sb.toString();
    }

}
