package christmas.Model.Events;

import static christmas.Constants.DomainConstants.ZERO;
import static christmas.Model.Events.EventDate.WEEKEND;
import static christmas.Model.Menu.MENU_CATEGORY_MAIN;

import christmas.Model.FoodOrderDetails;

public class WeekendDisEvent {
    public static final String EVENT_NAME = "주말 할인";
    private static final Integer WEEKEND_EVENT_DISCOUNT_UNIT = 2023;

    public Integer applyEvent(FoodOrderDetails foodOrder, String visitDayOfWeek){
        if(WEEKEND.getDate().contains(visitDayOfWeek)){
            return WEEKEND_EVENT_DISCOUNT_UNIT *
                    foodOrder.countItemsInCategory(MENU_CATEGORY_MAIN);
        }
        return ZERO;
    }
}
