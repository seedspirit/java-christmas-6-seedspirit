package christmas.Model.Events;

import java.util.Arrays;
import java.util.List;

public enum EventDate {
    WEEKDAY(Arrays.asList("Sun", "Mon", "Tue", "Wed", "Thu")),
    WEEKEND(Arrays.asList("Fri", "Sat")),
    SPECIAL_DAY(Arrays.asList("Sun"));

    List<String> date;
    EventDate(List<String> date){
        this.date = date;
    }

    public List<String> getDate() {
        return date;
    }
}
