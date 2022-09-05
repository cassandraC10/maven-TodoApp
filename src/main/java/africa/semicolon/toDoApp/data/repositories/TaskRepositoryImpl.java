package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.Status;
import africa.semicolon.toDoApp.data.models.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        task.setId(tasks.size() + 1);
        tasks.add(task);
        return task;
    }

    @Override
    public void deleteTask(Task task1) {

    }

    @Override
    public void delete(Task task) {tasks.remove(task);}

    @Override
    public void delete(int id) {
        int actualTask = id - 1;
        Task task = tasks.get(actualTask);
        delete(task);
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Task findById(int id) {
        for (var task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }return null;
    }
    @Override
    public Task findByTask(String Task) {
        for (Task task : tasks) {
            if (task.getTask().equalsIgnoreCase(Task)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public Task findByCreationDate(LocalDateTime creationDate){
        List<Task> createDateForTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getCreationDate() == creationDate){
                createDateForTasks.add(task);
            }
        }
        return (Task) createDateForTasks;
    }

    @Override
    public Task findByDueDate(LocalDateTime dueDate) {
        List <Task> dueTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDueDate() == dueDate){
                dueTasks.add(task);
            }
        }
        return (Task) dueTasks;
    }

    @Override
    public List<Task> findByCurrentStatus(Status currentStatus) {
        for (Task task : tasks) {
            if (task.getCurrentStatus() == currentStatus) {
                return (List<Task>) task;
            }
        }
        return null;
    }

    @Override
    public int count() {return tasks.size();}

}

