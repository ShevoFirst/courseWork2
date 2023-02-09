package tasks;

import java.time.LocalDateTime;

public class YearlyTask extends Task{

    public YearlyTask() {
        super();
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        return time.toLocalDate().getDayOfYear() == getDateTime().toLocalDate().getDayOfYear()
                && !time.isBefore(getDateTime());
    }
}
