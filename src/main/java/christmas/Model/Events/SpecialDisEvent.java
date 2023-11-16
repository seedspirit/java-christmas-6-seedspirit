package christmas.Model.Events;

import static christmas.Model.Events.EventDate.SPECIAL_DAY;
import static christmas.Constants.DomainConstants.CHRISTMAS_DAY;
import static christmas.Constants.DomainConstants.ZERO;

import java.util.List;

public class SpecialDisEvent {
    private List<String> eventDate = SPECIAL_DAY.getDate();
    public static final String EVENT_NAME = "특별 할인";
    private static final Integer DISCOUNT_BASIC = 1000;
    public Integer applyEvent(Integer visitDate, String visitDayOfWeek){
        if(visitDate.equals(CHRISTMAS_DAY) || eventDate.contains(visitDayOfWeek)){
            return DISCOUNT_BASIC;
        }
        return ZERO;
    }
}
