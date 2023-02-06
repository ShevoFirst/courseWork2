package Task;

import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type) {
        super(title, type);
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        if (time.isAfter(getDateTime().plusMonths(1)))
        return true;
        else return false;
    }
}
