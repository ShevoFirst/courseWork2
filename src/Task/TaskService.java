package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        for (int i = 0; i < taskMap.size(); i++) {
            if (taskMap.get(i).getDateTime().toLocalDate().isBefore(time)){
                tasks.add(taskMap.get(i));
            }
        }
        if (tasks.isEmpty())
            throw new IllegalArgumentException("таблица на этот день не найдена");
        return tasks;
    }
}
