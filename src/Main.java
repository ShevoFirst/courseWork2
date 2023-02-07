import Task.MonthlyTask;
import Task.TaskService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        taskService.add(new MonthlyTask());
        taskService.getAllByDate(LocalDate.of(2024,5,7)).
                stream().
                forEach(System.out::println);
        taskService.delete(0);
        taskService.getAllByDate(LocalDate.of(2024,5,7)).
                stream().
                forEach(System.out::println);
    }
}