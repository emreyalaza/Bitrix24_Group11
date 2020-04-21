package automation.utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeUtilities {
    /**
     * This method returns current date as a string.
     * Provide a format as a parameter
     *
     * MM - to specify month like: 01, 02, 03,
     * MMM - to specify month like: Jan, Feb, Mar
     *
     * dd - to specify day, like 01, 02, 03
     *
     * yyyy - to specify year like: 2010, 2020
     *
     * @param format for example: MMM dd, yyyy = Mar 29, 2020
     * @return current date as a string
     *
     * https://www.journaldev.com/17899/java-simpledateformat-java-date-format
     */
    public static String getCurrentDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }

    public static String getCurrentTime (String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return simpleDateFormat.format(date);

    }

    /**
     *
     * @param start time
     * @param end time
     * @param format like h:m a
     * @return difference between end time and start time as a long
     */
    public static int getTimeDifference(String start, String end, String format){
        LocalTime startTime= LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime= LocalTime.parse(end, DateTimeFormatter.ofPattern(format));
        //long elapsedMinutes = Duration.between(startTime, endTime).toHours();
        return (int) ChronoUnit.HOURS.between(startTime,endTime);
        //return (int)startTime.until(endTime, ChronoUnit.HOURS);

    }


}
