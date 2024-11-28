package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.util.SplitInput;

import java.util.List;

public class InputView {
    public List<String> inputMonth(){
        return SplitInput.splitMonth(Console.readLine());
    }
    public List<String> inputWorkPeople(){
        return SplitInput.splitPeople(Console.readLine());
    }
}
