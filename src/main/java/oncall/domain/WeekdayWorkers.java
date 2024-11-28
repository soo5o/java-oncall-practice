package oncall.domain;

import java.util.List;

public class WeekdayWorkers {
    List<String> weekdayWorker;
    private static int flg;
    private static int weekdaysIdx;
    private static int weekdaysSize;

    public WeekdayWorkers(List<String> workers){
        weekdaysSize = workers.size();
        weekdayWorker = workers;
        weekdaysIdx = 0;
    }

    public List<String> getWeekdayWorker() {
        return weekdayWorker;
    }
    public static int getWeekdaysIdx() {
        if (flg == 1){
            int tmpIdx = weekdaysIdx;
            weekdaysIdx += 1;
            flg = 0;
            return tmpIdx;
        }
        return weekdaysIdx;
    }
    public static void repetitionWeekdaysWorker(){
        flg = 1;
    }
    public static void updateWeekdaysIdx() {
        weekdaysIdx = (weekdaysIdx+1)%weekdaysSize;
    }
}
