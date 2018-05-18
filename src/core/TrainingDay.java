package core;

import SportPlanner.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TrainingDay {

    private String date; // dd.mm.yyyy
    private FitnessTraining fitnessTraining;
    private DistanceTraining distanceTraining;

    public TrainingDay() {
    }

    public TrainingDay(String dateString) {
        // day with date only
        this.setDate(dateString);
    }

    public TrainingDay(String dateString, FitnessTraining training) {
        // day with fitness training only
        this.setFitnessTraining(training);
        this.setDate(dateString);
    }


    public TrainingDay(String dateString, DistanceTraining distanceTraining) {
        // day with distance training only
        this.setDistanceTraining(distanceTraining);
        this.setDate(dateString);
    }

    public TrainingDay(String dateString, DistanceTraining distanceTraining, FitnessTraining fitnessTraining) {
        // day with both types of training
        this.setDistanceTraining(distanceTraining);
        this.setFitnessTraining(fitnessTraining);
        this.setDate(dateString);
    }


    public String getDate() {
        return date;
    }

    public void validateDateFormat(String dateString) throws IllegalArgumentException {
        // dd.MM.yyyy
        if(dateString.charAt(2) != '.' && dateString.charAt(5) != '.')
            throw new IllegalArgumentException("Invalid date format. Supported date format is dd.MM.yyyy");

        String day = "" + dateString.charAt(0) + dateString.charAt(1);
        String month = "" + dateString.charAt(3) + dateString.charAt(4);
        String year = "" + dateString.charAt(6) + dateString.charAt(7)
                + dateString.charAt(8) + dateString.charAt(9);

        int yearNumber = Integer.parseInt(year);
        int dayNumber = Integer.parseInt(day);
        int monthNumber = Integer.parseInt(month);

        if (yearNumber < 2001 || yearNumber > 3000)
            throw new IllegalArgumentException("you can't add trainings earlier than 2001 and later than 3000");
        if ( dayNumber < 1 || dayNumber > 31)
            throw new IllegalArgumentException("Invalid day. Supported date format is dd.MM.yyyy");
        if ( monthNumber < 1 || monthNumber > 12)
            throw new IllegalArgumentException("Invalid month. Supported date format is dd.MM.yyyy");

    }

    public void setDate(String dateString) throws IllegalArgumentException {
        try{
            validateDateFormat(dateString);
        } catch (IllegalArgumentException e){
            throw e;
        }

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
            validateDateFormat(strDate);
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

        TrainingDay trainingDay1 = new TrainingDay("18.04.2018", distanceTraining);
        TrainingDay trainingDay2 = new TrainingDay("19.04.2018", fitnessTraining);
        TrainingDay trainingDay3 = new TrainingDay("21.04.2018", distanceTraining, fitnessTraining);

        Planner planner = new Planner(3);
        planner.addDay(trainingDay1);
        planner.addDay(trainingDay2);
        planner.addDay(trainingDay3);

        System.out.println(planner);

    }



}
