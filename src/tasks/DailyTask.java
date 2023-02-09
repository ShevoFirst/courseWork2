package tasks;

import java.time.LocalDateTime;

public class DailyTask extends Task{

    public DailyTask() {
        super();
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        return !time.isBefore(getDateTime());
    }
}
