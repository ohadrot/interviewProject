package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static String dateOfToday(){
        String pattern = "dd.MM.yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    } //return the date of today

    public static boolean CheckTheDateFormat(String s){
        if(s.length() != 8)
            return false;
        String one = s.substring(2,3);
        String second = s.substring(5,6);
        if(s.substring(2,3).contains(".") && Integer.parseInt(s.substring(0,2))<32)
        {
            if(s.substring(5,6).contains(".") && Integer.parseInt(s.substring(3,5))<13) {

                return true;
            }
        }
        return false;
    }

    public static int CalculateDaysOfRent(String start, String end) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yy");
        Date date1 = myFormat.parse(start);
        Date date2 = myFormat.parse(end);
        long diff = date2.getTime() - date1.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
