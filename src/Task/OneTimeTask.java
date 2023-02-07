package Task;

import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask() {
        super();
    }

    @Override
    public boolean appearsln(LocalDateTime time) {
        if (!getDateTime().equals(time))
            return true;
        else return false;
    }
}
