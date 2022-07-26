package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        task.setId(tasks.size() + 1);
        tasks.add(task);
        return task;
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
    public int count() {return tasks.size();}

    @Override
    public List<Task> findOnGoing() {

        return null;
    }

    @Override
    public List<Task> done(){

        return null;
    }
}

