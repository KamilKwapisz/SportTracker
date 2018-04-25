import java.io.IOException;
import java.sql.SQLException;

public class Statistics {

//    private double totalTime; // total training time in seconds
//    private double totalDistance; // total distance from running and cycling in meters;
//    private int repsNumber; // number of repetitions from all trainings
//    private String sport; // sport type

//    public Statistics(String sportName){
//        this.totalDistance = 0.0;
//        this.totalTime = 0.0;
//        this.repsNumber = 0;
//        this.sport = sportName;
//    }

//    public double getTotalTime() {
//        return totalTime;
//    }

//    public double getTotalDistance() {
//        return totalDistance;
//    }

    public int getRepsNumber(String username) {
        try {
            SQLCommunication serv = new SQLCommunication();

            String[][] result;
            int reps = 0;
            if (username != null) {
                StringBuilder sb = new StringBuilder("Select ft.repeats from FitnessTraining ft join users u on (u.login=ft.login) where u.login='");
                sb.append(username).append("'");
                result = serv.customQuery(sb.toString());
            } else
                result = serv.customQuery("Select ft.repeats from FitnessTraining ft");
            for (String[] row : result)
                for (String repetitions : row)
                    reps += Integer.parseInt(repetitions);

            return reps;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
            return 0;
        } catch (IOException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
            return 0;
        }
    }

//    public String getSport() {
//        return sport;
//    }


//    public double calculateAvgSpeed(){
//        double speed = this.totalDistance / this.totalTime;
//        return speed;
//    }

//    @Override
//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        sb.append(this.sport)
//                .append("time= ").append(this.totalTime).append("s, ")
//                .append("distance = ").append(this.totalDistance).append("m, ")
//                .append("reps = ").append(this.repsNumber);
//        return sb.toString();
//    }

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        System.out.println(statistics.getRepsNumber(null));
        System.out.println(statistics.getRepsNumber("JavaLogin"));
    }

}
