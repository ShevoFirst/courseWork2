package tasks;

import java.time.LocalDateTime;

public class DailyTask extends Task{

    public DailyTask(int type, String title, String description) {
        super(type, title, description);
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        return !time.isBefore(getDateTime());
    }
}
