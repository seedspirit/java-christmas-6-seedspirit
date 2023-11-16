package christmas.Model;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
public class BenefitsTest {
    private static Stream<Arguments> provideUserInputForTotalBenefitTest(){
        return Stream.of(
                Arguments.of(new FoodOrderDetails(Map.of("양송이수프", 1)), 1, 0),
                Arguments.of(new FoodOrderDetails(Map.of("티본스테이크", 3, "제로콜라", 1, "레드와인", 1)), 25, 29400)
        );
    }

    @DisplayName("총혜택 금액 계산 테스트")
    @ParameterizedTest
    @MethodSource("provideUserInputForTotalBenefitTest")
    void 총혜택_금액_계산_테스트(FoodOrderDetails foodOrderDetails, Integer visitDate, Integer expected){
        Benefits benefits = new Benefits();
        benefits.apply(new ReservationDetails(foodOrderDetails, visitDate));
        assertThat(benefits.getTotalBenefitAmount()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideUserInputForActualDiscountTest(){
        return Stream.of(
                Arguments.of(new FoodOrderDetails(Map.of("양송이수프", 1)), 1, 0),
                Arguments.of(new FoodOrderDetails(Map.of("티본스테이크", 3, "제로콜라", 1, "레드와인", 1)), 25, 4400)
        );
    }

    @DisplayName("실제 할인 금액 계산 테스트")
    @ParameterizedTest
    @MethodSource("provideUserInputForActualDiscountTest")
    void 실제_할인_금액_계산_테스트(FoodOrderDetails foodOrderDetails, Integer visitDate, Integer expected){
        Benefits benefits = new Benefits();
        benefits.apply(new ReservationDetails(foodOrderDetails, visitDate));
        assertThat(benefits.getActualDiscountAmount()).isEqualTo(expected);
    }
}
