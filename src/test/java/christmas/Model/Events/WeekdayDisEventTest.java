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

public class WeekdayDisEventTest {

    private static Stream<Arguments> provideUserInputInWeekday(){
        return Stream.of(
                Arguments.of(new FoodOrderDetails(Map.of("양송이수프", 1)), 1, 0),
                Arguments.of(new FoodOrderDetails(Map.of("티본스테이크", 3, "제로콜라", 1, "초코케이크", 2)), 7, 4046)
        );
    }

    @DisplayName("평일 할인 이벤트 금액 계산 테스트")
    @ParameterizedTest
    @MethodSource("provideUserInputInWeekday")
    void 평일_할인_이벤트_금액_계산_테스트(FoodOrderDetails order, Integer visitDate, Integer expectedDisAmount){
        WeekdayDisEvent event = new WeekdayDisEvent();
        assertThat(event.applyEvent(order, DayOfWeekConvertor.convert(visitDate)))
                .isEqualTo(expectedDisAmount);
    }
}

