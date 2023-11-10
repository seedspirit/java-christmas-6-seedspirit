package christmas;

import java.util.Arrays;
import java.util.Map;

public enum Menu {
    MUSHROOM_SOUP("Appetizer", "양송이수프", 6_000),
    TAPAS("Appetizer", "타파스", 5_500),
    CAESAR_SALAD("Appetizer", "시저샐러드", 8_000),

    T_BONE_STEAK("Main", "티본스테이크", 55_000),
    BBQ_RIBS("Main", "바비큐립", 54_000),
    SEAFOOD_PASTA("Main", "해산물파스타", 35_000),
    CHRISTMAS_PASTA("Main", "크리스마스파스타", 25_000),

    CHOCOLATE_CAKE("Dessert", "초코케이크",  15_000),
    ICE_CREAM("Dessert", "아이스크림",5_000),

    ZERO_COLA("Beverage", "제로콜라", 3_000),
    RED_WINE("Beverage","레드와인", 60_000),
    CHAMPAGNE("Beverage", "샴페인", 25_000);

    private String menuCategory;
    private String menuKoreanName;
    private Integer price;

    Menu(String menuCategory, String menuKoreanName, Integer price){
        this.menuCategory = menuCategory;
        this.menuKoreanName = menuKoreanName;
        this.price = price;
    }

    public static Integer calculatePreDiscountTotal(Map<String, Integer> foodOrder){
        return Arrays.stream(Menu.values())
                .filter(menu -> foodOrder.containsKey(menu.menuKoreanName))
                .mapToInt(menu -> menu.price * foodOrder.get(menu.menuKoreanName))
                .sum();
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public String getMenuKoreanName() {
        return menuKoreanName;
    }

    public Integer getPrice() {
        return price;
    }
}
