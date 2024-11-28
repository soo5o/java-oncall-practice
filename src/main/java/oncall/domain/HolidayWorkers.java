package oncall.domain;

import java.util.List;

public class HolidayWorkers {
    List<String> holidayWorker;
    private static int flg;
    private static int holidayIdx;
    private static int holidaySize;
    public HolidayWorkers(List<String> workers){
        holidaySize = workers.size();
        holidayWorker = workers;
        holidayIdx = 0;
    }

    public List<String> getHolidayWorker() {
        return holidayWorker;
    }
    public static int getHolidayIdx() {
        if (flg == 1){
            int tmpIdx = holidayIdx;
            holidayIdx += 1;
            flg = 0;
            return tmpIdx;
        }
        return holidayIdx;
    }
    public static void repetitionHolidayWorker(){
        flg = 1;
    }

    public static void updateHolidayIdx() {
        holidayIdx = (holidayIdx+1)%holidaySize;;
    }
}
