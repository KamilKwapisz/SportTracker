import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class TrainingHistory {

    private SQLCommunication serv;

    public TrainingHistory(){
        establishDBConnection();
    }

    public static String getCurrentMonthAndYear(){
        String month = "";
        int monthNumber = Calendar.getInstance().get(Calendar.MONTH)+1;
        if( monthNumber < 10)
            month += "0";
        month += monthNumber;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return month + year;
    }

    private void establishDBConnection(){
        // method that set SQLCommunication class field.
        try {
            this.serv = new SQLCommunication();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
        }
    }

    public void getFitnessTrainingHistory(){
        String[][] result;
        StringBuilder query = new StringBuilder("");
        String date = getCurrentMonthAndYear();
        query.append("select discipline, repeats, date from FitnessTraining where date like '__")
                .append(date).append("'");

        result = serv.customQuery(query.toString());

        for (String[] row : result)
            for (String training : row)
                System.out.println(training);


    }

    public static void main(String[] args) {
        TrainingHistory trainingHistory =  new TrainingHistory();
        trainingHistory.getFitnessTrainingHistory();
    }

}
