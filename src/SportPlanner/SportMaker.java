package SportPlanner;

public class SportMaker {
    public static void main(String[] args) {

        // Distance SportPlanner.FitnessTraining

        DistanceTrainingMaker distanceDirector = new DistanceTrainingMaker();
        DistanceSportBuilder distanceBuilder = new DistanceTrainingBuilder();
        distanceDirector.setDistanceTraining(distanceBuilder);
        distanceDirector.makeDistanceTraining(1000, 1000, 500);
        DistanceTraining distanceTraining = distanceDirector.getDistanceTraining();

        System.out.println(distanceTraining);


        // FitnessTraining

        FitnessTrainingMaker fitnessDirector = new FitnessTrainingMaker();
        FitnessSportBuilder fitnessBuilder = new FitnessTrainingBuilder();
        fitnessDirector.setFitnessTraining(fitnessBuilder);

        Exercise exercise1 = new Exercise.ExerciseBuilder("Hitching")
                .time(120)
                .reps(20)
                .buildExercise();



        Exercise exercise2 = new Exercise.ExerciseBuilder("Push Ups")
                .time(30)
                .reps(10)
                .buildExercise();

        fitnessDirector.makeFitnessTraining(150, 400, 2);
        fitnessDirector.makeExercise(exercise2);
        fitnessDirector.makeExercise(exercise1);

        FitnessTraining fitnessTraining = fitnessDirector.getFitnessTraining();
        System.out.println("\n" + fitnessTraining);
    }
}
