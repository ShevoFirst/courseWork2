package tasks;

import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask() {
        super();
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
            return time.toLocalDate().equals(getDateTime().toLocalDate())
                    && !time.isBefore(getDateTime());
    }
}
