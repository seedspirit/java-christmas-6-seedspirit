package christmas.Model.Events;

import static christmas.Constants.DomainConstants.ZERO;
import static christmas.Model.Menu.CHAMPAGNE;

import christmas.Model.Menu;

public class GiveAwayEvent {

    public static final String EVENT_NAME = "증정 이벤트";
    private static final Integer MIN_GIVE_AWAY_EVENT_PARTICIPATION_FEE = 120_000;
    private static final Menu GIVE_AWAY_MENU = CHAMPAGNE;

    public Integer applyEvent(Integer totalPreDiscountTotal){
        if(totalPreDiscountTotal >= MIN_GIVE_AWAY_EVENT_PARTICIPATION_FEE){
            return GIVE_AWAY_MENU.getPrice();
        }
        return ZERO;
    }

    public static Menu getGiveAwayMenu() {
        return GIVE_AWAY_MENU;
    }
}

