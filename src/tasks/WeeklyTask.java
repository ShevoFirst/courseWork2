package tasks;

import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask() {
        super();
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        if (time.toLocalDate().getDayOfWeek() == getDateTime().toLocalDate().getDayOfWeek()
                && !time.isBefore(getDateTime()))
        return true;
        else return false;
    }
}
