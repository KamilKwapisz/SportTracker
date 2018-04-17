import SportPlanner.FitnessTraining;
public class Day {

    private String date;
    private FitnessTraining training;

    public Day(String dateString, FitnessTraining training) {
        this.training = training;
        this.date = dateString;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String dateString) {
        this.date = this.date = dateString;
    }

    public FitnessTraining getTraining() {
        return training;
    }

    public void setTraining(FitnessTraining training) {
        this.training = training;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(date).append(" - ").append(training);
        return sb.toString();
    }
}
