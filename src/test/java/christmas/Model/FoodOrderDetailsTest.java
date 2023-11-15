package christmas.Model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FoodOrderDetailsTest {
    private static Stream<Arguments> provideInvalidOrder(){
        return Stream.of(
                Arguments.of(Map.of("양송이수프", 2, "타파스", 3, "펩시콜라", 4)),
                Arguments.of(Map.of("티본스테이크", 100, "제로콜라", 2, "아이스크림", 3)),
                Arguments.of(Map.of("샴페인", 3, "제로콜라", 1, "레드와인", 1))
        );
    }

    @DisplayName("음식 주문 유효성 검증 기능 테스트")
    @ParameterizedTest
    @MethodSource("provideInvalidOrder")
    void 유효하지_않은_음식_주문_예외처리(Map<String, Integer> menuInput){
        assertThatThrownBy(
                () -> new FoodOrderDetails(menuInput)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
