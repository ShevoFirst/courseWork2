package tasks;

import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(int type, String title, String description) {
        super(type, title, description);
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        return time.toLocalDate().getDayOfMonth() == getDateTime().toLocalDate().getDayOfMonth()
                && !time.isBefore(getDateTime());
    }
}
