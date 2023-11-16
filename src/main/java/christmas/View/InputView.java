package christmas.View;

import static christmas.Constants.Message.InputPromptMsg.ASK_FOOD_ORDER;
import static christmas.Constants.Message.InputPromptMsg.ASK_VISITING_DATE;
import static christmas.Constants.Message.InputPromptMsg.DEFAULT_WELCOME_COMMENT;

import camp.nextstep.edu.missionutils.Console;
import christmas.View.InputConverter.InputConverter;
import christmas.View.InputValidator.OrderValidator;
import christmas.View.InputValidator.Validator;
import christmas.View.InputValidator.VisitDateValidator;

import java.util.Map;
import java.util.function.Function;

public class InputView {

    InputConverter converter = new InputConverter();

    Validator visitDateValidator = new VisitDateValidator();
    Validator orderValidator = new OrderValidator();

    public InputView(){
        System.out.println(DEFAULT_WELCOME_COMMENT.getMessage());
    }

    public Integer visitDateInput(){
        return inputWithValidation(
                ASK_VISITING_DATE.getMessage(),
                visitDateValidator,
                converter::convertVisitDate
        );
    }

    public Map<String, Integer> orderInput(){
        return inputWithValidation(
                ASK_FOOD_ORDER.getMessage(),
                orderValidator,
                converter::covertOrderInput
        );
    }

    private <T> T inputWithValidation(String message, Validator validator, Function<String, T> converter){
        while (true) {
            try {
                System.out.println(message);
                String userInput = Console.readLine();
                validator.validate(userInput);
                return converter.apply(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
