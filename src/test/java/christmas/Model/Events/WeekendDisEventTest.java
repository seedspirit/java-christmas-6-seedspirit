package christmas.Model.Events;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Model.Benefits;
import christmas.Model.FoodOrderDetails;
import christmas.Model.ReservationDetails;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WeekendDisEventTest {

    private static Stream<Arguments> provideUserInput(){
        return Stream.of(
                Arguments.of(new FoodOrderDetails(Map.of("바비큐립", 1)), 1, 0),
                Arguments.of(new FoodOrderDetails(Map.of("티본스테이크", 3, "제로콜라", 1, "초코케이크", 2)), 25, 25000),
                Arguments.of(new FoodOrderDetails(Map.of("티본스테이크", 3, "제로콜라", 1, "초코케이크", 2)), 12, 25000),
                Arguments.of(new FoodOrderDetails(Map.of("제로콜라", 1, "초코케이크", 2)), 12, 0)
                );
    }

    @DisplayName("증정 이벤트 테스트")
    @ParameterizedTest
    @MethodSource("provideUserInput")
    void 증정_이벤트_테스트(FoodOrderDetails order, Integer visitDate, Integer expectedDisAmount){
        ReservationDetails reservation = new ReservationDetails(order, visitDate);
        Benefits benefits = new Benefits();
        benefits.apply(reservation);
        GiveAwayEvent event = new GiveAwayEvent();
        assertThat(event.applyEvent(reservation.getFoodOrderDetails().getPreDiscountTotal()))
                .isEqualTo(expectedDisAmount);
    }
}
