import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Calendar2 {
    /*
    * An instance of a Calendar2, used to track desired dates and error checking.
    *
    * The responsability of a Calendar2 is to track the date and check for errors.
    *
    * Attributes:
    *   calendar (Calendar): Used to track the date and its changes.
    */
    private Calendar calendar;

    public Calendar2(){
        /*
        * Creates a basic instance of calendar2
        * Arguments: None
        * Returns: Nothing
        */
        this.calendar = Calendar.getInstance();
    }

    public Calendar getCalendar(){
        /*
        * Returns the calendar
        * Arguments: None
        * Returns: calendar (Calendar)
        */
        return calendar;
    }

    private void setCalendar(int year, int month, int day, int hour, int minutes){
        /*
        * Sets the calendar attribute with a new date.
        * Arguments:
        *   year (int): The year to be set
        *   month (int): The month to be set
        *   day (int): The day to be set
        *   hour (int): The hour to be set
        *   minutes (int): The minutes to be set
        * Returns: Nothing
        */
        this.calendar.set(year, month, day, hour, minutes, 0);
    }

    public Date getDate(){
        /*
        * Gets the date of the calendar.
        * Arguments: None
        * Returns: current date (Date)
        */
        return calendar.getTime();
    }

    public int getInt(String question){
        /*
        * Inputs the user for a number and checks if it's a number.
        * Arguments:
        *   question (String): What will be displayed to the user
        * Returns: number (int)
        */
        int number = 0;
        while (number == 0) {
            Scanner input = new Scanner(System.in);
            System.out.print(question);
            String numberString = input.nextLine();
            try {number = Integer.parseInt(numberString);return number = Integer.parseInt(numberString);}
            catch (NumberFormatException e) {System.out.println("Not a number");}
        }
        return number;
    }

    public void changeDate(){
        /*
        * Inputs for the user to change the date and error checks it.
        * Arguments: None
        * Returns: Nothing
        */
        Boolean stop = false;
        int year = -1;
        int month = -1;
        int day = -1;
        int hour = -1;
        int minutes = -1;
        while (!stop){
            if (year == -1){
                year = getInt("What year do you want? (Ex: 1968): ");
                if (year < 0){
                    System.out.println("Year can't be negative");
                    year = -1;}
            }
            else if(month == -1){
                month = getInt("What month do you want? (1-12): ") - 1;
                if (month < 0 | month > 11){
                    System.out.println("Month out of range");
                    month = -1;
                }
            }
            else if(day == -1){
                Calendar errorCal = new GregorianCalendar(year, month, 1);
                int daysInMonth = errorCal.getActualMaximum(Calendar.DAY_OF_MONTH);
                day = getInt("What day do you want? (1-" + daysInMonth + "): ");
                if (day < 1 | day > daysInMonth){
                    System.out.println("Day out of range");
                    day = -1;
                }
            }
            else if(hour == -1){
                hour = getInt("What hour do you want? (0-23): ");
                if (hour < 0 | hour > 23){
                    System.out.println("Hour out of range");
                    hour = -1;
                }
            }
            else if(minutes == -1){
                minutes = getInt("What minutes do you want? (0-59): ");
                if (minutes < 0 | minutes > 59){
                    System.out.println("Minutes out of range");
                    minutes = -1;
                }
                else{
                    stop = true;
                }
            }
        }
        setCalendar(year, month, day, hour, minutes);
    }
}
