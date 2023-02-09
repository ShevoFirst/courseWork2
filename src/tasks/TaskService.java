package tasks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<Integer,Task> taskMap = new HashMap<>();
    private Collection<Task> removedTask = new ArrayList<>();

    public void add(Task task){
        taskMap.put(task.getId(),task);
    }
    public void delete(int id){
        removedTask.add(taskMap.get(id));
        taskMap.remove(id);
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
