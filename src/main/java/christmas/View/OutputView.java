package christmas.View;


import christmas.Model.Benefits;
import christmas.Model.FoodOrderDetails;
import christmas.Model.Events.GiveAwayEvent;
import christmas.Model.ReservationDetails;
import java.util.Map;

import static christmas.Constants.DomainConstants.ZERO;
import static christmas.Constants.Message.OutputPromptMsg.COLON;
import static christmas.Constants.Message.OutputPromptMsg.DEC_EVENT_BADGE_NOTICE;
import static christmas.Constants.Message.OutputPromptMsg.FOOD_ORDER_NOTICE;
import static christmas.Constants.Message.OutputPromptMsg.GIVEAWAY_MENU_NOTICE;
import static christmas.Constants.Message.OutputPromptMsg.NO_BENEFIT_HISTORY;
import static christmas.Constants.Message.OutputPromptMsg.PRE_DISCOUNT_TOTAL_NOTICE;
import static christmas.Constants.Message.OutputPromptMsg.UNIT_OF_AMOUNT;
import static christmas.Constants.Message.OutputPromptMsg.UNIT_OF_KOREAN_MONEY;
import static christmas.Constants.Message.OutputPromptMsg.BENEFIT_DETAILS_NOTICE;
import static christmas.Constants.Message.OutputPromptMsg.TOTAL_BENEFIT_MONEY_AMOUNT_NOTICE;
import static christmas.Constants.Message.OutputPromptMsg.MINUS;
import static christmas.Constants.Message.OutputPromptMsg.EXPECTED_PAYMENT_AFTER_DISCOUNT_NOTICE;


public class OutputView {

    public void printWhole(ReservationDetails reservation, Benefits benefits){
        FoodOrderDetails foodOrder = reservation.getFoodOrderDetails();
        boolean isInEvent = reservation.isInEvent();

        printFoodOrderDetails(foodOrder);
        printPreDiscountTotal(foodOrder.getPreDiscountTotal());
        printGiveAwayMenu(benefits.getBenefits());
        printBenefits(isInEvent, benefits.getBenefits());
        printTotalBenefitAmount(isInEvent, benefits.getTotalBenefitAmount());
        printExpectedPaymentAfterDiscount(foodOrder.getPreDiscountTotal(), benefits.getActualDiscountAmount());
        printBadgeEventResult(benefits.getBadgeForBenefit());
    }
    private void printFoodOrderDetails(FoodOrderDetails foodOrder){
        System.out.println(FOOD_ORDER_NOTICE.getMessage());
        for(Map.Entry<String, Integer> entry: foodOrder.getFoodOrderDetails().entrySet()){
            System.out.println(entry.getKey() + String.format(UNIT_OF_AMOUNT.getMessage(), entry.getValue()));
        }
    }

    private void printPreDiscountTotal(Integer preDisCountTotal){
        System.out.println(PRE_DISCOUNT_TOTAL_NOTICE.getMessage());
        System.out.println(String.format(UNIT_OF_KOREAN_MONEY.getMessage(), preDisCountTotal));
    }

    private void printBenefits(boolean isInEvent, Map<String, Integer> benefits){
        System.out.println(BENEFIT_DETAILS_NOTICE.getMessage());
        if(isInEvent){
            printBenefitNameAndAmount(benefits);
            return;
        }
        System.out.println(NO_BENEFIT_HISTORY.getMessage());
    }

    private void printBenefitNameAndAmount(Map<String, Integer> benefits){
        for(Map.Entry<String, Integer> entry: benefits.entrySet()){
            if(!entry.getValue().equals(ZERO)){
                System.out.println(entry.getKey() + COLON.getMessage()
                        + MINUS.getMessage() + String.format(UNIT_OF_KOREAN_MONEY.getMessage(), entry.getValue()));
            }
        }
    }

    private void printGiveAwayMenu(Map<String, Integer> benefits) {
        System.out.println(GIVEAWAY_MENU_NOTICE.getMessage());
        if (!benefits.get(GiveAwayEvent.EVENT_NAME).equals(ZERO)) {
            System.out.println(GiveAwayEvent.getGiveAwayMenu().getMenuKoreanName()
                    + String.format(UNIT_OF_AMOUNT.getMessage(), 1));
            return;
        }
        System.out.println(NO_BENEFIT_HISTORY.getMessage());
    }

    private void printTotalBenefitAmount(boolean isInEvent, Integer totalBenefitAmount){
        System.out.println(TOTAL_BENEFIT_MONEY_AMOUNT_NOTICE.getMessage());
        if(isInEvent){
            System.out.println(MINUS.getMessage()
                    + String.format(UNIT_OF_KOREAN_MONEY.getMessage(), totalBenefitAmount));
            return;
        }
        System.out.println(NO_BENEFIT_HISTORY.getMessage());
    }

    private void printExpectedPaymentAfterDiscount(Integer preDiscountTotal, Integer totalBenefitAmount){
        System.out.println(EXPECTED_PAYMENT_AFTER_DISCOUNT_NOTICE.getMessage());
        System.out.println(String.format(UNIT_OF_KOREAN_MONEY.getMessage(), preDiscountTotal - totalBenefitAmount));
    }

    private void printBadgeEventResult(String badgeName){
        System.out.println(DEC_EVENT_BADGE_NOTICE.getMessage());
        System.out.println(badgeName);
    }
}
