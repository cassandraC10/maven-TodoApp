package africa.semicolon.toDoApp.utils;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.models.User;
import africa.semicolon.toDoApp.dtos.request.AddTaskRequest;
import africa.semicolon.toDoApp.dtos.request.LoginRequest;
import africa.semicolon.toDoApp.dtos.request.RegisterRequest;
import africa.semicolon.toDoApp.dtos.responses.AddTaskResponse;
import africa.semicolon.toDoApp.dtos.responses.LoginResponse;
import africa.semicolon.toDoApp.dtos.responses.RegisterResponse;

public class Mapper {
    public static void map(RegisterRequest request, User user) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
    }

    public static void map(User saved, RegisterResponse registerResponse) {
        registerResponse.setFullName(saved.getFirstName()+ " "+ saved.getLastName());
        registerResponse.setEmail(saved.getEmail());
        registerResponse.setId(saved.getId()+"");
    }

    public static void map(LoginRequest request, User user) {
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
    }

    public static void map(User saved, LoginResponse loginResponse) {
        loginResponse.setEmail(saved.getEmail());
        loginResponse.setId(saved.getId()+"");
    }


    public static void map(Task saved, AddTaskResponse addTaskResponse) {
        addTaskResponse.setTask(saved.getTask());
    }

    public static void map(AddTaskRequest taskRequest, Task task) {
        task.setTask(taskRequest.getTask());

    }
}
