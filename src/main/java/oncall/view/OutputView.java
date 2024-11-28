package oncall.view;

import java.util.List;

public class OutputView {
    private static final String INPUT_MONTH = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String INPUT_WEEKDAY = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String INPUT_HOLIDAY = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String RESULT_FORMAT = "%d월 %d일 %s %s"; //월, 일, 요일, 근무자
    private static final String RESULT_HOLIDAY_FORMAT = "%d월 %d일 %s(휴일) %s"; //월, 일, 요일, 근무자

    public void printGetMonth() {
        System.out.print(INPUT_MONTH);
    }

    public void printGetWeekPeople() {
        System.out.print(INPUT_WEEKDAY);
    }

    public void printGetHoliPeople() {
        System.out.print(INPUT_HOLIDAY);
    }

    public void printResult(int month, int day, String w, String worker, List<Integer> offDay) {
        if(!(w.equals("토")  || w.equals("일")) && offDay.contains(day)) {
            System.out.println(String.format(RESULT_HOLIDAY_FORMAT, month, day, w, worker));
            return;
        }
        System.out.println(String.format(RESULT_FORMAT, month, day, w, worker));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
