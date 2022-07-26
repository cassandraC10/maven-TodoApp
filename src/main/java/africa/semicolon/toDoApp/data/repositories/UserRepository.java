package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    void delete(User user);
    void delete(int id);
    List<User> findAll();
//    Optional<User> findById(String id);
    User findById(int id);

    int count();

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    User findByEmail(String email);

}
