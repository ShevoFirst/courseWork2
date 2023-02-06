package Task;

import java.time.LocalDateTime;

public class YearlyTask extends Task{

    public YearlyTask(String title, Type type) {
        super(title, type);
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        if (time.isAfter(getDateTime().plusYears(1)))
            return true;
        else return false;
    }
}
