package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MenuTest {

    private static Stream<Arguments> provideOrdersTotal(){
        return Stream.of(
                Arguments.of(Map.of("양송이수프", 2, "타파스", 3), 28500),
                Arguments.of(Map.of("티본스테이크", 1, "제로콜라", 2, "아이스크림", 3), 76000),
                Arguments.of(Map.of("샴페인", 1, "바비큐립", 1, "시저샐러드", 1), 87000),
                Arguments.of(Map.of(), 0)
        );
    }

    @DisplayName("입력 메뉴에 대한 올바른 총주문 금액 출력 테스트")
    @ParameterizedTest
    @MethodSource("provideOrdersTotal")
    void 총주문_금액_게산_테스트(Map<String, Integer> foodOrder, Integer expectedTotal){
        assertThat(Menu.calculatePreDiscountTotal(foodOrder))
                .isEqualTo(expectedTotal);
    }
}
