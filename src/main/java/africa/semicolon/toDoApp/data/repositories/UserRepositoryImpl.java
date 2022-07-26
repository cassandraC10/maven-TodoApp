package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();
    private UserRepository userRepository;
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
    public User findById(int id) {
        for (var user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

//    public Optional<User> findById(String id) {
//        for (var user : users) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;
    @Override
    public int count() {
        return users.size();
    }

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
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
