package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.models.User;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);

    void delete(Task task);

    void delete(int id);

    List<Task> findAll();

    Task findById(int id);
    ;
    int count();

    List<Task> findOnGoing();

    List<Task> done();
}
