package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.dtos.request.AddTaskRequest;
import africa.semicolon.toDoApp.dtos.responses.AddTaskResponse;

import java.util.List;

public interface TaskServices {

    AddTaskResponse addTask(AddTaskRequest taskRequest);

//    public UpdateTaskResponse
}
