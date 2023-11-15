package christmas.Utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.Utils.DayOfWeekConvertor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DayOfWeekConvertorTest {
    DayOfWeekConvertor convertor = new DayOfWeekConvertor();
    @DisplayName("일을 입력하면 12월의 해당 일의 요일 출력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,Fri", "2,Sat", "3,Sun", "4, Mon", "5,Tue", "6,Wed", "7,Thu"})
    void 요일_변환기_테스트(Integer reserveDate, String expectedDayOfWeek){
        String dayOfWeek = convertor.convert(reserveDate);
        assertThat(dayOfWeek).isEqualTo(expectedDayOfWeek);
    }
}
