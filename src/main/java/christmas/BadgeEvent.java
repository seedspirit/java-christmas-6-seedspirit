package christmas;

import java.util.Arrays;
import java.util.Comparator;

public enum BadgeEvent {
    NONE("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 1_0000),
    SANTA("산타", 2_0000);

    private String badgeName;
    private Integer condition;

    BadgeEvent(String badgeName, Integer condition){
        this.badgeName = badgeName;
        this.condition = condition;
    }

    public static String findWhichBadgeMatches(Integer totalPromAmount){
        return Arrays.stream(BadgeEvent.values())
                .sorted(Comparator.comparingInt((BadgeEvent b) -> b.condition).reversed())
                .filter(badgeEvent -> badgeEvent.condition <= totalPromAmount)
                .map(badgeEvent -> badgeEvent.badgeName)
                .findFirst()
                .orElse(NONE.getBadgeName());
    }

    public String getBadgeName() {
        return badgeName;
    }

    public Integer getCondition() {
        return condition;
    }
}
