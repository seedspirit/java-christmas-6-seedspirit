package christmas.Model.Events;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DDayDisEventTest {

    @DisplayName("디데이 할인 이벤트 금액 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,1000", "5,1400","15,2400","25,3400","31,0"})
    void 디데이_할인_이벤트_금액_계산_테스트(Integer visitDate, Integer expectedDiscountAmount){
        DDayDisEvent event = new DDayDisEvent();
        assertThat(event.applyEvent(visitDate)).isEqualTo(expectedDiscountAmount);
    }
}
