package SportPlanner;

public class Exercise {

    private String name; // exercise name
    private double time; // exercise time in seconds
    private int reps; // number of repetitions in exercise

    public Exercise(ExerciseBuilder exerciseBuilder){
        this.name = exerciseBuilder.name;
        this.time = exerciseBuilder.time;
        this.reps = exerciseBuilder.reps;
    }

    public Exercise(String name, double time, int reps) {
        setName(name);
        setTime(time);
        setReps(reps);
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public int getReps() {
        return reps;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public static class ExerciseBuilder {
        private String name;
        private double time;
        private int reps;

        public ExerciseBuilder(final String name) {
            this.name = name;
        }

        public ExerciseBuilder time(final double time) {
            this.time = time;
            return this;
        }

        public ExerciseBuilder reps(final int reps) {
            this.reps = reps;
            return this;
        }

        public Exercise buildExercise() {
            return new Exercise(this);
        }
    }

    @Override
    public String toString() {
        return "Selected Exercise"
                + "\n" + "Name: " + name
                + "\n" + "Time: " + time
                + "\n" + "Reps: " + reps;
    }
}
