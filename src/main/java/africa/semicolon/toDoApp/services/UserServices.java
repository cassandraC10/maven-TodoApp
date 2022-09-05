package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.dtos.request.LoginRequest;
import africa.semicolon.toDoApp.dtos.request.RegisterRequest;
import africa.semicolon.toDoApp.dtos.responses.LoginResponse;
import africa.semicolon.toDoApp.dtos.responses.RegisterResponse;

public interface UserServices {
    public RegisterResponse registerUser(RegisterRequest request);
    LoginResponse loginUser(LoginRequest request);

    Task findTask(String task);




}



