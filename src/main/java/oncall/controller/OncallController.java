package oncall.controller;

import oncall.domain.HolidayWorkers;
import oncall.domain.MonthDay;
import oncall.domain.WeekdayWorkers;
import oncall.service.OncallService;
import oncall.util.CheckWorker;
import oncall.util.OncallConfig;
import oncall.view.InputView;
import oncall.view.OutputView;
import java.util.List;

public class OncallController {
    private final InputView inputView;
    private final OutputView outputView;
    public OncallController(){
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void run(){
        List<String> startMonth = getMonthDate();
        new MonthDay(startMonth);
        checkWorkers();
        int month = MonthDay.getMonth();
        int yoilIdx = OncallConfig.DAYS.indexOf(MonthDay.getYoil());
        for (int day = 1; day<= MonthDay.getMaxDay(); day++){
            String name = OncallService.getTodayWorker(day, yoilIdx);
            outputView.printResult(month, day,OncallConfig.DAYS.get(yoilIdx), name, MonthDay.getOffDay());
            yoilIdx = (yoilIdx+1)%7;
        }
    }
    private List<String> getMonthDate(){
        while(true){
            try{
                outputView.printGetMonth();
                return inputView.inputMonth();
            }
            catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
    private void checkWorkers(){
        while(true){
            try{
                List<String> ww = getWeekdayWorker();
                List<String> hw = getHolidayWorker();
                CheckWorker.checkWorkersCount(ww, hw);
                WeekdayWorkers wws = new WeekdayWorkers(ww);
                HolidayWorkers hws = new HolidayWorkers(hw);
                new OncallService(wws, hws);
                return;
            }
            catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
    private List<String> getWeekdayWorker(){
        outputView.printGetWeekPeople();
        return inputView.inputWorkPeople();
    }
    private List<String> getHolidayWorker(){
        outputView.printGetHoliPeople();
        return inputView.inputWorkPeople();
    }
}
