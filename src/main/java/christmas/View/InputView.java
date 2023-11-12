package christmas.View;

import static christmas.Constants.Message.ExceptionMsg.OrderErrorMsg.ASK_ORDER_INPUT_IN_VALID_FORMAT;
import static christmas.Constants.Message.InputPromptMsg.ASK_FOOD_ORDER;
import static christmas.Constants.Message.InputPromptMsg.ASK_VISITING_DATE;
import static christmas.Constants.Message.InputPromptMsg.DEFAULT_WELCOME_COMMENT;

import camp.nextstep.edu.missionutils.Console;
import christmas.View.InputConvertor.InputConvertor;
import christmas.View.InputValidator.VisitDateValidator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputView {
    VisitDateValidator visitDateValidator = new VisitDateValidator();
    InputConvertor convertor = new InputConvertor();

    InputView(){
        System.out.println(DEFAULT_WELCOME_COMMENT.getMessage());
    }

    public Integer visitDateInput(){
        while (true) {
            try {
                System.out.println(ASK_VISITING_DATE.getMessage());
                String visitDateUserInput = Console.readLine();
                visitDateValidator.validate(visitDateUserInput);
                return convertor.convertVisitDate(visitDateUserInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<String, Integer> orderInput(){
        while (true) {
            try {
                System.out.println(ASK_FOOD_ORDER.getMessage());
                String orderUserInput = Console.readLine();
                visitDateValidator.validate(orderUserInput);
                return convertor.covertOrderInput(orderUserInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
