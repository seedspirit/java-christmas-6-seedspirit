package christmas.Constants.Message.ExceptionMsg;

public enum OrderErrorMsg {
    ASK_NO_EMPTY_INPUT("빈칸은 허용되지 않습니다. 메뉴와 주문 수량을 입력해주세요."),
    ASK_NO_WHITE_SPACE("공백 없이 숫자를 입력해주세요. 메뉴와 주문 수량을 입력해주세요."),
    ASK_ORDER_INPUT_IN_VALID_FORMAT("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String message;

    OrderErrorMsg(String message){
        this.message = PrefixMsg.ERROR_MSG.getMessage() + message;
    }

    public String getMessage() {
        return message;
    }
}
