package Task;

import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask() {
        super();
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        if (time.isAfter(getDateTime().plusWeeks(1)))
        return true;
        else return false;
    }
}
