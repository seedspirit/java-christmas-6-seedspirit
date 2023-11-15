package christmas.View.InputConverter;

import static christmas.Constants.Message.ExceptionMsg.OrderErrorMsg.ASK_ORDER_INPUT_IN_VALID_FORMAT;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class InputConverter {

    public Integer convertVisitDate(String visitDateUserInput){
        return Integer.parseInt(visitDateUserInput);
    }

    public Map<String, Integer> covertOrderInput(String orderUserInput) throws IllegalArgumentException{
        return Arrays.stream(orderUserInput.split(","))
                .map(element -> element.split("-"))
                .collect(Collectors.toMap(
                        split -> split[0],
                        split -> Integer.parseInt(split[1]),
                        (value1, value2) -> {
                            throw new IllegalArgumentException(ASK_ORDER_INPUT_IN_VALID_FORMAT.getMessage());
                        }));
    }
}
