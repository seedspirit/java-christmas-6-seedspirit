package christmas.Model.Events;

import static christmas.Constants.DomainConstants.CHRISTMAS_DAY;
import static christmas.Constants.DomainConstants.ZERO;

public class DDayDisEvent {
    public static final String EVENT_NAME = "크리스마스 디데이 할인";
    private static final Integer DISCOUNT_BASIC = 1000;
    private static final Integer DISCOUNT_UNIT = 100;

    public Integer applyEvent(Integer reserveDate){
        if(reserveDate <= CHRISTMAS_DAY){
            return DISCOUNT_BASIC + (reserveDate - 1) * DISCOUNT_UNIT;
        }
        return ZERO;
    }
}
