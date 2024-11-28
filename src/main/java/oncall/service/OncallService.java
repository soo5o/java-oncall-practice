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
    public OncallService(WeekdayWorkers wws, HolidayWorkers hws){ //월, 시작 요일,
        ww = wws.getWeekdayWorker();
        hw = hws.getHolidayWorker();
        preName = "";
    }
    public static String getTodayWorker(int today, int idx){ //name을 return 해야됨
        //name 으로 객체 찾아서 last_day를 today로 업데이트
        if (weekdayOrHoliday(idx, today) == 0){ //여기서 어제 근무자와 중복이 되는지 ?
            name = String.valueOf(hw.get(getHolidayIdx()));
            if(name.equals(preName)){
                name = String.valueOf(hw.get(getHolidayIdx()+1)); //다음 이름 가져옴
                repetitionHolidayWorker();
                return returnValue();
            }
            updateHolidayIdx(); //idx+=1
            return returnValue();
        }
        name = String.valueOf(ww.get(getWeekdaysIdx()));
        if(name.equals(preName)){
            name = String.valueOf(ww.get(getWeekdaysIdx()+1)); //다음 이름 가져옴
            repetitionWeekdaysWorker();
            return returnValue();
        }
        updateWeekdaysIdx(); //idx+=1
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
        return 1; //평일의 경우
    }
}
