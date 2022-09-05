package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.Status;
import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.models.User;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    void deleteTask(Task task1);
    void delete(int id);
    Task findById(int id);
    List<Task> findAll();
    int count();
    void delete(Task task);

    Task findByTask(String task);
//    List<Task> findByTask(String task);



    Task findByCreationDate(LocalDateTime creationDate);

    Task findByDueDate(LocalDateTime dueDate);
    List<Task> findByCurrentStatus(Status currentStatus);
}
