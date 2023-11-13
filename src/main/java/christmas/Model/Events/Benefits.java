package christmas.Model.Events;

import christmas.Model.FoodOrderDetails;
import christmas.Model.ReservationDetails;
import java.util.LinkedHashMap;
import java.util.Map;

public class Benefits {
    private Map<String, Integer> benefits;
    public Benefits(){
        this.benefits = new LinkedHashMap<>();
    }
    DDayDisEvent dDayDisEvent = new DDayDisEvent();
    SpecialDisEvent specialDisEvent = new SpecialDisEvent();
    WeekendDisEvent weekendDisEvent = new WeekendDisEvent();
    WeekdayDisEvent weekdayDisEvent = new WeekdayDisEvent();
    GiveAwayEvent giveAwayEvent = new GiveAwayEvent();

    public void applyBenefits(ReservationDetails reservation){
        FoodOrderDetails foodOrder = reservation.getFoodOrderDetails();
        Integer visitDate = reservation.getVisitDate();
        String visitDayOfWeek = reservation.getVisitDayOfWeek();

        benefits.put(DDayDisEvent.EVENT_NAME, dDayDisEvent.applyEvent(visitDate));
        benefits.put(SpecialDisEvent.EVENT_NAME, specialDisEvent.applyEvent(visitDate, visitDayOfWeek));
        benefits.put(WeekdayDisEvent.EVENT_NAME, weekdayDisEvent.applyEvent(foodOrder, visitDayOfWeek));
        benefits.put(WeekendDisEvent.EVENT_NAME, weekendDisEvent.applyEvent(foodOrder, visitDayOfWeek));
        benefits.put(GiveAwayEvent.EVENT_NAME, giveAwayEvent.applyEvent(foodOrder.getPreDiscountTotal()));
    }

    public Integer getTotalBenefitAmount(){
        return benefits.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public String getBadgeForBenefit(){
        return BadgeEvent.findWhichBadgeMatches(getTotalBenefitAmount());
    }

    public Map<String, Integer> getBenefits() {
        return benefits;
    }
}
