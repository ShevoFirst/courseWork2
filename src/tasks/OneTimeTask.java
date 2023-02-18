package tasks;

import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(int type, String title, String description) {
        super(type, title, description);
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
            return time.toLocalDate().equals(getDateTime().toLocalDate());
    }
}
