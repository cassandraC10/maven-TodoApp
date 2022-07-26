package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.models.User;
import africa.semicolon.toDoApp.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(String firstName, String lastName, String email, String password) {
    User user = new User(firstName, lastName, email, password);
    userRepository.save(user);
}

    @Override
    public User findById(String id){
//        Optional<User> found = userRepository.findById(id);
//        if (found.isEmpty())throw new NullPointerException("User not found");
//        return found.get();
        return null;
    }
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findByName(String name) {
        List<User> result = new ArrayList<>();
        result.addAll(userRepository.findByFirstName(name));
        result.addAll(userRepository.findByLastName(name));
        return result;
    }
}

