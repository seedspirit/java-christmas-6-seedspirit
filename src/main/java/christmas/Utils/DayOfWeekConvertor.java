package christmas.Utils;

import static christmas.Constants.DomainConstants.YEAR_2023;

import java.util.Calendar;
import java.util.Locale;

public class DayOfWeekConvertor {
    public static String convert(Integer reserveDate){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, YEAR_2023);
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DATE, reserveDate);
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
    }
}
