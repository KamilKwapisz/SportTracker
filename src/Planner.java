public class Planner {

    private Day [] days;
    private int n; // days number

    public Planner(){
        days = new Day[30];
    }

    public Planner(int daysNumber){
        days = new Day[daysNumber];
    }

    public void addDay(Day day){
        if( n == days.length )
            doubleSize();
        days[n++] = day;
    }

    private void doubleSize() {
        Day [] newDays = new Day[2*days.length];
        for( int i= 0; i < n; i++ )
            newDays[i] = days[i];
        days = newDays;
    }

    public int getN(){
        return n;
    }

    public Day[] getDays(){
        return days;
    }

    public Day[] showCalendar(int daysNumber){

        if ( daysNumber >= this.n ){
            Day[] daysToShow = new Day[daysNumber];

            return daysToShow;
        }
        Day[] daysToShow = new Day[n];
        System.arraycopy( days, 0, daysToShow, 0, n );
        return daysToShow;
    }

    public Day [] getDaysSince(String firstDate){
        Day [] newDays = new Day[this.n];
        int index = 0;
        for(int i = 0; i < this.n; i++){
            if(days[i].isLater(firstDate))
                newDays[index++] = days[i];
        }
        return newDays;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n; i++)
            sb.append(days[i]).append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        Day d1 = new Day("19.04.2018");
        Day d2 = new Day("20.04.2018");
        Day d3 = new Day("12.04.2018");

        Planner planner = new Planner(3);
        planner.addDay(d1);
        planner.addDay(d2);
        planner.addDay(d3);

        Day [] days = new Day[3];
        days = planner.getDaysSince("11.04.2018"); // get days which are later than given date from planner
        for(Day d: days)
            System.out.println(d);
    }

}
