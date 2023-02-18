package tasks;

import java.time.LocalDateTime;
import java.util.Scanner;

public abstract class Task {
    static private int idGenerator;
    private String title;
    private Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String description;

    public Task(int type, String title, String description) {
        this.id = idGenerator;
        idGenerator++;
        this.title = title;
        if(title.isEmpty())
            throw new IncorrectArgumentException("Отсутсвует заголовок");

        if (type == 1)
            this.type = Type.WORK;
        else this.type = Type.PERSONAL;

        this.description = description;

        dateTime = LocalDateTime.now();
        System.out.println();
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

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
