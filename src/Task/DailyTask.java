package Task;

import java.time.LocalDateTime;

public class DailyTask extends Task{

    public DailyTask() {
        super();
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        if (time.isAfter(getDateTime()))
            return true;
        else return false;
    }
}
