package christmas.View.Validator;

import static christmas.Constants.Message.ExceptionMsg.VisitDateErrorMsg.ASK_NO_EMPTY_INPUT;
import static christmas.Constants.Message.ExceptionMsg.VisitDateErrorMsg.ASK_NO_WHITE_SPACE;
import static org.assertj.core.api.Assertions.*;

import christmas.View.InputValidator.VisitDateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitDateValidatorTest {

    VisitDateValidator validator = new VisitDateValidator();

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
    @ValueSource(strings = {" 25", " ", "25 "})
    @DisplayName("공백 입력 예외처리 테스트")
    public void 공백_입력_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_WHITE_SPACE.getMessage());
    }

    @DisplayName("특수문자, 이스케이프코드, 문자 입력 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"*25", "christmas", "\n8"})
    public void 숫자_외_입력_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "40"})
    @DisplayName("입력 가능 범위 외 숫자 입력 예외 처리")
    public void 입력_가능_범위_외_입력_예외_처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

}
