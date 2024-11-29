package oncall.service;

import oncall.domain.HolidayWorkers;
import oncall.domain.MonthDay;
import oncall.domain.WeekdayWorkers;
import java.util.List;
import static oncall.domain.HolidayWorkers.*;
import static oncall.domain.WeekdayWorkers.*;

public class OncallService {
    private static String name;
    private static String preName;
    private static List<String> ww;
    private static List<String> hw;
    public OncallService(WeekdayWorkers wws, HolidayWorkers hws){
        ww = wws.getWeekdayWorker();
        hw = hws.getHolidayWorker();
        preName = "";
    }
    public static String getTodayWorker(int today, int idx){
        if (weekdayOrHoliday(idx, today) == 0){
            return getHolidayWorker();
        }
        return getWeekdaysWorker();
    }
    private static String getHolidayWorker(){
        name = String.valueOf(hw.get(getHolidayIdx()));
        if(name.equals(preName)){
            name = String.valueOf(hw.get(getHolidayIdx()+1));
            repetitionHolidayWorker();
            return returnValue();
        }
        updateHolidayIdx();
        return returnValue();
    }
    private static String getWeekdaysWorker(){
        name = String.valueOf(ww.get(getWeekdaysIdx()));
        if(name.equals(preName)){
            name = String.valueOf(ww.get(getWeekdaysIdx()+1));
            repetitionWeekdaysWorker();
            return returnValue();
        }
        updateWeekdaysIdx();
        return returnValue();
    }
    private static String returnValue(){
        preName = name;
        return name;
    }
    private static int weekdayOrHoliday(int idx, int today){
        if(idx == 0 || idx == 6 || MonthDay.getOffDay().contains(today)){
            return 0;
        }
        return 1;
    }
}
