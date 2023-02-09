import tasks.DailyTask;
import tasks.MonthlyTask;
import tasks.TaskService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        taskService.add(new MonthlyTask());
        taskService.add(new DailyTask());
        taskService.getAllByDate(LocalDate.of(2024,10,9)).
                stream().
                forEach(System.out::println);
        taskService.delete(0);
        System.out.println();
        taskService.getAllByDate(LocalDate.of(2024,3,9)).
                stream().
                forEach(System.out::println);
    }
}