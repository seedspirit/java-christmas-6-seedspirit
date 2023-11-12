package christmas.Constants.Message.ExceptionMsg;

public enum PrefixMsg {
    ERROR_MSG("[ERROR] ");

    private final String message;

    PrefixMsg(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
