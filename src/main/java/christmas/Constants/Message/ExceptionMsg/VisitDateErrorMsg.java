package christmas.Constants.Message.ExceptionMsg;

public enum VisitDateErrorMsg {

    ASK_NO_EMPTY_INPUT("빈칸은 허용되지 않습니다. 1~31 사이의 숫자를 입력해주세요"),
    ASK_NO_WHITE_SPACE("공백 없이 숫자를 입력해주세요. 1~31 사이의 숫자를 입력해주세요"),
    ASK_VISIT_DATE_INPUT_IN_VALID_FORMAT("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private String message;

    VisitDateErrorMsg(String message){
        this.message = PrefixMsg.ERROR_MSG.getMessage() + message;
    }

    public String getMessage() {
        return message;
    }
}
