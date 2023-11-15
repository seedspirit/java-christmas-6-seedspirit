package christmas.Model.Events;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Model.FoodOrderDetails;
import christmas.Utils.DayOfWeekConvertor;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WeekendDisEventTest {

    private static Stream<Arguments> provideUserInputInWeekend(){
        return Stream.of(
                Arguments.of(new FoodOrderDetails(Map.of("바비큐립", 1)), 1, 2023),
                Arguments.of(new FoodOrderDetails(Map.of("티본스테이크", 3, "제로콜라", 1, "초코케이크", 2)), 8, 6069),
                Arguments.of(new FoodOrderDetails(Map.of("티본스테이크", 3, "제로콜라", 1, "초코케이크", 2)), 12, 0),
                Arguments.of(new FoodOrderDetails(Map.of("제로콜라", 1, "초코케이크", 2)), 12, 0)
                );
    }

    @DisplayName("주말 할인 이벤트 금액 계산 테스트")
    @ParameterizedTest
    @MethodSource("provideUserInputInWeekend")
    void 주말_할인_이벤트_금액_계산_테스트(FoodOrderDetails order, Integer visitDate, Integer expectedDisAmount){
        WeekendDisEvent event = new WeekendDisEvent();
        assertThat(event.applyEvent(order, DayOfWeekConvertor.convert(visitDate)))
                .isEqualTo(expectedDisAmount);
    }
}
