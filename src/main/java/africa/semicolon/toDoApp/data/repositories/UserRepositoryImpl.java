package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements iUserRepository {
    private final List<User> users = new ArrayList<>();
//    private final ArrayList<Task> myTasks = new ArrayList<>();
    private int count;

    private iUserRepository userRepository;
    @Override
    public User save(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }
    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public void delete(int id) {
        int actualIndex = id - 1;
        User user = users.get(actualIndex);
        delete(user);
    }
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User add(Task user1) { return null; }

    @Override
    public User findById(int id) {
        for (var user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addTask(Task user) {

    }
    @Override
    public int count() {
        return users.size();
    }

    @Override
    public void deleteTask(User user1) { users.remove(user1); }

    @Override
    public User getTask(int index) { return users.get(index); }

    @Override
    public List<User> findByFirstName(String firstName) {
        List <User> usersWithSameFirstName = new ArrayList<>();
        for (User user : users) {
            if (user.getFirstName().equalsIgnoreCase(firstName)) {
                usersWithSameFirstName.add(user);
            }
        }
        return usersWithSameFirstName;
    }

    @Override
    public List<User> findByLastName(String lastName) {
        List <User> usersWithSameLastName = new ArrayList<>();
        for (User user : users) {
            if (user.getLastName().equalsIgnoreCase(lastName)) {
                usersWithSameLastName.add(user);
            }
        }
        return usersWithSameLastName;
    }
    @Override
    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
