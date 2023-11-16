package christmas.Constants.Message;

import christmas.View.OutputView;

public enum OutputPromptMsg {
    UNIT_OF_AMOUNT(" %d개"),
    UNIT_OF_KOREAN_MONEY("%,d원"),
    MINUS("-"),
    NO_BENEFIT_HISTORY("없음"),
    COLON(": "),
    FOOD_ORDER_NOTICE("\n<주문 메뉴>"),
    PRE_DISCOUNT_TOTAL_NOTICE("\n<할인 전 총주문 금액>"),
    GIVEAWAY_MENU_NOTICE("\n<증정 메뉴>"),
    BENEFIT_DETAILS_NOTICE("\n<혜택 내역>"),
    TOTAL_BENEFIT_MONEY_AMOUNT_NOTICE("\n<총혜택 금액>"),
    EXPECTED_PAYMENT_AFTER_DISCOUNT_NOTICE("\n<할인 후 예상 결제 금액>"),
    DEC_EVENT_BADGE_NOTICE("\n<12월 이벤트 배지>");

    private String message;

    OutputPromptMsg(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
