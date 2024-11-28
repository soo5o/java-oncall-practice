package oncall;

import java.util.Arrays;
import java.util.List;
import static oncall.message.ErrorMessage.INVALID_INPUT;

public enum DayData {
    ONE(1, 31, Arrays.asList(1)),
    TWO(2, 28, Arrays.asList()),
    THREE(3, 31, Arrays.asList(1)),
    FOURTH(4, 30, Arrays.asList()),
    FIVE(5, 31, Arrays.asList(5)),
    SIX(6, 30, Arrays.asList(6)),
    SEVEN(7, 31, Arrays.asList()),
    EIGHT(8, 31, Arrays.asList(15)),
    NINE(9, 30, Arrays.asList()),
    TEN(10, 31, Arrays.asList(3,9)),
    ELEVEN(11, 30, Arrays.asList()),
    TWELVE(12, 31, Arrays.asList(25));
    private final int month;
    private final int day;
    private final List<Integer> offDay;

    DayData(int month, int day, List<Integer> offDay){
        this.month = month;
        this.day = day;
        this.offDay = offDay;
    }
    public static DayData getByMonth(int month) {
        for (DayData dayData : values()) {
            if (dayData.month == month) {
                return dayData;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }

    public int getDay() {
        return day;
    }

    public List<Integer> getOffDay() {
        return offDay;
    }
}
