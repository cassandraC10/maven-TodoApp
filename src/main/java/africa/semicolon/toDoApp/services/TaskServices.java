package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.models.User;

import java.util.List;

public interface TaskServices {
    public void addTask(String task, int date);
    public void deleteTask(User user);
    public void markAsDone(Task task);
    public void markAsDoing(Task task);
    Task findTask(); // i'm not sure.

    User findById(String i);

    List<User> findByName(String name);
}
