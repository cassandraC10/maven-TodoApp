package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.models.User;

import java.util.List;

public interface UserServices {
    public void addUser(String firstName, String lastName, String email, String password);

    User findById(String i);

    public void deleteUser(User user);

    List<User> findByName(String name);
}



