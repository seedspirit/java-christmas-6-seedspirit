package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Model.FoodOrderDetails;
import christmas.Model.ReservationDetails;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ReservationDetailsTest {

    private static Stream<Arguments> provideUserInputAndExpect(){
        return Stream.of(
                Arguments.of(new FoodOrderDetails(Map.of("양송이수프", 1)), 1, false),
                Arguments.of(new FoodOrderDetails(Map.of("아이스크림", 1)), 17, false),
                Arguments.of(new FoodOrderDetails(Map.of("타파스", 3, "제로콜라", 1, "레드와인", 1)), 25, true),
                Arguments.of(new FoodOrderDetails(Map.of("티본스테이크", 1, "샴페인", 1, "초코케이크", 1)),3, true)
        );
    }

    @DisplayName("이벤트 참여 여부 결정 테스트")
    @ParameterizedTest
    @MethodSource("provideUserInputAndExpect")
    void 이벤트_참여_여부_검증_테스트(FoodOrderDetails foodOrderDetails, Integer visitDate, boolean expected){
        ReservationDetails reservation = new ReservationDetails(foodOrderDetails, visitDate);
        assertThat(reservation.isInEvent()).isEqualTo(expected);
    }
}
