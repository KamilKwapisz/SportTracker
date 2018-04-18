import SportPlanner.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Day {

    private String date; // dd.mm.yyyy
    private FitnessTraining fitnessTraining;
    private DistanceTraining distanceTraining;

    public Day(String dateString) {
        // day with date only
        this.setDate(dateString);
    }

    public Day(String dateString, FitnessTraining training) {
        // day with fitness training only
        this.setFitnessTraining(training);
        this.setDate(dateString);
    }


    public Day(String dateString, DistanceTraining distanceTraining) {
        // day with distance training only
        this.setDistanceTraining(distanceTraining);
        this.setDate(dateString);
    }

    public Day(String dateString, DistanceTraining distanceTraining, FitnessTraining fitnessTraining) {
        // day with both types of training
        this.setDistanceTraining(distanceTraining);
        this.setFitnessTraining(fitnessTraining);
        this.setDate(dateString);
    }


    public String getDate() {
        return date;
    }

    public void setDate(String dateString) {
        this.date = dateString;
    }

    public FitnessTraining getFitnessTraining() {
        return fitnessTraining;
    }

    public DistanceTraining getDistanceTraining() {
        return distanceTraining;
    }

    public void setFitnessTraining(FitnessTraining fitnessTraining) {
        this.fitnessTraining = fitnessTraining;
    }

    public void setDistanceTraining(DistanceTraining distanceTraining) {
        this.distanceTraining = distanceTraining;
    }

    public boolean isLater(String strDate){
        DateFormat formatter;
        Date newDate, date;
        formatter = new SimpleDateFormat("dd.mm.yyyy");
        try {
            newDate = formatter.parse(strDate);
            date = formatter.parse(this.date);
            if (date.compareTo(newDate) == -1){
                return false;
            }
            else
                return true;
        } catch (java.text.ParseException e ){
            System.out.println("Blad");
            return false;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(date).append("\n");
        if( fitnessTraining != null )
            sb.append(fitnessTraining).append("\n");
        if( distanceTraining != null )
            sb.append(distanceTraining).append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {

        DistanceTrainingMaker distanceDirector = new DistanceTrainingMaker();
        DistanceSportBuilder distanceBuilder = new DistanceTrainingBuilder();
        distanceDirector.setDistanceTraining(distanceBuilder);
        distanceDirector.makeDistanceTraining(1000, 1000, 500);
        DistanceTraining distanceTraining = distanceDirector.getDistanceTraining();

        FitnessTrainingMaker fitnessDirector = new FitnessTrainingMaker();
        FitnessSportBuilder fitnessBuilder = new FitnessTrainingBuilder();
        fitnessDirector.setFitnessTraining(fitnessBuilder);

        Exercise exercise1 = new Exercise.ExerciseBuilder("Pull ups")
                .time(120)
                .reps(20)
                .buildExercise();


        Exercise exercise2 = new Exercise.ExerciseBuilder("Push Ups")
                .time(30)
                .reps(10)
                .buildExercise();

        fitnessDirector.makeFitnessTraining(150, 200, 2);
        fitnessDirector.makeExercise(exercise2);
        fitnessDirector.makeExercise(exercise1);

        FitnessTraining fitnessTraining = fitnessDirector.getFitnessTraining();

        Day day1 = new Day("18.04.2018", distanceTraining);
        Day day2 = new Day("19.04.2018", fitnessTraining);
        Day day3 = new Day("21.04.2018", distanceTraining, fitnessTraining);

        Planner planner = new Planner(3);
        planner.addDay(day1);
        planner.addDay(day2);
        planner.addDay(day3);

        System.out.println(planner);

    }



}
