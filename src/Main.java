import tasks.DailyTask;
import tasks.MonthlyTask;
import tasks.TaskService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        System.out.print("введите заголовок для вашей задачи(обязательно): ");
        String title = new Scanner(System.in).nextLine();
        System.out.print("введите тип вашей задачи(Рабочая - 1, Персональная - 2): ");
        int type = new Scanner(System.in).nextInt();
        System.out.print("введите описание задачи(по желанию): ");
        String descriprion = new Scanner(System.in).nextLine();
        taskService.add(new MonthlyTask(type,title,descriprion));

        System.out.print("введите заголовок для вашей задачи(обязательно): ");
         title = new Scanner(System.in).nextLine();
        System.out.print("введите тип вашей задачи(Рабочая - 1, Персональная - 2): ");
         type = new Scanner(System.in).nextInt();
        System.out.print("введите описание задачи(по желанию): ");
         descriprion = new Scanner(System.in).nextLine();
        taskService.add(new DailyTask(type,title,descriprion));


        taskService.getAllByDate(LocalDate.of(2024,10,9)).
                stream().
                forEach(System.out::println);
        taskService.delete(0);
        taskService.updateDescription();
        System.out.println();
        taskService.getAllByDate(LocalDate.of(2024,3,9)).
                stream().
                forEach(System.out::println);
        taskService.getRemovedTask();
    }
}