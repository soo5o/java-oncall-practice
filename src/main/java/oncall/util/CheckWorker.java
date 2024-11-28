package oncall.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static oncall.message.ErrorMessage.INVALID_INPUT;

public class CheckWorker {
    public static void checkWorkersCount(List<String> week, List<String> holi){
        Set<String> mergedSet = new HashSet<>();
        mergedSet.addAll(week);
        mergedSet.addAll(holi);
        if (week.size() != holi.size() || mergedSet.size() < 5|| 35 < mergedSet.size()){
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
