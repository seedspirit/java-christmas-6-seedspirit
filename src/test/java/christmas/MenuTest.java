package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import static christmas.Menu.MENU_CATEGORY_MAIN;
import static christmas.Menu.MENU_CATEGORY_APPETIZER;
import static christmas.Menu.MENU_CATEGORY_BEVERAGE;
import static christmas.Menu.MENU_CATEGORY_DESSERT;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
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
    void 총주문_금액_계산_테스트(Map<String, Integer> foodOrder, Integer expectedTotal){
        assertThat(Menu.calculatePreDiscountTotal(foodOrder))
                .isEqualTo(expectedTotal);
    }

    private static Stream<Arguments> provideBeverage(){
        return Stream.of(
                Arguments.of(Map.of("양송이수프", 2, "타파스", 3), 0),
                Arguments.of(Map.of("티본스테이크", 1, "제로콜라", 2, "아이스크림", 3), 2),
                Arguments.of(Map.of("샴페인", 3, "바비큐립", 1, "시저샐러드", 1), 3),
                Arguments.of(Map.of(), 0)
        );
    }

    @DisplayName("입력 메뉴에 몇 개의 음료 메뉴가 있는지 찾는 메서드 테스트")
    @ParameterizedTest
    @MethodSource("provideBeverage")
    void 음료_수_카운트_테스트(Map<String, Integer> foodOrder, Integer expectedTotal){
        assertThat(Menu.countAmountOfMenuCategory(foodOrder, MENU_CATEGORY_BEVERAGE))
                .isEqualTo(expectedTotal);
    }

    private static Stream<Arguments> provideMain(){
        return Stream.of(
                Arguments.of(Map.of("양송이수프", 2, "타파스", 3), 0),
                Arguments.of(Map.of("티본스테이크", 1, "제로콜라", 2, "아이스크림", 3), 1),
                Arguments.of(Map.of("샴페인", 3, "바비큐립", 2, "시저샐러드", 1), 2),
                Arguments.of(Map.of(), 0)
        );
    }

    @DisplayName("입력 메뉴에 몇 개의 메인 메뉴가 있는지 찾는 메서드 테스트")
    @ParameterizedTest
    @MethodSource("provideMain")
    void 메인_수_카운트_테스트(Map<String, Integer> foodOrder, Integer expectedTotal){
        assertThat(Menu.countAmountOfMenuCategory(foodOrder, MENU_CATEGORY_MAIN))
                .isEqualTo(expectedTotal);
    }
}
