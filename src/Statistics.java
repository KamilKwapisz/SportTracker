import java.io.IOException;
import java.sql.SQLException;

public class Statistics {

    public int getTime(String username){
        try {
            SQLCommunication serv = new SQLCommunication();

            String[][] result;
            int time = 0; // in minutes

            if (username != null) {
                StringBuilder sb = new StringBuilder("Select dt.time from DistanceTraining dt join users u on (u.login=dt.login) where u.login='");
                sb.append(username).append("'");
                result = serv.customQuery(sb.toString());
            } else
                result = serv.customQuery("Select dt.time from DistanceTraining dt");
            for (String[] row : result)
                for (String timeStr : row)
                    time += Integer.parseInt(timeStr);

            return time;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
            return 1;
        } catch (IOException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
            return 1;
        }
    }

    public int getDistance(String username){
        try {
            SQLCommunication serv = new SQLCommunication();

            String[][] distanceResult;
            int dist = 0; // in meters

            if (username != null) {
                StringBuilder sb = new StringBuilder("Select dt.distance from DistanceTraining dt join users u on (u.login=dt.login) where u.login='");
                sb.append(username).append("'");
                distanceResult = serv.customQuery(sb.toString());
            } else
                distanceResult = serv.customQuery("Select dt.distance from DistanceTraining dt");
            for (String[] row : distanceResult)
                for (String distStr : row)
                    dist += Integer.parseInt(distStr);

            return dist;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
            return 0;
        } catch (IOException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
            return 0;
        }
    }

    public double getAvgSpeed(String username){
        double avgSpeed; // in m/min
        avgSpeed = (double)getDistance(username) / (double)getTime(username);
        return avgSpeed;
    }

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

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        System.out.println(statistics.getRepsNumber(null));
        System.out.println(statistics.getRepsNumber("JavaLogin"));

        System.out.println(statistics.getDistance(null));
        System.out.println(statistics.getTime(null));
        System.out.println(statistics.getAvgSpeed(null));
    }

}
