package Task;

import java.time.LocalDateTime;

public abstract class Task {
    private int idGenerator;
    private String title;
    private Type type;
    private static int id;
    private LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type) {
        id++;
        this.title = title;
        this.type = type;
        dateTime = LocalDateTime.now();
    }

    abstract public boolean appearsln(LocalDateTime time);

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
