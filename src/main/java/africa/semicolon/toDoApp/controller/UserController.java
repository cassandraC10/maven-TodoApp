package africa.semicolon.toDoApp.controller;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.repositories.UserRepositoryImpl;
import africa.semicolon.toDoApp.dtos.request.AddTaskRequest;
import africa.semicolon.toDoApp.dtos.request.LoginRequest;
import africa.semicolon.toDoApp.dtos.request.RegisterRequest;
import africa.semicolon.toDoApp.dtos.responses.LoginResponse;
import africa.semicolon.toDoApp.dtos.responses.RegisterResponse;
import africa.semicolon.toDoApp.services.UserServices;
import africa.semicolon.toDoApp.services.UserServicesImpl;

import java.util.List;


public class UserController {
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private final UserServices userServices = new UserServicesImpl(userRepository);
//    private final UserServices userServices = new UserServices() {
//        @Override
//        public RegisterResponse registerUser(RegisterRequest request) {return userServices.registerUser(request);}
//
//        @Override
//        public LoginResponse loginUser(LoginRequest request) { return userServices.loginUser(request); }
//
//        @Override
//        public List<Task> findTask(String task) {
//            return userServices.findTask(task);
//        }
////
////        @Override
////        public RegisterResponse register(RegisterRequest request) {
////            return userServices.register(request);
////        }
//
////        public List<User> findUserBelongingTo(String email) {return userServices.findUserBelongingTo(email); }
//    };

    public Task findTask(String taskId) {
        return (Task) userServices.findTask(taskId);
        }

        public RegisterResponse registerUser (RegisterRequest request){
            return userServices.registerUser(request);
        }

        public void addTask (AddTaskRequest taskRequest){
        }
//    public RegisterUserResponse registerUser(RegisterRequest request){
//        return userService.register(request);
//    }

//    public void findTask(String enter_your_email) {
//    }
////    public List<Task> findTask(String task){
//        return userServices.findTask(task);
//    }
//
//}


    }