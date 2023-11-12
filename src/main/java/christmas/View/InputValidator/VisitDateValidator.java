package christmas.View.InputValidator;

import static christmas.Constants.DomainConstants.EVENT_END_DATE;
import static christmas.Constants.DomainConstants.EVENT_START_DATE;
import static christmas.Constants.Message.ExceptionMsg.VisitDateErrorMsg.ASK_INPUT_IN_VALID_FORMAT;
import static christmas.Constants.Message.ExceptionMsg.VisitDateErrorMsg.ASK_NO_EMPTY_INPUT;
import static christmas.Constants.Message.ExceptionMsg.VisitDateErrorMsg.ASK_NO_WHITE_SPACE;



public class VisitDateValidator {
    public final String WHITE_SPACE = " ";
    private final String NUMBER_REGULAR_EXPRESSION = "^[0-9]+$";

    public void validate(String visitDateUserInput){
        isNotEmpty(visitDateUserInput);
        containsNoWhiteSpace(visitDateUserInput);
        isNumber(visitDateUserInput);
        isBetweenValidRange(visitDateUserInput);
    }

    public void isNotEmpty(String visitDateUserInput) throws IllegalArgumentException{
        if(visitDateUserInput.isEmpty()){
            throw new IllegalArgumentException(ASK_NO_EMPTY_INPUT.getMessage());
        }
    }

    public void containsNoWhiteSpace(String visitDateUserInput) throws IllegalArgumentException{
        if(visitDateUserInput.contains(WHITE_SPACE)){
            throw new IllegalArgumentException(ASK_NO_WHITE_SPACE.getMessage());
        }
    }

    public void isNumber(String visitDateUserInput) throws IllegalArgumentException {
        if (!visitDateUserInput.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(ASK_INPUT_IN_VALID_FORMAT.getMessage());
        }
    }

    public void isBetweenValidRange(String visitDateUserInput) throws IllegalArgumentException{
        if(Integer.parseInt(visitDateUserInput) < EVENT_START_DATE || Integer.parseInt(visitDateUserInput) > EVENT_END_DATE){
            throw new IllegalArgumentException(ASK_INPUT_IN_VALID_FORMAT.getMessage());
        }
    }
}
