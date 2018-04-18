import SportPlanner.*;

public class Day {

    private String date; // DD.MM.YYYY
    private FitnessTraining fitnessTraining;
    private DistanceTraining distanceTraining;

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

        System.out.println(day1);
        System.out.println("=========================");
        System.out.println(day2);
        System.out.println("=========================");
        System.out.println(day3);
    }



}
