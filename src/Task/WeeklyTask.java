package Task;

import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, Type type) {
        super(title, type);
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        if (time.isAfter(getDateTime().plusWeeks(1)))
        return true;
        else return false;
    }
}
