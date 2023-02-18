package tasks;

import java.time.LocalDateTime;

public class WeeklyTask extends Task{


    public WeeklyTask(int type, String title, String description) {
        super(type, title, description);
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        if (time.toLocalDate().getDayOfWeek() == getDateTime().toLocalDate().getDayOfWeek()
                && !time.isBefore(getDateTime()))
        return true;
        else return false;
    }
}
