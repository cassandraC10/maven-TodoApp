package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.models.User;

import java.util.List;

public interface iUserRepository {
    void addTask(Task user);
    int count();
    void deleteTask(User user1);
    User getTask(int index);
    List<User> findAll();
    User add(Task user1);
    User save(User user);
    void delete(int id);







    void delete(User user);
    User findById(int id);


    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    User findByEmail(String email);

}
