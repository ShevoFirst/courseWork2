package tasks;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private Map<Integer,Task> taskMap = new HashMap<>();
    private Collection<Task> removedTask = new ArrayList<>();

    public Collection<Task> getRemovedTask() {
        removedTask.stream().forEach(System.out::println);
        return removedTask;
    }

    public void add(Task task){
        taskMap.put(task.getId(),task);
    }
    public void delete(int id){
        removedTask.add(taskMap.get(id));
        taskMap.remove(id);
    }
    public void updateDescription(){
        System.out.print("введите id задачи описание которого вы хотите измениить: ");
        int id = new Scanner(System.in).nextInt();
        if (taskMap.get(id) == null)
            throw new TaskNotFoundException("таблица по этому id не найдена");

        System.out.print("Введите новое описание: ");
        taskMap.get(id).setDescription(new Scanner(System.in).nextLine());
        System.out.println("описание успешно изменено \n");
        System.out.println();
    }
    public Collection<Task> getAllByDate(LocalDate time){
        Collection<Task> tasks = new ArrayList<>();

        for (Task value : taskMap.values()) {
            if (value.appearsln(time.atStartOfDay()))
                tasks.add(value);
        }

        if (tasks.isEmpty())
            throw new TaskNotFoundException("таблица на этот день не найдена");

        return tasks;
    }

    public class TaskNotFoundException extends RuntimeException{

        public TaskNotFoundException() {super();}

        public TaskNotFoundException(String message) {
            super(message);
        }
    }
}
