public class Day {

    private String date;
    private Training training;

    public Day(String dateString, Training training) {
        this.training = training;
        this.date = dateString;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String dateString) {
        this.date = this.date = dateString;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
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
