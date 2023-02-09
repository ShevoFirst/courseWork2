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

    public Task() {
        this.id = idGenerator;
        idGenerator++;
        System.out.print("введите заголовок для вашей задачи(обязательно): ");
        this.title = new Scanner(System.in).nextLine();

        if(title.isEmpty())
            throw new IncorrectArgumentException("Отсутсвует заголовок");

        System.out.print("введите тип вашей задачи(Рабочая - 1, Персональная - 2): ");
        if (new Scanner(System.in).nextInt() == 1)
            this.type = Type.WORK;
        else this.type = Type.PERSONAL;

        System.out.print("введите описание задачи(по желанию): ");
        description = new Scanner(System.in).nextLine();

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
    public class IncorrectArgumentException extends RuntimeException{

        public IncorrectArgumentException() {super();}

        public IncorrectArgumentException(String message) {
            super(message);
        }
    }
}
