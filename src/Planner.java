import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Planner {

    private ArrayList<TrainingDay> trainingDays;

    public Planner(){
        trainingDays = new ArrayList<TrainingDay>();
    }

    public Planner(int daysNumber){
        trainingDays = new ArrayList<TrainingDay>(daysNumber);
    }

    public void addDay(TrainingDay trainingDay){
        trainingDays.add(trainingDay);
    }

    public ArrayList<TrainingDay> getTrainingDays(){
        return trainingDays;
    }

    public ArrayList<TrainingDay> showCalendar(int daysNumber){

        return trainingDays;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < trainingDays.size(); i++)
            sb.append(trainingDays.get(i)).append("\n");
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
        System.out.println(planner);

        List<String> dates = planner.getDaysBetweenDates("19.04.2018", "28.04.2018");
//        dates.forEach(System.out::println);


    }

}
