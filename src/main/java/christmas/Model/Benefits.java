package christmas.Model;

import static christmas.Constants.DomainConstants.ZERO;

import christmas.Model.Events.BadgeEvent;
import christmas.Model.Events.DDayDisEvent;
import christmas.Model.Events.GiveAwayEvent;
import christmas.Model.Events.SpecialDisEvent;
import christmas.Model.Events.WeekdayDisEvent;
import christmas.Model.Events.WeekendDisEvent;
import christmas.Model.FoodOrderDetails;
import christmas.Model.ReservationDetails;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

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

    public void apply(ReservationDetails reservation){
        initializeBenefits();

        if(reservation.isInEvent()) {
            applyBenefits(reservation);
        }
    }

    private void initializeBenefits(){
        benefits.put(DDayDisEvent.EVENT_NAME, ZERO);
        benefits.put(WeekdayDisEvent.EVENT_NAME, ZERO);
        benefits.put(WeekendDisEvent.EVENT_NAME, ZERO);
        benefits.put(SpecialDisEvent.EVENT_NAME, ZERO);
        benefits.put(GiveAwayEvent.EVENT_NAME, ZERO);
    }

    private void applyBenefits(ReservationDetails reservation){
        FoodOrderDetails foodOrder = reservation.getFoodOrderDetails();
        Integer visitDate = reservation.getVisitDate();
        String visitDayOfWeek = reservation.getVisitDayOfWeek();

        benefits.put(DDayDisEvent.EVENT_NAME, dDayDisEvent.applyEvent(visitDate));
        benefits.put(WeekdayDisEvent.EVENT_NAME, weekdayDisEvent.applyEvent(foodOrder, visitDayOfWeek));
        benefits.put(WeekendDisEvent.EVENT_NAME, weekendDisEvent.applyEvent(foodOrder, visitDayOfWeek));
        benefits.put(SpecialDisEvent.EVENT_NAME, specialDisEvent.applyEvent(visitDate, visitDayOfWeek));
        benefits.put(GiveAwayEvent.EVENT_NAME, giveAwayEvent.applyEvent(foodOrder.getPreDiscountTotal()));
    }

    public Integer getTotalBenefitAmount(){
        return benefits.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public Integer getActualDiscountAmount(){
        return benefits.entrySet().stream()
                .filter(benefits -> !GiveAwayEvent.EVENT_NAME.equals(benefits.getKey()))
                .mapToInt(Entry::getValue)
                .sum();
    }

    public String getBadgeForBenefit(){
        return BadgeEvent.findWhichBadgeMatches(getTotalBenefitAmount());
    }

    public Map<String, Integer> getBenefits() {
        return benefits;
    }
}
