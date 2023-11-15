package christmas.Model.Events;

import static christmas.Constants.DomainConstants.ZERO;
import static christmas.Model.Events.EventDate.WEEKDAY;
import static christmas.Model.Menu.MENU_CATEGORY_DESSERT;

import christmas.Model.FoodOrderDetails;

public class WeekdayDisEvent {
    public static final String EVENT_NAME = "평일 할인";
    private static final Integer WEEKDAY_EVENT_DISCOUNT_UNIT = 2023;

    public Integer applyEvent(FoodOrderDetails foodOrder, String visitDayOfWeek){
        if(WEEKDAY.getDate().contains(visitDayOfWeek)){
            return WEEKDAY_EVENT_DISCOUNT_UNIT *
                    foodOrder.countItemsInCategory(MENU_CATEGORY_DESSERT);
        }
        return ZERO;
    }

}
