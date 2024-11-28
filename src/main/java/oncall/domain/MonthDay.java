package oncall.domain;

import oncall.DayData;

import java.util.List;

import static oncall.DayData.getByMonth;

public class MonthDay {
    private static int month;
    private static int maxDay;
    private static List<Integer> offDay;
    private static String yoil;

    public MonthDay(List<String> input){
        month = Integer.parseInt(input.get(0));
        yoil = input.get(1);
        DayData dd = getByMonth(month);
        maxDay = dd.getDay();
        offDay = dd.getOffDay();
    }

    public static int getMonth() {
        return month;
    }

    public static int getMaxDay() {
        return maxDay;
    }

    public static List<Integer> getOffDay() {
        return offDay;
    }

    public static String getYoil() {
        return yoil;
    }
}
