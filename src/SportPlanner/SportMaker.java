package SportPlanner;

public class SportMaker {
    public static void main(String[] args) {
        DistanceTrainingMaker director = new DistanceTrainingMaker();
        DistanceSportBuilder builder = new DistanceTrainingBuilder();
        director.setDistanceSport(builder);
        director.makeDistanceSport(1000, 1000, 500);
        DistanceTraining training = director.getDistanceSport();

        System.out.println(training);
    }
}
