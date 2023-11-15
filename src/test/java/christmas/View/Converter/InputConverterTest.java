package christmas.View.Converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.View.InputConverter.InputConverter;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputConverterTest {
    InputConverter convertor = new InputConverter();
    @DisplayName("중복되는 메뉴를 적었을 때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,제로콜라-2,제로콜라-2", "티본스테이크-1,티본스테이크-1,아이스크림-3"})
    void 메뉴_중복_입력_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    convertor.covertOrderInput(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private static Stream<Arguments> provideOrderForConvert(){
        return Stream.of(
                Arguments.of("양송이수프-2,타파스-3", Map.of("양송이수프", 2, "타파스", 3)),
                Arguments.of("티본스테이크-1,제로콜라-2,아이스크림-3",Map.of("티본스테이크", 1, "제로콜라", 2, "아이스크림", 3)),
                Arguments.of("샴페인-3,바비큐립-2,시저샐러드-1",Map.of("샴페인", 3, "바비큐립", 2, "시저샐러드", 1))
        );
    }
    @DisplayName("입력 변환 테스트")
    @ParameterizedTest
    @MethodSource("provideOrderForConvert")
    void 메뉴_입력_변환_테스트(String orderUserInput, Map<String, Integer> expectedConvertedOrder){
        assertThat(convertor.covertOrderInput(orderUserInput))
                .isEqualTo(expectedConvertedOrder);
    }
}
