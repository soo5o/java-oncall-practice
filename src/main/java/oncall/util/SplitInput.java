package oncall.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static oncall.message.ErrorMessage.INVALID_INPUT;

public class SplitInput {
    private static final String DELIMITER_COMMA = ",";
    public static List<String> splitMonth(String input){
        List<String> monthData = Arrays.stream(input.split(DELIMITER_COMMA)).map(String::trim)
                .toList();
        validateMonthNum(monthData.get(0));
        validateDay(monthData.get(1));
        return monthData;
    }
    private static void validateMonthNum(String month){
        int num;
        try {
            num = Integer.parseInt(month);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        if (num<1 || 12<num){
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
    private static void validateDay(String day){
        if (!OncallConfig.DAYS.contains(day)){
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
    public static List<String> splitPeople(String input){
        List<String> personData = Arrays.stream(input.split(DELIMITER_COMMA)).map(String::trim).toList();
        Set<String> uniqueNames = new HashSet<>();
        for(String name:personData){
            validateName(name, uniqueNames);
        }
        return personData;
    }
    private static void validateName(String name, Set<String> uniqueNames){
        if (name.length() > 5){
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        if (!uniqueNames.add(name)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
