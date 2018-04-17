import SportPlanner.*;
import SportPlanner.DistanceTraining;

public class BuilderThatActuallySucks {
    DistanceTrainingMaker distanceDirector;
    FitnessTrainingMaker fitnessDirector;


    public DistanceTraining getDistanceTraining(double distance, double time, double calories) {
        this.distanceDirector = new DistanceTrainingMaker();
        this.distanceDirector.setDistanceTraining(new DistanceTrainingBuilder());
        this.distanceDirector.makeDistanceTraining(distance, time, calories);
        return this.distanceDirector.getDistanceTraining();
    }

    public FitnessTraining getFitnessTraining(double time, double calories, int exerciseNumber, Exercise[] exercises) {
        this.fitnessDirector = new FitnessTrainingMaker();
        this.fitnessDirector.setFitnessTraining(new FitnessTrainingBuilder());
        this.fitnessDirector.makeFitnessTraining(time, calories, exerciseNumber);

        for(Exercise exercise : exercises) {
            this.fitnessDirector.makeExercise(exercise);
        }

        return this.fitnessDirector.getFitnessTraining();
    }

    public Exercise getExercise(String name, double time, int reps) {
        return new Exercise.ExerciseBuilder(name)
                .time(time)
                .reps(reps)
                .buildExercise();
    }

    public static void main(String[] args) {
        BuilderThatActuallySucks myBuilder = new BuilderThatActuallySucks();

        System.out.println(
                myBuilder.getDistanceTraining(
                        1000,
                        1000,
                        500
                )
        );

        FitnessTraining exerciseArray = new FitnessTraining(4); // zawiera tablicę potrzebną do przechowywania ćwiczeń

        exerciseArray.addExercise(
                myBuilder.getExercise("Pompki", 100, 10)
        );

        exerciseArray.addExercise(
                myBuilder.getExercise("Przysiady", 100, 15)
        );

        exerciseArray.addExercise(
                myBuilder.getExercise("Brzuszki", 120, 12)
        );

        exerciseArray.addExercise(
                myBuilder.getExercise("Podciągnięcia", 60, 4)
        );

        System.out.println("\n" +
                myBuilder.getFitnessTraining(
                        380,
                        400,
                        4,
                        exerciseArray.getExercises()
                )
        );
    }
}
