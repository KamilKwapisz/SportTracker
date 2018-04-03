public class Day {

    private String date;
    private int training;

    public Day(String dateString, int trainingNumber) {
        this.training = trainingNumber;
        this.date = dateString;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String dateString) {
        this.date = this.date = dateString;
    }

    public int getTraining() {
        return training;
    }

    public void setTraining(int training) {
        this.training = training;
    }

    public void removeTraining(){
        this.training = 0; // tymczasowo
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(date).append(" - ").append(training);
        return sb.toString();
    }
}
