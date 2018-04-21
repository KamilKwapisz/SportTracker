import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Planner {

    private TrainingDay[] trainingDays;
    private int n; // trainingDays number

    public Planner(){
        trainingDays = new TrainingDay[30];
    }

    public Planner(int daysNumber){
        trainingDays = new TrainingDay[daysNumber];
    }

    public void addDay(TrainingDay trainingDay){
        if( n == trainingDays.length )
            doubleSize();
        trainingDays[n++] = trainingDay;
    }

    private void doubleSize() {
        TrainingDay[] newTrainingDays = new TrainingDay[2* trainingDays.length];
        for( int i= 0; i < n; i++ )
            newTrainingDays[i] = trainingDays[i];
        trainingDays = newTrainingDays;
    }

    public int getN(){
        return n;
    }

    public TrainingDay[] getTrainingDays(){
        return trainingDays;
    }

    public TrainingDay[] showCalendar(int daysNumber){

        if ( daysNumber >= this.n ){
            TrainingDay[] daysToShow = new TrainingDay[daysNumber];

            return daysToShow;
        }
        TrainingDay[] daysToShow = new TrainingDay[n];
        System.arraycopy(trainingDays, 0, daysToShow, 0, n );
        return daysToShow;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n; i++)
            sb.append(trainingDays[i]).append("\n");
        return sb.toString();
    }

    public static List<String> getDaysBetweenDates(String startDateString, String endDateString)
    {
        DateFormat formatter;
        Date startdate, enddate;
        formatter = new SimpleDateFormat("dd.mm.yyyy");

        try {
            startdate = formatter.parse(startDateString);
            enddate = formatter.parse(endDateString);
            List<String> dates = new ArrayList<>();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(startdate);


            while (calendar.getTime().before(enddate))
            {
                Date result = calendar.getTime();
                dates.add(result.toString());
                calendar.add(Calendar.DATE, 1);
            }
            return dates;
        } catch (java.text.ParseException e ) {
            System.out.println("Blad");
        }
        List<String> dates = new ArrayList<>();
        dates.add("blad");
        return dates;

    }

    public static void main(String[] args) {
        TrainingDay d1 = new TrainingDay("19.04.2018");
        TrainingDay d2 = new TrainingDay("20.04.2018");
        TrainingDay d3 = new TrainingDay("12.04.2018");

        Planner planner = new Planner(3);
        planner.addDay(d1);
        planner.addDay(d2);
        planner.addDay(d3);

        List<String> dates = planner.getDaysBetweenDates("19.04.2018", "28.04.2018");
        dates.forEach(System.out::println);


    }

}
