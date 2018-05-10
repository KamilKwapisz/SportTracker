import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

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

        private int timeMonthly; // in minutes
        private int distanceMonthly; // in meters
        private double avgSpeedMonthly; // in m/min

        public int getTimeMonthly(){return this.timeMonthly;}
        public int getDistanceMonthly(){return this.distanceMonthly;}
        public double getAvgSpeedMonthly(){return this.avgSpeedMonthly;}

        public void setTimeMonthly(int timeMonthly) { this.timeMonthly = timeMonthly; }
        public void setDistanceMonthly(int distanceMonthly) { this.distanceMonthly = distanceMonthly; }
        public void setAvgSpeedMonthly(double avgSpeed1) { this.avgSpeedMonthly = avgSpeed1; }
    }

    private class FitnessTrainingStats{
        private int time; // in minutes
        private int reps; // in meters

        public int getTime(){return this.time;}
        public int getReps(){return this.reps;}

        public void setTime(int time) { this.time = time; }
        public void setReps(int reps) { this.reps = reps; }

        private int timeMonthly; // in minutes
        private int repsMonthly; // in meters

        public int getTimeMonthly(){return this.timeMonthly;}
        public int getRepsMonthly(){return this.repsMonthly;}

        public void setTimeMonthly(int time) { this.timeMonthly = time; }
        public void setRepsMonthly(int reps) { this.repsMonthly = reps; }
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


    public void getDistanceTrainingStatsMonthly(String username){
        try {
            String[][] result;
            StringBuilder query = new StringBuilder("");

            int timeMonthly = 0; // in minutes
            int distanceMonthly = 0; // in meters
            String monthAndYear = getCurrentMonthAndYear();
            // fetching training time
            if (username != null) {
                query.append("Select dt.time from DistanceTraining dt join users u on (u.login=dt.login) where u.login='");
                query.append(username).append("'");
                query.append(" and date like '__").append(monthAndYear).append("'");

            } else {
                query.append("Select dt.time from DistanceTraining dt");
                query.append(" where date like '__").append(monthAndYear).append("'");
            }
            result = serv.customQuery(query.toString());


            for (String[] row : result)
                for (String timeStr : row)
                    timeMonthly += Integer.parseInt(timeStr);

            // fetching training distance
            String newQuery = query.toString().replace("dt.time", "dt.distance");
            result = serv.customQuery(newQuery);
            for (String[] row : result)
                for (String distStr : row)
                    distanceMonthly += Integer.parseInt(distStr);

            distanceTrainingStats.setDistanceMonthly(distanceMonthly);
            distanceTrainingStats.setTimeMonthly(timeMonthly);
            distanceTrainingStats.setAvgSpeed((double)distanceMonthly/(double)timeMonthly);

        } catch (NullPointerException ex) {
            System.out.println("User " + username + " has no trainings done");
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

    public void getFitnessStatsMonthly(String username){
        try {
            String[][] result;
            StringBuilder query = new StringBuilder("");

            int repsMonthly = 0;

            String monthAndYear = getCurrentMonthAndYear();

            // fetching repetitions number in month
            if (username != null) {
                query.append("Select ft.repeats from FitnessTraining ft join users u on (u.login=ft.login) where u.login='");
                query.append(username).append("'");
                query.append(" and date like '__").append(monthAndYear).append("'");
            } else {
                query.append("Select ft.time from FitnessTraining ft");
                query.append(" where date like '__").append(monthAndYear).append("'");
            }
            result = serv.customQuery(query.toString());

            for (String[] row : result)
                for (String repsStr : row)
                    repsMonthly += Integer.parseInt(repsStr);

            // fetching training distance
            String newQuery = query.toString().replace("dt.time", "dt.distance");
            result = serv.customQuery(newQuery);
            for (String[] row : result)
                for (String distStr : row)
                    repsMonthly += Integer.parseInt(distStr);

            fitnessTrainingStats.setRepsMonthly(repsMonthly);

        } catch (NullPointerException ex) {
            System.out.println("User " + username + " has no trainings done");
        }

    }

    // metody dostępowe do statystyk

    public String getTrainingTime(){
        return "" + distanceTrainingStats.getTime();
    }

    public String getTrainingTimeMonthly(){
        return "" + distanceTrainingStats.getTimeMonthly();
    }

    public String getTrainingDistance(){
        return "" + distanceTrainingStats.getDistance();
    }

    public String getTrainingDistanceMonthly(){
        return "" + distanceTrainingStats.getDistanceMonthly();
    }

    public String getTrainingAvgSpeed(){
        return "" + distanceTrainingStats.getAvgSpeed();
    }

    public String getTrainingReps(){
        return "" + fitnessTrainingStats.getReps();
    }

    public String getTrainingRepsMonthly(){
        return "" + fitnessTrainingStats.getRepsMonthly();
    }

    public String getTrainingAvgSpeedMonthly(){
        return "" + distanceTrainingStats.getAvgSpeedMonthly();
    }

    public static String getCurrentMonthAndYear(){
        int monthNumber = Calendar.getInstance().get(Calendar.MONTH)+1;
        String thisMonth = "";
        if( monthNumber < 10)
            thisMonth += "0";
        thisMonth += monthNumber;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return thisMonth + year;
    }

    public static void main(String[] args) {
        Statistics statistics = new Statistics(null);
        System.out.println(statistics.getTrainingAvgSpeed());
        System.out.println(statistics.getTrainingReps());
        System.out.println(statistics.getTrainingReps());
        System.out.println(statistics.getTrainingAvgSpeedMonthly());

    }

}