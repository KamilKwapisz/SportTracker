package core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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

    public TrainingDay getDay(int index) throws IndexOutOfBoundsException {
        try{
            return trainingDays.get(index);
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("There are only " + trainingDays.size() + " elements in the list.");
        }

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

    public static List<String> getDaysBetweenDates(String startDateString, String endDateString) throws IllegalArgumentException
    {
        List<String> dates = new ArrayList<>();
        DateFormat formatter;
        Date startdate, enddate;
        TrainingDay td = new TrainingDay();
        td.validateDateFormat(startDateString);
        td.validateDateFormat(endDateString);
        formatter = new SimpleDateFormat("dd.MM.yyyy");

        try {
            startdate = formatter.parse(startDateString);
            enddate = formatter.parse(endDateString);

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(startdate);
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");


            while (calendar.getTime().before(enddate))
            {
                Date result = calendar.getTime();
                dates.add(format1.format(result));
                calendar.add(Calendar.DATE, 1);
            }
            return dates;
        } catch (java.text.ParseException e ) {
            return dates;
        }


    }


    public static void main(String[] args) {
        TrainingDay d1 = new TrainingDay("19.04.2018");
        TrainingDay d2 = new TrainingDay("20.04.2018");
        TrainingDay d3 = new TrainingDay("12.04.2018");

        Planner planner = new Planner(3);
        planner.addDay(d1);
        planner.addDay(d2);
        planner.addDay(d3);
//        System.out.println(planner);

        List<String> dates = planner.getDaysBetweenDates("19.04.2018", "28.04.2018");
        System.out.println(dates);
//        dates.forEach(System.out::println);


    }



}
