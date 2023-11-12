package christmas.View;

import static christmas.Constants.Message.InputPromptMsg.ASK_FOOD_ORDER;
import static christmas.Constants.Message.InputPromptMsg.ASK_VISITING_DATE;
import static christmas.Constants.Message.InputPromptMsg.DEFAULT_WELCOME_COMMENT;

import camp.nextstep.edu.missionutils.Console;
import christmas.View.InputValidator.VisitDateValidator;

public class InputView {
    VisitDateValidator visitDateValidator = new VisitDateValidator();
    public void printDefaultWelcomeMsg(){
        System.out.println(DEFAULT_WELCOME_COMMENT.getMessage());
    }
    public Integer visitDateInput(){
        while (true) {
            try {
                System.out.println(ASK_VISITING_DATE.getMessage());
                String visitDateUserInput = Console.readLine();
                visitDateValidator.validate(visitDateUserInput);
                return Integer.parseInt(visitDateUserInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String foodOrderInput(){
        System.out.println(ASK_FOOD_ORDER.getMessage());
        return Console.readLine();
    }
}
