package christmas.View.InputValidator;

import static christmas.Constants.Message.ExceptionMsg.OrderErrorMsg.ASK_NO_EMPTY_INPUT;
import static christmas.Constants.Message.ExceptionMsg.OrderErrorMsg.ASK_NO_WHITE_SPACE;
import static christmas.Constants.Message.ExceptionMsg.OrderErrorMsg.ASK_ORDER_INPUT_IN_VALID_FORMAT;

public class OrderValidator implements Validator {
    public final String WHITE_SPACE = " ";
    private final String VALID_FORMAT_REGULAR_EXPRESSION = "^(?:[가-힣]+-\\d+,)*(?:[가-힣]+-\\d+)$";

    @Override
    public void validate(String orderUserInput){
        isNotEmpty(orderUserInput);
        containsNoWhiteSpace(orderUserInput);
        isRightFormat(orderUserInput);
    }

    public void isNotEmpty(String orderUserInput) throws IllegalArgumentException{
        if(orderUserInput.isEmpty()){
            throw new IllegalArgumentException(ASK_NO_EMPTY_INPUT.getMessage());
        }
    }

    public void containsNoWhiteSpace(String orderUserInput) throws IllegalArgumentException{
        if(orderUserInput.contains(WHITE_SPACE)){
            throw new IllegalArgumentException(ASK_NO_WHITE_SPACE.getMessage());
        }
    }

    public void isRightFormat(String orderUserInput) throws IllegalArgumentException{
        if(!orderUserInput.matches(VALID_FORMAT_REGULAR_EXPRESSION)){
            throw new IllegalArgumentException(ASK_ORDER_INPUT_IN_VALID_FORMAT.getMessage());
        }
    }
}
