package tasks;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    static private Map<Integer,Task> taskMap = new HashMap<>();
    static private Collection<Task> removedTask = new ArrayList<>();

    public static void start() {
        while (true) {
            System.out.print("введите функцию что хотите осуществить(\n" +
                    "1 - добавить задачу,\n" +
                    "2 - получить задачи на день,\n" +
                    "3 - удалить задачу по id,\n" +
                    "4 - обновить описание задачи по id,\n" +
                    "5 - получить список удаленных задач) : ");
            switch (new Scanner(System.in).nextInt()) {
                case (1):
                    add(createTask());
                    break;
                case (2):
                    getAllByDate();
                    break;
                case (3):
                    delete();
                    break;
                case (4):
                    updateDescription();
                    break;
                case (5):
                    getRemovedTask();
                    break;
                default:
                    throw new IncorrectArgumentException("Повторяемость отсутвует под этим номером");
            }
        }
    }
    static private void getRemovedTask() {
        removedTask.forEach(System.out::println);
    }

    static private void add(Task task){
        taskMap.put(task.getId(),task);
    }
    static private void delete(){
        System.out.print("введите id задачи которую хотите удалить: ");
        int id = new Scanner(System.in).nextInt();
        if (taskMap.get(id) == null)
            throw new TaskNotFoundException("таблица по этому id не найдена");

        removedTask.add(taskMap.get(id));
        taskMap.remove(id);
        System.out.println("Таблица успешно удалена");
    }

    static private void updateDescription(){
        System.out.print("введите id задачи описание которого вы хотите измениить: ");
        int id = new Scanner(System.in).nextInt();
        if (taskMap.get(id) == null)
            throw new TaskNotFoundException("таблица по этому id не найдена");

        System.out.print("Введите новое описание: ");
        taskMap.get(id).setDescription(new Scanner(System.in).nextLine());
        System.out.println("описание успешно изменено \n");
        System.out.println();
    }
    static private void getAllByDate(){
        Collection<Task> tasks = new ArrayList<>();

        System.out.println("введите год");
        int year = new Scanner(System.in).nextInt();
        System.out.println("введите месяц");
        int month = new Scanner(System.in).nextInt();
        System.out.println("введите день месяца");
        int dayofmonth = new Scanner(System.in).nextInt();

        LocalDate time = LocalDate.of(year,month,dayofmonth);

        for (Task value : taskMap.values()) {
            if (value.appearsln(time.atStartOfDay()))
                tasks.add(value);
        }

        if (tasks.isEmpty())
            throw new TaskNotFoundException("таблица на этот день не найдена");
        tasks.forEach(System.out::println);

    }
    static private   Task createTask(){
        System.out.print("введите заголовок для вашей задачи(обязательно): ");
        String title = new Scanner(System.in).nextLine();
        System.out.print("введите тип вашей задачи(Рабочая - 1, Персональная - 2): ");
        int type = new Scanner(System.in).nextInt();
        System.out.print("введите описание задачи(по желанию): ");
        String descriprion = new Scanner(System.in).nextLine();
        System.out.print("введите повторяемость вашей задачи(" +
                "1 однократная,\n" +
                "2 - ежедневная,\n" +
                "3 - еженедельная,\n" +
                "4 - ежемесячная,\n" +
                "5 - ежегодная.): ");
        switch (new Scanner(System.in).nextInt()){
            case (1):
                return new OneTimeTask(type,title,descriprion);
            case (2):
                return new DailyTask(type,title,descriprion);
            case (3):
                return new WeeklyTask(type,title,descriprion);
            case (4):
                return new MonthlyTask(type,title,descriprion);
            case (5):
                return new YearlyTask(type,title,descriprion);
            default:
                throw new IncorrectArgumentException("Повторяемость отсутвует под этим номером");
        }
    }
}
