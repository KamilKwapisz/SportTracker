public class Planner {

    private Day [] days; // tymczasowo, domyślnie będzie tu tablica treningów
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n; i++)
            sb.append(days[i]).append("\n");
        return sb.toString();
    }

}
