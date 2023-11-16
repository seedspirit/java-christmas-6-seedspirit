package christmas.View.Validator;

import static christmas.Constants.Message.ExceptionMsg.OrderErrorMsg.ASK_NO_EMPTY_INPUT;
import static christmas.Constants.Message.ExceptionMsg.OrderErrorMsg.ASK_NO_WHITE_SPACE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.View.InputValidator.OrderValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderValidatorTest {

    OrderValidator validator = new OrderValidator();

    @Test
    @DisplayName("빈값 입력 예외처리 테스트")
    public void 빈값_입력_예외처리(){
        assertThatThrownBy(
                () -> {
                    validator.validate("");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_EMPTY_INPUT.getMessage());
    }
    @ParameterizedTest
    @ValueSource(strings = {" 초코케이크-1", "티본스테이크- 1,제로콜라-2,아이스크림-3"})
    @DisplayName("공백 입력 예외처리 테스트")
    public void 공백_입력_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_WHITE_SPACE.getMessage());
    }

    @DisplayName("- 와 , 외 특수문자 및 유효 포맷을 벗어나는 입력 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크:1,제로콜라:2,아이스크림:3", "티본스테이크-1/제로콜라-2/아이스크림-3", "티본스테이크-1,Zero콜라:2,아이스크림:3"})
    public void 유효포맷_벗어나는_입력_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
