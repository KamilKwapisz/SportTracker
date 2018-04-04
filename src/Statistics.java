public class Statistics {

    private double totalTime; // total training time in seconds
    private double totalDistance; // total distance from running and cycling in meters;
    private int repsNumber; // number of repetitions from all trainings
    private String sport; // sport type

    public Statistics(String sportName){
        this.totalDistance = 0.0;
        this.totalTime = 0.0;
        this.repsNumber = 0;
        this.sport = sportName;
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
                .append("time= ").append(this.totalTime).append("s, ")
                .append("distance = ").append(this.totalDistance).append("m, ")
                .append("reps = ").append(this.repsNumber);
        return sb.toString();
    }

}
