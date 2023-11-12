package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BadgeEventTest {

    @DisplayName("총 할인 혜택 금액에 따른 뱃지 부여 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0,없음", "400,없음", "5200,별", "19999,트리", "40000,산타"})
    void 뱃지_부여_테스트(Integer totalPromAmount, String expectedBadge){
        assertThat(BadgeEvent.findWhichBadgeMatches(totalPromAmount))
                .isEqualTo(expectedBadge);
    }

}
