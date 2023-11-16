package christmas.Model;

import static christmas.Constants.DomainConstants.MIN_PARTICIPATION_FEE;

import christmas.Utils.DayOfWeekConvertor;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReservationDetails {
    private FoodOrderDetails foodOrderDetails;
    private Integer visitDate;
    private String visitDayOfWeek;
    private boolean inEvent;

    public ReservationDetails(FoodOrderDetails foodOrderDetails, Integer visitDate){
        this.foodOrderDetails = foodOrderDetails;
        this.visitDate = visitDate;
        this.visitDayOfWeek = DayOfWeekConvertor.convert(visitDate);
        this.inEvent = foodOrderDetails.getPreDiscountTotal() >= MIN_PARTICIPATION_FEE;
    }

    public FoodOrderDetails getFoodOrderDetails() {
        return foodOrderDetails;
    }

    public Integer getVisitDate() {
        return visitDate;
    }

    public String getVisitDayOfWeek() {
        return visitDayOfWeek;
    }

    public boolean isInEvent() {
        return inEvent;
    }
}
