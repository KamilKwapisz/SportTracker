import java.io.IOException;
import java.sql.SQLException;

public class Statistics {

    public Statistics(String username){
        establishDBConnection();
        getDistanceTrainingStats(username);
        getFitnessTrainingStats(username);

    }

    private class DistanceTrainingStats{
        private int time; // in minutes
        private int distance; // in meters
        private double avgSpeed; // in m/min

        public int getTime(){return this.time;}
        public int getDistance(){return this.distance;}
        public double getAvgSpeed(){return this.avgSpeed;}

        public void setTime(int time) { this.time = time; }
        public void setDistance(int distance) { this.distance = distance; }
        public void setAvgSpeed(double avgSpeed1) { this.avgSpeed = avgSpeed1; }
    }

    private class FitnessTrainingStats{
        private int time; // in minutes
        private int reps; // in meters

        public int getTime(){return this.time;}
        public int getReps(){return this.reps;}

        public void setTime(int time) { this.time = time; }
        public void setReps(int reps) { this.reps = reps; }
    }

    private DistanceTrainingStats distanceTrainingStats =  new DistanceTrainingStats();
    private FitnessTrainingStats fitnessTrainingStats=  new FitnessTrainingStats();
    private SQLCommunication serv;

    private void establishDBConnection(){
        // method that set SQLCommunication class field.
        try {
            serv = new SQLCommunication();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
        }
    }


    public void getDistanceTrainingStats(String username){
        try {
            String[][] result;
            StringBuilder query = new StringBuilder("");

            int time = 0; // in minutes
            int distance = 0; // in meters

            // fetching training time
            if (username != null) {
                query.append("Select dt.time from DistanceTraining dt join users u on (u.login=dt.login) where u.login='");
                query.append(username).append("'");
            } else
                query.append("Select dt.time from DistanceTraining dt");
            result = serv.customQuery(query.toString());


            for (String[] row : result)
                for (String timeStr : row)
                    time += Integer.parseInt(timeStr);

            // fetching training distance
            String newQuery = query.toString().replace("dt.time", "dt.distance");
            result = serv.customQuery(newQuery);
            for (String[] row : result)
                for (String distStr : row)
                    distance += Integer.parseInt(distStr);

            distanceTrainingStats.setDistance(distance);
            distanceTrainingStats.setTime(time);
            distanceTrainingStats.setAvgSpeed((double)distance/(double)time);

        } catch (NullPointerException ex) {
            System.out.println("User " + username + " has no trainings done");
        }
    }

    public void getFitnessTrainingStats(String username){
        try {
            String[][] result;
            StringBuilder query = new StringBuilder("");

            int reps = 0;

            // fetching repetitions number
            if (username != null) {
                query.append("Select ft.repeats from FitnessTraining ft join users u on (u.login=ft.login) where u.login='");
                query.append(username).append("'");
            } else
                query.append("Select ft.time from FitnessTraining ft");
            result = serv.customQuery(query.toString());

            for (String[] row : result)
                for (String repsStr : row)
                    reps += Integer.parseInt(repsStr);

            // fetching training distance
            String newQuery = query.toString().replace("dt.time", "dt.distance");
            result = serv.customQuery(newQuery);
            for (String[] row : result)
                for (String distStr : row)
                    reps += Integer.parseInt(distStr);

            fitnessTrainingStats.setReps(reps);

        } catch (NullPointerException ex) {
            System.out.println("User " + username + " has no trainings done");
        }
    }

    public String getTrainingTime(){
        StringBuilder sb = new StringBuilder("");
        sb.append(distanceTrainingStats.getTime());
        return sb.toString();
    }

    public String getTrainingDistance(){
        StringBuilder sb = new StringBuilder("");
        sb.append(distanceTrainingStats.getDistance());
        return sb.toString();
    }

    public String getTrainingAvgSpeed(){
        StringBuilder sb = new StringBuilder("");
        sb.append(distanceTrainingStats.getAvgSpeed());
        return sb.toString();
    }

    public String getTrainingReps(){
        StringBuilder sb = new StringBuilder("");
        sb.append(fitnessTrainingStats.getReps());
        return sb.toString();
    }


    public static void main(String[] args) {
        Statistics statistics = new Statistics(null);
        System.out.println(statistics.getTrainingAvgSpeed());
        System.out.println(statistics.getTrainingReps());

    }

}