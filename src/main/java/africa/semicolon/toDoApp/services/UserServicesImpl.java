package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.models.User;
import africa.semicolon.toDoApp.data.repositories.UserRepositoryImpl;
import africa.semicolon.toDoApp.data.repositories.iUserRepository;
import africa.semicolon.toDoApp.dtos.request.LoginRequest;
import africa.semicolon.toDoApp.dtos.request.RegisterRequest;
import africa.semicolon.toDoApp.dtos.responses.LoginResponse;
import africa.semicolon.toDoApp.dtos.responses.RegisterResponse;
import africa.semicolon.toDoApp.exceptions.DuplicateUserException;
import africa.semicolon.toDoApp.utils.Mapper;

import java.util.List;

public class UserServicesImpl implements UserServices {
    iUserRepository userRepository;

    public UserServicesImpl(iUserRepository userRepository) {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public RegisterResponse registerUser(RegisterRequest request) {
        User savedUser = userRepository.findByEmail(request.getEmail());
        if (savedUser != null) throw new DuplicateUserException(String.format("%s already exists", request.getEmail()));
        User user = new User();
        Mapper.map(request, user);
        User saved = userRepository.save(user);
        RegisterResponse registerResponse = new RegisterResponse();
        Mapper.map(saved, registerResponse);
        return registerResponse;
    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {
        User user = new User();
        Mapper.map(request, user);
        User saved = userRepository.save(user);
        LoginResponse loginResponse = new LoginResponse();
        Mapper.map(saved, loginResponse);
        return loginResponse;
    }

    @Override
    public Task findTask(String task) {
        return null;//TODO do this with task service / repository;
    }

//    public User getTask(int index) { return users.get(index); }


//    @Override
//    public RegisterResponse register(RegisterRequest request) {
//        return null;
//    }
//    @Override
//    public List<Task> findTask(String task) {
//        return null;
//    }
//;
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public void addUser(String firstName, String lastName, String email, String password) {
//    User user = new User(firstName, lastName, email, password);
//    userRepository.save(user);
//}
//
//    @Override
//    public User findById(String id){
////        Optional<User> found = userRepository.findById(id);
////        if (found.isEmpty())throw new NullPointerException("User not found");
////        return found.get();
//        return null;
//    }
//    @Override
//    public void deleteUser(User user) {
//        userRepository.delete(user);
//    }
//
//    @Override
//    public List<User> findByName(String name) {
//        List<User> result = new ArrayList<>();
//        result.addAll(userRepository.findByFirstName(name));
//        result.addAll(userRepository.findByLastName(name));
//        return result;
//    }

}


