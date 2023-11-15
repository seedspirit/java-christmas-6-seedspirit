package christmas.Model.Events;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.Utils.DayOfWeekConvertor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SpecialDisEventTest {
    @DisplayName("특별 할인 이벤트 금액 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "3,1000","17,1000","25,1000","27,0"})
    void 특별_할인_이벤트_금액_계산_테스트(Integer visitDate, Integer expectedDiscountAmount){
        SpecialDisEvent event = new SpecialDisEvent();
        assertThat(event.applyEvent(visitDate, DayOfWeekConvertor.convert(visitDate)))
                .isEqualTo(expectedDiscountAmount);
    }
}
